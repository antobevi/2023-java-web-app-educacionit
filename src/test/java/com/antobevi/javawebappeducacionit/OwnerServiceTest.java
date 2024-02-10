package com.antobevi.javawebappeducacionit;

import com.antobevi.javawebappeducacionit.model.Owner;
import com.antobevi.javawebappeducacionit.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OwnerServiceTest {
    @Autowired
    private OwnerService ownerService;

    @Test
    public void saveOwnerTest() {
        Owner owner = new Owner();
        owner.setName("Antonella");
        owner.setSurname("Bevilacqua");
        owner.setAddress("maranion 1124");

        Owner savedOwner = ownerService.saveOwner(owner);

        assertNotNull((savedOwner.getId()));
        assertEquals("Antonella", savedOwner.getName());
        assertEquals("Bevilacqua", savedOwner.getSurname());
        assertEquals("maranion 1124", savedOwner.getAddress());
    }

    @Test
    public void listOwnersTest() {
        List<Owner> owners = ownerService.listOwners();

        assertFalse(owners.isEmpty());
    }

    @Test
    public void getOwnerById() {
        Long ownerId = 1L;
        Owner owner = ownerService.getOwnerById(ownerId);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

}