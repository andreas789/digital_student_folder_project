package gr.aueb.mscis.educore.service.school.impl;

import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;

import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.school.impl.GuardianDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.OwnerDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.TeacherDaoImpl;
import gr.aueb.mscis.educore.service.school.RegistrationService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Inject
    OwnerDaoImpl ownerDao;
    @Inject
    TeacherDaoImpl teacherDao;
    @Inject
    GuardianDaoImpl guardianDao;

    @Override
    public Owner registerOwner(Owner owner) {
        return ownerDao.saveOwner(owner);
    }

    @Override
    public Teacher registerTeacher(Teacher teacher) {

        return teacherDao.saveTeacher(teacher);
    }

    @Override
    public Guardian registerGuardian(Guardian guardian) {
        return guardianDao.saveGuardian(guardian);
    }

    public void setOwnerDao(OwnerDaoImpl ownerDao) {
        this.ownerDao = ownerDao;
    }

    public void setTeacherDao(TeacherDaoImpl teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void setGuardianDao(GuardianDaoImpl guardianDao) {
        this.guardianDao = guardianDao;
    }
}
