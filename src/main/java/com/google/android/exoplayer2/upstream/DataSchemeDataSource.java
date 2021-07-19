/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Base64
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.net.URLDecoder;

public final class DataSchemeDataSource
extends BaseDataSource {
    public static final String SCHEME_DATA = "data";
    private byte[] data;
    private DataSpec dataSpec;
    private int endPosition;
    private int readPosition;

    public DataSchemeDataSource() {
        super(false);
    }

    public void close() {
        byte[] byArray = this.data;
        if (byArray != null) {
            this.data = null;
            this.transferEnded();
        }
        this.dataSpec = null;
    }

    public Uri getUri() {
        DataSpec dataSpec = this.dataSpec;
        dataSpec = dataSpec != null ? dataSpec.uri : null;
        return dataSpec;
    }

    public long open(DataSpec object) {
        int n10;
        int n11;
        this.transferInitializing((DataSpec)object);
        this.dataSpec = object;
        long l10 = ((DataSpec)object).position;
        this.readPosition = n11 = (int)l10;
        Object object2 = ((DataSpec)object).uri;
        Object object3 = object2.getScheme();
        CharSequence charSequence = SCHEME_DATA;
        boolean n12 = ((String)charSequence).equals(object3);
        if (!n12) {
            object2 = "Unsupported scheme: ";
            int n13 = (object3 = String.valueOf(object3)).length();
            if (n13 != 0) {
                object2 = object2.concat((String)object3);
            } else {
                object3 = new String((String)object2);
                object2 = object3;
            }
            object = new ParserException((String)object2);
            throw object;
        }
        object3 = object2.getSchemeSpecificPart();
        charSequence = ",";
        int n14 = ((String[])(object3 = Util.split((String)object3, (String)charSequence))).length;
        if (n14 == (n10 = 2)) {
            n11 = 1;
            object2 = object3[n11];
            boolean bl2 = false;
            charSequence = null;
            String string2 = ";base64";
            int n15 = (object3 = object3[0]).contains(string2);
            if (n15 != 0) {
                try {
                    object3 = Base64.decode((String)object2, (int)0);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    charSequence = "Error while parsing Base64 encoded string: ";
                    object2 = String.valueOf(object2);
                    n10 = object2.length();
                    object2 = n10 != 0 ? ((String)charSequence).concat((String)object2) : new String((String)charSequence);
                    object3 = new ParserException((String)object2, illegalArgumentException);
                    throw object3;
                }
                this.data = (byte[])object3;
            } else {
                object3 = Charsets.US_ASCII.name();
                object2 = Util.getUtf8Bytes(URLDecoder.decode((String)object2, (String)object3));
                this.data = (byte[])object2;
            }
            l10 = ((DataSpec)object).length;
            long l11 = -1;
            n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n10 != 0) {
                n11 = (int)l10;
                n15 = this.readPosition;
                n11 += n15;
            } else {
                object2 = this.data;
                n11 = ((Uri)object2).length;
            }
            this.endPosition = n11;
            object3 = this.data;
            n15 = ((String[])object3).length;
            if (n11 <= n15 && (n15 = this.readPosition) <= n11) {
                this.transferStarted((DataSpec)object);
                l10 = this.endPosition;
                long l12 = this.readPosition;
                return l10 - l12;
            }
            this.data = null;
            object = new DataSourceException(0);
            throw object;
        }
        object2 = String.valueOf(object2);
        int n16 = String.valueOf(object2).length() + 23;
        charSequence = new StringBuilder(n16);
        ((StringBuilder)charSequence).append("Unexpected URI format: ");
        ((StringBuilder)charSequence).append((String)object2);
        object2 = ((StringBuilder)charSequence).toString();
        object = new ParserException((String)object2);
        throw object;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        if (n11 == 0) {
            return 0;
        }
        int n13 = this.endPosition;
        int n14 = this.readPosition;
        if ((n13 -= n14) == 0) {
            return -1;
        }
        n11 = Math.min(n11, n13);
        Object object = Util.castNonNull(this.data);
        n14 = this.readPosition;
        System.arraycopy(object, n14, byArray, n10, n11);
        this.readPosition = n12 = this.readPosition + n11;
        this.bytesTransferred(n11);
        return n11;
    }
}

