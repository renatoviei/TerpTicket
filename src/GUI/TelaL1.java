package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaL1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton botaoLAdm = new JButton("Entrar como administrador");

	JButton botaoLClien = new JButton("Entrar como cliente");

	JButton botaoVolta = new JButton("Voltar");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Espaço.png"));

	JLabel label = new JLabel(imagem);
	private JFrame janela;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoLAdm) {
			TelaLoginAdm loginAdm = new TelaLoginAdm();
			loginAdm.setResizable(false);
			loginAdm.setLocationRelativeTo(null);
			loginAdm.setVisible(true);
			janela.dispose();
		} else if (e.getSource() == botaoLClien) {
			TelaLoginCliente loginClien = new TelaLoginCliente();
			loginClien.setResizable(false);
			loginClien.setLocationRelativeTo(null);
			loginClien.setVisible(true);
			janela.dispose();

		} else {
			TelaMenuInicial menuInicial = new TelaMenuInicial();
			menuInicial.setResizable(false);
			menuInicial.setLocationRelativeTo(null);
			menuInicial.setVisible(true);
			janela.dispose();
		}

	}

	public TelaL1() {

		botaoLAdm.addActionListener(this);
		botaoLClien.addActionListener(this);
		botaoVolta.addActionListener(this);

		janela = new JFrame("TerpTickets");
		janela.setSize(500, 400);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);

		JPanel painelPrincipal = new JPanel();
		janela.add(painelPrincipal);

		painelPrincipal.setLayout(null);

		label.setBounds(-5, -25, 500, 400);
		botaoLAdm.setBounds(150, 100, 200, 20);
		botaoLClien.setBounds(160, 200, 180, 20);
		botaoVolta.setBounds(200, 300, 80, 20);

		painelPrincipal.add(botaoLAdm);
		painelPrincipal.add(botaoLClien);
		painelPrincipal.add(botaoVolta);
		painelPrincipal.add(label);

	}

	public static void main(String[] args) {
		new TelaL1();
	}

}