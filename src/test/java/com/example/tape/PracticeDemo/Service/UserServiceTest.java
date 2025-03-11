package com.example.tape.PracticeDemo.Service;

import com.example.tape.PracticeDemo.Model.Address;
import com.example.tape.PracticeDemo.Model.Company;
import com.example.tape.PracticeDemo.Model.Geo;
import com.example.tape.PracticeDemo.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;
    private User mockUser;
    private UUID userId;

    @BeforeEach
    public void setUp() {
        userService = new UserService(); // สร้าง instance ของ UserService

        // สร้าง mock data ที่ต้องการ
        Address mockAddress = new Address("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", new Geo("-37.3159", "81.1496"));
        Company mockCompany = new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets");

        // สร้าง mockUser และเพิ่มเข้าไปใน userService
        mockUser = new User(UUID.randomUUID(),"Leanne", "Leanne Graham", "Sincere@april.biz", mockAddress, "1-770-736-8031 x56442", "hildegard.org", mockCompany);
        userService.addUser(mockUser);

        // กำหนด userId
        userId = mockUser.getId();
    }

    @Test
    public void testAddUser() {
        // Arrange
        User newUser = new User("Leanne", "Leanne Graham", "Sincere@april.biz", new Address("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", new Geo("-37.3159", "81.1496")), "1-770-736-8031 x56442", "hildegard.org", new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets"));

        // Act
        userService.addUser(newUser);

        // Assert
        assertTrue(userService.getAllUsers().contains(newUser), "User should be added");
    }

    @Test
    public void testDeleteUser_UserExists_ShouldReturnTrue() {
        // Act
        boolean result = userService.deleteUser(userId);

        // Assert
        assertTrue(result, "User should be deleted successfully");
        assertFalse(userService.getAllUsers().contains(mockUser), "User should no longer be in the list");
    }

    @Test
    public void testDeleteUser_UserNotFound_ShouldReturnFalse() {
        // Act
        UUID nonExistingUserId = UUID.randomUUID();
        boolean result = userService.deleteUser(nonExistingUserId);

        // Assert
        assertFalse(result, "Delete should return false if user does not exist");
    }

    @Test
    public void testGetUserById_Found_ShouldReturnUser() {
        // Act
        User foundUser = userService.getUserById(userId).orElse(null);

        // Assert
        assertNotNull(foundUser, "User should be found");
        assertEquals(mockUser.getId(), foundUser.getId(), "User ID should match");
    }

    @Test
    public void testGetUserById_NotFound_ShouldReturnEmpty() {
        // Act
        UUID nonExistingUserId = UUID.randomUUID();
        User foundUser = userService.getUserById(nonExistingUserId).orElse(null);

        // Assert
        assertNull(foundUser, "User should not be found");
    }
}
