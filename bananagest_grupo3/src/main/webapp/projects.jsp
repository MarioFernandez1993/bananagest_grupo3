<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="saveProject" class="com.generation.jwd.p1.beans.Project" scope="request"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Crear Proyecto | Banana GEST</title>
            <link rel="stylesheet" type="text/css" href="css/projects.css">
        </head>
        <body>
        <header>
            <div class="head"><img src="images/profile.png" width="55" height="55"><h3>Bienvenido/a (User)</h3>
            <a href="#">Editar perfil</a></div>
            <div class="head"><h1>Banana GEST</h1><a href="homeuser.jsp"><img src="images/bananas_medio.png"/></a></div>
            <div class="head"><h4><a href="login.jsp">Logout</a></h4></div>
        </header>
            <h2>Crear nuevo proyecto</h2>
               <hr>
        <main>
            <form method="post" action="createproyect" id = "proyect.id">
                <p>
                    <table id="newproject">
                        <tr class="contenttable">
                            <th class="namecontent">
                                Nombre
                            </th>
                            <th class="contenttable">
                                <input style="background-color:#F5BFB2;" type="text" placeholder="Nombre del proyecto" required="true"
                                name="project.id" autofocus/>
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Descripción
                            </th>
                            <th class="contenttable">
                                <textarea name="project.description" required="true" rows="15" cols="60"
                                 ></textarea>
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Fecha de inicio
                            </th>
                            <th class="contenttable">
                                <input id="projectform" type="date" name="projects.date_start" required="true"/> 
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Fecha de fin
                            </th>
                            <th class="contenttable">
                                <input id="projectform" type="date" name="projects.date_end" required="true"/> 
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Usuario asignado
                            </th>
                            <th class="contenttable">
                                <select  class="selectionbuton" name="project.id_user" required="true">
                                    <option>- Asignar a -</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                </select>
                            </th>
                        </tr> 
                    </table>
                </p>
                <div id="boton">
                    <button onclick = "validar()" style="width:200px; height:50px;">Crear Proyecto</button>
                    <button onclick = "cancelar()" name="cancel_proyect" value="Cancelar Proyecto" style="width:200px; height:50px;">Cancelar Proyecto</button>
                </div>
            </form>
        </body>
        <footer>
            <span>Banana GEST - Todos los derechos reservados</span>
        </footer>
</html>