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

package com.gm.di.module;

import android.app.Activity;
import android.content.Context;

import com.gm.di.ActivityContext;
import com.gm.di.PerActivity;
import com.gm.ui.login.LoginMvpPresenter;
import com.gm.ui.login.LoginMvpView;
import com.gm.ui.login.LoginPresenter;
import com.gm.ui.loginbase.LoginBaseMvpPresenter;
import com.gm.ui.loginbase.LoginBaseMvpView;
import com.gm.ui.loginbase.LoginBasePresenter;
import com.gm.ui.signup.SignUpMvpPresenter;
import com.gm.ui.signup.SignUpMvpView;
import com.gm.ui.signup.SignUpPresenter;
import com.gm.ui.splash.SplashMvpPresenter;
import com.gm.ui.splash.SplashMvpView;
import com.gm.ui.splash.SplashPresenter;
import com.gm.ui.test.TestMvpPresenter;
import com.gm.ui.test.TestMvpView;
import com.gm.ui.test.TestPresenter;
import com.gm.ui.test.detail.TestDetailMvpPresenter;
import com.gm.ui.test.detail.TestDetailMvpView;
import com.gm.ui.test.detail.TestDetailPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Name       : Gowtham
 * Created on : 21/4/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginBaseMvpPresenter<LoginBaseMvpView> provideLoginBasePresenter(LoginBasePresenter<LoginBaseMvpView> presenter) {
        return presenter;
    }

    @Provides
    SignUpMvpPresenter<SignUpMvpView> provideRegistrationPresenter(SignUpPresenter<SignUpMvpView> presenter) {
        return presenter;
    }

    @Provides
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TestMvpPresenter<TestMvpView> provideTestPresenter(TestPresenter<TestMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TestDetailMvpPresenter<TestDetailMvpView> provideTestDetailPresenter(TestDetailPresenter<TestDetailMvpView> presenter) {
        return presenter;
    }

}
