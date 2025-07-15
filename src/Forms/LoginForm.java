package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private String usuario = "user123";
    private String contrasena = "1234";
    private JPanel LoginPanel;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JComboBox cbRoles;
    private JButton ingresarButton;

    public boolean validarCampos(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public LoginForm() {
        setTitle("Inicio de sesión");
        setContentPane(LoginPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        cbRoles.setSelectedIndex(-1);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioInput = txtUsuario.getText();
                char[] contrasenaInputChar = txtContrasena.getPassword();
                String contrasenaInput = new String(contrasenaInputChar);
                int cbRolInput = cbRoles.getSelectedIndex();

                if (validarCampos(usuarioInput) && validarCampos(contrasenaInput)) {

                    if (cbRolInput == 0) {

                        if (usuarioInput.equals(usuario) && contrasenaInput.equals(contrasena)) {

                            new RegistrarClienteForm();
                            dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "Las credenciales con incorrectas.");
                        }

                    } else if (cbRolInput == 1) {

                        if (usuarioInput.equals(usuario) && contrasenaInput.equals(contrasena)) {

                            new RegistrarProductoForm();
                            dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "Las credenciales con incorrectas.");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Uno o más campos estan vacios.");
                }

            }
        });
    }
}
