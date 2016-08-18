package dao;

import model.User;

public interface IUserDAO {

	public User load(String username);

	public void save(User user);
}
