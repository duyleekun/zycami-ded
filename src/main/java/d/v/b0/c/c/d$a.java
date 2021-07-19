/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.c.c;

import d.v.b0.c.c.d;
import d.v.b0.c.c.d$b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.UUID;

public class d$a
implements Runnable {
    public final /* synthetic */ d$b a;
    public final /* synthetic */ d b;

    public d$a(d d10, d$b b10) {
        this.b = d10;
        this.a = b10;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Throwable throwable222222;
        AbstractInterruptibleChannel abstractInterruptibleChannel;
        block10: {
            abstractInterruptibleChannel = null;
            Object object = this.a;
            Object object2 = ((d$b)object).a;
            object = ((d$b)object).b;
            Object object3 = UUID.randomUUID();
            object3 = ((UUID)object3).toString();
            Object object4 = this.b;
            object4 = d.a((d)object4);
            Object object5 = new StringBuilder();
            ((StringBuilder)object5).append((String)object3);
            object3 = ".temp";
            ((StringBuilder)object5).append((String)object3);
            object3 = ((StringBuilder)object5).toString();
            File file = new File((String)object4, (String)object3);
            object4 = "rw";
            object3 = new RandomAccessFile(file, (String)object4);
            abstractInterruptibleChannel = ((RandomAccessFile)object3).getChannel();
            FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
            long l10 = 0L;
            int n10 = ((byte[])object2).length;
            long l11 = n10;
            object5 = abstractInterruptibleChannel;
            object3 = ((FileChannel)abstractInterruptibleChannel).map(mapMode, l10, l11);
            ((ByteBuffer)object3).put((byte[])object2);
            object2 = this.b;
            object2 = d.b((d)object2);
            if (object2 != null) {
                object2 = this.b;
                object2 = d.b((d)object2);
                object3 = file.getAbsolutePath();
                object2.a((String)object, (String)object3);
            }
            if (abstractInterruptibleChannel == null) return;
            abstractInterruptibleChannel.close();
            return;
            {
                catch (Throwable throwable222222) {
                    break block10;
                }
                catch (Exception exception) {}
                {
                    exception.printStackTrace();
                    if (abstractInterruptibleChannel == null) return;
                }
                try {
                    abstractInterruptibleChannel.close();
                    return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            return;
        }
        if (abstractInterruptibleChannel == null) throw throwable222222;
        try {
            abstractInterruptibleChannel.close();
            throw throwable222222;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        throw throwable222222;
    }
}

