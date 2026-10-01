import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * SAID MEZA
 * Clase Ventana: la interfaz grafica del programa.
 * Usa un objeto de la clase Cuenta.
 */
public class Ventana extends JFrame implements ActionListener {

    // El objeto Cuenta EMPIEZA EN CERO Y SE CREA AL DAR CLICK
    Cuenta miCuenta;

    // Textos que se ven en la ventana
    JLabel lblAutor = new JLabel("Said Miguel MEza Lopez");
    JLabel lblNombre = new JLabel("Titular:");
    JLabel lblSaldoInicial = new JLabel("Saldo inicial:");
    JLabel lblDatos = new JLabel("Aun no hay cuenta");
    JLabel lblMensaje = new JLabel("");
    JLabel lblMonto = new JLabel("Monto:");
    JLabel lblTasa = new JLabel("Tasa anual %:");
    JLabel lblAnios = new JLabel("Años:");

    // Cajas donde se escribe (JTextField)
    JTextField txtNombre = new JTextField();
    JTextField txtSaldoInicial = new JTextField();
    JTextField txtMonto = new JTextField();
    JTextField txtTasa = new JTextField();
    JTextField txtAnios = new JTextField();

    // Botones
    JButton btnCrear = new JButton("Crear cuenta");
    JButton btnDepositar = new JButton("Depositar");
    JButton btnRetirar = new JButton("Retirar");
    JButton btnComision = new JButton("Comision");
    JButton btnProyectar = new JButton("Proyectar");

    // Constructor: aqui se arma la ventana
    public Ventana() {
        setTitle("Cuentas - sm");
        setSize(450, 470);
        setLayout(null);   // nosotros ponemos cada cosa en su lugar
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // al cerrar, termina el programa

        // setBounds(x, y, ancho, alto) = donde va y que tan grande es
        lblAutor.setBounds(20, 10, 400, 25);

        lblNombre.setBounds(20, 45, 120, 25);
        txtNombre.setBounds(150, 45, 250, 25);

        lblSaldoInicial.setBounds(20, 80, 120, 25);
        txtSaldoInicial.setBounds(150, 80, 250, 25);

        btnCrear.setBounds(150, 115, 250, 30);

        lblDatos.setBounds(20, 155, 400, 25);
        lblMensaje.setBounds(20, 185, 400, 25);

        lblMonto.setBounds(20, 225, 120, 25);
        txtMonto.setBounds(150, 225, 250, 25);

        btnDepositar.setBounds(20, 260, 120, 30);
        btnRetirar.setBounds(150, 260, 120, 30);
        btnComision.setBounds(280, 260, 120, 30);

        lblTasa.setBounds(20, 305, 120, 25);
        txtTasa.setBounds(150, 305, 250, 25);

        lblAnios.setBounds(20, 340, 120, 25);
        txtAnios.setBounds(150, 340, 250, 25);

        btnProyectar.setBounds(150, 375, 250, 30);

        // Metemos
        add(lblAutor);
        add(lblNombre);      add(txtNombre);
        add(lblSaldoInicial); add(txtSaldoInicial);
        add(btnCrear);
        add(lblDatos);
        add(lblMensaje);
        add(lblMonto);       add(txtMonto);
        add(btnDepositar);   add(btnRetirar);   add(btnComision);
        add(lblTasa);        add(txtTasa);
        add(lblAnios);       add(txtAnios);
        add(btnProyectar);

        // Le decimos a cada boton que esta misma clase atiende sus clics
        btnCrear.addActionListener(this);
        btnDepositar.addActionListener(this);
        btnRetirar.addActionListener(this);
        btnComision.addActionListener(this);
        btnProyectar.addActionListener(this);
    }

    // Este metodo se ejecuta CADA VEZ que le dan clic a un boton
    public void actionPerformed(ActionEvent e) {

        // Si dieron clic en crear cuenta
        if (e.getSource() == btnCrear) {
            String nombre = txtNombre.getText();                          // lee lo escrito
            double saldo = Double.parseDouble(txtSaldoInicial.getText()); // lo vuelve numero
            miCuenta = new Cuenta(nombre, saldo);                         // crea el objeto
            lblDatos.setText(miCuenta.datos());                           // pone texto en la ventana
            lblMensaje.setText("Cuenta creada");

            // Si todavia no hay cuenta, avisamos
        } else if (miCuenta == null) {
            lblMensaje.setText("Primero crea la cuenta");

            // Si dieron clic en deposititar
        } else if (e.getSource() == btnDepositar) {
            double monto = Double.parseDouble(txtMonto.getText());
            miCuenta.depositar(monto);
            lblDatos.setText(miCuenta.datos());
            lblMensaje.setText("Deposito hecho");

            // Si dieron clic en "Retirar"
        } else if (e.getSource() == btnRetirar) {
            double monto = Double.parseDouble(txtMonto.getText());
            if (miCuenta.tieneFondos(monto)) {
                miCuenta.retirar(monto);
                lblDatos.setText(miCuenta.datos());
                lblMensaje.setText("Retiro hecho");
            } else {
                lblMensaje.setText("No te alcanza el saldo");
            }

            // Si dieron clic en comision
        } else if (e.getSource() == btnComision) {
            double porcentaje = Double.parseDouble(txtMonto.getText());
            double cobrado = miCuenta.aplicarComision(porcentaje);
            lblDatos.setText(miCuenta.datos());
            lblMensaje.setText("Se cobro: $" + cobrado);

            // Si dieron clic en "Proyectar" Y USAÑA RECURSION
        } else if (e.getSource() == btnProyectar) {
            double tasa = Double.parseDouble(txtTasa.getText());
            int anios = Integer.parseInt(txtAnios.getText());
            double futuro = miCuenta.proyectarSaldo(tasa, anios);
            lblMensaje.setText("En " + anios + " años: $" + futuro);
        }
    }
}
