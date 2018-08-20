package com.example.anti2110.wantedjobshare.post;


import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.anti2110.wantedjobshare.notice.BankFragment;
import com.example.anti2110.wantedjobshare.R;
import com.example.anti2110.wantedjobshare.utils.SectionPagerAdapter;

import io.github.yavski.fabspeeddial.FabSpeedDial;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomPostFragment extends Fragment {

    private static final String TAG = "BottomPostFragment";

    public BottomPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_post, container, false);

        setupViewPager(view);

        FabSpeedDial fabSpeedDial = (FabSpeedDial) view.findViewById(R.id.fab_speed_dial);
        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                Toast.makeText(getActivity(), ""+menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });

        return view;
    }

    private void setupViewPager(View view) {
        SectionPagerAdapter pagerAdapter = new SectionPagerAdapter(getChildFragmentManager());

        pagerAdapter.addFragment(new PostTimelineFragment());
        pagerAdapter.addFragment(new BankFragment());

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.post_view_pager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.post_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("타임라인");
        tabLayout.getTabAt(1).setText("은행마당");

    }


}
