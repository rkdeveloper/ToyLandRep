package com.saisha.toyland.dao;

import com.saisha.toyland.model.User;

public interface UserDAO {
	public void addNewUser(User user);
	public boolean getUser(User user);
}
