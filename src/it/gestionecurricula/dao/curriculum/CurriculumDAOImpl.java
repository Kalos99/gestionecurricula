package it.gestionecurricula.dao.curriculum;

import java.sql.Connection;
import java.util.List;

import it.gestionecurricula.dao.AbstractMySQLDAO;
import it.gestionecurricula.model.Curriculum;

public class CurriculumDAOImpl extends AbstractMySQLDAO implements CurriculumDAO{

	@Override
	public List<Curriculum> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curriculum get(Long idInput) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Curriculum input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Curriculum input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Curriculum input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Curriculum> findByExample(Curriculum input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}

}
