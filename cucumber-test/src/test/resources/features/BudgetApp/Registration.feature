# language: ru
Функция: Операции с регистрацией
  Предыстория:
    Дано пользователь открыл страницу

  @2.1
  Сценарий: успешная регистрация
    Дано пользователь нажал ссылку SignUp
    Дано пользователь дождался открытия страницы Авторизации
    Дано пользователь придумал и ввел корректный логин и пароль
    Когда пользователь нажал кнопку SignUp
    Тогда появилось сообщение об успешной авторизации "Sign Up success. You can Login now."

  @2.2
  Структура сценария: неуспешная регистрация
    Дано пользователь нажал ссылку SignUp
    Дано пользователь дождался открытия страницы Авторизации
    Дано пользователь ввел логин "<login>"
    Дано пользователь ввел пароль "<password>"
    Когда пользователь нажал кнопку SignUp
    Тогда появилось предупреждение о неверном e-mail "<loginAllert>"
    Тогда появилось предупреждение о неверном пароле "<passwordAllert>"
    Примеры:
      |login|password|loginAllert         |passwordAllert                               |
      |a    |        |Email is not valid  |Password is required                         |
      |     |a       |Email is not valid  |Password length must be at least 6 characters|
      |a    |a       |Email is not valid  |Password length must be at least 6 characters|




