package gr.aueb.mscis.educore.dto.search;

import gr.aueb.mscis.educore.core.util.SearchParameters;

import javax.ws.rs.QueryParam;

public class PersonSearchParameters extends SearchParameters {
    @QueryParam("name")
    private String name;
    @QueryParam("surname")
    private String surname;
    @QueryParam("email")
    private String email;
    @QueryParam("phone")
    private String phone;
    @QueryParam("address")
    private String address;

    @Override
    public void buildParameters() {
        super.buildParameters();
        this.addParameter("name", name);
        this.addParameter("surname", surname);
        this.addParameter("email", email);
        this.addParameter("phone", phone);
        this.addParameter("address", address);
    }

    public String getName() {return this.name;}

    public String getSurname() {return this.surname;}

    public String getEmail() {return this.email;}

    public String getPhone() {return this.phone;}

    public String getAddress() {return this.address;}

    public void setName(String name) {this.name = name; }

    public void setSurname(String surname) {this.surname = surname; }

    public void setEmail(String email) {this.email = email; }

    public void setPhone(String phone) {this.phone = phone; }

    public void setAddress(String address) {this.address = address; }
}
