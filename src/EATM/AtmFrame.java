package EATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtmFrame extends JFrame implements ActionListener {
    JButton depositB,withdrawB,fastcashB,checkbalB;
    JLabel l1;
    public AtmFrame(){
        l1 = new JLabel();
        l1.setBounds(120,30,400,30);
        l1.setFont(new Font("Font.Sans-Serif",Font.BOLD,30));
        l1.setText("Select Your Transaction");
        add(l1);

        depositB = new JButton("Deposit");
        depositB.setBounds(120,100,140,70);
        add(depositB);
        depositB.addActionListener(this);

        withdrawB = new JButton("WithDraw");
        withdrawB.setBounds(120,220,140,70);
        add(withdrawB);
        withdrawB.addActionListener(this);

        fastcashB = new JButton("Fast Cash");
        fastcashB.setBounds(300,100,140,70);
        add(fastcashB);
        fastcashB.addActionListener(this);

        checkbalB = new JButton("Balance Enquiry");
        checkbalB.setBounds(300,220,140,70);
        add(checkbalB);
        checkbalB.addActionListener(this);



        this.setTitle("AUTOMATED TELLER MACHINE");
        this.setLayout(null);
        this.setLocation(420,140);
        this.setSize(600,500);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==depositB){
            new DepositFrame().setVisible(true);
            setVisible(false);

        }
        else if(ae.getSource()==withdrawB){
            new WithdrawFrame().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==fastcashB){
                new FastcashFrame().setVisible(true);
                setVisible(false);
        }
        else if(ae.getSource()==checkbalB){

            String query = "select amount from atm where c_no = '"+ LoginFrame.cardNo+"' and pin = '"+ LoginFrame.pin+"'";
            try {
                ResultSet rs = new MyConnection().st.executeQuery(query);
                rs.next();
                JOptionPane.showMessageDialog(this,"Your Total Amount is :"+rs.getInt("amount"));

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }



}
