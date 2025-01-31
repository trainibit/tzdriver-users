package com.trainibit.tzdriver_users.request;

import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Timestamp;
import java.util.UUID;
@Data
public class UserRequest {

    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;
}