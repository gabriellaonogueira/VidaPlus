# Vida_Plus

Esta aplicação é uma API desenvolvida em **Java** utilizando o framework **Spring Boot**. Ela tem como objetivo gerenciar informações relacionadas a pacientes e médicos em um ambiente hospitalar. A aplicação utiliza diversas tecnologias e práticas modernas, como **Lombok**, **JWT** para autenticação, e testes unitários com **JUnit**.

---

## **Funcionalidades**

### **Pacientes**
- **Consultar todos os pacientes**: Retorna uma lista de pacientes cadastrados.
- **Consultar paciente por ID**: Retorna os dados de um paciente específico.
- **Cadastrar paciente**: Permite o cadastro de um novo paciente.
- **Editar paciente**: Atualiza os dados de um paciente existente.
- **Inativar paciente**: Marca um paciente como inativo.

### **Médicos**
- **Consultar todos os médicos**: Retorna uma lista de médicos cadastrados.
- **Consultar médicos por ID**: Retorna os dados de médicos.
- **Cadastrar médicos**: Permite o cadastro de um novo médico.
- **Editar médicos**: Atualiza os dados de um médico existente.
- **Inativar médicos**: Marca um médico como inativo.

### **Consultas**
- **Agendar Consulta**: Retorna um JSON com os dados do agendamento.
- **Cancelar Consulta**: É possível adicionar motivo do cancelamento.
- **Validações para Consulta**: Regras de negócio para o agendamento de consultas, como exemplo: o horário de funcionamento da clínica e disponibilidade médica.


### **Exames**
- **Agendar Exames**: Retorna um JSON com os dados do agendamento.
- **Validações para Consulta**: Regras de negócio para o agendamento de exames, como exemplo: o horário de funcionamento da clínica e disponibilidade médica.
---

## **Tecnologias Utilizadas**
- **Java 17**
- **Spring Boot**
    - Spring Data JPA
    - Spring Security (JWT)
    - Spring Web
- **Lombok**: Reduz a verbosidade do código, gerando automaticamente getters, setters, builders, etc.
- **Maven**: Gerenciamento de dependências.
- **JUnit 5**: Framework para testes unitários.
---

## **Autenticação**
A aplicação utiliza **JWT (JSON Web Token)** para autenticação e autorização. O token é gerado no login e deve ser enviado no cabeçalho `Authorization` em todas as requisições protegidas.

---

## **Principais Endpoints**

### **Pacientes**
| Método | Endpoint                               | Descrição                          |
|--------|----------------------------------------|------------------------------------|
| GET    | `http://localhost:8080/pacientes`      | Lista todos os pacientes.          |
| GET    | `http://localhost:8080/pacientes/{id}` | Consulta um paciente por ID.       |
| POST   | `http://localhost:8080/pacientes`      | Cadastra um novo paciente.         |
| PUT    | `http://localhost:8080/pacientes`      | Edita os dados de um paciente.     |
| DELETE | `http://localhost:8080/pacientes/{id}` | Inativa um paciente.               | 

### **Médicos**
| Método | Endpoint                              | Descrição                    |
|--------|---------------------------------------|------------------------------|
| GET    | `http://localhost:8080/medicos`       | Lista todos os médicos.      |
| GET    | `http://localhost:8080/medicos/{id}`  | Consulta um médico por ID.   |
| POST   | `http://localhost:8080/medicos`       | Cadastra um novo médico.     |
| PUT    | `http://localhost:8080/medicos`       | Edita os dados de um médico. |
| DELETE | `http://localhost:8080/medicos/{id}`  | Inativa um médico.           |

### **Consultas**
| Método | Endpoint                             | Descrição                              |
|--------|--------------------------------------|----------------------------------------|
| POST   | `http://localhost:8080/consultas`    | Agendar uma nova consulta.             |
| DELETE | `http://localhost:8080/consultas`    | Cancela uma consulta.                  |

### **Exames**
| Método | Endpoint                       | Descrição              |
|--------|--------------------------------|------------------------|
| POST   | `http://localhost:8080/exames` | Agendar um novo exame. |
| DELETE | `http://localhost:8080/exames` | Cancela um exame.      |

## **Testes**

### **Testes Unitários**
A aplicação possui cobertura de testes unitários utilizando **JUnit 5**. Os testes verificam o comportamento dos serviços e garantem a integridade das regras de negócio.

- **JUnit** é utilizado para estruturar e executar os testes.

### **Exemplos de Testes**
- **Pacientes**:
    - Consultar pacientes.
    - Cadastrar paciente com dados válidos.
    - Cadastrar paciente com dados inválidos (ex.: CPF nulo).
    - Editar paciente.
    - Inativar paciente.
  
- **Médicos**:
    - Consultar médicos.
    - Cadastrar médico com dados válidos.
    - Editar médico.
    - Inativar médico.
  
- **Consultas**:
    - Agendar consulta com dados válidos.
    - Agendar consultas de um mesmo paciente no mesmo dia.
    - Agendar consulta no domingo.
    - Agendar consulta as 5:00.
    - Cancelar consulta.
  
- **Exames**:
    - Agendar exame com dados válidos.
    - Agendar exame de um mesmo paciente no mesmo dia.
    - Agendar exame no domingo.
    - Agendar exame as 5:00.

---

## **Como Executar**

1. **Pré-requisitos**:
    - Java 17+
    - IntelliJ IDEA
    - Maven
    - Banco de dados configurado - MySQL

2. **Clonar o repositório**:
   https://github.com/gabriellaonogueira/VidaPlus

3. **Configurar o banco de dados**:
   Verifique o arquivo application.properties ou application.yml para garantir que a conexão com vidaplus_api está correta.

4. **Executar a aplicação**:
   mvn spring-boot:run
