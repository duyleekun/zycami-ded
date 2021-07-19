/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.net.Uri;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.publish.VideoCropFragment;
import com.zhiyun.cama.publish.VideoCropFragment$c;
import d.v.c.s0.t6;
import d.v.e.l.s1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.h.c.b$a;
import m.a.a;

public class VideoCropFragment$c$a
implements b$a {
    public final /* synthetic */ VideoCropFragment$c a;

    public VideoCropFragment$c$a(VideoCropFragment$c videoCropFragment$c) {
        this.a = videoCropFragment$c;
    }

    public void a(Exception object, String object2) {
        VideoCropFragment.v(this.a.a).set(false);
        object2 = this.a.a.getContext();
        object = new k$b((Context)object2);
        object = (k$b)((k$a)object).m(2131951896);
        object2 = d.v.c.n1.a.a;
        object = (k$b)((k$b)((k$a)object).o(2131951833, (d.v.f.f.a)object2)).v(2131952621, (d.v.f.f.a)object2);
        object2 = this.a.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public void b(int n10) {
        Object object = new Object[1];
        Integer n11 = n10;
        object[0] = n11;
        m.a.a.u("onComposing: [progress] = %s", (Object[])object);
        object = VideoCropFragment.n((VideoCropFragment)this.a.a).b;
        Integer n12 = n10;
        ((MutableLiveData)object).setValue(n12);
    }

    public void c(String object) {
        int n10 = 1;
        Uri uri = new Object[n10];
        VideoCropFragment videoCropFragment = null;
        uri[0] = object;
        m.a.a.e("onComposeCompleted: [outputPath] = %s", (Object[])uri);
        uri = Uri.parse((String)object);
        Context context = this.a.a.getContext();
        Object object2 = this.a.a;
        boolean bl2 = VideoCropFragment.l((VideoCropFragment)object2);
        if (bl2) {
            object = new Object[]{};
            m.a.a.e("onComposeCompleted: [outputPath] = clear crop", object);
            s1.i(uri);
            return;
        }
        if (context != null) {
            object2 = VideoCropFragment.v(this.a.a);
            ((ObservableBoolean)object2).set(false);
            videoCropFragment = this.a.a;
            VideoCropFragment.A(videoCropFragment, (String)object);
            t6.a(context, uri);
            object = this.a.a;
            VideoCropFragment.o((VideoCropFragment)object);
        }
    }
}

