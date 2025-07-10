import * as path from 'path';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import * as apigateway from 'aws-cdk-lib/aws-apigateway';
import { Duration, Stack, StackProps } from 'aws-cdk-lib';
import { Construct } from 'constructs';
import * as iam from 'aws-cdk-lib/aws-iam'

export class BackendStack extends Stack {
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    const backendLambda = new lambda.Function(this, 'BackendLambda', {
      functionName: 'EmsBackend',
      runtime: lambda.Runtime.JAVA_17,
      handler: 'org.harshita.ems.StreamLambdaHandler::handleRequest',
      code: lambda.Code.fromAsset('../backend/build/dist/backend.zip'),
      memorySize: 1024,
      timeout: Duration.seconds(30),
    })

    backendLambda.addToRolePolicy(new iam.PolicyStatement({
      actions: ['dynamodb:*'],
      resources: ['*'],
    }));

    new apigateway.LambdaRestApi(this, 'APIGateway', {
      restApiName: 'BackendAPI',
      handler: backendLambda,
      defaultCorsPreflightOptions: {
        allowOrigins: [
          'http://localhost:5173',
          'https://eatthatfrog.github.io'
        ],
        allowMethods: apigateway.Cors.ALL_METHODS,
        allowHeaders: apigateway.Cors.DEFAULT_HEADERS,
      },
    });
  }
}
