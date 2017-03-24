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
import javax.swing.JTextField;

import exceptions.NegcExceptions;
import negocio.Fachada;

public class TelaRemoveEven extends JFrame implements ActionListener {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private JTextField caixaNomeEven = new JTextField(50);

	NegcExceptions ngc = new NegcExceptions("informação inválida");
	JButton botaoRemover = new JButton("Remover");
	JButton botaoVolta = new JButton("Voltar");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Remover.png"));
	JLabel label = new JLabel(imagem);

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoRemover) {
			Fachada fachada = Fachada.getInstance();
			if (fachada.existe(caixaNomeEven.getText())) {
				int reply = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover?", "SIM",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					fachada.removerEvento(caixaNomeEven.getText());
					JOptionPane.showMessageDialog(null, "Evento removido com sucesso");
				} else {

					TelaEspacoAdm espaco = new TelaEspacoAdm();
					espaco.setResizable(false);
					espaco.setLocationRelativeTo(null);
					espaco.setVisible(true);
					dispose();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Evento não existe ou nome " + "está incorreto");

			}
		} else {
			TelaEspacoAdm espaco = new TelaEspacoAdm();
			espaco.setResizable(false);
			espaco.setLocationRelativeTo(null);
			espaco.setVisible(true);
			dispose();

		}

	}

	public TelaRemoveEven() {

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

		JLabel capacidade = new JLabel("Digite o nome do evento: ");
		capacidade.setFont(grande);
		capacidade.setBounds(new Rectangle(20, 120, 450, 17));
		painelPrincipal.add(capacidade);

		caixaNomeEven.setBounds(new Rectangle(190, 120, 250, 17));
		painelPrincipal.add(caixaNomeEven);
		label.setBounds(-5, -20, 500, 400);
		botaoRemover.setBounds(150, 300, 100, 20);
		botaoVolta.setBounds(250, 300, 80, 20);

		painelPrincipal.add(botaoRemover);
		painelPrincipal.add(botaoVolta);
		painelPrincipal.add(label);
	}

	public static void main(String[] args) {
		new TelaRemoveEven();
	}

}
