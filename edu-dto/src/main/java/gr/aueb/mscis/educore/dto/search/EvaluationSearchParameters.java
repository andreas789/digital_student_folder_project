package gr.aueb.mscis.educore.dto.search;

import gr.aueb.mscis.educore.core.util.SearchParameters;

import javax.ws.rs.QueryParam;

public class EvaluationSearchParameters extends SearchParameters {
    @QueryParam("studentId")
    private String studentId;
    @QueryParam("courseId")
    private String courseId;

    @Override
    public void buildParameters() {
        super.buildParameters();
        this.addParameter("studentId", studentId);
        this.addParameter("courseId", courseId);
    }

    public String getStudentId() {return this.studentId;}

    public String getCourseId() {return this.courseId;}

    public void setStudentId(String studentId) {this.studentId = studentId; }

    public void setCourseId(String courseId) {this.courseId = courseId; }
}
