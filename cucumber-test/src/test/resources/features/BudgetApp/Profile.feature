# language: ru
Функция: Операции с авторизацией
  Предыстория:
    * пользователь открыл страницу

  @3.1
  Сценарий: Изменение имени
    * пользователь ввел существующий логин и пароль
    * пользователь нажал кнопку Login
    * открылась страница Dashboard
    * пользователь открыл страницу "ProfilePage"
    * пользователь открыл вкладку Profile
    * запомнил имя и символ валюты
    * ввел новое имя
    Когда сохранил изменения
    Тогда появилось сообщение об успешном изменении данных "Successfully update profile"
    Когда пользователь открыл страницу "ProfilePage"
    Тогда в поле Name содержится новое имя

  @3.2
  Сценарий: Изменение символа валюты
    * пользователь ввел существующий логин и пароль
    * пользователь нажал кнопку Login
    * открылась страница Dashboard
    * пользователь открыл страницу "ProfilePage"
    * пользователь открыл вкладку Profile
    * запомнил имя и символ валюты
    * ввел новый символ валюты
    Когда сохранил изменения
    Тогда появилось сообщение об успешном изменении данных "Successfully update profile"
    Когда пользователь открыл страницу "ProfilePage"
    Тогда в поле Currency Symbol содержится новый символ валюты

  @3.3
  Сценарий: Изменение пароля
    * пользователь ввел существующий логин и пароль
    * пользователь нажал кнопку Login
    * открылась страница Dashboard
    * пользователь открыл страницу "ProfilePage"
    * пользователь открыл вкладку Change Password
    * ввел текущий пароль
    * сгенерировал и ввел новый пароль
    Когда нажал кнопку 'Change password'
    Тогда появилось сообщение об успешном изменении данных "Successfully change password"
    * пользователь разлогинился
    * открылась страница "LoginPage"
    Когда пользовател ввел логин и старый пароль
    Когда пользователь нажал кнопку Login
    Тогда появилось сообщение "Invalid username and password combination"
    Когда пользовател ввел логин и новый пароль
    Когда пользователь нажал кнопку Login
    Тогда открылась страница Dashboard

  @3.4
  Сценарий: Возвращение исходного пароля
    * пользователь ввел существующий логин и новый пароль
    * пользователь нажал кнопку Login
    * открылась страница Dashboard
    * пользователь открыл страницу "ProfilePage"
    * пользователь открыл вкладку Change Password
    * вернул старый пароль
    Когда нажал кнопку 'Change password'
    Тогда появилось сообщение об успешном изменении данных "Successfully change password"




