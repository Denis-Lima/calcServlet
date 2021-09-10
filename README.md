# calcServlet

# Projeto da matéria de Laboratório de Engenharia de Software
## Autor: Denis F. Lima.

### Tecnologias e ferramentas

Java - 8  
JPA com Hibernate - 5.5.5  
Servlets - 4.0.1  
Java Server Pages  
Gradle - 7.1.1  
Apache TomCat = 9.0  
MariaDB - 2.7.3


Processo de build (Gradle 7):
1. Criar uma pasta vazia
2. Clonar o repositório com:  
```console
git clone https://github.com/Denis-Lima/calcServlet.git
```
3. Navegar para a pasta calcServlet
4. Executar o comando: 
```console
gradlew build
```
5. Ir na pasta build/libs
6. Copiar o arquivo calcServlet-1.0.war para a pasta webapps do seu TomCat
7. Rodar o TomCat e acessar na sua URL do TomCat, passando a rota /calcServlet-1.0/calculadora
8. Para baixar dependências, utilize o comando:
```console
gradlew dependencies
```

### Video explicativo da entrega
[Video entrega 1](https://www.youtube.com/watch?v=WyqoCjqRQ1Q)
