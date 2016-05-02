/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.usuarios;

import eco.JPAController.exceptions.NonexistentEntityException;
import eco.entidades.Usuarios;
import eco.servicios.usuarios.EliminarUsuario;
import eco.servicios.usuarios.TraerUsuarios;
import java.awt.Graphics;
import java.awt.Image;
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
public class MenuTablaUsuarios extends javax.swing.JPanel {

    Main mainFrame;
    private static MenuTablaUsuarios tabla;
    private static String fondo;
    private Image background;
    private TraerUsuarios traerU;
    private static List<Usuarios> cacheDatos;
    private List<Usuarios> miLista;
    private DefaultTableModel modelo;
    EliminarUsuario elimU;
    private CambiarClave cambio;

    /**
     * Creates new form MenuTablaUsuarios
     */
    private MenuTablaUsuarios(Main mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        modelo = (DefaultTableModel) jt_usuarios.getModel();
        fondo = "src/eco/resources/Usuarios.jpeg";
        setBackground(fondo);
        setSize(1024,700);
        setVisible(true);
        traerListaUsuarios();
    }

    public static MenuTablaUsuarios getMenuTablaUsuarios(Main mainFrame) {
        if (tabla == null) {
            tabla = new MenuTablaUsuarios(mainFrame);
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

    public void traerListaUsuarios() {
        traerU = new TraerUsuarios();
        miLista = traerU.traerUsuarios();
        llenarTabla(miLista);
    }

    private void llenarTabla(List<Usuarios> aCargar) {

        String datos[] = new String[3];
        for (int i = 0; i < aCargar.size(); i++) {
            datos[0] = aCargar.get(i).getNombre();
            datos[1] = aCargar.get(i).getClave();
            datos[2] = aCargar.get(i).getIdUsuario().toString();
            modelo.addRow(datos);
        }
        revalidate();
    }

    private void eliminar(int id) {
        try {
            elimU = new EliminarUsuario(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MenuTablaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void vaciarTabla(JTable tabla) {
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_salir = new javax.swing.JButton();
        btn_cambiarC = new javax.swing.JButton();
        btn_cargarN = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_usuarios = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)), "Usuarios", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 36), new java.awt.Color(255, 51, 0))); // NOI18N

        btn_salir.setBackground(new java.awt.Color(255, 102, 0));
        btn_salir.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(0, 0, 0));
        btn_salir.setText("Volver");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_cambiarC.setBackground(new java.awt.Color(255, 102, 0));
        btn_cambiarC.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_cambiarC.setForeground(new java.awt.Color(0, 0, 0));
        btn_cambiarC.setText("Cambiar Clave");
        btn_cambiarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambiarCActionPerformed(evt);
            }
        });

        btn_cargarN.setBackground(new java.awt.Color(255, 102, 0));
        btn_cargarN.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_cargarN.setForeground(new java.awt.Color(0, 0, 0));
        btn_cargarN.setText("Cargar Nuevo");
        btn_cargarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarNActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(255, 102, 0));
        btn_eliminar.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 0, 24)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 0, 0));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jt_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Clave", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_usuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cambiarC)
                .addGap(18, 18, 18)
                .addComponent(btn_cargarN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_eliminar)
                .addGap(12, 12, 12))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salir)
                    .addComponent(btn_cambiarC)
                    .addComponent(btn_cargarN)
                    .addComponent(btn_eliminar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        mainFrame.menuPrincipal();
        this.setVisible(false);
        tabla = null;
        System.gc();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_cambiarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambiarCActionPerformed
        // TODO add your handling code here:
        if ((jt_usuarios.getSelectedRow() != -1) && (jt_usuarios.getSelectedRowCount() < 2)) {
            mainFrame.cambiarClave(Integer.parseInt(modelo.getValueAt(jt_usuarios.getSelectedRow(), 2).toString()));
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario");
        }

    }//GEN-LAST:event_btn_cambiarCActionPerformed

    private void btn_cargarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarNActionPerformed
        // TODO add your handling code here:
        mainFrame.formularioUsuarios();
        this.setVisible(false);
        tabla = null;
        System.gc();
    }//GEN-LAST:event_btn_cargarNActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        if ((jt_usuarios.getSelectedRow() != -1) && (jt_usuarios.getSelectedRowCount() < 2)) {
            if (JOptionPane.showConfirmDialog(this, "Seguro desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION) == 0) {
                eliminar(Integer.parseInt(modelo.getValueAt(jt_usuarios.getSelectedRow(), 2).toString()));
                modelo.removeRow(jt_usuarios.getSelectedRow());
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cambiarC;
    private javax.swing.JButton btn_cargarN;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jt_usuarios;
    // End of variables declaration//GEN-END:variables
}
