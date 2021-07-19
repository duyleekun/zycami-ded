/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.widget.TextView
 */
package l.a.q.g0;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.Locale;
import l.a.q.g0.n;
import l.a.q.g0.o;
import l.a.q.g0.p;

public class u {
    private static void a(TextView textView, int n10, boolean bl2, Object ... resources) {
        String string2;
        int n11;
        if (resources != null && (n11 = ((Object[])resources).length) != 0) {
            Resources resources2 = textView.getContext().getResources();
            string2 = p.i(resources2, n10, (Object[])resources);
        } else {
            resources = textView.getContext().getResources();
            string2 = p.h(resources, n10);
        }
        u.i(textView, bl2, string2);
    }

    private static void b(TextView textView, String string2, boolean bl2, Object ... objectArray) {
        block8: {
            block7: {
                Object object;
                int n10;
                block6: {
                    n10 = TextUtils.isEmpty((CharSequence)string2);
                    if (n10 != 0) {
                        return;
                    }
                    object = "@";
                    n10 = string2.startsWith((String)object);
                    if (n10 == 0 || (n10 = (int)(string2.contains((CharSequence)(object = "string/")) ? 1 : 0)) == 0) break block6;
                    n10 = string2.lastIndexOf("/") + 1;
                    string2 = string2.substring(n10);
                    object = textView.getContext();
                    n10 = o.b((Context)object, string2);
                    if (n10 == 0) {
                        if (objectArray != null && (n10 = objectArray.length) != 0) {
                            string2 = String.format(n.b(textView.getResources()), string2, objectArray);
                            u.i(textView, bl2, string2);
                            return;
                        }
                        textView.setText((CharSequence)string2);
                        return;
                    }
                    u.a(textView, n10, bl2, objectArray);
                    break block7;
                }
                if (objectArray == null || (n10 = objectArray.length) == 0) break block8;
                object = n.b(textView.getResources());
                string2 = String.format((Locale)object, string2, objectArray);
                u.i(textView, bl2, string2);
            }
            return;
        }
        u.i(textView, bl2, string2);
    }

    public static void c(TextView textView, int n10, Object object) {
        if (object == null) {
            u.a(textView, n10, false, null);
            return;
        }
        Object[] objectArray = new Object[]{object};
        u.a(textView, n10, false, objectArray);
    }

    public static void d(TextView textView, int n10, Object object, Object object2) {
        if (object == null && object2 == null) {
            u.a(textView, n10, false, null);
            return;
        }
        Object[] objectArray = new Object[]{object, object2};
        u.a(textView, n10, false, objectArray);
    }

    public static void e(TextView textView, int n10, Object ... objectArray) {
        u.a(textView, n10, false, objectArray);
    }

    public static void f(TextView textView, String string2, Object object) {
        if (object == null) {
            u.b(textView, string2, false, null);
            return;
        }
        Object[] objectArray = new Object[]{object};
        u.b(textView, string2, false, objectArray);
    }

    public static void g(TextView textView, String string2, Object object, Object object2) {
        if (object == null && object2 == null) {
            u.b(textView, string2, false, null);
            return;
        }
        Object[] objectArray = new Object[]{object, object2};
        u.b(textView, string2, false, objectArray);
    }

    public static void h(TextView textView, String string2, Object ... objectArray) {
        u.b(textView, string2, false, objectArray);
    }

    private static void i(TextView textView, boolean bl2, String string2) {
        if (bl2) {
            textView.setText((CharSequence)string2);
        } else {
            textView.setHint((CharSequence)string2);
        }
    }

    public static void j(TextView textView, int n10, Object object) {
        boolean bl2 = true;
        if (object == null) {
            u.a(textView, n10, bl2, null);
            return;
        }
        Object[] objectArray = new Object[bl2];
        objectArray[0] = object;
        u.a(textView, n10, bl2, objectArray);
    }

    public static void k(TextView textView, int n10, Object object, Object object2) {
        boolean bl2 = true;
        if (object == null && object2 == null) {
            u.a(textView, n10, bl2, null);
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        objectArray[bl2] = object2;
        u.a(textView, n10, bl2, objectArray);
    }

    public static void l(TextView textView, int n10, Object ... objectArray) {
        u.a(textView, n10, true, objectArray);
    }

    public static void m(TextView textView, String string2, Object object) {
        boolean bl2 = true;
        if (object == null) {
            u.b(textView, string2, bl2, null);
            return;
        }
        Object[] objectArray = new Object[bl2];
        objectArray[0] = object;
        u.b(textView, string2, bl2, objectArray);
    }

    public static void n(TextView textView, String string2, Object object, Object object2) {
        boolean bl2 = true;
        if (object == null && object2 == null) {
            u.b(textView, string2, bl2, null);
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        objectArray[bl2] = object2;
        u.b(textView, string2, bl2, objectArray);
    }

    public static void o(TextView textView, String string2, Object ... objectArray) {
        u.b(textView, string2, true, objectArray);
    }
}

