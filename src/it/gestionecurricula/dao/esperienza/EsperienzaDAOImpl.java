package it.gestionecurricula.dao.esperienza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.gestionecurricula.dao.AbstractMySQLDAO;
import it.gestionecurricula.model.Curriculum;
import it.gestionecurricula.model.Esperienza;

public class EsperienzaDAOImpl extends AbstractMySQLDAO implements EsperienzaDAO {

	@Override
	public List<Esperienza> list() throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Esperienza> result = new ArrayList<Esperienza>();
		Esperienza esperienzaTemp = null;

		try (Statement ps = connection.createStatement();
				ResultSet rs = ps
						.executeQuery("select * from esperienza e inner join curriculum c on e.curriculum_id = c.id")) {

			while (rs.next()) {
				Curriculum curriculumTemp = new Curriculum();
				curriculumTemp.setNome(rs.getString("c.marca"));
				curriculumTemp.setCognome(rs.getString("c.modello"));
				curriculumTemp.setDataDiNascita(rs.getDate("c.dataproduzione"));
				curriculumTemp.setTelefono(rs.getString("c.telefono"));
				curriculumTemp.setEmail(rs.getString("c.email"));
				curriculumTemp.setId(rs.getLong("c.ID"));

				esperienzaTemp = new Esperienza();
				esperienzaTemp.setId(rs.getLong("ID"));
				esperienzaTemp.setDescrizione(rs.getString("i.descrizione"));
				esperienzaTemp.setDataInizio(rs.getDate("i.datainizio"));
				esperienzaTemp.setDataFine(rs.getDate("i.datafine"));
				esperienzaTemp.setConoscenzeAcquisite(rs.getString("i.conoscenzeacquisite"));
				esperienzaTemp.setCurriculumDiAppartenenza(curriculumTemp);
				result.add(esperienzaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Esperienza get(Long idInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		Esperienza result = null;
		try (PreparedStatement ps = connection.prepareStatement("select * from esperienza where id=?")) {

			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new Esperienza();
					result.setDescrizione(rs.getString("i.descrizione"));
					result.setDataInizio(rs.getDate("i.datainizio"));
					result.setDataFine(rs.getDate("i.datafine"));
					result.setConoscenzeAcquisite(rs.getString("i.conoscenzeacquisite"));
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
	public int update(Esperienza input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE esperienza SET descrizione=?, datainizio=?, datafine=?, conoscenzeacquisite=? where id=?;")) {
			ps.setString(1, input.getDescrizione());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(2, new java.sql.Date(input.getDataInizio().getTime()));
			ps.setDate(3, new java.sql.Date(input.getDataFine().getTime()));
			ps.setString(4, input.getConoscenzeAcquisite());
			ps.setLong(5, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insert(Esperienza input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO esperienza (descrizione, datainizio, datafine, conoscenzeacquisite, curriculum_id) VALUES (?, ?, ?, ?, ?);")) {
			ps.setString(1, input.getDescrizione());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(2, new java.sql.Date(input.getDataInizio().getTime()));
			ps.setDate(3, new java.sql.Date(input.getDataFine().getTime()));
			;
			ps.setString(4, input.getConoscenzeAcquisite());
			ps.setLong(5, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Esperienza input) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM esperienza WHERE ID=?")) {
			ps.setLong(1, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Esperienza> findByExample(Esperienza input) throws Exception {

		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		ArrayList<Esperienza> result = new ArrayList<Esperienza>();
		Esperienza esperienzaTemp = null;

		String query = "select * from esperienza where 1=1 ";
		if (input.getDescrizione() != null && !input.getDescrizione().isEmpty()) {
			query += " and marca like '" + input.getDescrizione() + "%' ";
		}
		if (input.getDataInizio() != null) {
			query += " and dataproduzione='" + new java.sql.Date(input.getDataInizio().getTime()) + "' ";
		}
		if (input.getDataFine() != null) {
			query += " and dataproduzione='" + new java.sql.Date(input.getDataFine().getTime()) + "' ";
		}
		if (input.getConoscenzeAcquisite() != null && !input.getConoscenzeAcquisite().isEmpty()) {
			query += " and marca like '" + input.getConoscenzeAcquisite() + "%' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				esperienzaTemp = new Esperienza();
				esperienzaTemp.setId(rs.getLong("ID"));
				esperienzaTemp.setDescrizione(rs.getString("i.descrizione"));
				esperienzaTemp.setDataInizio(rs.getDate("i.datainizio"));
				esperienzaTemp.setDataFine(rs.getDate("i.datafine"));
				esperienzaTemp.setConoscenzeAcquisite(rs.getString("i.conoscenzeacquisite"));
				result.add(esperienzaTemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public Esperienza findEsperienzaNonConclusa(Curriculum curriculumInput) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (curriculumInput == null || curriculumInput.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		Esperienza result = null;
		try (PreparedStatement ps = connection.prepareStatement(
				"select * from esperienza e inner join curriculum c on e.curriculum_id = c.id where c.id=? and e.datafine is null")) {

			ps.setLong(1, curriculumInput.getId());
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new Esperienza();
					result.setDescrizione(rs.getString("i.descrizione"));
					result.setDataInizio(rs.getDate("i.datainizio"));
					result.setDataFine(rs.getDate("i.datafine"));
					result.setConoscenzeAcquisite(rs.getString("i.conoscenzeacquisite"));
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
	public List<Esperienza> findAllByCurriculumId(Long curriculumId) throws Exception {
		// prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Esperienza> result = new ArrayList<Esperienza>();
		Esperienza esperienzaTemp = null;

		try (PreparedStatement ps = connection.prepareStatement("select * from esperienza e inner join curriculum c on e.curriculum_id = c.id where e.curriculum_id =? ;")){
			ps.setLong(1, curriculumId);
			try (ResultSet rs = ps.executeQuery()){
				while (rs.next()) {	
					Curriculum curriculumTemp = new Curriculum();
					curriculumTemp.setNome(rs.getString("c.marca"));
					curriculumTemp.setCognome(rs.getString("c.modello"));
					curriculumTemp.setDataDiNascita(rs.getDate("c.dataproduzione"));
					curriculumTemp.setTelefono(rs.getString("c.telefono"));
					curriculumTemp.setEmail(rs.getString("c.email"));
					curriculumTemp.setId(rs.getLong("c.ID"));

					esperienzaTemp = new Esperienza();
					esperienzaTemp.setId(rs.getLong("ID"));
					esperienzaTemp.setDescrizione(rs.getString("i.descrizione"));
					esperienzaTemp.setDataInizio(rs.getDate("i.datainizio"));
					esperienzaTemp.setDataFine(rs.getDate("i.datafine"));
					esperienzaTemp.setConoscenzeAcquisite(rs.getString("i.conoscenzeacquisite"));
					esperienzaTemp.setCurriculumDiAppartenenza(curriculumTemp);
					result.add(esperienzaTemp);
				}
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
