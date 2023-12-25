package com.antobevi.javawebappeducacionit.repository;

import com.antobevi.javawebappeducacionit.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> { // Se pasa Clase, Id por parametro

    // TODO: Implementar metodos personalizados de busqueda para OwnersRepository

}
