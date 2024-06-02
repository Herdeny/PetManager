package org.fyh.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;

@Data
public class Pet {
    private Integer id;
    @NotEmpty
    private String name;
    private Integer gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private Integer weight;
    private boolean owned;
    private Integer ownerId;
    private Integer category;
    private boolean sterilized;
}
