package com.skillcapital.leads;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Ensuring this field is not null
    private String name;

    @Column(nullable = false) // Ensuring this field is not null
    private String cc;

    @Column(nullable = false) // Ensuring this field is not null
    private String phone;

    @Column(nullable = false, unique = true) // Unique and not null
    private String email;

    @Column(nullable = false) // Ensuring this field is not null
    private double feeQuoted;

    @Column(nullable = false) // Ensuring this field is not null
    private String batchTiming;

    @Column(nullable = true) // Can be null if not required
    private String description;

    @Column(nullable = false) // Ensuring this field is not null
    private String leadStatus;

    @Column(nullable = false) // Ensuring this field is not null
    private String leadSource;

    @Column(nullable = true) // Can be null if not required
    private String stack;

    @Column(nullable = false) // Ensuring this field is not null
    private String course;

    @Column(nullable = false) // Ensuring this field is not null
    private String classMode;

    @Column(nullable = true) // Can be null if not required
    private String nextFollowUp;
}
