package br.mil.eb.rm.ideiudo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import br.mil.eb.rm.ideiudo.domain.Situacao;
import br.mil.eb.rm.ideiudo.domain.Tipo;

@Entity
@Table(name = "ideia_problema")
public class IdeiaProblema implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private String sugestao;
	private String nome;
	private String email;
	private String telefone;
	private Date dataCadastro;
	private Situacao situacao;
	private Tipo tipo;
	private String assunto;

	public IdeiaProblema() {
		super();
		this.dataCadastro = new Date();
		this.situacao = Situacao.NAO_LIDO;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotBlank(message = "é obrigatório")
	@Column(name = "tx_descricao", nullable = false, columnDefinition = "text")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "tx_sugestao", nullable = false, columnDefinition = "text")
	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	@Column(name = "tx_nome", length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "tx_email", length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tx_telefone", length = 20)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_criacao")
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "cs_situacao", nullable = false, length = 50)
	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "cs_tipo", nullable = false, length = 50)
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@NotBlank(message = "é obrigatório")
	@Column(name = "tx_assunto", nullable = false, length = 100)
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
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
		IdeiaProblema other = (IdeiaProblema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
