package controllers;


import enteties.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.AuthorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAuthors() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable UUID id) {
        return authorService.getById(id);
    }

    @PostMapping("")
    public Author saveAuthor(@RequestBody Author body) {
        return authorService.save(body);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable UUID id, @RequestBody Author body) {
        return authorService.update(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(UUID id) {
        authorService.delete(id);
    }
}
