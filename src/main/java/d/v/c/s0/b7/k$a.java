/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 */
package d.v.c.s0.b7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.data.CameraSet$HitchcockGuide;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.b7.k;
import d.v.c.s0.s6;
import d.v.e.j.b;
import d.v.e.l.o1;

public class k$a {
    public final /* synthetic */ k a;

    public k$a(k k10) {
        this.a = k10;
    }

    private void c(boolean bl2) {
        Object object;
        if (bl2) {
            object = k.j(this.a);
            ((DynamicZoomViewModel)object).P();
        } else {
            object = k.j(this.a);
            ((DynamicZoomViewModel)object).Q();
        }
        k.k(this.a).pause();
        object = k.i((k)this.a).c.g;
        Context context = this.a.requireContext();
        int n10 = bl2 ? 2131231021 : 2131231022;
        context = o1.m(context, n10);
        object.setImageDrawable((Drawable)context);
        object = k.i((k)this.a).c.g;
        context = null;
        object.setVisibility(0);
        object = k.k(this.a);
        n10 = 1;
        String[] stringArray = new String[n10];
        ResConfig$AppResType resConfig$AppResType = ResConfig$AppResType.APP_ASSETS;
        String string2 = bl2 ? "hitchcock_preview_far_away.mp4" : "hitchcock_preview_near.mp4";
        stringArray[0] = string2 = b.h(resConfig$AppResType, string2);
        ((ExoVideoView)object).setVideoPath(stringArray);
        k.k(this.a).start();
    }

    public void a() {
        Object object = k.h(this.a);
        boolean bl2 = ((s6)object).k();
        if (!bl2) {
            object = k.h((k)this.a).q;
            CameraSet$HitchcockGuide cameraSet$HitchcockGuide = CameraSet$HitchcockGuide.START;
            ((MutableLiveData)object).setValue((Object)cameraSet$HitchcockGuide);
        }
        k.i((k)this.a).c.getRoot().setVisibility(4);
        k.j(this.a).n();
        k.j(this.a).N(false);
        k.k(this.a).J();
    }

    public void b() {
        this.c(true);
    }

    public void d() {
        this.c(false);
    }
}

