# BiztelAI Web Crawler

A Spring Boot-based web crawler application that allows you to start a crawl job for a given URL and retrieve the list of crawled URLs.

---

## **Features**

1. **Start a Crawl Job**:
   - Provide a `seedUrl` to start crawling.
   - The application extracts all links from the `seedUrl` and stores them.

2. **Get Crawl Status**:
   - Retrieve the status and results of a crawl job using the `jobId`.

3. **DTO Layer**:
   - Uses Data Transfer Objects (DTOs) to decouple the API layer from the entity layer.

4. **Swagger UI**:
   - Interactive API documentation available at `/swagger-ui.html`.

5. **Database Integration**:
   - Stores crawl results in a MySQL database.

---

## **Technologies Used**

- **Spring Boot**: Backend framework.
- **Spring Data JPA**: For database operations.
- **MySQL**: Database to store crawl results.
- **Jsoup**: HTML parsing library for web crawling.
- **Lombok**: For reducing boilerplate code.
- **Swagger**: API documentation.
- **Maven**: Build tool.

---

## **Prerequisites**

1. **Java 21**: Ensure Java 21 is installed.
2. **MySQL**: Ensure MySQL is installed and running.
3. **Maven**: Ensure Maven is installed.

---

## **Setup and Running the Application**

### **1. Clone the Repository**
```bash
git clone https://github.com/RajMerai/BiztelAI-Assignment.git
cd biztelai-web-crawler
