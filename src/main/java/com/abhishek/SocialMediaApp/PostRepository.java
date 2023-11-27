package com.abhishek.SocialMediaApp;
import com.abhishek.SocialMediaApp.User.Post;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Post,Integer> {
}
