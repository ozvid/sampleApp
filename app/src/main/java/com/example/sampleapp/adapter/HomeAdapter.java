/**
 *@copyright : OZVID Technologies Pvt. Ltd. < www.ozvid.com >
 *@author	 : Shiv Charan Panjeta < shiv@ozvid.com >
 */

package com.example.sampleapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.sampleapp.R;
import com.example.sampleapp.databinding.AdapterHomeBinding;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private ArrayList<String> adapterList;

    public HomeAdapter(ArrayList<String> arrayList) {
        this.adapterList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        AdapterHomeBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.adapter_home, viewGroup
                , false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.homeBinding.titleTV.setText(adapterList.get(position));
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterHomeBinding homeBinding;

        MyViewHolder(@NonNull AdapterHomeBinding itemView) {
            super(itemView.getRoot());
            this.homeBinding = itemView;
        }
    }
}
