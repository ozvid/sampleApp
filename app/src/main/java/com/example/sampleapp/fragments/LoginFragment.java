/**
 * @copyright : OZVID Technologies Pvt. Ltd. < www.ozvid.com >
 * @author : Shiv Charan Panjeta < shiv@ozvid.com >
 */

package com.example.sampleapp.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleapp.R;
import com.example.sampleapp.activity.MainActivity;
import com.example.sampleapp.databinding.FragmentLoginBinding;

import java.util.Objects;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null)
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    private void initUI() {
        binding.loginBT.setOnClickListener(this);
        binding.forPasswordTV.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBT:
                gotoMainActivity();
                break;

            case R.id.forPasswordTV:
                gotoForgotPasswordFragment();
                break;

        }
    }

    private void gotoForgotPasswordFragment() {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameFL, new ForgotPasswordFragment())
                .addToBackStack(null)
                .commit();
    }


    private void gotoMainActivity() {
        startActivity(new Intent(getContext(), MainActivity.class));
        Objects.requireNonNull(getActivity()).finish();
    }


}
