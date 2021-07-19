/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.slf4j.impl.StaticMarkerBinder
 */
package i.h;

import i.h.b;
import i.h.h.i;
import org.slf4j.Marker;
import org.slf4j.impl.StaticMarkerBinder;

public class f {
    public static b a;

    static {
        b b10 = f.a();
        try {
            a = b10;
        }
        catch (Exception exception) {
            String string2 = "Unexpected failure while binding MarkerFactory";
            i.d(string2, exception);
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            a = b10 = new i.h.h.b();
        }
    }

    private f() {
    }

    private static b a() {
        StaticMarkerBinder staticMarkerBinder;
        try {
            staticMarkerBinder = StaticMarkerBinder.getSingleton();
        }
        catch (NoSuchMethodError noSuchMethodError) {
            return StaticMarkerBinder.SINGLETON.getMarkerFactory();
        }
        return staticMarkerBinder.getMarkerFactory();
    }

    public static Marker b(String string2) {
        return a.c(string2);
    }

    public static b c() {
        return a;
    }

    public static Marker d(String string2) {
        return a.a(string2);
    }
}

