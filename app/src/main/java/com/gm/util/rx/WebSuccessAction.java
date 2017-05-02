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


import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


/**
 * Name       : Gowtham
 * Created on : 21/3/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

public abstract class WebSuccessAction<T extends JsonDataResponse> implements Consumer<T> {

    @Override
    public void accept(@NonNull T response) throws Exception {
        int sc = response.getStatuscode();
        if (sc != 200) {
            throw new ResponseCodeError(response.getMsg());
        }
        onSuccess(response);
    }

    abstract void onSuccess(T response);
}

