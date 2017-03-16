package com.example.klemens.einzelbeispiel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

                                                                                                    /* Variables that are gonna get used */
    double dividend;
    double divisor;
                                                                                                    /* Using Booleans for the most common input errors */
    boolean noDividend = false;
    boolean noDivisor = false;
    boolean divisorZero = false;


    public void setDividend() {
        EditText editText = (EditText)findViewById(R.id.dividendInput);
        String value = editText.getText().toString();
        if (value.isEmpty()){                                                                       /*Checking if dividend is empty */
            this.noDividend = true;
        }
        else {
            try {                                                                                   /* For the unusual case, that something happened with the input */
                this.dividend = Double.parseDouble(value);
            }
            catch (Exception e){

            }

        }
    }

    public double getDividend() {
        setDividend();
        return dividend;
    }

    public void setDivisor() {
        EditText editText = (EditText)findViewById(R.id.divisorInput);
        String value = editText.getText().toString();
        if (value.isEmpty()){                                                                       /* Checking if divisor is empty */
            this.noDivisor = true;
        }
        else if (Double.parseDouble(value) == 0){                                                   /* Checking if divisor is 0 */
            this.divisorZero = true;
        }
        else {
            try {                                                                                   /* Same as the last exception */
                this.divisor = Double.parseDouble(value);
            }
            catch (Exception e){

            }

        }

    }

    public double getDivisor() {
        setDivisor();
        return divisor;
    }


    public void calculateButton(View view){
        TextView textView = (TextView)findViewById(R.id.output);
        double dividend = getDividend();
        double divisor = getDivisor();


        if (noDividend == true){
            textView.setText("Kein Dividend angegeben.");
            this.noDividend = false;                                                                /* Return Value back to false, so that we wont get stuck */
        }
        else if (noDivisor == true){
            textView.setText("Kein Divisor angegeben.");
            this.noDivisor = false;                                                                 /* Same as above */
        }
        else if (divisorZero == true){
            textView.setText("Division durch 0 macht keinen Sinn.");
            this.divisorZero = false;                                                               /* Same as above */
        }
        else {
            String output = String.valueOf(dividend/divisor);
            textView.setText(output);
        }
    }


}
