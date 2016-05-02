package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import eco.JPAController.ProductoJpaController;
import eco.entidades.Producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.UIDefaults;
import javax.swing.border.Border;
import view.main.Main;

public class ModificarPrecios extends Thread {

    Main mainFrame;
    private static ProductoJpaController jpa;
    private static List<Producto> miLista;
    private static int flag;
    private static Float aumento;
    private static ModificarPrecios miBarra;

    private ModificarPrecios(int flag, Float aumento, List<Producto> miLista) {
        this.flag = flag;
        this.aumento = aumento;
        this.miLista = miLista;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECOPU");
        jpa = new ProductoJpaController(emf);
    }

    public static ModificarPrecios getModificarPrecios(int flag, Float aumento, List<Producto> miLista) {
        if (miBarra == null) {
            miBarra = new ModificarPrecios(flag, aumento, miLista);
        }
        return miBarra;
    }

    @Override
    public void run() {
        JFrame f = new JFrame("Modificando precios");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        f.setLocationRelativeTo(mainFrame);
        Container content = f.getContentPane();
        JProgressBar progressBar = new JProgressBar();
        Border border = BorderFactory.createTitledBorder("Reading...");
        progressBar.setBorder(border);
        progressBar.setForeground(Color.BLACK);

        progressBar.setMaximum(miLista.size());
        progressBar.setSize(300, 100);
        content.add(progressBar, BorderLayout.NORTH);
        f.setSize(300, 100);
        f.setVisible(true);

        if (flag == 1) {
            for (int i = 0; i < miLista.size(); i++) {
                miLista.get(i).setPrecio(miLista.get(i).getPrecio() + aumento);
                try {
                    jpa.edit(miLista.get(i));
                    progressBar.setValue(i);
                    progressBar.setStringPainted(true);
                } catch (Exception ex) {
                    Logger.getLogger(ModificarPrecios.class.getName()).log(Level.SEVERE, "No existe el registro o id: " + miLista.get(i).getIdProducto().toString(), ex);
                    f.setVisible(false);
                    f = null;
                    miBarra = null;
                    System.gc();
                }
            }
        }
        if (flag == 2) {
            for (int i = 0; i < miLista.size(); i++) {
                miLista.get(i).setPrecio(miLista.get(i).getPrecio() + ((miLista.get(i).getPrecio() * aumento) / 100));
                try {
                    jpa.edit(miLista.get(i));
                    progressBar.setValue(i);
                    progressBar.setStringPainted(true);
                } catch (Exception ex) {
                    Logger.getLogger(ModificarPrecios.class.getName()).log(Level.SEVERE, "No existe el registro o id: " + miLista.get(i).getIdProducto().toString(), ex);
                    f.setVisible(false);
                    f = null;
                    miBarra = null;
                    System.gc();
                }
            }

        }
        JOptionPane.showMessageDialog(mainFrame, "Precios modificados con exito!");
        f.setVisible(false);
        f = null;
        miBarra = null;
        System.gc();

    }
}
