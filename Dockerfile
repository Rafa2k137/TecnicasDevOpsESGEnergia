# ETAPA 1 — Build com Maven (gera o .jar)
FROM maven:3.9.9-eclipse-temurin-21 AS builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml e baixa dependências (cache otimizado)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código fonte e gera o pacote .jar
COPY app/src ./src
RUN mvn clean package -DskipTests


# ETAPA 2 — Runtime (executa o .jar gerado)
FROM eclipse-temurin:21-jdk

# Define diretório de execução
WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta que o Spring Boot usa
EXPOSE 8080

# Define o comando de execução da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
