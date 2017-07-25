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
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gm.R;
import com.gm.ui.base.BaseActivity;
import com.gm.ui.splash.SplashActivity;
import com.gm.ui.splash.SplashMvpPresenter;
import com.gm.ui.splash.SplashMvpView;

import java.util.Arrays;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity implements TestMvpView {

    @Inject
    TestMvpPresenter<TestMvpView> mPresenter;

    private static final String[] desuNoto = {
            "Goutham","Alane Avey", "Belen Brewster", "Brandon Brochu", "Carli Carrol", "Della Delrio",
            "Esther Echavarria", "Etha Edinger", "Felipe Flecha", "Ilse Island", "Kecia Keltz",
            "Lourie Lucas", "Lucille Leachman", "Mandi Mcqueeney", "Murray Matchett", "Nadia Nero",
            "Nannie Nipp", "Ozella Otis", "Pauletta Poehler", "Roderick Rippy", "Sherril Sager",
            "Taneka Tenorio", "Treena Trentham", "Ulrike Uhlman", "Virgina Viau", "Willis Wysocki"
    };

    @BindView(R.id.recycler)
    public RecyclerView recyclerView;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, TestActivity.class);
        return intent;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_test;
    }

    @Override
    protected void setUp() {
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(TestActivity.this);
    }

    @Override
    public void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TestAdapter(this, Arrays.asList(desuNoto)));
    }

    public void performClick(View view) {
        mPresenter.loadData();
    }
}
