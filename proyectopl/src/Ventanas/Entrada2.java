/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import static Ventanas.Entrada1.n;
import static Ventanas.Entrada1.m;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTextField;
/* Cosas que aparentemente son inutiles y seran borradas posiblemente
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
*/


/**
 *
 * @author Eduardo
 */
public class Entrada2 extends javax.swing.JFrame {
    //public double[][] miMatriz;
    
    
    /* TODO ESTO ES LO QUE ES UTILIZADO EN LAS SALIDAS */
    public static String[] var_basicas2;
    public static double[][] tabla_optima2;
    public static List<double[][]> iteraciones2;// = new ArrayList<>();;
    
    public static List<double[][]> iteraciones; // = new ArrayList<>();;
    public static String[] var_basicas;
    public static double[][] tabla_optima;
    
    public static String[] variables;
    public static String[] variables2;
    public static double[][] fase2;
    public static double[][] fase1;
    public static List<double[][]> iteracionesFase1;
    public static List<double[][]> iteracionesFase2;
    
    
    
    
    /*HASTA AQUI*/
    
    
    public double[][] matriz = new double[m+1][n+1]; //lo que se va a usar para hacer los calculos.. 
    //Listas que controlaran los datos de la funcion objetivo
    public List <JTextField> lcoeficientes; //Los coeficientes
    //public List <JComboBox> lsignos; //Los signos
    
