package principal;
import java.awt.GridLayout;

import javax.swing.*;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI extends JFrame{
    private JTabbedPane pestanas;
    private JPanel registroCliente;
    private JPanel registroTrabajador;
    private JPanel registroAtraccion;
    
    public GUI() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	registroCliente.setLayout(new GridLayout(3,2));
    	registroCliente.add( new JLabel("Nombre"));
    }
}
