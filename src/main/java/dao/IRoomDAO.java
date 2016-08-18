package dao;

import java.util.List;

import model.Room;

public interface IRoomDAO {

	public Room load(Long id);

	public List<Room> loadAll();
	
	public void save(Room room);
}
