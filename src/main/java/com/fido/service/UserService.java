package com.fido.service;

import com.fido.model.User;
import com.fido.model.UserDto;
import com.fido.model.UserResponse;
import com.fido.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(UserRepository userRepository, JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        User user = null;
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        return user;
    }


    public UserResponse callUserControllerProcedure(UserDto request) {
        return jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement callableStatement = connection.prepareCall("{call Test_User_Controller_Test.User_Controller(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {

                callableStatement.setString(1, request.getI_Method_Name());
                callableStatement.setInt(2, request.getI_User_Id());
                callableStatement.setString(3, request.getI_First_Name());
                callableStatement.setString(4, request.getI_Last_Name());
                callableStatement.setString(5, request.getI_Username());
                callableStatement.setString(6, request.getI_Password());
                callableStatement.setString(7, request.getI_Email());
                callableStatement.setString(8, request.getI_Token());
                callableStatement.setString(9, request.getI_Token_Expiry());
                callableStatement.setString(10, request.getI_Card_Number());
                callableStatement.setString(11, request.getI_Card_Expiry_Date());
                callableStatement.setString(12, request.getI_Card_Cvv());
                callableStatement.setString(13, request.getI_Card_Type());

                callableStatement.registerOutParameter(14, Types.INTEGER);
                callableStatement.registerOutParameter(15, Types.VARCHAR);

                callableStatement.execute();

                int code = callableStatement.getInt(14);
                String message = callableStatement.getString(15);

                return new UserResponse(code, message);
            } catch (SQLException e) {
                e.printStackTrace();
                return new UserResponse(-1, "Error: " + e.getMessage());
            }
        });
    }


}