    //Listas que controlaran los datos de las restricciones
    //public List <JComboBox> lsignosrestricciones; //Los signos de los consumos de cada actividad
    public List <JTextField> lconsumos; //Los consumos de cada actividad 
    public List <JComboBox> lcondiciones; //Las condiciones (Mayor o igual, menor o igual o igual)
    //public List <JTextField> lparametros; //Los parametros de cada actividad
    /**
     * Creates new form Entrada2
     */
    public Entrada2() {
        initComponents();
        this.setLocationRelativeTo(null); //Pongo la ventana en el centro de la pantalla
        this.setSize(710, 380); //Pongo Dimensiones del Frame por defecto (Por precaucion)
        this.panel.setSize(710, 380); //Pongo Dimenciones del panel del frame por defecto (Para asegurar que el panel sea del mismo tamaño del Frame, siempre)
        this.panel.setLocation(0, 0); //Pongo ubicacion del panel en la coordenada 0,0 del frame para asegurarme que siempre esté en su sitio
        
        //Inicializo las listas que controlaran mis datos de entrada
        lcoeficientes = new ArrayList<>();
        //lsignos = new ArrayList<>();
        //lsignosrestricciones = new ArrayList<>();
        lconsumos = new ArrayList<>();
        lcondiciones = new ArrayList<>();
        //lparametros = new ArrayList<>();
        //Introduzco todos los componentes que serviran para la entrada de datos
        for (int i = 0; i < n ; i++) {
            if (i>=1) {
                JLabel signo = new JLabel();
                signo.setFont(new java.awt.Font("Tahoma", 0, 14));
                signo.setText("+");
                panelfuncion.add(signo);
            }
            
            //JComboBox signo = new JComboBox();
            JTextField coeficiente = new JTextField(5); //Pendiente validacion de todos los coeficientes ingresables
            JLabel variable = new JLabel();
           
            //El combobox del signo
            //signo.setFont(new java.awt.Font("Tahoma", 0, 14));
            //signo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-" }));
            
            //El jtextfield del coeficiente
            coeficiente.setFont(new java.awt.Font("Tahoma", 0, 14));
            coeficiente.addKeyListener(new java.awt.event.KeyAdapter(){});
            coeficiente.setText("0");
            
           
            //El label de la variable
            variable.setFont(new java.awt.Font("Tahoma", 0, 14));
            String cadena = "<html><p>X<sub>"+(i+1)+"</sub></p></html>";
            variable.setText(cadena);
            
            //panelfuncion.add(signo); //Los añado al panel
            //lsignos.add(signo); //Los ingreso en la lista
            panelfuncion.add(coeficiente); //Añado al panel
            lcoeficientes.add(coeficiente); //Ingreso en la lista
            panelfuncion.add(variable); //Añado al panel (No necesito ingresar en la lista porque es simplemente un label)
            
            panelfuncion.updateUI();
            
            
        }
        
        for (int i = 0; i < m; i++) {
            JLabel titulo = new JLabel();
            //El label del titulo
            titulo.setFont(new java.awt.Font("Tahoma", 0, 14));
            titulo.setText(" Restricción "+(i+1)+": ");
            panelrestricciones.add(titulo);
            for (int j = 0; j < n; j++) {
                if (j>=1) {
                    JLabel signo = new JLabel();
                    signo.setFont(new java.awt.Font("Tahoma", 0, 14));
                    signo.setText("+");
                    panelrestricciones.add(signo);
                }
                //JComboBox signorestriccion = new JComboBox();
                JTextField consumo = new JTextField(5);
                JLabel variable = new JLabel();
               
                //El combobox
                //signorestriccion.setFont(new java.awt.Font("Tahoma", 0, 14));
                //signorestriccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-" }));
               
               
                //El jtextfield del coeficiente
                consumo.setFont(new java.awt.Font("Tahoma", 0, 14));
                consumo.addKeyListener(new java.awt.event.KeyAdapter(){});
            
                //El label de la variable
                variable.setFont(new java.awt.Font("Tahoma", 0, 14));
                String cadena = "<html><p>X<sub>"+(j+1)+"</sub></p></html>";
                variable.setText(cadena);
           
                //panelrestricciones.add(signorestriccion);
                panelrestricciones.add(consumo);
                panelrestricciones.add(variable);
               
                //lsignosrestricciones.add(signorestriccion);
                lconsumos.add(consumo);
                }
            JComboBox condicion = new JComboBox();
            JTextField parametro = new JTextField(5);
            
            condicion.setFont(new java.awt.Font("Tahoma", 0, 14));
            condicion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ">=", "<=", "=" }));
            
            
            parametro.setFont(new java.awt.Font("Tahoma", 0, 14));
            parametro.addKeyListener(new java.awt.event.KeyAdapter(){});
            
            
            panelrestricciones.add(condicion);
            panelrestricciones.add(parametro);
            
            lcondiciones.add(condicion);
            lconsumos.add(parametro);
           
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

        panel = new javax.swing.JPanel();
        labeltitulo = new javax.swing.JLabel();
        botonregresar = new javax.swing.JButton();
        scrollfuncion = new javax.swing.JScrollPane();
        panelfuncion = new javax.swing.JPanel();
        labelvistaprevia = new javax.swing.JLabel();
        labelequal = new javax.swing.JLabel();
        funcion = new javax.swing.JComboBox();
        scrollrestricciones = new javax.swing.JScrollPane();
        panelrestricciones = new javax.swing.JPanel();
        botoncontinuar = new javax.swing.JButton();
        labelvistaprevia1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(710, 480));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labeltitulo.setText("Modelo de Programación Lineal");
        panel.add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        botonregresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonregresar.setText("Regresar");
        botonregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonregresarActionPerformed(evt);
            }
        });
        panel.add(botonregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 100, 30));

        panelfuncion.setBackground(new java.awt.Color(255, 255, 255));
        scrollfuncion.setViewportView(panelfuncion);

        panel.add(scrollfuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 480, 60));

        labelvistaprevia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelvistaprevia.setText("Sujeto a:");
        panel.add(labelvistaprevia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        labelequal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelequal.setText("=");
        panel.add(labelequal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        funcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        funcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Max", "Min" }));
        funcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionActionPerformed(evt);
            }
        });
        panel.add(funcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        panelrestricciones.setBackground(new java.awt.Color(255, 255, 255));
        scrollrestricciones.setViewportView(panelrestricciones);

        panel.add(scrollrestricciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 540, 60));

        botoncontinuar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botoncontinuar.setText("Continuar");
        botoncontinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botoncontinuarMouseClicked(evt);
            }
        });
        botoncontinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncontinuarActionPerformed(evt);
            }
        });
        panel.add(botoncontinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 110, 30));

        labelvistaprevia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelvistaprevia1.setText("Ingrese los datos requeridos: ");
        panel.add(labelvistaprevia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Z");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregresarActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere ir a la pantalla anterior? Se perderán todos los cambios efectuados", "Atención", YES_NO_OPTION, QUESTION_MESSAGE);
        if(resp == JOptionPane.YES_OPTION){
          this.setVisible(false);
          new Entrada1().setVisible(true);  
          lcoeficientes.clear();
          //lsignos.clear();              
          //lsignosrestricciones.clear(); 
          lconsumos.clear();            
          lcondiciones.clear();         
          //lparametros.clear();
        }
        

    }//GEN-LAST:event_botonregresarActionPerformed

    private void botoncontinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncontinuarActionPerformed
        // TODO add your handling code here:
        try{
        Proyecto obj = new Proyecto();
        Iterator<JTextField> it = lcoeficientes.iterator();
        int i = 0, j = 0;
        while (it.hasNext()) {
            String algo = it.next().getText();
            if(algo.charAt(0)=='-'){
                algo=algo.substring(1);
                double numero=Double.parseDouble(algo);
                numero = (-1)*numero;
                matriz[i][j] = numero;
            }else{
                double numero=Double.parseDouble(algo);
                matriz[i][j] = numero;
            }
            j++;
        }
        j = 0;
        i = 1;
        Iterator<JTextField> eso = lconsumos.iterator();
        while (eso.hasNext()){
            String algo = eso.next().getText();
            if(algo.charAt(0)=='-'){
                algo=algo.substring(1);
                double numero=Double.parseDouble(algo);
                numero = (-1)*numero;
                matriz[i][j] = numero;
            }else{
                double numero=Double.parseDouble(algo);
                matriz[i][j] = numero;
            }
            if(j==n){
                i++;
                j = 0;
            }else{
                j++;
            }
        }
        //ojo
        Iterator <JComboBox> otro = lcondiciones.iterator();
        i = 0;
        String[] arreglo = new String[lcondiciones.size()];
        while (otro.hasNext()) {
            arreglo[i] = otro.next().getSelectedItem().toString();
            i++;
        }
        
        String[] basicas2;
        String[] basicas4;
        String[] todas2 ;
        
        double[][] nmatriz = new double[matriz.length][matriz[0].length];
        double[] fila0;
        
        int[] vbasicas;
        nmatriz = obj.forma_estandar(matriz, arreglo);
        
        fila0 = obj.copiar_fila(nmatriz[0]);
        vbasicas=obj.verificar(nmatriz);
        
        obj.principal=obj.actualizar_matriz(obj.principal, nmatriz);
        
        todas2 = obj.rellenar();
        variables = todas2;
        basicas2=obj.rellenar_basicas(vbasicas, todas2);
        basicas4 = obj.copiar(basicas2);
        obj.principal[0]=obj.emes(todas2, funcion.getSelectedItem().toString());
        
        double[][] miMatriz = new double[obj.principal.length][obj.principal[0].length];
        miMatriz = obj.principal;
        
        double[][] miMatrizCopia = obj.copiar(miMatriz);
                //hola
        if(!obj.conArtificiales(todas2)){
            miMatriz = obj.metodo_simplex(basicas2, todas2 , miMatriz, funcion.getSelectedItem().toString());
            iteraciones = new ArrayList<>();
            iteraciones = obj.iteraciones;
            tabla_optima = miMatriz;
            var_basicas = obj.basicas3;
            Salida obj2 = new Salida();
            obj2.setVisible(true);
        }else{
            //tecnica M
            miMatrizCopia = obj.metodo_simplex(basicas2, todas2 , miMatrizCopia, funcion.getSelectedItem().toString());
            iteraciones = new ArrayList<>();
            iteraciones = obj.iteraciones;
            tabla_optima = miMatrizCopia;
            var_basicas = obj.basicas3;
            
            //metodo de dos fases
            //FASE 1
            miMatriz[0]=obj.renglo0Fase1(miMatriz[0]);
            miMatriz = obj.metodo_simplex(basicas4, todas2, miMatriz, "Min"); //ojo aqui es siempre minimizando
            var_basicas2=obj.basicas3;
            fase1 = miMatriz;
            iteracionesFase1 = obj.iteraciones;
            
            
            //FASE2
            fase2 = obj.mifase2(miMatriz,fila0);
            todas2=obj.convertir_todas(todas2);
            variables2=todas2;
            fase2 = obj.metodo_simplex(var_basicas2, todas2, fase2, funcion.getSelectedItem().toString());
            tabla_optima2 = fase2;
            iteracionesFase2 = obj.iteraciones;
            var_basicas2 = obj.basicas3;
            for (int k = 0; k < fase2.length; k++) {
                for (int l = 0; l < fase2[k].length; l++) {
                    System.out.print(fase2[k][l]+" ,");
                    
                }
                System.out.println(" ");
            }
            
            if(obj.noAcotada){
                JOptionPane.showMessageDialog(null, "Solución no acotada", "Atención", ERROR_MESSAGE);
            }
            System.out.println(obj.noAcotada);
            SalidaArt obj3 = new SalidaArt();
            obj3.setVisible(true);
            
            
            
        }
        /*obj.principal = obj.metodo_simplex(basicas2, todas2 , obj.principal, funcion.getSelectedItem().toString());
        tabla_optima = obj.principal;
        var_basicas = obj.basicas3;
        this.setVisible(false);
        new Salida().setVisible(true);*/
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Por favor ingrese los datos correctamente.", "Error", ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_botoncontinuarActionPerformed

    private void botoncontinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botoncontinuarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botoncontinuarMouseClicked

    private void funcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_funcionActionPerformed

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
            java.util.logging.Logger.getLogger(Entrada2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrada2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrada2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrada2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entrada2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncontinuar;
    private javax.swing.JButton botonregresar;
    private javax.swing.JComboBox funcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelequal;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JLabel labelvistaprevia;
    private javax.swing.JLabel labelvistaprevia1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelfuncion;
    private javax.swing.JPanel panelrestricciones;
    private javax.swing.JScrollPane scrollfuncion;
    private javax.swing.JScrollPane scrollrestricciones;
    // End of variables declaration//GEN-END:variables

    private Object Entrada1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
