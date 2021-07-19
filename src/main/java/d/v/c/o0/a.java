/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View$OnSystemUiVisibilityChangeListener
 */
package d.v.c.o0;

import android.view.View;
import com.zhiyun.cama.album.AlbumActivity;

public final class a
implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ AlbumActivity a;

    public /* synthetic */ a(AlbumActivity albumActivity) {
        this.a = albumActivity;
    }

    public final void onSystemUiVisibilityChange(int n10) {
        this.a.f(n10);
    }
}

