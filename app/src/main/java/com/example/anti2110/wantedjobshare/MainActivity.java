package com.example.anti2110.wantedjobshare;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.anti2110.wantedjobshare.more.BottomMoreFragment;
import com.example.anti2110.wantedjobshare.notice.BottomHomeFragment;
import com.example.anti2110.wantedjobshare.post.BottomPostFragment;
import com.example.anti2110.wantedjobshare.search.BottomSearchFragment;
import com.example.anti2110.wantedjobshare.todo.BottomTodoFragment;
import com.example.anti2110.wantedjobshare.utils.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private BottomHomeFragment homeFragment;
    private BottomSearchFragment searchFragment;
    private BottomPostFragment postFragment;
    private BottomTodoFragment todoFragment;
    private BottomMoreFragment moreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.container);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        homeFragment = new BottomHomeFragment();
        searchFragment = new BottomSearchFragment();
        postFragment = new BottomPostFragment();
        todoFragment = new BottomTodoFragment();
        moreFragment = new BottomMoreFragment();

        setFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        setFragment(homeFragment);
                        return true;
                    case R.id.bottom_search:
                        setFragment(searchFragment);
                        return true;
                    case R.id.bottom_post:
                        setFragment(postFragment);
                        return true;
                    case R.id.bottom_todo:
                        setFragment(todoFragment);
                        return true;
                    case R.id.bottom_more:
                        setFragment(moreFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
