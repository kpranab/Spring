/**
 * 
 */
package com.rnd.springboot.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rnd.springboot.jpa.entity.Student;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
