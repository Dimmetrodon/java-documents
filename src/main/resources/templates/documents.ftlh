<!DOCTYPE html>
<html>
<head>
    <title>Documents</title>
    <style>
        .document-container {
            border: 1px solid #000;
            padding: 10px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<h1>DOCUMENTS</h1>
<hr>
<h4>Документы</h4>
<form action="/" method="get">
    Поиск по номеру документа: <input type="text" name="document_number"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list documents as document>
    <div class="document-container">
        <p><b>${document.document_number}</b></p>
        <p>Сумма: ${document.sum}</p>
        <p>Дата: ${document.date}</p>
        <p>Примечание: ${document.note}</p>
        <a href="/document/${document.id}">Подробнее...</a>
    </div>
</#list>
<#if documents?size == 0>
    <h3>Документов нет</h3>
</#if>
<hr>
<h3>Создать новый документ</h3>
<form action="/document/create" method="post">
    Номер: <input type="text" name="document_number">
    Дата создания: <input type="text" name="date">
    Примечание: <input type="text" name="note">
    <input type="submit" value="Добавить документ"/>
</form>
</body>
</html>
