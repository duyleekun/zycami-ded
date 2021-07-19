/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory
 *  android.view.LayoutInflater$Factory2
 */
package l.a.p;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;
import l.a.p.a$a;
import l.a.p.b;

public final class a {
    private static final String a = "LayoutInflaterCompatHC";
    private static Field b;
    private static boolean c;

    private a() {
    }

    private static void a(LayoutInflater object, LayoutInflater.Factory2 factory2) {
        Object object2;
        Object object3;
        boolean bl2 = c;
        String string2 = "; inflation may have unexpected results.";
        String string3 = a;
        if (!bl2) {
            bl2 = true;
            object3 = LayoutInflater.class;
            CharSequence charSequence = "mFactory2";
            object3 = ((Class)object3).getDeclaredField((String)charSequence);
            b = object3;
            try {
                ((Field)object3).setAccessible(bl2);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                String string4 = LayoutInflater.class.getName();
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                Log.e((String)string3, (String)charSequence, (Throwable)noSuchFieldException);
            }
            c = bl2;
        }
        if ((object2 = b) != null) {
            try {
                ((Field)object2).set(object, factory2);
            }
            catch (IllegalAccessException illegalAccessException) {
                object2 = new StringBuilder();
                object3 = "forceSetFactory2 could not set the Factory2 on LayoutInflater ";
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(string2);
                object = ((StringBuilder)object2).toString();
                Log.e((String)string3, (String)object, (Throwable)illegalAccessException);
            }
        }
    }

    public static b b(LayoutInflater layoutInflater) {
        boolean bl2 = (layoutInflater = layoutInflater.getFactory()) instanceof a$a;
        if (bl2) {
            return ((a$a)layoutInflater).a;
        }
        return null;
    }

    public static void c(LayoutInflater layoutInflater, b b10) {
        int n10 = Build.VERSION.SDK_INT;
        a$a a$a = null;
        int n11 = 21;
        if (n10 >= n11) {
            if (b10 != null) {
                a$a = new a$a(b10);
            }
            layoutInflater.setFactory2((LayoutInflater.Factory2)a$a);
        } else {
            if (b10 != null) {
                a$a = new a$a(b10);
            }
            layoutInflater.setFactory2((LayoutInflater.Factory2)a$a);
            b10 = layoutInflater.getFactory();
            n10 = b10 instanceof LayoutInflater.Factory2;
            if (n10 != 0) {
                b10 = (LayoutInflater.Factory2)b10;
                l.a.p.a.a(layoutInflater, (LayoutInflater.Factory2)b10);
            } else {
                l.a.p.a.a(layoutInflater, a$a);
            }
        }
    }

    public static void d(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            n11 = factory instanceof LayoutInflater.Factory2;
            if (n11 != 0) {
                factory = (LayoutInflater.Factory2)factory;
                l.a.p.a.a(layoutInflater, (LayoutInflater.Factory2)factory);
            } else {
                l.a.p.a.a(layoutInflater, factory2);
            }
        }
    }
}

