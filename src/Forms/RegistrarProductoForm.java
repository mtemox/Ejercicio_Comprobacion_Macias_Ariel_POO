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
    private JPanel RegistrarProductoPanel1;


    public boolean validarCampos(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public boolean validarPrecio(String texto) {
        try {
            double precio = Double.parseDouble(texto);
            return precio >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validarStock(String texto) {
        try {
            int stock = Integer.parseInt(texto);
            return stock >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public RegistrarProductoForm() {
        setTitle("Registrar Producto");
        setContentPane(RegistrarProductoPanel1);
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

                if (validarCampos(txtCodigoInput) && validarCampos(txtNombreInput) &&
                        validarCampos(txtDetalleInput) && validarCampos(txtPrecioInput) &&
                        validarCampos(txtStockInput)) {

                    if (validarPrecio(txtPrecioInput) && validarStock(txtStockInput)) {
                        JOptionPane.showMessageDialog(null, "El producto se registró con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Precio y stock deben ser valores numéricos positivos.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Uno o más campos están vacíos.");
                }

            }
        });
    }

}
