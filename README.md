# Budget-Tracker-Backend

**To properly use app on your computer, please follow instructions and commands in terminal.**


1. Create and start PostgreSQL container.
   ```cmd
   docker compose up
   ```
2. Clear the *target* directory, build the project and package the resulting JAR file into the *target* directory.

   ```cmd
   .\mvnw.cmd clean package
   ```
3. Run JAR file 
   ```cmd
   java -jar .\target\budget-tracker-backend-0.0.1-SNAPSHOT.jar
   ```