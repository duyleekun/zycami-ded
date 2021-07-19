/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 */
package com.zhiyun.cama.voice.music;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import d.v.c.y1.f.l;
import d.v.c.y1.f.m;
import d.v.c.y1.f.n;
import d.v.c.y1.f.q;
import d.v.e.i.h;
import d.v.e.l.b2;
import d.v.e.l.f1;
import d.v.e.l.n2;
import d.v.e.l.s1;
import d.v.f.i.g;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.constant.Constable;
import m.a.a;

public class MusicPlayVieModel
extends AndroidViewModel
implements LifecycleObserver {
    private MediaPlayer a;
    private boolean b;
    private MutableLiveData c;
    private MutableLiveData d;
    private Application e;

    public MusicPlayVieModel(Application application) {
        super(application);
        MutableLiveData mutableLiveData;
        Constable constable = -1;
        this.c = mutableLiveData = new MutableLiveData(constable);
        constable = Boolean.FALSE;
        this.d = mutableLiveData = new MutableLiveData(constable);
        this.e = application;
    }

    private /* synthetic */ void e(MediaPlayer mediaPlayer) {
        this.a.start();
        this.b = true;
        this.n();
    }

    private /* synthetic */ void g(MediaPlayer object) {
        object = this.d;
        Boolean bl2 = Boolean.FALSE;
        h.g((MutableLiveData)object, bl2);
    }

    public static /* synthetic */ boolean j(Context context, MediaPlayer mediaPlayer, int n10, int n11) {
        n2.e(g.m(context, 2131952077));
        return false;
    }

    private void onPause() {
        this.m();
    }

    public MutableLiveData b() {
        return this.d;
    }

    public MutableLiveData c() {
        return this.c;
    }

    public int d() {
        int n10;
        Object object = this.c.getValue();
        if (object == null) {
            n10 = -1;
        } else {
            object = (Integer)this.c.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public /* synthetic */ void f(MediaPlayer mediaPlayer) {
        this.e(mediaPlayer);
    }

    public /* synthetic */ void i(MediaPlayer mediaPlayer) {
        this.g(mediaPlayer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void k(Context object, q object2, int n10) {
        int n11;
        Object object3;
        String string2;
        Application application = this.e;
        int n12 = b2.m((Context)application);
        if (n12 == 0 && (n12 = s1.q(string2 = ((q)object3).G().g())) == 0) {
            n2.e(g.m(object, 2131953290));
            return;
        }
        try {
            boolean bl2;
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer == null) {
                MediaPlayer mediaPlayer2;
                this.a = mediaPlayer2 = new MediaPlayer();
            }
            if ((n12 = this.d()) != n11) {
                MutableLiveData mutableLiveData = this.c;
                Object object4 = n11;
                h.g(mutableLiveData, object4);
                object4 = this.a;
                object4.reset();
                n11 = 0;
                object4 = null;
                this.b = false;
                object4 = ((q)object3).G();
                n11 = (int)(((d.v.c.k1.b.a)object4).j() ? 1 : 0);
                if (n11 != 0) {
                    object3 = ((q)object3).G();
                    object3 = ((d.v.c.k1.b.a)object3).g();
                    if ((object3 = f1.f((String)object3)) != null) {
                        MediaPlayer mediaPlayer3 = this.a;
                        FileDescriptor fileDescriptor = object3.getFileDescriptor();
                        long l10 = object3.getStartOffset();
                        long l11 = object3.getLength();
                        mediaPlayer3.setDataSource(fileDescriptor, l10, l11);
                    }
                } else {
                    object3 = ((q)object3).G();
                    object4 = new File((String)(object3 = ((d.v.c.k1.b.a)object3).g()));
                    n11 = (int)(s1.p((File)object4) ? 1 : 0);
                    if (n11 != 0) {
                        object4 = this.a;
                        object4.setDataSource((String)object3);
                    } else {
                        object4 = this.a;
                        object3 = Uri.parse((String)object3);
                        object4.setDataSource(object, (Uri)object3);
                    }
                }
                object3 = this.a;
                object3.prepareAsync();
                object3 = this.a;
                object4 = new m(this);
                object3.setOnPreparedListener((MediaPlayer.OnPreparedListener)object4);
                object3 = this.a;
                object4 = new l(this);
                object3.setOnCompletionListener((MediaPlayer.OnCompletionListener)object4);
                object3 = this.a;
                object4 = new n((Context)object);
                object3.setOnErrorListener((MediaPlayer.OnErrorListener)object4);
            }
            if (!(bl2 = this.b)) {
                return;
            }
            object3 = this.a;
            bl2 = object3.isPlaying();
            if (bl2) {
                object3 = this.a;
                object3.pause();
            } else {
                object3 = this.a;
                object3.start();
            }
            this.n();
            return;
        }
        catch (Exception exception) {
            n11 = 2131952077;
            String string3 = g.m(object, n11);
            n2.e(string3);
            m.a.a.f(exception);
        }
    }

    public void l(int n10) {
        MutableLiveData mutableLiveData = this.c;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public void m() {
        boolean bl2;
        Object object = this.a;
        if (object == null) {
            return;
        }
        int n10 = this.b;
        if (n10 != 0 && (bl2 = object.isPlaying())) {
            object = this.a;
            object.pause();
        } else {
            object = this.c;
            n10 = -1;
            Integer n11 = n10;
            h.g((MutableLiveData)object, n11);
            this.a.release();
            bl2 = false;
            object = null;
            this.a = null;
        }
        this.n();
    }

    public void n() {
        Object object;
        MutableLiveData mutableLiveData = this.d;
        boolean bl2 = this.b;
        if (bl2 && (object = this.a) != null && (bl2 = object.isPlaying())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object = bl2;
        h.g(mutableLiveData, object);
    }

    public void onCleared() {
        super.onCleared();
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}

