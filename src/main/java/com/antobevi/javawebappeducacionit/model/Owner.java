package com.antobevi.javawebappeducacionit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Se debe ingresar un nombre.")
    private String name;
    @NotBlank(message = "Se debe ingresar un apellido.")
    private String surname;
    @NotBlank(message = "Debe tener un direcci//u00F3n.")
    private String address; // TODO: Deberia ser una clase

}