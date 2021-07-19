/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.vision.barcode;

import android.content.Context;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.internal.vision.zzm;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class BarcodeDetector$Builder {
    private zzk zzbs;
    private Context zzg;

    public BarcodeDetector$Builder(Context object) {
        this.zzg = object;
        this.zzbs = object;
    }

    public BarcodeDetector build() {
        Object object = this.zzg;
        zzk zzk2 = this.zzbs;
        zzm zzm2 = new zzm((Context)object, zzk2);
        object = new BarcodeDetector(zzm2, null);
        return object;
    }

    public BarcodeDetector$Builder setBarcodeFormats(int n10) {
        this.zzbs.zzbt = n10;
        return this;
    }
}

