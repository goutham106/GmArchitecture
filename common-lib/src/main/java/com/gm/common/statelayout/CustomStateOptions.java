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

package com.gm.common.statelayout;

import android.support.annotation.DrawableRes;
import android.view.View;

import java.io.Serializable;

/**
 * Name       : Gowtham
 * Created on : 23/3/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

public class CustomStateOptions implements Serializable {

    @DrawableRes
    private int imageRes;
    private boolean isLoading;
    private String message;
    private String buttonText;
    private View.OnClickListener buttonClickListener;

    public CustomStateOptions image(@DrawableRes int val) {
        imageRes = val;
        return this;
    }

    public CustomStateOptions loading() {
        isLoading = true;
        return this;
    }

    public CustomStateOptions message(String val) {
        message = val;
        return this;
    }

    public CustomStateOptions buttonText(String val) {
        buttonText = val;
        return this;
    }

    public CustomStateOptions buttonClickListener(View.OnClickListener val) {
        buttonClickListener = val;
        return this;
    }

    public int getImageRes() {
        return imageRes;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public String getMessage() {
        return message;
    }

    public String getButtonText() {
        return buttonText;
    }

    public View.OnClickListener getClickListener() {
        return buttonClickListener;
    }

}

