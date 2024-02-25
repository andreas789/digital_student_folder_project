package gr.aueb.mscis.educore.service.school.impl;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.school.impl.GuardianDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.OwnerDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.StudentDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.TeacherDaoImpl;
import gr.aueb.mscis.educore.service.school.SchoolManagementService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SchoolManagementServiceImpl implements SchoolManagementService {
    @Inject
    OwnerDaoImpl ownerDao;
    @Inject
    GuardianDaoImpl guardianDao;
    @Inject
    TeacherDaoImpl teacherDao;
    @Inject
    StudentDaoImpl studentDao;

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerDao.saveOrUpdate(owner);
    }

    @Override
    public void deleteOwner(Long ownerId){
        ownerDao.deleteById(ownerId);
    }

    @Override
    public List<Owner> searchOwners(SearchParameters params) {
        return ownerDao.search(params);
    }

    @Override
    public Owner findOwnerById(Long id) {
        return ownerDao.findOne(id);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherDao.saveOrUpdate(teacher);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        teacherDao.deleteById(teacherId);
    }

    @Override
    public List<Teacher> searchTeachers(SearchParameters params) {
        return teacherDao.search(params);
    }

    @Override
    public Teacher findTeacherById(Long id) {
        return teacherDao.findOne(id);
    }

    @Override
    public Guardian saveGuardian(Guardian guardian) {
        return guardianDao.saveOrUpdate(guardian);
    }

    @Override
    public void deleteGuardian(Long guardianId) {
        guardianDao.deleteById(guardianId);
    }

    @Override
    public List<Guardian> searchGuardians(SearchParameters params) {
        return guardianDao.search(params);
    }

    @Override
    public Guardian findGuardianById(Long id) {
        return guardianDao.findOne(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveOrUpdate(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentDao.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(SearchParameters params) {
        return studentDao.search(params);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentDao.findOne(id);
    }

    public void setOwnerDao(OwnerDaoImpl ownerDao) {
        this.ownerDao = ownerDao;
    }

    public void setGuardianDao(GuardianDaoImpl guardianDao) {
        this.guardianDao = guardianDao;
    }

    public void setTeacherDao(TeacherDaoImpl teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }
}
