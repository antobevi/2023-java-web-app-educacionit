package com.antobevi.javawebappeducacionit.service;

import com.antobevi.javawebappeducacionit.model.Owner;
import com.antobevi.javawebappeducacionit.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
En esta capa Servicio es donde ponemos toda la logica de negocio, como por ejemplo,
listar todos los dueños con mas de 2 mascotas.
*/

@Service
public class OwnerService {
    @Autowired // En lugar de hacer un new, usamos el Autowired que nos permite instanciarlo.
    private OwnerRepository ownerRepository;

    public List<Owner> listOwners() {
        return ownerRepository.findAll(); // Metodo heredado que encuentra todas las entidades usando la interfaz
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found."));
    }

}