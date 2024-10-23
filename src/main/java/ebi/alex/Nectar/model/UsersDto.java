package ebi.alex.Nectar.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UsersDto {
    private Long id;
    private String username;
    private String password;
    private String email;
}
