# Cadastro de tarefas usando

## Requisitos para rodar o projeto

-   [JDK](https://www.oracle.com/br/java/technologies/javase-downloads.html)
-   [JRE](https://www.oracle.com/java/technologies/javase-jre8-downloads.html)
-   [eclipse](https://www.eclipse.org/downloads/)
-   [git](https://git-scm.com/downloads)
-   [postgresql](https://www.postgresql.org/download/)
-   [Tomcat 9.0](https://tomcat.apache.org/download-90.cgi)

# Como clonar o Projeto

Primeiro é importanter ter todos os requisitos instalados e/ou baixados em sua maquina
em seguida abra seu eclipse

clique em file e em seguida vá até import
![imgur](https://i.imgur.com/KToE00Y.png)

Procure a opcao git e clique na opcao projects from git with smart import
![Imgur](https://i.imgur.com/u6Ig1mY.png)
Clique na opcao clone url
![Imgur](https://i.imgur.com/U62n87i.png)
preencha a uri do repositorio com o link https://github.com/carlos0406/teste-esig-jsf.git
![Imgur](https://i.imgur.com/asQyC16.png)
Apenas clique em next até chegar nessa tela e clique em finish
![Imgur](https://i.imgur.com/asQyC16.png)
faça a estração ou instale o tomcat 9 na pasta desejada
e em seguida clique na opcao servers disponivel no menu inferior
![Imgur](https://i.imgur.com/z3FIeZF.png)
Clique na opcao de criar um novo server,na pasta apache escolha a versão 9 do tomcat e em seguida aponte o diretorio da instalação e clique em finish
![Imgur](https://i.imgur.com/QhoRN0Y.png)
![Imgur](https://i.imgur.com/qMBJqCT.png)
Com o botão direito clique em cima do servidor tomcat que está disponivel no menu inferior e escolha a opcao add and remove, clique duas vezes com o botão esquerdo no projeto teste-esig-jsf e depois clique em finish
![Imgur](https://i.imgur.com/ICaIC15.png)
![Imgur](https://i.imgur.com/CSNYvhv.png)
Dentro do arquivo persistence.xml localizado em /src/meta-info é importante usar as credencias do seu banco postgres, e caso deseje mudo o nome da base de dados(nome atual teste), além disso é importante criar um banco de dados com o nome que você está usando no persistence.xml ex:teste, as tabelas serão criadas pelo hibernate.
depois de criar o banco de dados é só acessar a url http://localhost:8080/teste/
