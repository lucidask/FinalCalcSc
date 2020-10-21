import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.awt.*;

public class CalcSc extends JFrame {

    private JButton nextButtonX2;
    private JButton nextButtonX3;
    private JButton nextButtonClear;
    private JButton nextButtonDelete;
    private JButton nextButtonShutDown;
    private JButton nextButtonEgal;
    private JButton nextButton7;
    private JButton nextButton8;
    private JButton nextButton9;
    private JButton nextButtonOperatorPlus;
    private JButton nextButton4;
    private JButton nextButton5;
    private JButton nextButton6;
    private JButton nextButtonOperatorMoins;
    private JButton nextButton1;
    private JButton nextButton2;
    private JButton nextButton3;
    private JButton nextButtonOperatorMult;
    private JButton nextButton0;
    private JButton nextButtonPoint;
    private JTextField ecran;
    private JPanel contentPane;
    JButton nextButtonEgal2 = new JButton("?");
    Font police= new Font("Arial", Font.PLAIN, 30);
    Color colorbackground= new Color(30,30,30);
    boolean tem=false;
    boolean tem2=false;

    public static void main(String[] args)  {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalcSc c = new CalcSc();
                    c.setTitle("Calculatrice Scientifique");
                    c.setVisible(true);
                    c.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    // Fenetre
    public CalcSc() throws Exception {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 888, 601);
        contentPane = new JPanel();
        contentPane.setBackground(colorbackground);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        ecran = new JTextField();
        // pour ecouter l'appuie sur les touches backspace,delele et le chiffrier
        ecran.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
//                if(  (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)) {
                if(Character.isLetter(c)){
                    e.consume();
                    getToolkit().beep();
                }

            }
        });

        ecran.setFont(police);
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        ecran.setBounds(12, 52, 846, 42);

        contentPane.add(ecran);
        ecran.setColumns(10);
        // panel pour les touches clear, delete, et off
        Panel panel = new Panel();
        panel.setBackground(colorbackground);
        panel.setBounds(12, 120, 846, 80);
        contentPane.add(panel);
        panel.setLayout(null);
        nextButtonClear = new JButton("C");
        nextButtonClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ecran.setText("");
            }
        });
        nextButtonClear.setFont(new Font("Arial", Font.BOLD, 16));
        nextButtonClear.setBackground(Color.LIGHT_GRAY);
        nextButtonClear.setBounds(300, 25, 70, 35);
        panel.add(nextButtonClear);



        nextButtonDelete = new JButton("Del");
        nextButtonDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int len = ecran.getText().length();
                int n = ecran.getText().length()-1;
                String ss="";
                if(len > 0) {
                    StringBuilder s = new StringBuilder(ecran.getText());
                    s.deleteCharAt(n);
                    ss=s.toString();
                    ecran.setText(ss);
                }
            }
        });
        nextButtonDelete.setFont(new Font("Arial", Font.BOLD, 16));
        nextButtonDelete.setBackground(Color.LIGHT_GRAY);
        nextButtonDelete.setBounds(400, 25, 70, 35);
        panel.add(nextButtonDelete);

        nextButtonShutDown = new JButton("OFF");
        nextButtonShutDown.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);
            }
        });
        nextButtonShutDown.setFont(new Font("Arial", Font.BOLD, 16));
        nextButtonShutDown.setBackground(Color.LIGHT_GRAY);
        nextButtonShutDown.setBounds(738, 25, 70, 35);
        panel.add(nextButtonShutDown);

        //panel pour les touches a gauche; et leur listener
        Panel panel_1 = new Panel();
        panel_1.setBackground(colorbackground);
        panel_1.setBounds(10, 235, 295, 268);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        nextButton7 = new JButton("7");
        nextButton7.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton7.setBounds(12, 13, 70, 35);
        nextButton7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("7");
            }
        });
        panel_1.add(nextButton7);

        nextButton8 = new JButton("8");
        nextButton8.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton8.setBounds(85, 13, 70, 35);
        nextButton8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("8");

            }
        });
        panel_1.add(nextButton8);

        nextButton9 = new JButton("9");
        nextButton9.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton9.setBounds(157, 13, 70, 35);
        nextButton9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("9");

            }
        });
        panel_1.add(nextButton9);

        nextButtonOperatorPlus = new JButton("+");
        nextButtonOperatorPlus.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButtonOperatorPlus.setBounds(230, 13, 70, 35);
        nextButtonOperatorPlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("+");
            }
        });
        panel_1.add(nextButtonOperatorPlus);

        nextButton4 = new JButton("4");
        nextButton4.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton4.setBounds(12, 76, 70, 35);
        nextButton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("4");

            }
        });
        panel_1.add(nextButton4);

        nextButton5 = new JButton("5");
        nextButton5.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton5.setBounds(85, 76, 70, 35);
        nextButton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("5");

            }
        });
        panel_1.add(nextButton5);

        nextButton6 = new JButton("6");
        nextButton6.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton6.setBounds(157, 76, 70, 35);
        nextButton6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("6");
            }
        });
        panel_1.add(nextButton6);

        nextButtonOperatorMoins = new JButton("-");
        nextButtonOperatorMoins.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButtonOperatorMoins.setBounds(230, 76, 70, 35);
        nextButtonOperatorMoins.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("-");

            }
        });
        panel_1.add(nextButtonOperatorMoins);

        nextButton1 = new JButton("1");
        nextButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                appendText("1");
            }
        });
        nextButton1.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton1.setBounds(12, 139, 70, 35);
        panel_1.add(nextButton1);

        nextButton2 = new JButton("2");
        nextButton2.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton2.setBounds(85, 139, 70, 35);
        nextButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("2");

            }
        });
        panel_1.add(nextButton2);

        nextButton3 = new JButton("3");
        nextButton3.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton3.setBounds(157, 139, 70, 35);
        nextButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("3");
            }
        });
        panel_1.add(nextButton3);

        nextButtonOperatorMult = new JButton("*");
        nextButtonOperatorMult.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButtonOperatorMult.setBounds(230, 139, 70, 35);
        nextButtonOperatorMult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("*");
            }
        });
        panel_1.add(nextButtonOperatorMult);

        nextButton0 = new JButton("0");
        nextButton0.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton0.setBounds(12, 202, 70, 35);
        nextButton0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("0");
            }
        });
        panel_1.add(nextButton0);

        nextButtonPoint = new JButton(".");
        nextButtonPoint.setFont(new Font("Arial", Font.BOLD, 16));
        nextButtonPoint.setBounds(85, 202, 70, 35);
        nextButtonPoint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText(".");
            }
        });
        panel_1.add(nextButtonPoint);

        JButton nextButtonPlusMoins = new JButton("+-");
        nextButtonPlusMoins.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButtonPlusMoins.setBounds(157, 202, 70, 35);
        nextButtonPlusMoins.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                double d = Double.parseDouble(ecran.getText());
                d*=(-1);
                ecran.setText(String.valueOf(d));
            }
        });
        panel_1.add(nextButtonPlusMoins);

        JButton div = new JButton("/");
        div.setFont(new Font("Arial", Font.PLAIN, 16));
        div.setBounds(230, 202, 70, 35);
        div.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                appendText("/");
            }
        });
        panel_1.add(div);

        nextButtonEgal = new JButton("=");
        nextButtonEgal.setFont(new Font("Arial", Font.BOLD, 16));
        nextButtonEgal.setBounds(318, 438, 70, 35);
        nextButtonEgal.setEnabled(true);
        nextButtonEgal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
              if(nextButtonEgal.isEnabled()){
                  //  creation de script engine qui va faire les operations grace a l'appui sur egal
                  ScriptEngineManager mgr = new ScriptEngineManager();
                  ScriptEngine engine = mgr.getEngineByName("JavaScript");

                  String res = ecran.getText();
                  try {
                      ecran.setText(String.valueOf(engine.eval(res)));
                  } catch (ScriptException e) {
                      ecran.setText("Error");
                  }
              }
            }
        });

        contentPane.add(nextButtonEgal);

        //panel pour les touches a droite; et leur listener
        Panel panel_2 = new Panel();
        panel_2.setBackground(colorbackground);
        panel_2.setBounds(390, 233, 468, 255);
        panel_2.setVisible(true);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        try {
            nextButtonX2 = new JButton("χ2 ");
            nextButtonX2.setBounds(12, 13, 70, 35);
            nextButtonX2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(s);
                        if(x<0){
                            x=Math.pow(x*(-1),2);
                            ecran.setText(String.valueOf(x));
                        }else
                            ecran.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.pow(x,2))));
                    }

                }
            });
            panel_2.add(nextButtonX2);

            nextButtonX3 = new JButton("χ3 ");
            nextButtonX3.setBounds(104, 13, 70, 35);
            nextButtonX3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(String.valueOf(s));
                        ecran.setText(String.valueOf(Math.pow(x,3)));
                    }

                }
            });
            panel_2.add(nextButtonX3);

            JButton nextButtonXY = new JButton("χ^y");
            nextButtonXY.setBounds(198, 13, 70, 35);
            nextButtonXY.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        appendText("^");
                        nextButtonEgal.setEnabled(false);
                        nextButtonEgal.setText("?");
                        nextButtonEgal2.setEnabled(true);
                        nextButtonEgal2.setText("=");
                    }

                }
            });
            panel_2.add(nextButtonXY);

            JButton nextButtonDivX = new JButton(" 1/x");
            nextButtonDivX.setBounds(292, 13, 70, 35);
            nextButtonDivX.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    int n = ecran.getText().length()-1;

                    if(len > 0) {
                        String s = ecran.getText();
                        ecran.setText(rep_last(s,"1/"+s.charAt(n) ));
                    }

                }
            });
            panel_2.add(nextButtonDivX);

            JButton nextButtonParentOuv = new JButton("( ");
            nextButtonParentOuv.setBounds(386, 13, 70, 35);
            nextButtonParentOuv.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    appendText("(");

                }
            });
            panel_2.add(nextButtonParentOuv);

            JButton nextButtonRac = new JButton(" √");
            nextButtonRac.setBounds(12, 61, 70, 35);
            nextButtonRac.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(s);
                        if(x >= 0)
                            ecran.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.sqrt(x))));
                        else ecran.setText("Error");
                    }

                }
            });
            panel_2.add(nextButtonRac);

            JButton nextButtonRac3 = new JButton("∛ ");
            nextButtonRac3.setBounds(104, 61, 70, 35);
            nextButtonRac3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(s);
                        if(x >= 0)
                            ecran.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.cbrt(x))));
                        else ecran.setText("Error");
                    }

                }
            });
            panel_2.add(nextButtonRac3);

            JButton nextButtonRacN = new JButton("y√ ");
            nextButtonRacN.setBounds(198, 61, 70, 35);
            nextButtonRacN.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        appendText("√");
                        nextButtonEgal.setEnabled(false);
                        nextButtonEgal.setText("?");
                        nextButtonEgal2.setEnabled(true);
                        nextButtonEgal2.setText("=");
                    }
                }
            });

            panel_2.add(nextButtonRacN);

            JButton nextButtonFac = new JButton("n!");
            nextButtonFac.setBounds(292, 61, 70, 35);
            nextButtonFac.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(String.valueOf(s));
                        if (x>=1) {
                            double c = fac(x);
                            ecran.setText(String.valueOf(c));
                        }else
                        ecran.setText("Error");
                    }

                }
            });
            panel_2.add(nextButtonFac);

            JButton nextButtonParentFerme = new JButton(")");
            nextButtonParentFerme.setBounds(386, 61, 70, 35);
            nextButtonParentFerme.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    appendText(")");

                }
            });
            panel_2.add(nextButtonParentFerme);

            JButton nextButtonSin = new JButton("sin");
            nextButtonSin.setBounds(12, 109, 70, 35);
            nextButtonSin.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Math.sin(Math.toRadians(Double.parseDouble(s))) ;

                        ecran.setText(String.valueOf(x));
                    }
                }
            });
            panel_2.add(nextButtonSin);

            JButton nextButtonCos = new JButton("cos ");
            nextButtonCos.setBounds(104, 109, 70, 35);
            nextButtonCos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Math.cos(Math.toRadians(Double.parseDouble(s)));
                        ecran.setText(String.valueOf(x));
                    }
                }
            });
            panel_2.add(nextButtonCos);

            JButton nextButtonTan = new JButton("tan ");
            nextButtonTan.setBounds(198, 109, 70, 35);
            nextButtonTan.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Math.tan(Math.toRadians(Double.parseDouble(s)));
                        ecran.setText(String.valueOf(x));
                    }
                }
            });
            panel_2.add(nextButtonTan);

            JButton nextButtonEx = new JButton("exp ");
            nextButtonEx.setBounds(292, 109, 70, 35);
            nextButtonEx.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(s);
                        ecran.setText(String.valueOf(Math.exp(x)));
                    }

                }
            });
            panel_2.add(nextButtonEx);

            JButton nextButtonNP = new JButton("nPr");
            nextButtonNP.setBounds(386, 109, 70, 35);
            nextButtonNP.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    int n = ecran.getText().length()-1;
                    int n2 =  ecran.getText().length()-2;
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double N =  Double.parseDouble(String.valueOf(s.charAt(n)));
                        double R =  Double.parseDouble(String.valueOf(s.charAt(n2)));
                        double p = fac(N) / fac(N - R);
                        ecran.setText(rep_last(""+s.subSequence(0, s.length()-1),String.valueOf(p)));
                    }

                }
            });
            panel_2.add(nextButtonNP);

            JButton nextButtonSinh = new JButton("sinh ");
            nextButtonSinh.setBounds(12, 157, 70, 35);
            nextButtonSinh.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {

                    int len = ecran.getText().length();
                    String s = "";
                    if (len > 0) {
                        s = ecran.getText();
                        double x = Math.sinh(Double.parseDouble(s));
                        ecran.setText(String.valueOf(x));

                    }
                }
            });
            panel_2.add(nextButtonSinh);

            JButton nextButtonSinM1= new JButton("sin-1 ");
            nextButtonSinM1.setBounds(12, 205, 70, 35);
            nextButtonSinM1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(String.valueOf(s));
                        ecran.setText(String.valueOf(Math.toDegrees(Math.asin(x))));
                    }

                }
            });
            panel_2.add(nextButtonSinM1);

            JButton nextButtonCosh = new JButton("cosh ");
            nextButtonCosh.setBounds(104, 157, 70, 35);
            nextButtonCosh.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s = "";
                    if (len > 0) {
                        s = ecran.getText();
                        double x = Math.cosh(Double.parseDouble(s));
                        ecran.setText(String.valueOf(x));

                    }

                }
            });
            panel_2.add(nextButtonCosh);

            JButton nextButtonTanh = new JButton("tanh");
            nextButtonTanh.setBounds(198, 157, 70, 35);
            nextButtonTanh.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s = "";
                    if (len > 0) {
                        s = ecran.getText();
                        double x = Math.tanh(Double.parseDouble(s));
                        ecran.setText(String.valueOf(x));

                    }

                }
            });
            panel_2.add(nextButtonTanh);

            JButton nextButtonLo = new JButton("ln");
            nextButtonLo.setBounds(292, 157, 70, 35);
            nextButtonLo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(s);
                        if(x>0)
                        ecran.setText(String.valueOf(Math.log(x)));
                        else
                            ecran.setText("Error");
                    }

                }
            });
            panel_2.add(nextButtonLo);

            JButton nextButtonNC = new JButton("nCr ");
            nextButtonNC.setBounds(386, 157, 70, 35);
            nextButtonNC.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    int n = ecran.getText().length()-1;
                    int n2 =  ecran.getText().length()-2;
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double N =  Double.parseDouble(String.valueOf(s.charAt(n)));
                        double R =  Double.parseDouble(String.valueOf(s.charAt(n2)));
                        double C = fac(N) / (fac(R) * fac(N - R));
                        ecran.setText(rep_last(""+s.subSequence(0, s.length()-1),String.valueOf(C)));
                    }

                }
            });
            panel_2.add(nextButtonNC);

            JButton nextButtonCosM1 = new JButton("cos-1 ");
            nextButtonCosM1.setBounds(104, 205, 70, 35);
            nextButtonCosM1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(String.valueOf(s));
                        ecran.setText(String.valueOf(Math.toDegrees(Math.acos(x))));
                    }

                }
            });
            panel_2.add(nextButtonCosM1);

            JButton nextButtonTanM1 = new JButton("tan-1 ");
            nextButtonTanM1.setBounds(198, 205, 70, 35);
            nextButtonTanM1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(String.valueOf(s));
                        ecran.setText(String.valueOf(Math.toDegrees(Math.atan(x))));
                    }

                }
            });
            panel_2.add(nextButtonTanM1);

            JButton nextButtonLo10 = new JButton("log10");
            nextButtonLo10.setBounds(292, 205, 70, 35);
            nextButtonLo10.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    int len = ecran.getText().length();
                    int n = ecran.getText().length()-1;
                    String s="";
                    if(len > 0) {
                        s = ecran.getText();
                        double x =  Double.parseDouble(String.valueOf(s.charAt(n)));
                        ecran.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.log10(x))));
                    }

                }
            });
            panel_2.add(nextButtonLo10);

            JButton nextButtonPi = new JButton("∏");
            nextButtonPi.setBounds(386, 205, 70, 35);
            nextButtonPi.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    appendText(""+Math.PI);
                }
            });
            panel_2.add(nextButtonPi);

            // creation checkbox pour changer de mode
            JRadioButton nextRadioButton= new JRadioButton("Scientifique");
            nextRadioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(nextRadioButton.isSelected())
                        panel_2.setVisible(true);
                    else panel_2.setVisible(false);
                }
            });

            nextRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
            nextRadioButton.setBackground(Color.black);
            nextRadioButton.setForeground(Color.white);
            nextRadioButton.setBounds(400, 100, 130, 25);

            contentPane.add(nextRadioButton);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    nextButtonEgal2.setFont(new Font("Arial", Font.BOLD, 16));
    nextButtonEgal2.setBounds(318, 400, 70, 35);
    nextButtonEgal2.setEnabled(false);
    nextButtonEgal2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent arg0) {
           if(nextButtonEgal2.isEnabled()){
               int len = ecran.getText().length();
               String s="";
               String collec="";
               String collecte="";
               String collecc="";
               String colleccc="";
               if(len > 0) {
                   s = ecran.getText();
               }
               for(int i=0;i<s.length();i++){
                   if(s.charAt(i)=='^'){
                       tem=true;
//                       System.out.print(s.charAt(i));
                       for(int j=0;j<i;j++){
                           collec+=String.valueOf(s.charAt(j));
                       }
                       for(int k=i+1;k<s.length();k++){
                           collecte+=String.valueOf(s.charAt(k));
                       }
                   }
               }
               for (int i=0;i<s.length();i++){
                    if(s.charAt(i)=='√'){
                       tem2=true;
                       for(int l=0;l<i;l++){
                           collecc+=String.valueOf(s.charAt(l));
                       }
                       for(int m=i+1;m<s.length();m++){
                           colleccc+=String.valueOf(s.charAt(m));
                       }
                   }
               }
               if(tem){
                   try{
                       double x=Double.parseDouble(collec);
                       double y=Double.parseDouble(collecte);
                       double resultat = Math.pow(x,y);
                       ecran.setText(String.valueOf(resultat));
                       tem=false;
                   }catch(NumberFormatException e) {
                       ecran.setText("Error");
                   }

               }
               if (tem2){
                   try{
                       double x=Double.parseDouble(collecc);
                       double y=Double.parseDouble(colleccc);
                       ecran.setText(String.valueOf(Math.pow(y,1/x)));
                       tem2=false;
                   }catch(NumberFormatException e) {
                       ecran.setText("Error");
                   }
               }
           }else {
               ecran.setText(ecran.getText());
           }
           nextButtonEgal.setEnabled(true);
            nextButtonEgal.setText("=");
           nextButtonEgal2.setEnabled(false);
            nextButtonEgal2.setText("?");
        }
    });
        contentPane.add(nextButtonEgal2);

    }

    // methode pour affichage
    void appendText(String s) {
        ecran.setText(ecran.getText()+s);
    }

    // methode pour effacer une caractere
    String rep_last(String s , String c) {
        return s.substring(0,s.length()-1) + c;
    }


    // methode factorielle
    double fac(double n) {
        if(n <= 1)return 1;
        else return n * fac(n-1);
    }
}
