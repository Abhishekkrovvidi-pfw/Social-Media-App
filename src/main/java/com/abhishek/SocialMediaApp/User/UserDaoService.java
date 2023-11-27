package com.abhishek.SocialMediaApp.User;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1,"ABhishek", LocalDate.now().minusYears(23)));
        users.add(new User(2,"Satya", LocalDate.now().minusYears(25)));
        users.add(new User(3,"Sai", LocalDate.now().minusYears(29)));
    }
    int count = users.size();
    public List<User> findAll() {
        return users;
    }
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        User user = users.stream().filter(predicate).findFirst().orElse(null);
        return user;
    }
    public User save(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }
    public void delete(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
