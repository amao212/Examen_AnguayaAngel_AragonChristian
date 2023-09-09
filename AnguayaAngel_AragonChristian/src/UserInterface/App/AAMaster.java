/*
 * une el panel menu y el panel presentar coordenadas.
 */

package UserInterface.App;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Framework.AppException;

public class AAMaster extends JFrame implements ActionListener {

    ImageIcon icon;
    AAMenu panelMenu;
    AAPresentarCordenada aaPresentarCordenada;
    JPanel panelContent;

    public AAMaster(String title, String icon) throws AppException, SQLException{
        setCustomizerForm(title, icon);

        panelMenu = new AAMenu();
        panelMenu.setBounds(5, 5, 150, 350);
        panelMenu.AACordenada.addActionListener(this);
        add(panelMenu);

        panelContent = new JPanel();
        panelContent.setBounds(200, 10, getWidth()-200, getHeight() - 50);
        panelContent.setBackground(Color.lightGray);
        add(panelContent);
    }

    public void setCustomizerForm(String title, String pathIcon) throws AppException, SQLException{
        icon = new ImageIcon(pathIcon);                  
        setTitle(title);                               
        setVisible(true);
        setLayout(null);
        setLocation(100, 50);
        setResizable(true);
        setSize(800, 600);
        setIconImage(icon.getImage()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void AAshowPanelCoordenada() throws AppException{
        aaPresentarCordenada = new AAPresentarCordenada();
        
        panelContent.removeAll();
        panelContent.setLayout(new GridBagLayout());
        panelContent.add(aaPresentarCordenada);
        panelContent.revalidate();
        panelContent.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == panelMenu.AACordenada) {
            try {
                AAshowPanelCoordenada();
            } catch (AppException e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println("MASTE ->>"+e.getActionCommand());
        }
    }
    
}
