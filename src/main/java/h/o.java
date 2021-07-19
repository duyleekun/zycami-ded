/*
 * Decompiled with CFR 0.151.
 */
package h;

import h.c0;
import h.k0;
import h.m;
import h.m0;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

public interface o
extends m0,
ReadableByteChannel {
    public short G();

    public long I();

    public long K(ByteString var1, long var2);

    public void L(long var1);

    public long N(byte var1);

    public String P(long var1);

    public ByteString Q(long var1);

    public byte[] T();

    public boolean V();

    public long W();

    public String Y(Charset var1);

    public int Z();

    public m b();

    public ByteString b0();

    public long c(ByteString var1, long var2);

    public int e0();

    public String f0();

    public String g0(long var1, Charset var3);

    public m getBuffer();

    public long i(ByteString var1);

    public long i0(k0 var1);

    public long j(byte var1, long var2);

    public void k(m var1, long var2);

    public long k0();

    public long l(byte var1, long var2, long var4);

    public InputStream l0();

    public long m(ByteString var1);

    public int m0(c0 var1);

    public String n();

    public String p(long var1);

    public o peek();

    public int read(byte[] var1);

    public int read(byte[] var1, int var2, int var3);

    public byte readByte();

    public void readFully(byte[] var1);

    public int readInt();

    public long readLong();

    public short readShort();

    public boolean request(long var1);

    public boolean s(long var1, ByteString var3);

    public void skip(long var1);

    public String w();

    public boolean x(long var1, ByteString var3, int var4, int var5);

    public byte[] z(long var1);
}

