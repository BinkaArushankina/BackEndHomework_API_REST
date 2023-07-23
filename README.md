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