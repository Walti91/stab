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

import dao.IExaminationSubjectDAO;
import data.Storage;
import model.ExaminationSubject;

public class ExaminationSubjectDAO implements IExaminationSubjectDAO {

	private Storage storage;

	public ExaminationSubjectDAO(Storage storage) {
		this.storage = storage;
	}
	
	public ExaminationSubject load(Long id) {
		return storage.loadExaminationSubject(id);
	}

	public void save(ExaminationSubject examinationSubject) {
		storage.saveExaminationSubject(examinationSubject);
	}
}
