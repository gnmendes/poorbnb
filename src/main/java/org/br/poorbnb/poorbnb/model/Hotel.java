package org.br.poorbnb.poorbnb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.br.poorbnb.poorbnb.vo.HotelVO;


/**
 * The persistent class for the HOTEL database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "HOTEL")
public class Hotel implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4474361041998773912L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_HOTEL")
	private Long idHotel;

	@NotEmpty
	@Column(name="ENDERECO")
	private String endereco;

	@NotEmpty
	@Column(name="NOME_HOTEL")
	private String nomeHotel;

	@NotEmpty
	@Column(name="TELEFONE")
	private String telefone;

	@Column(name="TELEFONE_OPC")
	private String telefoneOpc;

	@Column(name="DESATIVADO_S_N")
	private String desativadoSN;

	//bi-directional many-to-one association to Usuario

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_PROPRIETARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Quarto
	@OneToMany(mappedBy="hotel")
	private List<Quarto> quartos;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="hotel")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Servico
	@OneToMany(mappedBy="hotel")
	private List<Servico> servicos;

	@JsonIgnore
	@OneToOne(mappedBy = "hotel", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private CobrancaHotel cobrancaHotel;

	public Hotel(final HotelVO valueObject) {
		this.nomeHotel 		= valueObject.getNomeHotel();
		this.usuario 		= valueObject.getIdUsuario();
		this.telefone 		= valueObject.getTelefone();
		this.telefoneOpc 	= valueObject.getTelefoneOpcional();
		this.endereco 		= valueObject.getEndereco();
		this.desativadoSN 	= valueObject.getDesativadoSN();
	}
}