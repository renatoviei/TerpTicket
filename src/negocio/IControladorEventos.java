package negocio;

import beans.Evento;
import beans.Local;
import exceptions.IngInsuficienteException;
import exceptions.NegcExceptions;

public interface IControladorEventos {

	abstract boolean cadastrar(Evento event)throws NegcExceptions, NumberFormatException;

	abstract Evento buscarEvento(String nome);

	abstract void remover(String nome);

	abstract boolean existe(String nome);

	abstract void venderIngrClien(int quantIngressos, String busca)throws IngInsuficienteException;

	abstract void salvarEventos();
	
	public String[] retornaTudo();
	
	 void atualiza(Evento even, String nome, int preco, Local local, String bandas);

}
