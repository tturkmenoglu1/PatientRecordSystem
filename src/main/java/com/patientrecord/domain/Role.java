package com.patientrecord.domain;

import com.patientrecord.domain.enums.RoleType;
import org.mapstruct.EnumMapping;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleType type;

    @Override
    public String toString() {
        return "Role [type=" + type + "]";
    }
}
