package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarProductoForm extends JFrame {
    private JTextField txtProducto;
    private JTextField txtNombre;
    private JTextField txtDetalle;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JButton btnRegistrarProducto;
    private JButton btnLimpiar;
    private JButton btnRegresar;
    private JLabel RegistrarProductoPanel;

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

    public RegistrarProductoForm() {

        setTitle("Registrar Producto");
        setContentPane(RegistrarProductoPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtProducto.setText("");
                txtNombre.setText("");
                txtDetalle.setText("");
                txtPrecio.setText("");
                txtStock.setText("");
            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm();
                dispose();
            }
        });
        btnRegistrarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String txtCodigoInput = txtProducto.getText();
                String txtNombreInput = txtNombre.getText();
                String txtDetalleInput = txtDetalle.getText();
                String txtPrecioInput = txtPrecio.getText();
                String txtStockInput = txtStock.getText();

                JOptionPane.showMessageDialog(null, "Se registro con éxito");



            }
        });
    }

}
