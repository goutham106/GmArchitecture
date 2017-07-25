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

package com.gm.ui.test;

import com.gm.di.PerActivity;
import com.gm.ui.base.MvpPresenter;

import java.util.List;

/**
 * Name       : Gowtham
 * Created on : 25/7/17.
 * Email      : goutham.gm11@gmail.com
 */

@PerActivity
public interface TestMvpPresenter<V extends TestMvpView> extends MvpPresenter<V>  {

    void loadData();
}