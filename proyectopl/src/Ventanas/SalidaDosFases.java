/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.text.DecimalFormat;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class SalidaDosFases extends javax.swing.JFrame {
public double[][][] matrices;
    public String[] columnas;
    public DefaultTableModel modelo;
    
    public double[][][] matrices2;
    public String[] columnas2;
    public DefaultTableModel modelo2;
    /**
     * Creates new form SalidaArt
     */
    public SalidaDosFases() {
        initComponents();
        setDefaultCloseOperation(0);
        this.setLocationRelativeTo(null);
        DecimalFormat formateador = new DecimalFormat("####.##");
        double[] valores = new double[Ventanas.Entrada2.tabla_optima2.length];
        int i=0;
        for (double[] tabla_optima : Ventanas.Entrada2.tabla_optima2) {
            valores[i] = tabla_optima[tabla_optima.length-1];
            i++;
        }
        JLabel f = new JLabel();
        f.setFont(new java.awt.Font("Tahoma", 0, 14));
        f.setText("Z = "+valores[0]+" ");
        panel.add(f);
        int j=1;
        for (String var_basica : Ventanas.Entrada2.var_basicas2) {
            JLabel var = new JLabel();
            var.setFont(new java.awt.Font("Tahoma", 0, 14));
            var.setText(var_basica);
            panel.add(var);
            JLabel num = new JLabel();
            num.setFont(new java.awt.Font("Tahoma", 0, 14));
            num.setText(" = "+formateador.format(valores[j])+" ");
            panel.add(num);
            j++;
        }
        
        //INICIO DE FUMADA DE LUMPIA
        
         String[] columnas = new String[Ventanas.Entrada2.variables.length+1];
        int k;
        for (k = 0; k < Ventanas.Entrada2.variables.length; k++) {
            columnas[k] = Ventanas.Entrada2.variables[k];
                       
        }
        columnas[k] = "<html><p>Sol</p></html>";
        modelo = new DefaultTableModel(null,columnas);
        Iterator<double[][]> it = Ventanas.Entrada2.iteracionesFase1.iterator();
        
        int x=Ventanas.Entrada2.iteracionesFase1.size();
        
                
        String[] numerosIt= new String[x];
        for (int kj = 1; kj <= x; kj++) {
            numerosIt[kj-1] = String.valueOf(kj);
        }
        iteracionesBoxFase1.setFont(new java.awt.Font("Tahoma", 0, 14));
        iteracionesBoxFase1.setModel(new javax.swing.DefaultComboBoxModel(numerosIt));
        
        matrices = new double[x][Ventanas.Entrada2.fase1.length][Ventanas.Entrada2.fase1[0].length];
        
        x=0;
        while(it.hasNext()){
            matrices[x] = it.next();
            x++;
        }
        
        String fila[] = new String[columnas.length];
        for (int kj = 0; kj < Ventanas.Entrada2.fase1.length; kj++) {
            fila = new String[columnas.length];
            for (int l = 0; l < Ventanas.Entrada2.fase1[0].length; l++) {
                fila[l] = formateador.format(Ventanas.Entrada2.fase1[kj][l]);
            }
            modelo.addRow(fila);
            
        }
        tablafase1.setModel(modelo);
        
        
        //CON LA TABLA DE LA FASE 2
        String[] columnas2 = new String[Ventanas.Entrada2.variables2.length+1];
        int k2;
        for (k2 = 0; k2 < Ventanas.Entrada2.variables2.length; k2++) {
            columnas2[k2] = Ventanas.Entrada2.variables2[k2];
                       
        }
        columnas2[k2] = "<html><p>Sol</p></html>";
        modelo2 = new DefaultTableModel(null,columnas2);
        Iterator<double[][]> it2 = Ventanas.Entrada2.iteracionesFase2.iterator();
        
        int x2=Ventanas.Entrada2.iteracionesFase2.size();
        
                
        String[] numerosIt2= new String[x2];
        for (int kj = 1; kj <= x2; kj++) {
            numerosIt2[kj-1] = String.valueOf(kj);
        }
        iteracionesBoxFase2.setFont(new java.awt.Font("Tahoma", 0, 14));
        iteracionesBoxFase2.setModel(new javax.swing.DefaultComboBoxModel(numerosIt2));
        
        matrices2 = new double[x2][Ventanas.Entrada2.fase2.length][Ventanas.Entrada2.fase2[0].length];
        
        x2=0;
        while(it2.hasNext()){
            matrices2[x2] = it2.next();
            x2++;
        }
        
        String fila2[] = new String[columnas2.length];
        for (int kj = 0; kj < Ventanas.Entrada2.fase2.length; kj++) {
            fila2 = new String[columnas2.length];
            for (int l = 0; l < Ventanas.Entrada2.fase2[0].length; l++) {
                fila2[l] = formateador.format(Ventanas.Entrada2.fase2[kj][l]);
            }
            modelo2.addRow(fila2);
            
        }
        tablafase2.setModel(modelo2);
        
        if(Ventanas.Proyecto.noAcotada){
            JOptionPane.showConfirmDialog(this, "Solución no acotada", "Atención",i);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labeltitulo1 = new javax.swing.JLabel();
        botonregresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iteracionesBoxFase2 = new javax.swing.JComboBox();
        iteracionesBoxFase1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        veriteracionFase2 = new javax.swing.JButton();
        veriteracionFase1 = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labeltitulo2 = new javax.swing.JLabel();
        botonregresar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        iteracionesBoxFase3 = new javax.swing.JComboBox();
        iteracionesBoxFase4 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        veriteracionFase3 = new javax.swing.JButton();
        veriteracionFase4 = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablafase1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablafase2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labeltitulo1.setText("Modelo de Programación Lineal");
        jPanel1.add(labeltitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 50));

        botonregresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonregresar.setText("Regresar");
        botonregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonregresarActionPerformed(evt);
            }
        });
        jPanel1.add(botonregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 90, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fase 2");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fase 1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jPanel1.add(iteracionesBoxFase2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jPanel1.add(iteracionesBoxFase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Iteración:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Iteración:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 20));

        veriteracionFase2.setText("Ver iteración");
        veriteracionFase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veriteracionFase2ActionPerformed(evt);
            }
        });
        jPanel1.add(veriteracionFase2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        veriteracionFase1.setText("Ver iteración");
        veriteracionFase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veriteracionFase1ActionPerformed(evt);
            }
        });
        jPanel1.add(veriteracionFase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 370, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Solución:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labeltitulo2.setText("Modelo de Programación Lineal");
        jPanel2.add(labeltitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 50));

        botonregresar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonregresar1.setText("Regresar");
        botonregresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonregresar1ActionPerformed(evt);
            }
        });
        jPanel2.add(botonregresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 90, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fase 2");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Fase 1");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jPanel2.add(iteracionesBoxFase3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jPanel2.add(iteracionesBoxFase4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Iteración:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Iteración:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 20));

        veriteracionFase3.setText("Ver iteración");
        veriteracionFase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veriteracionFase3ActionPerformed(evt);
            }
        });
        jPanel2.add(veriteracionFase3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        veriteracionFase4.setText("Ver iteración");
        veriteracionFase4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veriteracionFase4ActionPerformed(evt);
            }
        });
        jPanel2.add(veriteracionFase4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 370, 60));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Solución:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, -1));

        tablafase1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablafase1);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 470, 100));

        tablafase2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablafase2);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 470, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregresarActionPerformed
        // TODO add your handling code here:
        //int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere ir a la pantalla anterior? Se perderán todos los cambios efectuados", "Atención", YES_NO_OPTION, QUESTION_MESSAGE);
        //if(resp == JOptionPane.YES_OPTION){
            this.setVisible(false);
            //new Entrada2().setVisible(true);

            //}
    }//GEN-LAST:event_botonregresarActionPerformed

    private void veriteracionFase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veriteracionFase2ActionPerformed
        DecimalFormat formateador = new DecimalFormat("####.##");
        int iteracion =Integer.parseInt(iteracionesBoxFase2.getSelectedItem().toString());
        String[] columnas2 = new String[Ventanas.Entrada2.variables2.length+1];
        int k;
        for (k = 0; k < Ventanas.Entrada2.variables2.length; k++) {
            columnas2[k] = Ventanas.Entrada2.variables2[k];

        }
        columnas2[k] = "<html><p>Sol</p></html>";
        modelo2 = new DefaultTableModel(null,columnas2);
        String fila2[] = new String[Ventanas.Entrada2.variables2.length+1];

        for (int kj = 0; kj < Ventanas.Entrada2.tabla_optima2.length; kj++) {
            fila2 = new String[Ventanas.Entrada2.variables2.length+1];
            for (int l = 0; l < Ventanas.Entrada2.tabla_optima2[0].length; l++) {
                fila2[l] = formateador.format(matrices2[iteracion-1][kj][l]);
            }
            modelo2.addRow(fila2);

        }
        tablafase2.setModel(modelo2);      // TODO add your handling code here:
    }//GEN-LAST:event_veriteracionFase2ActionPerformed

    private void veriteracionFase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veriteracionFase1ActionPerformed
        DecimalFormat formateador = new DecimalFormat("####.##");
        int iteracion =Integer.parseInt(iteracionesBoxFase1.getSelectedItem().toString());
        String[] columnas = new String[Ventanas.Entrada2.variables.length+1];
        int k;
        for (k = 0; k < Ventanas.Entrada2.variables.length; k++) {
            columnas[k] = Ventanas.Entrada2.variables[k];

        }
        columnas[k] = "<html><p>Sol</p></html>";
        modelo = new DefaultTableModel(null,columnas);
        String fila[] = new String[Ventanas.Entrada2.variables.length+1];

        for (int kj = 0; kj < Ventanas.Entrada2.fase1.length; kj++) {
            fila = new String[Ventanas.Entrada2.variables.length+1];
            for (int l = 0; l < Ventanas.Entrada2.fase1[0].length; l++) {
                fila[l] = formateador.format(matrices[iteracion-1][kj][l]);
            }
            modelo.addRow(fila);

        }
        tablafase1.setModel(modelo);      // TODO add your handling code here:
    }//GEN-LAST:event_veriteracionFase1ActionPerformed

    private void botonregresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregresar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonregresar1ActionPerformed

    private void veriteracionFase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veriteracionFase3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_veriteracionFase3ActionPerformed

    private void veriteracionFase4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veriteracionFase4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_veriteracionFase4ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SalidaDosFases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalidaDosFases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalidaDosFases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalidaDosFases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalidaDosFases().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonregresar;
    private javax.swing.JButton botonregresar1;
    private javax.swing.JComboBox iteracionesBoxFase1;
    private javax.swing.JComboBox iteracionesBoxFase2;
    private javax.swing.JComboBox iteracionesBoxFase3;
    private javax.swing.JComboBox iteracionesBoxFase4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labeltitulo1;
    private javax.swing.JLabel labeltitulo2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JTable tablafase1;
    private javax.swing.JTable tablafase2;
    private javax.swing.JButton veriteracionFase1;
    private javax.swing.JButton veriteracionFase2;
    private javax.swing.JButton veriteracionFase3;
    private javax.swing.JButton veriteracionFase4;
    // End of variables declaration//GEN-END:variables
}
