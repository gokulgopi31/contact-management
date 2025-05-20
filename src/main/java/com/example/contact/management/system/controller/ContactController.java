package com.example.contact.management.system.controller;

import com.example.contact.management.system.modal.Contact;
import com.example.contact.management.system.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {


    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        return ResponseEntity.ok(contactService.addContact(contact));
    }

    @GetMapping
    public  ResponseEntity<List<Contact>> getAllContact(){
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Contact> getContactById(@PathVariable String id){
        return contactService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> uodateContact(@PathVariable String id,@RequestBody Contact contact){
        return ResponseEntity.ok(contactService.updateContact(id,contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable String id){
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> searchContactsByName(@RequestParam String name){
        return ResponseEntity.ok(contactService.searchContactsByName(name));
    }

    @GetMapping("/phone")
    public ResponseEntity<Contact> searchByPhone(@RequestParam String phone){
        return ResponseEntity.ok(contactService.searchByPhone(phone));
    }

    public int checking(){
        return 0;
    }
}
