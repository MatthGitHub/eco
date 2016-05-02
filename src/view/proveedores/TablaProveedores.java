/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.proveedores;

import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Proveedor;
import eco.servicios.proveedores.EliminarProveedor;
import eco.servicios.proveedores.TraerProveedores;
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
public class TablaProveedores extends javax.swing.JPanel {
    Main mainFrame;
    private static TablaProveedores tabla;
    private static String fondo;
    private Image background;
    //Vector estatico con los proveedores
    private static List <Proveedor> cacheDatos;
    //Vector con las marcas
    private List <Proveedor> miLista;
    //Clase con el servicio para traer todas los proveedores de la BD
    private TraerProveedores traerP;
    //Modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();
    //Marca a eliminar
    EliminarProveedor eliProv;
    
    
    /**
     * Creates new form TablaProveedores
     */
    private TablaProveedores(Main mainFrame) {
        initComponents();
        cacheDatos = new ArrayList<>();
        this.mainFrame = mainFrame;
        fondo = "src/eco/resources/Proveedores.jpg";
        setBackground(fondo);
        setVisible(true);
        setSize(1024, 700);
        llenarTabla();
    }
    
    public static TablaProveedores getTablaProveedores(Main mainFrame){
        if(tabla == null){
            tabla = new TablaProveedores(mainFrame);
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
     * Traer vector con todas las marcas
     **/
    public void llenarTabla(){
        traerP = new TraerProveedores();
        miLista = traerP.TraerProveedores();
        guardarCacheDatos(miLista);
        recargarTabla();        
    }
    
    /**
     * Guardar en el vector cacheDatos
     * @param aGuardar: Una lista del tipo Proveedor
     **/
    private void guardarCacheDatos(List <Proveedor> aGuardar){
        if(cacheDatos.isEmpty()){
            cacheDatos = aGuardar;
        }else{
            for(int i = 0; i < cacheDatos.size(); i ++ ){
                for(int j = 0; j < aGuardar.size(); j++){
                    if(aGuardar.get(j).equals(cacheDatos.get(i))){
                        aGuardar.remove(j);
                    }
                }
            }
            for(int i = 0; i < aGuardar.size(); i ++ ){
                cacheDatos.add(aGuardar.get(i));
            }
        }
    }
    
    /**
     * Actualiza la tabla de proveedores
     * */
    public void recargarTabla(){
        vaciarTabla(jt_proveedores);
        String datos[] = new String[2];
        model = (DefaultTableModel) jt_proveedores.getModel();
        for(int i = 0; i < cacheDatos.size();i++){
            datos[0] = cacheDatos.get(i).getIdProveedor().toString();
            datos[1] = cacheDatos.get(i).getNombre();
            model.addRow(datos);
        }
    }
    
    /**Vaciar la tabla
     * Vacia la tabla de proveedores
     * @param tabla 
     */
    private void vaciarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    /**
     * Eliminar una marca de la tabla, del chache y de la BD
     **/
    private void eliminarFila(int elim) throws NonexistentEntityException {
        Integer id_proveedor;
        cacheDatos.remove(elim);
        id_proveedor= traerP.traerProveedor(Integer.parseInt(model.getValueAt(elim, 0).toString())).getIdProveedor();
        eliProv = new EliminarProveedor(id_proveedor);
        recargarTabla();
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
        jt_proveedores = new javax.swing.JTable();
        btn_volver = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)), "Proveedores", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 36), new java.awt.Color(255, 51, 0))); // NOI18N

        jt_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_proveedores);

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
        btn_eliminar.setText("Eliminar proveedor");
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
                .addContainerGap()
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
        mainFrame.menuProveedores();
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        if(jt_proveedores.getSelectedRowCount() > 0){
            try {
                eliminarFila(jt_proveedores.getSelectedRow());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(TablaProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila!");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_proveedores;
    // End of variables declaration//GEN-END:variables
}
