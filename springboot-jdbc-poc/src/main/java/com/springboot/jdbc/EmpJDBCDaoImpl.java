package com.springboot.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * @author Muna
 *
 */
@Repository
public class EmpJDBCDaoImpl {

	private final String INSERT_SQL = "INSERT INTO emp(empno, ename, job,mgr,hiredate,sal,comm,deptno)  values(:empno, :ename, :job,:mgr,:hiredate,:sal,:comm,:deptno)";

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Emp create(final Emp emp) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("empno", emp.getEmpno())
				.addValue("ename", emp.getEname()).addValue("job", emp.getJob()).addValue("mgr", emp.getMgr())
				.addValue("hiredate", emp.getHiredate()).addValue("sal", emp.getSal()).addValue("comm", emp.getComm())
				.addValue("deptno", emp.getDeptno());
		namedParameterJdbcTemplate.update(INSERT_SQL, parameters);
		return emp;
	}

	@SuppressWarnings("unchecked")
	public void callProcedure(Emp emp){
		
		MapSqlParameterSource mySqlParameters = new MapSqlParameterSource();
	    mySqlParameters.addValue("eno", emp.getEmpno());
	    mySqlParameters.addValue("depno", emp.getDeptno());
	    mySqlParameters.addValue("empname", emp.getEname());
		
		  String myStoredProc = "{call EmPDEtails(:eno,:depno,@empname)}";
			 
		/* namedParameterJdbcTemplate.execute(myStoredProc , mySqlParameters , 
		               new PreparedStatementCallback<Boolean>() {
		 
		                    @Override
		                    public Boolean doInPreparedStatement(PreparedStatement ps)
		                            throws SQLException, DataAccessException {
		                        return ps.execute();
		                        //return ps.execute(myStoredProc);
		                    }
		                 
		                });*/
		  
		  namedParameterJdbcTemplate.query(myStoredProc , mySqlParameters,new EmployeeMapper());
		
	}
}

class EmployeeMapper implements ResultSetExtractor<Emp> {
	
	@Override
	public Emp extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		Emp employee = new Emp();
		while(rs.next()){
			
			employee.setEmpno(rs.getInt("eno"));
			employee.setDeptno(rs.getInt("depno"));
			employee.setEname(rs.getString("empname"));
		}
		return employee;
	}

	/*public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Emp employee = new Emp();
		employee.setEmpno(rs.getInt("eno"));
		employee.setDeptno(rs.getInt("depno"));
		employee.setEname(rs.getString("empname"));
		return employee;
	}*/
}
