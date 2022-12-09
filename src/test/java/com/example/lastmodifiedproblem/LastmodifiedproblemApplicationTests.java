package com.example.lastmodifiedproblem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LastmodifiedproblemApplicationTests {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Test
    void shouldUpdateLastModifiedDateCorrectly() {
        var post = new BlogPost();
        post.setTitle("test");

        var savedPost = blogPostRepository.save(post);

        assertThat(savedPost.getCreatedAt()).isEqualTo(savedPost.getUpdatedAt());

        var beforeUpdatePost = blogPostRepository.findById(savedPost.getId());

        assertThat(savedPost.getCreatedAt()).isEqualTo(beforeUpdatePost.get().getCreatedAt());

        savedPost.setTitle("newTitle");
        var updatedPost = blogPostRepository.save(savedPost);

        assertThat(updatedPost.getCreatedAt()).isEqualTo(savedPost.getCreatedAt());
        assertThat(updatedPost.getUpdatedAt()).isAfter(savedPost.getUpdatedAt());
    }

}
