package gr.aueb.mscis.educore.service.school;

import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.model.school.Teacher;

public interface RegistrationService {
    Owner registerOwner(Owner owner);
    Teacher registerTeacher(Teacher teacher);
    Guardian registerGuardian(Guardian guardian);

}
