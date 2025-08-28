
# Dockerized User Service with MySQL

## 🎯 **Objective**

This project demonstrates how to containerize a simple Spring Boot REST API and its MySQL database using Docker and Docker Compose. The application exposes a `/users` endpoint that retrieves data from a MySQL database.

## ✨ **Project Structure**

The project is structured as follows:

  - **`src/main/java/`**: Contains the Spring Boot application's Java source code (e.g., `User.java`, `UserRepository.java`, `UserController.java`).
  - **`src/main/resources/`**: Includes the application configuration (`application.properties`) and the SQL script (`data.sql`) to pre-populate the database.
  - **`Dockerfile`**: A multi-stage build file to create a lightweight Docker image for the Spring Boot application.
  - **`docker-compose.yml`**: Defines and links the two services: the **`app`** (Spring Boot application) and the **`db`** (MySQL database).
  - **`pom.xml`**: The Maven project file managing dependencies.

## 📦 **Deliverables**

  - **Java Source Code**: Located in the `src` directory.
  - **`Dockerfile`**: Defines the application's container image.
  - **`docker-compose.yml`**: Orchestrates the application and database services.
  - **SQL Script**: `src/main/resources/data.sql` to pre-populate the database.

## 🚀 **Getting Started**

### **Prerequisites**

  - **Docker and Docker Compose**: Ensure both are installed and running on your system. You can verify this by running `docker --version` and `docker-compose --version` in your terminal.

### **Run Instructions**

1.  **Navigate to the Project Root**: Open your terminal and change the directory to the project's root folder where the `docker-compose.yml` file is located.

2.  **Build and Run the Services**: Execute the following command to build the Docker image for the Spring Boot application and start both the `app` and `db` services.

    ```bash
    docker-compose up --build
    ```

      - The `--build` flag is crucial. It tells Docker Compose to first build the `app` service's image from the `Dockerfile` before starting the containers.
      - This command will pull the official MySQL image, create a network, and spin up both containers. You will see logs from both services in your terminal.
      - **Note**: The first time you run this, it may take a few minutes as Docker downloads the MySQL image and Maven downloads the project dependencies. Subsequent runs will be much faster.

### **Accessing the API**

Once the services are up and running, the Spring Boot application will be accessible at `http://localhost:8080`.

To test the API, open a new terminal window and use `curl` or a tool like Postman to make a `GET` request to the `/users` endpoint.

```bash
curl http://localhost:8080/users
```

**Expected Output**:
You should receive a JSON array containing the users from the database. The `data.sql` script pre-populates the table with three users.

```json
[
  {
    "id": 1,
    "name": "Alice",
    "email": "alice@example.com"
  },
  {
    "id": 2,
    "name": "Bob",
    "email": "bob@example.com"
  },
  {
    "id": 3,
    "name": "Charlie",
    "email": "charlie@example.com"
  }
]
```

### **Stopping the Services**

When you are finished, you can stop and remove the running containers, networks, and volumes by pressing `Ctrl+C` in the terminal where the `docker-compose up` command is running, and then executing:

```bash
docker-compose down
```

This command cleans up the Docker environment, but the named volume for the database (`mysql-data`) will persist, so your data will be saved for future use. To completely remove the volume and all data, use:

```bash
docker-compose down -v
```