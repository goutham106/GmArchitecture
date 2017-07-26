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
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.gm.common.R;

import java.util.Random;

/**
 * Name       : Gowtham
 * Created on : 25/7/17.
 * Email      : goutham.gm11@gmail.com
 */

public class CircleTextImageBadgeView extends FrameLayout {
    private CircleTextImageView mProfileView;
    private CircleTextImageView mOnlineView;
    private Context context;

    private int[] mMaterialColors;
    private static final Random RANDOM = new Random();


    public CircleTextImageBadgeView(Context context) {
        super(context);
    }

    public CircleTextImageBadgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            initView(context, attrs);
    }

    public CircleTextImageBadgeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        this.context = context;
        mMaterialColors = context.getResources().getIntArray(R.array.colors);
        LayoutInflater.from(context).inflate(R.layout.circle_imageview_badge, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mProfileView = (CircleTextImageView) findViewById(R.id.profile_image);
        mOnlineView = (CircleTextImageView) findViewById(R.id.online_view);

    }

    public CircleTextImageView getProfileView() {
        return mProfileView;
    }

    public CircleTextImageView getOnlineView() {
        return mOnlineView;
    }

    public void setAvatarResource(int resource) {
//        mProfileView.setImageResource(resource);
        setViews(true, resource, "");
    }

    public void setAvatarResource(String avatarText) {
        setViews(false, 0, avatarText);
    }

    public void setOnline(boolean online) {
        mOnlineView.setBorderWidth(2);
        mOnlineView.setBorderColor(context.getResources().getColor(R.color.white));
        mOnlineView.setOval(true);

        if (online) {
//            mOnlineView.setImageResource(R.color.online_color);
            mOnlineView.setShapeColor(context.getResources().getColor(R.color.online_color));
            mOnlineView.setText("1");
            mOnlineView.setLetterCount(0);
            mOnlineView.setTextSize(0);
        } else {
//            mOnlineView.setImageResource(R.color.offline_color);
            mOnlineView.setShapeColor(context.getResources().getColor(R.color.offline_color));
            mOnlineView.setText("0");
            mOnlineView.setLetterCount(0);
            mOnlineView.setTextSize(0);
        }
    }

    private void setViews(boolean isImage, int mImageResource, String text) {
//        mProfileView.setBorderWidth(2);
//        mProfileView.setBorderColor(context.getResources().getColor(R.color.black));

        if (isImage) {
            mProfileView.setOval(true);
            mProfileView.setScaleType(ImageView.ScaleType.FIT_XY);
            mProfileView.setImageResource(mImageResource);
        } else {
            mProfileView.setOval(true);
            mProfileView.setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);
            mProfileView.setText(text);
            mProfileView.setLetterCount(2);
            mProfileView.setTextSize(18);
        }
    }

}

