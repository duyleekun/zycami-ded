/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.u1.d;

import com.zhiyun.protocol.message.usb.media.MediaType;
import d.v.y.c.u1.d.a;
import d.v.y.d.b;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Objects;

public class c
extends a {
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private byte[] h;
    private boolean i;

    public c() {
        MediaType mediaType = MediaType.VIDEO_RMP;
        this.e(mediaType);
        this.c(false);
    }

    public byte[] a() {
        int n10;
        Object object = this.b;
        MediaType mediaType = MediaType.UNKNOWN;
        if (object == mediaType) {
            return d.v.y.d.a.b();
        }
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = n10 = (int)object.value;
        n10 = this.c;
        boolean s10 = this.b();
        object = d.v.y.d.b.s(n10, s10);
        boolean bl2 = this.i;
        int n12 = 2;
        int n13 = 3;
        if (bl2) {
            Objects.requireNonNull(object);
            short s11 = (short)this.d;
            short s12 = this.b();
            byte[] byArray2 = d.v.y.d.b.t(s11, s12 != 0);
            s12 = (short)this.e;
            boolean bl3 = this.b();
            byte[] byArray3 = d.v.y.d.b.t(s12, bl3);
            byte[][] byArrayArray = new byte[4][];
            byArrayArray[0] = (byte[])object;
            byArrayArray[n11] = byArray2;
            byArrayArray[n12] = byArray3;
            object = this.h;
            byArrayArray[n13] = (byte[])object;
            return d.v.y.d.a.a(byArray, byArrayArray);
        }
        int n14 = this.f;
        int n15 = this.b();
        byte[] byArray4 = d.v.y.d.b.s(n14, n15 != 0);
        n15 = this.g;
        boolean bl4 = this.b();
        byte[] byArray5 = d.v.y.d.b.s(n15, bl4);
        byte[][] byArrayArray = new byte[n13][];
        byArrayArray[0] = (byte[])object;
        byArrayArray[n11] = byArray4;
        byArrayArray[n12] = byArray5;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        MediaType mediaType = MediaType.VIDEO_RMP;
        this.e(mediaType);
        this.o(0);
        this.r(0);
        this.p(0);
        this.q(0);
        this.m(null);
    }

    public byte[] f() {
        return this.h;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.c;
    }

    public int i() {
        return this.e;
    }

    public int j() {
        return this.g;
    }

    public int k() {
        return this.d;
    }

    public boolean l() {
        return this.i;
    }

    public void m(byte[] byArray) {
        this.h = byArray;
    }

    public void n(int n10) {
        this.f = n10;
    }

    public void o(int n10) {
        this.c = n10;
    }

    public void p(int n10) {
        this.e = n10;
    }

    public boolean parseFrom(byte[] object) {
        Object object2;
        int n10;
        block23: {
            try {
                object = ByteBuffer.wrap((byte[])object);
            }
            catch (BufferUnderflowException bufferUnderflowException) {
                bufferUnderflowException.printStackTrace();
                return false;
            }
            n10 = ((ByteBuffer)object).get();
            object2 = MediaType.from(n10);
            this.b = object2;
            MediaType mediaType = MediaType.UNKNOWN;
            if (object2 != mediaType) break block23;
            return false;
        }
        n10 = ((ByteBuffer)object).get();
        byte by2 = ((ByteBuffer)object).get();
        byte bl2 = ((ByteBuffer)object).get();
        byte by3 = ((ByteBuffer)object).get();
        boolean bl3 = this.b();
        n10 = d.v.y.d.b.u((byte)n10, by2, bl2, by3, bl3);
        this.c = n10;
        n10 = ((ByteBuffer)object).get();
        by2 = ((ByteBuffer)object).get();
        boolean bl4 = this.b();
        n10 = d.v.y.d.b.y((byte)n10, by2, bl4);
        this.d = n10;
        n10 = ((ByteBuffer)object).get();
        by2 = ((ByteBuffer)object).get();
        boolean bl5 = this.b();
        n10 = d.v.y.d.b.y((byte)n10, by2, bl5);
        this.e = n10;
        n10 = ((Buffer)object).remaining();
        object2 = new byte[n10];
        this.h = (byte[])object2;
        ((ByteBuffer)object).get((byte[])object2);
        return true;
    }

    public void q(int n10) {
        this.g = n10;
    }

    public void r(int n10) {
        this.d = n10;
    }

    public void s(boolean bl2) {
        this.i = bl2;
    }
}

