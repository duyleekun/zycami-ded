/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import f.q1;
import g.h0.d;
import g.h0.j.c$a;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class c {
    public static final long a = 253402300799999L;
    private static final c$a b;
    private static final String[] c;
    private static final DateFormat[] d;

    static {
        String[] stringArray = new c$a();
        b = stringArray;
        stringArray = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        c = stringArray;
        d = new DateFormat[stringArray.length];
    }

    public static final Date a(String object) {
        int n10;
        Object object2 = "$this$toHttpDateOrNull";
        f0.p(object, (String)object2);
        int n11 = object.length();
        if (n11 == 0) {
            n11 = 1;
        } else {
            n11 = 0;
            object2 = null;
        }
        if (n11 != 0) {
            return null;
        }
        object2 = new ParsePosition(0);
        String[] stringArray = ((DateFormat)b.get()).parse((String)object, (ParsePosition)object2);
        int n12 = ((ParsePosition)object2).getIndex();
        if (n12 == (n10 = ((String)object).length())) {
            return stringArray;
        }
        stringArray = c;
        synchronized (stringArray) {
            n12 = stringArray.length;
            for (n10 = 0; n10 < n12; ++n10) {
                DateFormat dateFormat;
                Object object3;
                block22: {
                    object3 = d;
                    dateFormat = object3[n10];
                    if (dateFormat != null) break block22;
                    Object object4 = c;
                    object4 = object4[n10];
                    Locale locale = Locale.US;
                    dateFormat = new SimpleDateFormat((String)object4, locale);
                    object4 = g.h0.d.f;
                    dateFormat.setTimeZone((TimeZone)object4);
                    object3[n10] = dateFormat;
                }
                ((ParsePosition)object2).setIndex(0);
                object3 = dateFormat.parse((String)object, (ParsePosition)object2);
                int n13 = ((ParsePosition)object2).getIndex();
                if (n13 == 0) continue;
                return object3;
            }
            try {
                object = q1.a;
                return null;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }

    public static final String b(Date object) {
        f0.p(object, "$this$toHttpDateString");
        object = ((DateFormat)b.get()).format((Date)object);
        f0.o(object, "STANDARD_DATE_FORMAT.get().format(this)");
        return object;
    }
}

