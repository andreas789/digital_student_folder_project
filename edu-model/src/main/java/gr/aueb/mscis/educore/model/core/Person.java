package gr.aueb.mscis.educore.model.core;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class Person extends CoreEntity {
    String name;
    String surname;
    String email;
    LocalDate birthdate;
    String phone;
    String address;

    public Person() {}

    public String getName() {return this.name;}

    public String getSurname() {return this.surname;}

    public String getEmail() {return this.email;}

    public LocalDate getBirthdate() {return this.birthdate;}

    public String getPhone() {return this.phone;}

    public String getAddress() {return this.address;}

    public void setName(String name) {this.name = name; }

    public void setSurname(String surname) {this.surname = surname; }

    public void setEmail(String email) {this.email = email; }

    public void setBirthdate(LocalDate birthdate) {this.birthdate = birthdate; }

    public void setPhone(String phone) {this.phone = phone; }

    public void setAddress(String address) {this.address = address; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$birthdate = this.getBirthdate();
        final Object other$birthdate = other.getBirthdate();
        if (this$birthdate == null ? other$birthdate != null : !this$birthdate.equals(other$birthdate)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Person;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $birthdate = this.getBirthdate();
        result = result * PRIME + ($birthdate == null ? 43 : $birthdate.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        return result;
    }
}
