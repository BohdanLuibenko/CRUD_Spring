package Service;

import Entity.StudentEntity;

public class StudentEntityTransformer {
	
	public static StudentEntity toStudentEntity(Long id, String firstName, String middleName, String lastName) {
		return StudentEntity.builder().id(id).name(firstName).middlename(middleName).lastname(lastName).build();
	}
	
	public static StudentEntity toStudentEntity(Long id, String middleName, String lastName, StudentEntity studentEntity) {
		return toStudentEntity(id, studentEntity.getName(), middleName, lastName);
	}
	

}
