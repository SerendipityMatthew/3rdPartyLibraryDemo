package com.xuwanjin.viewpagerdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SlidePageFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = "SlidePageFragment";
    View slidePageView;
    ImageButton slideToNext;
    ImageButton slideToPrevious;
    TextView pageContent;
    private String mContent;
    private int mPageCount;
    private int mCurrentIndex;

    public SlidePageFragment(String content, int position, int pageCount) {
        mContent = content;
        mCurrentIndex = position;
        mPageCount = pageCount;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        slidePageView = inflater.inflate(R.layout.fragment_slide_page, container, false);
        return slidePageView;
    }


    @Override
    public void onStart() {
        super.onStart();
        slideToNext = slidePageView.findViewById(R.id.slide_to_next);
        slideToPrevious = slidePageView.findViewById(R.id.slide_to_previous);
        slideToNext.setOnClickListener(this);
        slideToPrevious.setOnClickListener(this);
        pageContent = slidePageView.findViewById(R.id.page_content);
        pageContent.setText(mContent);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        updateSlideUI();
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: mCurrentIndex = " + mCurrentIndex);
        int vId = v.getId();
        if (vId == R.id.slide_to_next) {
            ++mCurrentIndex;
            updateSlideUI();
            Log.d(TAG, "Matthew: onClick: slide_to_next: mCurrentIndex next page= " + mCurrentIndex);
//            ((MainActivity)getActivity()).viewPager.getAdapter().notifyDataSetChanged();
            ((MainActivity)getActivity()).viewPager.setCurrentItem(mCurrentIndex);
        } else if (vId == R.id.slide_to_previous) {
            --mCurrentIndex;
            updateSlideUI();
//            ((MainActivity)getActivity()).viewPager.getAdapter().notifyDataSetChanged();
            Log.d(TAG, "onClick: slide_to_previous: mCurrentIndex next page= " + mCurrentIndex);
            ((MainActivity)getActivity()).viewPager.setCurrentItem(mCurrentIndex);
        }
    }
    public void updateSlideUI() {
        int count = mPageCount - 1;
        Log.d(TAG, "updateSlideUI: count = " + count);

        // 非第一页和非最后一页, 显示左右滑动箭头
        if (mCurrentIndex > 0) {
            if (mCurrentIndex < count) {
                slideToPrevious.setVisibility(View.VISIBLE);
                slideToNext.setVisibility(View.VISIBLE);
            }
            // 不是第一页, 但是最后一页
            else if (mCurrentIndex == count) {
                slideToPrevious.setVisibility(View.VISIBLE);
                slideToNext.setVisibility(View.GONE);
            }
            return;
        }
        // 第一页, 也是最后一页, 两个箭头都不显示
        if (mCurrentIndex == 0) {
            if (mCurrentIndex == count) {
                slideToPrevious.setVisibility(View.GONE);
                slideToNext.setVisibility(View.GONE);
            }
            // 是第一页, 但是不是最后一页
            else if (mCurrentIndex < count) {
                slideToPrevious.setVisibility(View.GONE);
                slideToNext.setVisibility(View.VISIBLE);

            }
        }
    }
}
