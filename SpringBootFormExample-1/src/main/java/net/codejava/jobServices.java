package net.codejava;
import java.awt.print.Pageable;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import net.codejava.job;
import com.sun.istack.Nullable;
@Service
@Transactional

public class jobServices {
	@Autowired
	private jobDAO dao;
	
	

	
	public job saveJob(job u)
	{
		
		return dao.save(u);
	}
	public Collection<job> getAllJobs()
	{
		return dao.findAll();
	}
	public void removeJob(int id)
	{
		dao.deleteById(id);
	}
	public job updateJob(job u )
	{
		return dao.save(u);
	}
	
	public long joblength()
	{
		return dao.count();
	}

}
