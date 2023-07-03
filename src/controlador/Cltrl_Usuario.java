
package controlador;

/**
 *
 * @author Gemi
 */
import modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;
import sistema_facturacion.Conexion;
public class Cltrl_Usuario {
    /**
     * **************************************************
     * metodo para guardar un nuevo usuario
     * **************************************************
     */
    public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = sistema_facturacion.Conexion.conectaBD();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
        }
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si usuario ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "select usuario from usuarios where usuario = '" + usuario + "';";
        Statement st;
        try {
            Connection cn = sistema_facturacion.Conexion.conectaBD();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;
    }

    public boolean loginUser(Usuario objeto){
        
        boolean respuesta = false;
        Connection cn = Conexion.conectaBD();
        
        String sql ="select usuario, password from  usuarios where usuario='"+objeto.getUsuario()+"' and password = '"+objeto.getPassword()+"'";
        Statement st;
        try{
            st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                respuesta = true;
            }
        }catch (SQLException e){
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
        return respuesta;
    }
    /**
     * **************************************************
     * metodo para actualizar un cliente
     * **************************************************
     */
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Connection cn = sistema_facturacion.Conexion.conectaBD();
        try {

            PreparedStatement consulta = cn.prepareStatement("update usuarios set nombre=?, apellido = ?, usuario = ?, password= ?, telefono = ?, estado = ? where id_usuario ='" + idUsuario + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getUsuario());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para eliminar un cliente
     * **************************************************
     */
    public boolean eliminar(int idUsuario) {
        boolean respuesta = false;
        Connection cn = sistema_facturacion.Conexion.conectaBD();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from usuarios where id_usuario ='" + idUsuario + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
        return respuesta;
    }

}
