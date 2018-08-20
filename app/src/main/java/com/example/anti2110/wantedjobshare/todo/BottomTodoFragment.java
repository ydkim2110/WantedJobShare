package com.example.anti2110.wantedjobshare.todo;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anti2110.wantedjobshare.R;
import com.example.anti2110.wantedjobshare.database.DbHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomTodoFragment extends Fragment {

    private static final String TAG = "BottomTodoFragment";
    private ImageView todo_toolbar_add;

    private List<Task> taskList;
    private DbHelper dbHelper;
    private RecyclerView recyclerView;
    private TodoRecyclerAdapter adapter;

    public BottomTodoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "onCreateView()", Toast.LENGTH_SHORT).show();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_todo, container, false);

        dbHelper = new DbHelper(getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.todo_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        loadTaskList();

        todo_toolbar_add = (ImageView) view.findViewById(R.id.todo_toolbar_add);
        todo_toolbar_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TodoActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void loadTaskList() {
        taskList = dbHelper.getTaskList();

        if(adapter == null) {
            adapter = new TodoRecyclerAdapter(getActivity(), taskList);
        } else {
            adapter.notifyDataSetChanged();
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle().equals("삭제")) {
            Toast.makeText(getActivity(), "삭제 클릭"+item.getItemId(), Toast.LENGTH_SHORT).show();
        } else if(item.getTitle().equals("수정")) {
            Toast.makeText(getActivity(), "수정 클릭"+item.getItemId(), Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }
}
