/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Exif$2
extends ThreadLocal {
    public SimpleDateFormat initialValue() {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", locale);
        return simpleDateFormat;
    }
}

