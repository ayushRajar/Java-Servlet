# Setup Instructions for Java Servlet & JSP Web Application

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Tomcat (or any Servlet container)
- Java Servlet API JAR (if running standalone)
- Visual Studio Code (recommended)

## Project Structure
- `src/` - Java source files (servlets, main app)
- `build/webapp/` - JSP files and web resources
- `build/webapp/WEB-INF/web.xml` - Servlet and JSP configuration
- `bin/` - Compiled Java classes

## Setup Steps

1. **Clone or Download the Project**
   - Place the project folder in your workspace.

2. **Add Servlet API JAR**
   - If using Tomcat, this is included automatically.
   - If running standalone, download `javax.servlet-api.jar` and place it in the `lib/` directory.

3. **Compile the Java Source Files**
   ```powershell
   javac -d bin -cp "lib/*" src/servlets/*.java src/App.java
   ```

4. **Deploy to Tomcat**
   - Copy the contents of `build/webapp/` to your Tomcat `webapps/YourAppName/` directory.
   - Or configure your IDE to deploy the project.

5. **Start Tomcat**
   - Run Tomcat using `startup.bat` (Windows) or `startup.sh` (Linux/Mac).

6. **Access the Application**
   - Open your browser and go to: `http://localhost:8080/YourAppName/login.jsp`

## Usage
- Login with username: `admin`, password: `admin`.
- Use the calculator after successful login.

## Troubleshooting
- Ensure the Servlet API JAR is in your classpath if you see import errors.
- Check Tomcat logs for deployment or runtime errors.

## Author
Generated and documented by GitHub Copilot.
