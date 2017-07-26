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
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.gm.common.R;
import com.gm.common.widget.image.drawable.TextDrawable;

/**
 * Name       : Gowtham
 * Created on : 24/7/17.
 * Email      : goutham.gm11@gmail.com
 */

public class CircleTextImageView extends RoundedImageViewWithBorder {
    private TextDrawable.IShapeBuilder mBuilder;
    private String mText;
    private int mTextSize;
    private int mTextColor;
    private int mShapeColor;
    private int mLetterCount;
    private Typeface mTypeface;
    private boolean bold, uppercase;
    private boolean mOval;
    private Drawable mDrawable;

    public CircleTextImageView(Context context) {
        super(context);
    }

    public CircleTextImageView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        if (!isInEditMode())
            initWithAttrs(context, attrs, 0);
    }

    public CircleTextImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            initWithAttrs(context, attrs, defStyle);
    }

    private void initWithAttrs(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        mBuilder = TextDrawable.builder();
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.CircleTextImageView, defStyleAttr, 0);
        mLetterCount = attr.getInt(R.styleable.CircleTextImageView_text_number, 2);
        mTextSize = attr.getInt(R.styleable.CircleTextImageView_text_size, 26);
        mTextColor = attr.getColor(R.styleable.CircleTextImageView_text_color, Color.WHITE);
        mShapeColor = attr.getColor(R.styleable.CircleTextImageView_shape_color, Color.RED);
        bold = attr.getBoolean(R.styleable.CircleTextImageView_is_bold, false);
        uppercase = attr.getBoolean(R.styleable.CircleTextImageView_is_uppercase, false);

        computeText(attr.getString(R.styleable.CircleTextImageView_text));
        attr.recycle();
        updateDrawable();
    }

    private int toPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    private void updateDrawable() {
        if (TextUtils.isEmpty(mText)) {
            return;
        }
        TextDrawable.IConfigBuilder iConfigBuilder = mBuilder.beginConfig().withBorder(getBorderWidth()).textColor(mTextColor).borderColor(getBorderColor());
        if (mTypeface != null)
            iConfigBuilder.useFont(mTypeface);
        if (mTextSize > 0)
            iConfigBuilder.fontSize(toPx(mTextSize));
        if (mTextSize == 0)
            iConfigBuilder.fontSize(0);
        if (isBold())
            iConfigBuilder.bold();
        if (isUppercase())
            iConfigBuilder.toUpperCase();
        mBuilder = iConfigBuilder.endConfig();
        //FIXME : once we change CircleImageView to RoundedImageView we have to un comment the below if loop :)
        if (isOval())
            mDrawable = mBuilder.buildRound(mText, mShapeColor);
        else if (getCornerRadius() > 0)
            mDrawable = mBuilder.buildRoundRect(mText, mShapeColor, getCornerRadius() / 5);
        else mDrawable = mBuilder.buildRect(mText, mShapeColor);
        setImageDrawable(mDrawable);
    }

    private void computeText(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        String initials[] = text.split("\\s+");
        StringBuilder initialsPlain = new StringBuilder(mLetterCount);
        for (String initial : initials) {
            initialsPlain.append(initial.substring(0, 1));
        }
        mText = initialsPlain.toString();
        mText = mText.substring(0, mLetterCount > mText.length() ? mText.length() : mLetterCount);
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        computeText(text);
        updateDrawable();
    }

    public int getTextSize() {
        return mTextSize;
    }

    public void setTextSize(int textSize) {
        mTextSize = textSize;
        updateDrawable();
    }

    public void setTypeface(Typeface typeface) {
        mTypeface = typeface;
        updateDrawable();
    }

    public Typeface getTypeFace() {
        return mTypeface;
    }

    public int getShapeColor() {
        return mShapeColor;
    }

    public void setShapeColor(@ColorInt int color) {
        mShapeColor = color;
        updateDrawable();
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(@ColorInt int color) {
        mTextColor = color;
        updateDrawable();
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isUppercase() {
        return uppercase;
    }

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }

    public int getLetterCount() {
        return mLetterCount;
    }

    public void setLetterCount(int mLetterCount) {
        this.mLetterCount = mLetterCount;
    }

    public void setBorderColor(int color) {
        setBorderColors(ColorStateList.valueOf(color));
    }
}