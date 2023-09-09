/* Personaliza los botones */
package UserInterface.CustomerControl;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AAButton extends JButton implements MouseListener{
    

    Font font = new Font("MesloLGL Nerd Font", Font.BOLD | Font.LAYOUT_LEFT_TO_RIGHT, 12);

    public AAButton(String label){
        super(label);
        styleLabel();
    }

    public AAButton(String label, String icon){
        styleMenu(label, icon);
    }
    
    public void styleMenu(String label, String icon){
        addMouseListener(this);
        setText(label);
        setSize(40, 40);
        setBounds(50,30,90,20);
        setOpaque(false);
        setForeground(Color.GRAY);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setIcon(new ImageIcon(icon));
        setHorizontalAlignment(SwingConstants.LEFT);
        setFont(font);
    }

    public void styleLabel(){
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.darkGray);
        setHorizontalAlignment(SwingConstants.CENTER);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(font);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
}
