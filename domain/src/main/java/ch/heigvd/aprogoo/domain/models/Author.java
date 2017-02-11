package ch.heigvd.aprogoo.domain.models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents an author, a writer of a {@link Post}.
 *
 * @see <a href="https://docs.jboss.org/hibernate/stable/annotations/reference/en/html/entity.html">Hibernate Community Documentation: Mapping Entities</a>
 */
@Embeddable
public class Author implements Serializable {
    /**
     * The first name of the author.
     */
    @NotEmpty
    private String firstName;

    /**
     * The last name of the author.
     */
    @NotEmpty
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The return value is a human-readable representation of an {@link Author}.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
