## Tasks

- Добавить пользователя

```
Запрос:
POST /users

email - текстовое поле
password - текстовое поле

Ответ:
id - число
email - текстовое поле
state - состояние
role - роль

Дополнительно:
При создании пользователя ему должен быть присвоен статус NOT_CONFIRMED и роль по умолчанию USER
```

- Получить список всех пользователей

```
Запрос:

GET /users

Ответ:

{
    "users": [
        // список пользователей, с полями
        // id, email, state, role
    ],
    "count" : // сколько данных вернули 
}
```

- Add Event

```
Запрос:
POST /events

name - текстовое поле

Ответ:
eventType - текстовое поле

```

- Get all Events

```
Запрос:

GET /events

Ответ:

{
    "events": [
        {
            "eventType" : "NOT_FOUND" 
        }
    ],
    "count" : // сколько events вернули 
}
```

- Удалить пользователя по id
```
Запрос:

DELETE /users/{users-id}

Ответ 200:

{
// данные о пользователе
}

Ответ 404 - пользователь не найден
```

- Обновить пользователя по id (можно обновлять только роль (например, сделать менеджером) и статус - для администратора)
```
Запрос:

PUT /users/{user-id}

- role (строка)
- status (строка)

Ответ:

- Данные пользователя
```

- Получить одного пользователя по id (в будущем мы его доделаем, чтобы он еще и события пользователя возвращал)
```
  Запрос:

GET /users/{user-id}

Ответ:

- Данные пользователя
```

- Удалить event по id
```
Запрос:

DELETE /events/{events-id}

Ответ 200:

{
// данные о event
}

Ответ 404 - пользователь не найден
```

- Обновить event по id (можно обновлять только state (Ignored) и EventType - для администратора)
```
Запрос:

PUT /events/{event-id}

- eventType (строка)
- status (строка)

Ответ:

- event name
```

- Получить event по id 
```
  Запрос:

GET /events/{event-id}

Ответ:

- Данные event
```

- Добавить статью о пользователе
- Добавить event о пользователе
- Получить все статьи определенного пользователя
- Получить все events определенного пользователя

- Получить все статьи по определенным датам:
- Получить все events по определенным датам:

```
GET /api/articles получить все статьи
GET /api/articles?year=2022 получить статьи за 2022-год
GET /api/articles?year=2022&month=2 получить все статьи за 2022-й год за февраль
```

```
GET /api/events получить все events
GET /api/events?year=2022 получить events за 2022-год
GET /api/events?year=2022&month=2 получить все events за 2022-й год за февраль
```

- Validation for user: email field cannot be null, empty or not blank. 
- Password field - min 7, max 20 characters. 
- Validation for all events and articles fields are required cannot be null, empty or not blank. 