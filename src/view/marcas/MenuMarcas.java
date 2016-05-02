/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.marcas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import view.main.Main;

/**
 *
 * @author Matias Benditti
 */
public class MenuMarcas extends javax.swing.JPanel {
    Main mainFrame;
    private static MenuMarcas menu;
    private static String fondo;
    private Image background;
    /**
     * Creates new form MenuMarcas
     */
    private MenuMarcas(Main mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        fondo = "src/eco/resources/Marcas.jpg";
        setBackground(fondo);
        setVisible(true);
        setSize(1024, 700);
    }
    public static MenuMarcas getMenuMarcas(Main mainFrame){
        if(menu == null){
            menu = new MenuMarcas(mainFrame);
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

        btn_salir = new javax.swing.JButton();
        btn_verTodas = new javax.swing.JButton();
        btn_cargarNueva = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 102, 0)), "Marcas", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 36), new java.awt.Color(255, 102, 0))); // NOI18N

        btn_salir.setBackground(new java.awt.Color(255, 102, 0));
        btn_salir.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(0, 0, 0));
        btn_salir.setText("Volver");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_verTodas.setBackground(new java.awt.Color(255, 102, 0));
        btn_verTodas.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_verTodas.setForeground(new java.awt.Color(0, 0, 0));
        btn_verTodas.setText("Ver todas");
        btn_verTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verTodasActionPerformed(evt);
            }
        });

        btn_cargarNueva.setBackground(new java.awt.Color(255, 102, 0));
        btn_cargarNueva.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_cargarNueva.setForeground(new java.awt.Color(0, 0, 0));
        btn_cargarNueva.setText("Cargar nueva");
        btn_cargarNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarNuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_cargarNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_verTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btn_verTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cargarNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(btn_salir)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
       mainFrame.menuPrincipal();
       this.setVisible(false);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_verTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verTodasActionPerformed
        // TODO add your handling code here:
        mainFrame.verTodasLasMarcas();
        this.setVisible(false);
    }//GEN-LAST:event_btn_verTodasActionPerformed

    private void btn_cargarNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarNuevaActionPerformed
        // TODO add your handling code here:
        mainFrame.formularioCargaMarca();
        this.setVisible(false);
    }//GEN-LAST:event_btn_cargarNuevaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cargarNueva;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_verTodas;
    // End of variables declaration//GEN-END:variables
}
