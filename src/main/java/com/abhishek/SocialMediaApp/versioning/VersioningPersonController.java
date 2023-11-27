package com.abhishek.SocialMediaApp.versioning;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionPerson(){
        return new PersonV1("Abhishek Prajwal");
    }
    @GetMapping("/v2/person")
    public PersonV2 getFirstVersion2Person(){
        return new PersonV2(new Name("Abhishek", "Prajwal"));
    }
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersion2PersononRequestParameter(){
        return new PersonV1("Abhishek");
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getFirstVersion2PersonRequestParam(){
        return new PersonV2(new Name("Abhishek", "Prajwal"));
    }
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersion2PersononRequestHeader(){
        return new PersonV1("Abhishek");
    }
    @GetMapping(path = "/person/header", headers= "X-API-VERSION=2")
    public PersonV2 getFirstVersion2PersonRequestHeader(){
        return new PersonV2(new Name("Abhishek", "Prajwal"));
    }
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersion2PersononAcceptHeader(){
        return new PersonV1("Abhishek");
    }
    @GetMapping(path = "/person/accept", produces= "application/vnd.company.app-v2+json")
    public PersonV2 getFirstVersion2AcceptRequestHeader(){
        return new PersonV2(new Name("Abhishek", "Prajwal"));
    }
}
