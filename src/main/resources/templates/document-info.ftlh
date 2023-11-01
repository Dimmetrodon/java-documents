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
<form action ="/document/update/${document.id}" method="post">
    Номер: <input type="text" name="document_number" value="${document.document_number}">
    Дата создания: <input type="text" name="date" value="${document.date}">
    Сумма: <input type="number" name="sum" value="${document.sum}">
    Примечание: <input type="text" name="note" value="${document.note}">
    <input type="submit" value="Изменить документ"/>
</form>
<form action="/document/delete/${document.id}" method="post">
    <input type="submit" value="Удалить документ"/>
</form>
</body>
</html>