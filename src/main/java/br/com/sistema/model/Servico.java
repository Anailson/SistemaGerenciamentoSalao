package br.com.sistema.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int valorservico; /*VALOR DO SERVIÇO */
	
	private String tiposervico; /*TIPO DE SERVIÇO NO SALÃO CORTE CABELO, PINTURA, DEPILAÇÃO ETC*/
	
	private String duracao;  /*DEFININDO O TEMPO DO SERVIÇO EM DURACAO EX: CORTE DO CABELO - DURACAO 00:30*/



	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValorservico() {
		return valorservico;
	}

	public void setValorservico(int valorservico) {
		this.valorservico = valorservico;
	}

	public String getTiposervico() {
		return tiposervico;
	}

	public void setTiposervico(String tiposervico) {
		this.tiposervico = tiposervico;
	}

	
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	public String getDuracao() {
		return duracao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
