/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.e;
import com.xiaomi.push.ek$b;
import com.xiaomi.push.ek$e;
import com.xiaomi.push.fl;
import com.xiaomi.push.fq;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.be;
import com.xiaomi.push.t;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class fn {
    private int a;
    private fq a;
    private OutputStream a;
    public ByteBuffer a;
    private Adler32 a;
    private byte[] a;
    private int b;
    private ByteBuffer b;

    public fn(OutputStream object, fq fq2) {
        int n10;
        Object object2 = ByteBuffer.allocate(2048);
        this.a = object2;
        object2 = ByteBuffer.allocate(4);
        this.b = object2;
        this.a = object2 = new Adler32();
        this.a = object2 = new BufferedOutputStream((OutputStream)object);
        this.a = fq2;
        object = TimeZone.getDefault();
        this.a = n10 = ((TimeZone)object).getRawOffset() / 3600000;
        boolean bl2 = ((TimeZone)object).useDaylightTime();
        this.b = (int)(bl2 ? 1 : 0);
    }

    public int a(fl object) {
        int n10;
        int n11 = ((fl)object).c();
        int n12 = 32768;
        String string2 = null;
        if (n11 > n12) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Blob size=");
            stringBuilder.append(n11);
            stringBuilder.append(" should be less than ");
            stringBuilder.append(n12);
            stringBuilder.append(" Drop blob chid=");
            n11 = ((fl)object).a();
            stringBuilder.append(n11);
            stringBuilder.append(" id=");
            object = ((fl)object).e();
            stringBuilder.append((String)object);
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            return 0;
        }
        Object object2 = this.a;
        ((ByteBuffer)object2).clear();
        n12 = n11 + 8;
        int n13 = 4;
        Object object3 = this.a;
        int n14 = ((Buffer)object3).capacity();
        if ((n12 += n13) > n14 || (n14 = ((Buffer)(object3 = this.a)).capacity()) > (n10 = 4096)) {
            object2 = ByteBuffer.allocate(n12);
            this.a = object2;
        }
        this.a.putShort((short)-15618);
        this.a.putShort((short)5);
        this.a.putInt(n11);
        object2 = this.a;
        n12 = ((Buffer)object2).position();
        object3 = this.a;
        object3 = ((fl)object).a((ByteBuffer)object3);
        this.a = object3;
        object3 = ((fl)object).a();
        Object object4 = "CONN";
        n14 = (int)(((String)object4).equals(object3) ? 1 : 0);
        if (n14 == 0) {
            object3 = this.a;
            if (object3 == null) {
                object3 = this.a.a();
                this.a = (byte[])object3;
            }
            object3 = this.a;
            object4 = this.a.array();
            boolean bl2 = true;
            ay.a((byte[])object3, (byte[])object4, bl2, n12, n11);
        }
        this.a.reset();
        Object object5 = this.a;
        object2 = this.a.array();
        n14 = this.a.position();
        ((Adler32)object5).update((byte[])object2, 0, n14);
        n11 = (int)this.a.getValue();
        this.b.putInt(0, n11);
        object5 = this.a;
        object2 = this.a.array();
        n14 = this.a.position();
        ((OutputStream)object5).write((byte[])object2, 0, n14);
        object5 = this.a;
        object2 = this.b.array();
        ((OutputStream)object5).write((byte[])object2, 0, n13);
        this.a.flush();
        n11 = this.a.position() + n13;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("[Slim] Wrote {cmd=");
        string2 = ((fl)object).a();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(";chid=");
        int n15 = ((fl)object).a();
        ((StringBuilder)object2).append(n15);
        ((StringBuilder)object2).append(";len=");
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append("}");
        com.xiaomi.channel.commonutils.logger.b.c(((StringBuilder)object2).toString());
        return n11;
    }

    public void a() {
        Object object = new ek$e();
        int n10 = 106;
        ((ek$e)object).a(n10);
        String string2 = Build.MODEL;
        ((ek$e)object).a(string2);
        String string3 = t.a();
        ((ek$e)object).b(string3);
        string3 = be.a();
        ((ek$e)object).c(string3);
        int n11 = 39;
        ((ek$e)object).b(n11);
        String string4 = this.a.b();
        ((ek$e)object).d(string4);
        string4 = this.a.a();
        ((ek$e)object).e(string4);
        string4 = Locale.getDefault().toString();
        ((ek$e)object).f(string4);
        int n12 = Build.VERSION.SDK_INT;
        ((ek$e)object).c(n12);
        Object object2 = this.a.a().a();
        if (object2 != null) {
            object2 = ek$b.a((byte[])object2);
            ((ek$e)object).a((ek$b)object2);
        }
        object2 = new fl;
        ((fl)object2)();
        ((fl)object2).a(0);
        ((fl)object2).a("CONN", null);
        ((fl)object2).a(0L, "xiaomi.com", null);
        object = ((e)object).a();
        ((fl)object2).a((byte[])object, null);
        this.a((fl)object2);
        object = new StringBuilder();
        ((StringBuilder)object).append("[slim] open conn: andver=");
        ((StringBuilder)object).append(n12);
        ((StringBuilder)object).append(" sdk=");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(" hash=");
        string3 = be.a();
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(" tz=");
        n11 = this.a;
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(":");
        n11 = this.b;
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(" Model=");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" os=");
        string2 = Build.VERSION.INCREMENTAL;
        ((StringBuilder)object).append(string2);
        com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
    }

    public void b() {
        fl fl2 = new fl();
        fl2.a("CLOSE", null);
        this.a(fl2);
        this.a.close();
    }
}

