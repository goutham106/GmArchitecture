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

package com.gm.util.rx;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


/**
 * Name       : Gowtham
 * Created on : 21/3/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

public abstract class WebFailAction implements Consumer<Throwable> {

    @Override
    public void accept(@NonNull Throwable throwable) throws Exception {
        String errorMsg = "";
        if (throwable instanceof IOException) {
            errorMsg = "Please check your network status";
        } else if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            errorMsg = httpException.response().message();
        } else {
            errorMsg = "unKnown error";
        }
        onFailure(throwable, errorMsg);
    }

    abstract void onFailure(Throwable throwable, String errorMsg);


}
