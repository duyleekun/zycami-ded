/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Exif$1
extends ThreadLocal {
    public SimpleDateFormat initialValue() {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd", locale);
        return simpleDateFormat;
    }
}

