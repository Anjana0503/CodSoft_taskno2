package com.anjana.calc;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.text.DecimalFormat;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    ImageView btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0,btn_backspace;
    ImageView btn_dot, btn_equal, btn_ac, btn_div,btn_module, btn_plus, btn_minus, btn_multiplication;
    ImageView btn_more, btn_sqrt, btn_pi, btn_power,btn_fact, btn_DEG,btn_sin, btn_cos, btn_tan, btn_bracket;
    ImageView btn_INV, btn_e, btn_ln, btn_log;
    LinearLayout llextra1, llextra2;
    TextView inputTxt, outPuttxt;
    String input = "";
    boolean isDegreeMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outPuttxt = findViewById(R.id.outPuttxt);
        inputTxt = findViewById(R.id.inputTxt);

        llextra1= findViewById(R.id.llextra1);
        llextra2= findViewById(R.id.llextra2);

        btn_more = findViewById(R.id.btn_more);
        btn_sqrt = findViewById(R.id.btn_sqrt);
        btn_pi = findViewById(R.id.btn_pi);
        btn_power = findViewById(R.id.btn_power);
        btn_fact = findViewById(R.id.btn_fact);
        btn_DEG = findViewById(R.id.btn_DEG);
        btn_sin = findViewById(R.id.btn_sin);
        btn_cos = findViewById(R.id.btn_cos);
        btn_tan = findViewById(R.id.btn_tan);
        btn_INV = findViewById(R.id.btn_INV);
        btn_e = findViewById(R.id.btn_e);
        btn_ln = findViewById(R.id.btn_ln);
        btn_log = findViewById(R.id.btn_log);
        btn_bracket = findViewById(R.id.btn_bracket);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);


        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="0";
                inputTxt.setText(input);
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="1";
                inputTxt.setText(input);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="2";
                inputTxt.setText(input);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="3";
                inputTxt.setText(input);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="4";
                inputTxt.setText(input);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="5";
                inputTxt.setText(input);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="6";
                inputTxt.setText(input);
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="7";
                inputTxt.setText(input);
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="8";
                inputTxt.setText(input);
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="9";
                inputTxt.setText(input);
            }
        });

        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        btn_ac = findViewById(R.id.btn_ac);
        btn_backspace = findViewById(R.id.btn_backspace);
        btn_div = findViewById(R.id.btn_div);
        btn_module = findViewById(R.id.btn_module);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiplication = findViewById(R.id.btn_multiplication);

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input="";
                inputTxt.setText("");
                outPuttxt.setText("");
            }
        });
        btn_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.isEmpty()){
                    input = input.substring(0,input.length()-1);
                    inputTxt.setText(input);
                }
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.contains(".")){
                    input+=".";
                    inputTxt.setText(input);
                }
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.isEmpty()){
                    input+="+";
                    inputTxt.setText(input);
                }
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.isEmpty()){
                    input+="-";
                    inputTxt.setText(input);
                } else if (input.charAt(input.length()-1)=='-') {
                    input+="-";
                    inputTxt.setText(input);
                }else {
                    input+="-";
                    inputTxt.setText(input);
                }
            }
        });
        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.isEmpty()){
                    input+="%";
                    inputTxt.setText(input);
                }
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.isEmpty()){
                    input+="/";
                    inputTxt.setText(input);
                }
            }
        });
        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.isEmpty()){
                    input+="*";
                    inputTxt.setText(input);
                }
            }
        });

        btn_more.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(llextra1.getVisibility() == View.VISIBLE && llextra2.getVisibility() == View.VISIBLE){
                     llextra1.setVisibility(View.GONE);
                     llextra2.setVisibility(View.GONE);
                 }else {
                     llextra1.setVisibility(View.VISIBLE);
                     llextra2.setVisibility(View.VISIBLE);
                 }
             }
         });
        btn_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!input.isEmpty()){
                    try {
                        double number = Double.parseDouble(input);
                        input = "√"+input;
                        inputTxt.setText(input);
                        double result = Math.sqrt(number);
                        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
                        String finalResult = decimalFormat.format(result);
                        outPuttxt.setText(finalResult);
                    }catch (NumberFormatException e){
                        Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+=Math.PI;
                inputTxt.setText(input);
            }
        });
        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.isEmpty()){
                    input+="^";
                    inputTxt.setText(input);
                }
            }
        });
        btn_fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    try {
                        int number = Integer.parseInt(input);
                        if (number < 0) {
                            Toast.makeText(MainActivity.this, "Factorial of a negative number is undefined", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        input = input + "!";
                        inputTxt.setText(input);
                        BigInteger factorial = BigInteger.ONE;
                        for (int i = 2; i <= number; i++) {
                            factorial = factorial.multiply(BigInteger.valueOf(i));
                        }
                        outPuttxt.setText(factorial.toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_bracket.setOnClickListener(new View.OnClickListener() {
            boolean isOpenBracket = true;
            @Override
            public void onClick(View view) {
                if (isOpenBracket) {
                    input+="(";
                    isOpenBracket = false;
                }else {
                    input+=")";
                    isOpenBracket = true;
                }
                inputTxt.setText(input);
            }
        });
        btn_DEG.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                isDegreeMode = !isDegreeMode;
                if (isDegreeMode) {
                    btn_DEG.setImageResource(R.drawable.ic_deg);
                    Toast.makeText(MainActivity.this, "Degree mode activated", Toast.LENGTH_SHORT).show();
                } else {
                    btn_DEG.setImageResource(R.drawable.ic_rad);
                    Toast.makeText(MainActivity.this, "Radian mode activated", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        double result;

                        if (isDegreeMode) {
                            double radians = Math.toRadians(number);
                            result = Math.sin(radians);
                        } else {
                            result = Math.sin(number);
                        }
                        input = "Sin(" + input + ")";
                        inputTxt.setText(input);
                        input = String.valueOf(result); // Update input with the sin result
                        outPuttxt.setText(input); // Display the sin result as output
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        double result;

                        if (isDegreeMode) {
                            double radians = Math.toRadians(number);
                            result = Math.cos(radians);
                        } else {
                            result = Math.cos(number);
                        }
                        input = "Cos(" + input + ")";
                        inputTxt.setText(input);
                        input = String.valueOf(result); // Update input with the sin result
                        outPuttxt.setText(input); // Display the sin result as output
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        double result;

                        if (isDegreeMode) {
                            double radians = Math.toRadians(number);
                            result = Math.tan(radians);
                        } else {
                            result = Math.tan(number);
                        }
                        input = "tan(" + input + ")";
                        inputTxt.setText(input);
                        input = String.valueOf(result); // Update input with the sin result
                        outPuttxt.setText(input); // Display the sin result as output
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        if (number <= 0) {
                            Toast.makeText(MainActivity.this, "Invalid input for ln", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        input = "ln(" + input + ")";
                        inputTxt.setText(input);
                        double result = Math.log(number);
                        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
                        String finalResult = decimalFormat.format(result);
                        outPuttxt.setText(finalResult);
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input for ln", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        if (number <= 0) {
                            Toast.makeText(MainActivity.this, "Invalid input for log", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        input = "log(" + input + ")";
                        inputTxt.setText(input);
                        double result = Math.log10(number);
                        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
                        String finalResult = decimalFormat.format(result);
                        outPuttxt.setText(finalResult);
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input for log", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+=Math.E;
                inputTxt.setText(input);
            }
        });
        btn_INV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        if (number == 0) {
                            Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        input = "INV(" + input + ")";
                        inputTxt.setText(input);
                        double inverse = 1 / number;
                        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
                        String result = decimalFormat.format(inverse);
                        outPuttxt.setText(result);
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.isEmpty()) {
                    try {
                        String expression = input.replaceAll("%", "/100");
                        String[] parts = input.split("\\^");
                        if (parts.length == 2) {
                            double base = Double.parseDouble(parts[0]);
                            double exponent = Double.parseDouble(parts[1]);
                            double result = Math.pow(base, exponent);
                            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
                            String finalResult = decimalFormat.format(result);
                            outPuttxt.setText(finalResult);
                        } else {
                            // Handle other mathematical operations
                            double result = evaluateExpression(expression);
                            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
                            String finalResult = decimalFormat.format(result);
                            outPuttxt.setText(finalResult);
                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Invalid input or calculation", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter a valid expression", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private double evaluateExpression(String expression) {
        double result = 0.0;
        try {
            result = new Object() {
                int pos = -1, ch;

                void nextChar() {
                    ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                }

                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expression.length()) {
                        throw new RuntimeException("Unexpected: " + (char) ch);
                    }
                    return x;
                }

                double parseExpression() {
                    double x = parseTerm();
                    while (true) {
                        if (eat('+')) {
                            x += parseTerm();
                        } else if (eat('-')) {
                            x -= parseTerm();
                        } else {
                            return x;
                        }
                    }
                }

                double parseTerm() {
                    double x = parseFactor();
                    while (true) {
                        if (eat('*')) {
                            x *= parseFactor();
                        } else if (eat('/')) {
                            x /= parseFactor();
                        } else {
                            return x;
                        }
                    }
                }

                double parseFactor() {
                    if (eat('+')) {
                        return parseFactor();
                    }
                    if (eat('-')) {
                        return -parseFactor();
                    }

                    double x;
                    int startPos = this.pos;
                    if (eat('(')) {
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(expression.substring(startPos, this.pos));
                    } else {
                        throw new RuntimeException("Unexpected: " + (char) ch);
                    }

                    if (eat('^')) {
                        x = Math.pow(x, parseFactor());
                    }

                    return x;
                }
            }.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}