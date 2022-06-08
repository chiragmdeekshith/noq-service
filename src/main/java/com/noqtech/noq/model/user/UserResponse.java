package com.noqtech.noq.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private String fullName;
    private String emailId;
    private String phone;
    private String message;
}
