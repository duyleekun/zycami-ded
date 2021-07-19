/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.database.model.SplashAd;
import com.zhiyun.cama.data.database.model.SplashAdWatch;

public interface SplashAdDao {
    public void deleteAllSplashAd();

    public void insertSplashAd(SplashAd ... var1);

    public void insertSplashAdWatch(SplashAdWatch var1);

    public LiveData loadSplashAd(int var1);

    public SplashAdWatch loadSplashAdWatchData(int var1);

    public LiveData loadTypeOneSplashAd(String var1, long var2);

    public LiveData loadTypeThreeSplashAd(String var1, long var2);

    public LiveData loadTypeTwoSplashAd(String var1, long var2, long var4);
}

