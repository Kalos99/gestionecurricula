package it.gestionecurricula.dao.curriculum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.gestionecurricula.dao.AbstractMySQLDAO;
import it.gestionecurricula.model.Curriculum;

public class CurriculumDAOImpl extends AbstractMySQLDAO implements CurriculumDAO {

	@Override
	public Curriculum get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		Curriculum result = null;
		try (PreparedStatement ps = connection.prepareStatement("select * from curriculum where id=?")) {

			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new Curriculum();
					result.setNome(rs.getString("nome"));
					result.setCognome(rs.getString("cognome"));
					result.setDataDiNascita(rs.getDate("datadinascita"));
					result.setTelefono(rs.getString("telefono"));
					result.setEmail(rs.getString("email"));
					result.setId(rs.getLong("ID"));
				} else {
					result = null;
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Curriculum> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Curriculum> result = new ArrayList<Curriculum>();
		Curriculum curriculumTemp = null;

		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from curriculum")) {

			while (rs.next()) {
				curriculumTemp = new Curriculum();
				curriculumTemp.setNome(rs.getString("nome"));
				curriculumTemp.setCognome(rs.getString("cognome"));
				curriculumTemp.setDataDiNascita(rs.getDate("datadinascita"));
				curriculumTemp.setTelefono(rs.getString("telefono"));
				curriculumTemp.setEmail(rs.getString("email"));
				curriculumTemp.setId(rs.getLong("ID"));
				result.add(curriculumTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int update(Curriculum input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection
				.prepareStatement("UPDATE curriculum SET nome=?, cognome=?, datadinascita=?, telefono=?, email=? where id=?;")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(3, new java.sql.Date(input.getDataDiNascita().getTime()));
			ps.setString(4, input.getTelefono());
			ps.setString(5, input.getEmail());
			ps.setLong(6, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insert(Curriculum input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO curriculum (nome, cognome, datadinascita, telefono, email) VALUES (?, ?, ?, ?, ?);")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(3, new java.sql.Date(input.getDataDiNascita().getTime()));
			ps.setString(4, input.getTelefono());
			ps.setString(5, input.getEmail());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Curriculum input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM curriculum WHERE ID=?")) {
			ps.setLong(1, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Curriculum> findByExample(Curriculum input) throws Exception {

		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		ArrayList<Curriculum> result = new ArrayList<Curriculum>();
		Curriculum curriculumTemp = null;

		String query = "select * from curriculum where 1=1 ";
		if (input.getNome() != null && !input.getNome().isEmpty()) {
			query += " and marca like '" + input.getNome() + "%' ";
		}
		if (input.getCognome() != null && !input.getCognome().isEmpty()) {
			query += " and modello like '" + input.getCognome() + "%' ";
		}

		if (input.getDataDiNascita() != null) {
			query += " and dataproduzione='" + new java.sql.Date(input.getDataDiNascita().getTime()) + "' ";
		}
		if (input.getTelefono() != null && !input.getTelefono().isEmpty()) {
			query += " and marca like '" + input.getTelefono() + "%' ";
		}
		if (input.getEmail() != null && !input.getEmail().isEmpty()) {
			query += " and modello like '" + input.getEmail() + "%' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				curriculumTemp = new Curriculum();
				curriculumTemp.setNome(rs.getString("nome"));
				curriculumTemp.setCognome(rs.getString("cognome"));
				curriculumTemp.setDataDiNascita(rs.getDate("datadinascita"));
				curriculumTemp.setTelefono(rs.getString("telefono"));
				curriculumTemp.setEmail(rs.getString("email"));
				curriculumTemp.setId(rs.getLong("ID"));
				result.add(curriculumTemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

}
