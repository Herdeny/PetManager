package org.fyh.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet {
    private Integer id;
    @NotEmpty
    private String name;
    private Integer gender;
    private LocalDate birth;
    private Integer weight;
    private Integer breed_times;
    private boolean is_owned;
    private Integer owner_id;
    private Integer category;
    private boolean is_sterilized;
}
