package com.springservice.models;

import com.springservice.forms.UserForm;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_table")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String hashPassword;

    private String firstName;
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

    public static Users from(UserForm form) {
        return Users.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();
    }
}
