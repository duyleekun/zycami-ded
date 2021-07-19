/*
 * Decompiled with CFR 0.151.
 */
package g.h0.g;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.g.a;
import g.h0.g.b;
import h.m;
import h.m0;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import okio.ByteString;

public final class b$a {
    private b$a() {
    }

    public /* synthetic */ b$a(u u10) {
        this();
    }

    public final b a(File object, m0 m02, ByteString byteString, long l10) {
        f0.p(object, "file");
        f0.p(m02, "upstream");
        f0.p(byteString, "metadata");
        RandomAccessFile randomAccessFile = new RandomAccessFile((File)object, "rw");
        Object object2 = m02;
        object = new b(randomAccessFile, m02, 0L, byteString, l10, null);
        randomAccessFile.setLength(0L);
        object2 = b.n;
        b.a((b)object, (ByteString)object2, -1, -1);
        return object;
    }

    public final b b(File object) {
        f0.p(object, "file");
        RandomAccessFile randomAccessFile = new RandomAccessFile((File)object, "rw");
        ByteChannel byteChannel = randomAccessFile.getChannel();
        f0.o(byteChannel, "randomAccessFile.channel");
        object = new a((FileChannel)byteChannel);
        byteChannel = new m();
        long l10 = 0L;
        long l11 = 32;
        Object object2 = object;
        Object object3 = byteChannel;
        ((a)object).a(l10, (m)byteChannel, l11);
        Object object4 = b.m;
        int n10 = ((ByteString)object4).size();
        long l12 = n10;
        object2 = ((m)byteChannel).Q(l12);
        boolean bl2 = f0.g(object2, object4) ^ true;
        if (!bl2) {
            long l13 = ((m)byteChannel).readLong();
            l11 = ((m)byteChannel).readLong();
            byteChannel = new m();
            l10 = l13 + (long)32;
            object2 = object;
            object3 = byteChannel;
            ((a)object).a(l10, (m)byteChannel, l11);
            object3 = ((m)byteChannel).b0();
            object4 = object;
            l10 = l13;
            object = new b(randomAccessFile, null, l13, (ByteString)object3, 0L, null);
            return object;
        }
        object = new IOException("unreadable cache file");
        throw object;
    }
}

