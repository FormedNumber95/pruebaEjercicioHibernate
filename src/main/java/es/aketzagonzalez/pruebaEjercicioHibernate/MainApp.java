package es.aketzagonzalez.pruebaEjercicioHibernate;

import java.util.List;

import org.hibernate.Session;

import dao.DaoContenido;
import dao.DaoCuentaCreadora;
import dao.DaoUsuario;
import model.ModeloContenido;
import model.ModeloCuentaCreadora;
import model.ModeloUsuario;

public class MainApp{
	
    private static double validateDouble(String value) {
        if (value.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(value);
    }

    private static String validateString(String value) {
        if (value.isEmpty()) {
            return "N/A";
        }
        return value.strip();
    }
    
    
    
    public static void selectAll() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	List<ModeloUsuario>lstUsuarios=DaoUsuario.listaTodos(session);
    	for(ModeloUsuario usu:lstUsuarios) {
    		 System.out.println(usu.getNombre());
    		 System.out.println("Cuentas:");
    		 for(ModeloCuentaCreadora creadora:DaoCuentaCreadora.obtenerPorUsuario(usu, session)) {
    			 System.out.println("\t"+creadora.getCuenta());
    		 }
    		 System.out.println("Contenidos:");
    		 for(ModeloContenido contenido:DaoContenido.obtenerPorUsuario(usu, session)) {
    			 System.out.println("\t"+contenido.getNombre());
    		 }
    	}
    }
	
    public static void main(String[] args) {
    	selectAll();
    }

}
