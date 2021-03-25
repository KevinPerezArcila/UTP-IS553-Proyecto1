
package Contacto;


public class Contactos {
    //ATRIBUTOS
    private String nombre;
    private String telefonos;
    private String correo;
    private String direccion;
    private String alias;
    
    //CONSTRUCTOR

    public Contactos(String nombre, String telefonos, String correo, String direccion, String alias) {
        this.nombre = nombre;
        this.telefonos = telefonos;
        this.correo = correo;
        this.direccion = direccion;
        this.alias = alias;
    }
    
        public Contactos() {
        
    }
        
        //VALIDACION DE DATOS REPETIDOS
        public boolean equals(Contactos op){
            if (this.telefonos.equals(op.telefonos))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", telefonos=" + telefonos + ", correo=" + correo + ", direccion=" + direccion + ", alias=" + alias;
    }
    
    
}
