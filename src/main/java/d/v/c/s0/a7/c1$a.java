/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.Handler
 *  android.widget.TextView
 */
package d.v.c.s0.a7;

import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.n0.f$a;
import d.v.c.s0.a7.c1;
import d.v.c.s0.a7.l;
import d.v.c.s0.a7.m;
import d.v.e.j.a;
import d.v.e.j.b;
import d.v.f.i.g;
import d.v.j0.d;
import d.v.j0.d$a;

public class c1$a
extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ c1 a;

    public c1$a(c1 c12) {
        this.a = c12;
    }

    private /* synthetic */ void a(int n10, d d10) {
        c1.v((c1)this.a).g.setCurrentItem(n10);
    }

    private /* synthetic */ void c(int n10) {
        Object object = c1.y(this.a);
        if (object != null) {
            object = c1.y(this.a);
            object.pause();
        }
        object = this.a;
        Object object2 = (f$a)c1.C((c1)object).findViewHolderForLayoutPosition(n10);
        c1.B((c1)object, (f$a)object2);
        object = c1.A(this.a);
        if (object != null) {
            ExoVideoView exoVideoView;
            object = this.a;
            object2 = (ExoVideoView)c1.A((c1)object).itemView.findViewById(2131362404);
            c1.z((c1)object, (ExoVideoView)object2);
            object = c1.y(this.a);
            int n11 = 0;
            object2 = null;
            object.setLoopPlay(false);
            c1.y(this.a).F(false);
            c1.y(this.a).L(false);
            c1.y(this.a).setMediaControllerDefault(false);
            c1.y(this.a).A();
            object = c1.y(this.a);
            String[] stringArray = null;
            object.setVolume(0.0f);
            object = c1.y(this.a);
            object.pause();
            int n12 = 1;
            if (n10 == 0) {
                exoVideoView = c1.y(this.a);
                stringArray = new String[n12];
                Object object3 = ResConfig$AppResType.APP_ASSETS;
                int n13 = c1.w();
                String string2 = n13 == 0 ? "hitchcock_preview_far_away.mp4" : "hitchcock_preview_near.mp4";
                stringArray[0] = object3 = b.h((a)object3, string2);
                exoVideoView.setVideoPath(stringArray);
                n11 = n12;
            } else if (n10 == n12) {
                exoVideoView = c1.y(this.a);
                object = new String[n12];
                stringArray = ResConfig$AppResType.APP_ASSETS;
                int n14 = c1.w();
                String string3 = n14 == 0 ? "hitchcock_help_faraway.mp4" : "hitchcock_help_near.mp4";
                object[0] = stringArray = b.h((a)stringArray, string3);
                exoVideoView.setVideoPath((String)object);
            }
            c1.y(this.a).start();
            exoVideoView = c1.y(this.a);
            object = new m(this, n11);
            exoVideoView.setOnCompletionListener((d$a)object);
        }
    }

    public /* synthetic */ void b(int n10, d d10) {
        this.a(n10, d10);
    }

    public /* synthetic */ void d(int n10) {
        this.c(n10);
    }

    public void onPageScrollStateChanged(int n10) {
        super.onPageScrollStateChanged(n10);
    }

    public void onPageScrolled(int n10, float f10, int n11) {
        c1 c12 = this.a;
        c1.u(c12);
        super.onPageScrolled(n10, f10, n11);
        TextView textView = (TextView)c1.v((c1)this.a).g.getRootView().findViewById(2131363530);
        String string2 = g.o(this.a.getResources(), 2131952323);
        textView.setText((CharSequence)string2);
        textView = c1.v((c1)this.a).g.getRootView();
        n11 = 2131363528;
        textView = (TextView)textView.findViewById(n11);
        string2 = this.a.getResources();
        int n12 = c1.w();
        n10 = n12 == 0 ? (n10 == 0 ? 2131952334 : 2131952333) : (n10 == 0 ? 2131952325 : 2131952324);
        String string3 = g.o((Resources)string2, n10);
        textView.setText((CharSequence)string3);
    }

    public void onPageSelected(int n10) {
        super.onPageSelected(n10);
        c1.x(this.a).R(n10);
        Handler handler = new Handler();
        l l10 = new l(this, n10);
        handler.postDelayed((Runnable)l10, 150L);
    }
}

