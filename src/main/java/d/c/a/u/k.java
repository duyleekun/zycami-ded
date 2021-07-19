/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.c.a.u;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

public final class k {
    private k() {
    }

    public static void a(boolean bl2, String string2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static String b(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return object;
        }
        object = new IllegalArgumentException("Must not be null or empty");
        throw object;
    }

    public static Collection c(Collection object) {
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            return object;
        }
        object = new IllegalArgumentException("Must not be empty.");
        throw object;
    }

    public static Object d(Object object) {
        return k.e(object, "Argument must not be null");
    }

    public static Object e(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }
}

