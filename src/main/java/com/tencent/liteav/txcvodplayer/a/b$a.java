/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer.a;

import java.io.Serializable;

public class b$a
implements Serializable {
    public String fileType;
    public String path;
    public Long time;
    public String url;

    public String a() {
        return this.url;
    }

    public void a(Long l10) {
        this.time = l10;
    }

    public void a(String string2) {
        this.url = string2;
    }

    public String b() {
        return this.path;
    }

    public void b(String string2) {
        this.path = string2;
    }

    public Long c() {
        return this.time;
    }

    public void c(String string2) {
        this.fileType = string2;
    }

    public String d() {
        String string2 = this.fileType;
        if (string2 == null && (string2 = this.path) != null) {
            String string3 = "mp4";
            boolean bl2 = string2.endsWith(string3);
            if (bl2) {
                return string3;
            }
            string2 = this.path;
            string3 = "m3u8.sqlite";
            bl2 = string2.endsWith(string3);
            if (bl2) {
                return "m3u8";
            }
        }
        return this.fileType;
    }
}

