package com.example.gt_2m_6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email_input);
        EditText password = findViewById(R.id.pass_input);
        Button sign_btn = findViewById(R.id.sign_btn);


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!(charSequence.toString().length()==0) && !(password.getText().toString().length()==0)){
                    sign_btn.setBackgroundColor(getResources().getColor(R.color.orange));
                } else{
                    sign_btn.setBackgroundColor(getResources().getColor(R.color.gray));

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!(charSequence.toString().length()==0) && !(email.getText().toString().length()==0)){
                    sign_btn.setBackgroundColor(getResources().getColor(R.color.orange));
                } else{
                    sign_btn.setBackgroundColor(getResources().getColor(R.color.gray));

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        sign_btn.setOnClickListener(view -> {
            if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();
                findViewById(R.id.container).setVisibility(View.GONE);
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_LONG).show();
            }
        });


    }
}