
package pe.edu.ulima.michifrontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.michifrontend.beans.Partida;
import pe.edu.ulima.michifrontend.dao.PartidaDAO;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String usuario = req.getParameter("usuario");
        
        PartidaDAO partidaDAO = new PartidaDAO();
        List<Partida> partidas = new ArrayList<>();
        try {
            partidas = partidaDAO.obtener(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
        req.setAttribute("partidas", partidas);
        req.setAttribute("usuario", usuario);
        
        rd.forward(req, resp);
        
    }
    
    
}
