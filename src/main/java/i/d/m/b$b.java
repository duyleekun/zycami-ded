/*
 * Decompiled with CFR 0.151.
 */
package i.d.m;

import i.d.i;
import i.d.m.b;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b$b
implements Runnable {
    private final b a;
    public final /* synthetic */ b b;

    public b$b(b b10, b b11) {
        this.b = b10;
        this.a = b11;
    }

    private void a() {
        block6: {
            Object object = this.b;
            object = i.d.m.b.access$400((b)object);
            if (object == null) break block6;
            object = this.b;
            object = i.d.m.b.access$400((b)object);
            try {
                ((Socket)object).close();
            }
            catch (IOException iOException) {
                b b10 = this.b;
                b b11 = this.a;
                b10.onWebsocketError(b11, iOException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        while (true) {
            Object object;
            Object object2;
            Object object3;
            Thread thread = null;
            try {
                int n10 = Thread.interrupted();
                if (n10 != 0) return;
                object3 = this.b;
                object3 = i.d.m.b.access$200((b)object3);
                object3 = ((i)object3).b;
                object3 = object3.take();
                object3 = (ByteBuffer)object3;
                object2 = this.b;
                object2 = i.d.m.b.access$300((b)object2);
                object = ((ByteBuffer)object3).array();
                n10 = ((Buffer)object3).limit();
                ((OutputStream)object2).write((byte[])object, 0, n10);
                object3 = this.b;
                object3 = i.d.m.b.access$300((b)object3);
                ((OutputStream)object3).flush();
            }
            catch (InterruptedException interruptedException) {
                int n11;
                object3 = i.d.m.b.access$200((b)this.b).b.iterator();
                while ((n11 = object3.hasNext()) != 0) {
                    object2 = (ByteBuffer)object3.next();
                    object = i.d.m.b.access$300(this.b);
                    byte[] byArray = ((ByteBuffer)object2).array();
                    n11 = ((Buffer)object2).limit();
                    ((OutputStream)object).write(byArray, 0, n11);
                    object2 = i.d.m.b.access$300(this.b);
                    ((OutputStream)object2).flush();
                }
                thread = Thread.currentThread();
                thread.interrupt();
                return;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block5: {
            var1_1 = Thread.currentThread();
            var2_2 = new StringBuilder();
            var2_2.append("WebSocketWriteThread-");
            var3_5 /* !! */  = Thread.currentThread();
            var4_6 = var3_5 /* !! */ .getId();
            var2_2.append(var4_6);
            var2_2 = var2_2.toString();
            var1_1.setName((String)var2_2);
            var1_1 = null;
            this.b();
lbl14:
            // 2 sources

            while (true) {
                this.a();
                var2_2 = this.b;
                break;
            }
            {
                catch (Throwable var2_3) {
                    break block5;
                }
                catch (IOException var2_4) {}
                {
                    var3_5 /* !! */  = this.b;
                    i.d.m.b.access$000((b)var3_5 /* !! */ , var2_4);
                    ** continue;
                }
            }
            i.d.m.b.access$102((b)var2_2, null);
            return;
        }
        this.a();
        i.d.m.b.access$102(this.b, null);
        throw var2_3;
    }
}

