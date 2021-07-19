/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.RawResourceDataSource$RawResourceDataSourceException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class RawResourceDataSource
extends BaseDataSource {
    public static final String RAW_RESOURCE_SCHEME = "rawresource";
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private InputStream inputStream;
    private boolean opened;
    private final String packageName;
    private final Resources resources;
    private Uri uri;

    public RawResourceDataSource(Context object) {
        super(false);
        Resources resources;
        this.resources = resources = object.getResources();
        object = object.getPackageName();
        this.packageName = object;
    }

    public static Uri buildRawResourceUri(int n10) {
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("rawresource:///");
        stringBuilder.append(n10);
        return Uri.parse((String)stringBuilder.toString());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Throwable throwable4222222;
        Throwable throwable22222222;
        boolean bl2;
        block19: {
            Throwable throwable32222222;
            bl2 = false;
            this.uri = null;
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            this.inputStream = null;
            {
                catch (Throwable throwable22222222) {
                    break block19;
                }
                catch (IOException iOException) {}
                {
                    RawResourceDataSource$RawResourceDataSourceException rawResourceDataSource$RawResourceDataSourceException = new RawResourceDataSource$RawResourceDataSourceException(iOException);
                    throw rawResourceDataSource$RawResourceDataSourceException;
                }
            }
            inputStream = this.assetFileDescriptor;
            if (inputStream != null) {
                inputStream.close();
            }
            this.assetFileDescriptor = null;
            bl2 = this.opened;
            if (!bl2) return;
            this.opened = false;
            this.transferEnded();
            return;
            {
                catch (Throwable throwable32222222) {
                }
                catch (IOException iOException) {}
                {
                    RawResourceDataSource$RawResourceDataSourceException rawResourceDataSource$RawResourceDataSourceException = new RawResourceDataSource$RawResourceDataSourceException(iOException);
                    throw rawResourceDataSource$RawResourceDataSourceException;
                }
            }
            this.assetFileDescriptor = null;
            bl2 = this.opened;
            if (!bl2) throw throwable32222222;
            this.opened = false;
            this.transferEnded();
            throw throwable32222222;
        }
        this.inputStream = null;
        AssetFileDescriptor assetFileDescriptor = this.assetFileDescriptor;
        if (assetFileDescriptor != null) {
            assetFileDescriptor.close();
        }
        this.assetFileDescriptor = null;
        bl2 = this.opened;
        if (!bl2) throw throwable22222222;
        this.opened = false;
        this.transferEnded();
        throw throwable22222222;
        {
            catch (Throwable throwable4222222) {
            }
            catch (IOException iOException) {}
            {
                RawResourceDataSource$RawResourceDataSourceException rawResourceDataSource$RawResourceDataSourceException = new RawResourceDataSource$RawResourceDataSourceException(iOException);
                throw rawResourceDataSource$RawResourceDataSourceException;
            }
        }
        this.assetFileDescriptor = null;
        bl2 = this.opened;
        if (!bl2) throw throwable4222222;
        this.opened = false;
        this.transferEnded();
        throw throwable4222222;
    }

    public Uri getUri() {
        return this.uri;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long open(DataSpec object) {
        block16: {
            long l10;
            long l11;
            String string2;
            Object object2;
            Object object3 = ((DataSpec)object).uri;
            this.uri = object3;
            Object object4 = object3.getScheme();
            CharSequence charSequence = RAW_RESOURCE_SCHEME;
            int n10 = TextUtils.equals((CharSequence)charSequence, (CharSequence)object4);
            int n11 = 1;
            if (n10 == 0 && ((n10 = TextUtils.equals((CharSequence)(object2 = "android.resource"), (CharSequence)(object4 = object3.getScheme()))) == 0 || (n10 = (object4 = object3.getPathSegments()).size()) != n11 || (n10 = (int)(((String)(object4 = (String)Assertions.checkNotNull(object3.getLastPathSegment()))).matches(string2 = "\\d+") ? 1 : 0)) == 0)) {
                int n12;
                object4 = object3.getScheme();
                n10 = (int)(TextUtils.equals((CharSequence)object2, (CharSequence)object4) ? 1 : 0);
                if (n10 == 0) {
                    object = new RawResourceDataSource$RawResourceDataSourceException("URI must either use scheme rawresource or android.resource");
                    throw object;
                }
                object4 = (String)Assertions.checkNotNull(object3.getPath());
                boolean bl2 = ((String)object4).startsWith((String)(object2 = "/"));
                if (bl2) {
                    object4 = ((String)object4).substring(n11);
                }
                if ((n12 = TextUtils.isEmpty((CharSequence)(object2 = object3.getHost()))) != 0) {
                    object2 = "";
                } else {
                    object2 = String.valueOf(object2);
                    string2 = ":";
                    object2 = ((String)object2).concat(string2);
                }
                object2 = String.valueOf(object2);
                object4 = String.valueOf(object4);
                n12 = ((String)object4).length();
                object4 = n12 != 0 ? ((String)object2).concat((String)object4) : new String((String)object2);
                object2 = this.resources;
                string2 = this.packageName;
                String string3 = "raw";
                n10 = object2.getIdentifier((String)object4, string3, string2);
                if (n10 == 0) {
                    object = new RawResourceDataSource$RawResourceDataSourceException("Resource not found.");
                    throw object;
                }
            } else {
                object4 = object3.getLastPathSegment();
                object4 = Assertions.checkNotNull(object4);
                object4 = (String)object4;
                n10 = Integer.parseInt((String)object4);
            }
            this.transferInitializing((DataSpec)object);
            object2 = this.resources;
            object4 = object2.openRawResourceFd(n10);
            this.assetFileDescriptor = object4;
            if (object4 == null) {
                object3 = String.valueOf(object3);
                n10 = String.valueOf(object3).length() + 24;
                charSequence = new StringBuilder(n10);
                ((StringBuilder)charSequence).append("Resource is compressed: ");
                ((StringBuilder)charSequence).append((String)object3);
                object3 = ((StringBuilder)charSequence).toString();
                object = new RawResourceDataSource$RawResourceDataSourceException((String)object3);
                throw object;
            }
            object2 = object4.getFileDescriptor();
            object3 = new FileInputStream((FileDescriptor)object2);
            this.inputStream = object3;
            try {
                l11 = object4.getStartOffset();
                ((FileInputStream)object3).skip(l11);
                l11 = ((DataSpec)object).position;
                l11 = ((FileInputStream)object3).skip(l11);
                l10 = ((DataSpec)object).position;
                long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (l12 < 0) break block16;
            }
            catch (IOException iOException) {
                object3 = new RawResourceDataSource$RawResourceDataSourceException(iOException);
                throw object3;
            }
            l11 = ((DataSpec)object).length;
            l10 = -1;
            long l13 = l11 - l10;
            Object object5 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object5 != false) {
                this.bytesRemaining = l11;
            } else {
                long l14 = object4.getLength();
                long l15 = l14 - l10;
                Object object6 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object6 != false) {
                    l11 = ((DataSpec)object).position;
                    l10 = l14 - l11;
                }
                this.bytesRemaining = l10;
            }
            this.opened = n11;
            this.transferStarted((DataSpec)object);
            return this.bytesRemaining;
        }
        object = new EOFException();
        throw object;
        catch (NumberFormatException numberFormatException) {
            object = new RawResourceDataSource$RawResourceDataSourceException("Resource identifier must be an integer.");
            throw object;
        }
    }

    public int read(byte[] object, int n10, int n11) {
        int n12;
        long l10;
        long l11;
        block11: {
            Object object2;
            if (n11 == 0) {
                return 0;
            }
            l11 = this.bytesRemaining;
            long l12 = 0L;
            Object object3 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            int n13 = -1;
            if (object3 == false) {
                return n13;
            }
            l10 = -1;
            long l13 = l11 - l10;
            object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 != false) {
                long l14 = n11;
                l11 = Math.min(l11, l14);
                n11 = (int)l11;
            }
            try {
                object2 = this.inputStream;
            }
            catch (IOException iOException) {
                RawResourceDataSource$RawResourceDataSourceException rawResourceDataSource$RawResourceDataSourceException = new RawResourceDataSource$RawResourceDataSourceException(iOException);
                throw rawResourceDataSource$RawResourceDataSourceException;
            }
            object2 = Util.castNonNull(object2);
            object2 = (InputStream)object2;
            n12 = ((InputStream)object2).read((byte[])object, n10, n11);
            if (n12 != n13) break block11;
            long l15 = this.bytesRemaining;
            long l16 = l15 - l10;
            n12 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
            if (n12 == 0) {
                return n13;
            }
            object = new RawResourceDataSource$RawResourceDataSourceException;
            EOFException eOFException = new EOFException();
            object(eOFException);
            throw object;
        }
        long l17 = this.bytesRemaining;
        long l18 = l17 - l10;
        Object object4 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object4 != false) {
            l11 = n12;
            this.bytesRemaining = l17 -= l11;
        }
        this.bytesTransferred(n12);
        return n12;
    }
}

