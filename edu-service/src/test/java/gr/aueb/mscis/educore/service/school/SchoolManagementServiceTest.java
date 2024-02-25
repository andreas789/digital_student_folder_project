package gr.aueb.mscis.educore.service.school;

import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.school.*;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import gr.aueb.mscis.educore.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SchoolManagementServiceTest extends EducoreTest {
    SchoolManagementService schoolManagementService;

    @BeforeEach
    public void setup(){
        schoolManagementService = ServiceFactory.getSchoolManagementService();
    }

    @Test
    void saveOwner() {
        Owner owner = DataFactory.getValidOwner();
        owner = schoolManagementService.saveOwner(owner);
        Assertions.assertNotNull(owner.getId());
        Assertions.assertNotNull(owner.getUser().getId());
    }

    @Test
    void deleteOwner() {
        Owner owner = DataFactory.getValidOwner(true);
        Assertions.assertNotNull(owner.getId());

        schoolManagementService.deleteOwner(owner.getId());
        Assertions.assertNull(schoolManagementService.findOwnerById(owner.getId()));
    }

    @Test
    void searchOwners() {
        Owner owner1 = DataFactory.getValidOwner(true);
        Owner owner2 = DataFactory.getValidOwner(true);
        Owner owner3 = DataFactory.getValidOwner(true);

        List<Owner> owners = schoolManagementService.searchOwners(new SearchParameters());
        Assertions.assertEquals(3,owners.size());

    }

    @Test
    void saveTeacher() {
        Teacher teacher = DataFactory.getValidTeacher();
        teacher = schoolManagementService.saveTeacher(teacher);
        Assertions.assertNotNull(teacher.getId());
        Assertions.assertNotNull(teacher.getUser().getId());
    }

    @Test
    void deleteTeacher() {
        Teacher teacher = DataFactory.getValidTeacher(true);
        Assertions.assertNotNull(teacher.getId());

        schoolManagementService.deleteTeacher(teacher.getId());
        Assertions.assertNull(schoolManagementService.findTeacherById(teacher.getId()));
    }

    @Test
    void searchTeachers() {
        Teacher teacher1 = DataFactory.getValidTeacher(true);
        Teacher teacher2 = DataFactory.getValidTeacher(true);
        Teacher teacher3 = DataFactory.getValidTeacher(true);

        List<Teacher> teachers = schoolManagementService.searchTeachers(new SearchParameters());
        Assertions.assertEquals(3,teachers.size());
    }

    @Test
    void saveGuardian() {
        Guardian guardian = DataFactory.getValidGuardian();
        guardian = schoolManagementService.saveGuardian(guardian);
        Assertions.assertNotNull(guardian.getId());
        Assertions.assertNotNull(guardian.getUser().getId());
    }

    @Test
    void deleteGuardian() {
        Guardian guardian = DataFactory.getValidGuardian(true);
        Assertions.assertNotNull(guardian.getId());

        schoolManagementService.deleteGuardian(guardian.getId());
        Assertions.assertNull(schoolManagementService.findGuardianById(guardian.getId()));
    }

    @Test
    void searchGuardians() {
        Guardian guardian1 = DataFactory.getValidGuardian(true);
        Guardian guardian2 = DataFactory.getValidGuardian(true);
        Guardian guardian3 = DataFactory.getValidGuardian(true);

        List<Guardian> guardians = schoolManagementService.searchGuardians(new SearchParameters());
        Assertions.assertEquals(3,guardians.size());
    }

    @Test
    void saveStudent() {
        Student student = DataFactory.getValidStudent();
        student = schoolManagementService.saveStudent(student);
        Assertions.assertNotNull(student.getId());
    }

    @Test
    void deleteStudent() {
        Student student = DataFactory.getValidStudent(true);
        Assertions.assertNotNull(student.getId());

        schoolManagementService.deleteStudent(student.getId());
        Assertions.assertNull(schoolManagementService.findStudentById(student.getId()));
    }

    @Test
    void searchStudents() {
        Student student1 = DataFactory.getValidStudent(true);
        Student student2 = DataFactory.getValidStudent(true);
        Student student3 = DataFactory.getValidStudent(true);

        List<Student> students = schoolManagementService.searchStudents(new SearchParameters());
        Assertions.assertEquals(3,students.size());
    }
}