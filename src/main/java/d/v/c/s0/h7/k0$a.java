/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.s0.h7;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import d.v.c.s0.h7.k0;
import d.v.c.s0.h7.k0$d;
import d.v.c.s0.h7.m0;
import d.v.e.l.s1;
import d.v.v.q.h;
import e.a.y0.e;

public class k0$a
extends e {
    public final /* synthetic */ k0$d b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean[] d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ k0 f;

    public k0$a(k0 k02, k0$d k0$d, int n10, boolean[] blArray, boolean bl2) {
        this.f = k02;
        this.b = k0$d;
        this.c = n10;
        this.d = blArray;
        this.e = bl2;
    }

    public void a() {
        k0.a(this.f, true);
        k0$d k0$d = this.b;
        Object object = this.f;
        int n10 = this.c;
        object = k0.b((k0)object, n10);
        k0$d.f((String)object);
    }

    public void b(String object) {
        Object object2 = this.d;
        boolean bl2 = true;
        int n10 = 0;
        object2[0] = bl2;
        this.dispose();
        boolean bl3 = this.e;
        if (bl3) {
            bl3 = TextUtils.isEmpty((CharSequence)object);
            if (bl3) {
                return;
            }
            bl3 = h.l0((String)object);
            if (!bl3) {
                return;
            }
            k0.c(this.f).Z((String)object);
            object = k0.c(this.f);
            object2 = (Object)CameraSet$StoryState.STORY_REVIEW;
            ((m0)object).g0((CameraSet$StoryState)((Object)object2));
        } else {
            object = k0.c(this.f).k();
            boolean bl4 = s1.q((String)object);
            if (bl4) {
                n10 = 100;
            }
            object = k0.c(this.f).t();
            object2 = n10;
            ((MutableLiveData)object).postValue(object2);
        }
    }

    public void onError(Throwable throwable) {
        this.d[0] = true;
        this.dispose();
    }
}

