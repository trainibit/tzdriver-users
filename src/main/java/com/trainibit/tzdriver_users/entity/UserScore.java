package com.trainibit.tzdriver_users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_scores")
public class UserScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//SEQUENCE, generator = "user_scores_id_gen")
//    @SequenceGenerator(name = "user_scores_id_gen", sequenceName = "user_scores_id_seq", allocationSize = 1)
//    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ColumnDefault("0")
    @Column(name = "communication", nullable = false)
    private Integer communication;

    @ColumnDefault("0")
    @Column(name = "cleanning", nullable = false)
    private Integer cleanning;

    @ColumnDefault("0")
    @Column(name = "punctuality", nullable = false)
    private Integer punctuality;

    @ColumnDefault("0")
    @Column(name = "cordiality", nullable = false)
    private Integer cordiality;

    @ColumnDefault("0.0")
    @Column(name = "total_score", nullable = false, precision = 2, scale = 1)
    private BigDecimal totalScore;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "registered_at", nullable = false)
    private Instant registeredAt;

    @Column(name = "comments", nullable = false, length = Integer.MAX_VALUE)
    private String comments;

}