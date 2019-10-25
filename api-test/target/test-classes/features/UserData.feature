# language: ru

Функция: Авторизация

  Предыстория:
    Дано получены данные пользователя
    Дано пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com

  @2.1
  Сценарий: Изменение имени пользоателя /api/users/auth
    Когда пользователь меняет значение "key" поля "value"
    |key    |value    |
    |name   |Вася     |
    Когда пользователь отправляет PUT запрос на /api/users
    И передает application/json:
      |header Content-Type   |application/json;charset=UTF-8     |
      |template              |changedNameUserData                |
    Тогда пользователь получает ответ со статусом 200
