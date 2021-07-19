/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class u {
    private static final Set a;
    private Context a;
    private RandomAccessFile a;
    private String a;
    private FileLock a;

    static {
        HashSet hashSet = new HashSet();
        a = Collections.synchronizedSet(hashSet);
    }

    private u(Context context) {
        this.a = context;
    }

    public static u a(Context object, File object2) {
        boolean bl2;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("Locking: ");
        Object object4 = ((File)object2).getAbsolutePath();
        ((StringBuilder)object3).append((String)object4);
        b.c(((StringBuilder)object3).toString());
        object3 = new StringBuilder();
        object2 = ((File)object2).getAbsolutePath();
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(".LOCK");
        object2 = ((StringBuilder)object3).toString();
        object3 = new File((String)object2);
        boolean bl3 = ((File)object3).exists();
        if (!bl3) {
            object4 = ((File)object3).getParentFile();
            ((File)object4).mkdirs();
            ((File)object3).createNewFile();
        }
        if (bl2 = (object4 = a).add(object2)) {
            u u10;
            block16: {
                block17: {
                    u10 = new u((Context)object);
                    u10.a = object2;
                    String string2 = "rw";
                    try {
                        object = new RandomAccessFile((File)object3, string2);
                    }
                    catch (Throwable throwable) {
                        object2 = u10.a;
                        if (object2 == null) {
                            object2 = u10.a;
                            if (object2 != null) {
                                y.a((Closeable)object2);
                            }
                            object2 = a;
                            object3 = u10.a;
                            object2.remove(object3);
                        }
                        throw throwable;
                    }
                    u10.a = object;
                    object = ((RandomAccessFile)object).getChannel();
                    object = ((FileChannel)object).lock();
                    u10.a = object;
                    object = new StringBuilder();
                    object3 = "Locked: ";
                    ((StringBuilder)object).append((String)object3);
                    ((StringBuilder)object).append((String)object2);
                    object2 = " :";
                    ((StringBuilder)object).append((String)object2);
                    object2 = u10.a;
                    ((StringBuilder)object).append(object2);
                    object = ((StringBuilder)object).toString();
                    b.c((String)object);
                    object = u10.a;
                    if (object != null) break block16;
                    object = u10.a;
                    if (object == null) break block17;
                    y.a((Closeable)object);
                }
                object = u10.a;
                object4.remove(object);
            }
            return u10;
        }
        object = new IOException("abtain lock failure");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("unLock: ");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        b.c(((StringBuilder)object).toString());
        object = this.a;
        if (object != null && (bl2 = ((FileLock)object).isValid())) {
            try {
                object = this.a;
                ((FileLock)object).release();
            }
            catch (IOException iOException) {}
            bl2 = false;
            object = null;
            this.a = null;
        }
        if ((object = this.a) != null) {
            y.a((Closeable)object);
        }
        object = a;
        object2 = this.a;
        object.remove(object2);
    }
}

