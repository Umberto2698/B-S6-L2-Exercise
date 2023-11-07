package services;

import enteties.Author;
import exceptions.ItemoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {
    private List<Author> authorList = new ArrayList<>();

    public List<Author> getAllAuthor() {
        return this.authorList;
    }

    public Author save(Author author) {
        author.setId(UUID.randomUUID());
        author.setAvatar("https://www.google.com/url?q=https://ui-avatars.com/api/?name%3DMario%2BRossi&sa=D&source=editors&ust=1699365783132181&usg=AOvVaw2Et-pcRRuu4r-mN8n2_iDJ");
        this.authorList.add(author);
        return author;
    }

    public Author getById(UUID id) {
        Author author = null;
        for (Author a : authorList) {
            if (a.getId() == id) {
                author = a;
            }
        }
        if (author != null) {
            return author;
        } else {
            throw new ItemoNotFoundException(id);
        }
    }

    public Author update(UUID id, Author body) {
        Author found = null;
        for (Author author : authorList) {
            if (author.getId() == id) {
                found.setBirthday(body.getBirthday());
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setEmail(body.getEmail());
                found.setAvatar(body.getAvatar());
            }
        }
        if (found != null) {
            return found;
        } else {
            throw new ItemoNotFoundException(id);
        }
    }

    public void delete(UUID id) {
        authorList.removeIf(author -> author.getId() == id);
    }
}
