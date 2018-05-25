package lacerda.luhan.negocio;

import java.util.List;

import lacerda.luhan.dao.DAOCompromisso;
import lacerda.luhan.dao.DAOFactory;
import lacerda.luhan.modelo.Compromisso;

public class NegocioCompromisso implements INegocioCompromisso {

	private static String ERRO_DESCRICAO = "Favor informar a descrição";
	private static String ERRO_DATA = "Data inválida";
	private static String ERRO_DURACAO = "Duração inválida";
	private static String ERRO_ID = "ID inválido";

	private DAOCompromisso compromissoDAO = DAOFactory.getCompromissoDAO();

	@Override
	public void insert(Compromisso compromisso) throws Exception {

		if (compromisso.getDescricao().isEmpty()) {
			throw new Exception(ERRO_DESCRICAO);
		}

		if (compromisso.getData() == null) {
			throw new Exception(ERRO_DATA);
		}

		if (compromisso.getDuracao() == null) {
			throw new Exception(ERRO_DURACAO);
		}

		compromissoDAO.insert(compromisso);
	}

	@Override
	public void update(Compromisso compromisso) throws Exception {

		if (compromisso.getDescricao().isEmpty()) {
			throw new Exception(ERRO_DESCRICAO);
		}

		if (compromisso.getData() == null) {
			throw new Exception(ERRO_DATA);
		}

		if (compromisso.getDuracao() == null) {
			throw new Exception(ERRO_DURACAO);
		}

		compromissoDAO.update(compromisso);

	}

	@Override
	public void remove(Compromisso compromisso) throws Exception {

		if (compromisso.getId() < 0) {
			throw new Exception(ERRO_ID);
		}

		compromissoDAO.remove(compromisso);

	}

	@Override
	public void refresh(Compromisso compromisso) throws Exception {

		if (compromisso.getDescricao().isEmpty()) {
			throw new Exception(ERRO_DESCRICAO);
		}

		if (compromisso.getData() == null) {
			throw new Exception(ERRO_DATA);
		}

		if (compromisso.getDuracao() == null) {
			throw new Exception(ERRO_DURACAO);
		}

		compromissoDAO.update(compromisso);

	}

	@Override
	public List<Compromisso> getAllByOrdemCronologica() throws Exception {
		return compromissoDAO.getAllByOrdemCronologica();
	}

}
