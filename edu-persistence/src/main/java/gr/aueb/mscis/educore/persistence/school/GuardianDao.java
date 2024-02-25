package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.persistence.GenericDao;

public interface GuardianDao extends GenericDao<Guardian> {
    Guardian saveGuardian(Guardian guardian);
}
