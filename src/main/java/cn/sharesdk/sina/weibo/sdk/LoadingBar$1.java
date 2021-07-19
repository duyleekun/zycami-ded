/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.sina.weibo.sdk;

import cn.sharesdk.sina.weibo.sdk.LoadingBar;

public class LoadingBar$1
implements Runnable {
    public final /* synthetic */ LoadingBar a;

    public LoadingBar$1(LoadingBar loadingBar) {
        this.a = loadingBar;
    }

    public void run() {
        LoadingBar loadingBar = this.a;
        int n10 = LoadingBar.a(loadingBar) + 1;
        LoadingBar.a(loadingBar, n10);
        loadingBar = this.a;
        n10 = LoadingBar.a(loadingBar);
        loadingBar.a(n10);
    }
}

