# Employee Management System Backend

A Spring Boot application designed to run on AWS Lambda with API Gateway integration.

## Project Structure

- `src/main/java/com/harshita/ems/EmployeeManagementBackendApplication.java`: Main Spring Boot application class
- `src/main/java/com/harshita/ems/StreamLambdaHandler.java`: AWS Lambda handler for API Gateway integration
- `src/main/java/com/harshita/ems/HelloController.java`: Sample REST controller
- `src/main/resources/application.properties`: Spring Boot configuration
- `build.gradle`: Gradle build configuration

## Prerequisites

- Java 17
- Gradle
- AWS CLI
- AWS CDK

## Building the Application

To build the application, run:

```bash
./gradlew clean build
```

This will create a ZIP file in `build/dist/backend.zip` that can be deployed to AWS Lambda.

## Deployment

To deploy the application to AWS using CDK, run:

```bash
cd ../infrastructure
npm install
npm run build
cdk deploy
```

This will deploy the application to your AWS account using the CDK stack defined in `infrastructure/lib/backend-stack.ts`.

## API Endpoints

- `GET /hello`: Returns a greeting message
- `GET /ping`: Returns a pong message

## Troubleshooting

If you encounter any issues with the Lambda function, check the CloudWatch logs for error messages.
