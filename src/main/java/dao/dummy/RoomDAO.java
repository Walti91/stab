package dao.dummy;

import java.util.List;

import dao.IRoomDAO;
import data.Storage;
import model.Room;

public class RoomDAO implements IRoomDAO {

	private Storage storage;

	public RoomDAO(Storage storage) {
		this.storage = storage;
	}
	
	public Room load(Long id) {
		return storage.loadRoom(id);
	}
	
	public List<Room> loadAll() {
		return storage.loadAllRooms();
	}

	public void save(Room room) {
		storage.saveRoom(room);
	}
}
