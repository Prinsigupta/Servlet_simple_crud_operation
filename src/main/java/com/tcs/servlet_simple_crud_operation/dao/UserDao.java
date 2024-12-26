package com.tcs.servlet_simple_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tcs.servlet_simple_crud_operation.connection.UserConnection;
import com.tcs.servlet_simple_crud_operation.dto.User;

public class UserDao {
	Connection connection = UserConnection.getUserConnection();
	final String INSERTUSERQUERY = "INSERT INTO USERR (id,name,email,dob,gender,password) value(?,?,?,?,?,?)";
	final String USERMAILQUERY = "SELECT * FROM USERR WHERE email=?";
	final String DISPLAYALLUSERQUERY = "SELECT * FROM USERR ";
	final String DELETEUSERBYIDQUERY = "DELETE FROM USERR WHERE id=?";

	public User saveUserDao(User userr) {

		try {

			PreparedStatement ps = connection.prepareStatement(INSERTUSERQUERY);
			ps.setInt(1, userr.getId());
			ps.setString(2, userr.getName());
			ps.setString(3, userr.getEmail());
			ps.setObject(4, userr.getDob());
			ps.setString(5, userr.getGender());
			ps.setString(6, userr.getPassword());
			int a = ps.executeUpdate();
			String msg = a != 0 ? "DATA_STORED" : "please check your code";
			System.out.println(msg);
			return userr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByUserEmailDao(String userEmail) {
		try {

//		PreparedStatement ps = connection.prepareStatement(INSERTUSERQUERY);
			PreparedStatement ps = connection.prepareStatement(USERMAILQUERY);
			ps.setString(1, userEmail);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				return new User(email, password);
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllUserDao() {
		try {

			PreparedStatement ps = connection.prepareStatement(DISPLAYALLUSERQUERY);

			ResultSet resultSet = ps.executeQuery();

			List<User> users = new ArrayList<User>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				LocalDate dob = resultSet.getDate("dob").toLocalDate();
				String gender = resultSet.getString("gender");
				User userr = new User(id, name, email, dob, gender);
				users.add(userr);
			}
			return users;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deleteUserByIdDao(int userId) {
		try {

			PreparedStatement ps = connection.prepareStatement(DELETEUSERBYIDQUERY);

			ps.setInt(1, userId);

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
