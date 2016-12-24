package com.gmonetix.stringevaluator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends Activity {

    TextView tvResult;
    EditText etExpression;
    Button btn;
    Editable expression;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etExpression = (EditText) findViewById(R.id.etExpression);
        tvResult = (TextView) findViewById(R.id.tvresult);
        btn = (Button) findViewById(R.id.seeResult);
        expression = etExpression.getText();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Create an object of DoubleEvaluator for getting result in double type
                    DoubleEvaluator evaluator = new DoubleEvaluator();
                    result = evaluator.evaluate(String.valueOf(expression));
                    tvResult.setText(result.toString());
                }
                // Catching error for wrong expressions otherwise app will crash
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
