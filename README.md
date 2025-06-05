# Spring Boot CRUD API для управления пользователями
![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.6-brightgreen?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue?logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-3.6+-red?logo=apache-maven) 

Простое REST API для создания, чтения, обновления и удаления пользователей с использованием Spring Boot и PostgreSQL.

## 📌 Технологии

- **Java 17**
- **Spring Boot 3.4.6**
- **Spring Data JPA** (для работы с БД)
- **PostgreSQL** (реляционная база данных)
- **Maven** (сборка проекта)

## 🚀 Запуск проекта

### 1. Требования
- Установленные:
  - Java 17+
  - Maven 3.6+
  - PostgreSQL 14+

### 2. Настройка базы данных
1. Создайте БД в PostgreSQL:
   ```sql
   CREATE DATABASE users_db;
   
2. Настройте подключение в application.properties:

```
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/users_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Сборка и запуск
bash
# Клонировать репозиторий
git clone https://github.com/your-username/your-repo.git

# Перейти в директорию проекта
cd your-repo

# Собрать проект
mvn clean package

# Запустить приложение
java -jar target/demo-1.jar
Приложение будет доступно по адресу: http://localhost:8080

📚 API Endpoints
```
Пользователи (/api/users)
Метод	Путь	Действие	Тело запроса (JSON)
GET	/api/users	Получить всех пользователей	-
POST	/api/users	Создать пользователя	{"name": "John", "email": "john@example.com", "birth": "1990-01-01"}
PUT	/api/users/{id}	Обновить пользователя	Параметры: email (опционально), name (опционально)
DELETE	/api/users/{id}	Удалить пользователя	-
```
Пример запроса (POST):
```
json
{
  "name": "Alice",
  "email": "alice@example.com",
  "birth": "1995-05-15"
}
```
🛠 Структура проекта
```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/UserController.java  # REST-контроллер
│   │   ├── service/UserService.java        # Бизнес-логика
│   │   ├── repository/UserRepository.java  # Работа с БД
│   │   └── repository/User.java            # Сущность пользователя
│   └── resources/
│       └── application.properties          # Настройки БД
```
🐳 Запуск в Docker (опционально)

Соберите образ:
```
bash
docker build -t user-api .
```

Запустите контейнер:
```
bash
docker run -p 8080:8080 user-api
```
