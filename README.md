# Finance App – Backend

Backend de una aplicación web para la **gestión de finanzas personales**, que permite registrar ingresos y gastos, administrar categorías y consultar balances mensuales.

Este proyecto forma parte de mi portafolio personal y está desarrollado con **Spring Boot** siguiendo buenas prácticas de diseño y arquitectura.

---

## 🚀 Tecnologías utilizadas

* **Java 17**
* **Spring Boot 4**

    * Spring Web
    * Spring Data JPA
    * Spring Security
    * Spring Validation
* **MySQL**
* **JWT** para autenticación
* **Springdoc OpenAPI (Swagger)** para documentación
* **Maven** como gestor de dependencias

---

## 📂 Arquitectura

El proyecto está organizado siguiendo una estructura inspirada en **DDD (Domain-Driven Design)**, separando responsabilidades por capas y contextos.

Incluye componentes compartidos como:

* Estrategia personalizada de nombres de tablas (snake_case + plural)
* Configuración centralizada de OpenAPI

---

## ⚙️ Configuración del entorno

### 1️⃣ Variables de entorno

Este proyecto utiliza variables de entorno para manejar credenciales y secretos.

Crea un archivo `.env` en la raíz del proyecto (no se incluye en el repositorio):

```env
DB_USERNAME=root
DB_PASSWORD=root
JWT_SECRET=your-secret-key
```

### 2️⃣ application.properties

Las propiedades sensibles se cargan desde variables de entorno:

```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

authorization.jwt.secret=${JWT_SECRET}
authorization.jwt.expiration.days=7
```

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/Gaboo04/finance-app-backend.git
   ```

2. Configurar la base de datos MySQL local.

3. Crear el archivo `.env` con las credenciales necesarias.

4. Ejecutar el proyecto:

   ```bash
   mvn spring-boot:run
   ```

La aplicación se iniciará por defecto en:

```
http://localhost:8080
```

---

## 📑 Documentación de la API

La documentación interactiva está disponible mediante **Swagger UI**:

```
http://localhost:8080/swagger-ui/index.html
```

Incluye:

* Descripción de endpoints
* Esquemas de request/response
* Autenticación mediante JWT

---

## 🔐 Seguridad

* Autenticación basada en **JWT (Bearer Token)**
* Integración con Spring Security
* Configuración documentada en Swagger

---

## 📌 Estado del proyecto

🚧 En desarrollo

Próximas funcionalidades:

* CRUD de ingresos y gastos
* Gestión de categorías
* Balance mensual
* Integración con frontend Angular

---

## 👤 Autor

**Gabriel Braithuaite**
Estudiante de Ingeniería de Software

Este proyecto es parte de mi preparación para **prácticas preprofesionales**.
