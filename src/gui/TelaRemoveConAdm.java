package gui;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import beans.Administrador;
import negocio.Fachada;

public class TelaRemoveConAdm extends JFrame implements ActionListener {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private JTextField caixaLogin = new JTextField(50);
	private JPasswordField caixaSenha = new JPasswordField(50);

	JButton botaoRemover = new JButton("Remover");
	JButton botaoVolta = new JButton("Voltar");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Remover.png"));
	JLabel label = new JLabel(imagem);

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoRemover) {
			Fachada fachada = Fachada.getInstance();
			Administrador adm = null;
			adm = fachada.buscarAdm(caixaLogin.getText());

			if (caixaSenha.getText().equals(adm.getSenha())) {
				int reply = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover?", "SIM",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					fachada.removerAdm(caixaLogin.getText());
					JOptionPane.showMessageDialog(null, "Conta removida com sucesso");
					TelaMenuInicial menuInicial = new TelaMenuInicial();
					menuInicial.setResizable(false);
					menuInicial.setLocationRelativeTo(null);
					menuInicial.setVisible(true);
					dispose();
				} else {
					TelaEspacoAdm espacoAdm = new TelaEspacoAdm();
					espacoAdm.setResizable(false);
					espacoAdm.setLocationRelativeTo(null);
					espacoAdm.setVisible(true);
					dispose();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Login ou senha estão incorretos");
			}
		} else {
			TelaEspacoAdm espaco = new TelaEspacoAdm();
			espaco.setResizable(false);
			espaco.setLocationRelativeTo(null);
			espaco.setVisible(true);
			dispose();

		}

	}

	public TelaRemoveConAdm() {

		botaoRemover.addActionListener(this);
		botaoVolta.addActionListener(this);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel painelPrincipal = new JPanel();

		add(painelPrincipal);

		painelPrincipal.setLayout(null);

		Font grande = new Font("Serif", Font.BOLD, 16);

		JLabel login = new JLabel("Digite seu login: ");
		login.setFont(grande);
		login.setBounds(new Rectangle(20, 50, 120, 17));
		painelPrincipal.add(login);

		caixaLogin.setBounds(new Rectangle(150, 50, 120, 17));
		painelPrincipal.add(caixaLogin);

		JLabel senha = new JLabel("Digite sua senha: ");
		senha.setFont(grande);
		senha.setBounds(new Rectangle(20, 100, 120, 17));
		painelPrincipal.add(senha);

		caixaSenha.setBounds(new Rectangle(150, 100, 120, 17));
		painelPrincipal.add(caixaSenha);

		label.setBounds(-5, -20, 500, 400);
		botaoRemover.setBounds(150, 300, 100, 20);
		botaoVolta.setBounds(250, 300, 80, 20);

		painelPrincipal.add(botaoRemover);
		painelPrincipal.add(botaoVolta);
		painelPrincipal.add(label);

	}

	public static void main(String[] args) {
		new TelaRemoveConAdm();
	}

}
