package lacerda.luhan.modelo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compromisso {

	@Id
	@GeneratedValue
	private int id;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar duracao = Calendar.getInstance();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getDuracao() {
		return duracao;
	}

	public void setDuracao(Calendar duration) {
		this.duracao = duration;
	}

}
