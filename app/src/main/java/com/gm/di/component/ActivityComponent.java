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

package com.gm.di.component;

import com.gm.di.PerActivity;
import com.gm.di.module.ActivityModule;
import com.gm.ui.login.LoginFragment;
import com.gm.ui.loginbase.LoginBaseBaseActivity;
import com.gm.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Name       : Gowtham
 * Created on : 21/4/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginBaseBaseActivity activity);

    void inject(SplashActivity activity);

    void inject(LoginFragment activity);
}
