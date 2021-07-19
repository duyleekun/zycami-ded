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
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.publish.VideoCropFragment;
import com.zhiyun.cama.publish.VideoCropFragment$c$a;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.t6;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.f.f.a;
import d.v.g0.k$b;
import d.v.v.q.h;

public class VideoCropFragment$c {
    public final /* synthetic */ VideoCropFragment a;

    public VideoCropFragment$c(VideoCropFragment videoCropFragment) {
        this.a = videoCropFragment;
    }

    public void a() {
        ObservableBoolean observableBoolean = VideoCropFragment.v(this.a);
        boolean bl2 = observableBoolean.get();
        if (bl2) {
            VideoCropFragment.w(this.a);
            return;
        }
        NavHostFragment.findNavController(this.a).popBackStack();
    }

    public void b() {
        Object object;
        long l10;
        long l11 = k2.e();
        long l12 = l11 - (l10 = s1.M(object = Uri.parse((String)VideoCropFragment.z(this.a))));
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            Object object3 = this.a.getContext();
            k$b k$b = new k$b((Context)object3);
            k$b = (k$b)k$b.m(2131952617);
            object = d.v.c.n1.a.a;
            k$b = (k$b)k$b.v(2131952621, (a)object);
            object3 = this.a.getChildFragmentManager();
            k$b.D((FragmentManager)object3);
            return;
        }
        this.c();
        VideoCropFragment.v(this.a).set(true);
        VideoCropFragment.m(this.a, false);
        String string2 = VideoCropFragment.z(this.a);
        object = k2.A(t6.f()).toString();
        long l13 = VideoCropFragment.p(this.a) * 1000;
        long l14 = VideoCropFragment.r(this.a) * 1000;
        VideoCropFragment$c$a videoCropFragment$c$a = new VideoCropFragment$c$a(this);
        h.j(string2, (String)object, l13, l14, videoCropFragment$c$a);
    }

    public void c() {
        VideoCropFragment.k((VideoCropFragment)this.a).i.E();
        VideoCropFragment.k((VideoCropFragment)this.a).e.setVisibility(0);
        VideoCropFragment.x(this.a);
    }

    public void d() {
        Object object = this.a;
        boolean bl2 = VideoCropFragment.t((VideoCropFragment)object);
        if (bl2) {
            object = VideoCropFragment.k((VideoCropFragment)this.a).i;
            ((ExoVideoView)object).start();
        } else {
            object = VideoCropFragment.k((VideoCropFragment)this.a).i;
            VideoCropFragment videoCropFragment = this.a;
            int bl3 = VideoCropFragment.p(videoCropFragment);
            ((ExoVideoView)object).c(bl3);
            VideoCropFragment.k((VideoCropFragment)this.a).i.start();
            object = this.a;
            boolean bl4 = true;
            VideoCropFragment.u((VideoCropFragment)object, bl4);
        }
        VideoCropFragment.k((VideoCropFragment)this.a).e.setVisibility(8);
        VideoCropFragment.y(this.a);
    }
}

