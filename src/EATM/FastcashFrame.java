package EATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FastcashFrame extends JFrame implements ActionListener {

    JButton five,thousand,two,fivetho,back;
    JLabel l1;
    public FastcashFrame(){
        l1 = new JLabel();
        l1.setBounds(120,30,400,30);
        l1.setFont(new Font("Font.Sans-Serif",Font.BOLD,30));
        l1.setText("Select Your Transaction");
        add(l1);

        five = new JButton("Rs.500");
        five.setBounds(120,100,140,70);
        add(five);
        five.addActionListener(this);

        thousand = new JButton("Rs.1000");
        thousand.setBounds(120,220,140,70);
        add(thousand);
        thousand.addActionListener(this);

        two = new JButton("Rs.2000");
        two.setBounds(300,100,140,70);
        add(two);
        two.addActionListener(this);

        fivetho = new JButton("Rs.5000");
        fivetho.setBounds(300,220,140,70);
        add(fivetho);
        fivetho.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(450,400,80,30);
        add(back);
        back.addActionListener(this);


        this.setTitle("AUTOMATED TELLER MACHINE");
        this.setLayout(null);
        this.setLocation(420,140);
        this.setSize(600,500);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back)
        {
            new AtmFrame().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==five){
            int nAmount = 500;
            String query = "select amount from atm where c_no = '"+ LoginFrame.cardNo+"' and pin = '"+ LoginFrame.pin+"'";
            try {
                ResultSet rs = new MyConnection().st.executeQuery(query);
                rs.next();
                int amount = rs.getInt("amount");
                int total = Math.abs(amount - nAmount);
                new MyConnection().st.executeUpdate("update atm set amount = '"+total+"' where c_no = '"+LoginFrame.cardNo+"' and pin = '"+LoginFrame.pin+"'");
                JOptionPane.showMessageDialog(this,"Rs.500 Withdrawn\nYour Total Amount is :"+ total);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==thousand){
            int nAmount = 1000;
            String query = "select amount from atm where c_no = '"+ LoginFrame.cardNo+"' and pin = '"+ LoginFrame.pin+"'";
            try {
                ResultSet rs = new MyConnection().st.executeQuery(query);
                rs.next();
                int amount = rs.getInt("amount");
                int total = Math.abs(amount - nAmount);
                new MyConnection().st.executeUpdate("update atm set amount = '"+total+"' where c_no = '"+LoginFrame.cardNo+"' and pin = '"+LoginFrame.pin+"'");
                JOptionPane.showMessageDialog(this,"Rs.500 Withdrawn\nYour Total Amount is :"+ total);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==two){
            int nAmount = 2000;
            String query = "select amount from atm where c_no = '"+ LoginFrame.cardNo+"' and pin = '"+ LoginFrame.pin+"'";
            try {
                ResultSet rs = new MyConnection().st.executeQuery(query);
                rs.next();
                int amount = rs.getInt("amount");
                int total = Math.abs(amount - nAmount);
                new MyConnection().st.executeUpdate("update atm set amount = '"+total+"' where c_no = '"+LoginFrame.cardNo+"' and pin = '"+LoginFrame.pin+"'");
                JOptionPane.showMessageDialog(this,"Rs.500 Withdrawn\nYour Total Amount is :"+ total);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            int nAmount = 5000;
            String query = "select amount from atm where c_no = '"+ LoginFrame.cardNo+"' and pin = '"+ LoginFrame.pin+"'";
            try {
                ResultSet rs = new MyConnection().st.executeQuery(query);
                rs.next();
                int amount = rs.getInt("amount");
                int total = Math.abs(amount - nAmount);
                new MyConnection().st.executeUpdate("update atm set amount = '"+total+"' where c_no = '"+LoginFrame.cardNo+"' and pin = '"+LoginFrame.pin+"'");
                JOptionPane.showMessageDialog(this,"Rs.500 Withdrawn\nYour Total Amount is :"+ total);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
