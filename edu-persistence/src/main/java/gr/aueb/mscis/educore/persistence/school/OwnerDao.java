package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.persistence.GenericDao;

public interface OwnerDao extends GenericDao<Owner> {


    Owner saveOwner(Owner owner);
}
