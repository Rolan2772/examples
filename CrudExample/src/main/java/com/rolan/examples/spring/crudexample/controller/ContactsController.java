package com.rolan.examples.spring.crudexample.controller;

import com.rolan.examples.spring.crudexample.entity.Contact;
import com.rolan.examples.spring.crudexample.service.CrudService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactsController {

    @Autowired
    private CrudService contactsService;

    @RequestMapping(value = {"/", "/contacts/viewAllContacts"})
    public ModelAndView getAllContacts() {
        ModelAndView mv = new ModelAndView("/contacts/showContacts");
        List<Contact> contacts = contactsService.getAllContacts();
        mv.addObject("contacts", contacts);
        return mv;
    }

    @RequestMapping(value = "/contacts/contactDetail", method = RequestMethod.GET)
    public ModelAndView editContact(@RequestParam(required = false) Long id) {
        Contact contact = (id == null) ? new Contact() : contactsService.getContactById(id);
        return new ModelAndView("contacts/contactDetail", "contact", contact);
    }

    @RequestMapping(value = "/contacts/contactDetail", method = RequestMethod.POST)
    public String editContact(@ModelAttribute @Valid Contact contact, BindingResult result) {
        String view = "redirect:/contacts/viewAllContacts";
        if (result.hasErrors()) {
            view = "contacts/contactDetail";
        } else {
            contactsService.update(contact);
        }
        return view;
    }

    @RequestMapping(value = "/contacts/deleteContact")
    public String deleteContact(@RequestParam final Long id) {
        contactsService.delete(id);
        return "redirect:/contacts/viewAllContacts";
    }
}
