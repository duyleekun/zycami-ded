/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.main;

import android.view.View;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.cama.main.MainFragment;

public class MainFragment$d {
    public final /* synthetic */ MainFragment a;

    public MainFragment$d(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public void a(View view) {
        MainFragment.l(this.a);
    }

    public void b(View view) {
        MainFragment.k(this.a);
    }

    public void c(View object) {
        object = this.a;
        ThirdPlatform thirdPlatform = ThirdPlatform.FACEBOOK;
        MainFragment.m((MainFragment)object, thirdPlatform);
    }

    public void d(View object) {
        object = this.a;
        ThirdPlatform thirdPlatform = ThirdPlatform.KWAI_UPLOAD;
        MainFragment.m((MainFragment)object, thirdPlatform);
    }

    public void e(View object) {
        object = this.a;
        ThirdPlatform thirdPlatform = ThirdPlatform.MOMENT;
        MainFragment.m((MainFragment)object, thirdPlatform);
    }

    public void f(View object) {
        object = this.a;
        ThirdPlatform thirdPlatform = ThirdPlatform.QQ;
        MainFragment.m((MainFragment)object, thirdPlatform);
    }

    public void g(View object) {
        object = this.a;
        ThirdPlatform thirdPlatform = ThirdPlatform.TWITTER;
        MainFragment.m((MainFragment)object, thirdPlatform);
    }

    public void h(View object) {
        object = this.a;
        ThirdPlatform thirdPlatform = ThirdPlatform.WE_CHAT;
        MainFragment.m((MainFragment)object, thirdPlatform);
    }

    public void i(View object) {
        object = this.a;
        ThirdPlatform thirdPlatform = ThirdPlatform.WEIBO;
        MainFragment.m((MainFragment)object, thirdPlatform);
    }
}

