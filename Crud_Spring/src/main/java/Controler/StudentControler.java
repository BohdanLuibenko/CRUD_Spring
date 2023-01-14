package Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entity.StudentEntity;
import Repository.StudentRepository;
import Service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentControler {

	private final StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping
	public ResponseEntity create(@RequestBody StudentEntity student) {
		return ResponseEntity.ok(studentRepository.save(studentService.create(student)));
	}

	@GetMapping
	public ResponseEntity get(@RequestParam Long id) {
		return ResponseEntity.ok(studentService.get(id));
	}

	@GetMapping("/all")
	public ResponseEntity getAll() {
		return ResponseEntity.ok(studentService.getAll());
	}

	@PutMapping
	public ResponseEntity update(@RequestParam Long id, @RequestBody StudentEntity student) {
		return ResponseEntity.ok(studentRepository.save(studentService.update(id, student)));
	}

	@DeleteMapping
	public ResponseEntity delete(@RequestParam Long id) {
		return ResponseEntity.ok("Deleted"+studentService.delete(id));
	}
}
