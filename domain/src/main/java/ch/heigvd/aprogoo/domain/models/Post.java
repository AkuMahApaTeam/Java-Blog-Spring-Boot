package ch.heigvd.aprogoo.domain.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.Instant;
import java.util.Date;

/**
 * Represents a post that is published on the blog.
 */
@Entity
public class Post {
    /**
     * The unique identifier of the post.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The content of the post, with a big size.
     */
    @Lob
    @NotEmpty
    private String content;

    /**
     * The date of the last time that the post has been published.
     */
    private Date publishedDate;

    /**
     * The title of the post.
     */
    @NotEmpty
    private String title;

    /**
     * The author who has written the post.
     */
    @Valid
    private Author author;

    /**
     * Initializes a new instance of the class {@link Post}.
     */
    public Post() {
        publishedDate = Date.from(Instant.now());
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
