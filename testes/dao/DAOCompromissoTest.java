package dao;

import java.text.SimpleDateFormat;
import java.time.Duration;

import lacerda.luhan.dao.DAOCompromisso;
import lacerda.luhan.dao.DAOFactory;
import lacerda.luhan.modelo.Compromisso;

public class DAOCompromissoTest {

	public static void main(String[] args) {

		try {
			Compromisso compromisso = new Compromisso();

			compromisso.setDescricao("Projeto Faculdade");
			compromisso.setData(new SimpleDateFormat("dd/MM/yyyy").parse("26/05/2018"));
			compromisso.setDuracao(Duration.ofHours(2));

			DAOCompromisso factory = DAOFactory.getCompromissoDAO();
			factory.insert(compromisso);

			factory.getAllByOrdemCronologica();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
