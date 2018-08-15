/*
import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class mmm {
    private TextArea ta = new TextArea(20 , 40);

    public  void init ()
    {		int i;
        Frame f = new Frame("计算器");
        FirstListener f1 = new FirstListener();
        f.add(ta , BorderLayout.NORTH);
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(4 , 4 , 4 , 4));
        String[] name = {"7","8","9","*",
                "4","5","6","/",
                "3","2","1","+",
                "0",".","=","-"};
        Button[] buttons = new Button[name.length];
        for ( i = 0 ; i < name.length ; i++)
        {
            buttons[i] = new Button(name[i]);
            System.out.println(buttons.length);
            System.out.println(i);
            p2.add(buttons[i]);
            buttons[i].addActionListener(f1);
        }
        f.add(p2);
        f.pack();
        int ss = 44;
        int dd = 55;
        ta.setText("lalcdsjvoi"+(ss+dd));
        f.setBounds(600, 300, 500, 500 );
        f.setVisible(true);
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
    class FirstListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            ta.append(  e.getActionCommand());
        }
    }
    public static void main (String[] args)
    {
        new mmm().init();
    }
}

*/




//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.math.BigDecimal;
//public class mmm {
//    private TextArea ta = new TextArea(20 , 40);
//    int i = 0;
//    Panel p2 = new Panel();
//    public  void init ()
//    {
//        Frame f = new Frame("计算器");
//        FirstListener f1 = new FirstListener();
//        f.add(ta , BorderLayout.NORTH);
//
//        p2.setLayout(new GridLayout(4,  4,4,4));
//        String[] name = {"7","8","9","*",
//                "4","5","6","/",
//                "1","2","3","+",
//                "0",".","=","-"};
//
//        Button b1 = new Button("7");
//        b1.addActionListener(f1);
//        Button b2 = new Button("8");
//        b2.addActionListener(f1);
//        Button b3 = new Button("9");
//        b3.addActionListener(f1);
//        Button b4 = new Button("/");
//        b4.addActionListener(f1);
//        Button b5 = new Button("4");
//        b5.addActionListener(f1);
//        Button b6 = new Button("5");
//        b6.addActionListener(f1);
//        Button b7 = new Button("6");
//        b7.addActionListener(f1);
//        Button b8 = new Button("*");
//        b8.addActionListener(f1);
//        Button b9 = new Button("1");
//        b9.addActionListener(f1);
//        Button b10 = new Button("2");
//        b10.addActionListener(f1);
//        Button b11 = new Button("3");
//        b11.addActionListener(f1);
//        Button b12 = new Button("+");
//        b12.addActionListener(f1);
//        Button b13 = new Button("0");
//        b13.addActionListener(f1);
//        Button b14 = new Button(".");
//        b14.addActionListener(f1);
//        Button b15 = new Button("=");
//        b15.addActionListener(f1);
//        Button b16 = new Button("-");
//        b16.addActionListener(f1);
//        p2.add(b1);
//        p2.add(b2);
//        p2.add(b3);
//        p2.add(b4);
//        p2.add(b5);
//        p2.add(b6);
//        p2.add(b7);
//        p2.add(b8);
//        p2.add(b9);
//        p2.add(b10);
//        p2.add(b11);
//        p2.add(b12);
//        p2.add(b13);
//        p2.add(b14);
//        p2.add(b15);
//        p2.add(b16);
//        f.addWindowListener(new MyListener());
//        f.add(p2);
//
//        f.pack();
//        f.setBounds(600, 300, 500, 500 );
//        f.setVisible(true);
//
//    }
//    class MyListener implements WindowListener
//    {
//
//        public void windowClosed(WindowEvent e)
//        {
//            ta.append("窗口被成功关闭！\n");
//        }
//        public void windowClosing(WindowEvent e)
//        {
//            ta.append("用户关闭窗口！\n");
//            System.exit(0);
//        }
//        @Override
//        public void windowOpened(WindowEvent e) {
//            // TODO 自动生成的方法存根
//
//        }
//        @Override
//        public void windowIconified(WindowEvent e) {
//            // TODO 自动生成的方法存根
//
//        }
//        @Override
//        public void windowDeiconified(WindowEvent e) {
//            // TODO 自动生成的方法存根
//
//        }
//        @Override
//        public void windowActivated(WindowEvent e) {
//            // TODO 自动生成的方法存根
//
//        }
//        @Override
//        public void windowDeactivated(WindowEvent e) {
//            // TODO 自动生成的方法存根
//
//        }
//
//    }
//    class FirstListener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e)
//        {
//            ta.append( e.getActionCommand());
//            String a  = e.getActionCommand();
//            switch (a)
//            {
//                case "+":
//                    String mm = ta.getText();
//                    String mmm = mm.substring(0, mm.indexOf("+"));
//                    i = Integer.valueOf(mmm).intValue();
//                    ta.setText("");
//
//
//                    break;
//
//                case "=":
//                        String bb = ta.getText();
//                        String bbb = bb.substring(0, bb.indexOf("="));
//                        int j1 = Integer.valueOf(bbb).intValue();
//                        ta.setText(i + "+" + j1 + "=" +  (i + j1) );
//                        break;
//
//                case "-":
//                    String nn = ta.getText();
//                    String nnn = nn.substring(0, nn.indexOf("-"));
//                    int k = Integer.valueOf(nnn).intValue();
//                    ta.setText("");
//                    if(a == "=")
//                    {
//                        String aa = ta.getText();
//                        String aaa = aa.substring(0, aa.indexOf("="));
//                        int j = Integer.valueOf(aaa).intValue();
//                        ta.setText(k + "-" + j + "=" +  k + (-j));
//                    }
//
//                    break;
//                case "*":
//                    String ll = ta.getText();
//                    String lll = ll.substring(0, ll.indexOf("*"));
//                    int l = Integer.valueOf(lll).intValue();
//                    ta.setText("");
//                    if(a == "=")
//                    {
//                        String aa = ta.getText();
//                        String aaa = aa.substring(0, aa.indexOf("="));
//                        int j = Integer.valueOf(aaa).intValue();
//                        ta.setText(l + "*" + j + "=" +  l * j );
//                    }
//
//
//                    break;
//                case "/":
//                    String oo = ta.getText();
//                    String ooo = oo.substring(0, oo.indexOf("-"));
//                    int o = Integer.valueOf(ooo).intValue();
//                    ta.setText("");
//                    if(a == "=")
//                    {
//                        String aa = ta.getText();
//                        String aaa = aa.substring(0, aa.indexOf("="));
//                        int j = Integer.valueOf(aaa).intValue();
//                        ta.setText(o + "/" + j + "=" +  o / j );
//                    }
//
//                    break;
//            }
//
//        }
//    }
//
//    public static void main (String[] args)
//    {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//        new mmm().init();
//    }
//}
