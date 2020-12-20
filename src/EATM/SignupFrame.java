package EATM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class SignupFrame extends JFrame implements ActionListener {
    JLabel fName, lName, accType, aadharNo, phNo, notice;
    JTextField f1, f2, f3, f4;
    JButton createB;

    public SignupFrame() {
        fName = new JLabel("First Name :");
        fName.setBounds(40, 50, 70, 30);
        add(fName);

        f1 = new JTextField();
        f1.setBounds(120, 55, 400, 20);
        add(f1);

        lName = new JLabel("Last Name :");
        lName.setBounds(40, 100, 70, 30);
        add(lName);

        f2 = new JTextField();
        f2.setBounds(120, 105, 400, 20);
        add(f2);

        aadharNo = new JLabel("Aadhar No :");
        aadharNo.setBounds(40, 150, 70, 30);
        add(aadharNo);

        f3 = new JTextField();
        f3.setBounds(120, 155, 400, 20);
        add(f3);

        phNo = new JLabel("Mobile No :");
        phNo.setBounds(40, 200, 70, 30);
        add(phNo);

        f4 = new JTextField();
        f4.setBounds(120, 205, 400, 20);
        add(f4);

        notice = new JLabel(" ***  After You Hit Create 'CardNo' and 'Pin' is shown please note for future purpose");
        notice.setBounds(40, 250, 470, 30);
        add(notice);

        createB = new JButton("CREATE");
        createB.setBounds(225, 300, 80, 30);
        add(createB);
        createB.addActionListener(this);

        this.setTitle("AUTOMATED TELLER MACHINE");
        this.setLayout(null);
        this.setLocation(420, 140);
        this.setSize(600, 500);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        /* new JOptionPane("CardNo:\nPin:");*/
        String cardNo = new String();
        cardNo = new RandomString().getAlphaNumericString(16);
        Random random = new Random();
        int id = Integer.parseInt(String.format("%04d", random.nextInt(10000)));
        String f_name = f1.getText();
        String l_name = f2.getText();
        long adh = Long.parseLong(f3.getText());
        long ph = Long.parseLong(f4.getText());
        String query = "insert into atm values('" + cardNo + "','" + id + "','" + f_name + "','" + l_name + "','" + adh + "','" + ph + "',0)";
        try {
            new MyConnection().st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "CardNo: '" + cardNo + "'\n Pin : '" + id + "'");
        new LoginFrame().setVisible(true);
        setVisible(false);
    }

}
