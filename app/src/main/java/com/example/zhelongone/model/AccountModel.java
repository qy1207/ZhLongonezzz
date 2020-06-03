package com.example.zhelongone.model;

import android.content.Context;

import com.example.fraem.ApiConfig;
import com.example.fraem.FrameApplication;
import com.example.fraem.ICommonModel;
import com.example.fraem.ICommonPresenter;
import com.example.fraem.NetManger;
import com.example.fraem.utils.ParamHashMap;
import com.example.zhelongone.R;
import com.example.zhelongone.base.Application1907;

/**
 * 作者：Leishen  秦宇
 * 创建于： 2020/6/3 09:09
 * 作者邮箱：1623060075@qq.com
 */

public class AccountModel implements ICommonModel {
   private NetManger mManger=NetManger.getInstance();
    private Context mContext = Application1907.get07ApplicationContext();

    @Override
    public void getData(ICommonPresenter pPresenter, int whichApi, Object[] params) {
        switch (whichApi) {
            case ApiConfig.SEND_VERIFY:
                mManger.netWork(mManger.getService(mContext.getString(R.string.passport_openapi_user))
                        .getLoginVerify((String) params[0]), pPresenter, whichApi);
                break;
            case ApiConfig.VERIFY_LOGIN:
                mManger.netWork(mManger.getService(mContext.getString(R.string.passport_openapi_user))
                        .loginByVerify(new ParamHashMap().add("mobile",params[0])
                                .add("code",params[1])),pPresenter,whichApi);
                break;
            case ApiConfig.GET_HEADER_INFO:
                String uid = FrameApplication.getFrameApplication().getLoginInfo().getUid();
                mManger.netWork(mManger.getService(mContext.getString(R.string.passport_api)).getHeaderInfo(new ParamHashMap().add("zuid",uid).add("uid",uid)),pPresenter,whichApi);
                break;
        }
    }
}
