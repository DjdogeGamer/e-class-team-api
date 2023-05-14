package eclass.hackthon.mercedesbenz.io.eclassteam.repository;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
