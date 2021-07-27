package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TelaAplicacao extends JFrame {
	private static final long serialVersionUID = 1L;

	public JButton novoButton, loginButton, addButton, removeButton, showButton, sairButton;
	public JRadioButton mascRadioButton, femRadioButton;
	public JTextField loginField, cpfField;
	public JPasswordField senhaField;

	ImageIcon icone;
	JLabel iconeLabel, loginLabel, senhaLabel, cpfLabel;
	JPanel panel;

	public TelaAplicacao() {
		super("tela Login");
		setLayout(new BorderLayout(4, 4));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		na minha tela essa foi a resolução ideal,
//		na que o senhor passou o botão se escondia atras da imagem
		setSize(180, 340);

		this.icone = new ImageIcon("img/logo.png");
		this.iconeLabel = new JLabel(this.icone);

		this.novoButton = new JButton("Novo");
		this.loginButton = new JButton("Login");
		this.addButton = new JButton("Add");
		this.removeButton = new JButton("Remove");
		this.showButton = new JButton("Show");
		this.sairButton = new JButton("Sair");

		this.loginLabel = new JLabel("Login:");
		this.cpfLabel = new JLabel("CPF:");
		this.senhaLabel = new JLabel("Senha:");

		this.loginField = new JTextField();
		this.cpfField = new JTextField();
		this.senhaField = new JPasswordField();

		this.mascRadioButton = new JRadioButton("Masc");
		this.femRadioButton = new JRadioButton("Fem");

		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(7, 2));

		this.panel.add(this.novoButton);
		this.panel.add(this.loginButton);
		
		this.panel.add(this.loginLabel);
		this.panel.add(this.loginField);

		this.panel.add(this.senhaLabel);
		this.panel.add(this.senhaField);
		
		this.panel.add(this.cpfLabel);
		this.panel.add(this.cpfField);

		this.panel.add(this.mascRadioButton);
		this.panel.add(this.femRadioButton);

		this.panel.add(this.addButton);
		this.panel.add(this.removeButton);

		this.panel.add(this.showButton);
		this.panel.add(this.sairButton);

		this.add(this.iconeLabel, BorderLayout.NORTH);
		this.add(new JSeparator(), BorderLayout.CENTER);
		this.add(this.panel, BorderLayout.SOUTH);

		this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
	}

	public void showNovoFields() {
		this.showLoginFields();
		
		this.cpfLabel.setVisible(true);
		this.cpfField.setVisible(true);

		this.mascRadioButton.setVisible(true);
		this.femRadioButton.setVisible(true);
	}

	public void showLoginFields() {
		this.hideAllFields();

		this.loginLabel.setVisible(true);
		this.loginField.setVisible(true);

		this.senhaLabel.setVisible(true);
		this.senhaField.setVisible(true);
	}

	public void hideAllFields() {
		this.cpfLabel.setVisible(false);
		this.cpfField.setVisible(false);
		
		this.loginLabel.setVisible(false);
		this.loginField.setVisible(false);

		this.senhaLabel.setVisible(false);
		this.senhaField.setVisible(false);

		this.mascRadioButton.setVisible(false);
		this.femRadioButton.setVisible(false);
	}

}
