/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package d.v.c.k1.a.x;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.data.me.remote.KWaiManager;
import d.v.c.k1.a.v;
import d.v.c.k1.a.x.l;
import d.v.e.l.b2;
import d.v.e.l.s1;
import d.v.h.e.a;
import java.util.ArrayList;

public class k
extends l {
    public static final int o = 31;

    public void e(Activity object, Fragment object2, long l10, MutableLiveData mutableLiveData) {
        boolean bl2;
        object2 = KWaiManager.getInstance();
        boolean bl3 = ((KWaiManager)object2).isKwaiInstall((Context)object);
        if (!bl3) {
            object2 = 2131953271;
            mutableLiveData.setValue(object2);
            object.finish();
            return;
        }
        object2 = KWaiManager.getInstance();
        bl3 = ((KWaiManager)object2).isKwaiAppSupport((Context)object);
        if (!bl3) {
            object2 = 2131953263;
            mutableLiveData.setValue(object2);
            object.finish();
            return;
        }
        bl3 = b2.m((Context)object);
        if (!bl3) {
            object = 2131953261;
            mutableLiveData.setValue(object);
            return;
        }
        object2 = this.b();
        ArrayList<String> arrayList = new ArrayList<String>();
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            String string2 = s1.H(((a)object2.next()).e());
            arrayList.add(string2);
        }
        KWaiManager.getInstance().aiCutMedias(arrayList, (Activity)object);
        object.finish();
    }

    public void f(RecyclerView object, v v10, a a10, MutableLiveData mutableLiveData) {
        long l10;
        long l11 = a10.d();
        long l12 = l11 - (l10 = 1000000L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            object = 2131953262;
            mutableLiveData.setValue(object);
            return;
        }
        super.f((RecyclerView)object, v10, a10, mutableLiveData);
    }
}

