
import java.util.List;

import db.repositorys.GenerosRepository;
import models.Genero;

public class App {
    public static void main(String[] args) throws Exception {
       
       //generar un genero y recuperar
       // el repsoditorio se encarga de recuperar cosas
        GenerosRepository generosRepository = new GenerosRepository();
        Genero generosDB = generosRepository.recuperarId(1L);
        System.out.println(generosDB.getNombre());

        

       //Si quiero agregar Le mando la entidad que quiero agregar
       // GenerosRepository generosRepository = new GenerosRepository();
      // Genero genero = new Genero(null, "no binario");
       //generosRepository.agregar(genero);
       //List<Genero> generos = generosRepository.recuperarTodos();
       //for (Genero generoL : generos) {
        //System.out.println(generoL.getNombre());
       

     }  
    }

       
      
        
    //System.out.println("Hello, World!");
    //ConexionDB.obtenerConexion();

    
