package com.trainibit.tzdriver_users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//SEQUENCE, generator = "users_id_gen")
//    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
//    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "registered_at", nullable = false)
    private Instant registeredAt;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "user")
    private List<UserScore> userScores = new ArrayList<>();

}