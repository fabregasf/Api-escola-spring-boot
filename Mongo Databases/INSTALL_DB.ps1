<# Esse script é usado no Windows para criação da imagem do MongoDB
e importação das bases de dados - coleções 
  Precisa do arquivo dockercompose.yml
#>

# Cria a imagem customizada copiando as bases de dados
docker build -t mongodb/1.0 . 


# Cria o container baseado na imagem criada anteriormente
docker run -d --name mongodb --mount target=/data/db --name mongodb -v volume1:/tmp -it --link -e MONGO_INITDB_ROOT_USERNAME=fabricio -e MONGO_INITDB_ROOT_PASSWORD=queroserzupper mongodb/1.0

echo "<-- Criado com sucesso"

# importando as bases de dados
<#mongoimport --uri "mongodb://fabricio:fabricio666@localhost:27017/admin?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false" alunos.json

mongoimport --uri "mongodb://fabricio:fabricio666@localhost:27017/admin?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false" professores.json #>


