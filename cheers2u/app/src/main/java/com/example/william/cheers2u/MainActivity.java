package com.example.william.cheers2u;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);

        final Button button1 = (Button) findViewById(R.id.button1);
        final TextView ans = (TextView) findViewById(R.id.right);
        final EditText drinks = (EditText) findViewById(R.id.dinks);
        final EditText time = (EditText) findViewById(R.id.time);
        final EditText Weight = (EditText) findViewById(R.id.weight);
        final CheckBox man = (CheckBox) findViewById(R.id.man);
        final CheckBox women = (CheckBox) findViewById(R.id.women);
        final RelativeLayout ImageView = (RelativeLayout) findViewById(R.id.imageView1);


        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {

                String no = drinks.getText().toString();       //get values dirnks
                final double d = Double.parseDouble(no);

                String no1 = time.getText().toString();       //get values dirnks
                final double t = Double.parseDouble(no1);

                String no2 = Weight.getText().toString();       //get values dirnks
                final double w = Double.parseDouble(no2);

                final Boolean manstate = man.isChecked();
                final Boolean womenstate = women.isChecked();

                if (manstate == true && womenstate == true) {
                    double concent = ((((0.806 * d * 1.2) / (0.58 * (0.453592*w))) - (0.017 * t)) + (((0.806 * d * 1.2) / (0.49 * (0.453592*w))) - (0.017 * t))) / 2;
                    if (concent < 0) {
                        concent = 0;
                    }
                    String strans = Double.toString(concent);
                    ans.setText(strans);

                    if (concent > 0.08) {
                        ImageView.setBackgroundResource(R.drawable.beer3);
                    } else {
                        ImageView.setBackgroundResource(R.drawable.beer2);
                        ;
                    }

                } else if (manstate) {
                    double concent = ((0.806 * d * 1.2) / (0.58 * (0.453592*w))) - (0.017 * t);
                    if (concent < 0) {
                        concent = 0;
                    }

                    String strans = Double.toString(concent);
                    ans.setText(strans);

                    if (concent > 0.08) {
                        ImageView.setBackgroundResource(R.drawable.beer3);
                    } else {
                        ImageView.setBackgroundResource(R.drawable.beer2);
                    }

                } else if (womenstate) {
                    double concent = ((0.806 * d * 1.2) / (0.49 * (0.453592*w))) - (0.017 * t);
                    if (concent < 0) {
                        concent = 0;
                    }

                    String strans2 = Double.toString(concent);
                    ans.setText(strans2);

                    if (concent > 0.08) {
                        ImageView.setBackgroundResource(R.drawable.beer3);
                    } else {
                        ImageView.setBackgroundResource(R.drawable.beer2);
                    }

                } else {
                    ans.setText("Check a box!");
                    ImageView.setBackgroundResource(R.drawable.beer2);
                }
            }
        });
    }
}
