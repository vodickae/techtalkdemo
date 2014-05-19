<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1>Main (Hauptseite)</h1>
Dies ist die Hauptseite der Anwendung für angemeldete Nutzer. Folgende Use Cases sind hier zu implementieren:
<ul>
<li>Eingabe-Formular zum erfassen einen neuen Stunden-Datensatzes.</li>
<li>Tabelle mit der Auflistung aller Stunden-Datensätze des Nutzers, sowie von anderen Nutzern freigegebener Datensätze.</li>
<li>Link zur Detailansicht pro Datensatz</li>
<li>Suchformular, mit dem die Tabelle "gefiltert" werden kann.</li>
</ul>

<table border="1">
<thead><tr><th>ID</th><th>Projekt</th><th>Anzahl</th><th>Freigegeben</th><th>Kommentar</th></tr></thead>

<c:forEach items="${items}" var="item">
	<tr>
		<td>${item.id}</td>
		<td>${item.projekt}</td>
		<td>${item.anzahl}</td>
		<td>${item.freigegeben}</td>
		<td>${item.kommentar}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>
