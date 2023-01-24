import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clc {
    String num1;
    String signo;
    String num2;
    private JPanel panel1;
    private JButton B7;
    private JButton B8;
    private JButton B9;
    private JButton BDiv;
    private JButton B4;
    private JButton B5;
    private JButton B6;
    private JButton BPor;
    private JButton B1;
    private JButton B2;
    private JButton B3;
    private JButton BMenos;
    private JButton B0;
    private JButton BPUNTO;
    private JButton BMas;
    private JButton BBorrar;
    private JLabel MostrarOP;
    private JButton BIgual;

    public Clc() {
        BBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText("");
            }
        });
        B0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+0);
            }
        });
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+1);
            }
        });
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+2);
            }
        });
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+3);
            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+4);
            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+5);
            }
        });
        B6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+6);
            }
        });
        B7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+7);
            }
        });
        B8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+8);
            }
        });
        B9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarOP.setText(MostrarOP.getText()+9);
            }
        });
        BPUNTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena;
                cadena=MostrarOP.getText();

                if(cadena.length()<=0){
                    MostrarOP.setText("0.");
                }
                else{
                    if (!ContolPunto(MostrarOP.getText())){
                        MostrarOP.setText(MostrarOP.getText()+".");
                    }
                }
            }
        });
        BDiv.addActionListener(new ActionListener() {
            //Divicion
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(MostrarOP.getText().equals(""))){
                    num1=MostrarOP.getText();
                    signo="/";
                    MostrarOP.setText("");
                }
            }
        });
        BPor.addActionListener(new ActionListener() {
            //Multiplicacion
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(MostrarOP.getText().equals(""))) {
                    num1 = MostrarOP.getText();
                    signo = "*";
                    MostrarOP.setText("");
                }
            }
        });
        BMenos.addActionListener(new ActionListener() {
            //Resta
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(MostrarOP.getText().equals(""))) {
                    num1 = MostrarOP.getText();
                    signo = "-";
                    MostrarOP.setText("");
                }
            }
        });
        BMas.addActionListener(new ActionListener() {
            //Suma
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(MostrarOP.getText().equals(""))) {
                    num1 = MostrarOP.getText();
                    signo = "+";
                    MostrarOP.setText("");
                }
            }
        });
        BIgual.addActionListener(new ActionListener() {
            //Boton igual
            @Override
            public void actionPerformed(ActionEvent e) {
                String tot;
                num2=MostrarOP.getText();
                if (signo.equals("/")&&num2.equals("0")){
                    MostrarOP.setText("No se puede dividir para cero");
                }
                else if(!num2.equals("")){
                    tot=Oper(num1, signo, num2);
                    MostrarOP.setText(tot);
                }
            }
        });
    }

    public static String Oper(String num1, String signo, String num2){
        double tot=0.0;
        String result="76";

        if(signo.equals("/")){
            tot=Double.parseDouble(num1)/Double.parseDouble(num2);
        }
        if(signo.equals("*")){
            tot=Double.parseDouble(num1)*Double.parseDouble(num2);
        }
        if(signo.equals("+")){
            tot=Double.parseDouble(num1)+Double.parseDouble(num2);
        }
        if(signo.equals("-")){
            tot=Double.parseDouble(num1)-Double.parseDouble(num2);
        }
        result=String.valueOf(tot);
        return result;
    }
    public static boolean ContolPunto(String cadena){
        boolean res;
        res=false;
        for(int i=0; i< cadena.length(); i++){
            if (cadena.substring(i, i+1).equals(".")){
                res=true;
                break;
            }
        }
        return  res;
    }
    public static void main(String[] args){
        JFrame frame= new JFrame("Clc");
        frame.setContentPane(new Clc().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}