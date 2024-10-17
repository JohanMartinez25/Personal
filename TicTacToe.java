package Practicas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];  // Botones del tablero
    private char currentPlayer = 'X';  // Jugador actual ('X' o 'O')

    
    
    public TicTacToe() { 
        setTitle("Juego de Gato");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        setLocationRelativeTo(null);

        // Crear botones del tablero y añadir a la ventana
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 80));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    // Método para manejar los eventos de clic en los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();  // Botón que fue clicado

        // Verificar si el botón ya fue clicado
        if (!buttonClicked.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Casilla ya ocupada. Elige otra.", "Casilla Ocupada", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Marcar el botón con el símbolo del jugador actual
        buttonClicked.setText(String.valueOf(currentPlayer));

        // Verificar si el jugador actual ha ganado
        if (checkForWinner()) {
            JOptionPane.showMessageDialog(this, "El jugador " + currentPlayer + " ha ganado!", "¡Fin del juego!", JOptionPane.INFORMATION_MESSAGE);
            resetBoard();  // Reiniciar el tablero
            return;
        }

        // Cambiar de jugador
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

        // Verificar si hay empate
        if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "¡Es un empate!", "¡Fin del juego!", JOptionPane.INFORMATION_MESSAGE);
            resetBoard();
        }
    }

    // Verificar si hay un ganador
    private boolean checkForWinner() {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().equals("")) {
                return true;
            }

            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().equals("")) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().equals("")) {
            return true;
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().equals("")) {
            return true;
        }

        return false;
    }

    // Verificar si el tablero está lleno
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    // Reiniciar el tablero
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';  // Reiniciar el jugador
    }

    // Método principal para ejecutar el juego
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.setVisible(true);
    }
}
