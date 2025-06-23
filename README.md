# Employee Management System (EMS)

A serverless application built with Spring Boot and AWS Lambda.

## Project Structure

- `backend/` - Spring Boot application that runs on AWS Lambda
- `infrastructure/` - AWS CDK code for deploying the application

## Backend

To build the backend:

```bash
cd backend
./gradlew clean build
```

This will create a ZIP file in `backend/build/dist/backend.zip` that can be deployed to AWS Lambda.

## Infrastructure

To deploy the application to AWS:

```bash
cd infrastructure
npm install
npm run build
cdk deploy
```

## API Endpoints

- `GET /hello` - Returns a greeting message
- `GET /ping` - Returns a pong message

## Development

The application is built with:

- Spring Boot 3.2.3
- Java 17
- Gradle 8.5
- AWS CDK
