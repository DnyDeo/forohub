# ForoHub API

API REST construida con **Spring Boot 3** para gestionar tópicos en un foro.  
Permite **crear, listar, actualizar, eliminar (lógico) y consultar** tópicos de manera sencilla.

## 🚀 Funcionalidades principales
- **Crear tópico** → `POST /topicos`
- **Listar tópicos con paginación** → `GET /topicos`
- **Consultar tópico por ID** → `GET /topicos/{id}`
- **Actualizar tópico** → `PUT /topicos`
- **Eliminar tópico (lógico)** → `DELETE /topicos/{id}`

## ⚙️ Tecnologías
- Java 17+
- Spring Boot 3
- Spring Data JPA + Hibernate
- Jakarta Validation
- Base de datos: MySQL / PostgreSQL

## 📌 Notas
- El **borrado es lógico** (los tópicos se marcan como inactivos, no se eliminan físicamente).  
- Soporta **paginación** al listar tópicos.  
- Respuestas con **códigos HTTP apropiados** (`201 Created`, `200 OK`, `204 No Content`, etc.).

## ▶️ Ejecución
1. Clona el repositorio
2. Configura la base de datos en `application.properties`
3. Ejecuta con:
   ```bash
   mvn spring-boot:run

