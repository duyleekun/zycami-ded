/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package d.c.a.o.k.x;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import d.c.a.o.k.x.c;
import d.c.a.o.k.x.e;
import d.c.a.o.k.x.k$a;
import d.c.a.o.k.x.k$b;
import d.c.a.o.k.x.l;
import d.c.a.o.k.x.n;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class k
implements e {
    private static final String k = "LruBitmapPool";
    private static final Bitmap.Config l = Bitmap.Config.ARGB_8888;
    private final l a;
    private final Set b;
    private final long c;
    private final k$a d;
    private long e;
    private long f;
    private int g;
    private int h;
    private int i;
    private int j;

    public k(long l10) {
        l l11 = d.c.a.o.k.x.k.p();
        Set set = d.c.a.o.k.x.k.o();
        this(l10, l11, set);
    }

    public k(long l10, l l11, Set set) {
        this.c = l10;
        this.e = l10;
        this.a = l11;
        this.b = set;
        k$b k$b = new k$b();
        this.d = k$b;
    }

    public k(long l10, Set set) {
        l l11 = d.c.a.o.k.x.k.p();
        this(l10, l11, set);
    }

    private static void h(Bitmap.Config object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return;
        }
        Object object2 = Bitmap.Config.HARDWARE;
        if (object != object2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create a mutable Bitmap with config: ");
        stringBuilder.append(object);
        stringBuilder.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private static Bitmap i(int n10, int n11, Bitmap.Config config) {
        if (config == null) {
            config = l;
        }
        return Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
    }

    private void j() {
        String string2 = k;
        int n10 = 2;
        boolean bl2 = Log.isLoggable((String)string2, (int)n10);
        if (bl2) {
            this.k();
        }
    }

    private void k() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Hits=");
        int n10 = this.g;
        charSequence.append(n10);
        charSequence.append(", misses=");
        n10 = this.h;
        charSequence.append(n10);
        charSequence.append(", puts=");
        n10 = this.i;
        charSequence.append(n10);
        charSequence.append(", evictions=");
        n10 = this.j;
        charSequence.append(n10);
        charSequence.append(", currentSize=");
        long l10 = this.f;
        charSequence.append(l10);
        charSequence.append(", maxSize=");
        l10 = this.e;
        charSequence.append(l10);
        charSequence.append("\nStrategy=");
        l l11 = this.a;
        charSequence.append(l11);
        charSequence = charSequence.toString();
        Log.v((String)k, (String)charSequence);
    }

    private void l() {
        long l10 = this.e;
        this.v(l10);
    }

    private static Set o() {
        Bitmap.Config config = Arrays.asList(Bitmap.Config.values());
        HashSet<Bitmap.Config> hashSet = new HashSet<Bitmap.Config>((Collection<Bitmap.Config>)config);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            n11 = 0;
            hashSet.add(null);
        }
        if (n10 >= (n11 = 26)) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l p() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        l l10 = n10 >= n11 ? new n() : new c();
        return l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Bitmap q(int n10, int n11, Bitmap.Config config) {
        synchronized (this) {
            Object object;
            CharSequence charSequence;
            int n12;
            int n13;
            d.c.a.o.k.x.k.h(config);
            l l10 = this.a;
            Object object2 = config != null ? config : l;
            l10 = l10.f(n10, n11, (Bitmap.Config)object2);
            if (l10 == null) {
                object2 = k;
                n13 = 3;
                n12 = (int)(Log.isLoggable((String)object2, (int)n13) ? 1 : 0);
                if (n12 != 0) {
                    object2 = k;
                    charSequence = new StringBuilder();
                    object = "Missing bitmap=";
                    ((StringBuilder)charSequence).append((String)object);
                    object = this.a;
                    object = object.b(n10, n11, config);
                    ((StringBuilder)charSequence).append((String)object);
                    charSequence = ((StringBuilder)charSequence).toString();
                    Log.d((String)object2, (String)charSequence);
                }
                this.h = n12 = this.h + 1;
            } else {
                this.g = n12 = this.g + 1;
                long l11 = this.f;
                object = this.a;
                int n14 = object.c((Bitmap)l10);
                long l12 = n14;
                this.f = l11 -= l12;
                object2 = this.d;
                object2.a((Bitmap)l10);
                d.c.a.o.k.x.k.u((Bitmap)l10);
            }
            object2 = k;
            n13 = 2;
            n12 = (int)(Log.isLoggable((String)object2, (int)n13) ? 1 : 0);
            if (n12 != 0) {
                object2 = k;
                charSequence = new StringBuilder();
                object = "Get bitmap=";
                ((StringBuilder)charSequence).append((String)object);
                object = this.a;
                String string2 = object.b(n10, n11, config);
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                Log.v((String)object2, (String)string2);
            }
            this.j();
            return l10;
        }
    }

    private static void s(Bitmap bitmap) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            n10 = 1;
            bitmap.setPremultiplied(n10 != 0);
        }
    }

    private static void u(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        d.c.a.o.k.x.k.s(bitmap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void v(long l10) {
        synchronized (this) {
            long l11;
            long l12;
            long l13;
            while ((l13 = (l12 = (l11 = this.f) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                int n10;
                l l14 = this.a;
                if ((l14 = l14.removeLast()) == null) {
                    String string2 = k;
                    int n11 = 5;
                    boolean bl2 = Log.isLoggable((String)string2, (int)n11);
                    if (bl2) {
                        string2 = k;
                        String string3 = "Size mismatch, resetting";
                        Log.w((String)string2, (String)string3);
                        this.k();
                    }
                    this.f = l10 = 0L;
                    return;
                }
                Object object = this.d;
                object.a((Bitmap)l14);
                long l15 = this.f;
                Object object2 = this.a;
                int n12 = object2.c((Bitmap)l14);
                long l16 = n12;
                this.f = l15 -= l16;
                this.j = n10 = this.j + 1;
                object = k;
                int n13 = 3;
                n10 = (int)(Log.isLoggable((String)object, (int)n13) ? 1 : 0);
                if (n10 != 0) {
                    object = k;
                    CharSequence charSequence = new StringBuilder();
                    object2 = "Evicting bitmap=";
                    charSequence.append((String)object2);
                    object2 = this.a;
                    object2 = object2.a((Bitmap)l14);
                    charSequence.append((String)object2);
                    charSequence = charSequence.toString();
                    Log.d((String)object, (String)charSequence);
                }
                this.j();
                l14.recycle();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n10) {
        int n11;
        String string2 = k;
        int n12 = Log.isLoggable((String)string2, (int)3);
        if (n12 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "trimMemory, level=";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            String string4 = stringBuilder.toString();
            Log.d((String)string2, (String)string4);
        }
        if (n10 < (n11 = 40)) {
            n11 = Build.VERSION.SDK_INT;
            n12 = 23;
            int n13 = 20;
            if (n11 < n12 || n10 < n13) {
                if (n10 < n13) {
                    n11 = 15;
                    if (n10 != n11) return;
                }
                long l10 = this.e();
                long l11 = 2;
                this.v(l10 /= l11);
                return;
            }
        }
        this.b();
    }

    public void b() {
        String string2 = k;
        boolean bl2 = Log.isLoggable((String)string2, (int)3);
        if (bl2) {
            String string3 = "clearMemory";
            Log.d((String)string2, (String)string3);
        }
        this.v(0L);
    }

    public void c(float f10) {
        synchronized (this) {
            long l10 = this.c;
            float f11 = (float)l10 * f10;
            int n10 = Math.round(f11);
            l10 = n10;
            this.e = l10;
            this.l();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(Bitmap object) {
        synchronized (this) {
            Throwable throwable2;
            if (object != null) {
                try {
                    Object object2;
                    Object object3;
                    int n10 = object.isRecycled();
                    if (n10 != 0) {
                        String string2 = "Cannot pool recycled bitmap";
                        object = new IllegalStateException(string2);
                        throw object;
                    }
                    n10 = object.isMutable();
                    int n11 = 2;
                    if (n10 != 0) {
                        object3 = this.a;
                        n10 = object3.c((Bitmap)object);
                        long l10 = n10;
                        long l11 = this.e;
                        long l12 = l10 - l11;
                        if ((n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0 && (n10 = (int)((object3 = this.b).contains(object2 = object.getConfig()) ? 1 : 0)) != 0) {
                            int n12;
                            object3 = this.a;
                            n10 = object3.c((Bitmap)object);
                            object2 = this.a;
                            object2.d((Bitmap)object);
                            object2 = this.d;
                            object2.b((Bitmap)object);
                            this.i = n12 = this.i + 1;
                            l10 = this.f;
                            l11 = n10;
                            this.f = l10 += l11;
                            object3 = k;
                            n10 = (int)(Log.isLoggable((String)object3, (int)n11) ? 1 : 0);
                            if (n10 != 0) {
                                object3 = k;
                                StringBuilder stringBuilder = new StringBuilder();
                                object2 = "Put bitmap in pool=";
                                stringBuilder.append((String)object2);
                                object2 = this.a;
                                object = object2.a((Bitmap)object);
                                stringBuilder.append((String)object);
                                object = stringBuilder.toString();
                                Log.v((String)object3, (String)object);
                            }
                            this.j();
                            this.l();
                            return;
                        }
                    }
                    if ((n10 = Log.isLoggable((String)(object3 = k), (int)n11)) != 0) {
                        object3 = k;
                        CharSequence charSequence = new StringBuilder();
                        object2 = "Reject bitmap from pool, bitmap: ";
                        charSequence.append((String)object2);
                        object2 = this.a;
                        object2 = object2.a((Bitmap)object);
                        charSequence.append((String)object2);
                        object2 = ", is mutable: ";
                        charSequence.append((String)object2);
                        boolean bl2 = object.isMutable();
                        charSequence.append(bl2);
                        object2 = ", is allowed config: ";
                        charSequence.append((String)object2);
                        object2 = this.b;
                        Bitmap.Config config = object.getConfig();
                        bl2 = object2.contains(config);
                        charSequence.append(bl2);
                        charSequence = charSequence.toString();
                        Log.v((String)object3, (String)charSequence);
                    }
                    object.recycle();
                    return;
                }
                catch (Throwable throwable2) {}
            } else {
                String string3 = "Bitmap must not be null";
                object = new NullPointerException(string3);
                throw object;
            }
            throw throwable2;
        }
    }

    public long e() {
        return this.e;
    }

    public Bitmap f(int n10, int n11, Bitmap.Config config) {
        Bitmap bitmap = this.q(n10, n11, config);
        if (bitmap != null) {
            n10 = 0;
            bitmap.eraseColor(0);
        } else {
            bitmap = d.c.a.o.k.x.k.i(n10, n11, config);
        }
        return bitmap;
    }

    public Bitmap g(int n10, int n11, Bitmap.Config config) {
        Bitmap bitmap = this.q(n10, n11, config);
        if (bitmap == null) {
            bitmap = d.c.a.o.k.x.k.i(n10, n11, config);
        }
        return bitmap;
    }

    public long m() {
        return this.j;
    }

    public long n() {
        return this.f;
    }

    public long r() {
        return this.g;
    }

    public long t() {
        return this.h;
    }
}

