/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author Administrador
 */
public class Process extends SwingWorker<Integer, String>{
    
    private JProgressBar jpbar;
    private JTextArea txtA;
    
    
    @Override
    protected Integer doInBackground() throws Exception {
        return 0;
    }

    public JProgressBar getJpbar() {
        return jpbar;
    }

    public void setJpbar(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }

    public JTextArea getTxtA() {
        return txtA;
    }

    public void setTxtA(JTextArea txtA) {
        this.txtA = txtA;
    }
    
}
