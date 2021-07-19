/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.b;

import com.zhiyun.cama.data.database.model.music.MusicBeatData;
import d.v.c.v0.v.b.a;
import d.v.c.v0.v.b.b$a;
import d.v.c.v0.v.c.s;
import java.util.HashMap;

public class b
implements a {
    private s a;

    public b() {
        s s10;
        this.a = s10 = s.p();
    }

    public static b c() {
        return b$a.a();
    }

    public void a(String string2, HashMap hashMap) {
        this.a.q0(string2, hashMap);
    }

    public void b(String string2) {
        this.a.i(string2);
    }

    public MusicBeatData getMusicBeatDataByPath(String string2) {
        return this.a.q(string2);
    }

    public void insertMusicBeatData(MusicBeatData musicBeatData) {
        this.a.H(musicBeatData);
    }
}

