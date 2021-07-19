/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.os;

import androidx.core.util.ObjectsCompat;

public class OperationCanceledException
extends RuntimeException {
    public OperationCanceledException() {
        this((String)null);
    }

    public OperationCanceledException(String string2) {
        string2 = ObjectsCompat.toString(string2, "The operation has been canceled.");
        super(string2);
    }
}

