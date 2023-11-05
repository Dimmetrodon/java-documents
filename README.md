# "Java Documents"

## Описание

Этот проект представляет собой Java-приложение для управления документами. Оно использует Spring Boot для реализации бэкенда и Angular для создания пользовательского интерфейса.

## Требования

Перед началом работы убедитесь, что у вас установлены следующие компоненты:

-   Java JDK версии 11 или выше
-   Maven
-   Angular

## Установка, сборка и запуск

Для установки проекта "Java Documents" выполните следующие шаги:

1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/Dimmetrodon/java-documents.git
    git clone https://github.com/Dimmetrodon/documents-front.git
    ```
2. Перейдите в директорию проекта:
    ```bash
    cd java-documents
    mvn clean package
    java -jar ./target/"your .jar file"
    ```
3. В другом терминале
    ```bash
    cd documents-front
    npm i -g @angular/cli
    npm i
    ng serve --open
    ```
