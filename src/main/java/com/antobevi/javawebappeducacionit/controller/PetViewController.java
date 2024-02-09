package com.antobevi.javawebappeducacionit.controller;

import com.antobevi.javawebappeducacionit.model.Pet;
import com.antobevi.javawebappeducacionit.service.OwnerService;
import com.antobevi.javawebappeducacionit.service.PetService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger.*;

@Controller
@Data
@RequestMapping("/pets")
public class PetViewController {
    @Autowired
    private PetService petService;
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String redirectToPets() {

        return "redirect:/pets/list";
    }

    @GetMapping("/list")
    public String listPets(Model model) {
        List<Pet> pets = petService.listPets();
        model.addAttribute("pets", pets);

        return "pets";
    }

    @GetMapping("/new")
    public String getFormNewPet(Model model) {
        model.addAttribute("owners", ownerService.listOwners());
        model.addAttribute("pet", new Pet());

        return "newPetForm";
    }

    @PostMapping("/add")
    public String addNewPet(@ModelAttribute Pet pet, @RequestParam(name = "ownerId") Long ownerId) {
        petService.savePet(pet, ownerId);

        java.util.logging.Logger.getLogger("log").info("Nombre mascota: " + pet.getName());
        java.util.logging.Logger.getLogger("log").info("Nombre dueño: " + pet.getOwner().toString());
        java.util.logging.Logger.getLogger("log").info("ID dueño: " + pet.getOwner().getId().toString());

        return "redirect:/pets/list";
    }

    @GetMapping("/delete/{petId}") // El DeleteMapping se usa al hacer un controlador REST
    public String deletePet(@PathVariable(name = "petId") Long petId) {
        petService.deletePet(petId);

        return "redirect:/pets/list";
    }

    @GetMapping("/update/{petId}") // Model es lo que le enviamos a la vista (el front)
    public String getFormUpdatePet(@PathVariable(name = "petId") Long petId, Model model) {
        Pet pet = petService.getPetById(petId);
        model.addAttribute("pet", pet);
        model.addAttribute("owners", ownerService.listOwners()); // Por si se quiere actualizar el dueño

        return "updatePet";
    }

    @PostMapping("/update/{petId}") // ModelAttribute es el modelo que recibimos de la vista
    public String updatePet(@ModelAttribute Pet updatedPet, @PathVariable(name = "petId") Long petId, @RequestParam(name = "owner") Long ownerId) {
        updatedPet.setOwner(ownerService.getOwnerById(ownerId));
        petService.updatePet(petId, updatedPet);

        return "redirect:/pets/list";
    }

}