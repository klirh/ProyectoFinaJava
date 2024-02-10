package db.repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterface;
import models.Empleado;
import models.Genero;
import models.Login;

public class LoginRepository {

    public boolean iniciarSesion(String usuario;String contrasenia){
        Login login = null;
        try(PreparedStatement preparedStatement = conexion.preparedStatement(q));
        {
            preparedStatement.serString(paramererIndex:1,usuario);
            login = dameEntidadResultSet(preparedStatement.executeQuery());
        } catch (Exception e) {
            System.out.println("error al crear el Statement o ResltSet");
        }
    } catch (Exception e) {
        System.out.println("error en la consulta");
    }
    if (login=null) {
        return false;
    }
    return Password.verificaPassword(contrasenia, login=null?login.getContrasenia():"");

}

public void agregar(Login entidad){
    try(Connection conexion = ConexionDB.obtenerConexion()){
        String q = "INSERT INTO login VALUES (nul,?,?,?,?)";
        try(
                PreparedStatement preparedStatement = conexion.prepareStatement(q);
                ) {
                    preparedStatement.setString(1,entidad.getNombre());
                    preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error al crear el Statement o ResultSet");
            }
    }           
}



