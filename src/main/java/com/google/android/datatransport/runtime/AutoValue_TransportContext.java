/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext$1;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

public final class AutoValue_TransportContext
extends TransportContext {
    private final String backendName;
    private final byte[] extras;
    private final Priority priority;

    private AutoValue_TransportContext(String string2, byte[] byArray, Priority priority) {
        this.backendName = string2;
        this.extras = byArray;
        this.priority = priority;
    }

    public /* synthetic */ AutoValue_TransportContext(String string2, byte[] byArray, Priority priority, AutoValue_TransportContext$1 autoValue_TransportContext$1) {
        this(string2, byArray, priority);
    }

    public boolean equals(Object object) {
        block6: {
            boolean bl2;
            block8: {
                block7: {
                    boolean bl3;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    boolean bl4 = object instanceof TransportContext;
                    if (!bl4) break block6;
                    Object object2 = this.backendName;
                    Object object3 = ((TransportContext)(object = (TransportContext)object)).getBackendName();
                    bl4 = ((String)object2).equals(object3);
                    if (!bl4) break block7;
                    object2 = this.extras;
                    boolean bl5 = object instanceof AutoValue_TransportContext;
                    if (bl5) {
                        object3 = object;
                        object3 = ((AutoValue_TransportContext)object).extras;
                    } else {
                        object3 = ((TransportContext)object).getExtras();
                    }
                    bl4 = Arrays.equals((byte[])object2, (byte[])object3);
                    if (bl4 && (bl3 = ((Enum)(object2 = this.priority)).equals(object = ((TransportContext)object).getPriority()))) break block8;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getBackendName() {
        return this.backendName;
    }

    public byte[] getExtras() {
        return this.extras;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public int hashCode() {
        int n10 = this.backendName.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = Arrays.hashCode(this.extras);
        n10 = (n10 ^ n12) * n11;
        n11 = this.priority.hashCode();
        return n10 ^ n11;
    }
}

