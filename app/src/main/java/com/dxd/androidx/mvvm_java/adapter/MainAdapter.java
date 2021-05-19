package com.dxd.androidx.mvvm_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dxd.androidx.mvvm_java.R;
import com.dxd.androidx.mvvm_java.bean.MpBean;
import com.dxd.androidx.mvvm_java.databinding.AdapterMainItemBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : gavin_du
 * date : 2021/5/19 11:11
 * description :
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MpBean> list = new ArrayList<>();

    private LayoutInflater inflater;

    public MainAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterMainItemBinding adapterMainItemBinding =
                DataBindingUtil.inflate(inflater, R.layout.adapter_main_item, parent, false);
        return new ViewHolder(adapterMainItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MpBean bean = list.get(position);
        if (bean != null){
            holder.binding.setMp(bean);
        }
        holder.binding.tvName.setText("Name: ");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private AdapterMainItemBinding binding;
        public ViewHolder(@NonNull AdapterMainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setList(List<MpBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
