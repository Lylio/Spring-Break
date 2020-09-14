package com.lylechristine.emergencycontacts.controller;

import javax.validation.Valid;

import com.lylechristine.emergencycontacts.entity.Contact;
import com.lylechristine.emergencycontacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts/")
public class ContactController {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Contact contact) {
        return "add-contact";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addContact(@Valid Contact contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-contact";
        }

        contactRepository.save(contact);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contactee Id:" + id));
        model.addAttribute("contact", contact);
        return "update-contact";
    }

    @PostMapping("update/{id}")
    public String updateContact(@PathVariable("id") long id, @Valid Contact contact, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            contact.setId(id);
            return "update-contact";
        }

        contactRepository.save(contact);
        model.addAttribute("contacts", contactRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteContact(@PathVariable("id") long id, Model model) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        contactRepository.delete(contact);
        model.addAttribute("contacts", contactRepository.findAll());
        return "index";
    }
}

