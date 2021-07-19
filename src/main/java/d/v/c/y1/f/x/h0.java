/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.x;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import d.v.c.w0.wb;
import d.v.c.y1.f.q;
import d.v.f.d.b;
import d.v.f.d.b$b;

public class h0
extends b {
    private MusicLocalImportViewModel g;

    public h0(LifecycleOwner lifecycleOwner, MusicLocalImportViewModel musicLocalImportViewModel) {
        super(lifecycleOwner, musicLocalImportViewModel);
        this.g = musicLocalImportViewModel;
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (wb)viewDataBinding;
        object = (q)this.d().get(n10);
        ((wb)viewDataBinding).C((q)object);
        object = n10;
        ((wb)viewDataBinding).D((Integer)object);
        object = this.g;
        ((wb)viewDataBinding).B((MusicLocalImportViewModel)object);
    }

    public int e(int n10) {
        return 2131558642;
    }
}

