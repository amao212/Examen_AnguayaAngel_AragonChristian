package UserInterface.App;

import javax.swing.*;

import Framework.AppException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AAIniciarSesion extends JFrame {
    private int intentosRestantes = 3;
    private Map<String, String> usuariosContraseñas = new HashMap<>();

    private JLabel aaUsuarioLnl;
    private JLabel aaContrasenaLbl;
    private JTextField aaUsuarioTxt;
    private JPasswordField aaContrasenaTxt;
    private JButton aaINgresarBtn;
    
    /*
     * Permite iniciar sesión.
     */
    public AAIniciarSesion() {
        setTitle("EXAMEN UWU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        aaUsuarioLnl = new JLabel("Usuario:");
        aaContrasenaLbl = new JLabel("Contraseña:");
        aaUsuarioTxt = new JTextField();
        aaContrasenaTxt = new JPasswordField();
        aaINgresarBtn = new JButton("Ingresar");
        

        // Agrega usuarios válidos y sus contraseñas en forma de hash MD5
        agregarUsuarioConContraseña("christian.aragon@epn.edu.ec", "2c3509b4297e1b13df4017c98b7cdaec"); 
        agregarUsuarioConContraseña("angel.anguaya02@epn.edu.ec", "1265e696d51d915b8d3784ac6940ac95");  
        agregarUsuarioConContraseña("profe", "827ccb0eea8a706c4c34a16891f84e7b"); 
        agregarUsuarioConContraseña("lol", "9cdfb439c7876e703e307864c9167a15" );

        aaINgresarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuarioIngresado = aaUsuarioTxt.getText();
                String contraseñaIngresada = new String(aaContrasenaTxt.getPassword());

                if (validarCredenciales(usuarioIngresado, contraseñaIngresada)) {
                    JOptionPane.showMessageDialog( null,"BIENVENIDO");
                    dispose();
                    try {
                        AAMaster f = new AAMaster("CORDENAS UCRANIANAS","");
                    } catch (AppException | SQLException e1) {
                        e1.printStackTrace();
                    }
                    
                } else {
                    intentosRestantes--;
                    if (intentosRestantes == 0) {
                        JOptionPane.showMessageDialog( null,"Has agotado tus intentos. La aplicación se cerrará.");
                       dispose();
                    } else {
                         JOptionPane.showMessageDialog( null,"Credenciales incorrectas. Intentos restantes: " + intentosRestantes);
                    }
                }
            }
        });

        add(aaUsuarioLnl);
        add(aaUsuarioTxt);
        add(aaContrasenaLbl);
        add(aaContrasenaTxt);
        add(new JLabel()); 
        add(aaINgresarBtn);
        add(new JLabel()); 
   
        setVisible(true);
    }
    /**
     * Agrega usuarios.
     * @param usuario usuario ingresado
     * @param contraseñaMD5 contraseña ingresada
     */
    private void agregarUsuarioConContraseña(String usuario, String contraseñaMD5) {
        usuariosContraseñas.put(usuario, contraseñaMD5);
    }

    /*
     * valida las credenciales.
     */
    private boolean validarCredenciales(String usuario, String contraseña) {
        String contraseñaMD5Almacenada = usuariosContraseñas.get(usuario);
        if (contraseñaMD5Almacenada == null) {
            return false; 
        }

        String contraseñaMD5Ingresada = calcularMD5(contraseña);

        return contraseñaMD5Almacenada.equals(contraseñaMD5Ingresada);
    }
    /*
     * Encripta la contraseña
     */
    private String calcularMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AAIniciarSesion();
            }
        });
    }
}