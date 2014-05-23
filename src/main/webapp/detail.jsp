<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Detailansicht</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  	<div class="container">
	    <h1>Detailansicht</h1>

		Dies ist die Detailansicht eines Stunden-Datensatzes. Sie zeigt einen Datensatz im Detail an.

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Projekt</th>
					<th>Anzahl</th>
					<th>Freigegeben</th>
					<th>Kommentar</th>
				</tr>
			</thead>
			<tr>
				<td>${item.id}</td>
				<td>${item.projekt}</td>
				<td>${item.anzahl}</td>
				<td>${item.freigegeben}</td>
				<td>${item.kommentar}</td>
			</tr>
		</table>

	</div>
  </body>
</html>