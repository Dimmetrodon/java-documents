<!DOCTYPE html>
<html>
<head>
    <title>Documents</title>
</head>
<body>
<h1>DOCUMENTS</h1><hr>
<h4>Документы</h4>
<form action="/" method="get">
    Поиск по номеру документа: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list documents as document>
    <div>
        <p><b>${document.document_number}</b> ${document.sum} ${document.date} ${document.note}</p> | <a href="/document/${document.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Документов нет</h3>
</#list>
<hr>
<h3>Создать новый документ</h3>
<form action ="/document/create" method="post">
    Номер: <input type="text" name="document_number">
    Дата создания: <input type="text" name="date">
    Примечание: <input type="text" name="note">
    <input type="submit" value="Добавить документ"/>
</form>
</body>
</html>
