package ch.heigvd.aprogoo.services;

import ch.heigvd.aprogoo.domain.models.Post;

/**
 * A contract defining the service to interact with the business logic of the posts.
 */
public interface IPostService {
    /**
     * Removes the post that corresponds to the identifier.
     * @param postId An identifier of a {@link Post} to remove.
     */
    void delete(Long postId);

    /**
     * Retrieves all the posts.
     *
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
     * Saves a given {@link Post}.
     *
     * @param post A given instance of the class {@link Post}.
     */
    void save(Post post);

    /**
     * Updates the content of an already-existing {@link Post}.
     * @param post The {@link Post} to update.
     */
    void update(Post post);
}
