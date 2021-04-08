package ex3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import ex1.InformaDados;

public class AcessaOrcamento extends JFrame implements ActionListener {
	// definindo elementos do Frame e variáveis do programa //
	JLabel LTitulo, LGastos, LSaldo, LItens, LNome, LTaxSaque, LDesconto, LValorInvest;// label dos atributos
	JButton MOSTRAR, SAIR;
	JCheckBox C1, C2, C3, C4;// checkbox para selecionar qual classe será instanciada
	JTextField TTitulo, TGastos, TSaldo, TItens, TNome, TTaxSaque, TDesconto, TValorInvest;// text para inserir
																							// atributos

	String titulo, nome, gastos, saldo, taxSaque, desconto, valorInvest, itens;

	// variáveis usadas para converter de String para tipo numérico (int/double): //
	double Dgastos, Dsaldo, DtaxSaque, Ddesconto, DvalorInvest;
	int itensI;
	// ------------------------------------------------------------//
	boolean orcamento, bancaria, poupanca, outros;
	// classe nula que será USADA PARA POLIMORFISMO: //
	Orcamento orc = null;
	// FIM definições de elementos do programa //

	public static void main(String[] args) {
		// criação do frame
		JFrame abstracao = new AcessaOrcamento();
		abstracao.show();

		WindowListener x = new WindowAdapter() {
			public void windowClosing(WindowEvent fechar) {
				System.exit(0);
			}
		};
		abstracao.addWindowListener(x);
	}

	// Construtor do AcessaOrcamento //
	public AcessaOrcamento() {
		setTitle("EXERCÍCIO 3 - HERANÇA E POLIMORFISMO");
		setSize(800, 600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new GridLayout(12, 2));

		// Associando variaveis com elementos da tela:
		// Labels:
		LTitulo = new JLabel("Título da compra ");
		LTitulo.setForeground(Color.black);
		LTitulo.setFont(new Font("", Font.BOLD, 14));
		LNome = new JLabel("Nome do cliente ");
		LNome.setForeground(Color.black);
		LNome.setFont(new Font("", Font.BOLD, 14));
		LSaldo = new JLabel("Saldo $");
		LSaldo.setForeground(Color.black);
		LSaldo.setFont(new Font("", Font.BOLD, 14));
		LGastos = new JLabel("Gastos $");
		LGastos.setForeground(Color.black);
		LGastos.setFont(new Font("", Font.BOLD, 14));
		LItens = new JLabel("Quantidade de itens ");
		LItens.setForeground(Color.black);
		LItens.setFont(new Font("", Font.BOLD, 14));
		LTaxSaque = new JLabel("Taxa de saque $");
		LTaxSaque.setForeground(Color.black);
		LTaxSaque.setFont(new Font("", Font.BOLD, 14));
		LDesconto = new JLabel("Desconto $");
		LDesconto.setForeground(Color.black);
		LDesconto.setFont(new Font("", Font.BOLD, 14));
		LValorInvest = new JLabel("Outros investimentos $");
		LValorInvest.setForeground(Color.black);
		LValorInvest.setFont(new Font("", Font.BOLD, 14));
		// TextFields
		TTitulo = new JTextField();
		TTitulo.setBackground(Color.white);
		TTitulo.setForeground(Color.black);
		TNome = new JTextField();
		TNome.setBackground(Color.white);
		TNome.setForeground(Color.black);
		TSaldo = new JTextField();
		TSaldo.setBackground(Color.white);
		TSaldo.setForeground(Color.black);
		TGastos = new JTextField();
		TGastos.setBackground(Color.white);
		TGastos.setForeground(Color.black);
		TItens = new JTextField();
		TItens.setBackground(Color.white);
		TItens.setForeground(Color.black);
		TTaxSaque = new JTextField();
		TTaxSaque.setBackground(Color.white);
		TTaxSaque.setForeground(Color.black);
		TDesconto = new JTextField();
		TDesconto.setBackground(Color.white);
		TDesconto.setForeground(Color.black);
		TValorInvest = new JTextField();
		TValorInvest.setBackground(Color.white);
		TValorInvest.setForeground(Color.black);
		// CheckBoxes e botões
		C1 = new JCheckBox("Orçamento");
		C1.setBackground(Color.white);
		C2 = new JCheckBox("Conta bancária");
		C2.setBackground(Color.white);
		C3 = new JCheckBox("Conta poupança");
		C3.setBackground(Color.white);
		C4 = new JCheckBox("Outros investimentos");
		C4.setBackground(Color.white);
		MOSTRAR = new JButton("MOSTRAR");// imprimir no console
		MOSTRAR.setBackground(Color.white);
		MOSTRAR.setForeground(Color.blue);
		MOSTRAR.addActionListener(this);
		SAIR = new JButton("SAIR");// sair do programa
		SAIR.setBackground(Color.white);
		SAIR.setForeground(Color.red);
		SAIR.addActionListener(this);
		// Fim associação //
		// adicionando elementos no layout
		getContentPane().add(LTitulo);
		getContentPane().add(TTitulo);
		getContentPane().add(LNome);
		getContentPane().add(TNome);
		getContentPane().add(LSaldo);
		getContentPane().add(TSaldo);
		getContentPane().add(LGastos);
		getContentPane().add(TGastos);
		getContentPane().add(LItens);
		getContentPane().add(TItens);
		getContentPane().add(LTaxSaque);
		getContentPane().add(TTaxSaque);
		getContentPane().add(LDesconto);
		getContentPane().add(TDesconto);
		getContentPane().add(LValorInvest);
		getContentPane().add(TValorInvest);
		getContentPane().add(C1);
		getContentPane().add(C2);
		getContentPane().add(C3);
		getContentPane().add(C4);
		getContentPane().add(MOSTRAR);
		getContentPane().add(SAIR);
	} // FIM CONSTRUTOR AcessaOrcamento//

