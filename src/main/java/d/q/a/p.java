/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import java.util.Objects;

public final class p {
    private p() {
        InstantiationError instantiationError = new InstantiationError();
        throw instantiationError;
    }

    public static Object a(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }
}

