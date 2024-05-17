package JAVA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    JLabel label, timerLabel;
    JRadioButton radioButton[] = new JRadioButton[4];
    JButton nxtButton, submitButton;
    ButtonGroup bg;
    int count = 0, current = 0;
    Timer timer;
    int timeRemaining = 15 * 60; 

    Quiz(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        nxtButton = new JButton("Next");
        submitButton = new JButton("Result");
        submitButton.setVisible(false);
        submitButton.addActionListener(this);
        nxtButton.addActionListener(this);
        add(nxtButton);
        add(submitButton);
        

        timerLabel = new JLabel();
        add(timerLabel);
        timerLabel.setBounds(500, 10, 100, 20);




        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                    int minutes = timeRemaining / 60;
                    int seconds = timeRemaining % 60;
                    timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(Quiz.this, "Time's up! Your Score is " + count);
                    System.exit(0);
                }
            }
        });
        timer.start();

        setData();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 450, 20);
        radioButton[2].setBounds(50, 140, 450, 20);
        radioButton[3].setBounds(50, 170, 450, 20);
        nxtButton.setBounds(100, 240, 100, 30);
        submitButton.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    void setData() {
        radioButton[3].setSelected(true);
        if (current == 0) {
            label.setText("1. Who invented Java Programming?");
            radioButton[0].setText("a) Guido van Rossum");
            radioButton[1].setText("b) James Gosling");
            radioButton[2].setText("c) Dennis Ritchie");
            radioButton[3].setText("d) Bjarne Stroustrup");
        } else if (current == 1) {
            label.setText("2. Which statement is true about Java?");
            radioButton[0].setText("a) Java is a sequence-dependent programming language");
            radioButton[1].setText("b) Java is a code dependent programming language");
            radioButton[2].setText("c) Java is a platform-dependent programming language");
            radioButton[3].setText("d) Java is a platform-independent programming language");
        } else if (current == 2) {
            label.setText("3. Which component is used to compile, debug and execute the java programs?");
            radioButton[0].setText("a) JRE");
            radioButton[1].setText("b) JIT");
            radioButton[2].setText("c) JDK");
            radioButton[3].setText("d) JVM");
        } else if (current == 3) {
            label.setText("4. Which one of the following is not a Java feature?");
            radioButton[0].setText("a) Object-oriented");
            radioButton[1].setText("b) Use of pointers");
            radioButton[2].setText("c) Portable");
            radioButton[3].setText("d) Dynamic and Extensible");
        } else if (current == 4) {
            label.setText("5. Which of these cannot be used for a variable name in Java?");
            radioButton[0].setText("a) identifier & keyword");
            radioButton[1].setText("b) identifier");
            radioButton[2].setText("c) keyword");
            radioButton[3].setText("d) none of the mentioned");
        } else if (current == 5) {
            label.setText("6. What is the extension of java code files?");
            radioButton[0].setText("a) .js");
            radioButton[1].setText("b) .txt");
            radioButton[2].setText("c) .class");
            radioButton[3].setText("d) .java");
        } else if (current == 6) {
            label.setText("7. Which environment variable is used to set the java path?");
            radioButton[0].setText("a) MAVEN_Path");
            radioButton[1].setText("b) JavaPATH");
            radioButton[2].setText("c) JAVA");
            radioButton[3].setText("d) JAVA_HOME");
        } else if (current == 7) {
            label.setText("8. Which of the following is not an OOPS concept in Java?");
            radioButton[0].setText("a) Polymorphism");
            radioButton[1].setText("b) Inheritance");
            radioButton[2].setText("c) Compilation");
            radioButton[3].setText("d) Encapsulation");
        } else if (current == 8) {
            label.setText("9. Which of the following is a type of polymorphism in Java Programming?");
            radioButton[0].setText("a) Multiple polymorphism");
            radioButton[1].setText("b) Compile time polymorphism");
            radioButton[2].setText("c) Multilevel polymorphism");
            radioButton[3].setText("d) Execution time polymorphism");
        } else if (current == 9) {
            label.setText("10. What is Truncation in Java?");
            radioButton[0].setText("a) Floating-point value assigned to a Floating type");
            radioButton[1].setText("b) Floating-point value assigned to an integer type");
            radioButton[2].setText("c) Integer value assigned to floating type");
            radioButton[3].setText("d) Double value assigned to floating type");
        }
    }

    boolean checkAns() {
        if (current == 0) {
            return (radioButton[1].isSelected());
        } else if (current == 1) {
            return (radioButton[3].isSelected());
        } else if (current == 2) {
            return (radioButton[2].isSelected());
        } else if (current == 3) {
            return (radioButton[1].isSelected());
        } else if (current == 4) {
            return (radioButton[2].isSelected());
        } else if (current == 5) {
            return (radioButton[3].isSelected());
        } else if (current == 6) {
            return (radioButton[3].isSelected());
        } else if (current == 7) {
            return (radioButton[2].isSelected());
        } else if (current == 8) {
            return (radioButton[1].isSelected());
        } else if (current == 9) {
            return (radioButton[1].isSelected());
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nxtButton) {
            if (checkAns()) {
                count++;
            }
            current++;
            if (current == 10) {
                nxtButton.setEnabled(false);
                submitButton.setVisible(true);
            } else {
                setData();
            }
        } else if (e.getSource() == submitButton) {
            if (checkAns()) {
                count++;
            }
            JOptionPane.showMessageDialog(this, "Your Score is " + count);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Quiz("Sample Quiz TestApp");
    }
}
