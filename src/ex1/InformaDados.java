package ex1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InformaDados extends JFrame implements ActionListener {

	//instanciação da classe Dados_Condominio e declarando atributos da classe.
	Dados_Condominio condominio = new Dados_Condominio();

	JLabel L1, L2, L3, L4, L5;
	JButton B1, sair;
	JCheckBox C1, C2;
	JTextField T1, T2, T3, T4, T5;

	String nome, numAp, taxaLavanderia, taxaZelador, aluguel;
	boolean zelador, lavanderia;

	public static void main(String[] args) {

		JFrame abstracao = new InformaDados();
		abstracao.show();

		WindowListener x = new WindowAdapter() {
			public void windowClosing(WindowEvent fechar) {
				System.exit(0);
			}
		};
		abstracao.addWindowListener(x);
	}

	// Construtor.
	public InformaDados() {
		//Configuração dos atributos 
		setTitle("EXERCÍCIO 1 - ABSTRAÇÃO DE UM CONDOMÍNIO");
		setSize(800, 600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new GridLayout(7, 2));
		//Configurando os elementos da interface gráfica//
		L1 = new JLabel("Nome: ");
		L1.setForeground(Color.black);
		L1.setFont(new Font(" ", Font.BOLD, 14));
		L2 = new JLabel("Número do apartamento: ");
		L2.setForeground(Color.black);
		L2.setFont(new Font(" ", Font.BOLD, 14));
		L3 = new JLabel("Alugel: ");
		L3.setForeground(Color.black);////////////////////////////////////////////////////////
		L3.setFont(new Font(" ", Font.BOLD, 14));
		L4 = new JLabel("Taxa do zelador: ");
		L4.setForeground(Color.black);
		L4.setFont(new Font(" ", Font.BOLD, 14));
		L5 = new JLabel("Taxa da lavanderia");
		L5.setForeground(Color.black);
		L5.setFont(new Font(" ", Font.BOLD, 14));
		T1 = new JTextField();
		T1.setBackground(Color.white);
		T1.setForeground(Color.black);
		T2 = new JTextField();
		T2.setBackground(Color.white);
		T2.setForeground(Color.black);
		T3 = new JTextField();
		T3.setBackground(Color.white);
		T3.setForeground(Color.black);
		T4 = new JTextField();
		T4.setBackground(Color.white);
		T4.setForeground(Color.black);
		T5 = new JTextField();
		T5.setBackground(Color.white);
		T5.setForeground(Color.black);
		C1 = new JCheckBox("Zelador");
		C2 = new JCheckBox("Lavanderia");
		B1 = new JButton("MOSTRAR DADOS");
		B1.setBackground(Color.white);
		B1.setForeground(Color.blue);
		B1.addActionListener(this);
		sair = new JButton("SAIR");
		sair.setBackground(Color.gray);//cor do fundo do botão.
		sair.setForeground(Color.blue);//cor da letra do botão.
		sair.addActionListener(this);
		//Adicionando os elementos a classe GridLayout da aplicação//
		getContentPane().add(L1);
		getContentPane().add(T1);
		getContentPane().add(L2);
		getContentPane().add(T2);
		getContentPane().add(L3);
		getContentPane().add(T3);
		getContentPane().add(L4);
		getContentPane().add(T4);
		getContentPane().add(L5);
		getContentPane().add(T5);
		getContentPane().add(C1);
		getContentPane().add(C2);
		getContentPane().add(B1);
		getContentPane().add(sair);
		//////////////////////////////////////////////////////
	}// FIM CONSTRUTOR

	@Override
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == B1) {
			nome = T1.getText();
			numAp = T2.getText();
			aluguel = T3.getText();
			taxaZelador = T4.getText();
			taxaLavanderia = T5.getText();
			zelador = C1.isSelected();
			lavanderia = C2.isSelected();
			informaDados();
		}
		if (click.getSource() == sair) {
			 System.exit(0);
		}

	}

	public void informaDados() {
		condominio.setName(nome);
		condominio.setApartamento(numAp);
		condominio.setAluguel(aluguel);
		condominio.setTaxaZelador(taxaZelador);
		condominio.setTaxaLavanderia(taxaLavanderia);

		System.out.println("Nome do morador: " + condominio.getName());
		System.out.println("Número do apartamento: " + condominio.getApartamento());
		System.out.println("Valor do aluguel: " + condominio.getAluguel());
		if (zelador == true)
			System.out.println("Taxa do zelador: " + condominio.getTaxaZelador());
		if (lavanderia == true)
			System.out.println("Taxa da lavanderia: " + condominio.getTaxaLavanderia());

	}

}
