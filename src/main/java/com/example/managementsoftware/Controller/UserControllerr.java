package com.example.managementsoftware.Controller;

import com.example.managementsoftware.Modell.User;
import com.example.managementsoftware.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserControllerr {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers() {
        return ResponseEntity.status(200).body(userService.getUsers());

    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PutMapping("/update/{id}")

    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("user updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("user deleted");
    }

    @GetMapping("/get-role/{role}")
    public ResponseEntity getUsersByRole(String role) {
        return ResponseEntity.status(200).body(userService.getUsersByRole(role));
    }


    @GetMapping("/get-age/{age}")
    public ResponseEntity getUsersByAgeOrAbove(int age) {
        return ResponseEntity.status(200).body(userService.getUsersByAgeOrAbove(age));
    }
@GetMapping("/get-email/{email}")
    public ResponseEntity  getUserByEmail(@RequestParam String email) {

    userService.getUserByEmail(email);
    return ResponseEntity.status(200).body("email founded");

}

    @PostMapping("/check")
public ResponseEntity checkUsernameAndPassword(String username, String password) {
        userService.checkUsernameAndPassword(username, password);
        return ResponseEntity.status(200).body(userService.getUsers());
}

    }


