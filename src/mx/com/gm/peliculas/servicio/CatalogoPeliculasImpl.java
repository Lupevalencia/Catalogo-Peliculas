//IMPLEMENTACION DE LA INTERFACE CATALOGO PELICULAS
package mx.com.gm.peliculas.servicio;

import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;


public class CatalogoPeliculasImpl implements ICatalogoPeliculas {
    private final IAccesoDatos datos; //atributo de la clase

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
    
    
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
          var peliculas = this.datos.listar(NOMBRE_RECURSO);
          for (var pelicula: peliculas) {
              System.out.println("pelicula = " + pelicula);
          }
       } catch (AccesoDatosEx ex) { //La excepción AccesoDatos es más genérica que LecturaAccesoDatos
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace();
        }
        System.out.println("resultado = " + resultado);

    }

    @Override
    public void iniciarCatalogoPeliculas() {
            try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }
            else{
                 datos.crear(NOMBRE_RECURSO);   
            }
            } catch (AccesoDatosEx ex) {
                   
               System.out.println("Error al iniciar Catalogo de Peliculas");
             ex.printStackTrace();
            }
    }

   
}
