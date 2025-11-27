# Spring Batch - Asynchronous Processing

## 📖 Overview

This project demonstrates **asynchronous processing** techniques in Spring Batch for optimizing job performance. It's based on the Udemy course "Otimização de desempenho para jobs Spring Batch" (Performance Optimization for Spring Batch Jobs).

**Course Link**: https://www.udemy.com/course/otimizacao-de-desempenho-para-jobs-spring-batch/

## 🚀 Features

- **Data Migration**: Processes and migrates data from CSV files to a MySQL database
- **Asynchronous Processing**: Implements parallel processing strategies to improve performance
- **Spring Batch**: Leverages Spring Batch framework for robust batch processing
- **Two-Step Migration**: 
  - Migrates person data (`pessoas.csv`)
  - Migrates bank account data (`dados_bancarios.csv`)

## 🛠️ Technologies

- **Java 8**
- **Spring Boot 2.3.0**
- **Spring Batch**
- **MySQL**
- **Maven**
- **Docker** (for database setup)

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/springbatch/migracaodados/
│   │       ├── config/          # DataSource configuration
│   │       ├── dominio/         # Domain entities (Pessoa, DadosBancarios)
│   │       ├── job/             # Job configuration
│   │       ├── processor/       # Item processors
│   │       ├── reader/          # CSV readers
│   │       ├── step/            # Step configurations
│   │       └── writer/          # Database writers
│   └── resources/
│       ├── application.properties
│       └── docker-compose.yml
└── files/
    ├── pessoas.csv              # Person data input
    ├── dados_bancarios.csv      # Bank account data input
    └── scripts.sql              # Database scripts
```

## 🐳 Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- Docker and Docker Compose (for MySQL)

### Setup Database

1. Navigate to the resources directory:
   ```cmd
   cd src\main\resources
   ```

2. Start the MySQL database using Docker Compose:
   ```cmd
   docker-compose up -d
   ```

### Build the Project

```cmd
mvnw clean install
```

### Run the Application

```cmd
mvnw spring-boot:run
```

## 📊 How It Works

The application performs data migration in two main steps:

1. **Person Migration Step**: Reads person data from `pessoas.csv` and writes to the database
2. **Bank Account Migration Step**: Reads bank account data from `dados_bancarios.csv` and writes to the database

Both steps leverage asynchronous processing techniques to optimize performance and throughput.

## 📝 Configuration

Database and application settings can be configured in `src/main/resources/application.properties`.

## 📚 Learning Objectives

- Understand Spring Batch concepts and architecture
- Implement asynchronous processing patterns
- Optimize batch job performance
- Handle large-scale data migration scenarios

## 📄 License

This project is for educational purposes based on the Udemy course materials.

## 🤝 Contributing

This is an educational project. Feel free to fork and experiment with different optimization techniques!
