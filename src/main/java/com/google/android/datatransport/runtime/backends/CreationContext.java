/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.AutoValue_CreationContext;
import com.google.android.datatransport.runtime.time.Clock;

public abstract class CreationContext {
    private static final String DEFAULT_BACKEND_NAME = "cct";

    public static CreationContext create(Context context, Clock clock, Clock clock2) {
        AutoValue_CreationContext autoValue_CreationContext = new AutoValue_CreationContext(context, clock, clock2, DEFAULT_BACKEND_NAME);
        return autoValue_CreationContext;
    }

    public static CreationContext create(Context context, Clock clock, Clock clock2, String string2) {
        AutoValue_CreationContext autoValue_CreationContext = new AutoValue_CreationContext(context, clock, clock2, string2);
        return autoValue_CreationContext;
    }

    public abstract Context getApplicationContext();

    public abstract String getBackendName();

    public abstract Clock getMonotonicClock();

    public abstract Clock getWallClock();
}

