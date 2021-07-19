/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext$Builder;
import com.google.android.datatransport.runtime.TransportContext$Builder;

public abstract class TransportContext {
    public static TransportContext$Builder builder() {
        AutoValue_TransportContext$Builder autoValue_TransportContext$Builder = new AutoValue_TransportContext$Builder();
        Priority priority = Priority.DEFAULT;
        return autoValue_TransportContext$Builder.setPriority(priority);
    }

    public abstract String getBackendName();

    public abstract byte[] getExtras();

    public abstract Priority getPriority();

    public final String toString() {
        int n10 = 3;
        Object[] objectArray = new Object[n10];
        Object object = this.getBackendName();
        objectArray[0] = object;
        object = this.getPriority();
        objectArray[1] = object;
        object = this.getExtras();
        int n11 = 2;
        object = object == null ? "" : Base64.encodeToString((byte[])this.getExtras(), (int)n11);
        objectArray[n11] = object;
        return String.format("TransportContext(%s, %s, %s)", objectArray);
    }

    public TransportContext withPriority(Priority object) {
        Object object2 = TransportContext.builder();
        String string2 = this.getBackendName();
        object = ((TransportContext$Builder)object2).setBackendName(string2).setPriority((Priority)((Object)object));
        object2 = this.getExtras();
        return ((TransportContext$Builder)object).setExtras((byte[])object2).build();
    }
}

