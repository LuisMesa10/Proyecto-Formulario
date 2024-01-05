
package proyecto_formulario;


public class Persona {
    private String Nombre;
    private String Apellido;
    private String Numero_Documento;
    private String Telefono;
    private String Tipo_Documento;
    private String Lugar_Residencia;
    private String Nacionalidad;
    private String Correo;

    public Persona(String Nombre, String Apellido, String Numero_Documento, String Telefono, String Tipo_Documento, String Lugar_Residencia, String Nacionalidad, String Correo) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Numero_Documento = Numero_Documento;
        this.Telefono = Telefono;
        this.Tipo_Documento = Tipo_Documento;
        this.Lugar_Residencia = Lugar_Residencia;
        this.Nacionalidad = Nacionalidad;
        this.Correo = Correo;
    }

    public Persona() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNumero_Documento() {
        return Numero_Documento;
    }

    public void setNumero_Documento(String Numero_Documento) {
        this.Numero_Documento = Numero_Documento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTipo_Documento() {
        return Tipo_Documento;
    }

    public void setTipo_Documento(String Tipo_Documento) {
        this.Tipo_Documento = Tipo_Documento;
    }

    public String getLugar_Residencia() {
        return Lugar_Residencia;
    }

    public void setLugar_Residencia(String Lugar_Residencia) {
        this.Lugar_Residencia = Lugar_Residencia;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
}
