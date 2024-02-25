package gr.aueb.mscis.educore.model.school;

import gr.aueb.mscis.educore.model.core.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person {
    @Column(name = "_condition")
    String condition;

    public Student() {}

    public String getCondition() {return this.condition;}

    public void setCondition(String condition) {this.condition = condition; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$condition = this.getCondition();
        final Object other$condition = other.getCondition();
        if (this$condition == null ? other$condition != null : !this$condition.equals(other$condition)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Student;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $condition = this.getCondition();
        result = result * PRIME + ($condition == null ? 43 : $condition.hashCode());
        return result;
    }
}
