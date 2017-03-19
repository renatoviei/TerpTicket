package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaMenuInicial extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton botaoCadastrar = new JButton("Cadastrar");

	JButton botaoLogar = new JButton("Fazer login");

	JButton botaoSair = new JButton("Sair");

	ImageIcon imagem = new ImageIcon(getClass().getResource("MenuInicial.png"));

	JLabel label = new JLabel(imagem);

	private JFrame janela;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoSair) {
			System.exit(0);
		} else if (e.getSource() == botaoCadastrar) {
			TelaC1 telaC = new TelaC1();
			telaC.setResizable(false);
			telaC.setLocationRelativeTo(null);
			telaC.setVisible(true);
			janela.dispose();

		} else {
			TelaL1 telaL = new TelaL1();
			telaL.setResizable(false);
			telaL.setLocationRelativeTo(null);
			telaL.setVisible(true);
			janela.dispose();

		}

	}

	public TelaMenuInicial() {

		botaoCadastrar.addActionListener(this);
		botaoLogar.addActionListener(this);
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

		botaoCadastrar.setBounds(200, 100, 100, 20);
		botaoLogar.setBounds(200, 200, 100, 20);
		botaoSair.setBounds(200, 300, 100, 20);

		label.setBounds(-5, -27, 500, 400);
		painelPrincipal.add(botaoCadastrar);
		painelPrincipal.add(botaoLogar);
		painelPrincipal.add(botaoSair);

		painelPrincipal.add(label);

	}

	public static void main(String[] args) {
		new TelaMenuInicial();
	}

}
