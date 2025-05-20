package com.example.contact.management.system.repository;

import com.example.contact.management.system.modal.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact,String> {

    List<Contact> findByNameContainingIgnoreCase(String name);
    Contact findByPhone(String phone);
}
