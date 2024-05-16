### Frontend

Desarrollado con Angular 17. Para ejecutarlo en desarrollo se necesita tener instalado Node ejecutar:

    npm i
    npm run start

### Backend

Desarrollado con Java 17 y springboot.
Antes de ejecutarlo/compilarlo hay que cambiar los datos de conexión a la base de datos en el archivo application.yaml

### Ejecutar con Docker

Para ejecutar el proyecto usando Docker, abra una terminal de comandos en la raiz del proyecto (el mismo directorio de este archivo) y ejecute las siguientes instrucciones:

Configurar la red para la comunicación entre contenedores

    docker network create medellin-times-net

Iniciar la base de datos

    docker run --net medellin-times-net --name medellin-times-db -e MYSQL_ROOT_PASSWORD=password -d -p 3306:3306 mysql
    docker exec medellin-times-db /bin/sh -c 'mysql -u root -ppassword < ./dump.sql'

Configure la conexión entre el backend y la DB dirigiéndose al archivo `backend\src\main\resources\application.yaml` y cambiando la url y el username por:

    url: jdbc:mysql://medellin-times-net:3306/medellin_times
    username: root

Ejecute el back

    docker build -t medellin-times-be-image ./backend
    docker run --net medellin-times-net --name medellin-times-be -d -p 8080:8080 medellin-times-be-image

Ejecutar el front

    docker build -t medellin-times-fe-image ./frontend
    docker run --net medellin-times-net --name medellin-times-fe -d -p 4200:4200 medellin-times-fe-image

Finalmente, puede abrir la aplicación en http://localhost:4200
