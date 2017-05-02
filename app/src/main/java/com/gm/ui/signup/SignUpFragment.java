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

package com.gm.ui.signup;

import android.os.Bundle;
import android.view.View;

import com.gm.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Name       : Gowtham
 * Created on : 21/4/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

public class SignUpFragment extends BaseFragment implements SignUpMvpView {

    @Inject
    SignUpMvpPresenter<SignUpMvpView> mPresenter;

    public static SignUpFragment newInstance() {
        Bundle args = new Bundle();
        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    protected void setUp(View view) {

    }
}
