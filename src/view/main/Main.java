/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.main;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import view.listaGeneral.TablaGeneral;
import view.marcas.FormularioCargaMarca;
import view.marcas.MenuMarcas;
import view.marcas.TablaMarcas;
import view.menuPrincipal.MenuPrincipal;
import view.menuPrincipal.ModificarMoneda;
import view.modificaValores.FormularioModificarPrecios;
import view.productos.FormularioCargaProducto;
import view.productos.MenuProductos;
import view.productos.TablaProductos;
import view.proveedores.FormularioCargaProveedor;
import view.proveedores.MenuProveedores;
import view.proveedores.TablaProveedores;
import view.senia.FormularioSenia;
import view.usuarios.CambiarClave;
import view.usuarios.CargaNuevoUsuario;
import view.usuarios.MenuTablaUsuarios;


/**
 *
 * @author Matias Benditti
 */
public class Main extends javax.swing.JFrame {
    MenuPrincipal menuPpal;
    Index login;
    MenuMarcas menuMarcas;
    FormularioCargaMarca forMarca;
    TablaMarcas tablaMarcas;
    MenuProductos menuProd;
    FormularioCargaProducto forProd;
    TablaProductos tablaProd;
    MenuProveedores menuProv;
    TablaProveedores tablaProv;
    FormularioCargaProveedor forProv;
    TablaGeneral tablaGeneral;
    MenuTablaUsuarios tablaU;
    CargaNuevoUsuario formUsu;
    CambiarClave cambiarC;
    FormularioModificarPrecios forModificaP;
    FormularioSenia senia;
    ModificarMoneda forModificaMo;
    
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setTitle("Eurocamping Outdoor");
        setSize(1024, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        ingresar();
        
        
    }
    
    /**
     * Login
     */
   public void ingresar(){
        login = Index.getIndex(this);
        
        if(!login.isVisible() == false){
            getContentPane().add(login);
        }else{
            login.setVisible(true);
        }
    }
    /**
     * Verificar permisos de usuario
     */
   private void verificarUsuario(){
        if(Index.PermisoUsuario != 1){
            //Menu Principal usuarios
            menuPpal.btn_usuarios.setVisible(false);
            //Marcas
            tablaMarcas.btn_eliminar.setVisible(false);
            menuMarcas.btn_cargarNueva.setVisible(false);
            //Productos
            tablaProd.btn_eliminar.setVisible(false);
            menuProd.btn_salir2.setVisible(false);
            //Proveedores
            menuProv.btn_cargarNuevo.setVisible(false);
            tablaProv.btn_eliminar.setVisible(false);
       }
    }
    
    /**
     * Ventana menu principal
     */
   public void menuPrincipal(){
        menuPpal = MenuPrincipal.getMenuPrincipal(this);
        verificarUsuario();
        
        if(!menuPpal.isVisible()== false){
           getContentPane().add(menuPpal);
        }else{
            menuPpal.setVisible(true);
        }
        revalidate();
    }
    /**
     * Setea imagen del icono
     * @return 
     */
   /*
   @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("C:\\Documents and Settings\\Administrador\\Mis documentos\\NetBeansProjects\\ECO\\icono.PNG"));


        return retValue;
    }
    
*/    
    /**
     * Ventana menu marcas
     */
   public void menuMarcas(){
        menuMarcas = MenuMarcas.getMenuMarcas(this);
        
        if(!menuMarcas.isVisible() == false){
            getContentPane().add(menuMarcas);
        }else{
            menuMarcas.setVisible(true);
        }
        revalidate();
    }
    
    /**
     * Formulario para cargar una nueva marca
     */
   public void formularioCargaMarca(){
        forMarca = FormularioCargaMarca.getFormularioCargaMarca(this);
        
        if(!forMarca.isVisible() == false){
            getContentPane().add(forMarca);
        }else{
            forMarca.setVisible(true);
        }
        revalidate();
    }
    
    /**
     * Tabla con todas las marcas
     */
   public void verTodasLasMarcas(){
        tablaMarcas = TablaMarcas.getTablaMarcas(this);
        
        if(!tablaMarcas.isVisible() == false){
            getContentPane().add(tablaMarcas);
        }else{
            tablaMarcas.setVisible(true);
            tablaMarcas.traerMarcas();
        }
        revalidate();
    }
    
