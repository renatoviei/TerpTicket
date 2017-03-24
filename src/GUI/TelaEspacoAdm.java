package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaEspacoAdm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton botaoCriarEven = new JButton("Criar evento");

	JButton botaoRemEven = new JButton("Remover evento");

	JButton botaoSRemCon = new JButton("Remover conta");

	JButton botaoSair = new JButton("Sair");
	ImageIcon imagem = new ImageIcon(getClass().getResource("Espaço.png"));

	JLabel label = new JLabel(imagem);
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoCriarEven) {
			TelaEspacoCriarEven cEven = new TelaEspacoCriarEven();
			cEven.setResizable(false);
			cEven.setLocationRelativeTo(null);
			cEven.setVisible(true);
			dispose();
			
		} else if (e.getSource() == botaoRemEven) {
			TelaRemoveEven remove = new TelaRemoveEven();
			remove.setResizable(false);
			remove.setLocationRelativeTo(null);
			remove.setVisible(true);
			dispose();
			
		} else if (e.getSource() == botaoSRemCon) {
			TelaRemoveConAdm remove = new TelaRemoveConAdm();
			remove.setResizable(false);
			remove.setLocationRelativeTo(null);
			remove.setVisible(true);
			dispose();
			
		} else {
			TelaMenuInicial menuInicial = new TelaMenuInicial();
			menuInicial.setResizable(false);
			menuInicial.setLocationRelativeTo(null);
			menuInicial.setVisible(true);
			dispose();
			
		}

	}

	public TelaEspacoAdm() {

		botaoCriarEven.addActionListener(this);
		botaoRemEven.addActionListener(this);
		botaoSRemCon.addActionListener(this);
		botaoSair.addActionListener(this);

		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel painelPrincipal = new JPanel();
		add(painelPrincipal);

		painelPrincipal.setLayout(null);

		label.setBounds(-0, -20, 500, 400);
		botaoCriarEven.setBounds(150, 50, 200, 20);
		botaoRemEven.setBounds(150, 140, 200, 20);
		botaoSRemCon.setBounds(150, 215, 200, 20);
		botaoSair.setBounds(150, 300, 200, 20);
		painelPrincipal.add(botaoCriarEven);
		painelPrincipal.add(botaoRemEven);
		painelPrincipal.add(botaoSRemCon);
		painelPrincipal.add(botaoSair);
		painelPrincipal.add(label);
	}

	public static void main(String[] args) {
		new TelaEspacoAdm();
	}

}
