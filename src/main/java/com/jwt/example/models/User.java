package com.jwt.example.models;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;

    private String name;

    private String email;

}
