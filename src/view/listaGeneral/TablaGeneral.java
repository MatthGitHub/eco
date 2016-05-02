/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listaGeneral;

import eco.entidades.Marca;
import eco.entidades.Producto;
import eco.entidades.Proveedor;
import eco.entidades.Tipos;
import eco.servicios.buscadores.Buscadores;
import eco.servicios.marcas.TraerMarcas;
import eco.servicios.productos.TraerProductos;
import eco.servicios.proveedores.TraerProveedores;
import eco.servicios.tipos.TraerTipos;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import view.main.Main;
import view.menuPrincipal.MenuPrincipal;

/**
 *
 * @author Matias Benditti
 */
public class TablaGeneral extends javax.swing.JPanel {

    Main mainFrame;
    private static TablaGeneral tabla;
    private static String fondo;
    private Image background;
    DefaultTableModel model;
    private Buscadores buscar;
    //Productos
    private TraerProductos traerProd;
    private static List<Producto> miListaProd;
    //Proveedores
    private TraerProveedores traerProv;
    private static List<Proveedor> miListaProv;
    //Marcas
    private TraerMarcas traerM;
    private static List<Marca> miListaM;
    //Tipos
    private TraerTipos traerT;
    private static List<Tipos> miListaT;
    int[] columnEsc;

    /**
     * Creates new form TablaGeneral
     */
    private TablaGeneral(Main mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        fondo = "src/eco/resources/TablaGeneral.jpeg";

        setBackground(fondo);
        setVisible(true);
        setSize(1024, 700);
        model = new DefaultTableModel();
        columnEsc = new int[1];
        columnEsc[0] = 9;
        miListaM = new ArrayList<>();
        miListaProd = new ArrayList<>();
        miListaProv = new ArrayList<>();
        miListaT = new ArrayList<>();
        traerTodo();
        llenarComboBoxes();
        llenarTabla(miListaProd);
        esconderColumna(jt_general, columnEsc);

    }

    public static TablaGeneral getTablaGeneral(Main mainFrame) {
        if (tabla == null) {
            tabla = new TablaGeneral(mainFrame);
        }
        return tabla;
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
     * Trae taaadaaa
     */
    private void traerTodo() {
        traerProd = new TraerProductos();
        miListaProd = traerProd.TraerProductos();
        traerProv = new TraerProveedores();
        miListaProv = traerProv.TraerProveedores();
        traerM = new TraerMarcas();
        miListaM = traerM.TraerMarcas();
        traerT = new TraerTipos();
        miListaT = traerT.TraerTipos();
    }

    private void llenarComboBoxes() {
        for (int i = 0; i < miListaProv.size(); i++) {
            cmbx_proveedor.addItem(miListaProv.get(i).getNombre());
        }
        for (int i = 0; i < miListaM.size(); i++) {
            cmbx_marca.addItem(miListaM.get(i).getNombre());
        }
        for (int i = 0; i < miListaT.size(); i++) {
            cmbx_tipo.addItem(miListaT.get(i).getNombre());
        }
    }

    private void llenarTabla(List<Producto> aLlenar) {
        limpiarTabla(jt_general);
        String aGuardar[] = new String[10];
        model = (DefaultTableModel) jt_general.getModel();

        //Guardo en tabla
        for (int i = 0; i < aLlenar.size(); i++) {

            aGuardar[0] = aLlenar.get(i).getNombre();
            aGuardar[1] = aLlenar.get(i).getFkMarca().getNombre();
            aGuardar[2] = aLlenar.get(i).getCodigo();
            aGuardar[3] = Float.toString(aLlenar.get(i).getPrecio());
            aGuardar[4] = Float.toString(aLlenar.get(i).getPrecio() * aLlenar.get(i).getFkMoneda().getCosto());
            aGuardar[5] = aLlenar.get(i).getFkMoneda().getNombre();
            aGuardar[6] = aLlenar.get(i).getDescripcion();
            aGuardar[7] = aLlenar.get(i).getFkProveedor().getNombre();
            aGuardar[8] = aLlenar.get(i).getFkMarca().getFkTipo().getNombre();
            aGuardar[9] = aLlenar.get(i).getIdProducto().toString();
            model.addRow(aGuardar);

        }
    }

    /**
     * Esconde columnas
     *
     * @param tbl: la tabla
     * @param columna: un vector con el numero de las columnas a esconder
     */
    private void esconderColumna(JTable tbl, int columna[]) {
        for (int i = 0; i < columna.length; i++) {
            tbl.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
            tbl.getColumnModel().getColumn(columna[i]).setMinWidth(0);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);
        }
    }

    public static void limpiarTabla(JTable Tabla) {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_general = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_volver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbx_tipo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbx_proveedor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbx_marca = new javax.swing.JComboBox();
        btn_seniar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)), "EUROCAMPING", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 36), new java.awt.Color(255, 51, 0))); // NOI18N

        jt_general.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Codigo", "Precio", "Precio Final", "Moneda", "Descripcion", "Proveedor", "Tipo", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_general);
        if (jt_general.getColumnModel().getColumnCount() > 0) {
            jt_general.getColumnModel().getColumn(0).setMinWidth(250);
            jt_general.getColumnModel().getColumn(0).setPreferredWidth(250);
            jt_general.getColumnModel().getColumn(0).setMaxWidth(250);
        }

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Buscar:");

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Tipo:");

        cmbx_tipo.setBackground(new java.awt.Color(255, 102, 0));
        cmbx_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Proveedor:");

        cmbx_proveedor.setBackground(new java.awt.Color(255, 102, 0));
        cmbx_proveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbx_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbx_proveedorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Marca:");

        cmbx_marca.setBackground(new java.awt.Color(255, 102, 0));
        cmbx_marca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbx_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbx_marcaActionPerformed(evt);
            }
        });

        btn_seniar.setBackground(new java.awt.Color(255, 102, 0));
        btn_seniar.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_seniar.setText("Señar producto");
        btn_seniar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seniarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173)
                .addComponent(btn_seniar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbx_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbx_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbx_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbx_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver)
                    .addComponent(btn_seniar)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
        mainFrame.menuPrincipal();
        this.setVisible(false);
        tabla = null;
        System.gc();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void cmbx_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbx_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbx_proveedorActionPerformed

    private void cmbx_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbx_marcaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbx_marcaActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
        buscar = new Buscadores();
        llenarTabla(Buscadores.buscarProductos(txt_buscar.getText()));
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void btn_seniarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seniarActionPerformed
        // TODO add your handling code here:
        if (jt_general.getSelectedRow() != -1 && jt_general.getSelectedRowCount() < 2) {
            mainFrame.formularioSenia(Integer.parseInt(jt_general.getValueAt(jt_general.getSelectedRow(), 9).toString()));
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Debe seleccionar una y solo una fila!");
        }
    }//GEN-LAST:event_btn_seniarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_seniar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox cmbx_marca;
    private javax.swing.JComboBox cmbx_proveedor;
    private javax.swing.JComboBox cmbx_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_general;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
