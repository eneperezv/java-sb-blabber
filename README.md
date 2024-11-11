# Blabber API 🐦

Blabber es una API RESTful creada con **Spring Boot** que replica funcionalidades de una red social tipo X (anteriormente Twitter). Permite a los usuarios publicar "Blabs", seguir a otros usuarios, dar "likes", comentar, enviar mensajes directos y recibir notificaciones sobre diversas interacciones.

**Tabla de Contenidos**

[TOCM]

[TOC]

## 📋 Características

- **Gestión de usuarios**: Registro, inicio de sesión y autenticación de usuarios.
- **Blabs**: Crear, obtener y listar publicaciones de texto (limite de 280 caracteres).
- **Likes** y **Comentarios**: Permite a los usuarios interactuar con los Blabs mediante "me gusta" y comentarios.
- **Seguidores**: Los usuarios pueden seguir y ser seguidos por otros usuarios.
- **Mensajes Directos**: Comunicación privada entre usuarios.
- **Notificaciones**: Alertas para informar a los usuarios sobre nuevos seguidores, likes, comentarios y mensajes directos.

## 🛠️ Tecnologías

- **Java 17**
- **Spring Boot**: Framework para desarrollo de la API REST.
- **Spring Data JPA**: Para el manejo de persistencia de datos.
- **MySQL**: Base de datos relacional.
- **JWT**: Autenticación y autorización.
- **Lombok** (opcional): Para reducir el boilerplate en las clases.

## 🚀 Instalación y Configuración

### Prerrequisitos

- **Java 17**
- **Maven** (para gestión de dependencias)
- **MySQL** (o cualquier base de datos compatible)

### Configuración de la Base de Datos

#### 1. Crea una base de datos en MySQL:

`CREATE DATABASE blabberdb;`

#### 2. Actualiza las credenciales en src/main/resources/application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/blabberdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

#### 3. Ejecución

Clona el repositorio y ejecuta el siguiente comando desde la raíz del proyecto para compilar y correr la API:

`mvn spring-boot:run`

La API estará disponible en http://localhost:8080.


## 📁 Estructura del Proyecto
```
src
│
├── com.enp.blabber
│   ├── controller               # Controladores (Endpoints REST)
│   │   ├── UserController.java
│   │   ├── BlabController.java
│   │   ├── FollowController.java
│   │   ├── NotificationController.java
│   │   └── DirectMessageController.java
│   │
│   ├── dto                      # Objetos de transferencia de datos (DTOs)
│   │   ├── UserDto.java
│   │   ├── BlabDto.java
│   │   ├── FollowDto.java
│   │   ├── NotificationDto.java
│   │   └── DirectMessageDto.java
│   │
│   ├── model                    # Entidades (Tablas de BD)
│   │   ├── User.java
│   │   ├── Blab.java
│   │   ├── Follow.java
│   │   ├── Notification.java
│   │   ├── Like.java
│   │   └── Comment.java
│   │
│   ├── repository               # Repositorios (Interacción con la BD)
│   │   ├── UserRepository.java
│   │   ├── BlabRepository.java
│   │   ├── FollowRepository.java
│   │   ├── NotificationRepository.java
│   │   ├── LikeRepository.java
│   │   └── CommentRepository.java
│   │
│   ├── service                  # Servicios (Lógica de negocio)
│   │   ├── UserService.java
│   │   ├── BlabService.java
│   │   ├── FollowService.java
│   │   ├── NotificationService.java
│   │   ├── LikeService.java
│   │   └── DirectMessageService.java
│   │
│   └── BlabberApplication.java  # Clase principal para ejecutar la API
│
└── resources
    └── application.properties   # Configuración de la aplicación
```

## 🔧 Endpoints Principales

| **Usuarios** | - | - |
| ------------- | --- | --- |
| `POST` | `/api/users/register` | Registrar un nuevo usuario. |
| `POST` | `/api/users/login` | Iniciar sesión. |
| `GET` | `/api/users/{id}` | Obtener el perfil de un usuario. |

| **Blabs** | - | - |
| ------------- | --- | --- |
| `POST` | `/api/blabs` | Crear un nuevo blab. |
| `GET` | `/api/blabs/{id}` | Obtener un blab por ID. |
| `POST` | `/api/blabs/{blabId}/like` |  Dar "like" a un blab. |
| `POST` | `/api/blabs/{blabId}/comment` | Comentar en un blab. |

| **Seguidores** | - | - |
| ------------- | --- | --- |
| `POST` | `/api/follows/{userId}` | Seguir a un usuario. |

| **Notificaciones** | - | - |
| ------------- | --- | --- |
| `GET` | `/api/notifications/{userId}` | Obtener notificaciones de un usuario.|

| **Mensajes Directos** | - | - |
| ------------- | --- | --- |
| `POST` | `/api/messages` | Enviar un mensaje directo. |
| `GET` | `/api/messages/{conversationId}` | Obtener los mensajes de una conversación. |


## 🛡️ Autenticación y Seguridad
La API utiliza JWT (JSON Web Tokens) para autenticación. Los usuarios deben autenticarse para poder acceder a la mayoría de los endpoints. La configuración de seguridad en Spring Security garantiza que solo los usuarios autorizados puedan realizar acciones como publicar Blabs, enviar mensajes o dar "me gusta".


## 🚧 Estado del proyecto
Este proyecto está en desarrollo y se están agregando funcionalidades adicionales y mejoras en la seguridad. Contribuciones, sugerencias y reportes de problemas son bienvenidos.


## 📜 Licencia
Este proyecto está bajo la MIT License. Puedes ver los detalles en el archivo LICENSE.


## 🤝 Contribuciones
Haz un fork del proyecto.
Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
Haz commit de tus cambios (git commit -m 'Agregar nueva funcionalidad').
Haz push a la rama (git push origin feature/nueva-funcionalidad).
Abre un Pull Request.


## 💙🧡 ¡Gracias por usar Blabber! Con esta API, esperamos crear una experiencia de red social robusta y escalable para usuarios y desarrolladores 🚀.