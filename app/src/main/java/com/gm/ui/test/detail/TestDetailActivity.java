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

package com.gm.ui.test.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gm.R;
import com.gm.common.widget.TouchImageView;
import com.gm.ui.base.BaseActivity;
import com.gm.ui.test.TestActivity;
import com.gm.ui.test.TestMvpPresenter;
import com.gm.ui.test.TestMvpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestDetailActivity extends BaseActivity implements TestDetailMvpView {

    @Inject
    TestDetailMvpPresenter<TestDetailMvpView> mPresenter;

    @BindView(R.id.touchImageView)
    TouchImageView touchImageView;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, TestDetailActivity.class);
        return intent;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_test_detail;
    }

    @Override
    protected void setUp() {
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(TestDetailActivity.this);
        init();
    }

    public void init(){
        Bundle bundle=getIntent().getExtras();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            String imageTransitionName = bundle.getString(TestActivity.EXTRA_NAME);
            touchImageView.setTransitionName(imageTransitionName);
        }

        touchImageView.setImageResource(bundle.getInt(TestActivity.EXTRA_ID));
    }
}
