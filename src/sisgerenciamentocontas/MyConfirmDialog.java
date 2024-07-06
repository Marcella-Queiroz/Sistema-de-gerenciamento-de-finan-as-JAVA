/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisgerenciamentocontas;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author marcella.1963
 */
public class MyConfirmDialog extends JDialog{
    private int result = JOptionPane.CLOSED_OPTION;

    public MyConfirmDialog(String message, String title, String[] buttonLabels) {
        setTitle(title);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(message);
        messageLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(messageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (label.equals(buttonLabels[0])) {
                        result = JOptionPane.YES_OPTION;
                    } else if (label.equals(buttonLabels[1])) {
                        result = JOptionPane.NO_OPTION;
                    }
                    dispose();
                }
            });
            buttonPanel.add(button);
        }

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPanel);
        pack();
        setLocationRelativeTo(null); // Centraliza na tela
        setVisible(true);
    }

    public int getResult() {
        return result;
    }

//    public static void main(String[] args) {
//        MyConfirmDialog dialog = new MyConfirmDialog("Deseja confirmar?", "Confirmação");
//        int result = dialog.getResult();
//        System.out.println("Resultado: " + result);
//    }
}
