/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.y1.f.v;

import android.view.View;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;
import d.v.c.y1.f.v.i;

public class i$a {
    public final /* synthetic */ i a;

    public i$a(i i10) {
        this.a = i10;
    }

    public void a(View object) {
        this.a.i();
        object = i.w(this.a);
        if (object != null) {
            object = i.w(this.a);
            ((MusicPlayVieModel)object).m();
        }
    }

    public void b() {
        this.c();
        i.x((i)this.a).e.e();
        i.y(this.a).g(false);
    }

    public void c() {
        MusicListViewModel musicListViewModel = i.w(this.a);
        long l10 = i.z(this.a);
        musicListViewModel.u(l10);
    }
}

