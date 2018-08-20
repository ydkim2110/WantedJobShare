package com.example.anti2110.wantedjobshare.notice;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anti2110.wantedjobshare.R;
import com.example.anti2110.wantedjobshare.utils.SectionPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomHomeFragment extends Fragment {


    public BottomHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_bottom_home, container, false);

        setupViewPager(view);


        return view;
    }

    private void setupViewPager(View view) {
        SectionPagerAdapter pagerAdapter = new SectionPagerAdapter(getChildFragmentManager());

        pagerAdapter.addFragment(new HomeNoticeFragment());
        pagerAdapter.addFragment(new HomeBookmarkFragment());
        pagerAdapter.addFragment(new HomeBookmarkFragment());
        pagerAdapter.addFragment(new HomeBookmarkFragment());
        pagerAdapter.addFragment(new HomeBookmarkFragment());
        pagerAdapter.addFragment(new HomeBookmarkFragment());
        pagerAdapter.addFragment(new HomeBookmarkFragment());
        pagerAdapter.addFragment(new HomeBookmarkFragment());
        pagerAdapter.addFragment(new HomeBookmarkFragment());

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.notice_view_pager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout =(TabLayout) view.findViewById(R.id.notice_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("전체 공고");
        tabLayout.getTabAt(1).setText("은행 채용");
        tabLayout.getTabAt(2).setText("증권사 채용");
        tabLayout.getTabAt(3).setText("보험사 채용");
        tabLayout.getTabAt(4).setText("자산운용사 채용");
        tabLayout.getTabAt(5).setText("캐피탈 채용");
        tabLayout.getTabAt(6).setText("저축은행 채용");
        tabLayout.getTabAt(7).setText("카드사 채용");
        tabLayout.getTabAt(8).setText("기타 채용");

    }

}
