/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.mediacontent.media;

import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity;
import d.v.c.k1.a.l;
import d.v.c.k1.a.w;
import d.v.c.q0.f.a;
import java.util.Optional;

public class EditorAddVideoActivity$b
implements a {
    public final /* synthetic */ EditorAddVideoActivity a;

    public EditorAddVideoActivity$b(EditorAddVideoActivity editorAddVideoActivity) {
        this.a = editorAddVideoActivity;
    }

    public static /* synthetic */ void c(Fragment fragment) {
        ((AddVideoFragment)fragment).F();
    }

    public void a(View view) {
        ActivityCompat.finishAfterTransition(this.a);
    }

    public void b(View object) {
        object = EditorAddVideoActivity.j(this.a);
        boolean bl2 = ((w)object).p();
        if (!bl2) {
            return;
        }
        object = this.a.getSupportFragmentManager();
        Object object2 = AddVideoFragment.class.getName();
        object = Optional.ofNullable(((FragmentManager)object).findFragmentByTag((String)object2));
        object2 = l.a;
        ((Optional)object).ifPresent(object2);
    }
}

