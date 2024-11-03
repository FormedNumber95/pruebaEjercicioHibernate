package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.ModeloContenido;
import model.ModeloUsuario;

public class DaoUsuario {
	
	public static void insertar(ModeloUsuario usuario, Session session) {
		 Transaction transaction = null;
		 transaction=session.beginTransaction();
		 session.persist(usuario);
		 transaction.commit();
	}
	
	public static List<ModeloUsuario> listaTodos(Session session){
		String hql="FROM Usuario";
		Query<ModeloUsuario> query=session.createQuery(hql,ModeloUsuario.class);
		return query.getResultList();
	}
	
	public static ModeloUsuario conseguirPorEmail(String email,Session session) {
		 String hql = "FROM Usuario WHERE email = :email";
		 Query<ModeloUsuario>query=session.createQuery(hql,ModeloUsuario.class);
		 query.setParameter("email",email);
		 return query.uniqueResult();
	}
	
	public static void aniadirContenido(ModeloContenido contenido, ModeloUsuario usuario,Session session) {
		Transaction transaction=session.beginTransaction();
		usuario.aniadirContenido(contenido);
		session.merge(usuario);
		transaction.commit();
	}
	
}
