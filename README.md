# WeatherApp

# API de Datos Meteorológicos

## Descripción

Esta aplicación utiliza tecnología Java y el framework Spring Boot para crear una API que obtiene y entrega datos meteorológicos de la API externa OpenWeatherMap. La API ofrece datos meteorológicos actuales y pronósticos para ciudades especificadas, implementando funcionalidades como caché de datos, limitación de tasa, autenticación y autorización de usuarios, almacenamiento en base de datos y documentación automática con Swagger.

## Requisitos Previos

Asegúrate de tener instalados los siguientes componentes antes de configurar y ejecutar el proyecto:

- Java JDK 8 o superior
- Maven
- Docker (opcional para contener la base de datos)
- Postman (para probar los endpoints)
- Visual Studio Code u otro IDE

## Requisitos previos

Asegúrate de tener instalados los siguientes componentes antes de configurar y ejecutar el proyecto:

- [Java JDK 8 o superior](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Docker](https://www.docker.com/get-started)
- [Maven](https://maven.apache.org/download.cgi)
- [Postman](https://www.postman.com/downloads/)
- [Visual Studio Code](https://code.visualstudio.com/download) o tu IDE preferido

## Configuración y ejecución del proyecto

1. **Clonar el Repositorio:**
   ```shell
   git clone https://github.com/Santi980923/WeatherApp.git
   ```
2. **Dirirgirse a la carpeta proyecto**
   ```shell
   git clone https://github.com/Santi980923/WeatherApp.git
   ```
3. **Empaquetar la aplicación (omitir pruebas para mayor rapidez)**
```bash
./mvnw clean package -DskipTests
```
4. **Construir contenedor Docker**
```bash
 docker-compose build
```
5. **Iniciar la aplicación y la base de datos**
```bash
 docker-compose up
```

## Ejemplos de Solicitudes y Respuestas

### Registro

#### Registro usuario (POST http://localhost:8080/auth/register)

- **Solicitud(usuario ADMIN):**
#### Cuerpo (Body):
```json
{
   "username": "santi2309",
   "password": "123456",
   "lastname": "espitia",
   "firstname": "santiago",
   "country": "Colombia",
   "role": "ADMIN"
}
```
**Response**
```json
{
   "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJOaWNvbGFzMjYwNCIsImlhdCI6MTcwMDQ5MjI1NCwiZXhwIjoxNzAwNDkzNjk0fQ.NMdpYIDa2d0tcXzb5Nbk00funLVlyb0dVUFqP6T-N8Y"
}
```

- **Solicitud(usuario USER):**
#### Cuerpo (Body):
```json
{
   "username": "santi2309",
   "password": "123456",
   "lastname": "espitia",
   "firstname": "santiago",
   "country": "Colombia"
}
```
**Response**
```json
{
   "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJOaWNvbGFzMjYwNCIsImlhdCI6MTcwMDQ5MjI1NCwiZXhwIjoxNzAwNDkzNjk0fQ.NMdpYIDa2d0tcXzb5Nbk00funLVlyb0dVUFqP6T-N8Y"
}
```
### Login

#### Registro usuario (POST http://localhost:8080/auth/login)
- Cuerpo (Body):
```json
{
   "username": "iva@gmail.com",
   "password": "123456"
}
```
**Response**
```json
{
"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJOaWNvbGFzMjYwNCIsImlhdCI6MTcwMDQ5MjI1NCwiZXhwIjoxNzAwNDkzNjk0fQ.NMdpYIDa2d0tcXzb5Nbk00funLVlyb0dVUFqP6T-N8Y"
}
```
### Informacion Meteorlogica

#### Obtener Clima Actual (GET http://localhost:8080/weather/current/nombre_ciudad)
- Requiere un Token JWT en el encabezado de autorización (Bearer Token) obtenido al hacer Login.
#### (GET http://localhost:8080/weather/current/London)
- Response:
```json
{
   "base": "stations",
   "coord": {
      "lon": -0.1257,
      "lat": 51.5085
   },
   "weather": [
      {
         "id": 803,
         "main": "Clouds",
         "description": "broken clouds",
         "icon": "04d"
      }
   ],
   "main": {
      "temp": 11.67,
      "feels_like": 10.93,
      "temp_min": 10.02,
      "temp_max": 12.86,
      "pressure": 1007.0,
      "humidity": 78.0
   },
   "visibility": 10000,
   "wind": {
      "speed": 4.12,
      "deg": 300.0
   },
   "clouds": {
      "all": 75.0
   },
   "sys": {
      "type": 2,
      "id": 2075535,
      "country": "GB",
      "lat": null,
      "sunrise": 1700465184,
      "sunset": 1700496358
   },
   "timezone": 0.0,
   "id": 2643743,
   "name": "London",
   "cod": 200
}
```

#### Obtener pronostico del clima de 5 días para una ciudad designada. (GET http://localhost:8080/weather/forecast/nombre_ciudad)
- Requiere un Token JWT en el encabezado de autorización (Bearer Token) obtenido al hacer Login.
#### (GET http://localhost:8080/weather/forecast/bogota)
- Response:
```json
{
   "cod": "200",
   "message": 0.0,
   "cnt": 40,
   "list": [
      {
         "dt": 1700503200,
         "main": {
            "temp": 17.83,
            "feels_like": 17.6,
            "temp_min": 16.03,
            "temp_max": 17.83,
            "pressure": 1024.0,
            "humidity": 74.0,
            "sea_level": 1024.0,
            "grnd_level": 754.0,
            "temp_kf": 1.8
         },
         "weather": [
            {
               "id": 501,
               "main": "Rain",
               "description": "moderate rain",
               "icon": "10d"
            }
         ],
         "clouds": {
            "all": 79.0
         },
         "wind": {
            "speed": 0.68,
            "deg": 250.0,
            "gust": 1.35
         },
         "visibility": 10000,
         "pop": 0,
         "sys": {
            "pod": "d"
         },
         "dt_txt": "2023-11-20 18:00:00"
      },
      {
         "dt": 1700514000,
         "main": {
            "temp": 16.13,
            "feels_like": 15.99,
            "temp_min": 14.83,
            "temp_max": 16.13,
            "pressure": 1019.0,
            "humidity": 84.0,
            "sea_level": 1019.0,
            "grnd_level": 752.0,
            "temp_kf": 1.3
         },
         "weather": [
            {
               "id": 501,
               "main": "Rain",
               "description": "moderate rain",
               "icon": "10d"
            }
         ],
         "clouds": {
            "all": 91.0
         },
         "wind": {
            "speed": 0.52,
            "deg": 219.0,
            "gust": 1.38
         },
         "visibility": 8292,
         "pop": 0,
         "sys": {
            "pod": "d"
         },
         "dt_txt": "2023-11-20 21:00:00"
      },
      "....................................",
      {
         "dt": 1700924400,
         "main": {
            "temp": 16.07,
            "feels_like": 15.38,
            "temp_min": 16.07,
            "temp_max": 16.07,
            "pressure": 1017.0,
            "humidity": 63.0,
            "sea_level": 1017.0,
            "grnd_level": 756.0,
            "temp_kf": 0.0
         },
         "weather": [
            {
               "id": 803,
               "main": "Clouds",
               "description": "broken clouds",
               "icon": "04d"
            }
         ],
         "clouds": {
            "all": 84.0
         },
         "wind": {
            "speed": 0.9,
            "deg": 137.0,
            "gust": 2.16
         },
         "visibility": 10000,
         "pop": 0,
         "sys": {
            "pod": "d"
         },
         "dt_txt": "2023-11-25 15:00:00"
      }
   ],
   "city": {
      "id": 3688689,
      "name": "Bogota",
      "coord": {
         "lon": -74.0817,
         "lat": 4.6097
      },
      "country": "CO",
      "population": 1000000,
      "timezone": -18000.0,
      "sunrise": 1700477108,
      "sunset": 1700519940
   }
}
```
#### Obtener Contaminación del Aire para una ciudad actual. (GET http://localhost:8080/weather/airpollution/nombre_ciudad)
- Requiere un Token JWT en el encabezado de autorización (Bearer Token) obtenido al hacer Login.
#### (GET http://localhost:8080/weather/airpollution/bogota)
- Response:
```json
{
    "coord": {
        "lon": -74.0836,
        "lat": 4.6535
    },
    "list": [
        {
            "main": {
                "aqi": 1
            },
            "components": {
                "co": 250.34,
                "no": 0.68,
                "no2": 2.57,
                "o3": 34.69,
                "so2": 0.5,
                "pm2_5": 3.73,
                "pm10": 5.94,
                "nh3": 1.33
            },
            "dt": 1.700494249E9
        }
    ]
}
```
#### Limitación de tasa a la API
- Si se sobrepasa el limite de 100 solicitudes por hora se llega al siguiente mensaje:

```json
{
   "Se ha excedido el limite de solicitudes. Por favor, intentelo de nuevo mas tarde.""
}

