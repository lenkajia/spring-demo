package com.example.database.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GroupRepo groupRepo;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(
            @RequestParam String name, @RequestParam Integer
            id,@RequestParam String user, @RequestParam String email){

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setId(id);
        n.setUser(user);
        System.out.println("");
        System.out.println(n);
        System.out.println("");
        userRepo.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping(path = "/group")
    public  @ResponseBody Iterable<Group> getAllGroups(){
        return groupRepo.findAll();
    }

    @GetMapping(path = "/user/{groupid}")
    public @ResponseBody Iterable<User> getUsersByGroup(@PathVariable String groupid) {
        return userRepo.getUsersByGroup(groupid);
    }

}
