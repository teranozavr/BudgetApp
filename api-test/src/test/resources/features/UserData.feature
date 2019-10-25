# language: ru

Функция: Изменение данных пользователя

  Предыстория:
    Дано получены данные пользователя
    Дано пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com

  @2.1
  Сценарий: Изменение имени пользоателя
    Когда пользователь меняет значение "key" поля "value"
    |name   |Вася     |
    Когда пользователь отправляет PUT запрос на /api/users
    И передает application/json:
      |header Content-Type   |application/json;charset=UTF-8     |
      |header Authorization  |token                              |
      |template              |changedNameUserData                |
    Тогда пользователь получает ответ со статусом 200
    Тогда ответ содержит значение "key" поля "value"
      |name   |Вася     |
