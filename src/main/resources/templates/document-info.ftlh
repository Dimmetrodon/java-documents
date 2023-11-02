<!DOCTYPE html>
<html>
<head>
    <title>Документы</title>
    <style>
        .document-info {
            border: 1px solid #000;
            padding: 10px;
            margin: 10px 0;
        }

        .position {
            border: 1px solid #999;
            padding: 10px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<h1>Документы</h1>
<hr>
<div class="document-info">
    <h4>Подробная информация о документе</h4>
    <b>Номер: </b>${document.document_number}<br>
    <b>Дата создания: </b>${document.date}<br>
    <b>Сумма: </b>${document.sum}<br>
    <b>Примечание: </b>${document.note}<br>
    <form action="/document/update/${document.id}" method="post">
        Номер: <input type="text" name="document_number" value="${document.document_number}">
        Дата создания: <input type="text" name="date" value="${document.date}">
        Примечание: <input type="text" name="note" value="${document.note}">
    <input type="submit" value="Изменить документ"/>
    </form>
    <form action="/document/delete/${document.id}" method="post">
        <input type="submit" value="Удалить документ"/>
    </form>
</div>
<hr>
<div class="document-info">
    <h4>Позиции</h4>
    <#list document.positions as position>
        <div class="position">
            <p><b>Номер позиции: ${position.position_number}</b></p>
            <p>Название: ${position.name}</p>
            <p>Сумма: ${position.sum}</p>
            <form action="/document/${document.id}/updateposition/${position.id}" method="post">
                Номер позиции: <input type="text" name="position_number" value="${position.position_number}">
                Название: <input type="text" name="name" value="${position.name}">
                Сумма: <input type="text" name="sum" value="${position.sum}">
                <input type="submit" value="Изменить позицию"/>
            </form>
            <form action="/document/${document.id}/deleteposition/${position.id}" method="post">
                <input type="submit" value="Удалить позицию"/>
            </form>
        </div>
    </#list>
    <#if document.positions?size == 0>
        <h3>Позиций нет</h3>
    </#if>
</div>
<form action="/document/${document.id}/createposition" method="post">
    Номер позиции: <input type="text" name="position_number">
    Название: <input type="text" name="name">
    Сумма: <input type="text" name="sum">
    <input type="submit" value="Добавить позицию"/>
</form>
</body>
</html>
