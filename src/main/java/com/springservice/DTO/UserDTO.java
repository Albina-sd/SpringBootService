package com.springservice.DTO;

import com.springservice.models.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {
    private String firstName;
    private String lastName;

    public static UserDTO from(Users user){
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
