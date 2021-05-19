package com.dxd.androidx.mvvm_java.http;

import com.dxd.androidx.mvvm_java.base.BaseData;
import com.dxd.androidx.mvvm_java.bean.MpBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

/**
 * author : gavin_du
 * date : 2021/5/19 11:05
 * description :
 */
public interface MpSerivce {

    @GET("wxarticle/chapters/json")
    Observable<BaseData<List<MpBean>>> getListData();

}
