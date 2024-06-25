import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BancoSistema bancoSistema = new BancoSistema();
                bancoSistema.setVisible(true);
            }
        });
    }
}