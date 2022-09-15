package com.ekramul.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weight,height_1,height_2;
    TextView display;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height_1 = findViewById(R.id.height_1);
        height_2 = findViewById(R.id.height_2);
        button = findViewById(R.id.button);
        display = findViewById(R.id.display);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (weight.length() !=0 && height_1.length() !=0 && height_2.length() !=0 ){

                    String wt,ht1,ht2;
                    float fwt,fht1,fht2,final_height,bmi;
                    wt = weight.getText().toString();
                    ht1 = height_1.getText().toString();
                    ht2 = height_2.getText().toString();

                    fwt = Float.parseFloat(wt);
                    fht1 = Float.parseFloat(ht1);
                    fht2 = Float.parseFloat(ht2);

                    final_height = (float) (fht1*0.3048 + fht2*0.0254);
                    bmi = fwt/(final_height*final_height);

                        if (bmi<16){
                            display.setText(""+"Your BMI: "+String.format("%.2f",bmi)+"%"+"\n Your Fitness: Severe Thinness");
                        }
                        else if (bmi<17){
                            display.setText(""+"Your BMI: "+String.format("%.2f",bmi)+"%"+"\n Your Fitness: Moderate Thinness");
                        }

                        else if (bmi<18.5){
                            display.setText(""+"Your BMI: "+String.format("%.2f",bmi)+"%"+"\n Your Fitness: Mild Thinness");
                        }
                        else if (bmi<25){
                            display.setText("Your BMI: "+String.format("%.2f",bmi)+"%"+"\n Your Fitness: Normal");
                        }

                        else if (bmi<30){
                            display.setText(""+"Your BMI: "+String.format("%.2f",bmi)+"%"+"\n Your Fitness: Overweight");
                        }

                        else {
                            display.setText(""+"Your BMI: "+String.format("%.2f",bmi)+"%"+"\nYour Fitness: Obese Class");
                        }


                }

                else {
                    weight.setError("please input data");
                    height_1.setError("please input data");
                    height_2.setError("please input data");
                }


            }
        });
    }
}