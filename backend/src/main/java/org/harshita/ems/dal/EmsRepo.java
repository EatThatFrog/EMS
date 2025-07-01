package org.harshita.ems.dal;

import org.harshita.ems.model.EmsItem;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Repository
public class EmsRepo {

    // DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.create();

    // Configure an instance of the standard DynamoDbClient.
    DynamoDbClient standardClient = DynamoDbClient.builder()
            .region(Region.US_WEST_2)
            .credentialsProvider(DefaultCredentialsProvider.builder().build())
            .build();

    // Use the configured standard client with the enhanced client.
    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(standardClient)
            .build();

    final DynamoDbTable<EmsItem> emsTable = enhancedClient.table("EMS", TableSchema.fromBean(EmsItem.class));

    // CRUD
    public EmsItem getEmsItem(String employeeId) {
        return emsTable.getItem(Key.builder().partitionValue(employeeId).build());
    }
}
