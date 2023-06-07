package com.eswagger;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class BookDTO {

    @ApiModelProperty(value = "This is a book name")
    @NotEmpty
    @Size(min = 2, message = "name should have at least 2 characters")
    private String name;

    private String author;
}
