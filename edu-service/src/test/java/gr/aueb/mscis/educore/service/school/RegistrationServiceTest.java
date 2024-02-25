package gr.aueb.mscis.educore.service.school;

import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import gr.aueb.mscis.educore.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationServiceTest extends EducoreTest {
    RegistrationService registrationService;

    @BeforeEach
    public void setup(){
        registrationService = ServiceFactory.getRegistrationService();
    }

    @Test
    public void registerOwnerTest() {
        Owner owner = DataFactory.getValidOwner();
        owner = registrationService.registerOwner(owner);
        Assertions.assertNotNull(owner.getId());
    }

    @Test
    void registerTeacherTest() {
        Teacher teacher = DataFactory.getValidTeacher();
        teacher = registrationService.registerTeacher(teacher);
        Assertions.assertNotNull(teacher.getId());
    }

    @Test
    void registerGuardianTest() {
        Guardian guardian = DataFactory.getValidGuardian();
        guardian = registrationService.registerGuardian(guardian);
        Assertions.assertNotNull(guardian.getId());
    }

}