/*
 * Decompiled with CFR 0.151.
 */
package i.d.t;

import i.d.f;
import i.d.i;
import i.d.t.e;
import i.d.t.e$a$a;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class e$a
extends Thread {
    public static final /* synthetic */ boolean c;
    private BlockingQueue a;
    public final /* synthetic */ e b;

    public e$a(e e10) {
        this.b = e10;
        Object object = new LinkedBlockingQueue();
        this.a = object;
        ((StringBuilder)object).append("WebSocketWorker-");
        long l10 = this.getId();
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        this.setName((String)object);
        object = new e$a$a(this, e10);
        this.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)object);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(i var1_1, ByteBuffer var2_4) {
        block5: {
            var1_1.h(var2_4);
lbl3:
            // 2 sources

            while (true) {
                var1_1 = this.b;
                break;
            }
            {
                catch (Throwable var1_2) {
                    break block5;
                }
                catch (Exception var1_3) {}
                {
                    var3_5 = this.b;
                    var3_5 = e.a((e)var3_5);
                    var4_6 = "Error while reading from remote connection";
                    var3_5.error(var4_6, var1_3);
                    ** continue;
                }
            }
            e.c((e)var1_1, var2_4);
            return;
        }
        e.c(this.b, var2_4);
        throw var1_2;
    }

    public void b(i i10) {
        this.a.put(i10);
    }

    /*
     * Loose catch block
     */
    public void run() {
        block12: {
            Object object;
            Object object2;
            block11: {
                while (true) {
                    object2 = null;
                    object = this.a;
                    object = object.take();
                    object = (i)object;
                    object2 = ((i)object).c;
                    object2 = object2.poll();
                    object2 = (ByteBuffer)object2;
                    this.a((i)object, (ByteBuffer)object2);
                    continue;
                    break;
                }
                catch (RuntimeException runtimeException) {
                    break block11;
                }
                catch (RuntimeException runtimeException) {
                    object = null;
                    object2 = runtimeException;
                }
            }
            e e10 = this.b;
            e.b(e10, (f)object, (Exception)object2);
            break block12;
            catch (InterruptedException interruptedException) {
                object2 = Thread.currentThread();
                ((Thread)object2).interrupt();
            }
        }
    }
}

