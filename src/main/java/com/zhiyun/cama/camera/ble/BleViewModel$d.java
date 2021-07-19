/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.zhiyun.cama.camera.ble;

import android.graphics.Bitmap;
import androidx.core.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.ble.BleViewModel$PanoramaState;
import com.zhiyun.cama.camera.ble.BleViewModel$r;
import com.zhiyun.cama.camera.ble.BleViewModel$u;
import d.v.e0.ie.g;
import java.util.List;

public class BleViewModel$d
implements g {
    public int a = 0;
    public final /* synthetic */ List b;
    public final /* synthetic */ int c;
    public final /* synthetic */ BleViewModel$u d;
    public final /* synthetic */ BleViewModel$r e;
    public final /* synthetic */ BleViewModel f;

    public BleViewModel$d(BleViewModel bleViewModel, List list, int n10, BleViewModel$u bleViewModel$u, BleViewModel$r bleViewModel$r) {
        this.f = bleViewModel;
        this.b = list;
        this.c = n10;
        this.d = bleViewModel$u;
        this.e = bleViewModel$r;
    }

    public void a() {
        MutableLiveData mutableLiveData = this.f.r;
        BleViewModel$PanoramaState bleViewModel$PanoramaState = BleViewModel$PanoramaState.END;
        mutableLiveData.postValue((Object)bleViewModel$PanoramaState);
    }

    public Bitmap b() {
        int n10;
        MutableLiveData mutableLiveData = this.f.s;
        this.a = n10 = this.a + 1;
        Object object = n10;
        Integer n11 = this.b.size();
        object = Pair.create(object, n11);
        mutableLiveData.postValue(object);
        return this.e.b();
    }

    public void c(int n10) {
        BleViewModel$u bleViewModel$u;
        int n11 = this.c;
        int n12 = 3;
        if (n11 == n12 && (bleViewModel$u = this.d) != null) {
            bleViewModel$u.c(n10);
        }
    }

    public void d() {
        MutableLiveData mutableLiveData = this.f.s;
        Object object = this.b.size();
        Integer n10 = this.b.size();
        object = Pair.create(object, n10);
        mutableLiveData.postValue(object);
        mutableLiveData = this.f.r;
        object = BleViewModel$PanoramaState.SPLICE;
        mutableLiveData.postValue(object);
    }

    public void onCancel() {
        MutableLiveData mutableLiveData = this.f.r;
        BleViewModel$PanoramaState bleViewModel$PanoramaState = BleViewModel$PanoramaState.CANCEL;
        mutableLiveData.postValue((Object)bleViewModel$PanoramaState);
    }

    public void onFailed(Throwable object) {
        ((Throwable)object).printStackTrace();
        object = this.f.r;
        BleViewModel$PanoramaState bleViewModel$PanoramaState = BleViewModel$PanoramaState.ERROR;
        ((MutableLiveData)object).postValue((Object)bleViewModel$PanoramaState);
    }

    public void onStart() {
        MutableLiveData mutableLiveData = this.f.s;
        Object object = this.a;
        Integer n10 = this.b.size();
        object = Pair.create(object, n10);
        mutableLiveData.postValue(object);
        mutableLiveData = this.f.r;
        object = BleViewModel$PanoramaState.START;
        mutableLiveData.postValue(object);
    }
}

