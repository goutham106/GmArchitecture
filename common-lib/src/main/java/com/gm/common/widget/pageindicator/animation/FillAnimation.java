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

package com.gm.common.widget.pageindicator.animation;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.animation.DecelerateInterpolator;

public class FillAnimation extends ColorAnimation {

    private static final String ANIMATION_COLOR_REVERSE = "ANIMATION_COLOR_REVERSE";
    private static final String ANIMATION_COLOR = "ANIMATION_COLOR";

    private static final String ANIMATION_RADIUS_REVERSE = "ANIMATION_RADIUS_REVERSE";
    private static final String ANIMATION_RADIUS = "ANIMATION_RADIUS";

    private static final String ANIMATION_STROKE_REVERSE = "ANIMATION_STROKE_REVERSE";
    private static final String ANIMATION_STROKE = "ANIMATION_STROKE";

    public static final int DEFAULT_STROKE_DP = 1;
    private int radiusPx;
    private int strokePx;

    public FillAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        super(listener);
    }

    @NonNull
    @Override
    public ValueAnimator createAnimator() {
        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(AbsAnimation.DEFAULT_ANIMATION_TIME);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                onAnimateUpdated(animation);
            }
        });

        return animator;
    }

    @NonNull
    public FillAnimation with(int colorStartValue, int colorEndValue, int radiusValue, int strokeValue) {
        if (animator != null && hasChanges(colorStartValue, colorEndValue, radiusValue, strokeValue)) {

            startColor = colorStartValue;
            endColor = colorEndValue;
            radiusPx = radiusValue;
            strokePx = strokeValue;

            PropertyValuesHolder colorHolder = createColorPropertyHolder(false);
            PropertyValuesHolder reverseColorHolder = createColorPropertyHolder(true);

            PropertyValuesHolder radiusHolder = createRadiusPropertyHolder(false);
            PropertyValuesHolder radiusReverseHolder = createRadiusPropertyHolder(true);

            PropertyValuesHolder strokeHolder = createStrokePropertyHolder(false);
            PropertyValuesHolder strokeReverseHolder = createStrokePropertyHolder(true);

            animator.setValues(
                    colorHolder,
                    reverseColorHolder,

                    radiusHolder,
                    radiusReverseHolder,

                    strokeHolder,
                    strokeReverseHolder);
        }

        return this;
    }

    @NonNull
    private PropertyValuesHolder createRadiusPropertyHolder(boolean isReverse) {
        String propertyName;
        int startRadiusValue;
        int endRadiusValue;

        if (isReverse) {
            propertyName = ANIMATION_RADIUS_REVERSE;
            startRadiusValue = radiusPx / 2;
            endRadiusValue = radiusPx;
        } else {
            propertyName = ANIMATION_RADIUS;
            startRadiusValue = radiusPx;
            endRadiusValue = radiusPx / 2;
        }

        PropertyValuesHolder holder = PropertyValuesHolder.ofInt(propertyName, startRadiusValue, endRadiusValue);
        holder.setEvaluator(new IntEvaluator());

        return holder;
    }

    @NonNull
    private PropertyValuesHolder createStrokePropertyHolder(boolean isReverse) {
        String propertyName;
        int startStrokeValue;
        int endStrokeValue;

        if (isReverse) {
            propertyName = ANIMATION_STROKE_REVERSE;
            startStrokeValue = radiusPx;
            endStrokeValue = 0;
        } else {
            propertyName = ANIMATION_STROKE;
            startStrokeValue = 0;
            endStrokeValue = radiusPx;
        }

        PropertyValuesHolder holder = PropertyValuesHolder.ofInt(propertyName, startStrokeValue, endStrokeValue);
        holder.setEvaluator(new IntEvaluator());

        return holder;
    }

    private void onAnimateUpdated(@NonNull ValueAnimator animation) {
        int color = (int) animation.getAnimatedValue(ANIMATION_COLOR);
        int colorReverse = (int) animation.getAnimatedValue(ANIMATION_COLOR_REVERSE);

        int radius = (int) animation.getAnimatedValue(ANIMATION_RADIUS);
        int radiusReverse = (int) animation.getAnimatedValue(ANIMATION_RADIUS_REVERSE);

        int stroke = (int) animation.getAnimatedValue(ANIMATION_STROKE);
        int strokeReverse = (int) animation.getAnimatedValue(ANIMATION_STROKE_REVERSE);

        if (listener != null) {
            listener.onFillAnimationUpdated(
                    color,
                    colorReverse,

                    radius,
                    radiusReverse,

                    stroke,
                    strokeReverse);
        }
    }

    @SuppressWarnings("RedundantIfStatement")
    private boolean hasChanges(int colorStartValue, int colorEndValue, int radiusValue, int strokeValue) {
        if (startColor != colorStartValue) {
            return true;
        }

        if (endColor != colorEndValue) {
            return true;
        }

        if (radiusPx != radiusValue) {
            return true;
        }

        if (strokePx != strokeValue) {
            return true;
        }

        return false;
    }
}
