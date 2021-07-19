/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision;

import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.MultiProcessor$Factory;

public class MultiProcessor$Builder {
    private MultiProcessor zzbh;

    public MultiProcessor$Builder(MultiProcessor$Factory object) {
        MultiProcessor multiProcessor;
        this.zzbh = multiProcessor = new MultiProcessor(null);
        if (object != null) {
            MultiProcessor.zza(multiProcessor, (MultiProcessor$Factory)object);
            return;
        }
        object = new IllegalArgumentException("No factory supplied.");
        throw object;
    }

    public MultiProcessor build() {
        return this.zzbh;
    }

    public MultiProcessor$Builder setMaxGapFrames(int n10) {
        if (n10 >= 0) {
            MultiProcessor.zza(this.zzbh, n10);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder(28);
        stringBuilder.append("Invalid max gap: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }
}

