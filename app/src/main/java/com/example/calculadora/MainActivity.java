package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button clearBtn, eraseBtn, percentBtn, divBtn, sevenBtn, eigthBtn, nineBtn, multBtn, fourBtn, fiveBtn, sixBtn, minBtn, oneBtn, twoBtn, threeBtn, plusBtn, dotBtn, ceroBtn, resultBtn;
    TextView resultTxt, operationTxt;
    Boolean isOperated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
        loadListeners();
    }

    public void loadComponents() {
        oneBtn = findViewById(R.id.oneBtn);
        twoBtn = findViewById(R.id.twoBtn);
        threeBtn = findViewById(R.id.threeBtn);
        fourBtn = findViewById(R.id.fourBtn);
        fiveBtn = findViewById(R.id.fiveBtn);
        sixBtn = findViewById(R.id.sixBtn);
        sevenBtn = findViewById(R.id.sevenBtn);
        eigthBtn = findViewById(R.id.eigthBtn);
        nineBtn = findViewById(R.id.nineBtn);
        ceroBtn = findViewById(R.id.ceroBtn);
        dotBtn = findViewById(R.id.dotBtn);
        clearBtn = findViewById(R.id.clearBtn);
        eraseBtn = findViewById(R.id.eraseBtn);
        percentBtn = findViewById(R.id.percentBtn);
        divBtn = findViewById(R.id.divBtn);
        multBtn = findViewById(R.id.multBtn);
        minBtn = findViewById(R.id.minBtn);
        plusBtn = findViewById(R.id.plusBtn);
        resultBtn = findViewById(R.id.resultBtn);
        resultTxt = findViewById(R.id.resultTxt);
        operationTxt = findViewById(R.id.operationTxt);
    }


    public void loadListeners() {

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("1");
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("2");
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("3");
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("4");
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("5");
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("6");
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("7");
            }
        });

        eigthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("8");
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("9");
            }
        });

        ceroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("0");
            }
        });

        dotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(".");
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("+");
            }
        });

        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("-");
            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("x");
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("/");
            }
        });

        percentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText("%");
            }
        });


        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation();
            }
        });

        eraseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence result = "";
                if (operationTxt.getText().toString().isEmpty()) {
                    result = resultTxt.getText().toString();
                    if (result.length() > 0) {
                        resultTxt.setText(result.subSequence(0, result.length() - 1));
                    }
                } else {
                    result = operationTxt.getText().toString();
                    if (result.length() > 0) {
                        operationTxt.setText(result.subSequence(0, result.length() - 1));
                    }
                }
                if (result.length() > 2) {
                    operation();
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }

    public void operation() {
        String val = "";
        double val1 = 0;
        double val2 = 0;
        double res = 0;

        if (operationTxt.getText().toString().isEmpty()) {
            val = resultTxt.getText().toString();
        } else {
            val = operationTxt.getText().toString();
        }

        System.out.println("###############################");
        System.out.println("Val: " + val);
        String[] splitVal = val.split("[-+x/]");
        System.out.println("splitVal.length: " + splitVal.length);

        for (String num : splitVal) {
            System.out.println("num: " + num);
            System.out.println("indexOf: " + val.indexOf(num));
            System.out.println(val.indexOf(num) != 0);
            if ((val.indexOf(num) != 0)) {
                val2 = Double.parseDouble(num);
                String op = val.substring(val.indexOf(num) - 1, val.indexOf(num));
                switch (op) {
                    case "+":
                        res = val1 + val2;
                        setResult(val, String.valueOf(res));
                        val1 = res;
                        break;
                    case "-":
                        res = val1 - val2;
                        setResult(val, String.valueOf(res));
                        val1 = res;
                        break;
                    case "x":
                        res = val1 * val2;
                        setResult(val, String.valueOf(res));
                        val1 = res;
                        break;
                    case "/":
                        if (val2 > 0 ){
                            res = val1 / val2;
                            setResult(val, String.valueOf(res));
                            val1 = res;
                        }else{
                            resultTxt.setText("Error");
                        }
                        break;
                    case "%":
                        res = val1 % val2;
                        setResult(val, String.valueOf(res));
                        val1 = res;
                        break;
                }
            } else {
                val1 = Double.parseDouble(num);
                setResult("", val);
            }
        }


        /*if
        }

        if (val.contains("-") && val.split("[-]").length > 1) {
            val1 = Double.parseDouble(val.split("[-]")[0]);
            val2 = Double.parseDouble(val.split("[-]")[1]);

        }

        if (val.contains("x") && val.split("[x]").length > 1) {
            val1 = Double.parseDouble(val.split("[x]")[0]);
            val2 = Double.parseDouble(val.split("[x]")[1]);

            setResult(val,String.valueOf(val1 * val2));
        }

        if (val.contains("/") && val.split("[/]").length > 1) {
            val1 = Double.parseDouble(val.split("[/]")[0]);
            val2 = Double.parseDouble(val.split("[/]")[1]);

            if (val2 > 0 ){
                setResult(val,String.valueOf(val1 / val2));
            }else{
                resultTxt.setText("Error");
            }
        }

        if (val.contains("%") && val.split("[%]").length > 1) {
            val1 = Double.parseDouble(val.split("[%]")[0]);
            val2 = Double.parseDouble(val.split("[%]")[1]);
            setResult(val,String.valueOf(val1 % val2));
        }*/
    }

    public void setResult(String operation, String value) {
        operationTxt.setText(operation);
        resultTxt.setText(value);
        isOperated = true;
    }

    public void clear() {
        resultTxt.setText("");
        operationTxt.setText("");
    }

    public void setText(String text) {
        if (operationTxt.getText().toString().isEmpty()) {
            resultTxt.setText(resultTxt.getText().toString() + text);
        } else {
            operationTxt.setText(operationTxt.getText().toString() + text);
        }
        operation();
    }
}