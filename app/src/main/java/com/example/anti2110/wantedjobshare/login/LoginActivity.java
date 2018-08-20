package com.example.anti2110.wantedjobshare.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.anti2110.wantedjobshare.R;

public class LoginActivity extends Activity {

    private EditText login_email_edit_text;
    private EditText login_password_edit_text;
    private Button login_btn;
    private Button login_register_btn;

    private ProgressBar login_progressbar;
    private TextView login_progressbar_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email_edit_text = (EditText) findViewById(R.id.login_email_edit_text);
        login_password_edit_text = (EditText) findViewById(R.id.login_password_edit_text);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_register_btn = (Button) findViewById(R.id.login_register_btn);

        login_progressbar = (ProgressBar) findViewById(R.id.login_progressbar);
        login_progressbar_text = (TextView) findViewById(R.id.login_progressbar_text);
        login_progressbar.setVisibility(View.INVISIBLE);
        login_progressbar_text.setVisibility(View.INVISIBLE);


    }
}
