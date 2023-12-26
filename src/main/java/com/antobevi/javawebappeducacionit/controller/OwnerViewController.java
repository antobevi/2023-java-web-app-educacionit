package com.antobevi.javawebappeducacionit.controller;

import com.antobevi.javawebappeducacionit.model.Owner;
import com.antobevi.javawebappeducacionit.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/owners")
public class OwnerViewController { // Controlador para una vista ya que estamos haciendo una Web App
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    public String listOwners(Model model) { // Model no refiere a la capa Modelo, si no que es lo que representa nuestra vista
        List<Owner> owners = ownerService.listOwners();
        model.addAttribute("owners", owners);

        return "list-owners";
    }

    @GetMapping("/new-owner") // Formulario para crear un nuevo dueño
    public String getFormNewOwner(Model model) {
        model.addAttribute("owner", new Owner());

        return "new-owner";
    }

    @PostMapping("/add") // Guarda el dueño en la base de datos
    public String addOwner(Owner owner) {
        ownerService.saveOwner(owner);

        return "redirect:/api/owners/list";
    }

}