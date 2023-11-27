package com.abhishek.SocialMediaApp.User;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service){
        super();
        this.service=service;
    }
    @GetMapping("/user")
    public String getUser(){
        return "Users";
    }
    @GetMapping("/users")
    public List<User> getAll(){
        return service.findAll();
    }
    //http://localhost:8080/users/
    //EntityModel
    //WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> findById(@PathVariable int id){
        User user = service.findOne(id);
        if(user ==null){
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAll());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @PostMapping("/users")
    public ResponseEntity<User>add(@Valid @RequestBody User user){
        service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable int id){
        service.delete(id);
        ResponseEntity.accepted().build();
    }
}
