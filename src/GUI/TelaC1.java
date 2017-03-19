package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaC1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton botaoCAdm = new JButton("Cadastrar administrador");

	JButton botaoCClien = new JButton("Cadastrar cliente");

	JButton botaoVolta = new JButton("Voltar");

	ImageIcon imagem = new ImageIcon(getClass().getResource("Espa�o.png"));

	JLabel label = new JLabel(imagem);
	private JFrame janela;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoCAdm) {
			TelaCadastroAdm telaCAdm = new TelaCadastroAdm();
			telaCAdm.setResizable(false);
			telaCAdm.setLocationRelativeTo(null);
			telaCAdm.setVisible(true);
			janela.dispose();

		} else if (e.getSource() == botaoCClien) {
			TelaCadastroCliente telaCClien = new TelaCadastroCliente();
			telaCClien.setResizable(false);
			telaCClien.setLocationRelativeTo(null);
			telaCClien.setVisible(true);
			janela.dispose();

		} else {
			TelaMenuInicial menuInicial = new TelaMenuInicial();
			menuInicial.setResizable(false);
			menuInicial.setLocationRelativeTo(null);
			menuInicial.setVisible(true);
			janela.dispose();
		}

	}

	public TelaC1() {

		botaoCAdm.addActionListener(this);
		botaoCClien.addActionListener(this);
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

		label.setBounds(-0, -20, 500, 400);
		botaoCAdm.setBounds(160, 100, 180, 20);
		botaoCClien.setBounds(160, 200, 180, 20);
		botaoVolta.setBounds(200, 300, 80, 20);

		painelPrincipal.add(botaoCAdm);
		painelPrincipal.add(botaoCClien);
		painelPrincipal.add(botaoVolta);
		painelPrincipal.add(label);

	}

	public static void main(String[] args) {
		new TelaC1();
	}

}