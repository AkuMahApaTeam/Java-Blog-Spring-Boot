package ch.heigvd.aprogoo.service.impl.tests;

import ch.heigvd.aprogoo.data.repositories.IPostRepository;
import ch.heigvd.aprogoo.domain.models.Post;
import ch.heigvd.aprogoo.services.impl.PostService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Unit testing for the service layer. The service is tested in isolation from the other components (repository mocked).
 */
public class PostServiceUnitTests {
    @Mock
    private IPostRepository _postRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GetAll_ProvideSomePosts_ShouldBeInReverseChronologicalOrder() {
        // Arrange
        Calendar calendar = Calendar.getInstance();

        calendar.set(2000, 2, 1);
        Post middlePost = new Post();
        middlePost.setPublishedDate(calendar.getTime());

        calendar.set(2000, 1, 1);
        Post olderPost = new Post();
        olderPost.setPublishedDate(calendar.getTime());

        calendar.set(2000, 3, 1);
        Post newerPost = new Post();
        newerPost.setPublishedDate(calendar.getTime());

        Mockito.when(_postRepository.findAll())
                .thenReturn(Arrays.asList(middlePost, olderPost, newerPost));

        PostService postService = new PostService(_postRepository);

        // Act
        List<Post> posts = StreamSupport.stream(postService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        // Assert
        assertThat(posts.size(), is(equalTo(3)));
        assertThat(posts.get(0), is(newerPost));
        assertThat(posts.get(1), is(middlePost));
        assertThat(posts.get(2), is(olderPost));
    }
}
