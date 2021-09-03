//IMPLEMENTAMOS TODOS LOS MÉTODOS DEFINIFOS EN LA INTERFACE
package mx.com.gm.peliculas.datos;
import java.io.File;
import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
//import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
//import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
//import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.excepciones.*;


public class AccesoDatosImpl implements IAccesoDatos {
//Para hacer esto nos salía directamente a la izquierda para hacer click
    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        return archivo.exists(); //Cómo devuelve un booleano utilizamos directamente return
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>(); //Es "peliculas" en plural pq se trata de una coleccion
        try { //hemos cambiado bufferedReader entrada por var entrada
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();      
            while(linea != null){
                //Creamos un objeto de nuestra clase y le pasamos la línea que estamos leyendo
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula); //añadimos un objeto de línea pelicula a la lista de peliculas
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
       var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString()); //necesitamos añadir toString para que se imprima nuestro objeto tipo pelicula
            //Y por tanto en nuestro archivo pelicula debemos borrar todo lo que mostramos y quedarnos sólo con el nombre
            salida.close();
            System.out.println("Se ha escrito información al archivo: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir peliculas: " + ex.getMessage());
        }
       
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado  = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1; //para inicializar y encontrar en qué línea se encuentra la pelicula que estamos buscando
            while (linea != null){
                if (buscar != null && buscar.equalsIgnoreCase(linea)) { 
                    resultado = "Pelicula" + " " + linea + " " + "encontrada en el índice\n " + " " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            
            }
        } catch (FileNotFoundException ex) {
           ex.printStackTrace(); //arrojamos la posible excepción
           throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
           ex.printStackTrace(); //arrojamos la posible excepción
           throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        }
        return resultado;
        
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
            
      } catch (FileNotFoundException ex) {
           ex.printStackTrace();
           throw new AccesoDatosEx("Excepcion al crear peliculas: " + ex.getMessage());
        } catch (IOException ex) {
           ex.printStackTrace();
           throw new AccesoDatosEx("Excepcion al crear peliculas: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
       var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
            
        }
    }
    
    
}
