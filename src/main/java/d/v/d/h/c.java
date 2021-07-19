/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.d.h;

import android.content.Context;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class c {
    public static final String a = "yyyyMMdd-HH:mm:ss";
    public static final String b = "yyyyMMdd-HH:mm:ss:SSS";

    public static String a(Context object, String string2, String charSequence) {
        object = object.getExternalFilesDir(null);
        Objects.requireNonNull(object);
        object = ((File)object).getAbsolutePath();
        charSequence = new StringBuilder((String)object);
        Cloneable cloneable = Locale.getDefault();
        object = new SimpleDateFormat(a, (Locale)cloneable);
        cloneable = new Date();
        object = ((DateFormat)object).format((Date)cloneable);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public static String b(String object, String string2, String charSequence) {
        charSequence = new StringBuilder((String)object);
        ((StringBuilder)charSequence).append("/");
        Cloneable cloneable = Locale.getDefault();
        object = new SimpleDateFormat(b, (Locale)cloneable);
        cloneable = new Date();
        object = ((DateFormat)object).format((Date)cloneable);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }
}

