package gr.aueb.mscis.educore.model.school;

import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.model.core.Person;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner extends Person {

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    public Owner() {}

    public User getUser() {return this.user;}

    public void setUser(User user) {this.user = user; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Owner)) return false;
        final Owner other = (Owner) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Owner;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }
}
