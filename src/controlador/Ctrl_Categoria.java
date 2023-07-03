package controlador;

import sistema_facturacion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Categoria;

/**
 *
 * @author Gemi
 */
public class Ctrl_Categoria {

    /**
     * **************************************************
     * metodo para guardar una nueva categoria
     * **************************************************
     */
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = sistema_facturacion.Conexion.conectaBD();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into categorias values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar categoria: " + e);
        }

        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si la categoria registrado ya existe
     * ********************************************************************
     */
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select descripcion from categorias where descripcion = '" + categoria + "';";
        Statement st;

        try {
            Connection cn = sistema_facturacion.Conexion.conectaBD();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar categoria: " + e);
        }
        return respuesta;
    }
    
     /**
     * **************************************************
     * metodo para actualizar una nueva categoria
     * **************************************************
     */
    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        Connection cn = sistema_facturacion.Conexion.conectaBD();
        try {

            PreparedStatement consulta = cn.prepareStatement("update categorias set descripcion=? where id_categoria ='" + idCategoria + "'");
            consulta.setString(1, objeto.getDescripcion());
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoria: " + e);
        }

        return respuesta;
    }
    
    
    /**
     * **************************************************
     * metodo para eliminar una nueva categoria
     * **************************************************
     */
    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        Connection cn = sistema_facturacion.Conexion.conectaBD();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "delete from categorias where id_Categoria ='" + idCategoria + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria: " + e);
        }

        return respuesta;
    }

}
