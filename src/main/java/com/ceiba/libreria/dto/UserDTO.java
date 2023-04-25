package com.ceiba.libreria.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private String name;
    private Long id;
    private LocalDate birthDate;

    public UserDTO(String name, Long id, LocalDate birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthDate=" + birthDate +
                '}';
    }
}
