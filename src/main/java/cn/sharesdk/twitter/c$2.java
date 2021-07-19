/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.twitter;

import cn.sharesdk.twitter.MappedFileReader;
import cn.sharesdk.twitter.UpLoadViewCallBack;
import cn.sharesdk.twitter.c;

public class c$2
implements UpLoadViewCallBack {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ c c;

    public c$2(c c10, String string2, long l10) {
        this.c = c10;
        this.a = string2;
        this.b = l10;
    }

    public void onResule(String object) {
        object = this.c;
        Object object2 = cn.sharesdk.twitter.c.a((c)object);
        if ((object = (Object)cn.sharesdk.twitter.c.a((c)object, (MappedFileReader)object2)) != null) {
            String string2 = MappedFileReader.byteToBase64((byte[])object);
            object2 = this.c;
            boolean bl2 = true;
            String string3 = this.a;
            long l10 = this.b;
            cn.sharesdk.twitter.c.a((c)object2, string2, bl2, this, string3, l10);
        } else {
            object = cn.sharesdk.twitter.c.a(this.c);
            if (object != null) {
                object = cn.sharesdk.twitter.c.a(this.c);
                ((MappedFileReader)object).close();
            }
        }
    }
}

