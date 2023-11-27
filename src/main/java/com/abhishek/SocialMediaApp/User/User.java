package com.abhishek.SocialMediaApp.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {
    protected User(){

    }
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=2,message = "Name should have at least 2 characters")
    //@JsonProperty("User_Name")
    private String name;
    @Past(message = "Birthday should be in the past ")
    private LocalDate birthDay;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;
    public User(Integer id, String name, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public LocalDate getBirthDay() {return birthDay;}

    public void setBirthDay(LocalDate birthDay) {this.birthDay = birthDay;}
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';}
}
