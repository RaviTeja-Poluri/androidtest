package app.ravi.com.myapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Place {

    private String id;
    private String name;
    private Description description;
    private List<String> imageNames;
    private List<String> imageUris;
    private String nearestRailwayStation;
    private String nearestAirport;
    private String nearestBusTerminal;
    private String stateId;
    private String villageOrCity;

}
