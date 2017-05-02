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

package com.gm.ui.loginbase;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.gm.R;
import com.gm.ui.base.BaseActivity;
import com.gm.ui.login.LoginFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name       : Gowtham
 * Created on : 20/4/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

public class LoginBaseBaseActivity extends BaseActivity implements LoginBaseMvpView {

    private static final String TAG = "LoginBaseBaseActivity";

    @Inject
    LoginBaseMvpPresenter<LoginBaseMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LoginBaseBaseActivity.class);
    }

    @Override
    protected void setUp() {
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginBaseBaseActivity.this);

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(LoginFragment.TAG);
        if (fragment == null) {
            super.onBackPressed();
        } else {
            onFragmentDetached(LoginFragment.TAG);
        }
    }

    @Override
    public void showLoginFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
               // .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.container, LoginFragment.newInstance(), LoginFragment.TAG)
                .commit();
    }

    @Override
    public void onFragmentAttached() {
//        if (mDrawer != null)
//            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
//                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
//            if (mDrawer != null)
//                mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            finish();
        }

    }
}
