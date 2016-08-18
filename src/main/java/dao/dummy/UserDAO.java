package dao.dummy;

import dao.IUserDAO;
import data.Storage;
import model.User;

public class UserDAO implements IUserDAO {

	private Storage storage;

	public UserDAO(Storage storage) {
		this.storage = storage;
	}

	public User load(String username) {
		return storage.loadUser(username);
	}

	public void save(User user) {
		storage.saveUser(user);
	}
}
