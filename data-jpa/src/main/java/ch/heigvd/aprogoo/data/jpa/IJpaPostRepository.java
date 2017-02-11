package ch.heigvd.aprogoo.data.jpa;

import ch.heigvd.aprogoo.data.repositories.IPostRepository;
import ch.heigvd.aprogoo.domain.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementation that interacts with a database using the library Spring Data JPA.
 */
@Repository
public interface IJpaPostRepository extends JpaRepository<Post, Long>, IPostRepository {
}