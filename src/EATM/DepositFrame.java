package EATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositFrame extends JFrame implements ActionListener {
    JLabel notice,cardNo,enterAmount;
    JTextField f1;
    JButton depositB,back;
    public DepositFrame(){
        notice = new JLabel("Deposit Your Amount");
        notice.setBounds(120,50,400,30);
        notice.setFont(new Font("Font.Sans-Serif",Font.BOLD,30));
        add(notice);

        cardNo = new JLabel("Card No: "+LoginFrame.cardNo);
        cardNo.setFont(new Font("Font.Sans-Serif",Font.ITALIC,15));
        cardNo.setBounds(120,100,250,30);
        add(cardNo);

        enterAmount = new JLabel("Enter Amount :");
        enterAmount.setBounds(120,150,100,25);
        add(enterAmount);

        f1 = new JTextField();
        f1.setBounds(250,150,150,25);
        add(f1);

        depositB = new JButton("Deposit");
        depositB.setBounds(200,200,90,40);
        add(depositB);
        depositB.addActionListener(this);

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
        else{
            int nAmount = Integer.parseInt(f1.getText());
            String query = "select amount from atm where c_no = '"+ LoginFrame.cardNo+"' and pin = '"+ LoginFrame.pin+"'";
            try {
                ResultSet rs = new MyConnection().st.executeQuery(query);
                rs.next();
                int amount = rs.getInt("amount");
                int total = amount + nAmount;
                new MyConnection().st.executeUpdate("update atm set amount = '"+total+"' where c_no = '"+LoginFrame.cardNo+"' and pin = '"+LoginFrame.pin+"'");
                JOptionPane.showMessageDialog(this,"Your Total Amount is :"+ total);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
