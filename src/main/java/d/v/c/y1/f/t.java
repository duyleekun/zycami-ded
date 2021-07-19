/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.y1.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.music.MusicData;
import com.zhiyun.cama.data.database.model.music.MusicFile;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.util.DownloadState;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.v0.d;
import d.v.c.v0.q.b;
import d.v.c.v0.q.c;
import d.v.c.y1.f.h;
import d.v.c.y1.f.i;
import d.v.c.y1.f.q;
import d.v.c.y1.f.t$a;
import d.v.e.j.a;
import d.v.e.l.s1;
import d.v.j.g.d0.d$a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class t {
    private final d.v.c.v0.v.d.b a;
    private b b;
    private d$a c;

    public t() {
        Object object = new b();
        this.b = object;
        this.a = object = d.c();
        this.c = object = h.a;
        this.b.b((d$a)object);
    }

    private q b(MusicData object, boolean bl2, String object2) {
        long l10;
        long l11;
        long l12;
        int n10;
        q q10 = new q();
        d.v.c.k1.b.a a10 = new d.v.c.k1.b.a();
        Object object3 = ((ResourceData)object).showLabel();
        a10 = a10.v((String)object3);
        object3 = ((MusicData)object).getThumb();
        a10 = a10.q((String)object3);
        object3 = ((MusicData)object).getAlbumId();
        int n11 = 1;
        int n12 = 0;
        if (object3 != null && (n10 = (l12 = (l11 = ((Long)(object3 = ((MusicData)object).getAlbumId())).longValue()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(object3 = ((MusicData)object).getHash())) ? 1 : 0)) != 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object3 = null;
        }
        a10 = a10.m(n10 != 0);
        object2 = a10.s((String)object2);
        int n13 = ((MusicData)object).getRequiredPrime();
        if (n13 != n11) {
            n11 = 0;
        }
        object2 = ((d.v.c.k1.b.a)object2).t(n11 != 0);
        long l13 = ((MusicData)object).getDuration();
        object2 = ((d.v.c.k1.b.a)object2).o(l13);
        l13 = ((MusicData)object).getSize();
        object2 = ((d.v.c.k1.b.a)object2).u(l13);
        l13 = ((ResourceData)object).getResId();
        object = ((d.v.c.k1.b.a)object2).r(l13);
        object = q10.K((d.v.c.k1.b.a)object);
        object2 = ((c)object).B(bl2);
        if (bl2) {
            n12 = 100;
        }
        ((c)object2).C(n12);
        return object;
    }

    public static /* synthetic */ void c(Long object, q q10, DownloadEvent downloadEvent) {
        if (downloadEvent != null) {
            object = t$a.a;
            DownloadState downloadState = downloadEvent.getDownloadState();
            int n10 = downloadState.ordinal();
            Object object2 = object[n10];
            switch (object2) {
                default: {
                    break;
                }
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    object2 = false;
                    object = null;
                    q10.C(0);
                    q10.B(false);
                    break;
                }
                case 2: {
                    q10.C(100);
                    object2 = true;
                    q10.B((boolean)object2);
                    break;
                }
                case 1: {
                    object2 = downloadEvent.getProgress();
                    q10.C((int)object2);
                }
            }
        }
    }

    public static /* synthetic */ q d(MusicInfoData object) {
        q q10 = new q();
        d.v.c.k1.b.a a10 = new d.v.c.k1.b.a();
        String string2 = ((MusicInfoData)object).getMusicName();
        a10 = a10.v(string2);
        string2 = ((MusicInfoData)object).getMusicPath();
        a10 = a10.s(string2);
        string2 = ((MusicInfoData)object).getMusicImage();
        a10 = a10.q(string2);
        boolean bl2 = s1.q(((MusicInfoData)object).getMusicPath());
        boolean bl3 = true;
        a10 = a10.m(bl2 ^= bl3);
        long l10 = (int)((MusicInfoData)object).getDuration();
        a10 = a10.o(l10);
        l10 = ((MusicInfoData)object).getSize();
        object = a10.u(l10).t(false);
        q10.K((d.v.c.k1.b.a)object);
        q10.B(bl3).C(100);
        return q10;
    }

    public void a(Context context, long l10, q q10) {
        q10.C(0);
        this.b.J(context, l10, q10);
    }

    public LiveData e(long l10) {
        return this.a.h(true, 1, 1000, l10, l10);
    }

    public LiveData f() {
        d.v.c.v0.v.d.b b10 = this.a;
        int n10 = 1;
        return b10.e(n10 != 0, n10, 1000);
    }

    public LiveData g() {
        return this.a.q();
    }

    public void h() {
        d$a d$a = this.c;
        if (d$a != null) {
            b b10 = this.b;
            b10.w(d$a);
        }
    }

    public List i(List stream) {
        boolean bl2 = d.v.j.b.f((List)((Object)stream));
        if (bl2) {
            return Collections.emptyList();
        }
        stream = stream.stream();
        Object object = i.a;
        stream = stream.map(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    public List j(List iterator2, List list) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        boolean bl2;
        boolean bl3;
        boolean bl4 = d.v.j.b.f((List)((Object)iterator2));
        if (bl4) {
            return Collections.emptyList();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object5 = new ArrayList();
        object5.clear();
        iterator2 = iterator2.iterator();
        while (true) {
            long l10;
            bl3 = iterator2.hasNext();
            bl2 = true;
            if (!bl3) break;
            object4 = (MusicData)iterator2.next();
            long l11 = ((ResourceData)object4).getResId();
            long l12 = l11 - (l10 = 0L);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 < 0) {
                object2 = EditConfig$ResourceType.MUSIC;
                object = ((MusicData)object4).getPath();
                object = TemEditorConfig.c((a)object2, (String)object);
                ((MusicData)object4).setPath((String)object);
                object = ((MusicData)object4).getThumb();
                object2 = TemEditorConfig.c((a)object2, (String)object);
                ((MusicData)object4).setThumb((String)object2);
                object2 = ((MusicData)object4).getPath();
                object4 = this.b((MusicData)object4, bl2, (String)object2);
                arrayList.add(object4);
                continue;
            }
            object5.add(object4);
        }
        boolean bl5 = object5.isEmpty();
        if (!bl5) {
            boolean bl6;
            iterator2 = object5.iterator();
            while (bl6 = iterator2.hasNext()) {
                object5 = (MusicData)iterator2.next();
                object4 = ((MusicData)object5).getHash();
                object3 = 0;
                object2 = null;
                boolean bl7 = d.v.j.b.f(list);
                if (!bl7) {
                    boolean bl8;
                    object = list.iterator();
                    while (bl8 = object.hasNext()) {
                        boolean bl9;
                        MusicFile musicFile = (MusicFile)object.next();
                        String string2 = musicFile.getHash();
                        boolean bl10 = TextUtils.isEmpty((CharSequence)string2);
                        if (bl10 || (bl10 = TextUtils.isEmpty((CharSequence)object4)) || !(bl9 = ((String)object4).equals(string2))) continue;
                        object2 = ((MusicData)object5).getPath();
                        object3 = ((String)object2).equals(string2 = musicFile.getPath());
                        if (object3 == false) {
                            object2 = this.a;
                            string2 = musicFile.getPath();
                            long l13 = musicFile.getDownloadTimestamp();
                            ((d.v.c.v0.v.d.b)object2).updateMusicPath(string2, (String)object4, l13);
                        }
                        object2 = musicFile;
                    }
                }
                if (object2 != null) {
                    bl3 = bl2;
                } else {
                    bl3 = false;
                    object4 = null;
                }
                object2 = object2 != null ? ((FileData)object2).getPath() : ((MusicData)object5).getPath();
                object5 = this.b((MusicData)object5, bl3, (String)object2);
                arrayList.add(object5);
            }
        }
        return arrayList;
    }
}

