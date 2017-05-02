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

/**
 * Created by Andy on 2/7/17.
 */

public class SwapAnimation extends AbsAnimation<ValueAnimator> {

    private static final String ANIMATION_COORDINATE = "ANIMATION_COORDINATE";
    private static final int COORDINATE_NONE = -1;

    private int startCoordinate = COORDINATE_NONE;
    private int endCoordinate = COORDINATE_NONE;

    public SwapAnimation(@NonNull ValueAnimation.UpdateListener listener) {
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

    @Override
    public SwapAnimation progress(float progress) {
        if (animator != null) {
            long playTime = (long) (progress * animationDuration);

            if (animator.getValues() != null && animator.getValues().length > 0) {
                animator.setCurrentPlayTime(playTime);
            }
        }

        return this;
    }

    @NonNull
    public SwapAnimation with(int startValue, int endValue) {
        if (animator != null && hasChanges(startValue, endValue)) {
            startCoordinate = startValue;
            endCoordinate = endValue;

            PropertyValuesHolder holder = createColorPropertyHolder();
            animator.setValues(holder);
        }

        return this;
    }

    private PropertyValuesHolder createColorPropertyHolder() {
        PropertyValuesHolder holder = PropertyValuesHolder.ofInt(ANIMATION_COORDINATE, startCoordinate, endCoordinate);
        holder.setEvaluator(new IntEvaluator());

        return holder;
    }

    private void onAnimateUpdated(@NonNull ValueAnimator animation) {
        int coordinate = (int) animation.getAnimatedValue(ANIMATION_COORDINATE);

        if (listener != null) {
            listener.onSwapAnimationUpdated(coordinate);
        }
    }

    @SuppressWarnings("RedundantIfStatement")
    private boolean hasChanges(int startValue, int endValue) {
        if (startCoordinate != startValue) {
            return true;
        }

        if (endCoordinate != endValue) {
            return true;
        }

        return false;
    }
}
