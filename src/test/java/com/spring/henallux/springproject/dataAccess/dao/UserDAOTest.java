package com.spring.henallux.springproject.dataAccess.dao;

import com.spring.henallux.springproject.dataAccess.entity.UserEntity;
import com.spring.henallux.springproject.dataAccess.repository.UserRepository;
import com.spring.henallux.springproject.dataAccess.util.ProviderConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class UserDAOTest {

    private UserDAO userDAO;
    private ProviderConverter providerConverter;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        providerConverter = new ProviderConverter();
        userDAO = new UserDAO(userRepository, providerConverter);
    }

    @Test
    void findByUsername() {
        UserEntity user = new UserEntity();

        user.setUsername("JohnDoe");
        user.setPassword("$2b$10$WccERRwZoBJbVSdQ7tjOiO6vIrghGG8etzs1EbOZVNm3EG6iM0MLi");
        user.setAuthorities("");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setFirstname("John");
        user.setName("Doe");
        user.setEmail("john.doe@gmail.com");
        user.setPhoneNumber(null);
        user.setBirthdate(new Date());
        user.setPostalCode(5555);
        user.setCity("Namur");
        user.setDeliveryAddress("Rue de fer 35");
        user.setCommands(null);

        when(userRepository.findByUsername("JohnDoe")).thenReturn(user);
        String usernameResult = "JohnDoe";
        assertThat(userDAO.findByUsername("JohnDoe").getUsername()).isEqualTo(usernameResult);
    }
}