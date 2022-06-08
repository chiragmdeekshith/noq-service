package com.noqtech.noq.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private String fullName;
    private String emailId;
    private String password;
    private String phone;
}
