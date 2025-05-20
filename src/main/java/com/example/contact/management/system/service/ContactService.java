package com.example.contact.management.system.service;


import com.example.contact.management.system.modal.Contact;
import com.example.contact.management.system.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact addContact(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(String id){
        return contactRepository.findById(id);
    }

    public Contact updateContact(String id,Contact contact){
        contact.setId(id);
        return contactRepository.save(contact);
    }

    public void deleteContact(String id){
        contactRepository.deleteById(id);
    }

    public List<Contact> searchContactsByName(String name){
        return contactRepository.findByNameContainingIgnoreCase(name);
    }

    public Contact searchByPhone(String phone){
        return contactRepository.findByPhone(phone);
    }
}
