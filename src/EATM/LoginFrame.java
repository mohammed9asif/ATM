package EATM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
        JLabel label1,label2,head;
        JTextField field1,field2;
        JButton login,signup;
        public static String cardNo;
        public static int pin;

    LoginFrame(){
        head = new JLabel("ATM",SwingConstants.CENTER);
        head.setBounds(200,70,150,20);
        this.add(head);

        label1 = new JLabel("CARD NO:");
        label1.setBounds(140,110,90,30);
        add(label1);

        label2 = new JLabel("PIN:");
        label2.setBounds(140,160,90,30);
        add(label2);

        field1 = new JTextField();
        field1.setBounds(250,110,150,30);
        add(field1);

        field2 = new JTextField();
        field2.setBounds(250,160,150,30);
        add(field2);

        login = new JButton("Login");
        login.setBounds(180,220,80,30);
        add(login);
        login.addActionListener(this);

        signup = new JButton("Sign Up");
        signup.setBounds(290,220,80,30);
        add(signup);
        signup.addActionListener(this);


        this.setTitle("AUTOMATED TELLER MACHINE");
        this.setLayout(null);
        this.setLocation(420,140);
        this.setSize(600,500);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==signup)
        {
            new SignupFrame().setVisible(true);
            setVisible(false);
        }else
        {
             cardNo = field1.getText();
             pin = Integer.parseInt(field2.getText());
            try {
                ResultSet rs = new MyConnection().st.executeQuery("select c_no,pin from atm where c_no = '"+cardNo+"' and pin ='"+pin+"'");
                if(rs.next()){
                    new AtmFrame().setVisible(true);
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Enter Correct Card No and Pin");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
