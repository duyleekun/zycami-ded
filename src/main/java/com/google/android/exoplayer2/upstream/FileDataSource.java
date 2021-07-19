/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource$FileDataSourceException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource
extends BaseDataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private boolean opened;
    private Uri uri;

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile openLocalFile(Uri object) {
        Object[] objectArray;
        Object object2;
        try {
            object2 = object.getPath();
        }
        catch (FileNotFoundException fileNotFoundException) {
            object2 = object.getQuery();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)(object2 = object.getFragment())))) {
                object = new FileDataSource$FileDataSourceException(fileNotFoundException);
                throw object;
            }
            objectArray = new Object[3];
            String string2 = object.getPath();
            objectArray[0] = string2;
            string2 = object.getQuery();
            objectArray[1] = string2;
            object = object.getFragment();
            objectArray[2] = object;
            object = String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", objectArray);
            object2 = new FileDataSource$FileDataSourceException((String)object, fileNotFoundException);
            throw object2;
        }
        object2 = Assertions.checkNotNull(object2);
        object2 = (String)object2;
        objectArray = "r";
        RandomAccessFile randomAccessFile = new RandomAccessFile((String)object2, (String)objectArray);
        return randomAccessFile;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Throwable throwable2222222;
        boolean bl2 = false;
        this.uri = null;
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.file = null;
        bl2 = this.opened;
        if (bl2) {
            this.opened = false;
            this.transferEnded();
        }
        return;
        {
            catch (Throwable throwable2222222) {
            }
            catch (IOException iOException) {}
            {
                FileDataSource$FileDataSourceException fileDataSource$FileDataSourceException = new FileDataSource$FileDataSourceException(iOException);
                throw fileDataSource$FileDataSourceException;
            }
        }
        this.file = null;
        bl2 = this.opened;
        if (bl2) {
            this.opened = false;
            this.transferEnded();
        }
        throw throwable2222222;
    }

    public Uri getUri() {
        return this.uri;
    }

    public long open(DataSpec object) {
        block13: {
            Object object2;
            try {
                object2 = ((DataSpec)object).uri;
            }
            catch (IOException iOException) {
                object2 = new FileDataSource$FileDataSourceException(iOException);
                throw object2;
            }
            this.uri = object2;
            this.transferInitializing((DataSpec)object);
            object2 = FileDataSource.openLocalFile((Uri)object2);
            this.file = object2;
            long l10 = ((DataSpec)object).position;
            ((RandomAccessFile)object2).seek(l10);
            long l11 = ((DataSpec)object).length;
            long l12 = -1;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 == false) {
                object2 = this.file;
                l11 = ((RandomAccessFile)object2).length();
                l12 = ((DataSpec)object).position;
                l11 -= l12;
            }
            this.bytesRemaining = l11;
            l12 = 0L;
            long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l14 < 0) break block13;
            this.opened = true;
            this.transferStarted((DataSpec)object);
            return this.bytesRemaining;
        }
        object = new EOFException();
        throw object;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        block9: {
            Object object;
            if (n11 == 0) {
                return 0;
            }
            long l10 = this.bytesRemaining;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                return -1;
            }
            try {
                object = this.file;
            }
            catch (IOException iOException) {
                FileDataSource$FileDataSourceException fileDataSource$FileDataSourceException = new FileDataSource$FileDataSourceException(iOException);
                throw fileDataSource$FileDataSourceException;
            }
            object = Util.castNonNull(object);
            object = (RandomAccessFile)object;
            long l13 = this.bytesRemaining;
            long l14 = n11;
            l13 = Math.min(l13, l14);
            n11 = (int)l13;
            n12 = ((RandomAccessFile)object).read(byArray, n10, n11);
            if (n12 <= 0) break block9;
            long l15 = this.bytesRemaining;
            l10 = n12;
            this.bytesRemaining = l15 -= l10;
            this.bytesTransferred(n12);
        }
        return n12;
    }
}

