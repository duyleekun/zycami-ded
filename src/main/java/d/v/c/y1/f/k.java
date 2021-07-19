/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class k
implements Observer {
    public final /* synthetic */ MusicListViewModel a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicBoolean d;

    public /* synthetic */ k(MusicListViewModel musicListViewModel, AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean) {
        this.a = musicListViewModel;
        this.b = atomicReference;
        this.c = atomicReference2;
        this.d = atomicBoolean;
    }

    public final void onChanged(Object object) {
        MusicListViewModel musicListViewModel = this.a;
        AtomicReference atomicReference = this.b;
        AtomicReference atomicReference2 = this.c;
        AtomicBoolean atomicBoolean = this.d;
        object = (List)object;
        musicListViewModel.z(atomicReference, atomicReference2, atomicBoolean, (List)object);
    }
}

