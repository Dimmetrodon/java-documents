<!DOCTYPE html>
<html>
<head>
    <title>Documents</title>
</head>
<body>
<h1>DOCUMENTS</h1><hr>
<h4>Документы</h4>
<#list documents as document>
    <div>
        <p><b>${document.document_number}</b> ${document.sum}</p> | <a href="/document/${document.id}">Подробнее...</a></p>
    </div>
</#list>
<hr>
<h3>Создать новый документ</h3>
<form action ="/document/create" method="post">
    Номер: <input type="text" name="document_number">
    Дата создания: <input type="text" name="date">
    Сумма: <input type="int" name="sum">
    Примечание: <input type="int" name="note">
</form>
</body>
</html>
