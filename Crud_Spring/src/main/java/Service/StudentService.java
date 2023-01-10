package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static Service.StudentEntityTransformer.toStudentEntity;
import Entity.StudentEntity;
import Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok(studentRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}

	public ResponseEntity get(Long id) {
		try {
			return ResponseEntity.ok(studentRepository.findById(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}

	public ResponseEntity create(StudentEntity student) {
		try {
			studentRepository.save(student);
			return ResponseEntity.ok("ok");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}
	
	public ResponseEntity update(Long id, StudentEntity newStudent) {
		StudentEntity student = studentRepository.findById(id).get();

		try {
			return ResponseEntity.ok(studentRepository.save(
					toStudentEntity(newStudent.getId(),
							newStudent.getMiddlename(), newStudent.getLastname(), student)));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}

	public ResponseEntity delete(Long id) {
		try {
			studentRepository.deleteById(id);
			return ResponseEntity.ok("deleted " + id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}
}
