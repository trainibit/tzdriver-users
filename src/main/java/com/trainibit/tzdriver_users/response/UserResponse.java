package com.trainibit.tzdriver_users.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;
@Data
public class UserResponse {

    //Datos que queremos exponber y enviaremos al cliente
    private UUID uuid;
    private String name;
    private String phoneNumber;
    private String phone_number;

    public String registeredAt;  // Exponer como String directamente
    private Boolean active;

    public Timestamp updatedAt;

}
