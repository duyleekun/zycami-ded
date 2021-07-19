/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.google.firebase.installations;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public class CrossProcessLock {
    private static final String TAG = "CrossProcessLock";
    private final FileChannel channel;
    private final FileLock lock;

    private CrossProcessLock(FileChannel fileChannel, FileLock fileLock) {
        this.channel = fileChannel;
        this.lock = fileLock;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static CrossProcessLock acquire(Context object, String object2) {
        void var2_9;
        block17: {
            object = object.getFilesDir();
            Object object3 = new File((File)object, (String)object2);
            object2 = "rw";
            object = new RandomAccessFile((File)object3, (String)object2);
            object = ((RandomAccessFile)object).getChannel();
            object2 = ((FileChannel)object).lock();
            try {
                return new CrossProcessLock((FileChannel)object, (FileLock)object2);
            }
            catch (OverlappingFileLockException overlappingFileLockException) {
                break block17;
            }
            catch (Error error) {
                break block17;
            }
            catch (IOException iOException) {
                break block17;
            }
            catch (OverlappingFileLockException overlappingFileLockException) {
            }
            catch (Error error) {
            }
            catch (IOException iOException) {
                // empty catch block
            }
            object2 = null;
            break block17;
            catch (OverlappingFileLockException overlappingFileLockException) {
            }
            catch (Error error) {
            }
            catch (IOException iOException) {
                // empty catch block
            }
            object = null;
            object2 = null;
        }
        String string2 = TAG;
        String string3 = "encountered error while creating and acquiring the lock, ignoring";
        Log.e((String)string2, (String)string3, (Throwable)var2_9);
        if (object2 != null) {
            try {
                ((FileLock)object2).release();
            }
            catch (IOException iOException) {}
        }
        if (object == null) return null;
        try {
            ((AbstractInterruptibleChannel)object).close();
            return null;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public void releaseAndClose() {
        AutoCloseable autoCloseable = this.lock;
        ((FileLock)autoCloseable).release();
        autoCloseable = this.channel;
        try {
            ((AbstractInterruptibleChannel)autoCloseable).close();
        }
        catch (IOException iOException) {
            String string2 = TAG;
            String string3 = "encountered error while releasing, ignoring";
            Log.e((String)string2, (String)string3, (Throwable)iOException);
        }
    }
}

