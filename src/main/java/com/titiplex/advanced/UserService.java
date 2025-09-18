package com.titiplex.advanced;

public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean register(String email) {
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("bad email");
        return !repo.existsByEmail(email);
    }
}
