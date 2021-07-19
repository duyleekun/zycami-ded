/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.net.Uri
 */
package d.v.c.i1;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.cama.data.api.entity.ShareInfo;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$OnShareCallback;
import d.v.a.f.c.b;
import d.v.c.i1.r2$a;
import d.v.c.v0.f;
import d.v.c.v0.u.v;
import d.v.c.v0.u.z;
import d.v.e.h.a;
import d.v.e.h.d;
import d.v.e.i.j;

public class r2
extends ViewModel {
    public static final int s = 255;
    private boolean a = false;
    private boolean b = true;
    private MutableLiveData c;
    public MutableLiveData d;
    public LiveData e;
    public j f;
    public MutableLiveData g;
    public MutableLiveData h;
    public MutableLiveData i;
    public final MutableLiveData j;
    public final j k;
    public final MutableLiveData l;
    public final MutableLiveData m;
    public final MutableLiveData n;
    public int o;
    public int p;
    public int q;
    public int r;

    public r2() {
        LiveData liveData;
        this.c = liveData = new MutableLiveData();
        this.d = liveData = new MutableLiveData();
        liveData = d.v.a.f.c.b.N().c();
        this.e = liveData;
        this.f = liveData;
        this.g = liveData = new MutableLiveData();
        this.h = liveData = new MutableLiveData();
        this.i = liveData = new MutableLiveData();
        this.j = liveData = new MutableLiveData();
        super();
        this.k = liveData;
        Boolean bl2 = Boolean.TRUE;
        this.l = liveData = new MutableLiveData(bl2);
        this.m = liveData = new MutableLiveData();
        bl2 = Boolean.FALSE;
        this.n = liveData = new MutableLiveData(bl2);
        this.o = -1;
        this.e();
        this.j();
    }

    public void b() {
        boolean bl2 = this.a;
        if (!bl2) {
            this.a = bl2 = true;
            z z10 = z.m();
            r2$a r2$a = new r2$a(this);
            z10.a(r2$a);
        }
    }

    public MutableLiveData c() {
        return this.c;
    }

    public void d(String object, String object2, String string2, String string3, String string4, String string5, SharePlatformManager$OnShareCallback sharePlatformManager$OnShareCallback) {
        if (object == null) {
            return;
        }
        Object object3 = "copyurl";
        boolean bl2 = object.equals(object3);
        if (bl2) {
            object = (ClipboardManager)d.v.e.f.a().b().getSystemService("clipboard");
            object2 = Uri.parse((String)string3);
            string2 = "Label";
            object2 = ClipData.newRawUri((CharSequence)string2, (Uri)object2);
            if (object != null) {
                object.setPrimaryClip((ClipData)object2);
            }
        } else {
            ShareInfo shareInfo;
            if ((object = ThirdPlatform.shareTypeToPlatformName(object)) == null) {
                return;
            }
            int n10 = Integer.parseInt((String)object2);
            int n11 = -1;
            object3 = shareInfo;
            shareInfo = new ShareInfo(n10, n11, string2, string3, string4, string5);
            object2 = d.v.c.v0.f.a();
            ((v)object2).c((ThirdPlatform)((Object)object), shareInfo, sharePlatformManager$OnShareCallback);
        }
    }

    public void e() {
        MutableLiveData mutableLiveData = this.m;
        Boolean bl2 = z.m().v();
        mutableLiveData.setValue(bl2);
    }

    public boolean f() {
        return this.b;
    }

    public void g(boolean bl2, String string2) {
        if (bl2) {
            v v10 = d.v.c.v0.f.a();
            v10.j();
        } else {
            v v11 = d.v.c.v0.f.a();
            int n10 = d.v.e.h.d.a(string2);
            v11.B(n10);
        }
    }

    public void i(int n10, d.v.a.f.b.a a10) {
        AccountManager.queryUserDetail(n10, a10);
    }

    public void j() {
        this.o = -1;
    }

    public void k(boolean bl2) {
        Object object;
        MutableLiveData mutableLiveData = this.d;
        boolean bl3 = false;
        if (bl2 && !(bl2 = ((z)(object = z.m())).p()) && (bl2 = d.v.e.h.a.d((Boolean)(object = (Boolean)this.c.getValue()), false))) {
            bl3 = true;
        }
        object = bl3;
        mutableLiveData.setValue(object);
    }

    public void l(boolean bl2) {
        this.b = bl2;
    }

    public void m(boolean bl2) {
        z.m().N(bl2);
        MutableLiveData mutableLiveData = this.d;
        Boolean bl3 = Boolean.FALSE;
        mutableLiveData.setValue(bl3);
    }

    public void n() {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
        this.k(true);
    }

    public void onCleared() {
        super.onCleared();
        z.m().a(null);
    }
}

