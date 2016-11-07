
package pe.edu.ulima.michifrontend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.ulima.michifrontend.beans.Partida;

public class PartidaDAO {
    private Connection mConnection;
    
    public void setConnection(Connection conn){
        mConnection = conn;
    }
    public Connection getConnection(){
        return mConnection;
    }
    public void abrirConexion() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        mConnection = DriverManager.getConnection(
                Configuracion.URL_BD, 
                Configuracion.USER_BD, 
                Configuracion.PWD_BD);
        
    }
    public List<Partida> obtener(String usuario) throws SQLException{
        if (mConnection == null){
            abrirConexion();
        }
        List<Partida> partidas = new ArrayList<>();
        String sql = "SELECT * FROM partida WHERE jugador1=?";
        listarPartidas(partidas, sql, usuario);
        sql = "SELECT * FROM partida WHERE jugador2=?";
        listarPartidas(partidas, sql, usuario);
        
        return partidas;
    }
    
    private void listarPartidas(List<Partida> partidas, 
             String sql, 
             String usuario) throws SQLException{
        PreparedStatement ps = mConnection.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Partida partida = new Partida(
                    rs.getInt("id"),
                    rs.getString("jugador1"),
                    rs.getString("jugador2"),
                    rs.getString("resultado")
            );
            partidas.add(partida);
        }
    }
}
