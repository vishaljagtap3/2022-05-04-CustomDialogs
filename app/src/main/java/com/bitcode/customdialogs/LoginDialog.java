package com.bitcode.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {

    private EditText edtUsername, edtPassword;
    private Button btnSignIn;

    public interface OnLoginListener {
        void onSuccess();
        void onFail();
    }

    private OnLoginListener onLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public LoginDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.login_dialog);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new BtnSignInClickListener());

    }

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if(onLoginListener == null) {
                return;
            }

            if(edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode")) {
                /*mt("Success Action -- Start HomeActivity");
                dismiss();*/
                onLoginListener.onSuccess();
                dismiss();
            }
            else {
                //mt("Failure Action");
                onLoginListener.onFail();
            }
        }
    }

    private void mt(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }
}
