package com.example.zhelongone.avtivity;

import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.data.BaseInfo;
import com.example.data.SpecialtyChooseEntity;
import com.example.fraem.ApiConfig;
import com.example.zhelongone.R;
import com.example.zhelongone.adapter.SubjectAdapter;
import com.example.zhelongone.base.BaseMvpActivity;

import com.example.zhelongone.model.LauchModel;
import com.teach.frame.constants.ConstantKey;

import com.yiyatech.utils.newAdd.SharedPrefrenceUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SubjectActivity extends BaseMvpActivity<LauchModel> {

    private List<SpecialtyChooseEntity> mListData = new ArrayList<>();
    @BindView(R.id.title_content)
    TextView titleContent;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private SubjectAdapter mAdapter;

    @Override
    public LauchModel setModel() {
        return new LauchModel();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_subject;
    }

    @Override
    public void setUpView() {
        titleContent.setText(getString(R.string.select_subject));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SubjectAdapter(mListData,this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setUpData() {
     List<SpecialtyChooseEntity> info= SharedPrefrenceUtils.getSerializableList(this, ConstantKey.SUBJECT_LIST);
        if ( info!= null) {
            mListData.addAll(info);
            mAdapter.notifyDataSetChanged();
        } else
            mPresenter.getData(ApiConfig.SUBJECT);
    }

    @Override
    public void netSuccess(int whichApi, Object[] pD) {
        switch (whichApi) {
            case ApiConfig.SUBJECT:
                BaseInfo<List<SpecialtyChooseEntity>> info = (BaseInfo<List<SpecialtyChooseEntity>>) pD[0];
                mListData.addAll(info.result);
                mAdapter.notifyDataSetChanged();
                SharedPrefrenceUtils.putSerializableList(this, ConstantKey.SUBJECT_LIST,mListData);
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPrefrenceUtils.putObject(this, ConstantKey.SUBJECT_SELECT,mApplication.getSelectedInfo());
    }

    @OnClick(R.id.back_image)
    public void onViewClicked() {
        finish();
    }
}
