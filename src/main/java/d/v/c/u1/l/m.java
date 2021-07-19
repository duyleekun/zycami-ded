/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.l;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.template.PlayState;
import com.zhiyun.editortemplate.util.DownloadState;
import d.v.c.u1.l.j;
import d.v.c.u1.l.k;
import d.v.e.i.g;
import d.v.e.i.h;

public class m
extends ViewModel {
    private MutableLiveData a;
    private LiveData b;
    public LiveData c;
    private MutableLiveData d;

    public m() {
        LiveData liveData;
        Object object = PlayState.STATE_IDLE;
        this.a = liveData = new MutableLiveData(object);
        object = j.a;
        liveData = Transformations.distinctUntilChanged(Transformations.map(liveData, (Function)object));
        this.b = liveData;
        liveData = this.a;
        object = k.a;
        liveData = g.a(liveData, (Function)object);
        this.c = liveData;
        this.d = liveData = new MutableLiveData();
    }

    public static /* synthetic */ PlayState i(PlayState playState) {
        return playState;
    }

    public DownloadState b() {
        return (DownloadState)((Object)this.d.getValue());
    }

    public LiveData c() {
        return this.d;
    }

    public PlayState d() {
        return (PlayState)((Object)this.a.getValue());
    }

    public LiveData e() {
        return this.a;
    }

    public LiveData f() {
        return this.b;
    }

    public boolean g() {
        return (Boolean)this.b.getValue();
    }

    public void j(DownloadState downloadState) {
        h.d(this.d, (Object)downloadState);
    }

    public void k(PlayState playState) {
        h.e(this.a, (Object)playState);
    }

    public void onCleared() {
        super.onCleared();
    }
}

