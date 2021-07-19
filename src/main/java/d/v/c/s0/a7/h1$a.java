/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.Handler
 *  android.view.View
 *  android.widget.TextView
 */
package d.v.c.s0.a7;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.n0.f$a;
import d.v.c.s0.a7.e0;
import d.v.c.s0.a7.h1;
import d.v.c.s0.s6;
import d.v.e.j.a;
import d.v.e.j.b;
import d.v.f.i.g;

public class h1$a
extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ s6 a;
    public final /* synthetic */ h1 b;

    public h1$a(h1 h12, s6 s62) {
        this.b = h12;
        this.a = s62;
    }

    private /* synthetic */ void a(int n10) {
        int n11;
        String[] stringArray = h1.x(this.b);
        if (stringArray != null) {
            stringArray = h1.x(this.b);
            stringArray.pause();
        }
        if (n10 == (n11 = 1)) {
            Object object = this.b;
            Object object2 = h1.B((h1)object);
            Object object3 = (f$a)((RecyclerView)object2).findViewHolderForLayoutPosition(n10);
            h1.A((h1)object, (f$a)object3);
            object3 = h1.z(this.b);
            if (object3 != null) {
                object3 = this.b;
                object = (ExoVideoView)h1.z((h1)object3).itemView.findViewById(2131362404);
                h1.y((h1)object3, (ExoVideoView)object);
                h1.x(this.b).setLoopPlay(n11 != 0);
                object3 = h1.x(this.b);
                object = null;
                ((ExoVideoView)object3).F(false);
                h1.x(this.b).L(false);
                h1.x(this.b).setMediaControllerDefault(false);
                h1.x(this.b).A();
                h1.x(this.b).setVolume(0.0f);
                object3 = h1.x(this.b);
                stringArray = new String[n11];
                object2 = ResConfig$AppResType.APP_ASSETS;
                String string2 = "panorama_help.mp4";
                stringArray[0] = object2 = d.v.e.j.b.h((a)object2, string2);
                ((ExoVideoView)object3).setVideoPath(stringArray);
                object3 = h1.x(this.b);
                ((ExoVideoView)object3).start();
            }
        }
    }

    public /* synthetic */ void b(int n10) {
        this.a(n10);
    }

    public void onPageScrollStateChanged(int n10) {
        super.onPageScrollStateChanged(n10);
        h1.w(this.b, true);
    }

    public void onPageScrolled(int n10, float f10, int n11) {
        h1 h12 = this.b;
        h1.u(h12);
        super.onPageScrolled(n10, f10, n11);
        View view = h1.v((h1)this.b).f.getRootView();
        n11 = 2131363528;
        view = (TextView)view.findViewById(n11);
        Resources resources = this.b.getResources();
        n10 = n10 == 0 ? 2131952645 : 2131952365;
        String string2 = g.o(resources, n10);
        view.setText((CharSequence)string2);
    }

    public void onPageSelected(int n10) {
        super.onPageSelected(n10);
        this.a.P(n10);
        Handler handler = new Handler();
        e0 e02 = new e0(this, n10);
        handler.postDelayed((Runnable)e02, 150L);
    }
}

