package platzi_validator;
import javax.swing.JOptionPane;
public class Platzi_Validator {
    public static void main(String[] args) {
        int i /*,NumParentesisApertura=0,NumParentesisCierre=0*/, error = 0, error_inicio = 0, error_cierre = 0, where = 0, where_2 = 0;
        String S;
        S=JOptionPane.showInputDialog("");
        
        
        for (i=0;i<S.length();i++) {
            if(i == 0 && (")".equals(String.valueOf(S.charAt(i))))){
                error_inicio = 1;
            }else if ("(".equals(String.valueOf(S.charAt(i)))) {
                //NumParentesisApertura++;
                error++;
                where_2 = i + 1;
            }
            else if (")".equals(String.valueOf(S.charAt(i))) && error == 1) {
                //NumParentesisCierre++;
                error--;
                where_2 = 0;
            }else if(")".equals(String.valueOf(S.charAt(i))) && error == 0){
                error_cierre++;
                where = i + 1;
            }
        }
        
        if(error_inicio == 1){
            JOptionPane.showMessageDialog(null, "FALSE");
            JOptionPane.showMessageDialog(null, "Error en la posicion 1");
        }else if /*(NumParentesisApertura==NumParentesisCierre)*/(error_cierre > 0){
            JOptionPane.showMessageDialog(null, "FALSE");
            JOptionPane.showMessageDialog(null, "Error en la posicion " + where);
        }else if(error == 0) {
            JOptionPane.showMessageDialog(null, "TRUE");
        }else{
            JOptionPane.showMessageDialog(null, "FALSE");
                JOptionPane.showMessageDialog(null, "Error en la posición " + where_2);
        }
    }    
}