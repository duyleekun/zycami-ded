/*
 * Decompiled with CFR 0.151.
 */
package d.e.a;

import java.text.SimpleDateFormat;
import java.util.Date;

public class n {
    private static final SimpleDateFormat a;

    static {
        SimpleDateFormat simpleDateFormat;
        a = simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static long a() {
        long l10 = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = a;
        Date date = new Date(l10);
        Object object = simpleDateFormat.format(date);
        object = simpleDateFormat.parse((String)object);
        try {
            l10 = ((Date)object).getTime();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            l10 = 0L;
        }
        return l10;
    }

    public static String b(long l10) {
        SimpleDateFormat simpleDateFormat = a;
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }
}

