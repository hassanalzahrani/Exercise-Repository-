package com.example.managementsoftware.Service;

import com.example.managementsoftware.Api.ApiException;
import com.example.managementsoftware.Modell.User;
import com.example.managementsoftware.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;


    }

    public User addUser(User user) {
        return userRepository.save(user);

    }


    public void updateUser(Integer id, User user) {
        User u = userRepository.findUserById(id);
        if (u == null) {

            throw new ApiException("user not found");

        }
        u.setUserID(user.getUserID());
        u.setAge(user.getAge());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        u.setUserName(user.getUserName());
        u.setPassword(user.getPassword());
        u.setName(user.getName());
        userRepository.save(u);

    }

    public void deleteUser(Integer id) {
        User u = userRepository.findUserById(id);
        if (u == null) {
            throw new ApiException("user not found");
        }
        userRepository.delete(u);

    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public List<User> getUsersByAgeOrAbove(Integer age) {
        return userRepository.findByAgeGreaterThanEqual(age);
    }

    public User getUserByEmail(String email) {
        if (email == null) {
            throw new ApiException("user not found");
        }

        return userRepository.findByEmail(email);
    }

    public String checkUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            return "Username not found";
        }
        if (!user.getPassword().equals(password)) {
            return "Incorrect password";
        }
        return "Credentials are valid";
    }
}




