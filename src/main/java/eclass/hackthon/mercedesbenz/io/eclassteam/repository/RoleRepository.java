package eclass.hackthon.mercedesbenz.io.eclassteam.repository;

import java.util.Optional;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Role;
import eclass.hackthon.mercedesbenz.io.eclassteam.utils.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}