<%@page import="java.util.List"%>
<%@page import="pe.edu.ulima.michifrontend.beans.Partida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
List<Partida> partidas = (List<Partida>)request.getAttribute("partidas");
String usuario = request.getAttribute("usuario").toString();
%>
<html>
    <head>
        <title>Michi Game</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous">
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" 
              crossorigin="anonymous">
        <link rel="stylesheet"
              href="css/font-awesome/css/font-awesome.min.css">
    </head>
    <body class="container">
        <h1>Michi Game</h1>
        <span id="sp_nombre_usuario"></span>
        <div class="row">
            <div class="col-md-6">
                <h3>
                    Partidas
                </h3>
                <p>
                    <button id="but_nueva_partida" class="btn btn-success"
                            >Nueva
                    </button>
                </p>
                <div class="list-group">
                    <%
                    for (Partida partida : partidas){
                        String oponente = "";
                        if (partida.getJugador1().equals(usuario)){
                            oponente = partida.getJugador2();
                        }else{
                            oponente = partida.getJugador1();
                        }
                        String resultado = "fa-frown-o";
                        if (partida.getResultado() == null 
                                || partida.getResultado().equals("")){
                            resultado = "fa-meh-o";
                        }else if (usuario.equals(partida.getResultado())){
                            resultado = "fa-smile-o";
                        }
                        
                        %>
                        <a href="#" class="list-group-item">
                            vs <%= oponente %>
                            <i class="fa <%= resultado %>" aria-hidden="true"></i>
                        </a>
                    <%
                    }
                    %>
                </div>
            </div>
            <div class="col-md-6">
                <h3>
                    Partidas que se encuentran desarrollándose
                </h3>
                <div class="list-group">
                    <a href="#" class="list-group-item">
                        Jsatch vs Juanita
                        <span class="glyphicon glyphicon-arrow-down" 
                              aria-hidden="true"></span>
                    </a>
                    <a href="#" class="list-group-item">
                        Luisito vs Pepito
                        <span class="glyphicon glyphicon-arrow-down" 
                              aria-hidden="true"></span>
                    </a>

                </div>
            </div>
        </div>
        <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    </body>
</html>
