/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ek$a;
import com.xiaomi.push.gj;
import com.xiaomi.push.gu;
import com.xiaomi.push.service.ay;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class fl {
    private static long a;
    private static final byte[] a;
    private static String b;
    private ek$a a;
    public String a;
    private short a = (short)2;
    private byte[] b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = gu.a(5);
        stringBuilder.append(string2);
        stringBuilder.append("-");
        b = stringBuilder.toString();
        a = 0L;
        a = new byte[0];
    }

    public fl() {
        Object object = a;
        this.b = object;
        this.a = null;
        object = new ek$a;
        this.a = object;
    }

    public fl(ek$a ek$a, short s10, byte[] byArray) {
        byte[] byArray2 = a;
        this.b = byArray2;
        this.a = null;
        this.a = ek$a;
        this.a = s10;
        this.b = byArray;
    }

    public static fl a(gj object, String charSequence) {
        short s10;
        String string2;
        fl fl2;
        block10: {
            StringBuilder stringBuilder;
            int n10;
            fl2 = new fl();
            string2 = ((gj)object).k();
            try {
                n10 = Integer.parseInt(string2);
            }
            catch (Exception exception) {
                stringBuilder = new StringBuilder();
                String string3 = "Blob parse chid err ";
                stringBuilder.append(string3);
                string2 = exception.getMessage();
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                com.xiaomi.channel.commonutils.logger.b.a(string2);
                n10 = 1;
            }
            fl2.a(n10);
            string2 = ((gj)object).j();
            fl2.a(string2);
            string2 = ((gj)object).m();
            fl2.c(string2);
            string2 = ((gj)object).n();
            fl2.b(string2);
            string2 = "XMLMSG";
            stringBuilder = null;
            fl2.a(string2, null);
            object = ((gj)object).a();
            string2 = "utf8";
            object = ((String)object).getBytes(string2);
            fl2.a((byte[])object, (String)charSequence);
            s10 = TextUtils.isEmpty((CharSequence)charSequence);
            if (s10 == 0) break block10;
            s10 = 3;
            fl2.a(s10);
        }
        s10 = 2;
        fl2.a(s10);
        object = "SECMSG";
        try {
            fl2.a((String)object, null);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            charSequence = new StringBuilder();
            string2 = "Blob setPayload err\uff1a ";
            ((StringBuilder)charSequence).append(string2);
            String string4 = unsupportedEncodingException.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            com.xiaomi.channel.commonutils.logger.b.a(string4);
        }
        return fl2;
    }

    public static fl a(ByteBuffer object) {
        StringBuilder stringBuilder;
        try {
            object = ((ByteBuffer)object).slice();
            stringBuilder = null;
        }
        catch (Exception exception) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("read Blob err :");
            Object object2 = exception.getMessage();
            stringBuilder.append((String)object2);
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            object2 = new IOException("Malformed Input");
            throw object2;
        }
        short s10 = ((ByteBuffer)object).getShort(0);
        int n10 = 2;
        n10 = ((ByteBuffer)object).getShort(n10);
        int n11 = 4;
        n11 = ((ByteBuffer)object).getInt(n11);
        ek$a ek$a = new ek$a();
        byte[] byArray = ((ByteBuffer)object).array();
        int n12 = ((ByteBuffer)object).arrayOffset() + 8;
        ek$a.a(byArray, n12, n10);
        byArray = new byte[n11];
        n10 += 8;
        ((ByteBuffer)object).position(n10);
        ((ByteBuffer)object).get(byArray, 0, n11);
        object = new fl(ek$a, s10, byArray);
        return object;
    }

    public static String d() {
        Class<fl> clazz = fl.class;
        synchronized (clazz) {
            long l10;
            CharSequence charSequence = new StringBuilder();
            String string2 = b;
            charSequence.append(string2);
            long l11 = a;
            a = l10 = 1L + l11;
            string2 = Long.toString(l11);
            charSequence.append(string2);
            charSequence = charSequence.toString();
            return charSequence;
        }
    }

    public int a() {
        return this.a.c();
    }

    public String a() {
        return this.a.c();
    }

    public ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            int n10 = this.c();
            byteBuffer = ByteBuffer.allocate(n10);
        }
        int n11 = this.a;
        byteBuffer.putShort((short)n11);
        n11 = (short)this.a.a();
        byteBuffer.putShort((short)n11);
        n11 = this.b.length;
        byteBuffer.putInt(n11);
        n11 = byteBuffer.position();
        ek$a ek$a = this.a;
        byte[] byArray = byteBuffer.array();
        int n12 = byteBuffer.arrayOffset() + n11;
        int n13 = this.a.a();
        ek$a.a(byArray, n12, n13);
        int n14 = this.a.a();
        byteBuffer.position(n11 += n14);
        byte[] byArray2 = this.b;
        byteBuffer.put(byArray2);
        return byteBuffer;
    }

    public short a() {
        return this.a;
    }

    public void a(int n10) {
        this.a.a(n10);
    }

    public void a(long l10, String string2, String string3) {
        ek$a ek$a;
        boolean bl2;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            ek$a ek$a2 = this.a;
            ek$a2.a(l10);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            ek$a = this.a;
            ek$a.a(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            ek$a = this.a;
            ek$a.b(string3);
        }
    }

    public void a(String string2) {
        this.a.e(string2);
    }

    public void a(String object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            ek$a ek$a = this.a;
            ek$a.c((String)object);
            object = this.a;
            ((ek$a)object).a();
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3) {
                object = this.a;
                ((ek$a)object).d(string2);
            }
            return;
        }
        object = new IllegalArgumentException("command should not be empty");
        throw object;
    }

    public void a(short s10) {
        this.a = s10;
    }

    public void a(byte[] byArray, String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            Object object2 = this.a;
            int n10 = 1;
            ((ek$a)object2).c(n10);
            object2 = this.e();
            object = ay.a((String)object, (String)object2);
            byArray = ay.a((byte[])object, byArray);
            this.b = byArray;
        } else {
            object = this.a;
            bl2 = false;
            Object var4_5 = null;
            ((ek$a)object).c(0);
            this.b = byArray;
        }
    }

    public boolean a() {
        return this.a.j();
    }

    public byte[] a() {
        return this.b;
    }

    public byte[] a(String object) {
        int n10;
        Object object2 = this.a;
        int n11 = ((ek$a)object2).e();
        if (n11 == (n10 = 1)) {
            object2 = this.e();
            object = ay.a((String)object, (String)object2);
            object2 = this.b;
            return ay.a((byte[])object, (byte[])object2);
        }
        object = this.a;
        int n12 = ((ek$a)object).e();
        if (n12 == 0) {
            return this.b;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("unknow cipher = ");
        n11 = this.a.e();
        ((StringBuilder)object).append(n11);
        com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
        return this.b;
    }

    public int b() {
        return this.a.f();
    }

    public String b() {
        return this.a.d();
    }

    public void b(String string2) {
        this.a = string2;
    }

    public int c() {
        int n10 = this.a.b() + 8;
        int n11 = this.b.length;
        return n10 + n11;
    }

    public String c() {
        return this.a.f();
    }

    public void c(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0) {
            Object object = "@";
            n10 = string2.indexOf((String)object);
            Object object2 = null;
            object2 = string2.substring(0, n10);
            long l10 = Long.parseLong((String)object2);
            Object object3 = "/";
            int n11 = string2.indexOf((String)object3, n10);
            ++n10;
            object = string2.substring(n10, n11);
            ++n11;
            string2 = string2.substring(n11);
            object3 = this.a;
            ((ek$a)object3).a(l10);
            object2 = this.a;
            ((ek$a)object2).a((String)object);
            object = this.a;
            try {
                ((ek$a)object).b(string2);
            }
            catch (Exception exception) {
                object = new StringBuilder();
                object2 = "Blob parse user err ";
                ((StringBuilder)object).append((String)object2);
                String string3 = exception.getMessage();
                ((StringBuilder)object).append(string3);
                string3 = ((StringBuilder)object).toString();
                com.xiaomi.channel.commonutils.logger.b.a(string3);
            }
        }
    }

    public String e() {
        Object object = "ID_NOT_AVAILABLE";
        String string2 = this.a.e();
        boolean bl2 = ((String)object).equals(string2);
        if (bl2) {
            return null;
        }
        object = this.a;
        bl2 = ((ek$a)object).g();
        if (!bl2) {
            string2 = fl.d();
            object = this.a;
            ((ek$a)object).e(string2);
        }
        return string2;
    }

    public String f() {
        return this.a;
    }

    public String g() {
        Object object = this.a;
        boolean bl2 = ((ek$a)object).b();
        if (bl2) {
            object = new StringBuilder();
            String string2 = Long.toString(this.a.a());
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("@");
            string2 = this.a.a();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("/");
            string2 = this.a.b();
            ((StringBuilder)object).append(string2);
            return ((StringBuilder)object).toString();
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Blob [chid=");
        int n10 = this.a();
        stringBuilder.append(n10);
        stringBuilder.append("; Id=");
        String string2 = this.e();
        stringBuilder.append(string2);
        stringBuilder.append("; cmd=");
        string2 = this.a();
        stringBuilder.append(string2);
        stringBuilder.append("; type=");
        n10 = this.a();
        stringBuilder.append(n10);
        stringBuilder.append("; from=");
        string2 = this.g();
        stringBuilder.append(string2);
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}

