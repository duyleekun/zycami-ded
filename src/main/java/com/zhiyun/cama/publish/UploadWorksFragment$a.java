/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 */
package com.zhiyun.cama.publish;

import android.content.res.Resources;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.cama.publish.UploadWorksFragment;
import com.zhiyun.cama.publish.UploadWorksFragment$a$a;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.m1.b;
import d.v.c.m1.d.l;
import d.v.c.m1.d.l$b;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.h.e.a;

public class UploadWorksFragment$a {
    public final /* synthetic */ UploadWorksFragment a;

    public UploadWorksFragment$a(UploadWorksFragment uploadWorksFragment) {
        this.a = uploadWorksFragment;
    }

    public void a() {
        NavHostFragment.findNavController(this.a).popBackStack();
    }

    public void b() {
        long l10;
        long l11;
        long l12;
        Object object;
        Object object2 = UploadWorksFragment.k(this.a);
        int n10 = UploadWorksFragment.j(this.a);
        Object object3 = ((UploadCEMediaInfo)(object2 = (UploadCEMediaInfo)((BaseQuickAdapter)object2).getItem(n10))).a().f();
        if (object3 == (object = MediaType.VIDEO) && (n10 = (int)((l12 = (l11 = ((a)(object3 = ((UploadCEMediaInfo)object2).a())).d()) - (l10 = 300050L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0) {
            object2 = this.a;
            UploadWorksFragment.l((UploadWorksFragment)object2);
        } else {
            long l13;
            long l14;
            object3 = ((UploadCEMediaInfo)object2).a().f();
            if (object3 == object && (n10 = (int)((l14 = (l13 = ((a)(object3 = ((UploadCEMediaInfo)object2).a())).d()) - (l11 = 1800000L)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) <= 0) {
                n10 = (int)(b.a() ? 1 : 0);
                if (n10 != 0) {
                    object2 = this.a;
                    UploadWorksFragment.l((UploadWorksFragment)object2);
                } else {
                    n10 = 3;
                    object3 = l.y(n10);
                    object = new UploadWorksFragment$a$a(this, (UploadCEMediaInfo)object2);
                    object2 = ((l)object3).z((l$b)object);
                    object3 = this.a.getChildFragmentManager();
                    ((d.v.f.g.b)object2).q((FragmentManager)object3);
                }
            } else {
                object2 = this.a.getResources();
                n10 = 2131952070;
                object2 = g.o((Resources)object2, n10);
                n2.e((String)object2);
            }
        }
    }
}

