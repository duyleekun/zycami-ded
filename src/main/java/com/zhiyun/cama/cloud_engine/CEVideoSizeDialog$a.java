/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.cloud_engine;

import android.os.Bundle;
import android.view.View;
import androidx.navigation.fragment.NavHostFragment;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Resolution;
import com.zhiyun.cama.cloud_engine.CEVideoSizeDialog;
import d.v.c.t0.r;
import d.v.c.x1.l;
import java.io.Serializable;
import java.util.ArrayList;

public class CEVideoSizeDialog$a {
    public static final /* synthetic */ boolean b;
    public final /* synthetic */ CEVideoSizeDialog a;

    public CEVideoSizeDialog$a(CEVideoSizeDialog cEVideoSizeDialog) {
        this.a = cEVideoSizeDialog;
    }

    public static /* synthetic */ void c(View view) {
        view.setEnabled(true);
    }

    public void a() {
        NavHostFragment.findNavController(this.a).popBackStack();
    }

    public void b(View view, CompositeConfig$Resolution object) {
        view.setEnabled(false);
        Object object2 = this.a.getDialog();
        if (object2 != null) {
            object2 = this.a.getDialog();
            object2.hide();
        }
        object2 = this.a.getArguments();
        String string2 = "CE_TEMPLATEID";
        long l10 = object2.getLong(string2);
        String string3 = "CE_ALBUMSECTION";
        object2 = object2.getParcelableArrayList(string3);
        Bundle bundle = new Bundle();
        bundle.putLong(string2, l10);
        bundle.putParcelableArrayList(string3, (ArrayList)object2);
        object = (Serializable)Serializable.class.cast(object);
        bundle.putSerializable("resolution", (Serializable)object);
        l.e(this.a, 2131361798, bundle);
        object = new r(view);
        view.postDelayed((Runnable)object, 200L);
    }
}

