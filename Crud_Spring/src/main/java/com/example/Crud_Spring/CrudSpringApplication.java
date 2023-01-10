package com.example.Crud_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import Controler.StudentControler;
import Entity.StudentEntity;
import Repository.StudentRepository;
import Service.StudentService;

@SpringBootApplication
@ComponentScan(basePackageClasses = StudentControler.class)
@EntityScan(basePackageClasses = StudentEntity.class)
@EnableJpaRepositories(basePackageClasses = StudentRepository.class)
@ComponentScan(basePackageClasses = StudentService.class)
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

}
