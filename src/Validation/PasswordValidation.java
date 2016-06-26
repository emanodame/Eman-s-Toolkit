package Validation;
import javax.swing.*;
import java.util.Arrays;

public class PasswordValidation extends JFrame {
    private JPanel mainPanel = new JPanel();
    private JLabel passLabel = new JLabel("PRIVATE. Enter Password!");
    private JPasswordField pass = new JPasswordField(10);
    private String[] options = new String[]{"GO!", "Back."};

    public boolean verify() {
        mainPanel.add(passLabel);
        mainPanel.add(pass);

        int option = JOptionPane.showOptionDialog(null, mainPanel, "AUTHENTICATION", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (option == 0) {
            char[] password = pass.getPassword();

            if(passwordCheck(password)){
                return true;
            }else{
                verify();

                return false;
            }
        }
        return false;
    }

    private static boolean passwordCheck(char[] input){
        boolean isCorrect;
        char[] correctPassword = {'m','o','l','l','y'};

        if(input.length != correctPassword.length){
            isCorrect = false;
        }else{
            isCorrect = Arrays.equals(input, correctPassword);
        }

        Arrays.fill(correctPassword,'0');
        return isCorrect;
    }
}

