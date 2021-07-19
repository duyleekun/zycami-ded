/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import g.h0.d;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class c$a
extends ThreadLocal {
    public DateFormat a() {
        Cloneable cloneable = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", (Locale)cloneable);
        simpleDateFormat.setLenient(false);
        cloneable = d.f;
        simpleDateFormat.setTimeZone((TimeZone)cloneable);
        return simpleDateFormat;
    }
}

