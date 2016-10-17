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

import dao.IEnrollmentDAO;
import data.Storage;
import model.Enrollment;

public class EnrollmentDAO implements IEnrollmentDAO {

	private Storage storage;

	public EnrollmentDAO(Storage storage) {
		this.storage = storage;
	}

	public Enrollment load(Long id) {
		return storage.loadEnrollment(id);
	}

	public void save(Enrollment enrollment) {
		storage.saveEnrollment(enrollment);
	}
	
	public List<Enrollment> loadAll() {
		return storage.loadAllEnrollments();
	}
}