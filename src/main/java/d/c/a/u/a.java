/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u;

import d.c.a.u.a$a;
import d.c.a.u.a$b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.concurrent.atomic.AtomicReference;

public final class a {
    private static final int a = 16384;
    private static final AtomicReference b;

    static {
        AtomicReference atomicReference;
        b = atomicReference = new AtomicReference();
    }

    private a() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static ByteBuffer a(File var0) {
        block29: {
            block26: {
                block27: {
                    block28: {
                        var1_4 = null;
                        var2_5 = var0.length();
                        var4_6 = 0x7FFFFFFFL;
                        var6_7 /* !! */  = var2_5 == var4_6 ? 0 : (var2_5 < var4_6 ? -1 : 1);
                        if (var6_7 /* !! */  > 0) break block26;
                        var4_6 = 0L;
                        cfr_temp_0 = var2_5 - var4_6;
                        var6_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                        if (var6_7 /* !! */  == false) break block27;
                        var8_9 = "r";
                        var7_8 = new RandomAccessFile((File)var0, (String)var8_9);
                        var1_4 = var7_8.getChannel();
                        var9_12 = FileChannel.MapMode.READ_ONLY;
                        var10_13 = 0L;
                        var8_9 = var1_4;
                        var0 = var1_4.map(var9_12, var10_13, var2_5);
                        var0 = var0.load();
                        if (var1_4 == null) break block28;
                        var1_4.close();
                    }
lbl28:
                    // 2 sources

                    while (true) {
                        var7_8.close();
lbl31:
                        // 2 sources

                        return var0;
                        break;
                    }
                    catch (Throwable var0_1) {}
                    break block29;
                }
                var8_10 = "File unsuitable for memory mapping";
                var0 = new IOException(var8_10);
                throw var0;
            }
            var8_11 = "File too large to map into memory";
            try {
                var0 = new IOException(var8_11);
                throw var0;
            }
            catch (Throwable var0_2) {
                var7_8 = null;
            }
        }
        if (var1_4 != null) {
            var1_4.close();
        }
lbl51:
        // 4 sources

        while (true) {
            if (var7_8 != null) {
                var7_8.close();
            }
lbl55:
            // 4 sources

            throw var0_3;
        }
        catch (IOException v0) {
            ** continue;
        }
        catch (IOException v1) {
            ** continue;
        }
        catch (IOException v2) {
            ** continue;
        }
        catch (IOException v3) {
            ** continue;
        }
    }

    public static ByteBuffer b(InputStream object) {
        int n10 = 16384;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n10);
        byte[] byArray = b.getAndSet(null);
        if (byArray == null) {
            byArray = new byte[n10];
        }
        while ((n10 = ((InputStream)object).read(byArray)) >= 0) {
            byteArrayOutputStream.write(byArray, 0, n10);
        }
        b.set(byArray);
        object = byteArrayOutputStream.toByteArray();
        return (ByteBuffer)ByteBuffer.allocateDirect(((Object)object).length).put((byte[])object).position(0);
    }

    private static a$b c(ByteBuffer byteBuffer) {
        boolean bl2 = byteBuffer.isReadOnly();
        if (!bl2 && (bl2 = byteBuffer.hasArray())) {
            byte[] byArray = byteBuffer.array();
            int n10 = byteBuffer.arrayOffset();
            int n11 = byteBuffer.limit();
            a$b a$b = new a$b(byArray, n10, n11);
            return a$b;
        }
        return null;
    }

    public static byte[] d(ByteBuffer object) {
        int n10;
        int n11;
        Object object2 = d.c.a.u.a.c((ByteBuffer)object);
        if (object2 != null && (n11 = ((a$b)object2).a) == 0 && (n11 = ((a$b)object2).b) == (n10 = ((Object)(object2 = (Object)((a$b)object2).c)).length)) {
            object = ((ByteBuffer)object).array();
        } else {
            object = ((ByteBuffer)object).asReadOnlyBuffer();
            n10 = ((Buffer)object).limit();
            object2 = new byte[n10];
            n11 = 0;
            ((ByteBuffer)object).position(0);
            ((ByteBuffer)object).get((byte[])object2);
            object = object2;
        }
        return object;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void e(ByteBuffer byteBuffer, File file) {
        void var0_3;
        RandomAccessFile randomAccessFile;
        block13: {
            block12: {
                AbstractInterruptibleChannel abstractInterruptibleChannel;
                block14: {
                    byteBuffer.position(0);
                    abstractInterruptibleChannel = null;
                    String string2 = "rw";
                    randomAccessFile = new RandomAccessFile(file, string2);
                    try {
                        abstractInterruptibleChannel = randomAccessFile.getChannel();
                        ((FileChannel)abstractInterruptibleChannel).write(byteBuffer);
                        ((FileChannel)abstractInterruptibleChannel).force(false);
                        abstractInterruptibleChannel.close();
                        randomAccessFile.close();
                        if (abstractInterruptibleChannel == null) break block12;
                    }
                    catch (Throwable throwable) {}
                    try {
                        abstractInterruptibleChannel.close();
                        break block12;
                    }
                    catch (IOException iOException) {}
                    break block14;
                    catch (Throwable throwable) {
                        randomAccessFile = null;
                    }
                }
                if (abstractInterruptibleChannel == null) break block13;
                try {
                    abstractInterruptibleChannel.close();
                    break block13;
                }
                catch (IOException iOException) {}
            }
            try {
                randomAccessFile.close();
                return;
            }
            catch (IOException iOException) {
                return;
            }
        }
        if (randomAccessFile == null) throw var0_3;
        try {
            randomAccessFile.close();
        }
        catch (IOException iOException) {
            throw var0_3;
        }
        throw var0_3;
    }

    public static InputStream f(ByteBuffer byteBuffer) {
        a$a a$a = new a$a(byteBuffer);
        return a$a;
    }

    public static void g(ByteBuffer object, OutputStream outputStream) {
        Object object2 = d.c.a.u.a.c((ByteBuffer)object);
        if (object2 != null) {
            object = ((a$b)object2).c;
            int n10 = ((a$b)object2).a;
            int n11 = ((a$b)object2).b + n10;
            outputStream.write((byte[])object, n10, n11);
        } else {
            object2 = b;
            int n12 = 0;
            if ((object2 = (Object)((AtomicReference)object2).getAndSet(null)) == null) {
                int n13 = 16384;
                object2 = new byte[n13];
            }
            while ((n12 = ((Buffer)object).remaining()) > 0) {
                n12 = ((Buffer)object).remaining();
                int n14 = ((Object)object2).length;
                n12 = Math.min(n12, n14);
                n14 = 0;
                ((ByteBuffer)object).get((byte[])object2, 0, n12);
                outputStream.write((byte[])object2, 0, n12);
            }
            object = b;
            ((AtomicReference)object).set(object2);
        }
    }
}

