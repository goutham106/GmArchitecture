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

package com.gm;

import android.app.Application;

import com.gm.data.DataManager;
import com.gm.di.component.ApplicationComponent;
import com.gm.di.component.DaggerApplicationComponent;
import com.gm.di.module.ApplicationModule;

import javax.inject.Inject;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Name       : Gowtham
 * Created on : 20/4/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

public class GmApp extends Application {
    private static final String TAG = "GmApp";

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        CustomActivityOnCrash.install(this);

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);


    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }


}
