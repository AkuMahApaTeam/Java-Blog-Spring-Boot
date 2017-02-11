package ch.heigvd.aprogoo.data.repositories;

import ch.heigvd.aprogoo.domain.models.Post;

/**
 * A contract for any data source that provides posts.
 */
public interface IPostRepository {
    /**
     * Removes a given {@link Post} from the data source.
     * @param post A given instance of the class {@link Post}.
     */
    void delete(Post post);

    /**
     * Retrieves all the posts.
     * @return The return value is a collection of {@link Post}.
     */
    Iterable<Post> findAll();

    /**
     * Retrieves a {@link Post} based on its identifier.
     * @param postId The identifier of the {@link Post} to retrieve.
     * @return The return value is an instance of the class {@link Post}.
     */
    Post findOne(Long postId);

    /**
     * Saves a given {@link Post} in the data source.
     *
     * @param post A given instance of the class {@link Post}.
     * @return The return value is the post passed by parameter.
     */
    Post saveAndFlush(Post post);
}
