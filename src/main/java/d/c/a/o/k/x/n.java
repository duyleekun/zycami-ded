/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build$VERSION
 */
package d.c.a.o.k.x;

import android.graphics.Bitmap;
import android.os.Build;
import d.c.a.o.k.x.h;
import d.c.a.o.k.x.l;
import d.c.a.o.k.x.m;
import d.c.a.o.k.x.n$a;
import d.c.a.o.k.x.n$b;
import d.c.a.o.k.x.n$c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class n
implements l {
    private static final int d = 8;
    private static final Bitmap.Config[] e;
    private static final Bitmap.Config[] f;
    private static final Bitmap.Config[] g;
    private static final Bitmap.Config[] h;
    private static final Bitmap.Config[] i;
    private final n$c a;
    private final h b;
    private final Map c;

    static {
        Bitmap.Config config;
        int n10 = 2;
        Bitmap.Config[] configArray = new Bitmap.Config[n10];
        configArray[0] = config = Bitmap.Config.ARGB_8888;
        config = null;
        int n11 = 1;
        configArray[n11] = null;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 26;
        if (n12 >= n13) {
            Bitmap.Config config2;
            configArray = Arrays.copyOf(configArray, 3);
            n12 = configArray.length - n11;
            configArray[n12] = config2 = Bitmap.Config.RGBA_F16;
        }
        e = configArray;
        f = configArray;
        configArray = new Bitmap.Config[n11];
        configArray[0] = config = Bitmap.Config.RGB_565;
        g = configArray;
        configArray = new Bitmap.Config[n11];
        configArray[0] = config = Bitmap.Config.ARGB_4444;
        h = configArray;
        configArray = new Bitmap.Config[n11];
        configArray[0] = config = Bitmap.Config.ALPHA_8;
        i = configArray;
    }

    public n() {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap = new HashMap();
        this.b = hashMap;
        this.c = hashMap = new HashMap();
    }

    private void e(Integer object, Bitmap object2) {
        Object object3 = object2.getConfig();
        Comparable<Integer> comparable = (Integer)(object3 = this.j((Bitmap.Config)object3)).get(object);
        if (comparable != null) {
            int n10;
            int n11 = (Integer)comparable;
            if (n11 == (n10 = 1)) {
                object3.remove(object);
            } else {
                n11 = (Integer)comparable - n10;
                object2 = n11;
                object3.put(object, object2);
            }
            return;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Tried to decrement empty size, size: ");
        ((StringBuilder)comparable).append(object);
        ((StringBuilder)comparable).append(", removed: ");
        object = this.a((Bitmap)object2);
        ((StringBuilder)comparable).append((String)object);
        ((StringBuilder)comparable).append(", this: ");
        ((StringBuilder)comparable).append(this);
        object = ((StringBuilder)comparable).toString();
        object3 = new NullPointerException((String)object);
        throw object3;
    }

    private n$b g(int n10, Bitmap.Config config) {
        n$b n$b = this.a.e(n10, config);
        for (Bitmap.Config config2 : n.i(config)) {
            int n11;
            int n12;
            Object object = this.j(config2);
            Integer n13 = n10;
            if ((object = object.ceilingKey(n13)) == null || (n12 = ((Integer)object).intValue()) > (n11 = n10 * 8)) continue;
            int n14 = (Integer)object;
            if (n14 == n10 && !(config2 == null ? config != null : (n10 = (int)(config2.equals((Object)config) ? 1 : 0)) == 0)) break;
            this.a.c(n$b);
            n$c n$c = this.a;
            int n15 = (Integer)object;
            n$b = n$c.e(n15, config2);
            break;
        }
        return n$b;
    }

    public static String h(int n10, Bitmap.Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(n10);
        stringBuilder.append("](");
        stringBuilder.append(config);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        Bitmap.Config[] configArray;
        Object object = Build.VERSION.SDK_INT;
        int n10 = 26;
        if (object >= n10 && (object = (Object)(configArray = Bitmap.Config.RGBA_F16).equals((Object)config)) != 0) {
            return f;
        }
        configArray = (Bitmap.Config[])n$a.a;
        n10 = config.ordinal();
        object = configArray[n10];
        if (object != (n10 = 1)) {
            Object object2 = 2;
            if (object != object2) {
                object2 = 3;
                if (object != object2) {
                    object2 = 4;
                    if (object != object2) {
                        configArray = new Bitmap.Config[n10];
                        configArray[0] = config;
                        return configArray;
                    }
                    return i;
                }
                return h;
            }
            return g;
        }
        return e;
    }

    private NavigableMap j(Bitmap.Config config) {
        TreeMap treeMap = (TreeMap)this.c.get(config);
        if (treeMap == null) {
            treeMap = new TreeMap();
            Map map = this.c;
            map.put(config, treeMap);
        }
        return treeMap;
    }

    public String a(Bitmap bitmap) {
        int n10 = d.c.a.u.m.h(bitmap);
        bitmap = bitmap.getConfig();
        return n.h(n10, (Bitmap.Config)bitmap);
    }

    public String b(int n10, int n11, Bitmap.Config config) {
        return n.h(d.c.a.u.m.g(n10, n11, config), config);
    }

    public int c(Bitmap bitmap) {
        return d.c.a.u.m.h(bitmap);
    }

    public void d(Bitmap object) {
        int n10 = d.c.a.u.m.h((Bitmap)object);
        Object object2 = this.a;
        Bitmap.Config config = object.getConfig();
        Object object3 = ((n$c)object2).e(n10, config);
        this.b.d((m)object3, object);
        object = object.getConfig();
        object = this.j((Bitmap.Config)object);
        int n11 = ((n$b)object3).b;
        object2 = n11;
        object2 = (Integer)object.get(object2);
        n10 = ((n$b)object3).b;
        object3 = n10;
        int n12 = 1;
        if (object2 != null) {
            n11 = (Integer)object2;
            n12 += n11;
        }
        object2 = n12;
        object.put(object3, object2);
    }

    public Bitmap f(int n10, int n11, Bitmap.Config config) {
        int n12 = d.c.a.u.m.g(n10, n11, config);
        Object object = this.g(n12, config);
        Bitmap bitmap = (Bitmap)this.b.a((m)object);
        if (bitmap != null) {
            n12 = ((n$b)object).b;
            object = n12;
            this.e((Integer)object, bitmap);
            bitmap.reconfigure(n10, n11, config);
        }
        return bitmap;
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap)this.b.f();
        if (bitmap != null) {
            int n10 = d.c.a.u.m.h(bitmap);
            Integer n11 = n10;
            this.e(n11, bitmap);
        }
        return bitmap;
    }

    public String toString() {
        Object object;
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SizeConfigStrategy{groupedMap=");
        Object object2 = this.b;
        stringBuilder.append(object2);
        stringBuilder.append(", sortedSizes=(");
        object2 = this.c.entrySet().iterator();
        while ((n10 = object2.hasNext()) != 0) {
            Object object3 = (Map.Entry)object2.next();
            object = object3.getKey();
            stringBuilder.append(object);
            char c10 = '[';
            stringBuilder.append(c10);
            object3 = object3.getValue();
            stringBuilder.append(object3);
            object3 = "], ";
            stringBuilder.append((String)object3);
        }
        object2 = this.c;
        int n11 = object2.isEmpty();
        if (n11 == 0) {
            n11 = stringBuilder.length() + -2;
            n10 = stringBuilder.length();
            object = "";
            stringBuilder.replace(n11, n10, (String)object);
        }
        stringBuilder.append(")}");
        return stringBuilder.toString();
    }
}

