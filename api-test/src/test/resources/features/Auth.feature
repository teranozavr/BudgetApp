# language: ru

Функция: Авторизация

  Предыстория:
    Дано пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com

  @1.1
  Сценарий: Успешная авторизация /api/users/auth
    Когда пользователь отправляет POST запрос на /api/users/auth
    И передает application/json:
      |header Content-Type   |application/json;charset=UTF-8     |
      |template              |api_user_auth_success.json         |
    Тогда пользователь получает ответ со статусом 200

  @1.2
  Сценарий: Неуспешная авторизация /api/users/auth
    Когда пользователь отправляет POST запрос на /api/users/auth
    И передает application/json:
      |header Accept         |application/json, text/plain, */*  |
      |header Accept-Encoding|gzip, deflate                      |
      |header Accept-Language|ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7|
      |header Authorization  |Basic undefined                    |
      |header Connection     |keep-alive                         |
      |header endPoint |otus-test-budget-app.herokuapp.com                                 |
      |header Origin |http://otus-test-budget-app.herokuapp.com                                |
      |header Referer |http://otus-test-budget-app.herokuapp.com/                                |
      |User-Agent |Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36                                 |
      |header Content-Type   |application/json;charset=UTF-8     |
      |template              |api_user_auth_fail.json         |
    Тогда пользователь получает ответ со статусом 401

  @1.3
  Сценарий: Неверный тип запроса /api/users/auth
    Когда пользователь отправляет PUT запрос на /api/users/auth
    И передает application/json:
      |header Accept         |application/json, text/plain, */*  |
      |header Accept-Encoding|gzip, deflate                      |
      |header Accept-Language|ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7|
      |header Authorization  |Basic undefined                    |
      |header Connection     |keep-alive                         |
      |header endPoint |otus-test-budget-app.herokuapp.com                                 |
      |header Origin |http://otus-test-budget-app.herokuapp.com                                |
      |header Referer |http://otus-test-budget-app.herokuapp.com/                                |
      |User-Agent |Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36                                 |
      |header Content-Type   |application/json;charset=UTF-8     |
      |template              |api_user_auth_fail.json         |
    Тогда пользователь получает ответ со статусом 405

  @1.5
  Сценарий: Неверный content type /api/users/auth
    Когда пользователь отправляет POST запрос на /api/users/auth
    И передает application/json:
      |header Accept         |application/json, text/plain, */*  |
      |header Accept-Encoding|gzip, deflate                      |
      |header Accept-Language|ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7|
      |header Authorization  |Basic undefined                    |
      |header Connection     |keep-alive                         |
      |header endPoint |otus-test-budget-app.herokuapp.com                                 |
      |header Origin |http://otus-test-budget-app.herokuapp.com                                |
      |header Referer |http://otus-test-budget-app.herokuapp.com/                                |
      |User-Agent |Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36                                 |
      |header Content-Type   |application/xml;charset=UTF-8     |
      |template              |api_user_auth_success.json         |
    Тогда пользователь получает ответ со статусом 415

  @1.6
  Сценарий: Неверное тело запроса /api/users/auth
    Когда пользователь отправляет POST запрос на /api/users/auth
    И передает application/json:
      |header Accept         |application/json, text/plain, */*  |
      |header Accept-Encoding|gzip, deflate                      |
      |header Accept-Language|ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7|
      |header Authorization  |Basic undefined                    |
      |header Connection     |keep-alive                         |
      |header endPoint |otus-test-budget-app.herokuapp.com                                 |
      |header Origin |http://otus-test-budget-app.herokuapp.com                                |
      |header Referer |http://otus-test-budget-app.herokuapp.com/                                |
      |User-Agent |Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36                                 |
      |header Content-Type   |application/json;charset=UTF-8     |
      |template              |api_user_auth_wrong_json_formatl.json         |
    Тогда пользователь получает ответ со статусом 500