package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Entity.StudentEntity;
import Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public ResponseEntity creatingOne(StudentEntity student) {
		try {
			studentRepository.save(student);
			return ResponseEntity.ok("ok");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}

	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok(studentRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}

	public ResponseEntity getOne(Long id) {
		try {
			return ResponseEntity.ok(studentRepository.findById(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}

	public ResponseEntity updateOne(Long id, StudentEntity student) {
		StudentEntity changingStudent = studentRepository.findById(id).get();
		changingStudent.setName(student.getName());
		changingStudent.setLastname(student.getLastname());
		changingStudent.setMidlename(student.getMidlename());
		try {
			return ResponseEntity.ok(studentRepository.save(changingStudent));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}

	public ResponseEntity deleteOne(Long id) {
		try {
			studentRepository.deleteById(id);
			return ResponseEntity.ok("deleted " + id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("bad");
		}
	}
}
