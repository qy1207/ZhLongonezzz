package com.example.zhelongone.avtivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.data.BaseInfo;
import com.example.data.LoginInfo;
import com.example.data.PersonHeader;
import com.example.fraem.ApiConfig;
import com.example.zhelongone.LoginView;
import com.example.zhelongone.R;
import com.example.zhelongone.base.BaseMvpActivity;
import com.example.zhelongone.model.AccountModel;
import com.teach.frame.constants.ConstantKey;
import com.yiyatech.utils.newAdd.SharedPrefrenceUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class LoginActivity extends BaseMvpActivity<AccountModel> implements LoginView.LoginViewCallBack {
    @BindView(R.id.login_view)
    LoginView mLonginView;
    @BindView(R.id.third_login_desc)
    TextView thirdLoginDesc;
    private Disposable subscribe;
    private String phoneNum;

    @Override
    public AccountModel setModel() {
        return new AccountModel();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void setUpView() {
        mLonginView.setmLoginViewCallBack(this);
    }

    @Override
    public void setUpData() {

    }

    @Override
    public void netSuccess(int whichApi, Object[] pD) {
        switch (whichApi) {
//            case ApiConfig.SEND_VERIFY:
//                BaseInfo<String> info = (BaseInfo<String>) pD[0];
//                showToast(info.result);
//                goTime();
//                break;
            case ApiConfig.SEND_VERIFY:
                BaseInfo<String> info = (BaseInfo<String>) pD[0];
              //  showToast(info.result);
                goTime();
                break;
                case ApiConfig.VERIFY_LOGIN:
                    BaseInfo<LoginInfo> baseInfo = (BaseInfo<LoginInfo>) pD[0];
                    LoginInfo loginInfo = baseInfo.result;
                    loginInfo.login_name=phoneNum;
                    mApplication.setLoginInfo(loginInfo);
                    mPresenter.getData(ApiConfig.GET_HEADER_INFO);
                    break;
            case ApiConfig.GET_HEADER_INFO:
                PersonHeader personHeader=((BaseInfo<PersonHeader>)pD[0]).result;
                mApplication.getLoginInfo().personHeader=personHeader;
                SharedPrefrenceUtils.putObject(this, ConstantKey.LOGIN_INFO,mApplication.getLoginInfo());
                jump();
                break;
        }
    }

    private void jump() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

    private long time = 60l;

    private void goTime() {
        //  mLonginView.getVerifyCode.setText(time+"s");
        subscribe = Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(goTime -> {
                    mLonginView.getVerifyCode.setText(time - goTime + "s");
                    if (time - goTime < 1) doPre();
                });
    }

    private void doPre() {
        if (subscribe != null && !subscribe.isDisposed()) subscribe.dispose();
        mLonginView.getVerifyCode.setText("获取验证码");
    }


    @OnClick({R.id.close_login, R.id.register_press, R.id.forgot_pwd, R.id.login_by_qq, R.id.login_by_wx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close_login:
                finish();
                break;
            case R.id.register_press:
                break;
            case R.id.forgot_pwd:
                break;
            case R.id.login_by_qq:
                break;
            case R.id.login_by_wx:
                break;
        }
    }

    @Override
    public void sendVerifyCode(String phoneNum) {
       this.phoneNum=phoneNum;
        mPresenter.getData(ApiConfig.SEND_VERIFY, phoneNum);
    }

    @Override
    public void loginPress(int type, String userName, String pwd) {
        doPre();
            if (mLonginView.mCurrentLoginType==mLonginView.VERIFY_TYPE){
                mPresenter.getData(ApiConfig.VERIFY_LOGIN,userName,pwd);
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        doPre();
    }
}
