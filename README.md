# Discord Reminder Bot 🕒
Java-бот для Discord, который отправляет напоминания по расписанию.
(Надеюсь буду обновлять бота, чтобы возможностей было много)
---

## 📌 Возможности

- Добавление напоминаний в формате:  
  `!remind Текст at ЧЧ:ММ`
- Поддержка нескольких напоминаний
- Работа без Spring, всё на чистом Java
- Использует [JDA](https://github.com/DV8FromTheWorld/JDA)

---

## 🛠 Как запустить

1. Установи **JDK 17 или выше**
2. Скачай и подключи **JDA-5.0.0-withDependencies.jar**
3. Создай файл `src/main/resources/config.properties` и вставь в него:

   ```properties
   DISCORD_TOKEN=твой_токен_бота

 ## Структура
├── src/
│   └── main/
│       ├── java/
│       │   └── com/yourname/reminderbot/
│       │       ├── Main.java
│       │       ├── BotListener.java
│       │       ├── ReminderManager.java
│       │       └── model/
│       │           └── Reminder.java
│       └── resources/
│           └── config.properties

✅ Пример команды:
!remind Сделать отчет at 18:30

Лицензия
MIT