	@Override
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == MOSTRAR) {
			// usando condicional if para selecionar os atributos certos //
			titulo = TTitulo.getText();
			saldo = TSaldo.getText();
			Dsaldo = Double.parseDouble(saldo);
			gastos = TGastos.getText();
			Dgastos = Double.parseDouble(gastos);
			itens = TItens.getText();
			itensI = Integer.parseInt(itens);
			orcamento = C1.isSelected();
			bancaria = C2.isSelected();
			if (bancaria == true || orcamento == false) {
				nome = TNome.getText();
				taxSaque = TTaxSaque.getText();
				DtaxSaque = Double.parseDouble(taxSaque);
			}
			poupanca = C3.isSelected();
			if (poupanca == true) {
				desconto = TDesconto.getText();
				Ddesconto = Double.parseDouble(desconto);
			}
			outros = C4.isSelected();
			if (outros == true) {
				valorInvest = TValorInvest.getText();
				DvalorInvest = Double.parseDouble(valorInvest);
			}
			mostrarDados();// Chamando o método para imprimir no console
		}

		if (click.getSource() == SAIR) {
			System.exit(0);// sair do programa
		}
	}

	// mostrar dados no console //
	public void mostrarDados() {
		if (orcamento == true) {// instancia apenas como Orcamento
			Orcamento orc = new Orcamento();
			orc.setTituloDaCompra(titulo);
			orc.setGastos(Dgastos);
			orc.setSaldo(Dsaldo);
			orc.setQtdItens(itensI);
			orc.extrato((Dsaldo * 0.05));// método padrão
		}
		if (bancaria == true) {// instancia como ContaBancaria
			ContaBancaria orc = new ContaBancaria();
			orc.setTituloDaCompra(titulo);
			orc.setGastos(Dgastos);
			orc.setSaldo(Dsaldo);
			orc.setQtdItens(itensI);
			orc.setNome(nome);
			orc.setTaxaSaque(DtaxSaque);
			orc.extrato(Dgastos);//método polimorfo
		}
		if (poupanca == true) {// instancia como ContaPoupança
			ContaPoupanca orc = new ContaPoupanca();
			orc.setTituloDaCompra(titulo);
			orc.setGastos(Dgastos);
			orc.setSaldo(Dsaldo);
			orc.setQtdItens(itensI);
			orc.setNome(nome);
			orc.setDesconto(Ddesconto);
			orc.extrato(Dgastos);//método polimorfo
		}
		if (outros == true) {// instancia como OutrosInvestimentos
			OutrosInvestimentos orc = new OutrosInvestimentos();
			orc.setTituloDaCompra(titulo);
			orc.setGastos(Dgastos);
			orc.setSaldo(Dsaldo);
			orc.setQtdItens(itensI);
			orc.setNome(nome);
			orc.setTaxaSaque(DtaxSaque);
			orc.setValorDosInvestimentos(DvalorInvest);
			orc.extrato((Dsaldo * 0.05));//método polimorfo
		}
	}
}
