package com.move4mobile.bite.model.requestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by Wilco Wolters on 12/09/2016.
 */
public class ChangePasswordRequestBody {

    @NotNull
    @Getter
    @Setter
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
