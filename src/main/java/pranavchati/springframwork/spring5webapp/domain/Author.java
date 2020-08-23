package pranavchati.springframwork.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;


/**
* Created by Pranav Chati on 8/20/20
*/
@Entity //Tells Java that this is an Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //underlying database will give the id
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    //Constructor
    public Author() {

    }

    public Author(String fname, String lname, Set<Book> bks) {
        firstName = fname;
        lastName = lname;
        books = bks;
    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}