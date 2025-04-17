# Recover data from a folder using a specific file

```sh
# Clone do repositório
git clone https://github.com/ramuspedro/recover-info-from-files

# Acesse o diretório do projeto
cd recover-info-from-files

# Compile e gere o jar
./gradlew clean build

```

## Melhorias

1. Traduzir para inglês

2. Executa a aplicação via Gradle, passando o diretório de entrada e extensão
./gradlew run --args="src/file/name kt"

3. Documentar executável standalone (após gerar o jar)
java -jar build/libs/seu-projeto.jar src/file/name kt
