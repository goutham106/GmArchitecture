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

package com.gm.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

import com.gm.common.R;

/**
 * Name       : Gowtham
 * Created on : 9/3/17.
 * Email      : goutham.gm11@gmail.com
 * GitHub     : https://github.com/goutham106
 */

public class GmTextView extends TextView {
    public GmTextView(Context context) {
        super(context);
    }

    public GmTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            initWithAttrs(context, attrs, 0, 0);
    }

    public GmTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            initWithAttrs(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GmTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode())
            initWithAttrs(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initWithAttrs(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.GmTextView, defStyleAttr, defStyleRes);
        int customFontIndex = a.getInt(R.styleable.GmTextView_setFont, -1);
        if (customFontIndex != -1) {
            String fontPath = getResources().getStringArray(R.array.FontNames)[customFontIndex];
            setCustomFont(fontPath);
        }
        a.recycle();
    }

    /**
     * Loads a font from the given asset path
     *
     * @param customFontPath path in the assets folder to the font file
     */
    private void setCustomFont(@NonNull String customFontPath) {
        if (isInEditMode() && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1) {
            //in the Android Studio stf_template preview, with SDK < 22, this throws an exception.  You'll
            // only see your custom font in the preview if you have the SDK set to 22 or above.
            return;
        }
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + customFontPath);
        setTypeface(typeface);
    }

}

