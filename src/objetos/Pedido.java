package objetos;

import java.io.Serializable;

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lanche;
	private String bebida;
	private String obs;
	private Double preco;
	//private Cliente cliente;
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedido(String lanche, String bebida, String obs, Double preco){//, Cliente cliente) {
		super();
		this.lanche = lanche;
		this.bebida = bebida;
		this.obs = obs;
		this.preco = preco;
	//	this.cliente = cliente;
	}
	public String getLanche() {
		return lanche;
	}
	public void setLanche(String lanche) {
		this.lanche = lanche;
	}
	public String getBebida() {
		return bebida;
	}
	public void setBebida(String bebida) {
		this.bebida = bebida;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
/*	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}*/
	@Override
	public String toString() {
		return "Pedido [lanche=" + lanche + ", bebida=" + bebida + ", obs=" + obs + ", preco=" + preco; //+ ", cliente="
			//	+ cliente + "]";
	}
	
}
