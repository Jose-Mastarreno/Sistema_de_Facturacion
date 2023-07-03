
package sistema_facturacion;

/**
 *
 * @author Gemi
 */
import java.sql.*;
public class Conexion {
 
    public static Connection conectaBD(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_sistema_facturacion", "root", "12345678");
            return cn;
        }catch (SQLException e){
            System.out.println("Error de conexion de base de datos"+e.toString());
    }
        return null;
    }
 
    
    
        
}  
    



