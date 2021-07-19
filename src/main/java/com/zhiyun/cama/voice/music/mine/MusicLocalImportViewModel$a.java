/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.voice.music.mine;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import com.zhiyun.mediaprovider.data.AudioBean;
import com.zhiyun.mediaprovider.data.MediaBean;
import d.v.c.k1.b.a;
import d.v.c.y1.f.q;
import d.v.e.i.h;
import d.v.s.b.i$a;

public class MusicLocalImportViewModel$a
implements i$a {
    public final /* synthetic */ MusicLocalImportViewModel a;

    public MusicLocalImportViewModel$a(MusicLocalImportViewModel musicLocalImportViewModel) {
        this.a = musicLocalImportViewModel;
    }

    public void a(MediaBean object) {
        Object object2;
        int n10;
        int n11 = ((MediaBean)object).getType();
        if (n11 != (n10 = 1)) {
            return;
        }
        Object object3 = ((MediaBean)(object = (AudioBean)object)).getDisplayName();
        if (object3 != null && ((n11 = (int)(((String)(object3 = ((MediaBean)object).getDisplayName())).endsWith((String)(object2 = "mp3")) ? 1 : 0)) || (n11 = (int)(((String)(object3 = ((MediaBean)object).getDisplayName())).endsWith((String)(object2 = "aac")) ? 1 : 0)))) {
            object3 = new a();
            n10 = ((MediaBean)object).getId();
            object2 = ((a)object3).p(n10);
            Object object4 = ((AudioBean)object).getTitle();
            object2 = ((a)object2).v((String)object4);
            object4 = ((MediaBean)object).getDisplayName();
            object2 = ((a)object2).n((String)object4);
            long l10 = ((AudioBean)object).getDuration();
            long l11 = 1000L;
            object2 = ((a)object2).o(l10 *= l11);
            l10 = ((MediaBean)object).getSize();
            object2 = ((a)object2).u(l10);
            object4 = ((AudioBean)object).getArtist();
            object2 = ((a)object2).l((String)object4);
            object4 = ((MediaBean)object).getUri().toString();
            object2 = ((a)object2).s((String)object4);
            object4 = ((AudioBean)object).getAlbumArtUri();
            ((a)object2).q((String)object4);
            object2 = this.a;
            object = ((MediaBean)object).getPath();
            boolean bl2 = MusicLocalImportViewModel.o((MusicLocalImportViewModel)object2, (a)object3, (String)object);
            object2 = this.a;
            n10 = (int)(MusicLocalImportViewModel.p((MusicLocalImportViewModel)object2, (a)object3) ? 1 : 0);
            object4 = MusicLocalImportViewModel.r(this.a);
            q q10 = new q();
            object3 = q10.K((a)object3).L(bl2).J(n10 != 0);
            object4.add(object3);
            if (!bl2) {
                object = this.a;
                MusicLocalImportViewModel.s((MusicLocalImportViewModel)object);
            }
        }
    }

    public void b() {
        MusicLocalImportViewModel.t(this.a);
        MutableLiveData mutableLiveData = MusicLocalImportViewModel.u(this.a);
        Object object = MusicLocalImportViewModel.r(this.a);
        h.g(mutableLiveData, object);
        mutableLiveData = MusicLocalImportViewModel.v(this.a);
        object = Boolean.FALSE;
        h.g(mutableLiveData, object);
    }

    public void c(Exception exception) {
        h.g(MusicLocalImportViewModel.w(this.a), exception);
    }
}

