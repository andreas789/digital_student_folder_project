package gr.aueb.mscis.educore.dto.search;

import gr.aueb.mscis.educore.core.util.SearchParameters;

import javax.ws.rs.QueryParam;

public class CourseSearchParameters extends SearchParameters {
    @QueryParam("name")
    private String name;
    @QueryParam("code")
    private String code;
    @QueryParam("description")
    private String description;
    @QueryParam("teacherId")
    private String teacherId;

    @Override
    public void buildParameters() {
        super.buildParameters();
        this.addParameter("name", name);
        this.addParameter("code", code);
        this.addParameter("description", description);
        this.addParameter("teacher.id", teacherId);
    }

    public String getName() {return this.name;}

    public String getCode() {return this.code;}

    public String getDescription() {return this.description;}

    public String getTeacherId() {return this.teacherId;}

    public void setName(String name) {this.name = name; }

    public void setCode(String code) {this.code = code; }

    public void setDescription(String description) {this.description = description; }

    public void setTeacherId(String teacherId) {this.teacherId = teacherId; }
}
