package com.example.anti2110.wantedjobshare.todo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anti2110.wantedjobshare.R;
import com.example.anti2110.wantedjobshare.database.DbHelper;

public class TodoActivity extends AppCompatActivity {

    private ImageView todo_add_toolbar_back_arrow;
    private ImageView todo_add_toolbar_save;

    private EditText todo_add_title_edit_text;
    private EditText todo_add_end_date_edit_text;
    private EditText todo_add_content_edit_text;

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        dbHelper = new DbHelper(this);

        todo_add_title_edit_text = (EditText) findViewById(R.id.todo_add_title_edit_text);
        todo_add_end_date_edit_text = (EditText) findViewById(R.id.todo_add_end_date_edit_text);
        todo_add_content_edit_text = (EditText) findViewById(R.id.todo_add_content_edit_text);

        todo_add_toolbar_back_arrow = (ImageView) findViewById(R.id.todo_add_toolbar_back_arrow);
        todo_add_toolbar_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        todo_add_toolbar_save = (ImageView) findViewById(R.id.todo_add_toolbar_save);
        todo_add_toolbar_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmDialog();
            }
        });

    }

    private void showConfirmDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(TodoActivity.this);
        alertDialog.setTitle("저장");
        alertDialog.setMessage("내 할일을 저장할까요?");

        alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                String title = todo_add_title_edit_text.getText().toString();
                String date = todo_add_end_date_edit_text.getText().toString();
                String memo = todo_add_content_edit_text.getText().toString();

                boolean isInserted = dbHelper.insertNewTask(title, date, memo);
                if(isInserted) {
                    Toast.makeText(TodoActivity.this, "Success!!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(TodoActivity.this, "Failed!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

}
