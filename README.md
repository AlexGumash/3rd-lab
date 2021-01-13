# Запуск сервиса:
* IntelliJ IDEA:  
Run -> Run "Tomcat"  
Сервис будет доступен по адресу: "http://localhost:8080/Evening_Courses_Applications_Service_war_exploded/"

* Docker:  
Создайте image, запустите контейнер  
Сервис будет доступен по адресу: "http://localhost:8081/evening-courses-applications-service/"  

> Последовательность символов после localhost:*/ - название war файла, развернутого на сервере.  
При необходимости можно легко поменять.

# Список сервисов:

* /evstudent
* /evcourse
* /evclass
* /evclassEvstudent
* /application
* /seminar
* /seminarEvstudent

# Доступ:

* Для доступа к сервисам используйте путь **/rest/{название сервиса}**  
Пример: http://localhost:8081/evening-courses-applications-service/rest/testservice  

* Для доступа к ресурсу по id добавьте к URL ресурса **/{id}** и используйте **GET**-запрос  
Пример: http://localhost:8081/evening-courses-applications-service/rest/evstudent/1  

* Для получения всех ресурсов сервиса добавьте к URL ресурса **/all** и используйте **GET**-запрос  
Пример: http://localhost:8081/evening-courses-applications-service/rest/evstudent/all  

* Для обновления ресурса по id добавьте к URL ресурса **/{id}?{param}=...** и используйте **PUT**-запрос  
Пример: http://localhost:8081/evening-courses-applications-service/rest/evstudent/1?name=Ivan&surname=Ivanov  

* Для удаления ресурса по id добавьте к URL ресурса **/{id}** и используйте **DELETE**-запрос  
Пример: http://localhost:8081/evening-courses-applications-service/rest/evstudent/1  

* Добавление ресурса происходит через заполнение формы и отправки POST-запроса, который содержит необходимые параметры  

# Список полей, необходимых для заполнения при обновлении или добавлении ресурса:

- evstudent:
    - name
    - surname
    - patronymic
    - phone
    - email
    - source  
- evcourse:
    - code
    - name
    - version
    - duration  
- evclass:
    - courseCode
    - dateBegin
    - dateEnd  
- evclassEvstudent:
    - evclassId
    - evstudentId
    - consultationDate
    - consultationTime
    - paymentState
    - contractState  
- seminar:
    - name
    - shortName
    - seminarDate
    - seminarTime
    - duration
    - price
- seminarEvstudent:
    - seminarId
    - evstudentId
    - paymentState

# Обработка заявок

Обработка заявки происходит путём отправки POST-запроса на сервис application. Запрос содержит данные, введение в форме заявки на сайте.  
В сервисе application происходит обработка данных и вызов методов других сервисов для создания записей в таблицах БД.

# CORS Filter

Для того, чтобы позволить приложениям, расположенным на других доменах, обращаться к данному сервису, был реализован CORS Filter.  
Его реализация находится в файле java/restServices/CorsFilter.java.  
Данный фильтр подключается при помощи аннотации @Provider. Это возможно благодаря тому, что в файле web.xml в специальном параметре указан соответсвующий пакет.  

# Аутентификация

На данный момент аутентификация сделана "на коленке" и требует совершенствования. 
При вызове любого метода любого сервиса происходит сравнение закодированной пары логин:пароль, пришедшей в заголовке запроса, с закодированной парой логин:пароль, захардкоженой в java/restServices/RestService.java.  
Сервис AuthTestRestService позволяет сторонним приложениям отправлять тестовые запросы с целью проверить логин и пароль.

# Документация

Более подробную техническую документацию можно найти в папке documents.  
Документация создана автоматически с помощью Swagger.