/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolan.examples.spring.crudexample;

import com.rolan.examples.spring.crudexample.dao.Contact;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rolan Burykin
 */
@Controller
public class CRUDController {
    
    @Autowired
    private ContactsDao contactsDao;
    
    @RequestMapping(value = "/viewAllContacts")
    public ModelAndView getAllContacts() {
        ModelAndView mv = new ModelAndView("/showContacts");
        List<Contact> contacts = contactsDao.getAllContacts();
        mv.addObject("contacts", contacts);
        return mv;
    }
    
    @RequestMapping(value = "/createContact", method = RequestMethod.GET)
    public ModelAndView createContact() {
        return new ModelAndView("/createContact", "contact", new Contact());
    }
    
    @RequestMapping(value = "/createContact", method = RequestMethod.POST)
    public String createContact(@ModelAttribute @Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "/createContact";
        } else {
            contactsDao.save(contact);
            return "redirect:/viewAllContacts";
        }
    }
    
    @RequestMapping(value = "/updateContact", method = RequestMethod.GET)
    public ModelAndView editContact(@RequestParam Long id) {
        Contact contact = contactsDao.getContact(id);
        return new ModelAndView("updateContact", "contact", contact);
    }
    
    @RequestMapping(value = "/updateContact", method = RequestMethod.POST)
    public String editContact(@ModelAttribute @Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "/updateContact";
        } else {
            contactsDao.update(contact);
            return "redirect:/viewAllContacts";
        }
    }
    
    @RequestMapping(value = "/deleteContact")
    public String deleteContact(@RequestParam Long id) {
        contactsDao.delete(id);
        return "redirect:/viewAllContacts";
    }
}