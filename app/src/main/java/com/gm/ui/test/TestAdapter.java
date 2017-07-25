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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gm.R;
import com.gm.common.widget.image.CircleTextImageBadgeView;

import java.util.List;
import java.util.Random;

/**
 * Name       : Gowtham
 * Created on : 25/7/17.
 * Email      : goutham.gm11@gmail.com
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<String> mValues;
    private int[] mMaterialColors;
    private int[] mImageResource;
    private static final Random RANDOM = new Random();
    private Context context;


    public TestAdapter(Context context, List<String> items) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mMaterialColors = context.getResources().getIntArray(R.array.colors);
//        mImageResource = new int[]{R.drawable.ruth, R.mipmap.ic_launcher};
        mImageResource = new int[]{R.color.color_1, R.color.color_2,R.color.color_3,R.color.color_4,R.color.color_5};

        mBackground = mTypedValue.resourceId;
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_test1, parent, false);
//        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

//                holder.mIcon.setTextSize(18);
//                holder.mIcon.setOval(false);
//                holder.mIcon.setTextColor(Color.WHITE);
//                holder.mIcon.setBorderColor(Color.BLACK);
//                holder.mIcon.setBorderWidth(1);
//                holder.mIcon.setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);
//                holder.mIcon.setText(mValues.get(position));

//        holder.mIcon.setLetterCount(3);
//        holder.mIcon.setTextSize(16);
//        holder.mIcon.setBorderWidth(0);
//        holder.mIcon.setOval(true);
//        holder.mIcon.setText(mValues.get(position));
//        holder.mIcon.setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);

//                holder.mIcon.setBorderWidth(0);
//                if (position % 2 == 0) {
//                    holder.mIcon.setOval(true);
//                    holder.mIcon.setScaleType(ImageView.ScaleType.FIT_XY);
//                    holder.mIcon.setImageResource(mImageResource[RANDOM.nextInt(mImageResource.length)]);
//                } else {
//                    holder.mIcon.setOval(true);
//                    holder.mIcon.setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);
//                    holder.mIcon.setText(mValues.get(position));
//                    holder.mIcon.setLetterCount(2);
//                    holder.mIcon.setTextSize(18);
//                }

        if (position % 2 == 0) {
            holder.mIcon.getProfileView().setOval(true);
            holder.mIcon.getOnlineView().setOval(true);
            holder.mIcon.setAvatarResource(mImageResource[RANDOM.nextInt(mImageResource.length)]);
            holder.mIcon.setOnline(true);
        } else {
            holder.mIcon.getProfileView().setOval(true);
            holder.mIcon.getOnlineView().setOval(true);
//            holder.mIcon.getProfileView().setText("");
            holder.mIcon.getProfileView().setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);
            holder.mIcon.getProfileView().setText(mValues.get(position));
            holder.mIcon.getProfileView().setLetterCount(2);
            holder.mIcon.getProfileView().setTextSize(18);
//            holder.mIcon.setAvatarResource(mImageResource[RANDOM.nextInt(mMaterialColors.length)]);
            holder.mIcon.setOnline(false);
            holder.mIcon.getOnlineView().setText("");
            holder.mIcon.getOnlineView().setShapeColor(context.getResources().getColor(R.color.offline_color));
            holder.mIcon.getOnlineView().setLetterCount(2);
            holder.mIcon.getOnlineView().setTextSize(18);
        }


        holder.mBoundString = mValues.get(position);
        holder.mTextView.setText(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
//        final CircleTextImageView mIcon;
        final CircleTextImageBadgeView mIcon;
        final TextView mTextView;
        String mBoundString;

        ViewHolder(View view) {
            super(view);
            mView = view;
            //mIcon = (CircleTextImageView) view.findViewById(R.id.circleTextImageView);
            mIcon = (CircleTextImageBadgeView) view.findViewById(R.id.circleTextBadgeImageView);
            mTextView = (TextView) view.findViewById(android.R.id.text1);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextView.getText();
        }
    }
}