package dao;

import model.ModeloCuentaCreadora;
import model.ModeloUsuario;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DaoCuentaCreadora {
	
	public static void insertar(ModeloCuentaCreadora cuentaCreadora, Session session) {
		 Transaction transaction = null;
		 transaction=session.beginTransaction();
		 session.persist(cuentaCreadora);
		 transaction.commit();
	}
	
	public static ModeloCuentaCreadora obtenerPorNombre(String nombre, Session session) {
		 String hql="FROM CuentaCreadora WHERE cuenta = :cuenta";
		 Query<ModeloCuentaCreadora> query=session.createQuery(hql, ModeloCuentaCreadora.class);
		 query.setParameter("cuenta", nombre);
		 return query.uniqueResult();
	}
	
	public static List<ModeloCuentaCreadora> obtenerPorUsuario(ModeloUsuario usuario, Session session){
		String hql="FROM CuentaCreadora cc JOIN cc.contenidos c JOIN c.usuarios u WHERE cc.cuentaCreadora_id = c.cuentaCreadora_id AND u.usuario_id=:usuario_id";
		List<ModeloCuentaCreadora>lst=session.createSelectionQuery(hql,ModeloCuentaCreadora.class).setParameter("usuario_id",usuario.getUsuario_id()).getResultList();
		return lst;
	}
	
}
