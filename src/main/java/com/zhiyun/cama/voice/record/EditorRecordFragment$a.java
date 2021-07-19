/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.voice.record;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.voice.record.EditorRecordFragment;
import com.zhiyun.cama.voice.record.widget.RecorderView;
import d.v.c.i1.i2;
import d.v.c.y1.g.o.c;
import d.v.e.i.h;
import d.v.h.h.a$a;

public class EditorRecordFragment$a
implements a$a {
    public final /* synthetic */ EditorRecordFragment a;

    public EditorRecordFragment$a(EditorRecordFragment editorRecordFragment) {
        this.a = editorRecordFragment;
    }

    public void a(short[] sArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = sArray.length); i10 += 40) {
            c c10 = EditorRecordFragment.y(this.a);
            short s10 = sArray[i10];
            c10.b(s10);
        }
    }

    public void b(Exception object, String object2) {
        object = EditorRecordFragment.z(this.a);
        int n10 = 1;
        ((i2)object).M3(n10 != 0);
        EditorRecordFragment.M(this.a, false);
        EditorRecordFragment.N(this.a, false);
        object = EditorRecordFragment.x(this.a).d();
        object2 = n10;
        h.g((MutableLiveData)object, object2);
    }

    public void c(long l10) {
        Object object = EditorRecordFragment.x(this.a).d();
        Object object2 = 3;
        h.g((MutableLiveData)object, object2);
        object = this.a;
        object2 = EditorRecordFragment.K((EditorRecordFragment)object).e;
        long l11 = d.v.v.q.h.x() - 1000L;
        c c10 = ((RecorderView)((Object)object2)).b(l10, l11);
        EditorRecordFragment.A((EditorRecordFragment)object, c10);
    }

    public void d(long l10) {
        Object object;
        EditorRecordFragment.L(this.a).M3(true);
        EditorRecordFragment.M(this.a, false);
        EditorRecordFragment.y(this.a).d();
        EditorRecordFragment.N(this.a, false);
        MutableLiveData mutableLiveData = EditorRecordFragment.x(this.a).d();
        int n10 = EditorRecordFragment.O(this.a).z();
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
        long l11 = 500000L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 < 0) {
            object = EditorRecordFragment.K((EditorRecordFragment)this.a).e;
            c c10 = EditorRecordFragment.y(this.a);
            object.removeView((View)c10);
        }
        if ((l12 = (long)EditorRecordFragment.P((EditorRecordFragment)(object = this.a))) != false) {
            EditorRecordFragment.R(this.a).dismiss();
            object = EditorRecordFragment.S(this.a);
            l11 = 0x4000000L;
            ((i2)object).b3(l11);
            object = NavHostFragment.findNavController(this.a);
            ((NavController)object).navigateUp();
        }
    }
}

