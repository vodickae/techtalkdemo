<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main (Hauptseite)</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  	<div class="container">
  	
	    <h1>Main (Hauptseite)</h1>
	
		Dies ist die Hauptseite der Anwendung f�r angemeldete Nutzer. Folgende Use Cases sind hier zu implementieren:
		<ul>
		<li>Eingabe-Formular zum erfassen einen neuen Stunden-Datensatzes.</li>
		<li>Tabelle mit der Auflistung aller Stunden-Datens�tze des Nutzers, sowie von anderen Nutzern freigegebener Datens�tze.</li>
		<li>Link zur Detailansicht pro Datensatz</li>
		<li>Suchformular, mit dem die Tabelle "gefiltert" werden kann.</li>
		</ul>
		
		<form class="form-inline" role="form" method="POST" action="/main">
		<legend>Suchen</legend>
		  <div class="form-group">
		    <input type="text" class="form-control" name="searchProjekt" id="searchProjekt" placeholder="Suche nach Projekt">
		  </div>
		  <div class="form-group">
		    <input type="text" class="form-control" name="searchComment" id="searchComment" placeholder="Suche nach Kommentar">
		  </div>
		  <button type="submit" class="btn btn-default">Suche starten</button>
		</form>		
		<br/><br/>
		<legend>Erfasste Stunden</legend>
		<table class="table table-striped">
		<thead><tr><th>ID</th><th>Projekt</th><th>Anzahl</th><th>Freigegeben</th><th>Kommentar</th><th>Link</th></tr></thead>
		
		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.projekt}</td>
				<td>${item.anzahl}</td>
				<td>${item.freigegeben}</td>
				<td>${item.kommentar}</td>
				<td><a href="/detail?id=${item.id}">Details</a></td>
			</tr>
		</c:forEach>
		</table>
		
		<br/><br/>
		<form class="form-horizontal" role="form" action="/main">
		<legend>Neuer Eintrag</legend>
		  <div class="form-group">
		    <label for="inputProjekt" class="col-sm-2 control-label">Projekt</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputProjekt">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputStunden" class="col-sm-2 control-label">Anzahl Stunden</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputStunden">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputKommentar" class="col-sm-2 control-label">Kommentar</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputKommentar">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox"> Freigegeben
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Abschicken</button>
		    </div>
		  </div>
		</form>

	</div>
  </body>
</html>
