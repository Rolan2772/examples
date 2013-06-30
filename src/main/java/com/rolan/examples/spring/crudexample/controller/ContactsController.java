package com.rolan.examples.spring.crudexample.controller;

import com.rolan.examples.spring.crudexample.dao.ContactsDao;
import com.rolan.examples.spring.crudexample.entity.Contact;
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
    private ContactsDao contactsDao;

    @RequestMapping(value = {"/", "/viewAllContacts"})
    public ModelAndView getAllContacts() {
        ModelAndView mv = new ModelAndView("/showContacts");
        List<Contact> contacts = contactsDao.getAllContacts();
        mv.addObject("contacts", contacts);
        return mv;
    }

    @RequestMapping(value = "/contactDetail", method = RequestMethod.GET)
    public ModelAndView editContact(@RequestParam(required = false) Long id) {
        Contact contact = (id == null) ? new Contact() : contactsDao.getContact(id);
        return new ModelAndView("contactDetail", "contact", contact);
    }

    @RequestMapping(value = "/contactDetail", method = RequestMethod.POST)
    public String editContact(@ModelAttribute @Valid Contact contact, BindingResult result) {
        String view = "redirect:/viewAllContacts";
        if (result.hasErrors()) {
            view = "/contactDetail";
        } else {
            contactsDao.update(contact);
        }
        return view;
    }

    @RequestMapping(value = "/deleteContact")
    public String deleteContact(@RequestParam final Long id) {
        contactsDao.delete(id);
        return "redirect:/viewAllContacts";
    }
}
