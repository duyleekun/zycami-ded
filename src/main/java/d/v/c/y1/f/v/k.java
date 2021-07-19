/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.v;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.data.database.model.music.AlbumData;
import d.v.c.w0.sb;
import d.v.c.y1.f.v.k$a;
import d.v.c.y1.f.v.l;
import d.v.f.d.b;
import d.v.f.d.b$b;

public class k
extends b {
    public k(LifecycleOwner lifecycleOwner, l l10) {
        k$a k$a = new k$a();
        super(lifecycleOwner, l10, k$a);
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (sb)viewDataBinding;
        object = (AlbumData)this.d().get(n10);
        ((sb)viewDataBinding).z((AlbumData)object);
    }

    public int e(int n10) {
        return 2131558640;
    }
}

