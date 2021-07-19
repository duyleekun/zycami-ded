/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import d.v.j.e.h.k;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class j
implements Observer {
    public final /* synthetic */ MusicListViewModel a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicReference d;

    public /* synthetic */ j(MusicListViewModel musicListViewModel, AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.a = musicListViewModel;
        this.b = atomicBoolean;
        this.c = atomicReference;
        this.d = atomicReference2;
    }

    public final void onChanged(Object object) {
        MusicListViewModel musicListViewModel = this.a;
        AtomicBoolean atomicBoolean = this.b;
        AtomicReference atomicReference = this.c;
        AtomicReference atomicReference2 = this.d;
        object = (k)object;
        musicListViewModel.x(atomicBoolean, atomicReference, atomicReference2, (k)object);
    }
}

