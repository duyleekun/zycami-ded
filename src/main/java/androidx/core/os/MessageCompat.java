/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Message
 */
package androidx.core.os;

import android.os.Build;
import android.os.Message;

public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    private MessageCompat() {
    }

    public static boolean isAsynchronous(Message message) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 >= n11) {
            return message.isAsynchronous();
        }
        n11 = (int)(sTryIsAsynchronous ? 1 : 0);
        if (n11 != 0 && n10 >= (n11 = 16)) {
            try {
                return message.isAsynchronous();
            }
            catch (NoSuchMethodError noSuchMethodError) {
                sTryIsAsynchronous = false;
            }
        }
        return false;
    }

    public static void setAsynchronous(Message message, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 >= n11) {
            message.setAsynchronous(bl2);
            return;
        }
        n11 = (int)(sTrySetAsynchronous ? 1 : 0);
        if (n11 != 0 && n10 >= (n11 = 16)) {
            try {
                message.setAsynchronous(bl2);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                message = null;
                sTrySetAsynchronous = false;
            }
        }
    }
}

