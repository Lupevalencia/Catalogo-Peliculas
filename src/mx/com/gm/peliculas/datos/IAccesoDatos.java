//INTERFACES. DEFINIMOS EL COMPORTAMIENTO. SÓLO CONTIENE LOS METODOS

package mx.com.gm.peliculas.datos;

//NO IMPLEMENTAN LOS MÉTODO SOLO DEFINEN LO QUE LAS CLASES DEBEN IMPLEMENTAR

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;


public interface IAccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx; //Personalizando las secciones
    
    //Conceptos de colecciones
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx; //regresa una lista de la clase tipo pelicula
    
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    
    void crear(String nombreRecurso) throws AccesoDatosEx;
    
    void borrar(String nombreRecurso)throws AccesoDatosEx;
    
}
