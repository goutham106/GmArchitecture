/*
 * Copyright (c) 2017 Gowtham Parimelazhagan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gm.ui.login;

import android.os.Bundle;
import android.view.View;

import com.gm.R;
import com.gm.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginFragment extends BaseFragment implements LoginMvpView {

    public static final String TAG = "LoginFragment";

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_login;
    }

    @Override
    protected void setUp(View view) {

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void showRegistrationFragment() {

    }

    @Override
    public void showForgetPasswordFragment() {

    }
}
