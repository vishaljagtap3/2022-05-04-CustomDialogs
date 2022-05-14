package com.bitcode.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtUsername, edtPassword;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            Dialog loginDialog = new Dialog(MainActivity.this);
            loginDialog.setContentView(R.layout.login_diaog);

            edtUsername = loginDialog.findViewById(R.id.edtUasername);
            edtPassword = loginDialog.findViewById(R.id.edtPassword);
            btnSignIn = loginDialog.findViewById(R.id.btnSignIn);

            btnSignIn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode")) {
                                mt("Success Action -- Start HomeActivity");
                                loginDialog.dismiss();
                            }
                            else {
                                mt("Failure Action");
                            }
                        }
                    }
            );

            loginDialog.show();
        }


    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}