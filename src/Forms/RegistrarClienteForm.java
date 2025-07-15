package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarClienteForm extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JTextField txtNacionalidad;
    private JTextField txtLocacion;
    private JButton btnRegistrarCliente;
    private JButton btnLimpiar;
    private JPanel RegistrarClientePanel;
    private JButton btnRegresar;

    public boolean validarCampos(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public boolean validarValores(String texto) {
        try {
            int n;
            n = Integer.parseInt(texto);
            return n >= 18 && texto.matches("\\d{2}");

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public RegistrarClienteForm() {
        setTitle("Registrar Cliente");
        setContentPane(RegistrarClientePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm();
                dispose();
            }
        });


        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtApellido.setText("");
                txtEdad.setText("");
                txtNacionalidad.setText("");
                txtLocacion.setText("");
            }
        });


        btnRegistrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtNombreInput = txtNombre.getText();
                String txtApellidoInput = txtApellido.getText();
                String txtEdadInputStr = txtEdad.getText();
                String txtNacionalidadInput = txtNacionalidad.getText();
                String txtLocacionInput = txtLocacion.getText();

                if (validarCampos(txtNombreInput) && validarCampos(txtApellidoInput) &&
                    validarCampos(txtEdadInputStr) && validarCampos(txtNacionalidadInput) &&
                    validarCampos(txtLocacionInput)) {

                    if (validarValores(txtEdadInputStr)) {
                        JOptionPane.showMessageDialog(null, "El cliente se registro con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente debe ser mayor a 18 años.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Uno o más campos están vacios.");
                }


            }
        });
    }

}
