/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.h2.t.f0;
import java.io.Serializable;

public final class Result$Failure
implements Serializable {
    public final Throwable exception;

    public Result$Failure(Throwable throwable) {
        f0.p(throwable, "exception");
        this.exception = throwable;
    }

    public boolean equals(Object object) {
        Throwable throwable;
        boolean bl2;
        boolean bl3 = object instanceof Result$Failure;
        if (bl3 && (bl2 = f0.g(throwable = this.exception, object = ((Result$Failure)object).exception))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        return this.exception.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failure(");
        Throwable throwable = this.exception;
        stringBuilder.append(throwable);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

