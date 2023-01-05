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

import Entity.StudentEntity;
import Service.StudentService;

@Controller
@RequestMapping("/student")

public class StudentControler {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity createOne(@RequestBody StudentEntity student) {
		return studentService.creatingOne(student);
	}

	@GetMapping
	public ResponseEntity getOne(@RequestParam Long id) {
		return studentService.getOne(id);
	}

	@GetMapping("/all")
	public ResponseEntity getAll() {
		return studentService.getAll();
	}
	@PutMapping
	public ResponseEntity updateOne(@RequestParam Long id,@RequestBody StudentEntity student)
	{
		return studentService.updateOne(id, student);
	}
	@DeleteMapping
	public ResponseEntity deleteOne(@RequestParam Long id)
	{
		return studentService.deleteOne(id);
	}
}
