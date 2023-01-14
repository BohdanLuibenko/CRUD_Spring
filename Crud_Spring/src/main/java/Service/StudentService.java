package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.StudentEntity;
import Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<StudentEntity> getAll() {
		try {
			List<StudentEntity> students = null;
			for (StudentEntity student : studentRepository.findAll()) {
				students.add(student);
			}
			return students;
		} catch (Exception e) {
			return null;
		}
	}

	public StudentEntity get(Long id) {
		try {
			StudentEntity student = studentRepository.findById(id).get();
			return student;
		} catch (Exception e) {
			return null;
		}
	}

	public StudentEntity create(StudentEntity student) {
		try {
			return student;
		} catch (Exception e) {
			return null;
		}
	}

	public StudentEntity update(Long id, StudentEntity newStudent) {
		StudentEntity student = studentRepository.findById(id).get();
		try {
			return StudentEntityTransformer.checkforNulls(newStudent);
		} catch (Exception e) {
			return null;
		}
	}

	public StudentEntity delete(Long id) {
		try {
			StudentEntity student = studentRepository.findById(id).get();
			studentRepository.deleteById(id);
			return student;
		} catch (Exception e) {
			return null;
		}
	}
}
