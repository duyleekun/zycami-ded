/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.l;

import android.util.Log;
import d.c.a.o.a;
import d.c.a.o.f;
import d.c.a.o.k.x.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class t
implements a {
    private static final String b = "StreamEncoder";
    private final b a;

    public t(b b10) {
        this.a = b10;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c(InputStream inputStream, File object, f object2) {
        void var1_6;
        byte[] byArray;
        block17: {
            boolean bl2;
            block16: {
                OutputStream outputStream;
                block14: {
                    int n10;
                    block15: {
                        object2 = b;
                        byArray = (byte[])this.a.c(65536, byte[].class);
                        bl2 = false;
                        int n11 = 0;
                        outputStream = null;
                        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
                        while ((n10 = inputStream.read(byArray)) != (n11 = -1)) {
                            ((OutputStream)fileOutputStream).write(byArray, 0, n10);
                        }
                        ((OutputStream)fileOutputStream).close();
                        bl2 = true;
                        try {
                            ((OutputStream)fileOutputStream).close();
                        }
                        catch (IOException iOException) {}
                        catch (Throwable throwable) {
                            outputStream = fileOutputStream;
                            break block14;
                        }
                        catch (IOException iOException) {
                            outputStream = fileOutputStream;
                            break block15;
                        }
                        catch (Throwable throwable) {
                            break block14;
                        }
                        catch (IOException iOException) {
                            // empty catch block
                        }
                    }
                    n10 = 3;
                    {
                        n10 = (int)(Log.isLoggable((String)object2, (int)n10) ? 1 : 0);
                        if (n10 != 0) {
                            object = "Failed to encode data onto the OutputStream";
                            Log.d((String)object2, (String)object, (Throwable)((Object)inputStream));
                        }
                        if (outputStream == null) break block16;
                    }
                    outputStream.close();
                    break block16;
                }
                if (outputStream == null) break block17;
                try {
                    outputStream.close();
                    break block17;
                }
                catch (IOException iOException) {}
            }
            this.a.put(byArray);
            return bl2;
        }
        this.a.put(byArray);
        throw var1_6;
    }
}

