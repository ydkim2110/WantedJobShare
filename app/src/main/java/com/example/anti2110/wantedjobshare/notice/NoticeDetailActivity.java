package com.example.anti2110.wantedjobshare.notice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anti2110.wantedjobshare.R;

public class NoticeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_CONTENT = "content";

    private TextView title;
    private TextView content;

    private ImageView notice_detail_toolbar_back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        title = (TextView) findViewById(R.id.notice_detail_title);
        content = (TextView) findViewById(R.id.notice_detail_content);
        notice_detail_toolbar_back_arrow = (ImageView) findViewById(R.id.notice_detail_toolbar_back_arrow);
        notice_detail_toolbar_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String passTitle = getIntent().getStringExtra(EXTRA_TITLE);
        String passContent = getIntent().getStringExtra(EXTRA_CONTENT);

        title.setText(passTitle);
        content.setText(passContent);

    }
}
