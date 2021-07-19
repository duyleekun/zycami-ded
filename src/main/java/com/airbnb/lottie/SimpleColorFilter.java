/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 */
package com.airbnb.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

public class SimpleColorFilter
extends PorterDuffColorFilter {
    public SimpleColorFilter(int n10) {
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        super(n10, mode);
    }
}

