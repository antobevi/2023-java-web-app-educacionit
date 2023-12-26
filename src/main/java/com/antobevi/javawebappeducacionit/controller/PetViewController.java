package com.antobevi.javawebappeducacionit.controller;

import com.antobevi.javawebappeducacionit.model.Pet;
import com.antobevi.javawebappeducacionit.service.OwnerService;
import com.antobevi.javawebappeducacionit.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/pets")
public class PetViewController {
    @Autowired
    private PetService petService;
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String redirectToPets() {

        return "redirect:/api/pets/list";
    }

    @GetMapping("/list")
    public String listPets(Model model) {
        List<Pet> pets = petService.listPets();
        model.addAttribute("pets", pets);

        return "list-pets";
    }

    @GetMapping("/new-pet")
    public String getFormNewPet(Model model) {
        model.addAttribute("owners", ownerService.listOwners());
        //model.addAttribute("pet", new Pet());

        return "new-pet-form";
    }

    @PostMapping("/add")
    public String addPet(@ModelAttribute Pet pet, @RequestParam Long ownerId) {
        petService.savePet(pet, ownerId);

        return "redirect:/api/pets/list";
    }

    // TODO: Buscar diferencias entre PathVariable y RequestParam
    @GetMapping("/delete/{id}") // El DeleteMapping se usa al hacer un controlador REST
    public String deletePet(@PathVariable Long petId) {
        petService.deletePet(petId);

        return "redirect:/api/pets/list";
    }

    @GetMapping("/update/{id}") // Model es lo que le enviamos a la vista (el front)
    public String getFormUpdatePet(@PathVariable Long petId, Model model) {
        Pet pet = petService.getPetById(petId);
        model.addAttribute("pet", pet);
        model.addAttribute("owners", ownerService.listOwners()); // Por si se quiere actualizar el dueño

        return "update-pet-form";
    }

    @PostMapping("/update/{id}") // ModelAttribute es el modelo que recibimos de la vista
    public String updatePet(@PathVariable Long petId, @ModelAttribute Pet updatedPet, @RequestParam Long ownerId) {
        updatedPet.setOwner(ownerService.getOwnerById(ownerId));
        petService.updatePet(petId, updatedPet);

        return "redirect:/api/pets/list";
    }

}