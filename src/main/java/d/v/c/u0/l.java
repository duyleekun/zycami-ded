/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.graphics.Bitmap$CompressFormat
 */
package d.v.c.u0;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editorinterface.compose.ComposeParams;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import com.zhiyun.editorsdk.ComposeUseCase;
import com.zhiyun.editortemplate.data.api.entity.template.Description;
import d.v.c.d0;
import d.v.c.u0.a;
import d.v.c.u0.b;
import d.v.c.u0.c;
import d.v.c.u0.l$a;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.e.l.c1;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.e.l.u1;
import d.v.f.i.g;
import d.v.h.c.b$a;
import d.v.j.e.g.y;
import d.v.j.e.g.z;
import d.v.j.e.g.z$a;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;

public class l
extends AndroidViewModel {
    public static final File p = d0.a();
    private final Application a;
    private final ComposeUseCase b;
    private final z c;
    private MutableLiveData d;
    private MutableLiveData e;
    private String f;
    private boolean g;
    private MutableLiveData h;
    private MutableLiveData i;
    public j j;
    private final MutableLiveData k;
    private final MutableLiveData l;
    private long m;
    private final MutableLiveData n;
    private final b$a o;

    public l(Application object) {
        super((Application)object);
        MutableLiveData mutableLiveData;
        Object object2 = new MutableLiveData();
        this.d = object2;
        object2 = new MutableLiveData();
        this.e = object2;
        this.g = false;
        this.h = mutableLiveData = new MutableLiveData();
        this.i = mutableLiveData = new MutableLiveData();
        super();
        this.j = mutableLiveData;
        this.k = mutableLiveData = new MutableLiveData();
        object2 = 0;
        this.l = mutableLiveData = new MutableLiveData(object2);
        this.n = object2 = new MutableLiveData();
        this.o = object2 = new l$a(this);
        this.a = object;
        super();
        this.b = object;
        object = y.q();
        this.c = object;
        object2 = new c(this);
        object.e((z$a)object2);
        object.c(2);
    }

    public static /* synthetic */ void F() {
        s1.g(p);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void G() {
        block7: {
            var1_1 = 0L;
            var3_2 /* !! */  = d.v.v.q.h.R(var1_1);
            var5_9 = k2.h();
            var6_10 = new StringBuilder();
            var7_11 = System.currentTimeMillis();
            var6_10.append(var7_11);
            var9_12 = ".png";
            var6_10.append(var9_12);
            var6_10 = var6_10.toString();
            var4_8 = new File((File)var5_9, (String)var6_10);
            var5_9 = null;
            try {
                var6_10 = new FileOutputStream(var4_8);
            }
            catch (Throwable var3_5) {
                break block7;
            }
            catch (Exception var3_6) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var5_9 = Bitmap.CompressFormat.JPEG;
                var10_13 = 100;
                var3_2 /* !! */ .compress((Bitmap.CompressFormat)var5_9, var10_13, (OutputStream)var6_10);
                var6_10.flush();
                var3_2 /* !! */  = var4_8.getAbsolutePath();
                this.M((String)var3_2 /* !! */ );
            }
            catch (Throwable var3_3) {
                var5_9 = var6_10;
                break block7;
            }
            catch (Exception var3_4) {
                var5_9 = var6_10;
                ** GOTO lbl-1000
            }
            u1.a((Closeable)var6_10);
            return;
lbl-1000:
            // 2 sources

            {
                var3_2 /* !! */ .printStackTrace();
            }
            u1.a((Closeable)var5_9);
            return;
        }
        u1.a((Closeable)var5_9);
        throw var3_7;
    }

    private /* synthetic */ void I(String string2) {
        d.v.e.i.h.g(this.d, string2);
    }

    public static /* synthetic */ MutableLiveData b(l l10) {
        return l10.i;
    }

    public static /* synthetic */ MutableLiveData c(l l10) {
        return l10.l;
    }

    public static /* synthetic */ MutableLiveData d(l l10) {
        return l10.h;
    }

    public static /* synthetic */ boolean e(l l10) {
        return l10.g;
    }

    public static /* synthetic */ Application f(l l10) {
        return l10.a;
    }

    public static /* synthetic */ MutableLiveData g(l l10) {
        return l10.e;
    }

    private static String n(long l10) {
        int n10;
        double d10;
        double d11;
        double d12;
        int n11;
        double d13 = l10;
        double d14 = d13;
        for (n11 = 0; (d12 = (d11 = d14 - (d10 = (double)(n10 = 1024))) == 0.0 ? 0 : (d11 > 0.0 ? 1 : -1)) >= 0 && n11 < (d12 = (double)4); ++n11) {
            d14 /= d10;
        }
        d14 = n11;
        d14 = Math.pow(d10, d14);
        String string2 = ".00";
        DecimalFormat decimalFormat = new DecimalFormat(string2);
        String string3 = decimalFormat.format(d13 /= d14);
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 != n12) {
                    n12 = 3;
                    if (n11 != n12) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string3);
                        stringBuilder.append("TB");
                        return stringBuilder.toString();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append("GB");
                    return stringBuilder.toString();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append("MB");
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("KB");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append("B");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ComposeParams r(String string2, String object) {
        int n10;
        ComposeParams$Resolution composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_720P;
        if (string2 != null) {
            string2.hashCode();
            int n11 = -1;
            int n12 = string2.hashCode();
            switch (n12) {
                default: {
                    break;
                }
                case 46737881: {
                    String string3 = "1080P";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 2;
                    break;
                }
                case 1688123: {
                    String string4 = "720P";
                    n10 = (int)(string2.equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 1;
                    break;
                }
                case 1687: {
                    String string5 = "4K";
                    n10 = (int)(string2.equals(string5) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                }
            }
            switch (n11) {
                default: {
                    break;
                }
                case 2: {
                    composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_1080P;
                    break;
                }
                case 0: {
                    composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_4K;
                    break;
                }
                case 1: 
            }
        }
        n10 = 24;
        try {
            n10 = Integer.parseInt((String)object);
        }
        catch (NumberFormatException numberFormatException) {}
        object = new ComposeParams();
        return ((ComposeParams)object).i(composeParams$Resolution).h(n10);
    }

    public MutableLiveData A() {
        return this.e;
    }

    public /* synthetic */ void H() {
        this.G();
    }

    public /* synthetic */ void J(String string2) {
        this.I(string2);
    }

    public void K() {
        this.c.a();
    }

    public void L(int n10) {
        MutableLiveData mutableLiveData = this.l;
        Integer n11 = n10;
        d.v.e.i.h.e(mutableLiveData, n11);
    }

    public void M(String string2) {
        d.v.e.i.h.e(this.n, string2);
    }

    public void N(String object, String object2) {
        long l10;
        Object object3 = null;
        this.g = false;
        long l11 = d.v.d.i.g.c.p();
        long l12 = l11 - (l10 = (long)50);
        Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object4 >= 0) {
            l11 = d.v.d.i.g.c.p();
            l10 = this.m;
            long l13 = 1024L;
            long l14 = l11 - (l10 = l10 / l13 / l13);
            object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object4 >= 0) {
                Object object5 = this.j;
                Boolean bl2 = Boolean.TRUE;
                ((j)object5).setValue(bl2);
                d.v.e.i.h.g(this.i, null);
                object5 = this.h;
                object3 = 0;
                d.v.e.i.h.g((MutableLiveData)object5, object3);
                object3 = this.l;
                object5 = 1;
                d.v.e.i.h.e((MutableLiveData)object3, object5);
                object3 = new StringBuilder();
                object5 = p.getAbsolutePath();
                ((StringBuilder)object3).append((String)object5);
                object5 = File.separator;
                ((StringBuilder)object3).append((String)object5);
                l11 = System.currentTimeMillis();
                ((StringBuilder)object3).append(l11);
                ((StringBuilder)object3).append(".mp4");
                this.f = object3 = ((StringBuilder)object3).toString();
                this.b.b((String)object3);
                object3 = this.b;
                object5 = this.o;
                ((ComposeUseCase)object3).d((b$a)object5);
                object3 = this.b;
                object = this.r((String)object, (String)object2);
                ((ComposeUseCase)object3).e((ComposeParams)object);
                this.b.f();
                return;
            }
        }
        object = this.i;
        object2 = new Exception("");
        d.v.e.i.h.g((MutableLiveData)object, object2);
        object = this.j;
        object2 = Boolean.FALSE;
        ((j)object).setValue(object2);
    }

    public void i(String string2, String string3) {
        long l10;
        this.m = l10 = d.v.v.q.h.f(this.r(string2, string3)) * 1024L;
        string2 = d.v.c.u0.l.n(l10);
        d.v.e.i.h.e(this.k, string2);
    }

    public void j() {
        boolean bl2;
        this.g = bl2 = s1.q((String)this.e.getValue()) ^ true;
        ComposeUseCase composeUseCase = this.b;
        composeUseCase.a();
        bl2 = this.g;
        if (bl2) {
            this.m();
        }
    }

    public void k() {
        this.f = null;
        d.v.e.i.h.e(this.e, null);
        Object object = this.l;
        Object object2 = 0;
        d.v.e.i.h.e((MutableLiveData)object, object2);
        object = c1.b().a();
        object2 = d.v.c.u0.a.a;
        object.execute((Runnable)object2);
    }

    public boolean l() {
        long l10;
        long l11;
        Object object;
        long l12 = d.v.v.q.h.H();
        boolean bl2 = true;
        Object[] objectArray = new Object[bl2];
        objectArray[0] = object = Long.valueOf(l12);
        object = "musicTrackDuration:%s";
        m.a.a.b((String)object, objectArray);
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 == false || (l11 = (l10 = l12 - (l13 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            bl2 = false;
        }
        return bl2;
    }

    public void m() {
        s1.h(this.f);
    }

    public void o() {
        Object object = this.z();
        if (object != null) {
            return;
        }
        object = c1.b().a();
        b b10 = new b(this);
        object.execute(b10);
    }

    public void onCleared() {
        super.onCleared();
        this.b.c();
        this.c.e(null);
    }

    public MutableLiveData p() {
        return this.i;
    }

    public MutableLiveData s() {
        return this.h;
    }

    public MutableLiveData t() {
        return this.l;
    }

    public MutableLiveData u() {
        return this.k;
    }

    public String v() {
        return (String)this.e.getValue();
    }

    public MutableLiveData w() {
        return this.d;
    }

    public Description x(Context object) {
        String string2 = d.v.f.i.g.m(object, 2131952032);
        String string3 = d.v.f.i.g.m(object, 2131952031);
        object = d.v.f.i.g.m(object, 2131952033);
        Description description = new Description(string2, string3, (String)object);
        return description;
    }

    public MutableLiveData y() {
        return this.n;
    }

    public String z() {
        return (String)this.n.getValue();
    }
}

