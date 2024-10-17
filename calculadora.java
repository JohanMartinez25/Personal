package calculadora;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class main {
public static void main (String []args){
    
    JOptionPane.showMessageDialog(null, "Este es un programa que funciona\n\ncomo una especie de calculadora\n\ncapaz de realizar las 4 operaciones básicas\n\nSUMA, RESTA, PRODUCTO Y COCIENTE\n\nen este caso para 2 números" );
    String dato = "";
    int variable = 0;
    double n1 = 0, n2 = 0, res = 0;
    dato = JOptionPane.showInputDialog("Ingrese el primer dígito");
    n1 = Double.parseDouble(dato);
    dato = JOptionPane.showInputDialog("Ingrese el segundo digito");
    n2 = Double.parseDouble(dato);
    dato = JOptionPane.showInputDialog("Escriba el número de la operación\\nartimética que desea realizar:\\nSUMA = 1\\nRESTA = 2\\nPRODUCTO = 3\\nRESIDUO = 4");
    variable = Integer.parseInt(dato);
    switch (variable){
        case 1:
            res = n1 + n2;
            JOptionPane.showMessageDialog(null, n1 + " + " + n2 + " = " + res);
            break;
        case 2:
            res = n1 - n2;
            JOptionPane.showMessageDialog(null, n1 + " - " + n2 + " = " + res);
            break;
        case 3:
            res = n1 * n2;
            JOptionPane.showMessageDialog(null, n1 + " * " + n2 + " = " + res);
            break;
        case 4:
            res = n1 / n2;
            JOptionPane.showMessageDialog(null, n1 + " / " + n2 + " = " + res);
            break;
        default:
            JOptionPane.showMessageDialog(null, "La opción ingresada NO es válida");
            break;
            
    }
}  
}
