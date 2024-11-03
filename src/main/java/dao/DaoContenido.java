package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.ModeloContenido;
import model.ModeloUsuario;

public class DaoContenido {

	public static void insertar(ModeloContenido contenido, Session session) {
		 Transaction transaction = null;
		 transaction=session.beginTransaction();
		 session.persist(contenido);
		 transaction.commit();
	}
	
	public static ModeloContenido obtenerPorNombre(String nombre,Session session) {
		String hql="FROM ModeloContenido WHERE nombre=:nombre";
		Query<ModeloContenido> query=session.createQuery(hql,ModeloContenido.class);
		query.setParameter("nombre",nombre);
		return query.uniqueResult();
	}
	
	public static List<ModeloContenido> obtenerPorUsuario(ModeloUsuario usuario,Session session){
		String hql="FROM ModeloContenido c JOIN c.usuarios u WHERE u.usuario_id=:usuario_id";
		List<ModeloContenido>lst=session.createSelectionQuery(hql,ModeloContenido.class).setParameter("usuario_id",usuario.getUsuario_id()).getResultList();
		return lst;
	}
	
	public static void aniadirUsuario(ModeloContenido contenido, ModeloUsuario usuario,Session session) {
		Transaction transaction=session.beginTransaction();
		contenido.aniadirUsuario(usuario);
		session.merge(contenido);
		transaction.commit();
	}
	
	public static void insertarRecomendacion(ModeloUsuario usuario, ModeloContenido contenido, Session session) {
		Transaction transaction = session.beginTransaction();
		usuario.aniadirContenido(contenido);
		contenido.aniadirUsuario(usuario);
		session.persist(contenido);
		transaction.commit();
	}
	
}
