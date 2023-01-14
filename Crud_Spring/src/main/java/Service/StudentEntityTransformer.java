package Service;

import static Service.StudentEntityTransformer.toStudentEntity;

import Entity.StudentEntity;

public class StudentEntityTransformer {
	public static StudentEntity checkforNulls(StudentEntity newStudent) 
	{
		if (newStudent.getName() != null && newStudent.getMiddlename() != null
				&& newStudent.getLastname() != null) {
			return toStudentEntity(newStudent.getId(),
					newStudent.getName(), newStudent.getMiddlename(), newStudent.getLastname());
		} else if (newStudent.getName() == null) {
			return toStudentEntity(newStudent.getId(),
					newStudent.getMiddlename(), newStudent.getLastname(), newStudent);
		} else {
			return null;
		}
	}
	public static StudentEntity toStudentEntity(Long id, String firstName, String middleName, String lastName) {
			return StudentEntity.builder().id(id).name(firstName).middlename(middleName).lastname(lastName).build();
	}

	public static StudentEntity toStudentEntity(Long id, String middleName, String lastName,
			StudentEntity studentEntity) {
		return toStudentEntity(id, studentEntity.getName(), middleName, lastName);
	}

}
