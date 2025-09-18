package com.titiplex.advanced;

public interface UserRepository {
    boolean existsByEmail(String email);
}
