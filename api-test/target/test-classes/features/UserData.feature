# language: ru

Функция: Авторизация

  Предыстория:
    Дано пользователь получает токен доступа
    Дано пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com

  @2.1
  Сценарий: Успешная авторизация /api/users/auth
    Когда пользователь отправляет POST запрос на /api/users/auth
    И передает application/json:
      |header Accept         |application/json, text/plain, */*  |
      |header Accept-Encoding|gzip, deflate                      |
      |header Accept-Language|ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7|
      |header Authorization  |Basic undefined                    |
      |header Connection     |keep-alive                         |
      |header Host |otus-test-budget-app.herokuapp.com                                 |
      |header Origin |http://otus-test-budget-app.herokuapp.com                                |
      |header Referer |http://otus-test-budget-app.herokuapp.com/                                |
      |User-Agent |Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36                                 |
      |header Content-Type   |application/json;charset=UTF-8     |
      |template              |api_user_auth_success.json         |
    Тогда пользователь получает ответ со статусом 200
