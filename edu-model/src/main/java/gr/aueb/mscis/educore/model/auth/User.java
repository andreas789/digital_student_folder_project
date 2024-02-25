package gr.aueb.mscis.educore.model.auth;

import com.google.common.base.Strings;
import gr.aueb.mscis.educore.model.core.CoreEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class User extends CoreEntity {
    String username;
    String password;
    String nickname;

    @Enumerated(EnumType.STRING)
    UserRole userRole = UserRole.GUEST;

    @Transient
    public static User GUEST = new User();

    public User(UserRole userRole) {
        this.userRole = userRole;
    }

    public User() {}

    public boolean isValidForPersistence() {
        return !Strings.isNullOrEmpty(username)&&
                !Strings.isNullOrEmpty(password)&&
                !Strings.isNullOrEmpty(nickname)&&
                userRole != UserRole.GUEST;
    }

    public String getUsername() {return this.username;}

    public String getPassword() {return this.password;}

    public String getNickname() {return this.nickname;}

    public UserRole getUserRole() {return this.userRole;}

    public void setUsername(String username) {this.username = username; }

    public void setPassword(String password) {this.password = password; }

    public void setNickname(String nickname) {this.nickname = nickname; }

    public void setUserRole(UserRole userRole) {this.userRole = userRole; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) return false;
        final Object this$userRole = this.getUserRole();
        final Object other$userRole = other.getUserRole();
        if (this$userRole == null ? other$userRole != null : !this$userRole.equals(other$userRole)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof User;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $userRole = this.getUserRole();
        result = result * PRIME + ($userRole == null ? 43 : $userRole.hashCode());
        return result;
    }
}
