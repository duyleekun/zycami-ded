/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class h {
    private final Map a;
    private final long b;
    private long c;
    private long d;

    public h(long l10) {
        LinkedHashMap linkedHashMap;
        this.a = linkedHashMap = new LinkedHashMap(100, 0.75f, true);
        this.b = l10;
        this.c = l10;
    }

    private void i() {
        long l10 = this.c;
        this.p(l10);
    }

    public void b() {
        this.p(0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(float f10) {
        synchronized (this) {
            Throwable throwable2;
            block5: {
                float f11 = 0.0f;
                String string2 = null;
                float f12 = f10 - 0.0f;
                float f13 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
                if (f13 >= 0) {
                    long l10;
                    try {
                        l10 = this.b;
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                    f11 = (float)l10 * f10;
                    int n10 = Math.round(f11);
                    this.c = l10 = (long)n10;
                    this.i();
                    return;
                }
                string2 = "Multiplier must be >= 0";
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                throw illegalArgumentException;
            }
            throw throwable2;
        }
    }

    public long e() {
        synchronized (this) {
            long l10 = this.c;
            return l10;
        }
    }

    public long getCurrentSize() {
        synchronized (this) {
            long l10 = this.d;
            return l10;
        }
    }

    public boolean h(Object object) {
        synchronized (this) {
            Map map = this.a;
            boolean bl2 = map.containsKey(object);
            return bl2;
        }
    }

    public Object j(Object object) {
        synchronized (this) {
            Map map = this.a;
            object = map.get(object);
            return object;
        }
    }

    public int k() {
        synchronized (this) {
            Map map = this.a;
            int n10 = map.size();
            return n10;
        }
    }

    public int l(Object object) {
        return 1;
    }

    public void m(Object object, Object object2) {
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object n(Object object, Object object2) {
        synchronized (this) {
            void var2_2;
            int n10 = this.l(var2_2);
            long l10 = n10;
            long l11 = this.c;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 >= 0) {
                this.m(object, var2_2);
                return null;
            }
            if (var2_2 != null) {
                this.d = l11 = this.d + l10;
            }
            Map map = this.a;
            if ((map = map.put(object, var2_2)) != null) {
                long l13 = this.d;
                int n11 = this.l(map);
                long l14 = n11;
                this.d = l13 -= l14;
                boolean bl2 = ((Object)map).equals(var2_2);
                if (!bl2) {
                    this.m(object, map);
                }
            }
            this.i();
            return map;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object o(Object object) {
        synchronized (this) {
            Map map = this.a;
            object = map.remove(object);
            if (object != null) {
                long l10 = this.d;
                int n10 = this.l(object);
                long l11 = n10;
                this.d = l10 -= l11;
            }
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void p(long l10) {
        synchronized (this) {
            long l11;
            long l12;
            long l13;
            while ((l13 = (l12 = (l11 = this.d) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                Iterator iterator2 = this.a;
                iterator2 = iterator2.entrySet();
                iterator2 = iterator2.iterator();
                Object object = iterator2.next();
                object = (Map.Entry)object;
                Object v10 = object.getValue();
                long l14 = this.d;
                int n10 = this.l(v10);
                long l15 = n10;
                this.d = l14 -= l15;
                object = object.getKey();
                iterator2.remove();
                this.m(object, v10);
            }
            return;
        }
    }
}

