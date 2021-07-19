/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.vision.text;

import android.content.Context;
import com.google.android.gms.internal.vision.zzam;
import com.google.android.gms.internal.vision.zzan;
import com.google.android.gms.vision.text.TextRecognizer;

public class TextRecognizer$Builder {
    private zzam zzem;
    private Context zzg;

    public TextRecognizer$Builder(Context object) {
        this.zzg = object;
        this.zzem = object;
    }

    public TextRecognizer build() {
        Object object = this.zzg;
        zzam zzam2 = this.zzem;
        zzan zzan2 = new zzan((Context)object, zzam2);
        object = new TextRecognizer(zzan2, null);
        return object;
    }
}

