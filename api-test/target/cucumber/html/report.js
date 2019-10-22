$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Auth.feature");
formatter.feature({
  "name": "Авторизация",
  "description": "",
  "keyword": "Функция"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.userSendRequest(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Успешная авторизация /api/users/auth",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@1.1"
    }
  ]
});
formatter.step({
  "name": "пользователь отправляет POST запрос на /api/users/auth",
  "keyword": "Когда "
});
formatter.match({
  "location": "When.пользователь_отправляет_запрос(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "передает application/json:",
  "rows": [
    {
      "cells": [
        "header Accept",
        "application/json, text/plain, */*"
      ]
    },
    {
      "cells": [
        "header Accept-Encoding",
        "gzip, deflate"
      ]
    },
    {
      "cells": [
        "header Accept-Language",
        "ru-RU,ru;q\u003d0.9,en-US;q\u003d0.8,en;q\u003d0.7"
      ]
    },
    {
      "cells": [
        "header Authorization",
        "Basic undefined"
      ]
    },
    {
      "cells": [
        "header Connection",
        "keep-alive"
      ]
    },
    {
      "cells": [
        "header Host",
        "otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Origin",
        "http://otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Referer",
        "http://otus-test-budget-app.herokuapp.com/"
      ]
    },
    {
      "cells": [
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36"
      ]
    },
    {
      "cells": [
        "header Content-Type",
        "application/json;charset\u003dUTF-8"
      ]
    },
    {
      "cells": [
        "template",
        "api_user_auth_success.json"
      ]
    }
  ],
  "keyword": "И "
});
formatter.match({
  "location": "When.передает(String,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь получает ответ со статусом 200",
  "keyword": "Тогда "
});
formatter.match({
  "location": "Then.пользователь_получает_ответ_со_статусом(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.userSendRequest(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Неуспешная авторизация /api/users/auth",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@1.2"
    }
  ]
});
formatter.step({
  "name": "пользователь отправляет POST запрос на /api/users/auth",
  "keyword": "Когда "
});
formatter.match({
  "location": "When.пользователь_отправляет_запрос(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "передает application/json:",
  "rows": [
    {
      "cells": [
        "header Accept",
        "application/json, text/plain, */*"
      ]
    },
    {
      "cells": [
        "header Accept-Encoding",
        "gzip, deflate"
      ]
    },
    {
      "cells": [
        "header Accept-Language",
        "ru-RU,ru;q\u003d0.9,en-US;q\u003d0.8,en;q\u003d0.7"
      ]
    },
    {
      "cells": [
        "header Authorization",
        "Basic undefined"
      ]
    },
    {
      "cells": [
        "header Connection",
        "keep-alive"
      ]
    },
    {
      "cells": [
        "header Host",
        "otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Origin",
        "http://otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Referer",
        "http://otus-test-budget-app.herokuapp.com/"
      ]
    },
    {
      "cells": [
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36"
      ]
    },
    {
      "cells": [
        "header Content-Type",
        "application/json;charset\u003dUTF-8"
      ]
    },
    {
      "cells": [
        "template",
        "api_user_auth_fail.json"
      ]
    }
  ],
  "keyword": "И "
});
formatter.match({
  "location": "When.передает(String,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь получает ответ со статусом 401",
  "keyword": "Тогда "
});
formatter.match({
  "location": "Then.пользователь_получает_ответ_со_статусом(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.userSendRequest(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Неверный тип запроса /api/users/auth",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@1.3"
    }
  ]
});
formatter.step({
  "name": "пользователь отправляет PUT запрос на /api/users/auth",
  "keyword": "Когда "
});
formatter.match({
  "location": "When.пользователь_отправляет_запрос(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "передает application/json:",
  "rows": [
    {
      "cells": [
        "header Accept",
        "application/json, text/plain, */*"
      ]
    },
    {
      "cells": [
        "header Accept-Encoding",
        "gzip, deflate"
      ]
    },
    {
      "cells": [
        "header Accept-Language",
        "ru-RU,ru;q\u003d0.9,en-US;q\u003d0.8,en;q\u003d0.7"
      ]
    },
    {
      "cells": [
        "header Authorization",
        "Basic undefined"
      ]
    },
    {
      "cells": [
        "header Connection",
        "keep-alive"
      ]
    },
    {
      "cells": [
        "header Host",
        "otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Origin",
        "http://otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Referer",
        "http://otus-test-budget-app.herokuapp.com/"
      ]
    },
    {
      "cells": [
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36"
      ]
    },
    {
      "cells": [
        "header Content-Type",
        "application/json;charset\u003dUTF-8"
      ]
    },
    {
      "cells": [
        "template",
        "api_user_auth_fail.json"
      ]
    }
  ],
  "keyword": "И "
});
formatter.match({
  "location": "When.передает(String,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь получает ответ со статусом 405",
  "keyword": "Тогда "
});
formatter.match({
  "location": "Then.пользователь_получает_ответ_со_статусом(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.userSendRequest(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Неверный content type /api/users/auth",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@1.5"
    }
  ]
});
formatter.step({
  "name": "пользователь отправляет POST запрос на /api/users/auth",
  "keyword": "Когда "
});
formatter.match({
  "location": "When.пользователь_отправляет_запрос(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "передает application/json:",
  "rows": [
    {
      "cells": [
        "header Accept",
        "application/json, text/plain, */*"
      ]
    },
    {
      "cells": [
        "header Accept-Encoding",
        "gzip, deflate"
      ]
    },
    {
      "cells": [
        "header Accept-Language",
        "ru-RU,ru;q\u003d0.9,en-US;q\u003d0.8,en;q\u003d0.7"
      ]
    },
    {
      "cells": [
        "header Authorization",
        "Basic undefined"
      ]
    },
    {
      "cells": [
        "header Connection",
        "keep-alive"
      ]
    },
    {
      "cells": [
        "header Host",
        "otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Origin",
        "http://otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Referer",
        "http://otus-test-budget-app.herokuapp.com/"
      ]
    },
    {
      "cells": [
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36"
      ]
    },
    {
      "cells": [
        "header Content-Type",
        "application/xml;charset\u003dUTF-8"
      ]
    },
    {
      "cells": [
        "template",
        "api_user_auth_success.json"
      ]
    }
  ],
  "keyword": "И "
});
formatter.match({
  "location": "When.передает(String,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь получает ответ со статусом 415",
  "keyword": "Тогда "
});
formatter.match({
  "location": "Then.пользователь_получает_ответ_со_статусом(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.userSendRequest(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Неверное тело запроса /api/users/auth",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@1.6"
    }
  ]
});
formatter.step({
  "name": "пользователь отправляет POST запрос на /api/users/auth",
  "keyword": "Когда "
});
formatter.match({
  "location": "When.пользователь_отправляет_запрос(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "передает application/json:",
  "rows": [
    {
      "cells": [
        "header Accept",
        "application/json, text/plain, */*"
      ]
    },
    {
      "cells": [
        "header Accept-Encoding",
        "gzip, deflate"
      ]
    },
    {
      "cells": [
        "header Accept-Language",
        "ru-RU,ru;q\u003d0.9,en-US;q\u003d0.8,en;q\u003d0.7"
      ]
    },
    {
      "cells": [
        "header Authorization",
        "Basic undefined"
      ]
    },
    {
      "cells": [
        "header Connection",
        "keep-alive"
      ]
    },
    {
      "cells": [
        "header Host",
        "otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Origin",
        "http://otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Referer",
        "http://otus-test-budget-app.herokuapp.com/"
      ]
    },
    {
      "cells": [
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36"
      ]
    },
    {
      "cells": [
        "header Content-Type",
        "application/json;charset\u003dUTF-8"
      ]
    },
    {
      "cells": [
        "template",
        "api_user_auth_wrong_json_formatl.json"
      ]
    }
  ],
  "keyword": "И "
});
formatter.match({
  "location": "When.передает(String,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь получает ответ со статусом 500",
  "keyword": "Тогда "
});
formatter.match({
  "location": "Then.пользователь_получает_ответ_со_статусом(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});