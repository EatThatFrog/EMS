// lib/backend-stack.ts

import * as cdk from 'aws-cdk-lib';
import { Construct } from 'constructs';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import * as apigateway from 'aws-cdk-lib/aws-apigateway';

export class BackendStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    const backend = new lambda.Function(this, 'BackendLambda', {
      runtime: lambda.Runtime.JAVA_17,
      code: lambda.Code.fromAsset('../backend/target/backend.jar'),
      handler: 'com.example.StreamLambdaHandler::handleRequest',
      memorySize: 1024,
      timeout: cdk.Duration.seconds(30),
    });

    new apigateway.LambdaRestApi(this, 'APIGateway', {
      handler: backend,
    });
  }
}
