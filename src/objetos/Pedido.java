package objetos;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lanche;
	private String bebida;
	private String obs;
	private Double preco;
	private Date data;
	//private Cliente cliente;
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedido(String lanche, String bebida, String obs, Double preco,Date data){//, Cliente cliente) {
		super();
		this.lanche = lanche;
		this.bebida = bebida;
		this.obs = obs;
		this.preco = preco;
		this.data = data;
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

	@Override
	public String toString() {
		return "Pedido [lanche=" + lanche + ", bebida=" + bebida + ", obs=" + obs + ", preco=" + preco + ", data"+data.toString();
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}
