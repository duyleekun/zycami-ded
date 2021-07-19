/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.af;
import com.xiaomi.push.ek$f;
import com.xiaomi.push.fl;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.fq;
import com.xiaomi.push.fs;
import com.xiaomi.push.gj;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ay;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class fm {
    private fo a;
    private fq a;
    private InputStream a;
    private ByteBuffer a;
    private Adler32 a;
    private volatile boolean a;
    private byte[] a;
    private ByteBuffer b;

    public fm(InputStream object, fq fq2) {
        Object object2 = ByteBuffer.allocate(2048);
        this.a = object2;
        object2 = ByteBuffer.allocate(4);
        this.b = object2;
        this.a = object2 = new Adler32();
        this.a = object2 = new BufferedInputStream((InputStream)object);
        this.a = fq2;
        this.a = object = new fo();
    }

    /*
     * Enabled aggressive block sorting
     */
    private ByteBuffer a() {
        Object object;
        block6: {
            int n10;
            ByteBuffer byteBuffer;
            Object object2;
            Object object3;
            int n11;
            int n12;
            int n13;
            Object object4;
            int n14;
            Object object5;
            int n15;
            block9: {
                block8: {
                    int n16;
                    block7: {
                        this.a.clear();
                        object = this.a;
                        this.a((ByteBuffer)object, 8);
                        object = this.a;
                        n15 = 0;
                        object5 = null;
                        n14 = ((ByteBuffer)object).getShort(0);
                        object4 = this.a;
                        n13 = ((ByteBuffer)object4).getShort(2);
                        n12 = -15618;
                        if (n14 != n12 || n13 != (n14 = 5)) break block6;
                        object = this.a;
                        n13 = 4;
                        n14 = ((ByteBuffer)object).getInt(n13);
                        ByteBuffer byteBuffer2 = this.a;
                        n12 = byteBuffer2.position();
                        n11 = 32768;
                        if (n14 > n11) {
                            object = new IOException("Blob size too large");
                            throw object;
                        }
                        n11 = n14 + 4;
                        object3 = this.a;
                        n16 = ((Buffer)object3).remaining();
                        if (n11 <= n16) break block7;
                        n11 = n14 + 2048;
                        object2 = ByteBuffer.allocate(n11);
                        object3 = this.a.array();
                        byteBuffer = this.a;
                        n10 = byteBuffer.arrayOffset();
                        ByteBuffer byteBuffer3 = this.a;
                        int n17 = byteBuffer3.position();
                        ((ByteBuffer)object2).put((byte[])object3, 0, n10 += n17);
                        break block8;
                    }
                    object2 = this.a;
                    n11 = ((Buffer)object2).capacity();
                    if (n11 <= (n16 = 4096) || n14 >= (n11 = 2048)) break block9;
                    object2 = ByteBuffer.allocate(n11);
                    object3 = this.a.array();
                    byteBuffer = this.a;
                    n10 = byteBuffer.arrayOffset();
                    ByteBuffer byteBuffer4 = this.a;
                    int n18 = byteBuffer4.position();
                    ((ByteBuffer)object2).put((byte[])object3, 0, n10 += n18);
                }
                this.a = object2;
            }
            object2 = this.a;
            this.a((ByteBuffer)object2, n14);
            this.b.clear();
            object2 = this.b;
            this.a((ByteBuffer)object2, n13);
            this.b.position(0);
            object4 = this.b;
            n13 = ((ByteBuffer)object4).getInt();
            this.a.reset();
            object2 = this.a;
            object3 = this.a.array();
            byteBuffer = this.a;
            n10 = byteBuffer.position();
            ((Adler32)object2).update((byte[])object3, 0, n10);
            object5 = this.a;
            long l10 = ((Adler32)object5).getValue();
            n15 = (int)l10;
            if (n13 != n15) {
                object = new StringBuilder();
                ((StringBuilder)object).append("CRC = ");
                n15 = (int)this.a.getValue();
                ((StringBuilder)object).append(n15);
                ((StringBuilder)object).append(" and ");
                ((StringBuilder)object).append(n13);
                com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
                object = new IOException("Corrupted Blob bad CRC");
                throw object;
            }
            object5 = this.a;
            if (object5 != null) {
                object4 = this.a.array();
                n11 = 1;
                ay.a((byte[])object5, (byte[])object4, n11 != 0, n12, n14);
            }
            return this.a;
        }
        object = new IOException("Malformed Input");
        throw object;
    }

    private void a(ByteBuffer object, int n10) {
        int n11;
        byte[] byArray;
        InputStream inputStream;
        int n12;
        int n13 = ((Buffer)object).position();
        while ((n12 = (inputStream = this.a).read(byArray = ((ByteBuffer)object).array(), n13, n10)) != (n11 = -1)) {
            n13 += n12;
            if ((n10 -= n12) > 0) continue;
            ((ByteBuffer)object).position(n13);
            return;
        }
        object = new EOFException();
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    private void c() {
        var1_1 = 0;
        var2_2 = null;
        this.a = false;
        var3_3 = this.a();
        var4_6 = var3_3.a();
        var5_7 = "CONN";
        var6_8 = var5_7.equals(var4_6);
        var7_9 = 1;
        if (var6_8) {
            var6_8 = (var3_3 = ek$f.a(var3_3.a())).a();
            if (var6_8) {
                var2_2 = this.a;
                var4_6 = var3_3.a();
                var2_2.a((String)var4_6);
                var1_1 = var7_9;
            }
            if (var6_8 = var3_3.c()) {
                var4_6 = var3_3.a();
                var8_10 = new fl();
                var9_11 = "CONF";
                var8_10.a("SYNC", (String)var9_11);
                var4_6 = var4_6.a();
                var10_12 = 0;
                var11_13 = null;
                var8_10.a((byte[])var4_6, null);
                var4_6 = this.a;
                var4_6.a((fl)var8_10);
            }
            var4_6 = new StringBuilder();
            var8_10 = "[Slim] CONN: host = ";
            var4_6.append((String)var8_10);
            var3_3 = var3_3.b();
            var4_6.append((String)var3_3);
            var3_3 = var4_6.toString();
            com.xiaomi.channel.commonutils.logger.b.a((String)var3_3);
        }
        if (var1_1 != 0) {
            var2_2 = this.a.a();
            this.a = var2_2;
            block21: while ((var1_1 = this.a) == 0) {
                var2_2 = this.a();
                var3_3 = this.a;
                var3_3.c();
                var12_14 = var2_2.a();
                if (var12_14 != var7_9) {
                    var4_6 = " failure:";
                    var8_10 = "; Id=";
                    var11_13 = "[Slim] Parse packet from Blob chid=";
                    var13_15 = 3;
                    var14_16 = 2;
                    if (var12_14 != var14_16) {
                        if (var12_14 != var13_15) {
                            var3_3 = new StringBuilder();
                            var4_6 = "[Slim] unknow blob type ";
                            var3_3.append((String)var4_6);
                            var1_1 = var2_2.a();
                            var3_3.append(var1_1);
                            var2_2 = var3_3.toString();
lbl60:
                            // 2 sources

                            while (true) {
                                com.xiaomi.channel.commonutils.logger.b.a((String)var2_2);
                                continue block21;
                                break;
                            }
                        }
                        try {
                            var3_3 = this.a;
                        }
                        catch (Exception var3_4) {
                            var9_11 = new StringBuilder();
lbl67:
                            // 2 sources

                            while (true) {
                                var9_11.append(var11_13);
                                var10_12 = var2_2.a();
                                var9_11.append(var10_12);
                                var9_11.append((String)var8_10);
                                var2_2 = var2_2.e();
                                var9_11.append((String)var2_2);
                                var9_11.append((String)var4_6);
                                var2_2 = var3_3.getMessage();
                                var9_11.append((String)var2_2);
                                var2_2 = var9_11.toString();
                                ** continue;
                                break;
                            }
                        }
                        var9_11 = var2_2.a();
                        var15_17 = this.a;
                        var3_3 = var3_3.a((byte[])var9_11, (fs)var15_17);
                        var9_11 = this.a;
                        var9_11.b((gj)var3_3);
                        continue;
                    }
                    var16_18 = "SECMSG";
                    var3_3 = var2_2.a();
                    var12_14 = (int)var16_18.equals(var3_3);
                    if (var12_14 != 0 && ((var12_14 = var2_2.a()) == var14_16 || (var12_14 = var2_2.a()) == var13_15) && (var12_14 = (int)TextUtils.isEmpty((CharSequence)(var3_3 = var2_2.b()))) != 0) {
                        try {
                            var12_14 = var2_2.a();
                        }
                        catch (Exception var3_5) {
                            var9_11 = new StringBuilder();
                            ** continue;
                        }
                        var3_3 = var12_14;
                        var3_3 = var3_3.toString();
                        var9_11 = var2_2.g();
                        var15_17 = ap.a();
                        var3_3 = var15_17.a((String)var3_3, (String)var9_11);
                        var9_11 = this.a;
                        var3_3 = var3_3.h;
                        var3_3 = var2_2.a((String)var3_3);
                        var15_17 = this.a;
                        var3_3 = var9_11.a((byte[])var3_3, (fs)var15_17);
                        var9_11 = this.a;
                        var9_11.b((gj)var3_3);
                        continue;
                    }
                }
                var3_3 = this.a;
                var3_3.a((fl)var2_2);
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("[Slim] Invalid CONN");
        var2_2 = new IOException;
        var2_2("Invalid Connection");
        throw var2_2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public fl a() {
        void var2_5;
        ByteBuffer byteBuffer;
        int n10;
        String string2;
        block8: {
            Object object;
            string2 = null;
            try {
                object = this.a();
                n10 = ((Buffer)object).position();
            }
            catch (IOException iOException) {
                n10 = 0;
                byteBuffer = null;
                break block8;
            }
            try {
                ((ByteBuffer)object).flip();
                int n11 = 8;
                ((ByteBuffer)object).position(n11);
                if (n10 == n11) {
                    object = new fp();
                } else {
                    object = ((ByteBuffer)object).slice();
                    object = fl.a((ByteBuffer)object);
                }
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "[Slim] Read {cmd=";
                stringBuilder.append(string3);
                String string4 = ((fl)object).a();
                stringBuilder.append(string4);
                String string5 = ";chid=";
                stringBuilder.append(string5);
                int n12 = ((fl)object).a();
                stringBuilder.append(n12);
                String string6 = ";len=";
                stringBuilder.append(string6);
                stringBuilder.append(n10);
                String string7 = "}";
                stringBuilder.append(string7);
                String string8 = stringBuilder.toString();
                com.xiaomi.channel.commonutils.logger.b.c(string8);
                return object;
            }
            catch (IOException iOException) {}
        }
        if (n10 == 0) {
            byteBuffer = this.a;
            n10 = byteBuffer.position();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Slim] read Blob [");
        byte[] byArray = this.a.array();
        int n13 = 128;
        if (n10 > n13) {
            n10 = n13;
        }
        string2 = af.a(byArray, 0, n10);
        stringBuilder.append(string2);
        stringBuilder.append("] Err:");
        string2 = var2_5.getMessage();
        stringBuilder.append(string2);
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        throw var2_5;
    }

    public void a() {
        IOException iOException2;
        block2: {
            try {
                this.c();
            }
            catch (IOException iOException2) {
                boolean bl2 = this.a;
                if (!bl2) break block2;
            }
            return;
        }
        throw iOException2;
    }

    public void b() {
        this.a = true;
    }
}

