Создаём проект через инициализацию добавляя инструменты разработчика и спринг веб. Остальное мы сможем вручную добавить по ходу разработки . ИДЕЯ нам сама добавит все зависимости . И получается запуск приложения начинается с файла _Application.java расположенный src/main/java/com/example/__/.
___ это название проекта . 
В файле build.gradle находится конфигурация нашего проекта . А в поле dependencies указаны зависимости , которые мы выбирали . 
Теперь разберем задачу . По сути у нас будет две базы данных . Первая это пользователи с полями id , username , password .  вторая это список дел каждого пользователя с полями id (уникальное для каждого расписания дел) , название , выполнено/не выполнено  и поля , которое имеет id пользователя для . Получается у нас связь один ко многим (один пользователь ко многим задачам) . 

Теперь в папке нашего проекта example/____/ создаём папку  controller, где будет сосредаточена вся логика по обработке http запросов . Внутри класс UserControllee. Этот класс решает вопросы конкретно от пользователя . 

Чтоб спринг понимал , что это контроллер добавим аннотацию @RestController
(которая автоматически добавит зависимости для него) . 
Бывает обычный контроллер который отправляет html файлы , но так как у нас РЕСТ сервер пишем рест контроллер . 
Добавляем @RequestMapping("/users")
Эта аннотация говорит , что запросы , которые будут тут отрабатываться должны начинаться с url /users . 

Создаём функцию , которая возвращает ResponseEntity   , которая нужна чтоб лишь убедиться в работоспособности сервера . 
Построим конструкцию try {} catch , которая при ловле ошибок будет возвращать (return)
ResponseEntity.badRequest().body("Ошибка");
То есть на клиент вернётся статус с 400 ошибкой и добавим текст . 

В теле try напишем return ResponseEnyity.ok("все работает") . то есть 200 стасус .

Перед функций это напишем аннотацию @GetMapping("/")
так как тип метода запроса гет (пост/пут/делит/гет) . 
В скобках можно указать урл по которому будет отрабатываться запрос . И по сути над контроллером мы так же указали путь , поэтому у нас получится так , что они будут приплюсовываться и получится сам Getmapping будет иметь путь /users/...
в браузере напишем localhost:8080/users/ . 

В папке controller создадим папку entity где будет вся логика нашей программы  . Назовём класс внутри UserEntity. 

Включаем MySQL
создаём базу данных и use. 

Теперь нам нужно подключить зависимости для sql и т.д. 
Лучше всего мы сможем получить описывающую документацию в сайте spring , где вкладке Learn  выбрать Guide и пишем в поиске mysql . Там будут зависимости . Но в целом лучше это делать , когда мы инициализировали файл на сайте . Либо можно создать архив под нужную зависимость , чтоб скопировать строчку из build.gradle в dependencies  , там в список зависимостей . 
То есть сейчас мы добавили mysql , data-jpa .
Так же в папке main/resources  есть файл application.properties . 
В документации спринга , который мы раньше открывали есть под раздел под это , нужно будет скопировать но ввести с изменениями . А именно вместо строки с url=jbdc:mysql:// _
указать туда путь в данном случае localhost:3306/ulbitv?
получается хттп адрес нашего сервака епта . 
А дальше в юзер нами , имя которое мы делали во время установки root 
и пароль Oybek
Возвращаемся в класс сущности пользователя . Для того , чтобы jpa сделало из этой сущности таблицу в базе данных необходимо пометить класс аннатоцией @Entity. 
у внутри описываем поля как было по условию . Очень важно то , что в базе данных каждое поле имеет название и оно не может принять название по названию полей класса из джава , поэтому над каждым полем бы пишем аннотацию названия поля как было бы написано в;  базе данных .
