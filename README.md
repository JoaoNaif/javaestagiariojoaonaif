# Sistema de Hotéis - Reserva de Quartos

Este é um sistema de gerenciamento de reservas de quartos para hotéis. O projeto foi desenvolvido utilizando **Java 21+** e requer **Docker** e **Docker Compose** para ser executado corretamente.

## 📌 Requisitos
Antes de iniciar, certifique-se de ter instalado em sua máquina:

- **Java 21+**
- **Docker**
- **Docker Compose**
- **Maven** (caso precise instalar dependências manualmente)

## 🚀 Clonando o Repositório
Você pode clonar o repositório usando **SSH** ou **HTTPS**:

### Clonar via SSH:
```sh
git clone git@bitbucket.org:joaonaif/javaestagiariojoaovictornaif.git
```

### Clonar via HTTPS:
```sh
git clone https://joaonaif-admin@bitbucket.org/joaonaif/javaestagiariojoaovictornaif.git
```

## 📦 Instalando Dependências
O projeto utiliza **Maven** para gerenciamento de dependências. Para garantir que todas as dependências estejam instaladas, execute:

```sh
mvn clean install
```

## 🐳 Subindo os Containers Docker
Antes de rodar a aplicação, é necessário iniciar os containers Docker. Para isso, execute:

```sh
docker compose up -d
```

Esse comando iniciará os containers em **modo detached** (em segundo plano).

## ▶️ Executando o Projeto
Com os containers em execução, você pode iniciar o projeto utilizando o Maven:

```sh
mvn spring-boot:run
```

Isso iniciará a aplicação e a tornará acessível conforme as configurações definidas.

## 📜 Executando Consultas SQL
Se precisar rodar o arquivo `query.sql` diretamente no banco de dados, utilize o seguinte comando:

```sh
cat query.sql | docker exec -i eclipse_hotel_postgres psql -U admin -d eclipse_hotel
```

Esse comando executa as queries contidas no arquivo `query.sql` dentro do container do **PostgreSQL**.

## 📝 Contribuição
Sinta-se à vontade para contribuir com melhorias para este projeto. Qualquer sugestão ou correção são bem-vindas!

---

## 🔥 Minhas Sugestões para o Tech Lead condutor da dinâmica:

- **Separar o DDD do número de telefone** em `Customers`.
- **Criar autenticação para Customer**, utilizando **Spring Security** e **JWT**.
- **Criar um serviço programado (Scheduled Service)** para gerenciar o status **ABSENCE** em `Reservation`.
- **Criar rotas para check-in e check-out**, para ativar o status **IN_USE** em `Reservation`.

---

Desenvolvido por **João Naif** 🚀

