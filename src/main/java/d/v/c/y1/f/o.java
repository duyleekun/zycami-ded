/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 */
package d.v.c.y1.f;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.database.model.music.MusicBeatData;
import com.zhiyun.editorsdk.voice.AudioWaveUseCase;
import d.v.c.y1.f.o$a;
import d.v.e.i.h;
import d.v.h.h.b;
import java.util.HashMap;

public class o
extends AndroidViewModel {
    private AudioWaveUseCase a;
    private MutableLiveData b;
    private MutableLiveData c;
    private d.v.c.v0.v.b.b d;
    private b e;

    public o(Application object) {
        super((Application)object);
        super();
        this.b = object;
        super();
        this.c = object;
        super();
        this.a = object;
        object = d.v.c.v0.v.b.b.c();
        this.d = object;
        this.k();
    }

    public static /* synthetic */ MutableLiveData b(o o10) {
        return o10.b;
    }

    private void k() {
        AudioWaveUseCase audioWaveUseCase = this.a;
        o$a o$a = new o$a(this);
        audioWaveUseCase.d(o$a);
    }

    public void c() {
        b b10 = this.e;
        if (b10 == null) {
            return;
        }
        long l10 = b10.f();
        long l11 = this.e.m();
        int n10 = (int)((double)(l10 - l11) * 4.0E-4);
        AudioWaveUseCase audioWaveUseCase = this.a;
        String string2 = this.e.k();
        long l12 = this.e.m();
        long l13 = this.e.f();
        audioWaveUseCase.b(string2, l12, l13, n10);
    }

    public int d() {
        b b10 = this.e;
        if (b10 == null) {
            return -1;
        }
        long l10 = b10.f();
        long l11 = this.e.m();
        return (int)((double)(l10 - l11) * 4.0E-4);
    }

    public MutableLiveData e() {
        return this.c;
    }

    public int f() {
        int n10;
        Object object = this.c;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Integer)this.c.getValue();
            n10 = (Integer)object;
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public HashMap g() {
        Cloneable cloneable = this.e;
        if (cloneable == null) {
            cloneable = new Cloneable();
            return cloneable;
        }
        d.v.c.v0.v.b.b b10 = this.d;
        cloneable = ((b)cloneable).k();
        if ((cloneable = b10.getMusicBeatDataByPath((String)((Object)cloneable))) == null) {
            cloneable = new Cloneable();
            return cloneable;
        }
        return ((MusicBeatData)((Object)cloneable)).getBeatMaps();
    }

    public long i(int n10) {
        return (long)((double)n10 / 4.0E-4);
    }

    public MutableLiveData j() {
        return this.b;
    }

    public void l(HashMap hashMap) {
        Object object = this.e;
        if (object == null) {
            return;
        }
        d.v.c.v0.v.b.b b10 = this.d;
        object = ((b)object).k();
        b10.a((String)object, hashMap);
    }

    public void m(int n10) {
        MutableLiveData mutableLiveData = this.c;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public void n(b b10) {
        this.e = b10;
    }
}

