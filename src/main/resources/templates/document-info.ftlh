<!DOCTYPE html>
<html>
<head>
    <title>Документы</title>
</head>
<body>
<h1>Документы</h1><hr>
<h4>Подробная информация о документе</h4>
<b>Номер: </b>${document.document_number}<br>
<b>Дата создания: </b>${document.date}<br>
<b>Сумма: </b>${document.sum}<br>
<b>Примечание: </b>${document.note}<br>
<hr>
<form action="/document/delete/${document.id}" method="post">
    <input type="submit" value="Удалить документ"/>
</form>
</body>
</html>