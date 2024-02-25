package gr.aueb.mscis.educore.model.auth;


import gr.aueb.mscis.educore.model.core.CoreEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sessions")
@Entity
public class Session extends CoreEntity {
    String token;
    Date expiration;
    Date creation;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    public Session() {}

    public String getToken() {return this.token;}

    public Date getExpiration() {return this.expiration;}

    public Date getCreation() {return this.creation;}

    public User getUser() {return this.user;}

    public void setToken(String token) {this.token = token; }

    public void setExpiration(Date expiration) {this.expiration = expiration; }

    public void setCreation(Date creation) {this.creation = creation; }

    public void setUser(User user) {this.user = user; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Session)) return false;
        final Session other = (Session) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        final Object this$expiration = this.getExpiration();
        final Object other$expiration = other.getExpiration();
        if (this$expiration == null ? other$expiration != null : !this$expiration.equals(other$expiration)) return false;
        final Object this$creation = this.getCreation();
        final Object other$creation = other.getCreation();
        if (this$creation == null ? other$creation != null : !this$creation.equals(other$creation)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Session;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        final Object $expiration = this.getExpiration();
        result = result * PRIME + ($expiration == null ? 43 : $expiration.hashCode());
        final Object $creation = this.getCreation();
        result = result * PRIME + ($creation == null ? 43 : $creation.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }
}
