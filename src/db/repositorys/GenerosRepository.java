package db.repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterface;
import models.Genero;

public class GenerosRepository implements RepositoryInterface<Genero>{

    @Override
    public Genero recuperarId(Long id) {
        // try - resources
        // para que la conexion se cierre al terminar el try
        try(Connection conexion = ConexionDB.obtenerConexion()) {
            // creo la consulta o query 
            String q = "SELECT * FROM generos WHERE id = ? ";
            try(
                PreparedStatement preparedStatement = conexion.prepareStatement(q);
                ) {
                // inserta el id en el primer ? que encuentre, en la consulta 
                preparedStatement.setLong(1,id);
                return dameEntidadResultSet(preparedStatement.executeQuery());
            } catch (Exception e) {
                System.out.println("Error al crear el Statement o ResultSet");
            }
        } catch (Exception e) {
            System.out.println("error en la consulta");
        }
        return null;
    }

    @Override
    public List<Genero> recuperarTodos() {
        try(Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "SELECT * FROM generos";
            try(
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery(q)
                ) {
                return this.dameListaGeneros(resultSet);
            } catch (Exception e) {
                System.out.println("Error al crear el Statement o ResultSet");
            }
        } catch (Exception e) {
            System.out.println("error en la consulta");
        }
        return null;
    }

    @Override
    public void agregar(Genero entidad) {
        try(Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "INSERT INTO generos VALUES(null,?)";
            try(
                PreparedStatement preparedStatement = conexion.prepareStatement(q);
                ) {
                    preparedStatement.setString(1,entidad.getNombre());
                    preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error al crear el Statement o ResultSet");
            }
        } catch (Exception e) {
            System.out.println("error en la consulta");
        }
    }

    @Override
    public void modificar(Genero entidad) {
        try(Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "UPDATE generos SET nombre = ? WHERE id = ?";
            try(
                PreparedStatement preparedStatement = conexion.prepareStatement(q);
                ) {
                    preparedStatement.setString(1,entidad.getNombre());
                    preparedStatement.setString(2,""+entidad.getId());
                    preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error al crear el Statement o ResultSet");
            }
        } catch (Exception e) {
            System.out.println("error en la consulta");
        }
    }

    @Override
    public void eliminar(Genero entidad) {
        try(Connection conexion = ConexionDB.obtenerConexion()) {
            String q = "DELETE FROM generos WHERE id = ?";
            try(
                PreparedStatement preparedStatement = conexion.prepareStatement(q);
                ) {
                    preparedStatement.setString(1,""+entidad.getId());
                    preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error al crear el Statement o ResultSet");
            }
        } catch (Exception e) {
            System.out.println("error en la consulta");
        }
    }

    private List<Genero> dameListaGeneros(ResultSet resultSet){
        List<Genero> generos = new ArrayList<Genero>();
        try(resultSet){
            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String nombre = resultSet.getString("nombre");
                generos.add(new Genero(id, nombre));
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar generos");
        }
        return generos;
    }

    private Genero dameEntidadResultSet(ResultSet resultSet){
        Long id=0L;
        String nombre="";
        try {
            // si existe el id regresa la fila como un Genero
            while(resultSet.next()){
                id = resultSet.getLong("id");
                nombre = resultSet.getString("nombre");
            }
            return new Genero(id, nombre);
        } catch (Exception e) {
            System.out.println("Error al recuperar resultSet");
        }
        return null;
    }
    
}
