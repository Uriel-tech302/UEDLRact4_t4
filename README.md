# Actividad 4 - API REST con Spring Boot, Spring Security y JWT
# Nombre - Uriel Espinoza de la Rosa

## Introducción
Este proyecto consiste en el desarrollo de una API REST robusta y segura construida con **Spring Boot**. A diferencia de un CRUD tradicional, esta API responde exclusivamente en formato JSON y separa completamente la lógica del backend. Implementa un sistema de seguridad real utilizando **Spring Security y JWT (JSON Web Tokens)** para proteger los endpoints, además de usar **DTOs** (Data Transfer Objects) y validaciones (`@Valid`) para asegurar que los datos que ingresan a la base de datos (MySQL) sean íntegros y correctos.

## Enlace del Despliegue en VPS
La API se encuentra desplegada, funcionando de manera independiente y conectada a su propia base de datos en un servidor VPS:
* **URL Base de la API:** `http://94.130.98.27:2758`

---

## Evidencias de Funcionamiento (Pruebas en Bruno)
A continuación se muestran las capturas de las peticiones HTTP probadas directamente contra el VPS, demostrando el flujo de autenticación y el CRUD protegido.

### 1. Registro de Usuario (`POST /api/auth/register`)
> **Descripción:** Este endpoint permite crear un nuevo usuario en la base de datos. La contraseña se encripta automáticamente (usando BCrypt) antes de guardarse para garantizar la seguridad.
<img width="1920" height="1200" alt="Registro_VPS" src="https://github.com/user-attachments/assets/334ebebf-54b1-4345-a824-f39344221993" />

### 2. Login y Generación de Token JWT (`POST /api/auth/login`)
> **Descripción:** Al enviar las credenciales correctas, el servidor autentica al usuario y devuelve un token JWT generado de forma dinámica. Este token será la "llave" obligatoria para consumir los endpoints del CRUD.
<img width="1920" height="1200" alt="Inicio_VPS" src="https://github.com/user-attachments/assets/ae1c7396-78a2-4afa-be05-6a3486cbb80a" />


### 3. Crear Estudiante protegido (`POST /api/v1/students`)
> **Descripción:** Permite registrar un nuevo estudiante. Los datos de entrada son filtrados por el `StudentDto` y la anotación `@Valid` (bloqueando campos vacíos o correos inválidos). Requiere enviar el JWT como Bearer Token.
<img width="1920" height="1200" alt="Students_Post_VPN" src="https://github.com/user-attachments/assets/06f4dae3-85bd-441e-bd6d-85dbc8d3a232" />


### 4. Consultar Estudiantes (`GET /api/v1/students`)
> **Descripción:** Devuelve la lista completa de estudiantes guardados en la base de datos del VPS en formato JSON. Si la petición no incluye un token JWT válido, es rechazada automáticamente por el filtro de seguridad.
<img width="1920" height="1200" alt="Student_VPS" src="https://github.com/user-attachments/assets/73d67eda-807f-4abb-a95d-951af2817b9c" />


### 5. Actualizar Estudiante (`PUT /api/v1/students/{id}`)
> **Descripción:** Permite modificar los datos de un registro existente apuntando a su ID en la URL. La petición está validada y protegida por el mismo mecanismo de seguridad.
<img width="1920" height="1200" alt="Student_2_VPS" src="https://github.com/user-attachments/assets/b4d77df7-966f-43a3-b764-cd78e1437de3" />


### 6. Eliminar Estudiante (`DELETE /api/v1/students/{id}`)
> **Descripción:** Elimina un estudiante de la base de datos mediante su ID. Devuelve el código de estado HTTP correspondiente (200 OK) al completar la operación autorizada.
<img width="1920" height="1200" alt="DeleteStudent_VPS" src="https://github.com/user-attachments/assets/cb17f88a-1527-4c72-acab-3b73ba9808fc" />
<img width="1920" height="1200" alt="Student_VPS_Delete" src="https://github.com/user-attachments/assets/e126fca9-1621-4560-af3c-013141c7a6dc" />

---

## Conclusión
Con la integración de seguridad por tokens JWT, encriptación de contraseñas y el manejo estricto de datos de entrada mediante DTOs, esta API REST cuenta con un nivel de desarrollo profesional. El sistema funciona de manera estable en un entorno de producción (servidor remoto VPS) y está preparado para ser consumido de manera segura por cualquier aplicación frontend en el futuro.
