package Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entity.StudentEntity;
import Service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentControler {

	private final StudentService studentService;

	@PostMapping
	public ResponseEntity create(@RequestBody StudentEntity student) {
		return studentService.create(student);
	}

	@GetMapping
	public ResponseEntity get(@RequestParam Long id) {
		return studentService.get(id);
	}

	@GetMapping("/all")
	public ResponseEntity getAll() {
		return studentService.getAll();
	}
	@PutMapping
	public ResponseEntity update(@RequestParam Long id,@RequestBody StudentEntity student)
	{
		return studentService.update(id, student);
	}
	@DeleteMapping
	public ResponseEntity delete(@RequestParam Long id)
	{
		return studentService.delete(id);
	}
}
