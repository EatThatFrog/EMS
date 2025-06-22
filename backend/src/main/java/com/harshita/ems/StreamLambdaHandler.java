package com.harshita.ems;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.testutils.Timer;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
// Import the specific SpringBootLambdaContainerHandler
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamLambdaHandler implements RequestStreamHandler {

    // Change the type to SpringBootLambdaContainerHandler
    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    static {
        try {
            Timer.start("HandlerInit");
            // Use the static factory method getAwsProxyHandler
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(EmployeeManagementBackendApplication.class);
            Timer.stop("HandlerInit");
        } catch (ContainerInitializationException e) {
            // if we fail here. We lose context for the exception to be logged
            // as it would be re-thrown and caught by the container.
            // We should print the stack trace so that it appears in CloudWatch logs.
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}