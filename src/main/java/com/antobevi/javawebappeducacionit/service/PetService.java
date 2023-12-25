package com.antobevi.javawebappeducacionit.service;

import com.antobevi.javawebappeducacionit.model.Owner;
import com.antobevi.javawebappeducacionit.model.Pet;
import com.antobevi.javawebappeducacionit.repository.OwnerRepository;
import com.antobevi.javawebappeducacionit.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private OwnerRepository ownerRepository; // Antes de buscar una mascota, necesitamos buscar el dueño

    public List<Pet> listPets() {
        //Sort sortBy = Sort.by(Sort.Direction.DESC, "name").ignoreCase();
        return petRepository.findAllOrderByNameIgnoreCaseDesc();
    }

    public Pet savePet(Pet pet, Long ownerId) {
        // Buscamos el dueño y si no lo encuentra tira una excepcion
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found."));
        pet.setOwner(owner);
        return petRepository.save(pet);
    }

    // Operaciones CRUD
    public void deletePet(Long id) {
        // Optional declara un espacio de memoria que puede estar presente o no, si encontramos el dato lo almacena y si no, queda vacio.
        Optional<Pet> petOptional =  petRepository.findById(id);

        if(petOptional.isPresent()) {
            petRepository.delete(petOptional.get());
        } else {
            throw new RuntimeException("Pet not found."); // Arrojamos excepcion
        }
    }

    public void updatePet(Long id, Pet updatedPet) {
        Optional<Pet> petOptional =  petRepository.findById(id);

        if(petOptional.isPresent()) {
            Pet pet = petOptional.get();
            pet.setName(updatedPet.getName());
            pet.setAge(updatedPet.getAge());
            pet.setSpecies(updatedPet.getSpecies()); // Se puede omitir ya que la especie no es algo que cambie, salvo que se haya cargado por error
            pet.setOwner(updatedPet.getOwner());

            petRepository.save(pet); // El framework pisa lo que ya esta cargado, no lo duplica
        } else {
            throw new RuntimeException("Pet to update not found."); // Arrojamos excepcion
        }
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found."));
    }

}
