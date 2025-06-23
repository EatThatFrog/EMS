# Employee Management System (EMS)

A serverless application built with Spring Boot, React, and AWS Lambda.

## Project Structure

- `backend/` - Spring Boot application that runs on AWS Lambda
- `frontend/` - React application with TypeScript and Vite
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

## Frontend

To run the frontend locally:

```bash
cd frontend
npm install
npm run dev
```

To build the frontend:

```bash
cd frontend
npm install
npm run build
```

## Development

The application is built with:

- Spring Boot 3.2.3
- Java 17
- Gradle 8.5
- React 19
- TypeScript
- Vite
- AWS CDK

## CI/CD

This project uses GitHub Actions for CI/CD:

- **CI Workflow**: Validates backend, frontend, and infrastructure code on pull requests and pushes to main
- **GitHub Pages**: Frontend is automatically deployed to GitHub Pages on pushes to main

You can access the deployed frontend at: https://eatthatfrog.github.io/EMS/
