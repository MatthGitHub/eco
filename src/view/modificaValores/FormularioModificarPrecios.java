/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modificaValores;

import eco.entidades.Marca;
import eco.entidades.Producto;
import eco.entidades.Proveedor;
import eco.servicios.marcas.TraerMarcas;
import util.ModificarPrecios;
import eco.servicios.productos.TraerProductos;
import eco.servicios.proveedores.TraerProveedores;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import view.main.Main;

/**
 *
 * @author Administrador
 */
public class FormularioModificarPrecios extends javax.swing.JPanel {

    Main mainFrame;
    private static FormularioModificarPrecios form;
    private int flag;
    private static String fondo;
    private Image background;
    private TraerMarcas traeM;
    private TraerProveedores traeP;
    private List<Proveedor> miListaP;
    private List<Marca> miListaM;
    private Marca miMarca;
    private Proveedor miProv;
    private ModificarPrecios modificaP;
    private List<Producto> miListaProd;
    private TraerProductos traeProd;

    /**
     * Creates new form FormularioModificarPrecios
     */
    private FormularioModificarPrecios(Main mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        miListaM = new ArrayList<>();
        miListaP = new ArrayList<>();
        fondo = "src/eco/resources/Modificar.jpeg";
        setBackground(fondo);
        cmbx_marca.setVisible(false);
        cmbx_proveedor.setVisible(false);
        txt_aumentar.setVisible(false);
        lbl_aumentar.setVisible(false);
        btn_guardar.setEnabled(false);
        llenarComboMarcas();
        llenarComboProveedores();
        setSize(1024, 700);
        setVisible(true);
    }

    public static FormularioModificarPrecios getFormularioModificarPrecios(Main mainFrame) {
        if (form == null) {
            form = new FormularioModificarPrecios(mainFrame);
        }
        return form;
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
     * Llenar los comboBox
     */
    public void llenarComboMarcas() {
        traeM = new TraerMarcas();
        miListaM = traeM.TraerMarcas();

        for (int i = 0; i < miListaM.size(); i++) {
            cmbx_marca.addItem(miListaM.get(i));
        }
    }

    public void llenarComboProveedores() {
        traeP = new TraerProveedores();
        miListaP = traeP.TraerProveedores();

        for (int i = 0; i < miListaP.size(); i++) {
            cmbx_proveedor.addItem(miListaP.get(i));
        }
    }

    /**
     * Validar todos los check_boxes
     *
     * @return
     */
    public int validacion_checkBox() {
        if ((chkbx_monto.isSelected()) && (chkbx_porcentaje.isSelected())) {
            JOptionPane.showMessageDialog(this, "Debe tildar monto o porcentaje, no ambas!", "Error en 'A aumentar'", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        if (!(chkbx_monto.isSelected()) && !(chkbx_porcentaje.isSelected())) {
            JOptionPane.showMessageDialog(this, "Debe tildar monto o porcentaje", "Error en 'A aumentar'", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        if ((chkbx_monto.isSelected())) {
            lbl_aumentar.setText("Ingrese monto a aumentar:");
            lbl_aumentar.setVisible(true);
            txt_aumentar.setVisible(true);
            if (chkbx_marca.isSelected()) {
                cmbx_marca.setVisible(true);
                btn_guardar.setEnabled(true);
            }
            if (chkbx_proveedor.isSelected()) {
                cmbx_proveedor.setVisible(true);
                btn_guardar.setEnabled(true);
            }
            return 1;
        }
        if ((chkbx_porcentaje.isSelected())) {
            lbl_aumentar.setText("Ingrese porcentaje a aumentar:");
            lbl_aumentar.setVisible(true);
            txt_aumentar.setVisible(true);
            if (chkbx_marca.isSelected()) {
                cmbx_marca.setVisible(true);
            }
            if (chkbx_proveedor.isSelected()) {
                cmbx_proveedor.setVisible(true);
            }
            return 2;
        }
        JOptionPane.showMessageDialog(this, "Debe tildar las casillas!");
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        chkbx_marca = new javax.swing.JCheckBox();
        chkbx_proveedor = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        chkbx_monto = new javax.swing.JCheckBox();
        chkbx_porcentaje = new javax.swing.JCheckBox();
        btn_guardar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        cmbx_marca = new javax.swing.JComboBox();
        cmbx_proveedor = new javax.swing.JComboBox();
        txt_aumentar = new javax.swing.JTextField();
        btn_aceptar = new javax.swing.JButton();
        lbl_aumentar = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)), "Modificar precios", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 36), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jLabel2.setText("Refinar por: ");

        chkbx_marca.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        chkbx_marca.setForeground(new java.awt.Color(255, 51, 0));
        chkbx_marca.setText("Marca");

        chkbx_proveedor.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        chkbx_proveedor.setForeground(new java.awt.Color(255, 51, 0));
        chkbx_proveedor.setText("Proveedor");

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jLabel3.setText("Aumentar por: ");

        chkbx_monto.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        chkbx_monto.setForeground(new java.awt.Color(255, 51, 0));
        chkbx_monto.setText("Monto");
        chkbx_monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbx_montoActionPerformed(evt);
            }
        });

