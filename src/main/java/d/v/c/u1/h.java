/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.u1;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.template.PlayState;
import d.v.c.u1.h$a;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.j0.d;

public class h {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private String d;
    public m2$d e;

    public h() {
        MutableLiveData mutableLiveData;
        Object object = 0;
        this.a = mutableLiveData = new MutableLiveData(object);
        object = Boolean.FALSE;
        this.b = mutableLiveData = new MutableLiveData(object);
        object = PlayState.STATE_IDLE;
        this.c = mutableLiveData = new MutableLiveData(object);
    }

    public String a() {
        return this.d;
    }

    public LiveData b() {
        return this.a;
    }

    public PlayState c() {
        return (PlayState)((Object)this.c.getValue());
    }

    public LiveData d() {
        return this.c;
    }

    public LiveData e() {
        return this.b;
    }

    public boolean f(String string2) {
        String string3 = this.d;
        return TextUtils.equals((CharSequence)string2, (CharSequence)string3);
    }

    public boolean g() {
        boolean bl2;
        PlayState playState;
        PlayState playState2 = this.c();
        if (playState2 == (playState = PlayState.STATE_COMPLETED)) {
            bl2 = true;
        } else {
            bl2 = false;
            playState2 = null;
        }
        return bl2;
    }

    public boolean h() {
        return (Boolean)this.b.getValue();
    }

    public boolean i(String string2) {
        String string3 = this.d;
        return TextUtils.equals((CharSequence)string2, (CharSequence)string3) ^ true;
    }

    public void j() {
        this.p();
    }

    public void k(String string2) {
        this.d = string2;
    }

    public void l(PlayState playState) {
        d.v.e.i.h.e(this.c, (Object)playState);
    }

    public void m(boolean bl2) {
        MutableLiveData mutableLiveData = this.b;
        Boolean bl3 = bl2;
        d.v.e.i.h.e(mutableLiveData, bl3);
    }

    public void n(int n10) {
        MutableLiveData mutableLiveData = this.a;
        Integer n11 = n10;
        d.v.e.i.h.e(mutableLiveData, n11);
    }

    public void o(d object) {
        boolean bl2;
        m2$d m2$d = this.e;
        if (m2$d != null && !(bl2 = m2$d.b())) {
            return;
        }
        h$a h$a = new h$a(this, (d)object);
        this.e = object = m2.i(0L, 1000L, h$a);
    }

    public void p() {
        m2.a(this.e);
        this.e = null;
    }
}

