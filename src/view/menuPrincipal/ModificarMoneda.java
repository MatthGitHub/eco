/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menuPrincipal;

import eco.entidades.Moneda;
import eco.servicios.moneda.TraerMonedas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ModificarMoneda extends javax.swing.JFrame {
    private MenuPrincipal mPpal;
    private static String fondo;
    private Image background;
    private static ModificarMoneda form;
    private TraerMonedas traerM;
    private List <Moneda> miLista;
    private Moneda miMo;
    private eco.servicios.moneda.ModificarMoneda guardarM;
    
    /**
     * Creates new form ModificarMoneda
     */
    private ModificarMoneda() {
        initComponents();
        fondo = "src/eco/resources/Monedas.jpg";
        setBackground(fondo);
        miLista = new ArrayList<>();
        llenarComboBox();
        
        setLocationRelativeTo(mPpal);
        btn_guardar.setEnabled(false);
        lbl_costoM.setVisible(false);
        lbl_costoN.setVisible(false);
        lbl_costoActual.setVisible(false);
        txt_costoNuevo.setVisible(false);
        setSize(370, 277);
        setVisible(true);
    }
    
    public static ModificarMoneda getModificarMoneda(){
        if(form == null){
            form = new ModificarMoneda();
        }
        return form;
    }
    
    private void llenarComboBox(){
        traerM = new TraerMonedas();
        miLista = traerM.traerMonedas();
        for(int i = 0 ; i < miLista.size(); i++){
            cmbx_monedas.addItem(miLista.get(i));
        }
    }
    
     // Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
    public void paintComponent(Graphics g) {

        /* Obtenemos el tamaño del panel para hacer que se ajuste a este
         cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
        int width = this.getSize().width;
        int height = this.getSize().height;

        // Mandamos que pinte la imagen en el panel
        if (this.background != null) {
            g.drawImage(this.background, 0, 0, width, height, null);
        }

        paintComponent(g);
    }

    // Metodo donde le pasaremos la dirección de la imagen a cargar.
    public void setBackground(String imagePath) {

        // Construimos la imagen y se la asignamos al atributo background.
        miPanel.setOpaque(false);
        this.background = new ImageIcon(imagePath).getImage();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miPanel = new javax.swing.JPanel();
        cmbx_monedas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btn_listo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        lbl_costoM = new javax.swing.JLabel();
        lbl_costoN = new javax.swing.JLabel();
        lbl_costoActual = new javax.swing.JLabel();
        txt_costoNuevo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 51)), "Modificar monedas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 24), new java.awt.Color(0, 204, 0))); // NOI18N
        miPanel.setForeground(new java.awt.Color(0, 204, 51));

        cmbx_monedas.setBackground(new java.awt.Color(0, 204, 51));
        cmbx_monedas.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Moneda a modificar: ");

        btn_listo.setBackground(new java.awt.Color(0, 153, 0));
        btn_listo.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        btn_listo.setText("Listo");
        btn_listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listoActionPerformed(evt);
            }
        });

        btn_guardar.setBackground(new java.awt.Color(0, 153, 0));
        btn_guardar.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_aceptar.setBackground(new java.awt.Color(0, 153, 0));
        btn_aceptar.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        lbl_costoM.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lbl_costoM.setForeground(new java.awt.Color(0, 153, 51));
        lbl_costoM.setText("Costo moneda:");

        lbl_costoN.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lbl_costoN.setForeground(new java.awt.Color(0, 153, 51));
        lbl_costoN.setText("Costo nuevo:");

        lbl_costoActual.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lbl_costoActual.setForeground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout miPanelLayout = new javax.swing.GroupLayout(miPanel);
        miPanel.setLayout(miPanelLayout);
        miPanelLayout.setHorizontalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanelLayout.createSequentialGroup()
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, miPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbx_monedas, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, miPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_aceptar))
                    .addGroup(miPanelLayout.createSequentialGroup()
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_costoN, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_costoM, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(miPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_costoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(miPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_costoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(miPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btn_listo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        miPanelLayout.setVerticalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbx_monedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_costoM)
                    .addComponent(lbl_costoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_costoN)
                    .addComponent(txt_costoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_listo)
                    .addComponent(btn_guardar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        form = null;
        System.gc();
    }//GEN-LAST:event_btn_listoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        if((txt_costoNuevo.getText().trim().length() > 0&&(!txt_costoNuevo.getText().contains(",")))){
            guardarM = new eco.servicios.moneda.ModificarMoneda();
            miMo.setCosto(Float.parseFloat(txt_costoNuevo.getText()));
            if(guardarM.modificarMoneda(miMo)){
                JOptionPane.showMessageDialog(this, "Costo modificado!");
                mPpal.lbl_dolar.setText(Float.toString(miMo.getCosto()));
            }else{
                JOptionPane.showMessageDialog(this, "Error al modificar el costo!");
            }
            this.setVisible(false);
            form = null;
            System.gc();
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un costo y si es decimal usar punto no coma.");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        miMo = (Moneda) cmbx_monedas.getSelectedItem();
        lbl_costoActual.setText(String.valueOf(miMo.getCosto()));
        lbl_costoM.setVisible(true);
        lbl_costoN.setVisible(true);
        lbl_costoActual.setVisible(true);
        txt_costoNuevo.setVisible(true);
        btn_guardar.setEnabled(true); 
    }//GEN-LAST:event_btn_aceptarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarMoneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarMoneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarMoneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarMoneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarMoneda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_listo;
    private javax.swing.JComboBox cmbx_monedas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_costoActual;
    private javax.swing.JLabel lbl_costoM;
    private javax.swing.JLabel lbl_costoN;
    private javax.swing.JPanel miPanel;
    private javax.swing.JTextField txt_costoNuevo;
    // End of variables declaration//GEN-END:variables
}
