/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.marcas;

import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Marca;
import eco.entidades.Tipos;
import eco.servicios.marcas.EliminarMarca;
import eco.servicios.marcas.TraerMarcas;
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
 * @author Matias Benditti
 */
public class TablaMarcas extends javax.swing.JPanel {
    //Ventana principal
    Main mainFrame;
    //Singleton
    private static TablaMarcas tabla;
    //Fondo
    private static String fondo;
    private Image background;
    //Vector estatico con las marcas
    private static List <Marca> cacheDatos;
    //Vector con las marcas
    private List <Marca> miLista;
    //Verctor con los tipos
    private static List <Tipos> listaTip;
    //Clase con el servicio para traerM todas las marcas de la BD
    private TraerMarcas traerM;
    //Clase con el servicio para traer todas los tipos de la BD
    private TraerTipos traerT;
    //Modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();
    //Marca a eliminar
    EliminarMarca eliMarca;
    
    
    /**
     * Creates new form TablaMarcas
     */
    private TablaMarcas(Main mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        cacheDatos = new ArrayList<Marca>();
        fondo = "src/eco/resources/Marcas.jpg";
        setBackground(fondo);
        setVisible(true);
        setSize(1024, 700);
        traerMarcas();
    }
    
    public static TablaMarcas getTablaMarcas(Main mainFrame){
        if(tabla == null){
            tabla = new TablaMarcas(mainFrame);
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
    public void traerMarcas(){
        traerM = new TraerMarcas();
        miLista = traerM.TraerMarcas();
        guardarCacheDatos(miLista);
        traerT = new TraerTipos();
        listaTip = traerT.TraerTipos();
        recargarTabla();        
    }
    
    /**
     * Guardar en el vector cacheDatos
     * @param aGuardar: Una lista del tipo Marca.
     **/
    private void guardarCacheDatos(List <Marca> aGuardar){
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
    //Actualiza la tabla de marcas
    public void recargarTabla(){
        vaciarTabla(jt_marcas);
        String datos[] = new String[3];
        model = (DefaultTableModel) jt_marcas.getModel();
        for(int i = 0; i < cacheDatos.size();i++){
            datos[0] = cacheDatos.get(i).getIdMarca().toString();
            datos[1] = cacheDatos.get(i).getNombre();
            datos[2] = cacheDatos.get(i).getFkTipo().getNombre().toString();
            model.addRow(datos);
        }
    }
    //Eliminar una marca de la tabla, del chache y de la BD
    private void eliminarFila(int elim) throws NonexistentEntityException{
        cacheDatos.remove(elim+1);
        eliMarca = new EliminarMarca(elim+1);
        recargarTabla();
    }
    
    //Vaciar la tabla
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_volver = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_marcas = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)), "Marcas", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 36), new java.awt.Color(255, 51, 0))); // NOI18N

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
        btn_eliminar.setText("Eliminar marca");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jt_marcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_marcas);
        if (jt_marcas.getColumnModel().getColumnCount() > 0) {
            jt_marcas.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
        mainFrame.menuMarcas();
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        if(jt_marcas.getSelectedRowCount() > 0){
            try {
                eliminarFila(jt_marcas.getSelectedRow());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(TablaMarcas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila!");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_marcas;
    // End of variables declaration//GEN-END:variables
}
