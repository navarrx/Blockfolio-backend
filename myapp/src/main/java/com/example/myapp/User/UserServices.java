package com.example.myapp.User;

public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate == null) {
            return null;
        }
        userToUpdate.setName(user.getName());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEmail(user.getEmail());
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
