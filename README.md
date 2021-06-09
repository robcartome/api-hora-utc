# API REST para obtener la Hora en UTC
Recibe una fecha,hora y TimeZone del lugar de donde estamos, Para luego Responder La hora UTC.

## Routes / Urls:

- Responde con la hora UTC según zona enviada:  
  | POST | http://server_name/api/utc

# Respuesta de la API rest

Se obtiene la hora UTC de un response De una Api Rest.
Ejemplo:

Recibe:         
{
"fecha":"2021-06-08 10:18:45",  
"zona":"+3"  
}

Respuesta:          
{
  "reponse": {
          "time": "07:18:45",
          "zoneTime": "UTC".
  }
}

## Tecnologías usadas
- Spring boot: V 2.5.0
- Language: Java 8                            

## Instalación
Pasos Para Correr en Local ( en la terminal ).
- Clonar el repositorio: git clone https://github.com/robcartome/api-hora-utc.git 
- Instalar las tecnologias para usar el Framework Spring.       
- Ejecutar para correr la api en el servidor, eventualmente corre en el puerto (http://localhost:8080):                                                          
-> .\mvnw.cmd spring-boot:run   


## Autores ✒️

- **Robert Tolentino** - _Trabajo Inicial_ - [robcartome](https://github.com/robcartome)