        chkbx_porcentaje.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        chkbx_porcentaje.setForeground(new java.awt.Color(255, 51, 0));
        chkbx_porcentaje.setText("Porcentaje");

        btn_guardar.setBackground(new java.awt.Color(255, 102, 0));
        btn_guardar.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_volver.setBackground(new java.awt.Color(255, 102, 0));
        btn_volver.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        cmbx_marca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas" }));

        txt_aumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aumentarActionPerformed(evt);
            }
        });

        btn_aceptar.setBackground(new java.awt.Color(255, 102, 0));
        btn_aceptar.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        lbl_aumentar.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lbl_aumentar.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkbx_marca)
                        .addGap(49, 49, 49)
                        .addComponent(cmbx_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkbx_proveedor)
                        .addGap(13, 13, 13)
                        .addComponent(cmbx_proveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(chkbx_monto)
                    .addComponent(chkbx_porcentaje))
                .addGap(215, 215, 215))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_aumentar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_aceptar)
                    .addComponent(txt_aumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkbx_marca)
                            .addComponent(cmbx_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkbx_proveedor)
                            .addComponent(cmbx_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(chkbx_monto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkbx_porcentaje)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(lbl_aumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_aumentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_volver))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkbx_montoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbx_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbx_montoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        //TODO
        if (txt_aumentar.getText().trim().length() > 0) {
            if(!cmbx_marca.getSelectedItem().equals("Todas")){
                miMarca = (Marca) cmbx_marca.getSelectedItem();
            }
            miProv = (Proveedor) cmbx_proveedor.getSelectedItem();
            traeProd = new TraerProductos();
            miListaProd = new ArrayList<>();

            if (cmbx_marca.getSelectedItem().equals("Todas")) {
                miListaProd = traeProd.TraerProductos();
                modificaP = ModificarPrecios.getModificarPrecios(flag, Float.parseFloat(txt_aumentar.getText()), miListaProd);
                modificaP.start();
                mainFrame.menuPrincipal();
                this.setVisible(false);
                form = null;
                System.gc();
            } else {

                //Marca y proveedor
                if ((chkbx_marca.isSelected()) && (chkbx_proveedor.isSelected())) {
                    miListaProd = traeProd.TraerProductosProveedorMarca(miProv, miMarca);
                    modificaP = ModificarPrecios.getModificarPrecios(flag, Float.parseFloat(txt_aumentar.getText()), miListaProd);
                    modificaP.start();
                    mainFrame.menuPrincipal();
                    this.setVisible(false);
                    form = null;
                    System.gc();
                } else {//Solo marca
                    if ((chkbx_marca.isSelected()) && !(chkbx_proveedor.isSelected())&& !(cmbx_marca.getSelectedItem().equals("Todas"))) {
                        miListaProd = traeProd.TraerProductosMarca(miMarca);
                        modificaP = ModificarPrecios.getModificarPrecios(flag, Float.parseFloat(txt_aumentar.getText()), miListaProd);
                        modificaP.start();
                        mainFrame.menuPrincipal();
                        this.setVisible(false);
                        form = null;
                        System.gc();
                    } else {//Solo proveedor
                        if (!(chkbx_marca.isSelected()) && (chkbx_proveedor.isSelected())) {
                            miListaProd = traeProd.TraerProductosProveedor(miProv);
                            modificaP = ModificarPrecios.getModificarPrecios(flag, Float.parseFloat(txt_aumentar.getText()), miListaProd);
                            modificaP.start();
                            mainFrame.menuPrincipal();
                            this.setVisible(false);
                            form = null;
                            System.gc();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
        mainFrame.menuPrincipal();
        this.setVisible(false);
        form = null;
        System.gc();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void txt_aumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aumentarActionPerformed
        // TODO add your handling code here:
        if (txt_aumentar.getText().trim().length() > 0) {
            btn_guardar.setEnabled(true);
        }
    }//GEN-LAST:event_txt_aumentarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        flag = validacion_checkBox();
        revalidate();
    }//GEN-LAST:event_btn_aceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JCheckBox chkbx_marca;
    private javax.swing.JCheckBox chkbx_monto;
    private javax.swing.JCheckBox chkbx_porcentaje;
    private javax.swing.JCheckBox chkbx_proveedor;
    private javax.swing.JComboBox cmbx_marca;
    private javax.swing.JComboBox cmbx_proveedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_aumentar;
    private javax.swing.JTextField txt_aumentar;
    // End of variables declaration//GEN-END:variables
}
