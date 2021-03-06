/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.proveedores;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import view.main.Main;

/**
 *
 * @author Administrador
 */
public class MenuProveedores extends javax.swing.JPanel {
    Main mainFrame;
    private static String fondo;
    private Image background;
    private static MenuProveedores menu;
    /**
     * Creates new form MenuProveedores
     */
    private MenuProveedores(Main mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        fondo = "src/eco/resources/Proveedores.jpg";
        setBackground(fondo);
        setVisible(true);
        setSize(1024, 700);
    }
    
    public static MenuProveedores getMenuProveedores(Main mainFrame){
        if(menu == null){
            menu = new MenuProveedores(mainFrame);
        }
        return menu;
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

        super.paintComponent(g);
    }

    // Metodo donde le pasaremos la dirección de la imagen a cargar.
    public void setBackground(String imagePath) {

        // Construimos la imagen y se la asignamos al atributo background.
        this.setOpaque(false);
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

        btn_cargarNuevo = new javax.swing.JButton();
        btn_salir1 = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)), "Menu Proveedores", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 36), new java.awt.Color(255, 51, 0))); // NOI18N

        btn_cargarNuevo.setBackground(new java.awt.Color(255, 102, 0));
        btn_cargarNuevo.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_cargarNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btn_cargarNuevo.setText("Cargar nuevo");
        btn_cargarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarNuevoActionPerformed(evt);
            }
        });

        btn_salir1.setBackground(new java.awt.Color(255, 102, 0));
        btn_salir1.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_salir1.setForeground(new java.awt.Color(0, 0, 0));
        btn_salir1.setText("Ver todos");
        btn_salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir1ActionPerformed(evt);
            }
        });

        btn_salir.setBackground(new java.awt.Color(255, 102, 0));
        btn_salir.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(0, 0, 0));
        btn_salir.setText("Volver");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cargarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btn_salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cargarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cargarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarNuevoActionPerformed
        // TODO add your handling code here:
        mainFrame.formularioCargaProveedor();
        this.setVisible(false);
    }//GEN-LAST:event_btn_cargarNuevoActionPerformed

    private void btn_salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir1ActionPerformed
        // TODO add your handling code here:
        mainFrame.verTodosProveedores();
        this.setVisible(false);
    }//GEN-LAST:event_btn_salir1ActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        mainFrame.menuPrincipal();
        this.setVisible(false);
    }//GEN-LAST:event_btn_salirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cargarNuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_salir1;
    // End of variables declaration//GEN-END:variables
}
