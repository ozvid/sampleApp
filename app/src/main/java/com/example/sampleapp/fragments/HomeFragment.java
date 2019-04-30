/**
 *@copyright : OZVID Technologies Pvt. Ltd. < www.ozvid.com >
 *@author	 : Shiv Charan Panjeta < shiv@ozvid.com >
 */

package com.example.sampleapp.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleapp.R;
import com.example.sampleapp.adapter.HomeAdapter;
import com.example.sampleapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null)
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    private void initUI() {
        binding.listRV.setLayoutManager(new LinearLayoutManager(getContext()));

        setDataInArrayList();
    }

    private void setDataInArrayList() {
        for (int i = 0; i < 5; i++) {
            arrayList.add("Version:-" + i + 1);
        }
        setAdapter();

    }

    private void setAdapter() {
        HomeAdapter homeAdapter = new HomeAdapter(arrayList);
        binding.listRV.setAdapter(homeAdapter);
    }
}
