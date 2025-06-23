// lib/app.ts

import * as cdk from 'aws-cdk-lib';
import { BackendStack } from './backend-stack';
import { FoundationStack } from './foundation-stack';
// import { FrontendStack } from './frontend-stack';

const app = new cdk.App();

new FoundationStack(app, 'EMS-Foundation', {
  env: { region: 'us-west-2' }
});

new BackendStack(app, 'EMS-Backend', {
  env: { region: 'us-west-2' }
});

// new FrontendStack(app, 'EMS-Frontend', {
//   env: { region: 'us-west-2' }
// });
