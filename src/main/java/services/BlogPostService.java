package services;

import enteties.BlogPost;
import exceptions.ItemoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class BlogPostService {
    private List<BlogPost> blogPostList = new ArrayList<>();

    public List<BlogPost> getAllBlogPost() {
        return this.blogPostList;
    }

    public BlogPost save(BlogPost blogPost) {
        blogPost.setId(UUID.randomUUID());
        blogPost.setCover("https://picsum.photos/200/300");
        blogPost.setReadingTime(new Random().nextInt(10, 240));
        this.blogPostList.add(blogPost);
        return blogPost;
    }

    public BlogPost getById(UUID id) {
        BlogPost blogPost = null;
        for (BlogPost b : blogPostList) {
            if (b.getId() == id) {
                blogPost = b;
            }
        }
        if (blogPost != null) {
            return blogPost;
        } else {
            throw new ItemoNotFoundException(id);
        }
    }

    public BlogPost update(UUID id, BlogPost body) {
        BlogPost found = null;
        for (BlogPost blogPost : blogPostList) {
            if (blogPost.getId() == id) {
                found.setId(id);
                found.setReadingTime(body.getReadingTime());
                found.setCover(body.getCover());
                found.setTitle(body.getTitle());
                found.setContent(body.getContent());
                found.setCategory(body.getCategory());
            }
        }
        if (found != null) {
            return found;
        } else {
            throw new ItemoNotFoundException(id);
        }
    }

    public void delete(UUID id) {
        blogPostList.removeIf(blogPost -> blogPost.getId() == id);
    }
}
