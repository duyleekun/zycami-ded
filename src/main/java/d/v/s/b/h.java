/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.v.s.b;

import android.net.Uri;
import com.zhiyun.mediaprovider.data.MediaBean;
import d.v.s.b.g;
import d.v.s.b.g$a;
import java.util.List;

public interface h
extends g {
    public int b(MediaBean var1, g$a var2);

    public int g(Uri var1);

    public int h(MediaBean var1);

    default public int l() {
        return 0;
    }

    public int m(List var1);

    public int p(List var1, g$a var2);

    public int q(Uri[] var1, g$a var2);

    public int t(int var1);

    public int u(int[] var1);

    public int v(Uri[] var1);

    public int z(Uri var1, g$a var2);
}

