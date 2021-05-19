package com.dxd.androidx.mvvm_java.model;

import com.dxd.androidx.mvvm_java.base.BaseData;
import com.dxd.androidx.mvvm_java.bean.MpBean;
import com.dxd.androidx.mvvm_java.http.HttpConfig;
import com.dxd.androidx.mvvm_java.http.MpSerivce;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : gavin_du
 * date : 2021/5/19 10:48
 * description :
 */
public class MainModel {

    private MainModel() {

    }

    public static MainModel getInstance() {
        return Instance.mainModel;
    }

    private static class Instance {
        private static final MainModel mainModel = new MainModel();
    }

    private Retrofit retrofit = new Retrofit.Builder().baseUrl(HttpConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();



    public void subscribe(Observer<BaseData<List<MpBean>>> observer){
        retrofit.create(MpSerivce.class).getListData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer);
    }

}
