/**
 * 
 */
package com.stackhive.tmsloginapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackhive.tmsloginapp.model.UserRole;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Repository
@Transactional
public class UserRoleRepository {
@Autowired
private EntityManager entityManager;

public List<String> getRoleNames(Long userId) {
    String sql = "Select ur.Role.roleName from " + UserRole.class.getName() + " ur " //
            + " where ur.User.userId = :userId ";

    Query query = this.entityManager.createQuery(sql, String.class);
    query.setParameter("userId", userId);
    return query.getResultList();
}
}