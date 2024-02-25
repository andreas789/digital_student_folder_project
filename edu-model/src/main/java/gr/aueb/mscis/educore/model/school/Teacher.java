package gr.aueb.mscis.educore.model.school;

import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.model.core.Person;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {
    String speciality;
    Integer experienceInYears;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    public Teacher() {}

    public String getSpeciality() {return this.speciality;}

    public Integer getExperienceInYears() {return this.experienceInYears;}

    public User getUser() {return this.user;}

    public void setSpeciality(String speciality) {this.speciality = speciality; }

    public void setExperienceInYears(Integer experienceInYears) {this.experienceInYears = experienceInYears; }

    public void setUser(User user) {this.user = user; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Teacher)) return false;
        final Teacher other = (Teacher) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$speciality = this.getSpeciality();
        final Object other$speciality = other.getSpeciality();
        if (this$speciality == null ? other$speciality != null : !this$speciality.equals(other$speciality)) return false;
        final Object this$experienceInYears = this.getExperienceInYears();
        final Object other$experienceInYears = other.getExperienceInYears();
        if (this$experienceInYears == null ? other$experienceInYears != null : !this$experienceInYears.equals(other$experienceInYears)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Teacher;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $speciality = this.getSpeciality();
        result = result * PRIME + ($speciality == null ? 43 : $speciality.hashCode());
        final Object $experienceInYears = this.getExperienceInYears();
        result = result * PRIME + ($experienceInYears == null ? 43 : $experienceInYears.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }
}
