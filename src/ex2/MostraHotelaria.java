package ex2;

public class MostraHotelaria extends javax.swing.JFrame {

    String nome, saldo, custoRH, lucroRH, custoAM, lucroAM;
    double saldod, custoRHd, lucroRHd, custoAMd, lucroAMd; //converter string para double
    boolean rh, am;

    public MostraHotelaria() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        T1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        T2 = new javax.swing.JTextField();
        C1 = new javax.swing.JCheckBox();
        J2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        T3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        T4 = new javax.swing.JTextField();
        C2 = new javax.swing.JCheckBox();
        J1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        T5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        T6 = new javax.swing.JTextField();
        MOSTRAR = new javax.swing.JButton();
        SAIR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EX2 - REDE HOTELARIA");
        setBackground(new java.awt.Color(226, 226, 226));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(10, 2));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome do hotel");
        getContentPane().add(jLabel2);

        getContentPane().add(T1);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Saldo");
        getContentPane().add(jLabel3);

        T2.setName(""); // NOI18N
        getContentPane().add(T2);

        C1.setBackground(new java.awt.Color(255, 255, 255));
        C1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        C1.setForeground(new java.awt.Color(0, 5, 255));
        C1.setText("RH");
        C1.setActionCommand("");
        getContentPane().add(C1);
        C1.getAccessibleContext().setAccessibleName("RH");

        J2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(J2);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Salarios pagos (custos)");
        getContentPane().add(jLabel4);

        getContentPane().add(T3);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Arrecadação (lucros)");
        getContentPane().add(jLabel5);

        getContentPane().add(T4);

        C2.setBackground(new java.awt.Color(255, 255, 255));
        C2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        C2.setForeground(new java.awt.Color(6, 244, 126));
        C2.setText("Almoxarifado e Materiais");
        getContentPane().add(C2);

        J1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(J1);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Valor total de impostos (custos)");
        getContentPane().add(jLabel7);

        getContentPane().add(T5);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vendas (lucros)");
        getContentPane().add(jLabel9);

        getContentPane().add(T6);

        MOSTRAR.setBackground(new java.awt.Color(254, 254, 254));
        MOSTRAR.setForeground(new java.awt.Color(25, 242, 10));
        MOSTRAR.setText("MOSTRAR");
        MOSTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MOSTRARActionPerformed(evt);
            }
        });
        getContentPane().add(MOSTRAR);

        SAIR.setBackground(new java.awt.Color(254, 254, 254));
        SAIR.setForeground(new java.awt.Color(255, 0, 0));
        SAIR.setText("SAIR");
        getContentPane().add(SAIR);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MOSTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MOSTRARActionPerformed
        nome = T1.getText();
        saldo = T2.getText();
        saldod = Double.parseDouble(saldo);
        rh = C1.isSelected();
        am = C2.isSelected();

        if (rh == true) {
            custoRH = T3.getText();
            custoRHd = Double.parseDouble(custoRH);
            lucroRH = T4.getText();
            lucroRHd = Double.parseDouble(lucroRH);
        }
        if (am == true) {
            custoAM = T5.getText();
            custoAMd = Double.parseDouble(custoAM);
            lucroAM = T6.getText();
            lucroAMd = Double.parseDouble(lucroAM);
        }
        mostrarDados();
    }//GEN-LAST:event_MOSTRARActionPerformed

    public void mostrarDados() {
        if (rh == true) {
            SetorRH rh1 = new SetorRH(lucroRHd, custoRHd, saldod, nome);
            rh1.extrato();
        }
        if (am == true){
            Almoxarifado_Materiais am1 = new Almoxarifado_Materiais (custoAMd, lucroAMd, saldod, nome);
            am1.extrato();
        }
        if (am == true && rh == true){
            SetorRH rh1 = new SetorRH(lucroRHd, custoRHd, saldod, nome);
             Almoxarifado_Materiais am1 = new Almoxarifado_Materiais (custoAMd, lucroAMd, saldod, nome);
             double saldoFinal = (rh1.extrato() + am1.extrato());
             System.out.println("------------- FINAL ------------");
             System.out.println("Saldo final: " + saldoFinal); 
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostraHotelaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostraHotelaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostraHotelaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostraHotelaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostraHotelaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox C1;
    private javax.swing.JCheckBox C2;
    private javax.swing.JLabel J1;
    private javax.swing.JLabel J2;
    private javax.swing.JButton MOSTRAR;
    private javax.swing.JButton SAIR;
    private javax.swing.JTextField T1;
    private javax.swing.JTextField T2;
    private javax.swing.JTextField T3;
    private javax.swing.JTextField T4;
    private javax.swing.JTextField T5;
    private javax.swing.JTextField T6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
