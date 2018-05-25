package lacerda.luhan.negocio;

import java.util.List;

import lacerda.luhan.modelo.Compromisso;


public interface INegocioCompromisso {
	
	public void insert(Compromisso compromisso) throws Exception;

	public void update(Compromisso compromisso) throws Exception;

	public void remove(Compromisso compromisso) throws Exception;

	public void refresh(Compromisso compromisso) throws Exception;
	
	public List<Compromisso> getAllByOrdemCronologica() throws Exception;
	
	
}
