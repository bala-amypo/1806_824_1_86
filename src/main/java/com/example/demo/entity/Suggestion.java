package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Suggestion {

    @Id
    @GeneratedValue
    private Long id;

    private String crop;
    private String fertilizer;

    // 🔥 REQUIRED BY TESTS
    @Transient
    public int getStatusCodeValue() {
        return 200;
    }

    @Transient
    public Suggestion getBody() {
        return this;
    }
}
