import javax.swing.*;

public class Errors {
    public static void errorsFunction(Exception error){
        JOptionPane.showMessageDialog(null,error.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
    }
}
