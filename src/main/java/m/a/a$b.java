/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package m.a;

import android.os.Build;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m.a.a$c;

public class a$b
extends a$c {
    private static final int b = 4000;
    private static final int c = 23;
    private static final int d = 5;
    private static final Pattern e = Pattern.compile("(\\$\\d+)+$");

    public String C(StackTraceElement object) {
        int n10;
        Matcher matcher = e.matcher((CharSequence)(object = ((StackTraceElement)object).getClassName()));
        int n11 = matcher.find();
        if (n11 != 0) {
            object = matcher.replaceAll("");
        }
        int n12 = ((String)object).lastIndexOf(46) + 1;
        if ((n12 = ((String)(object = ((String)object).substring(n12))).length()) > (n11 = 23) && (n12 = Build.VERSION.SDK_INT) < (n10 = 24)) {
            n12 = 0;
            matcher = null;
            object = ((String)object).substring(0, n11);
        }
        return object;
    }

    public final String i() {
        int n10;
        Object object = super.i();
        if (object != null) {
            return object;
        }
        object = new Throwable();
        int n11 = ((StackTraceElement[])(object = object.getStackTrace())).length;
        if (n11 > (n10 = 5)) {
            object = object[n10];
            return this.C((StackTraceElement)object);
        }
        object = new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        throw object;
    }

    public void o(int n10, String string2, String string3, Throwable object) {
        int n11 = string3.length();
        int n12 = 7;
        int n13 = 4000;
        if (n11 < n13) {
            if (n10 == n12) {
                Log.wtf((String)string2, (String)string3);
            } else {
                Log.println((int)n10, (String)string2, (String)string3);
            }
            return;
        }
        n11 = 0;
        object = null;
        n13 = string3.length();
        block0: while (n11 < n13) {
            int n14;
            int n15 = string3.indexOf(10, n11);
            if (n15 == (n14 = -1)) {
                n15 = n13;
            }
            while (true) {
                n14 = n11 + 4000;
                n14 = Math.min(n15, n14);
                object = string3.substring(n11, n14);
                if (n10 == n12) {
                    Log.wtf((String)string2, (String)object);
                } else {
                    Log.println((int)n10, (String)string2, (String)object);
                }
                if (n14 >= n15) {
                    n11 = n14 + 1;
                    continue block0;
                }
                n11 = n14;
            }
        }
    }
}

