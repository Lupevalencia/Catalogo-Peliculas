//EXCEPCIONES
package mx.com.gm.peliculas.excepciones;

//Si ponemos RunTimeException no nos mostrarĂ¡ errores
public class AccesoDatosEx extends Exception {
    public AccesoDatosEx(String mensaje){
        super(mensaje);
    }
    
}
