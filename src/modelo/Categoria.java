package modelo;

/**
 *
 * @author Gemi
 */
public class Categoria {
    
    private int id_categoria;
    private String descripcion;
    private int estado;
    
    public Categoria(){
        this.id_categoria = 0;
        this.descripcion = "";
        this.estado = 0;
    }

    public Categoria(int idCategoria, String descripcion, int estado) {
        this.id_categoria = idCategoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.id_categoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
     
    
}
