package org.harshita.ems.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@DynamoDbBean
public class EmsItem {
    private String pk;
    private String sk;

    private String name;
    private String email;
    private String deptId;
    private String doj;
    private String title;
    private Integer salary;

    // GSI1
    private String gsi1pk;
    private String gsi1sk;

    // GSI2
    private String gsi2pk;
    private Integer gsi2sk;

    @DynamoDbPartitionKey
    public String getPk() { return pk; }
    public void setPk(String pk) { this.pk = pk; }

    @DynamoDbSortKey
    public String getSk() { return sk; }
    public void setSk(String sk) { this.sk = sk; }

    @DynamoDbSecondaryPartitionKey(indexNames = {"GSI1"})
    public String getDeptId() { return deptId; }
    public void setDeptId(String deptId) { this.deptId = deptId; }

    @DynamoDbSecondarySortKey(indexNames = {"GSI1"})
    public String getDoj() { return doj; }
    public void setDoj(String doj) { this.doj = doj; }

    @DynamoDbSecondaryPartitionKey(indexNames = {"GSI2"})
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @DynamoDbSecondarySortKey(indexNames = {"GSI2"})
    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }

    // Optional fields
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
