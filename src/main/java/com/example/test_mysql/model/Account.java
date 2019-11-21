package com.example.test_mysql.model;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "account")
public class Account  implements Serializable {

    @Id
    private Integer id;
    private String name;
    private Double money;

}
