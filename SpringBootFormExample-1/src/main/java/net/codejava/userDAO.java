
package net.codejava;

import java.awt.print.Pageable;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import net.codejava.user;
import com.sun.istack.Nullable;

import antlr.collections.List;

@Repository
public interface userDAO extends JpaRepository<user,Integer>{
	
	


}
