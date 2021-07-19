/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.o.a;

import com.meicam.sdk.NvsWaveformDataGenerator;
import com.meicam.sdk.NvsWaveformDataGenerator$WaveformDataCallback;
import d.v.v.o.a.a;
import d.v.v.o.a.c$a;
import d.v.v.o.a.c$b;
import d.v.v.o.a.d;
import d.v.v.o.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c
implements NvsWaveformDataGenerator$WaveformDataCallback {
    private NvsWaveformDataGenerator a;
    private Map b;
    private ExecutorService c;
    private long d;

    private long a(long l10, long l11, long l12, long l13, int n10) {
        double d10 = l11 -= l10;
        double d11 = l12;
        d10 /= d11;
        d11 = (double)l13 * d10;
        l10 = (long)d11;
        if (n10 == 0) {
            n10 = 1000;
        }
        l11 = n10 / 2;
        l10 += l11;
        l11 = n10;
        return Math.max(l10 / l11, 1L);
    }

    private void c(d d10, float[] fArray, long l10) {
        int n10;
        Object object = d10;
        Object object2 = fArray;
        if (d10 == null) {
            return;
        }
        int n11 = d10.h();
        long l11 = d10.f();
        long l12 = d10.c();
        long l13 = d10.b();
        long l14 = d10.e();
        if (fArray != null && (n10 = fArray.length) != 0) {
            long l15 = 0L;
            double d11 = 0.0;
            Object object3 = l13 == l15 ? 0 : (l13 < l15 ? -1 : 1);
            if (object3 != false && (object3 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1)) > 0) {
                boolean bl2;
                object3 = fArray.length >> 1;
                double d12 = l11;
                double d13 = l13;
                d12 /= d13;
                double d14 = l14;
                l11 = (long)(d12 *= d14);
                double d15 = (double)(l12 - l14) / d13 * d14;
                long l16 = (l12 = (long)d15) - l15;
                Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object4 == false) {
                    return;
                }
                ArrayList<Float> arrayList = new ArrayList<Float>();
                for (int i10 = 0; i10 < n11; ++i10) {
                    double d16 = i10;
                    d11 = n11;
                    d16 /= d11;
                    d11 = l12;
                    l14 = ((long)(d16 *= d11) + l11) / l10;
                    int n12 = (int)l14;
                    if (n12 >= object3) continue;
                    n12 = n12 * 2 + 1;
                    Object object5 = object2[n12];
                    Float f10 = Float.valueOf((float)object5);
                    arrayList.add(f10);
                }
                ((d)object).m(arrayList);
                object = d10.d().iterator();
                while (bl2 = object.hasNext()) {
                    object2 = (c$a)object.next();
                    object2.b(arrayList);
                }
            }
        }
    }

    public static c d() {
        return c$b.a();
    }

    private d e(e e10) {
        boolean bl2;
        Iterator iterator2 = this.b.keySet().iterator();
        Object object = null;
        e e11 = null;
        while (bl2 = iterator2.hasNext()) {
            e e12 = (e)iterator2.next();
            boolean bl3 = e12.a(e10);
            if (!bl3) continue;
            e11 = e12;
        }
        if (e11 != null) {
            e10 = this.b.get(e11);
            object = e10;
            object = (d)((Object)e10);
        }
        return object;
    }

    private /* synthetic */ void g(d d10, float[] fArray, long l10) {
        this.c(d10, fArray, l10);
    }

    private void k(String string2, long l10) {
        long l11;
        this.d = l11 = this.a.generateWaveformData(string2, l10, 0L, 0L, 0);
    }

    public void b() {
        long l10;
        long l11;
        long l12;
        long l13;
        NvsWaveformDataGenerator nvsWaveformDataGenerator = this.a;
        if (nvsWaveformDataGenerator != null && (l13 = (l12 = (l11 = this.d) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            nvsWaveformDataGenerator.cancelTask(l11);
        }
    }

    public void f() {
        Object object = this.a;
        if (object == null) {
            object = new NvsWaveformDataGenerator();
            this.a = object;
            ((NvsWaveformDataGenerator)object).setWaveformDataCallback(this);
            object = new HashMap();
            this.b = object;
            int n10 = 5;
            int n11 = 5;
            long l10 = 0L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<Runnable>();
            this.c = object = new ThreadPoolExecutor(n10, n11, l10, timeUnit, linkedBlockingDeque);
        }
    }

    public /* synthetic */ void h(d d10, float[] fArray, long l10) {
        this.g(d10, fArray, l10);
    }

    public void i() {
        Object object = this.a;
        if (object != null) {
            ((NvsWaveformDataGenerator)object).setWaveformDataCallback(null);
            this.a.release();
            this.a = null;
            object = this.b;
            object.clear();
            this.b = null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void j(String string2, long l10, long l11, int n10, c$a c$a) {
        c c10 = this;
        String string3 = string2;
        c$a c$a2 = c$a;
        if (string2 != null && c$a != null) {
            long l12;
            Object object;
            Object object2;
            long l13;
            long l14;
            long l15;
            Object object3;
            block23: {
                block24: {
                    long l16;
                    block22: {
                        object3 = this.a;
                        l15 = ((NvsWaveformDataGenerator)object3).getAudioFileDuration(string2);
                        object3 = this.a;
                        l14 = ((NvsWaveformDataGenerator)object3).getAudioFileSampleCount(string2);
                        l13 = 0L;
                        long l17 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
                        if (l17 > 0 || (l17 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1)) > 0) break block22;
                        object2 = "audio path error";
                        object = new IllegalStateException((String)object2);
                        c$a.a((Exception)object);
                    }
                    l12 = (l16 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1)) == false ? l15 : l11;
                    object3 = this;
                    l13 = this.a(l10, l12, l15, l14, n10);
                    object = new e(string3, l13);
                    object2 = c10.e((e)object);
                    if (object2 == null) break block23;
                    object3 = ((d)object2).g();
                    if (object3 == null) break block24;
                    boolean bl2 = object3.isEmpty();
                    if (bl2) break block24;
                    c$a2.b((List)object3);
                    return;
                }
                ((d)object2).a(c$a2);
                return;
            }
            object2 = new ArrayList();
            object2.add(c$a2);
            d d10 = new d(n10, l10, l12, l15, l14, (List)object2);
            object2 = c10.b;
            object2.put(object, d10);
            try {
                c10.k(string3, l13);
                return;
            }
            catch (Exception exception) {
                String string4 = "unknown error";
                object3 = new IllegalStateException(string4);
                c$a2.a((Exception)object3);
            }
            return;
        }
        if (c$a2 == null) return;
        String string5 = "audio path can not be null";
        IllegalStateException illegalStateException = new IllegalStateException(string5);
        c$a2.a(illegalStateException);
    }

    public void onWaveformDataGenerationFailed(long l10, String object, long l11) {
        int n10 = 3;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        Iterator iterator2 = l10;
        objectArray[1] = iterator2;
        iterator2 = l11;
        int n11 = 2;
        objectArray[n11] = iterator2;
        m.a.a.b("error s = %s,l = %s,l1 = %s", objectArray);
        iterator2 = new Iterator((String)object, l11);
        iterator2 = this.e((e)((Object)iterator2));
        if (iterator2 != null) {
            iterator2 = ((d)((Object)iterator2)).d().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                c$a c$a = (c$a)iterator2.next();
                String string2 = "error";
                object = new Exception(string2);
                c$a.a((Exception)object);
            }
        }
    }

    public void onWaveformDataReady(long l10, String string2, long l11, long l12, float[] fArray, float[] objectArray) {
        long l13;
        this.d = l13 = 0L;
        int n10 = 4;
        objectArray = new Object[n10];
        Object object = l10;
        a a10 = null;
        objectArray[0] = (float)object;
        int n11 = 1;
        objectArray[n11] = (float)string2;
        object = l11;
        objectArray[2] = (float)object;
        object = l12;
        int n12 = 3;
        objectArray[n12] = (float)object;
        m.a.a.b("l = %s,s = %s,l1 = %s,l2 = %s", objectArray);
        object = new e(string2, l12);
        d d10 = this.e((e)object);
        if (d10 != null) {
            object = this.c;
            a10 = new a(this, d10, fArray, l12);
            object.execute(a10);
        }
    }
}

