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

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;

public abstract class AbsAnimation<T extends Animator> {

    public static final int DEFAULT_ANIMATION_TIME = 350;

    protected long animationDuration = DEFAULT_ANIMATION_TIME;
    protected ValueAnimation.UpdateListener listener;
    protected T animator;

    public AbsAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        this.listener = listener;
        animator = createAnimator();
    }

    @NonNull
    public abstract T createAnimator();

    public abstract AbsAnimation progress(float progress);

    public AbsAnimation duration(long duration) {
        animationDuration = duration;

        if (animator instanceof ValueAnimator) {
            animator.setDuration(animationDuration);
        }

        return this;
    }

    public void start() {
        if (animator != null && !animator.isRunning()) {
            animator.start();
        }
    }

    public void end() {
        if (animator != null && animator.isStarted()) {
            animator.end();
        }
    }
}
