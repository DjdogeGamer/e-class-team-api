package eclass.hackthon.mercedesbenz.io.eclassteam.entity;

import eclass.hackthon.mercedesbenz.io.eclassteam.utils.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;

}

