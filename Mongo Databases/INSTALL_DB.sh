#!/bin/bash

# Cria a imagem customizada copiando as bases de dados
docker build -t mongodb/1.0 . 
echo "Imagem personalizada criada.."

# Cria o container baseado na imagem criada anteriormente
docker run -d --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=fabricio -e MONGO_INITDB_ROOT_PASSWORD=fabricio666 mongodb/1.0
echo "Container inicializado.."

# importando as bases de dados
mongoimport --uri "mongodb://fabricio:fabricio666@localhost:27017/admin?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false" alunos.json

mongoimport --uri "mongodb://fabricio:fabricio666@localhost:27017/admin?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false" professores.json
echo "Bases de dados importadas.."






