package com.example.anti2110.wantedjobshare.notice;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anti2110.wantedjobshare.model.Notice;
import com.example.anti2110.wantedjobshare.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeNoticeFragment extends Fragment {

    private static final String TAG = "HomeNoticeFragment";

    private RecyclerView recyclerView;
    private HomeNoticeRecyclerAdapter adapter;

    private List<Notice> noticeList;

    public HomeNoticeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_notice, container, false);

        noticeList = new ArrayList<>();

        for(int i=1; i<101; i++) {
            Notice notice = new Notice();
            notice.setTitle("인프라를 관리할 필요 없이 빠르게 앱 개발-"+i);
            notice.setContent("Firebase 제품은 스스로 원활하게 작동하면서 데이터와 통계를 공유하며, 통합 대시보드에서 액세스할 수 있습니다.-"+i);
            noticeList.add(notice);
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.home_notice_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HomeNoticeRecyclerAdapter(noticeList, getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }
}
