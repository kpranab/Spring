package com.sapient.spring.service.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author prakumar56
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}