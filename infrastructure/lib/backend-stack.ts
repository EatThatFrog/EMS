import * as path from 'path';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import * as apigateway from 'aws-cdk-lib/aws-apigateway';
import { Duration, Stack, StackProps } from 'aws-cdk-lib';
import { Construct } from 'constructs';

export class BackendStack extends Stack {
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    const backendLambda = new lambda.Function(this, 'BackendLambda', {
      runtime: lambda.Runtime.JAVA_17,
      handler: 'com.harshita.ems.StreamLambdaHandler::handleRequest',
      code: lambda.Code.fromAsset(
        path.join(__dirname, '../../backend/libs/lambda')
      ),
      memorySize: 1024,
      timeout: Duration.seconds(30)
    });

    new apigateway.LambdaRestApi(this, 'APIGateway', {
      handler: backendLambda,
    });
  }
}