    /**
     * Ventana menu productos
     */
    public void menuProductos(){
        menuProd = MenuProductos.getMenuProductos(this);
        
        if(!menuProd.isVisible() == false){
            getContentPane().add(menuProd);
        }else{
            menuProd.setVisible(true);
        }
    }
    
    /**
     * Formulario para cargar un nuevo producto
     */
   public void formularioCargaProducto(){
        forProd = FormularioCargaProducto.getFormularioCargaProducto(this);
        
        if(!forProd.isVisible() == false){
            getContentPane().add(forProd);
        }else{
            forProd.setVisible(true);
        }
        revalidate();
    }
    
    /**
     * Tabla de todos los productos
     */
    public void verTodosLosProductos(){
        tablaProd = TablaProductos.getTablaProductos(this);
        
        if(!tablaProd.isVisible() == false){
            getContentPane().add(tablaProd);
        }else{
            tablaProd.setVisible(true);
            tablaProd.traerProductos();
        }
        revalidate();
    }
    /**
     * Ventana menu proveedores
     */
    public void menuProveedores(){
        menuProv = MenuProveedores.getMenuProveedores(this);
        
        if(!menuProv.isVisible() == false){
            getContentPane().add(menuProv);
        }else{
            menuProv.setVisible(true);
        }
    }
    /**
     * Formulario para cargar un nuevo proveedor
     */
    public void formularioCargaProveedor(){
        forProv = FormularioCargaProveedor.getFormularioCargaProveedor(this);
        
        if(!forProv.isVisible() == false){
            getContentPane().add(forProv);
        }else{
            forProv.setVisible(true);
        }
        revalidate();
    }
    
    public void verTodosProveedores(){
        tablaProv = TablaProveedores.getTablaProveedores(this);
        
        if(!tablaProv.isVisible() == false){
            getContentPane().add(tablaProv);
        }else{
            tablaProv.setVisible(true);
            tablaProv.llenarTabla();
        }
        revalidate();
    }

    /**
     * Ventana con la tabla general con toda la informacion de cada producto
     */
   public void verTablaGeneral(){
        tablaGeneral = TablaGeneral.getTablaGeneral(this);
        
        if(!tablaGeneral.isVisible() == false){
            getContentPane().add(tablaGeneral);
        }else{
            tablaGeneral.setVisible(true);
        }
    }
    /**
     * Menu y tabla usuarios 
     */
    public void menuUsuarios(){
        tablaU = MenuTablaUsuarios.getMenuTablaUsuarios(this);
        
        if(!tablaU.isVisible() == false){
            getContentPane().add(tablaU);
        }else{
            tablaU.setVisible(true);
        }
    }
    
    /**
     * Formulario carga usuario
     */
    public void formularioUsuarios(){
        formUsu = CargaNuevoUsuario.getCargaNuevoUsuario(this);
        
        if(!formUsu.isVisible() == false){
            getContentPane().add(formUsu);
        }else{
            formUsu.setVisible(true);
        }
    }
    /**
     * Formulario cambio clave (tipo pop up)
     */
    public void cambiarClave(Integer id){
        cambiarC = CambiarClave.getCambiarClave(id);
        
        if(!cambiarC.isVisible() == false){
            
        }else{
            cambiarC.setVisible(true);
        }
    }
    /**
     * Formulario para modificar los precios
     */        
    public void formularioModificaPrecios(){
        forModificaP = FormularioModificarPrecios.getFormularioModificarPrecios(this);
        
        if(!forModificaP.isVisible() == false){
            getContentPane().add(forModificaP);
        }else{
            forModificaP.setVisible(true);
        }
        revalidate();
    }
    
    public void formularioSenia(int id){
        senia = FormularioSenia.getFormularioSenia(this, id);
        
        if(!senia.isVisible() == false){
            getContentPane().add(senia);
        }else{
            senia.setVisible(true);
        }
        revalidate();
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
        btn_minimizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setUndecorated(true);

        btn_salir.setBackground(new java.awt.Color(255, 51, 0));
        btn_salir.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(0, 0, 0));
        btn_salir.setText("x");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_minimizar.setBackground(new java.awt.Color(255, 153, 51));
        btn_minimizar.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_minimizar.setForeground(new java.awt.Color(0, 0, 0));
        btn_minimizar.setText("-");
        btn_minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 304, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 279, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizarActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Seguro desea salir?")== 0){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_salirActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_minimizar;
    public javax.swing.JButton btn_salir;
    // End of variables declaration//GEN-END:variables
}
