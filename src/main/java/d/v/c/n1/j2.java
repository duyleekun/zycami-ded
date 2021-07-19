/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 */
package d.v.c.n1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.api.entity.ShareInfo;
import com.zhiyun.cama.data.me.remote.KWaiManager;
import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiCallback;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$OnShareCallback;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.c.n1.j2$a;
import d.v.c.n1.j2$b;
import d.v.c.n1.m1;
import d.v.c.n1.n1;
import d.v.c.v0.f;
import d.v.c.v0.u.x;
import d.v.c.v0.u.z;
import d.v.e.g.e;
import d.v.e.i.j;
import d.v.e.l.b2;
import d.v.e.l.c1;
import d.v.e.l.k2;
import d.v.e.l.u1;
import d.v.j.e.g.y;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

public class j2
extends ViewModel {
    public static final int y = 0;
    public static final int z = 1;
    private d.v.j.e.g.z a;
    private x b;
    private final LiveData c;
    private final j d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Long j;
    private String k;
    private int l;
    private ComposeParams$Resolution m;
    private MutableLiveData n;
    private List o;
    private List p;
    private final MutableLiveData q;
    private final MutableLiveData r;
    private List s;
    private final MutableLiveData t;
    private MutableLiveData u;
    private MutableLiveData v;
    private MutableLiveData w;
    private MutableLiveData x;

    public j2() {
        Object object = new j();
        this.d = object;
        this.l = 0;
        this.n = object;
        object = new ArrayList();
        this.o = object;
        object = new ArrayList();
        this.p = object;
        this.q = object = new MutableLiveData();
        this.r = object = new MutableLiveData();
        this.t = object = new MutableLiveData();
        Boolean bl2 = Boolean.FALSE;
        this.u = object = new MutableLiveData(bl2);
        this.v = object = new MutableLiveData();
        this.w = object = new MutableLiveData(bl2);
        this.x = object = new MutableLiveData(bl2);
        this.a = object = d.v.j.e.g.y.q();
        this.b = object = d.v.c.v0.f.a();
        this.c = object = object.G();
    }

    public static /* synthetic */ MutableLiveData b(j2 j22) {
        return j22.r;
    }

    public static /* synthetic */ boolean b0(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return false;
        }
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return true;
        }
        string3 = string3.toLowerCase();
        string2 = string2.toLowerCase();
        return string3.contains(string2);
    }

    public static /* synthetic */ MutableLiveData c(j2 j22) {
        return j22.q;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void c0(File object, Uri object2, e e10) {
        void var1_4;
        Closeable closeable;
        Object object3;
        block14: {
            block16: {
                block15: {
                    BufferedInputStream bufferedInputStream;
                    block13: {
                        int n10 = 0;
                        object3 = null;
                        closeable = new FileInputStream((File)object);
                        bufferedInputStream = new BufferedInputStream((InputStream)closeable);
                        Object object4 = d.v.e.f.a();
                        object4 = ((d.v.e.f)object4).c();
                        object4 = object4.getContentResolver();
                        object4 = object4.openOutputStream(object2);
                        closeable = new BufferedOutputStream((OutputStream)object4);
                        n10 = 1024;
                        try {
                            int n11;
                            int n12;
                            object3 = new byte[n10];
                            while ((n12 = bufferedInputStream.read((byte[])object3)) != (n11 = -1)) {
                                n11 = 0;
                                ((BufferedOutputStream)closeable).write((byte[])object3, 0, n12);
                            }
                            object3 = object2.toString();
                            this.p0((String)object3);
                            object3 = object2.toString();
                            this.u0((String)object3);
                            object = ((File)object).getAbsolutePath();
                            object3 = this.o();
                            boolean bl2 = ((String)object).equals(object3);
                            if (bl2) {
                                object = object2.toString();
                                this.m0((String)object);
                            }
                            object = this.d;
                            int n13 = 2;
                            object2 = n13;
                            ((MutableLiveData)object).postValue(object2);
                            e10.a();
                        }
                        catch (Throwable throwable) {
                            break block13;
                        }
                        u1.a(bufferedInputStream);
                        break block16;
                        catch (Throwable throwable) {
                            closeable = null;
                        }
                    }
                    object3 = bufferedInputStream;
                    break block14;
                    catch (IOException iOException) {
                        block17: {
                            closeable = null;
                            break block17;
                            catch (Throwable throwable) {
                                closeable = null;
                                break block14;
                            }
                            catch (IOException iOException2) {
                                closeable = null;
                                break block15;
                            }
                            catch (IOException iOException3) {}
                        }
                        object3 = bufferedInputStream;
                    }
                }
                try {
                    object = this.d;
                    int n14 = 3;
                    object2 = n14;
                    ((MutableLiveData)object).postValue(object2);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                u1.a((Closeable)object3);
            }
            u1.a(closeable);
            return;
        }
        u1.a(object3);
        u1.a(closeable);
        throw var1_4;
    }

    public static /* synthetic */ List d(j2 j22) {
        return j22.s;
    }

    public static /* synthetic */ List e(j2 j22, List list) {
        j22.s = list;
        return list;
    }

    public static /* synthetic */ List f(j2 j22, List list, String string2) {
        return j22.z(list, string2);
    }

    public static /* synthetic */ MutableLiveData g(j2 j22) {
        return j22.t;
    }

    private List z(List stream, String object) {
        stream = stream.stream();
        n1 n12 = new n1((String)object);
        stream = stream.filter(n12);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    public int A() {
        return this.l;
    }

    public boolean F() {
        return d.v.c.v0.u.z.m().r();
    }

    public LiveData G() {
        return this.c;
    }

    public ComposeParams$Resolution H() {
        return this.m;
    }

    public j I() {
        return this.d;
    }

    public MutableLiveData J() {
        return this.x;
    }

    public MutableLiveData K() {
        return this.u;
    }

    public boolean L() {
        boolean bl2;
        Object object = this.u;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Boolean)this.u.getValue();
            bl2 = (Boolean)object;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public MutableLiveData M() {
        return this.w;
    }

    public boolean N() {
        boolean bl2;
        Object object = this.w;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Boolean)this.w.getValue();
            bl2 = (Boolean)object;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public List P() {
        return this.o;
    }

    public MutableLiveData Q() {
        return this.n;
    }

    public String R() {
        return this.k;
    }

    public boolean S() {
        return d.v.c.v0.u.z.m().y();
    }

    public void T(ThirdPlatform thirdPlatform, ShareInfo shareInfo, SharePlatformManager$OnShareCallback sharePlatformManager$OnShareCallback) {
        this.b.c(thirdPlatform, shareInfo, sharePlatformManager$OnShareCallback);
    }

    public boolean U() {
        int n10 = this.l;
        int n11 = 1;
        int n12 = 2;
        if (n12 != n10 && n11 != n10) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean V() {
        int n10 = this.l;
        int n11 = 3;
        n10 = n10 != n11 && n10 != (n11 = 2) ? 0 : 1;
        return n10 != 0;
    }

    public boolean W() {
        int n10 = 3;
        int n11 = this.l;
        n11 = n10 == n11 ? 1 : 0;
        return n11 != 0;
    }

    public boolean X() {
        int n10 = this.l;
        int n11 = 4;
        n10 = n10 != n11 && n10 != (n11 = 5) ? 1 : 0;
        return n10 != 0;
    }

    public boolean Y() {
        int n10;
        int n11 = 1;
        int n12 = this.l;
        if (n11 != n12 && (n10 = 4) != n12 && (n10 = 7) != n12) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean Z(int n10) {
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            int n13;
            List list = this.o;
            n10 = list.size();
            if (n10 == (n13 = 5)) {
                n11 = n12;
            }
            return n11;
        }
        if (n10 == n12) {
            int n14;
            List list = this.p;
            n10 = list.size();
            if (n10 == (n14 = 3)) {
                n11 = n12;
            }
            return n11;
        }
        return n12;
    }

    public boolean a0() {
        return d.v.a.f.c.b.N().s();
    }

    public /* synthetic */ void d0(File file, Uri uri, e e10) {
        this.c0(file, uri, e10);
    }

    public void e0(a a10) {
        this.b.p(a10);
    }

    public void f0(Activity activity, int n10, int n11, String string2, String string3, KWaiManager$OnKWaiCallback kWaiManager$OnKWaiCallback) {
        KWaiManager.getInstance().publishSingleVideo(activity, n10, n11, string2, string3, kWaiManager$OnKWaiCallback);
    }

    public void g0(String object) {
        Object object2 = this.r;
        Object object3 = PagingRequestHelper$Status.RUNNING;
        object2.setValue(object3);
        object2 = d.v.e.f.a().c();
        boolean bl2 = b2.m((Context)object2);
        if (!bl2) {
            object = this.r;
            object2 = PagingRequestHelper$Status.FAILED;
            ((MutableLiveData)object).setValue(object2);
            return;
        }
        object = object == null ? null : ((String)object).trim();
        object2 = this.s;
        if (object2 != null) {
            object3 = this.t;
            object = this.z((List)object2, (String)object);
            ((MutableLiveData)object3).setValue(object);
            object = this.r;
            object2 = PagingRequestHelper$Status.SUCCESS;
            ((MutableLiveData)object).setValue(object2);
            return;
        }
        object2 = this.b;
        object3 = new j2$b(this, (String)object);
        object2.a((a)object3);
    }

    public void h0() {
        Object object = this.r;
        Object object2 = PagingRequestHelper$Status.RUNNING;
        ((MutableLiveData)object).setValue(object2);
        object = this.b;
        object2 = new j2$a(this);
        object.F((a)object2);
    }

    public void i(int n10, String string2) {
        if (n10 == 0) {
            List list = this.o;
            list.add(string2);
        } else {
            int n11 = 1;
            if (n11 == n10) {
                List list = this.p;
                list.add(string2);
            }
        }
    }

    public void i0(int n10, int n11) {
        if (n10 == 0) {
            List list;
            if (n11 >= 0 && n11 < (n10 = (list = this.o).size())) {
                list = this.o;
                list.remove(n11);
            }
        } else {
            List list;
            int n12 = 1;
            if (n12 == n10 && n11 >= 0 && n11 < (n10 = (list = this.p).size())) {
                list = this.p;
                list.remove(n11);
            }
        }
    }

    public void j() {
        this.a.a();
    }

    public void j0(e e10) {
        Object object = this.d;
        Object object2 = 1;
        ((j)object).setValue(object2);
        object2 = this.R();
        object = new File((String)object2);
        object2 = new StringBuilder();
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l10);
        ((StringBuilder)object2).append(".mp4");
        object2 = k2.B(((StringBuilder)object2).toString());
        Executor executor = c1.b().a();
        m1 m12 = new m1(this, (File)object, (Uri)object2, e10);
        executor.execute(m12);
    }

    public void k() {
        this.b.r();
    }

    public void k0(String string2) {
        this.h = string2;
    }

    public void l(Activity activity, int n10, int n11, String string2, KWaiManager$OnKWaiCallback kWaiManager$OnKWaiCallback) {
        KWaiManager.getInstance().editorSingleVideo(activity, n10, n11, string2, kWaiManager$OnKWaiCallback);
    }

    public void l0(String string2) {
        this.i = string2;
    }

    public String m() {
        return this.h;
    }

    public void m0(String string2) {
        this.f = string2;
    }

    public String n() {
        return this.i;
    }

    public void n0(Long l10) {
        this.j = l10;
    }

    public String o() {
        return this.f;
    }

    public void o0(String string2) {
        this.g = string2;
    }

    public List p() {
        return this.p;
    }

    public void p0(String string2) {
        this.e = string2;
    }

    public void q0(int n10) {
        this.l = n10;
    }

    public MutableLiveData r() {
        return this.t;
    }

    public void r0(boolean bl2) {
        d.v.c.v0.u.z.m().P(bl2);
    }

    public Long s() {
        long l10;
        Long l11 = this.j;
        long l12 = l11;
        long l13 = l12 - (l10 = (long)-1);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            object = 0;
            l11 = null;
        } else {
            l11 = this.j;
        }
        return l11;
    }

    public void s0(ComposeParams$Resolution composeParams$Resolution) {
        this.m = composeParams$Resolution;
    }

    public String t() {
        return this.g;
    }

    public void t0(String string2) {
        this.n.setValue(string2);
    }

    public String u() {
        return this.e;
    }

    public void u0(String string2) {
        this.k = string2;
    }

    public LiveData v() {
        return this.q;
    }

    public void v0(boolean bl2) {
        d.v.c.v0.u.z.m().V(bl2);
    }

    public MutableLiveData w() {
        return this.r;
    }

    public MutableLiveData x() {
        return this.v;
    }

    public String y() {
        Object object = this.v;
        object = object == null ? null : (String)((LiveData)object).getValue();
        return object;
    }
}

