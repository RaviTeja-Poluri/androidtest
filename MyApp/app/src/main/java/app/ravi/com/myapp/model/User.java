/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ravi.com.myapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ravi
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String id;
    private String name;
    private String userName;
    private String email;
    private String password;
    private Long mobile;
    private String location;
    private Integer age;
    private Role role;
    private String profilePics;


}
