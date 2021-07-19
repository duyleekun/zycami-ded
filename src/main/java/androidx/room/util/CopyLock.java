/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class CopyLock {
    private static final Map sThreadLocks;
    private final File mCopyLockFile;
    private final boolean mFileLevelLock;
    private FileChannel mLockChannel;
    private final Lock mThreadLock;

    static {
        HashMap hashMap;
        sThreadLocks = hashMap = new HashMap();
    }

    public CopyLock(String object, File file, boolean bl2) {
        File file2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(".lck");
        object = stringBuilder.toString();
        this.mCopyLockFile = file2 = new File(file, (String)object);
        this.mThreadLock = object = CopyLock.getThreadLock(file2.getAbsolutePath());
        this.mFileLevelLock = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Lock getThreadLock(String string2) {
        Map map = sThreadLocks;
        synchronized (map) {
            Object object = map.get(string2);
            object = (Lock)object;
            if (object == null) {
                object = new Object();
                map.put(string2, object);
            }
            return object;
        }
    }

    public void lock() {
        Object object = this.mThreadLock;
        object.lock();
        boolean bl2 = this.mFileLevelLock;
        if (bl2) {
            Serializable serializable;
            try {
                serializable = this.mCopyLockFile;
            }
            catch (IOException iOException) {
                serializable = new IllegalStateException("Unable to grab copy lock.", iOException);
                throw serializable;
            }
            object = new FileOutputStream((File)serializable);
            object = ((FileOutputStream)object).getChannel();
            this.mLockChannel = object;
            ((FileChannel)object).lock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unlock() {
        FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            }
            catch (IOException iOException) {}
        }
        this.mThreadLock.unlock();
    }
}

