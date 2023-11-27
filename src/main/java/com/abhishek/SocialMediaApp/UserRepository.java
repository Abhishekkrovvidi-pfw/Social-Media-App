package com.abhishek.SocialMediaApp;

import com.abhishek.SocialMediaApp.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
