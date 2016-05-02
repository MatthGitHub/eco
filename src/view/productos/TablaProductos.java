/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.productos;

import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Marca;
import eco.entidades.Producto;
import eco.entidades.Proveedor;
import eco.servicios.marcas.TraerMarcas;
import eco.servicios.productos.EliminarProducto;
import eco.servicios.productos.TraerProductos;
import eco.servicios.proveedores.TraerProveedores;
import eco.servicios.tipos.TraerTipos;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.main.Main;

/**
 *
 * @author Administrador
 */
public class TablaProductos extends javax.swing.JPanel {

    Main mainFrame;
    private static TablaProductos tabla;
    private static String fondo;
    private Image background;
    private List<Producto> miLista;
    private static List<Producto> cacheDatos;
    TraerProductos traerP;
    DefaultTableModel model = new DefaultTableModel();
    //Referencias a las clases para traer las marcas
    private TraerMarcas traerM;
    private static List<Marca> miListaM;
    //Referencia a las clases para traer los proveedores
    private TraerProveedores traerProv;
    private static List<Proveedor> miListaProv;
    private EliminarProducto elimProd;
    int[] columnEsc;

    /**
     * Creates new form TablaProductos
     */
    private TablaProductos(Main mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        cacheDatos = new ArrayList<>();
        columnEsc = new int[1];
        fondo = "src/eco/resources/Productos.jpeg";
        setBackground(fondo);
        setVisible(true);
        setSize(1024, 700);
        columnEsc[0] = 8;
        esconderColumna(jt_productos, columnEsc);
        traerProductos();
    }

    public static TablaProductos getTablaProductos(Main mainFrame) {
        if (tabla == null) {
            tabla = new TablaProductos(mainFrame);
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
     * Traer vector con todas los productos
     *
     */
    public void traerProductos() {
        traerP = new TraerProductos();
        miLista = traerP.TraerProductos();
        guardarCacheDatos(miLista);
        traerMarcas();
        traerProveedores();
        recargarTabla();
    }

    /**
     * Traer vector con todas las marcas
     */
    private void traerMarcas() {
        traerM = new TraerMarcas();
        miListaM = traerM.TraerMarcas();
    }

    /**
     * Traer vector con todas los proveedores
     */
    private void traerProveedores() {
        traerProv = new TraerProveedores();
        miListaProv = traerProv.TraerProveedores();
    }

    /**
     * Guardar en el vector cacheDatos
     *
     * @param aGuardar: Una lista del tipo Producto.
     *
     */
    private void guardarCacheDatos(List<Producto> aGuardar) {
        if (cacheDatos.isEmpty()) {
            cacheDatos = aGuardar;
        } else {
            for (int i = 0; i < cacheDatos.size(); i++) {
                for (int j = 0; j < aGuardar.size(); j++) {
                    if (aGuardar.get(j).equals(cacheDatos.get(i))) {
                        aGuardar.remove(j);
                    }
                }
            }
            for (int i = 0; i < aGuardar.size(); i++) {
                cacheDatos.add(aGuardar.get(i));
            }
        }
    }

    //Actualiza la tabla de productos
    private void recargarTabla() {
        vaciarTabla(jt_productos);
        String datos[] = new String[9];
        model = (DefaultTableModel) jt_productos.getModel();

        

        for (int i = 0; i < cacheDatos.size(); i++) {
            
            //Cargo el producto en la tabla
            datos[0] = cacheDatos.get(i).getNombre();
            
            if(cacheDatos.get(i).getFkMarca() != null){
                datos[1] = cacheDatos.get(i).getFkMarca().getNombre();
            }else{
                datos[1] = "No tiene";
            }
            
            datos[2] = cacheDatos.get(i).getCodigo();
            datos[3] = Float.toString(cacheDatos.get(i).getCosto());
            datos[4] = Float.toString(cacheDatos.get(i).getPrecio());
            datos[5] = cacheDatos.get(i).getFkMoneda().getNombre();
            datos[6] = cacheDatos.get(i).getDescripcion();
            if(cacheDatos.get(i).getFkProveedor() != null){
                datos[7] = cacheDatos.get(i).getFkProveedor().getNombre();
            }else{
                datos[7] = "No tiene";
            }
            
            datos[8] = cacheDatos.get(i).getIdProducto().toString();
            model.addRow(datos);
        }
        revalidate();
    }

    /**
     * Vacia la tabla
     *
     */
    private void vaciarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_productos = new javax.swing.JTable();
        btn_volver = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)), "Productos", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 36), new java.awt.Color(255, 51, 0))); // NOI18N

        jt_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Codigo", "Costo", "Precio", "Moneda", "Descripcion", "Proveedor", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_productos);
        if (jt_productos.getColumnModel().getColumnCount() > 0) {
            jt_productos.getColumnModel().getColumn(0).setMinWidth(250);
            jt_productos.getColumnModel().getColumn(0).setPreferredWidth(250);
            jt_productos.getColumnModel().getColumn(0).setMaxWidth(250);
            jt_productos.getColumnModel().getColumn(6).setMinWidth(150);
            jt_productos.getColumnModel().getColumn(6).setPreferredWidth(150);
            jt_productos.getColumnModel().getColumn(6).setMaxWidth(150);
            jt_productos.getColumnModel().getColumn(8).setResizable(false);
            jt_productos.getColumnModel().getColumn(8).setPreferredWidth(0);
        }

        btn_volver.setBackground(new java.awt.Color(255, 102, 0));
        btn_volver.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(0, 0, 0));
        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(255, 102, 0));
        btn_eliminar.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 0, 0));
        btn_eliminar.setText("Eliminar producto");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
        mainFrame.menuProductos();
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        if (jt_productos.getSelectedRowCount() > 0) {
            try {
                elimProd = new EliminarProducto(Integer.parseInt(model.getValueAt(jt_productos.getSelectedRow(), 6).toString()));
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(TablaProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < cacheDatos.size(); i++) {
                if (model.getValueAt(jt_productos.getSelectedRow(), 6) == cacheDatos.get(i).getIdProducto()) {
                    cacheDatos.remove(i);
                }
            }
            traerProductos();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto!");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_productos;
    // End of variables declaration//GEN-END:variables
}
