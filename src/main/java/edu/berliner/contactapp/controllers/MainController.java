package edu.berliner.contactapp.controllers;

import edu.berliner.contactapp.models.Contact;
import edu.berliner.contactapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController
{
    @Autowired
    ContactRepository contactRepo;

    @GetMapping("/")
    public String home()
    {
        return "index";
    }

    @GetMapping("/index")
    public String homepage(Model model)
    {
        return "index";
    }

    @GetMapping("/addcontact")
    public String addContact(Model model)
    {
        model.addAttribute("contact", new Contact());
        return "addcontact";
    }

    @PostMapping("/addcontact")
    public String submitContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "addcontact";
        }
        contactRepo.save(contact);
        return "confirmadd";
    }

    @GetMapping("/listcontacts")
    public String listContacts(Model model)
    {
        model.addAttribute("contacts", contactRepo.findAll());
        return "listcontacts";
    }

    @GetMapping("/updatecontact/{id}")
    public String updateContact(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("contact", contactRepo.findOne(id));
        //System.out.println(id);
        return "addcontact";
    }


}
