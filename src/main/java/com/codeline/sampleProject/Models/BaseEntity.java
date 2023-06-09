package com.codeline.sampleProject.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@MappedSuperclass
@Getter
@Setter
@Data
public class BaseEntity {

    Date Created_Date;
    Date Updated_Date;
    Boolean IS_Active;
}
