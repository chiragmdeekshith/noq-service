package com.noqtech.noq.entity;

import com.noqtech.noq.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "NOQ_USER")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONE")
    private String phone;

    public User(UserDto userDto) {
        this.emailId = userDto.getEmailId();
        this.fullName = userDto.getFullName();
        this.password = userDto.getPassword();
        this.phone = userDto.getPhone();
    }
}
