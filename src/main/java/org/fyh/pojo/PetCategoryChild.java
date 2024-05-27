package org.fyh.pojo;

import lombok.Data;

@Data
public class PetCategoryChild {
    private Integer id;
    private String categoryName;
    private String categoryNameEn;
    private String categoryAlias;
    private String categoryDescription;
    private Integer categoryFather;
}
