/**
	Copyright (C) 2016  Florian Waltenberger

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package dao.dummy;

import java.util.List;

import dao.IInstituteDAO;
import data.Storage;
import model.Institute;

/**
 * Dummy implemenation of the InstituteDAO. Needs a storage in the constructor
 * and calls its methods to store the data.
 * 
 * @author Florian Waltenberger
 * @see Storage
 * @see IInstituteDAO
 */

public class InstituteDAO implements IInstituteDAO {

	private Storage storage;

	public InstituteDAO(Storage storage) {
		this.storage = storage;
	}

	public Institute load(Long id) {
		return storage.loadInstitute(id);
	}

	public List<Institute> loadAll() {
		return storage.loadAllInstitutes();
	}

	public void save(Institute institute) {
		storage.saveInstitute(institute);
	}
}
