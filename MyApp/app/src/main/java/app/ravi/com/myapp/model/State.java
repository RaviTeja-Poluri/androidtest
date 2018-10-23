package app.ravi.com.myapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class State {

    private String id;
    private String name;
    private List<String> picNames;
    private Long places;
    private String briefInfo;
    private Description description;
    private String country;
    private List<String> pics;

}
