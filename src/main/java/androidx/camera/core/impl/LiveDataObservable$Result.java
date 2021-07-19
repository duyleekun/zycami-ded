/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.core.util.Preconditions;

public final class LiveDataObservable$Result {
    private Throwable mError;
    private Object mValue;

    private LiveDataObservable$Result(Object object, Throwable throwable) {
        this.mValue = object;
        this.mError = throwable;
    }

    public static LiveDataObservable$Result fromError(Throwable throwable) {
        throwable = (Throwable)Preconditions.checkNotNull(throwable);
        LiveDataObservable$Result liveDataObservable$Result = new LiveDataObservable$Result(null, throwable);
        return liveDataObservable$Result;
    }

    public static LiveDataObservable$Result fromValue(Object object) {
        LiveDataObservable$Result liveDataObservable$Result = new LiveDataObservable$Result(object, null);
        return liveDataObservable$Result;
    }

    public boolean completedSuccessfully() {
        boolean bl2;
        Throwable throwable = this.mError;
        if (throwable == null) {
            bl2 = true;
        } else {
            bl2 = false;
            throwable = null;
        }
        return bl2;
    }

    public Throwable getError() {
        return this.mError;
    }

    public Object getValue() {
        boolean bl2 = this.completedSuccessfully();
        if (bl2) {
            return this.mValue;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Result contains an error. Does not contain a value.");
        throw illegalStateException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = "[Result: <";
        stringBuilder.append((String)charSequence);
        boolean bl2 = this.completedSuccessfully();
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Value: ");
            Object object = this.mValue;
            ((StringBuilder)charSequence).append(object);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Error: ");
            Throwable throwable = this.mError;
            ((StringBuilder)charSequence).append(throwable);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        stringBuilder.append((String)charSequence);
        stringBuilder.append(">]");
        return stringBuilder.toString();
    }
}

