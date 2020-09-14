package com.lylechristine.emergencycontacts.repository;

import java.util.List;

import com.lylechristine.emergencycontacts.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends CrudRepository <Contact, Long> {
    List<Contact> findByName(String name);
}
