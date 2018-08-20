package com.example.anti2110.wantedjobshare.more;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.anti2110.wantedjobshare.R;

public class SignoutActivity extends AppCompatActivity {

    private ProgressBar sign_out_progressBar;
    private TextView sign_out_progressBar_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);

        sign_out_progressBar = (ProgressBar) findViewById(R.id.sign_out_progressBar);
        sign_out_progressBar_text = (TextView) findViewById(R.id.sign_out_progressBar_text);
        sign_out_progressBar.setVisibility(View.INVISIBLE);
        sign_out_progressBar_text.setVisibility(View.INVISIBLE);

    }

}
