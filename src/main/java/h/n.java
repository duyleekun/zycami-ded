/*
 * Decompiled with CFR 0.151.
 */
package h;

import h.k0;
import h.m;
import h.m0;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

public interface n
extends k0,
WritableByteChannel {
    public n J(String var1, int var2, int var3, Charset var4);

    public n M(long var1);

    public n R(ByteString var1, int var2, int var3);

    public n U(int var1);

    public n X(int var1);

    public n a0(long var1);

    public m b();

    public n c0(String var1, Charset var2);

    public n d();

    public n d0(m0 var1, long var2);

    public n e(int var1);

    public void flush();

    public n g(long var1);

    public m getBuffer();

    public n h0(ByteString var1);

    public OutputStream j0();

    public n o();

    public n r(String var1);

    public n u(String var1, int var2, int var3);

    public long v(m0 var1);

    public n write(byte[] var1);

    public n write(byte[] var1, int var2, int var3);

    public n writeByte(int var1);

    public n writeInt(int var1);

    public n writeLong(long var1);

    public n writeShort(int var1);
}

