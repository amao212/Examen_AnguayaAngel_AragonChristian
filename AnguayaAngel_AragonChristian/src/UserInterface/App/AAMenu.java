
/*
 * presenta los menus
 */
package UserInterface.App;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import UserInterface.CustomerControl.AAButton;

public class AAMenu extends JPanel implements ActionListener{

    public AAButton
           AACordenada = new AAButton("CORDNADAS","");
           
    AAMenu(){
        super(new GridLayout(6,1,10,10));
        add(AACordenada);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            if (this.isVisible()) {
                this.setVisible(false);
            } else {
                this.setVisible(true);
            } 
        } else {
            System.out.println(e.getActionCommand());           
        }
    }

    
}
