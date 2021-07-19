/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package d.v.c.k1.a.x;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.k1.a.v;
import d.v.c.k1.a.x.l;
import d.v.h.e.a;
import java.util.ArrayList;

public class i
extends l {
    public void e(Activity object, Fragment fragment, long l10, MutableLiveData mutableLiveData) {
        object = this.b();
        mutableLiveData = new Bundle();
        mutableLiveData.putLong("CE_TEMPLATEID", l10);
        mutableLiveData.putParcelableArrayList("CE_ALBUMSECTION", (ArrayList)object);
        d.v.c.x1.l.e(fragment, 2131361803, (Bundle)mutableLiveData);
    }

    public void f(RecyclerView object, v v10, a a10, MutableLiveData mutableLiveData) {
        long l10;
        long l11 = a10.d();
        long l12 = l11 - (l10 = 60000000L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 > 0) {
            object = 2131951840;
            mutableLiveData.setValue(object);
            return;
        }
        super.f((RecyclerView)object, v10, a10, mutableLiveData);
    }
}

