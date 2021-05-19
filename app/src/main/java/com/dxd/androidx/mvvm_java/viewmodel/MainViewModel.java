package com.dxd.androidx.mvvm_java.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.dxd.androidx.mvvm_java.adapter.MainAdapter;
import com.dxd.androidx.mvvm_java.base.BaseData;
import com.dxd.androidx.mvvm_java.bean.MpBean;
import com.dxd.androidx.mvvm_java.model.MainModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.rxjava3.observers.DefaultObserver;

/**
 * author : gavin_du
 * date : 2021/5/19 10:46
 * description :
 */
public class MainViewModel extends AndroidViewModel {

    private MainModel mainModel = MainModel.getInstance();

    private Context mContext;

    public MainAdapter mainAdapter;

    private MutableLiveData<List<MpBean>> liveData = new MutableLiveData<>();

    public MutableLiveData<List<MpBean>> getLiveData() {
        return liveData;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        mContext = application;
        mainAdapter = new MainAdapter(mContext);
    }

    public void getMpData(){
        mainModel.subscribe(new DefaultObserver<BaseData<List<MpBean>>>() {
            @Override
            public void onNext(@io.reactivex.rxjava3.annotations.NonNull BaseData<List<MpBean>> listBaseData) {
                if (listBaseData.getErrorCode() == 0){
                    liveData.setValue(listBaseData.getData());
//                    mainAdapter.setList(listBaseData.getData());
                }
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                Log.d("gavin",e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
