package ch.heigvd.aprogoo.services.impl;

import ch.heigvd.aprogoo.data.repositories.IPostRepository;
import ch.heigvd.aprogoo.domain.models.Post;
import ch.heigvd.aprogoo.services.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Implements of the business logic to interact with the posts.
 *
 */
@Service
public class PostService implements IPostService {
    /**
     * The repository that manages the {@link Post}. Injected by constructor.
     */
    private final IPostRepository repository;

    public PostService(IPostRepository repository) {
        this.repository = repository;
    }

    /**
     * Removes the post that corresponds to the identifier.
     *
     * @param postId An identifier of a {@link Post} to remove.
     */
    @Override
    public void delete(Long postId) {
        Post postToRemove = repository.findOne(postId);
        repository.delete(postToRemove);
    }

    /**
     * Retrieves all the posts.
     *
     * @return The return value is a collection of {@link Post}.
     */
    @Override
    public Iterable<Post> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .sorted((o1, o2) -> o2.getPublishedDate().compareTo(o1.getPublishedDate()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a {@link Post} based on its identifier.
     *
     * @param postId The identifier of the {@link Post} to retrieve.
     * @return The return value is an instance of the class {@link Post}.
     */
    @Override
    public Post findOne(Long postId) {
        return repository.findOne(postId);
    }

    /**
     * Saves a given {@link Post}.
     *
     * @param post A given instance of the class {@link Post}.
     */
    @Override
    public void save(Post post) {
        repository.saveAndFlush(post);
    }

    /**
     * Updates the content of an already-existing {@link Post}.
     *
     * @param post The {@link Post} to update.
     */
    @Override
    public void update(Post post) {
        Post existingPost = repository.findOne(post.getId());
        BeanUtils.copyProperties(post, existingPost);
        repository.saveAndFlush(existingPost);
    }
}
