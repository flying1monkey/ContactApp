package edu.berliner.contactapp.repositories;

import edu.berliner.contactapp.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long>
{
}
