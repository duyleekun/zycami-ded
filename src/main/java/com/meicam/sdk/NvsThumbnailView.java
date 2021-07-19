/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.meicam.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.meicam.sdk.NvsThumbnailView$1;
import com.meicam.sdk.NvsUtils;

public class NvsThumbnailView
extends View {
    private long m_internalObj = 0L;
    private String m_mediaFilePath;
    private boolean m_needUpdate = false;
    private boolean m_painting = false;
    private Bitmap m_thumbnail = null;
    private long m_timestamp = -2;

    public NvsThumbnailView(Context context) {
        super(context);
    }

    public NvsThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NvsThumbnailView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public NvsThumbnailView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
    }

    public static /* synthetic */ Bitmap access$002(NvsThumbnailView nvsThumbnailView, Bitmap bitmap) {
        nvsThumbnailView.m_thumbnail = bitmap;
        return bitmap;
    }

    private void cancelIconTask() {
        boolean bl2 = this.isInEditMode();
        if (!bl2) {
            long l10 = this.m_internalObj;
            this.nativeCancelIconTask(l10);
        }
    }

    private native void nativeCancelIconTask(long var1);

    private native void nativeClose(long var1);

    private native void nativeGetThumbnail(long var1, String var3, long var4);

    private native long nativeInit();

    public String getMediaFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_mediaFilePath;
    }

    public void notifyThumbnailArrived(Bitmap bitmap) {
        boolean bl2 = this.m_painting;
        if (!bl2) {
            this.m_thumbnail = bitmap;
            this.invalidate();
        } else {
            Handler handler = new Handler();
            NvsThumbnailView$1 nvsThumbnailView$1 = new NvsThumbnailView$1(this, bitmap);
            handler.post((Runnable)nvsThumbnailView$1);
        }
    }

    public void onAttachedToWindow() {
        boolean bl2 = this.isInEditMode();
        if (!bl2) {
            long l10;
            this.m_internalObj = l10 = this.nativeInit();
        }
    }

    public void onDetachedFromWindow() {
        this.cancelIconTask();
        long l10 = this.m_internalObj;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            this.nativeClose(l10);
            this.m_internalObj = l11;
        }
        this.m_thumbnail = null;
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        boolean bl2;
        super.onDraw(canvas);
        String string2 = this.m_mediaFilePath;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            string2 = this.m_thumbnail;
            if (string2 != null && !(bl2 = this.m_needUpdate)) {
                string2 = new Rect();
                this.getDrawingRect((Rect)string2);
                Bitmap bitmap = this.m_thumbnail;
                int n10 = bitmap.getWidth();
                Bitmap bitmap2 = this.m_thumbnail;
                int n11 = bitmap2.getHeight();
                double d10 = n10;
                n10 = string2.width();
                double d11 = n10;
                d11 = d10 / d11;
                double d12 = n11;
                int n12 = string2.height();
                double d13 = n12;
                d13 = d12 / d13;
                double d14 = d11 == d13 ? 0 : (d11 > d13 ? 1 : -1);
                double d15 = 2.0;
                if (d14 > 0) {
                    n10 = ((Rect)string2).left;
                    d11 = ((double)string2.width() - (d10 /= d13)) / d15;
                    n11 = (int)d11;
                    ((Rect)string2).left = n10 += n11;
                    d12 = (double)n10 + d10;
                    ((Rect)string2).right = n10 = (int)d12;
                } else {
                    int n13 = ((Rect)string2).top;
                    double d16 = ((double)string2.height() - (d12 /= d11)) / d15;
                    int n14 = (int)d16;
                    ((Rect)string2).top = n13 += n14;
                    d10 = (double)n13 + d12;
                    ((Rect)string2).bottom = n10 = (int)d10;
                }
                bitmap = new Paint(2);
                bitmap2 = this.m_thumbnail;
                canvas.drawBitmap(bitmap2, null, (Rect)string2, (Paint)bitmap);
                return;
            }
            long l10 = this.m_internalObj;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                return;
            }
            object = 0;
            canvas = null;
            this.m_needUpdate = false;
            this.m_painting = true;
            bl2 = this.isInEditMode();
            if (!bl2) {
                l11 = this.m_internalObj;
                String string3 = this.m_mediaFilePath;
                long l13 = this.m_timestamp;
                NvsThumbnailView nvsThumbnailView = this;
                this.nativeGetThumbnail(l11, string3, l13);
            }
            this.m_painting = false;
        }
    }

    public void setMediaFilePath(String string2) {
        this.setMediaFilePath(string2, -1);
    }

    public void setMediaFilePath(String string2, long l10) {
        long l11;
        long l12;
        boolean bl2;
        NvsUtils.checkFunctionInMainThread();
        String string3 = this.m_mediaFilePath;
        if (string3 != null && string2 != null && (bl2 = string3.equals(string2)) && !(bl2 = (l12 = l10 - (l11 = this.m_timestamp)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            return;
        }
        this.m_mediaFilePath = string2;
        this.m_timestamp = l10;
        this.m_needUpdate = true;
        this.cancelIconTask();
        this.invalidate();
    }
}

