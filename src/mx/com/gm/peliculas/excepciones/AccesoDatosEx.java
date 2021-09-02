//EXCEPCIONES
package mx.com.gm.peliculas.excepciones;

//Si ponemos RunTimeException no nos mostrará errores
public class AccesoDatosEx extends Exception {
    public AccesoDatosEx(String mensaje){
        super(mensaje);
    }
    
}
