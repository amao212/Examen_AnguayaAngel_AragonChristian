package UserInterface.App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BusinessLogic.Entities.AACordenadaUcraniana;
import DataAccess.AACordenadaDAC;
import Framework.AppException;
import UserInterface.CustomerControl.AALabel;

public class AAPresentarCordenada extends JPanel implements ActionListener {

    /* 
     * Recoge los datos del DAC  para presentar.
     */
    public List<AACordenadaUcraniana> aaGetAllCordenada() throws AppException{
        try {
            List<AACordenadaUcraniana> aaLstCordenadas = new ArrayList<AACordenadaUcraniana>();
            ResultSet rs = new AACordenadaDAC().aaGetAllData();
            while (rs.next()) {
                AACordenadaUcraniana a = new AACordenadaUcraniana(rs.getString("TipoArsenal"),
                                                                rs.getString("Coordenadas"),
                                                                rs.getString("Arsenal"),
                                                                rs.getString("Dias"),
                                                                rs.getString("Hora"));
                aaLstCordenadas.add(a);
            }
            return aaLstCordenadas;
        } catch (Exception e) {
            throw new AppException(e, getClass(),"aaGetAllCordenada");
        }
        
    }

    /*
     * Presenta las coordenadas de la base de datos.
     */
    public AAPresentarCordenada() throws AppException{
        setGridBagLayout();
        String[] aaHeader = {"TipoArsenal",
                             "Coordenadas",
                             "Arsenal",
                             "Dias",
                             "Hora"};

        Object[][] aaData = new Object[aaGetAllCordenada().size()][5];
        int aaIndex = 0;
        for (AACordenadaUcraniana a : aaGetAllCordenada()) {
            aaData[aaIndex][0] = a.getAaIdTipoArsenal();
            aaData[aaIndex][1] = a.getAaIdCoordenadas();
            aaData[aaIndex][2] = a.getAaIdDias();
            aaData[aaIndex][3] = a.getAaIdArsenal();
            aaData[aaIndex][4] = a.getAaIdHora();
            aaIndex ++;
        }   

        JTable table = new JTable(aaData, aaHeader);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        pnlTabla.add(scrollPane); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    private AALabel
            lblTitulo = new AALabel("COORDENADAS UCRANIANAS", Color.BLACK, new Font("MesloLGL Nerd Font", Font.BOLD ,  20));
    private JPanel 
            pnlTabla   = new JPanel();
    
    /*
     * Presenta en la interfaz las tablas.
     */
    public void setGridBagLayout(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();

        // GridBagConstraints.ponerComponentes
        gbc.gridy = 0;       gbc.gridx=0;  //| fila,  columna
        gbc.gridwidth=3;                   //| celdas a unir
        add(lblTitulo, gbc);               //| agrega el control

        gbc.gridy = 1;       gbc.gridx=0;   
        gbc.gridwidth=1;                     
        add(new JLabel("■ Sección de datos: "), gbc);  
        
        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=3;                   //| celdas a unir
        gbc.ipady = 150;                   //| tamaño alto
        gbc.ipadx = 450;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
        gbc.ipadx = 1;

        gbc.gridy = 4;       gbc.gridx=0; 
        gbc.gridwidth=1;    
    }
    
}