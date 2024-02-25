package gr.aueb.mscis.educore.model.school;

import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.model.core.Person;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "guardians")
public class Guardian extends Person {
    String occupation;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    public Guardian() {}

    public String getOccupation() {return this.occupation;}

    public User getUser() {return this.user;}

    public void setOccupation(String occupation) {this.occupation = occupation; }

    public void setUser(User user) {this.user = user; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Guardian)) return false;
        final Guardian other = (Guardian) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$occupation = this.getOccupation();
        final Object other$occupation = other.getOccupation();
        if (this$occupation == null ? other$occupation != null : !this$occupation.equals(other$occupation)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Guardian;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $occupation = this.getOccupation();
        result = result * PRIME + ($occupation == null ? 43 : $occupation.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }
}
