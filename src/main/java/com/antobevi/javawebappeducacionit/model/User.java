package com.antobevi.javawebappeducacionit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data // LOMBOK provee toString, equals, hashcode, getters y setters (me ahorra codigo)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`User`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", nullable = false)
    private Long id;
    @NotBlank(message = "Se debe ingresar un nombre.")
    @Column(name="`name`")
    private String name;
    @NotBlank(message = "Se debe ingresar un apellido.")
    @Column(name="`surname`")
    private String surname;
    @NotBlank(message = "Se debe ingresar un nombre de usuario.")
    @Column(name="`username`")
    private String username;
    @NotBlank(message = "Se debe ingresar una contraseña.")
    @Column(name="`password`")
    private String password;

}