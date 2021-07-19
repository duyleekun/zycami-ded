/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.me.country;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.zhiyun.account.me.country.CountryChooseActivity;
import d.v.e.l.h2;

public class CountryChooseActivity$a
extends RecyclerView$OnScrollListener {
    public final /* synthetic */ CountryChooseActivity a;

    public CountryChooseActivity$a(CountryChooseActivity countryChooseActivity) {
        this.a = countryChooseActivity;
    }

    public void onScrolled(RecyclerView recyclerView, int n10, int n11) {
        super.onScrolled(recyclerView, n10, n11);
        n10 = recyclerView.getHeight();
        CountryChooseActivity countryChooseActivity = this.a;
        n11 = (int)(CountryChooseActivity.d(countryChooseActivity) ? 1 : 0);
        if (n11 != 0) {
            countryChooseActivity = this.a;
            CountryChooseActivity.f(countryChooseActivity, false);
            float f10 = 40.0f;
            n11 = h2.b(f10);
            recyclerView.scrollBy(0, n10 -= n11);
        }
    }
}

