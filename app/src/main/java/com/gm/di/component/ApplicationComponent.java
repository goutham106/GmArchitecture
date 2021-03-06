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

import android.app.Application;
import android.content.Context;

import com.gm.GmApp;
import com.gm.data.DataManager;
import com.gm.di.ApplicationContext;
import com.gm.di.module.ApplicationModule;
import com.gm.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Name       : Gowtham
 * Created on : 21/4/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(GmApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
