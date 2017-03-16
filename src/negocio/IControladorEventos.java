package negocio;

import beans.Evento;

public interface IControladorEventos {

	abstract boolean cadastrar(Evento event);

	abstract Evento buscarEvento(String nome);

	abstract void remover(String nome);

	abstract boolean existe(String nome);

	abstract void venderIngrClien(int quantIngressos, String busca);

	abstract void salvarEventos();

}
