package com.titiplex.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExtendWithMockitoTest {

    @Test
    void register_uses_repo_and_validates_email() {
        UserRepository repo = mock(UserRepository.class);
        when(repo.existsByEmail("a@b.com")).thenReturn(false);

        UserService svc = new UserService(repo);
        assertTrue(svc.register("a@b.com"));

        verify(repo, times(1)).existsByEmail("a@b.com");
    }
}
