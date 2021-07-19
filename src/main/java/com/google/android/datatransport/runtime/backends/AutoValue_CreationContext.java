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
import java.util.Objects;

public final class AutoValue_CreationContext
extends CreationContext {
    private final Context applicationContext;
    private final String backendName;
    private final Clock monotonicClock;
    private final Clock wallClock;

    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String string2) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.applicationContext = context;
        Objects.requireNonNull(clock, "Null wallClock");
        this.wallClock = clock;
        Objects.requireNonNull(clock2, "Null monotonicClock");
        this.monotonicClock = clock2;
        Objects.requireNonNull(string2, "Null backendName");
        this.backendName = string2;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CreationContext;
        if (bl3) {
            boolean bl4;
            Object object2 = this.applicationContext;
            Object object3 = ((CreationContext)(object = (CreationContext)object)).getApplicationContext();
            bl3 = object2.equals(object3);
            if (!(bl3 && (bl3 = (object2 = this.wallClock).equals(object3 = ((CreationContext)object).getWallClock())) && (bl3 = (object2 = this.monotonicClock).equals(object3 = ((CreationContext)object).getMonotonicClock())) && (bl4 = ((String)(object2 = this.backendName)).equals(object = ((CreationContext)object).getBackendName())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public String getBackendName() {
        return this.backendName;
    }

    public Clock getMonotonicClock() {
        return this.monotonicClock;
    }

    public Clock getWallClock() {
        return this.wallClock;
    }

    public int hashCode() {
        int n10 = this.applicationContext.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.wallClock.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.monotonicClock.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.backendName.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CreationContext{applicationContext=");
        Object object = this.applicationContext;
        stringBuilder.append(object);
        stringBuilder.append(", wallClock=");
        object = this.wallClock;
        stringBuilder.append(object);
        stringBuilder.append(", monotonicClock=");
        object = this.monotonicClock;
        stringBuilder.append(object);
        stringBuilder.append(", backendName=");
        object = this.backendName;
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

