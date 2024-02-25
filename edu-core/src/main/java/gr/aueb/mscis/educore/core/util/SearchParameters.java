package gr.aueb.mscis.educore.core.util;

import javax.ws.rs.QueryParam;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SearchParameters implements Serializable {
    @QueryParam("id")
    Long id;

    Map<String, Object> parameters = new HashMap<>();

    public void addParameter(String name, Object value){
        if(Objects.nonNull(name) && Objects.nonNull(value))parameters.put(name, value);
    }

    public void removeParameter(String name){
        if(Objects.nonNull(name))parameters.remove(name);
    }

    public void buildParameters(){
        this.addParameter("id",id);
    }

    public Map<String, Object> getParameters() {
        buildParameters();
        return parameters;
    }
}
