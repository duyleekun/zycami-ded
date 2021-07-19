/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.time.Clock;

public class CreationContextFactory {
    private final Context applicationContext;
    private final Clock monotonicClock;
    private final Clock wallClock;

    public CreationContextFactory(Context context, Clock clock, Clock clock2) {
        this.applicationContext = context;
        this.wallClock = clock;
        this.monotonicClock = clock2;
    }

    public CreationContext create(String string2) {
        Context context = this.applicationContext;
        Clock clock = this.wallClock;
        Clock clock2 = this.monotonicClock;
        return CreationContext.create(context, clock, clock2, string2);
    }
}

