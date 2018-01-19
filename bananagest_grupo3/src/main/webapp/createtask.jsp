<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="saveTask" class="com.generation.jwd.p1.beans.Task" scope="request"></jsp:useBean>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Crear tarea | Banana GEST</title>
        <link rel="stylesheet" type="text/css" href="css/createtask.css">
    </head>
    <body>
        <header>
            <div class="head"><img src="images/profile.png" width="55" height="55"><h3>Bienvenido/a (User)</h3>
            <a href="#">Editar perfil</a></div>
            <div class="head"><h1>Banana GEST</h1><a href="homeuser.jsp"><img src="images/bananas_medio.png"/></a></div>
            <div class="head"><h4><a href="login.jsp">Logout</a></h4></div>
        </header>
            <h2>Registro de nuevo proyecto</h2>
            <hr>
        <main>
            <form method="post" action="createproyect" id = "proyecttask">
                <p>
                    <table id="basic">
                        <tr class="contenttable">
                            <th class="namecontent">
                                Nombre
                            </th>
                            <th class="contenttable">
                                <input style="background-color:#F5BFB2;" type="text" placeholder="Nombre de la tarea" required="true"
                                name="name.id" autofocus/>
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Descripción
                            </th>
                            <th class="contenttable">
                                <textarea name="description" required="true" rows="15" cols="60"
                                 ></textarea>
                            </th>
                        </tr>
                         <tr>
                            <th class="namecontent">
                                Fecha de inicio
                            </th>
                            <th class="contenttable">
                                <input id="dateform" type="date" name="dateStart" required="true"/>               
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Estado
                            </th>
                            <th class="contenttable">
                                <select  class="selectionbuton" name="state" required="true">
                                    <option value="">- Elige una opción -</option>
                                    <option value="1">Terminada</option>
                                    <option value="2">En curso</option>
                                    <option value="3">Recibida</option>
                                </select>
                            </th>
                        </tr>
                        <tr>
                            <th class="namecontent">
                                Horas asignadas
                            </th>
                            <th class="contenttable">
                                 <select  class="selectionbuton" name="id_user" required="true">
                                    <option>- Horas -</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                </select>
                            </th>
                        </tr>
                        
                        <tr>
                            <th class="namecontent">
                                Usuario asignado
                            </th>
                            <th class="contenttable">
                                <select  class="selectionbuton" name="id_user" required="true">
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
                    <button onclick = "cancelar()" name="cancel_task" value="Cancelar tarea" style="width:200px; height:50px;">Cancelar Tarea</button>
                </div>
            </form>
        </main>
        <footer>
            <span>Banana GEST - Todos los derechos reservados</span>
        </footer>
        <script>
            function validar(){
                var inpObj = document.getElementById("formtask");
                if (inpObj.checkValidity() == false) {
                    alert("Task has not created")
                } else{ 
                    alert("Task has been created")
                }            
            }
        </script>
    </body>
    </html>