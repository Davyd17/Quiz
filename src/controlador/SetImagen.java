/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author PC1
 */
public class SetImagen {
    
    private final JFrame jFrame;

    public SetImagen(JFrame jFrame) {
        
        this.jFrame = jFrame;
    }
    
    
    public void ajustarImagenLabel(JLabel labelName, String path) {

        ImageIcon image = new ImageIcon(path);
        Icon icon = new ImageIcon(image.getImage().
                getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.jFrame.repaint();
    }
    
}
