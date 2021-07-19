/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink$CacheDataSinkException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink
implements DataSink {
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    public static final long DEFAULT_FRAGMENT_SIZE = 0x500000L;
    private static final long MIN_RECOMMENDED_FRAGMENT_SIZE = 0x200000L;
    private static final String TAG = "CacheDataSink";
    private final int bufferSize;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private final Cache cache;
    private DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private long dataSpecFragmentSize;
    private File file;
    private final long fragmentSize;
    private OutputStream outputStream;
    private long outputStreamBytesWritten;

    public CacheDataSink(Cache cache, long l10) {
        this(cache, l10, 20480);
    }

    public CacheDataSink(Cache cache, long l10, int n10) {
        long l11;
        long l12;
        long l13 = 0L;
        long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        long l15 = -1;
        l14 = l14 <= 0 && (l14 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1)) != false ? (long)0 : (long)1;
        String string2 = "fragmentSize must be positive or C.LENGTH_UNSET.";
        Assertions.checkState((boolean)l14, string2);
        l14 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1);
        if (l14 != false && (l12 = (l11 = l10 - (l15 = 0x200000L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            String string3 = TAG;
            String string4 = "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.";
            Log.w(string3, string4);
        }
        this.cache = cache = (Cache)Assertions.checkNotNull(cache);
        if (l14 == false) {
            l10 = Long.MAX_VALUE;
        }
        this.fragmentSize = l10;
        this.bufferSize = n10;
    }

    private void closeCurrentOutputStream() {
        Object object = this.outputStream;
        if (object == null) {
            return;
        }
        Cache cache = null;
        try {
            ((OutputStream)object).flush();
        }
        catch (Throwable throwable) {
            Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file = (File)Util.castNonNull(this.file);
            this.file = null;
            file.delete();
            throw throwable;
        }
        Util.closeQuietly(this.outputStream);
        this.outputStream = null;
        object = (File)Util.castNonNull(this.file);
        this.file = null;
        cache = this.cache;
        long l10 = this.outputStreamBytesWritten;
        cache.commitFile((File)object, l10);
    }

    private void openNextOutputStream(DataSpec object) {
        Object object2;
        long l10 = ((DataSpec)object).length;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) {
            l11 = this.dataSpecBytesWritten;
            l10 -= l11;
            l11 = this.dataSpecFragmentSize;
            l11 = Math.min(l10, l11);
        }
        long l13 = l11;
        Cache cache = this.cache;
        Object object4 = object2 = Util.castNonNull(((DataSpec)object).key);
        object4 = (String)object2;
        l10 = ((DataSpec)object).position;
        l11 = this.dataSpecBytesWritten;
        long l14 = l10 + l11;
        object2 = this.file = (object = cache.startFile((String)object4, l14, l13));
        object = new FileOutputStream((File)object2);
        int n10 = this.bufferSize;
        if (n10 > 0) {
            object2 = this.bufferedOutputStream;
            if (object2 == null) {
                int n11 = this.bufferSize;
                this.bufferedOutputStream = object2 = new ReusableBufferedOutputStream((OutputStream)object, n11);
            } else {
                ((ReusableBufferedOutputStream)object2).reset((OutputStream)object);
            }
            this.outputStream = object = this.bufferedOutputStream;
        } else {
            this.outputStream = object;
        }
        this.outputStreamBytesWritten = 0L;
    }

    public void close() {
        DataSpec dataSpec = this.dataSpec;
        if (dataSpec == null) {
            return;
        }
        try {
            this.closeCurrentOutputStream();
            return;
        }
        catch (IOException iOException) {
            CacheDataSink$CacheDataSinkException cacheDataSink$CacheDataSinkException = new CacheDataSink$CacheDataSinkException(iOException);
            throw cacheDataSink$CacheDataSinkException;
        }
    }

    public void open(DataSpec dataSpec) {
        Object object = dataSpec.key;
        Assertions.checkNotNull(object);
        long l10 = dataSpec.length;
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false && (l12 = (long)dataSpec.isFlagSet(2)) != false) {
            this.dataSpec = null;
            return;
        }
        this.dataSpec = dataSpec;
        l12 = (long)dataSpec.isFlagSet(4);
        l10 = l12 != false ? this.fragmentSize : Long.MAX_VALUE;
        this.dataSpecFragmentSize = l10;
        this.dataSpecBytesWritten = l10 = 0L;
        try {
            this.openNextOutputStream(dataSpec);
            return;
        }
        catch (IOException iOException) {
            object = new CacheDataSink$CacheDataSinkException(iOException);
            throw object;
        }
    }

    public void write(byte[] byArray, int n10, int n11) {
        DataSpec dataSpec = this.dataSpec;
        if (dataSpec == null) {
            return;
        }
        int n12 = 0;
        while (n12 < n11) {
            long l10;
            long l11;
            long l12;
            block17: {
                try {
                    l12 = this.outputStreamBytesWritten;
                }
                catch (IOException iOException) {
                    CacheDataSink$CacheDataSinkException cacheDataSink$CacheDataSinkException = new CacheDataSink$CacheDataSinkException(iOException);
                    throw cacheDataSink$CacheDataSinkException;
                }
                l11 = this.dataSpecFragmentSize;
                l10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                if (l10 != false) break block17;
                this.closeCurrentOutputStream();
                this.openNextOutputStream(dataSpec);
            }
            l10 = n11 - n12;
            l12 = l10;
            l11 = this.dataSpecFragmentSize;
            long l13 = this.outputStreamBytesWritten;
            l11 -= l13;
            l12 = Math.min(l12, l11);
            l10 = (int)l12;
            Object object = this.outputStream;
            object = Util.castNonNull(object);
            object = (OutputStream)object;
            int n13 = n10 + n12;
            ((OutputStream)object).write(byArray, n13, (int)l10);
            n12 += l10;
            long l14 = this.outputStreamBytesWritten;
            long l15 = l10;
            l14 += l15;
            this.outputStreamBytesWritten = l14;
            l12 = this.dataSpecBytesWritten + l15;
            this.dataSpecBytesWritten = l12;
        }
    }
}

