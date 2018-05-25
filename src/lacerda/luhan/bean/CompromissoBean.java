package lacerda.luhan.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lacerda.luhan.modelo.Compromisso;
import lacerda.luhan.negocio.INegocioCompromisso;
import lacerda.luhan.negocio.NegocioCompromisso;

@ManagedBean
@ViewScoped
public class CompromissoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Compromisso compromisso = new Compromisso();
	private INegocioCompromisso negocio = new NegocioCompromisso();

	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public List<Compromisso> getCompromissos() throws Exception {
		return negocio.getAllByOrdemCronologica();
	}

	public void gravar() throws Exception {
		if (this.compromisso.getId() == 0) {
			negocio.insert(compromisso);
		} else {
			negocio.update(compromisso);
		}
		this.compromisso = new Compromisso();
	}
	
	public void carregar(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public void remover(Compromisso compromisso) throws Exception {
		negocio.remove(compromisso);
	}

}
