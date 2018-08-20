package com.example.anti2110.wantedjobshare.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.anti2110.wantedjobshare.R;

public class RegisterActivity extends Activity {

    private EditText register_email_edit_text;
    private EditText register_password_edit_text;
    private EditText register_password_confirm_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_email_edit_text = (EditText) findViewById(R.id.register_email_edit_text);
        register_password_edit_text = (EditText) findViewById(R.id.register_password_edit_text);
        register_password_confirm_edit_text = (EditText) findViewById(R.id.register_password_confirm_edit_text);




    }
}
