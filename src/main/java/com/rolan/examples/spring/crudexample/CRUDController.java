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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(value = "/addContact", method = RequestMethod.GET)
    public ModelAndView createContactForm() {
        return new ModelAndView("/createContact", "contact", new Contact());
    }
    
    @RequestMapping(value = "/createContact", method = RequestMethod.POST)
    public String createContact(@ModelAttribute @Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "/createContact";
        } else {
            return "redirect:viewAllContacts";
        }
    }
}