package platzi_validator;

import javax.swing.JOptionPane;

public class Validator_2 {

    public static void main(String[] args) {

        int i, error = 0, error_inicio = 0, error_cierre = 0;
        String S;
        S = JOptionPane.showInputDialog("Ingrese String");
        String errores[] = new String[S.length()];
        
        //Relleno de array para que puedan compararse
        for (int relleno = 0; relleno < errores.length; relleno++) {
            errores[relleno] = "";
        }
        
        //Validacion de parentesis y archivando errores y su posicion
        for (i = 0; i < S.length(); i++) {
            if (i == 0 && (")".equals(String.valueOf(S.charAt(i))))) {
                error_inicio = 1;
            } else if ("(".equals(String.valueOf(S.charAt(i)))) {
                error++;
                errores[i] = "error";
            } else if (")".equals(String.valueOf(S.charAt(i))) && error >= 1) {
                error--;
                for (int busqueda = errores.length - 1; busqueda >= 0; busqueda--) {
                    if (errores[busqueda].equals("error")) {
                        errores[busqueda] = "";
                        busqueda = 0;
                    }
                }
            } else if (")".equals(String.valueOf(S.charAt(i))) && error == 0) {
                error_cierre++;
                errores[i] = "error";
            }
        }

        
        //Validaciones y exposicion de errores
        if (error_inicio == 1) {
            JOptionPane.showMessageDialog(null, "FALSE");
            JOptionPane.showMessageDialog(null, "Error en la posicion 1");
            for (int warnings = 0; warnings < errores.length; warnings++) {
                if (errores[warnings].equals("error")) {
                    JOptionPane.showMessageDialog(null, "Error en la posición " + (warnings + 1));
                }
            }
        } else if (error == 0 && error_cierre == 0) {
            JOptionPane.showMessageDialog(null, "TRUE");
        } else{
            JOptionPane.showMessageDialog(null, "FALSE");
            for (int warnings = 0; warnings < errores.length; warnings++) {
                if (errores[warnings].equals("error")) {
                    JOptionPane.showMessageDialog(null, "Error en la posición " + (warnings + 1));
                }
            }
        }
    }
}
