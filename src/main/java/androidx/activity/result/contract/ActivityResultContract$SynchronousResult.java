/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity.result.contract;

public final class ActivityResultContract$SynchronousResult {
    private final Object mValue;

    public ActivityResultContract$SynchronousResult(Object object) {
        this.mValue = object;
    }

    public Object getValue() {
        return this.mValue;
    }
}

