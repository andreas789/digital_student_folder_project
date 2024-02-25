package gr.aueb.mscis.educore.model.school;

import com.google.common.base.Strings;
import gr.aueb.mscis.educore.model.core.CoreEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course extends CoreEntity {
    String name;
    String code;
    String description;
    Integer maxParticipants;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    Teacher teacher;

    public Course() {}


    public boolean isValidForPersistence() {
        return Objects.nonNull(maxParticipants)&& maxParticipants>0 &&
                !Strings.isNullOrEmpty(name)&&
                !Strings.isNullOrEmpty(code);
    }

    public String getName() {return this.name;}

    public String getCode() {return this.code;}

    public String getDescription() {return this.description;}

    public Integer getMaxParticipants() {return this.maxParticipants;}

    public Teacher getTeacher() {return this.teacher;}

    public void setName(String name) {this.name = name; }

    public void setCode(String code) {this.code = code; }

    public void setDescription(String description) {this.description = description; }

    public void setMaxParticipants(Integer maxParticipants) {this.maxParticipants = maxParticipants; }

    public void setTeacher(Teacher teacher) {this.teacher = teacher; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Course)) return false;
        final Course other = (Course) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$code = this.getCode();
        final Object other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) return false;
        final Object this$maxParticipants = this.getMaxParticipants();
        final Object other$maxParticipants = other.getMaxParticipants();
        if (this$maxParticipants == null ? other$maxParticipants != null : !this$maxParticipants.equals(other$maxParticipants)) return false;
        final Object this$teacher = this.getTeacher();
        final Object other$teacher = other.getTeacher();
        if (this$teacher == null ? other$teacher != null : !this$teacher.equals(other$teacher)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Course;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $code = this.getCode();
        result = result * PRIME + ($code == null ? 43 : $code.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $maxParticipants = this.getMaxParticipants();
        result = result * PRIME + ($maxParticipants == null ? 43 : $maxParticipants.hashCode());
        final Object $teacher = this.getTeacher();
        result = result * PRIME + ($teacher == null ? 43 : $teacher.hashCode());
        return result;
    }
}
