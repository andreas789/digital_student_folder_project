package gr.aueb.mscis.educore.service.school;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.model.school.Teacher;

import java.util.List;

public interface SchoolManagementService {
    Owner saveOwner(Owner owner);
    void deleteOwner(Long ownerId);
    List<Owner> searchOwners(SearchParameters params);
    Owner findOwnerById(Long id);

    Teacher saveTeacher(Teacher teacher);
    void deleteTeacher(Long teacherId);
    List<Teacher> searchTeachers(SearchParameters params);
    Teacher findTeacherById(Long id);

    Guardian saveGuardian(Guardian guardian);
    void deleteGuardian(Long guardianId);
    List<Guardian> searchGuardians(SearchParameters params);
    Guardian findGuardianById(Long id);

    Student saveStudent(Student student);
    void deleteStudent(Long studentId);
    List<Student> searchStudents(SearchParameters params);
    Student findStudentById(Long id);


}
