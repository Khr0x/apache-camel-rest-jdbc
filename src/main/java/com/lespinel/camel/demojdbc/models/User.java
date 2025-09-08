package com.lespinel.camel.demojdbc.models;

import lombok.Data;
import lombok.ToString;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@ToString
@Data
public class User {
    private int id;
    private String name;
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Timestamp getCreatedat() { return createdAt; }
    public void setCreatedat(Timestamp createdat) { this.createdAt = createdat; }

    public Timestamp getUpdatedat() { return updatedAt; }
    public void setUpdatedat(Timestamp updatedat) { this.updatedAt = updatedat; }

}