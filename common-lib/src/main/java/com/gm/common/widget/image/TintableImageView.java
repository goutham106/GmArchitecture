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

package com.gm.common.widget.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.gm.common.R;

/**
 * Name       : Gowtham
 * Created on : 24/7/17.
 * Email      : goutham.gm11@gmail.com
 */

public class TintableImageView extends AppCompatImageView {
    private ColorStateList mTint, mBackgroundTint;

    public TintableImageView(Context context) {
        super(context);
    }

    public TintableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            initWithAttrs(context, attrs, 0);
    }

    public TintableImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            initWithAttrs(context, attrs, defStyle);
    }

    private void initWithAttrs(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TintableImageView, defStyleAttr, 0);
        mTint = a.getColorStateList(R.styleable.TintableImageView_tint);
        mBackgroundTint = a.getColorStateList(R.styleable.TintableImageView_background_tint);
        a.recycle();
    }

        @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mTint != null) {
            if (mTint.isStateful())
                setColorFilter(mTint.getColorForState(getDrawableState(), 0));
            else setColorFilter(mTint);
        }
        Drawable drawable = getBackground();
        if (mBackgroundTint != null && drawable != null) {
            Drawable wrap = DrawableCompat.wrap(drawable);
            wrap = wrap.mutate();

            if (mBackgroundTint.isStateful())
                DrawableCompat.setTint(wrap, ContextCompat.getColor(getContext(), mBackgroundTint.getColorForState(getDrawableState(), 0)));
            else DrawableCompat.setTintList(wrap, mBackgroundTint);

            DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_IN);
        }
    }

    public void removeTint() {
        mTint = null;
        clearColorFilter();
    }

    public void setColorFilter(ColorStateList tint) {
        this.mTint = tint;
        setColorFilter(tint.getColorForState(getDrawableState(), 0));
    }
}