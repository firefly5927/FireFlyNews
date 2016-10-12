package com.zjk.fireflynews.module.news.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zjk.fireflynews.base.BaseRecyclerViewAdapter;
import com.zjk.fireflynews.data.NewsData;
import com.zjk.fireflynews.data.NewsListData;
import com.zjk.fireflynews.module.adapter.NewsListAdapter;
import com.zjk.fireflynews.module.base.ui.BaseListFragment;
import com.zjk.fireflynews.module.news.presenter.NewsDetailPresenter;
import com.zjk.fireflynews.module.news.presenter.NewsDetailPresenterImpl;
import com.zjk.fireflynews.module.news.view.NewsDetailView;

import java.util.ArrayList;

/**
 * Created by FireFly on 2016/9/8.
 */
public class NewsDetailFragment extends BaseListFragment<NewsDetailPresenter,NewsListData> implements NewsDetailView/*SwipeRefreshLayout.OnRefreshListener*/ {

    private static String EXTRA_KEY_NEWS_DETAIL = "extra_key_news_detail";
    private NewsData newsData;
//    private NewsListAdapter adapter;

    public static NewsDetailFragment getInstance(NewsData newsData) {
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_KEY_NEWS_DETAIL, newsData);
        newsDetailFragment.setArguments(bundle);
        return newsDetailFragment;
    }

    @Override
    protected void getArgs() {
        Bundle bundle = getArguments();
        newsData = bundle.getParcelable(EXTRA_KEY_NEWS_DETAIL);
    }

    /*@Override
    protected View onCreateViewInit(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new NewsDetailPresenterImpl(this, newsData);
        mPresenter.refreshData();
        return view;
    }*/

    @Override
    public void initView(View view) {
        mPresenter = new NewsDetailPresenterImpl(this, newsData);
        mPresenter.onRefreshData();
    }

    @Override
    public BaseRecyclerViewAdapter<NewsListData> getAdapter() {
        return new NewsListAdapter(getActivity(), null);
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }
/*
    @Override
    public void updateRecycleView(List<NewsListData> newsListDataList, String msg, @InitDataType.InitDataTypeChecker int type) {
        mSwipeRefreshLayout.setRefreshing(false);
        if (null == adapter) {
            initNewsList(new ArrayList<NewsListData>());
        }
        adapter.onShowEmptyView(false, msg);
        switch (type) {
            case InitDataType.TYPE_REFRESH_SUCCESS:
                adapter.update(newsListDataList);
                break;
            case InitDataType.TYPE_LOAD_MORE_SUCCESS:
//                    adapter.setShowFooter(false);
                adapter.onLoadMoreSuccess();
                adapter.addTail(newsListDataList);
                break;
            case InitDataType.TYPE_REFRESH_FAIL:
                if (adapter.getItemCount() == 0) {
                    //显示空布局
                    adapter.onShowEmptyView(true, msg);
                }
                break;
            case InitDataType.TYPE_LOAD_MORE_FAIL:
                adapter.onLoadMoreFail(msg);
                break;
        }

    }

    private void initNewsList(List<NewsListData> newsListDataList) {
        adapter = new NewsListAdapter(getActivity(), newsListDataList);

        adapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mPresenter.loadMoreData();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new BaseSpaceItemDecoration(MeasureUtil.dip2px(getActivity(), 4)));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(adapter);
    }
*/
}
