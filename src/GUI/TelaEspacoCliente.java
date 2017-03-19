package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaEspacoCliente extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton botaoBuscarEven = new JButton("Buscar evento");

	JButton botaoRemConta = new JButton("Remover conta");

	JButton botaoSair = new JButton("Sair");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Espaço.png"));

	JLabel label = new JLabel(imagem);
	private JFrame janela;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoBuscarEven) {
			TelaBuscarEvento busca = new TelaBuscarEvento();
			busca.setResizable(false);
			busca.setLocationRelativeTo(null);
			busca.setVisible(true);
			janela.dispose();

		} else if (e.getSource() == botaoRemConta) {
			TelaRemoveConClien remove = new TelaRemoveConClien();
			remove.setResizable(false);
			remove.setLocationRelativeTo(null);
			remove.setVisible(true);
			janela.dispose();

		} else {
			TelaMenuInicial menuInicial = new TelaMenuInicial();
			menuInicial.setResizable(false);
			menuInicial.setLocationRelativeTo(null);
			menuInicial.setVisible(true);
			janela.dispose();
		}

	}

	public TelaEspacoCliente() {

		botaoBuscarEven.addActionListener(this);
		botaoRemConta.addActionListener(this);
		botaoSair.addActionListener(this);

		janela = new JFrame("TerpTickets");
		janela.setSize(500, 400);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);

		JPanel painelPrincipal = new JPanel();
		janela.add(painelPrincipal);

		painelPrincipal.setLayout(null);

		label.setBounds(-0, -20, 500, 400);
		botaoBuscarEven.setBounds(150, 75, 200, 20);
		botaoRemConta.setBounds(150, 175, 200, 20);
		botaoSair.setBounds(150, 275, 200, 20);

		painelPrincipal.add(botaoBuscarEven);
		painelPrincipal.add(botaoRemConta);
		painelPrincipal.add(botaoSair);
		painelPrincipal.add(label);
	}

	public static void main(String[] args) {
		new TelaEspacoCliente();
	}

}
