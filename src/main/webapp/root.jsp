<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Root (Start-Seite)</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  	<div class="container">
  
	    <h1>Root (Start-Seite)</h1>
	
		Dies ist die Einstiegsseite der Anwendung. Folgende 2 Use Cases sind zu implementieren:
		<ul>
		<li>Ist der aktuelle Nutzer angemeldet, so wird ein redirect auf die Hauptseite durchgeführt.</li>
		<li>Ist der aktuelle Nutzer nicht angemeldet, so wird ein Login-Formular dargestellt und der Login durchgeführt. Anschließend findet ebenfalls ein Redirect auf die Hauptseite statt.</li>
		</ul>
		
		Seiten:
		<ul>
		<li><a href="main">main</a></li>
		<li><a href="detail">detail</a></li>
		</ul>
		
		
		<form role="form">
		  <div class="form-group">
		    <label for="user">User</label>
		    <input type="text" class="form-control" id="user" placeholder="Username">
		  </div>
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password" placeholder="Password">
		  </div>
		  <button type="submit" class="btn btn-default">Login</button>
		</form>		

    </div>
  </body>
</html>