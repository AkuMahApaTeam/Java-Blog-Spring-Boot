package tests.ch.heigvd.aprogoo.integration.tests;

import ch.heigvd.aprogoo.PresentationWebApplication;
import ch.heigvd.aprogoo.data.jpa.IJpaPostRepository;
import ch.heigvd.aprogoo.domain.models.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Integration tests of the Web application. The application is truly started when executed.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PresentationWebApplication.class})
public class IJpaPostRepositoryIntegrationTests {
    @Autowired
    private IJpaPostRepository repo;

    @Test
    public void findAll_GetAllPosts_ShouldReturnNonEmptyList() {
        // Act
        List<Post> posts = repo.findAll();

        // Assert
        assertThat(posts.size(), is(greaterThan(0)));
    }
}
