package com.example.ulbitv.controller;


import com.example.ulbitv.Service.UserService;
import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.entity.UserNotFoundException;
import com.example.ulbitv.exeption.UserAlreadyExistException;
import com.example.ulbitv.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userss")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public  ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Prinyali klienta");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Oshibka klienta");
        }
    }


    @GetMapping
    public ResponseEntity getOneUsers(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("BAD!!!!!!!!");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("BAD!!!!!!!!");
        }
    }
}
