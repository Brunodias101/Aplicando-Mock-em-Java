package br.com.alura.leilao.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal valor;

	@NotNull
	private LocalDate vencimento;

	@OneToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Leilao leilao;

	private Boolean pago;

	public Pagamento(Lance lanceVencedor, LocalDate vencimento) {
		this.leilao = lanceVencedor.getLeilao();
		this.usuario = lanceVencedor.getUsuario();
		this.valor = lanceVencedor.getValor();
		this.vencimento = vencimento;
		this.pago = false;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public Boolean getPago() {
		return pago;
	}

}
