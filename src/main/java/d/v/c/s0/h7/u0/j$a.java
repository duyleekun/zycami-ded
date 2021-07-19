/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.c.s0.h7.u0;

import android.graphics.Bitmap;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import d.v.c.s0.h7.u0.j;
import d.v.c.w0.yh;
import d.v.l.f;
import java.util.Map;

public class j$a
extends f {
    public final /* synthetic */ yh b;
    public final /* synthetic */ Map.Entry c;
    public final /* synthetic */ j d;

    public j$a(j j10, yh yh2, Map.Entry entry) {
        this.d = j10;
        this.b = yh2;
        this.c = entry;
    }

    public void b() {
        StoryProgressBar storyProgressBar = this.b.r;
        int n10 = (Integer)this.c.getKey();
        storyProgressBar.r(n10, null);
    }

    public void e(Bitmap bitmap) {
        StoryProgressBar storyProgressBar = this.b.r;
        int n10 = (Integer)this.c.getKey();
        storyProgressBar.r(n10, bitmap);
    }
}

