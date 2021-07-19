/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.network.ByteCounterInputStream;
import com.mob.tools.network.OnReadListener;
import com.mob.tools.utils.ReflectHelper;
import java.io.InputStream;

public abstract class HTTPPart {
    private OnReadListener listener;
    private long offset;

    public abstract InputStream getInputStream();

    public Object getInputStreamEntity() {
        Object object = this.toInputStream();
        long l10 = this.length();
        long l11 = this.offset;
        ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
        Object[] objectArray = new Object[]{object, object = Long.valueOf(l10 -= l11)};
        return ReflectHelper.newInstance("InputStreamEntity", objectArray);
    }

    public abstract long length();

    public void setOffset(long l10) {
        this.offset = l10;
    }

    public void setOnReadListener(OnReadListener onReadListener) {
        this.listener = onReadListener;
    }

    public InputStream toInputStream() {
        Object object = this.getInputStream();
        ByteCounterInputStream byteCounterInputStream = new ByteCounterInputStream((InputStream)object);
        object = this.listener;
        byteCounterInputStream.setOnInputStreamReadListener((OnReadListener)object);
        long l10 = this.offset;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            byteCounterInputStream.skip(l10);
        }
        return byteCounterInputStream;
    }
}

