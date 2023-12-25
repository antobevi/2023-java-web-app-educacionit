package com.antobevi.javawebappeducacionit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data // LOMBOK provee toString, equals, hashcode, getters y setters (me ahorra codigo)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Se debe ingresar un nombre.")
    private String name;
    @Min(value = 0, message = "La edad debe estar entre 0 y 25 años.")
    @Max(value = 25, message = "La edad debe estar entre 0 y 25 años.")
    @NotEmpty(message = "Se debe ingresar una edad.")
    private Integer age;
    @NotBlank(message = "Se debe ingresar la especie.")
    private String species; // especie: perro, gato, etc.
    @ManyToOne
    @NotNull(message = "El dueño no puede estar en blanco")
    private Owner owner; // NotEmpty y NotBlank se usa solo con Strings

}