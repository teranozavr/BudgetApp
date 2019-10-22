# language: ru

Функция: Авторизация

  Предыстория:
    Дано пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com

  @2.1
  Сценарий: Успешное изменение данных /api/users
    Когда пользователь отправляет PUT запрос на /api/users
    И передает application/json:
      |header Accept         |application/json, text/plain, */*  |
#      |header Accept-Encoding|gzip, deflate                      |
#      |header Accept-Language|ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7|
      |header Authorization  |Bearer 73bf9ecd-c2e2-4ca0-9a76-1289d2a4c0e5                    |
#      |header Connection     |keep-alive                         |
      |header Host |otus-test-budget-app.herokuapp.com                                 |
      |header Origin |http://otus-test-budget-app.herokuapp.com                                |
      |header Referer |http://otus-test-budget-app.herokuapp.com/profile                                |
      |User-Agent |Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36                                 |
      |header Content-Type   |application/json;charset=UTF-8     |
      |template              |api_user_success_user_data_change.json        |
    Тогда пользователь получает ответ со статусом 200
