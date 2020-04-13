# EXERCISE 1 BACKEND

## Database configuration

Using docker, run the following command in the same directory where the .yml file is located:
```bash
docker-compose up
```


## Compile & run locally

To compile and run locally we need to use gradle wrapper.
```bash
SPRING_PROFILES_ACTIVE=dev ./gradlew bootrun
```

## Web services testing doc

If you are running IntelliJ IDEA Ultimate edition, you can create, edit, and execute HTTP Requests directly in the 
IntelliJ IDEA code editor. We have all our tests in the **requests** folder and the environments configurations in the 
**requests/rest-client.env.json** file. For more help about this, visit https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html.