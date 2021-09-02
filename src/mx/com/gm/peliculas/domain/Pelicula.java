//CLASE PELICULA O CLASE IDENTIDAD. CLASES DE DOMINIO
package mx.com.gm.peliculas.domain;


public class Pelicula {
    //Definimos los atributos
    String nombre;
    
    //constructor vacío
    public Pelicula(){
    
    }
    //Constructor para inicializar atributos
    public Pelicula(String nombre){
        this.nombre = nombre;
    }
    //métodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //método toString
    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
