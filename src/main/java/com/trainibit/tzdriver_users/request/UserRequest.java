package com.trainibit.tzdriver_users.request;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;
@Data
public class UserRequest {
    private String name;
    private String phoneNumber;
    private Timestamp registerAt;
    private Boolean active;
    private UUID uuid;
    private Timestamp updateAt;

}
