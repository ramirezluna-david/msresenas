package com.edutech.msresenas.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class UserDTO {
    private int idUser;
    private String username;
    private String password;
}
