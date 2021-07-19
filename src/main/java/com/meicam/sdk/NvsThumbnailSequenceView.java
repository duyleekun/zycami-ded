/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.meicam.sdk;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.meicam.sdk.NvsMultiThumbnailSequenceView;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc;
import com.meicam.sdk.NvsThumbnailSequenceView$1;
import com.meicam.sdk.NvsUtils;
import java.util.ArrayList;

public class NvsThumbnailSequenceView
extends ViewGroup {
    private long m_duration = 4000000L;
    private NvsMultiThumbnailSequenceView m_internalView;
    private String m_mediaFilePath;
    private boolean m_needsUpdateInternalView = false;
    private long m_startTime = 0L;
    private boolean m_stillImageHint = false;
    private float m_thumbnailAspectRatio = 0.5625f;
    private int m_thumbnailImageFillMode = 0;

    public NvsThumbnailSequenceView(Context context) {
        super(context);
        NvsUtils.checkFunctionInMainThread();
        this.init(context);
    }

    public NvsThumbnailSequenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NvsUtils.checkFunctionInMainThread();
        this.init(context);
    }

    public NvsThumbnailSequenceView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        NvsUtils.checkFunctionInMainThread();
        this.init(context);
    }

    public NvsThumbnailSequenceView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        NvsUtils.checkFunctionInMainThread();
        this.init(context);
    }

    public static /* synthetic */ void access$000(NvsThumbnailSequenceView nvsThumbnailSequenceView) {
        nvsThumbnailSequenceView.doUpdateInternalView();
    }

    private void doUpdateInternalView() {
        long l10;
        long l11;
        int n10 = this.m_needsUpdateInternalView;
        if (n10 == 0) {
            return;
        }
        this.m_needsUpdateInternalView = false;
        Object object = this.m_internalView;
        float f10 = this.m_thumbnailAspectRatio;
        ((NvsMultiThumbnailSequenceView)object).setThumbnailAspectRatio(f10);
        n10 = this.getWidth();
        ArrayList<Object> arrayList = this.m_internalView;
        double d10 = n10;
        long l12 = this.m_duration;
        double d11 = l12;
        ((NvsMultiThumbnailSequenceView)((Object)arrayList)).setPixelPerMicrosecond(d10 /= d11);
        object = this.m_internalView;
        int n11 = this.m_thumbnailImageFillMode;
        ((NvsMultiThumbnailSequenceView)object).setThumbnailImageFillMode(n11);
        object = this.m_mediaFilePath;
        if (object == null) {
            this.m_internalView.setThumbnailSequenceDescArray(null);
            return;
        }
        object = new NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc();
        arrayList = this.m_mediaFilePath;
        ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object).mediaFilePath = arrayList;
        ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object).inPoint = 0L;
        ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object).outPoint = l11 = this.m_duration;
        ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object).trimIn = l10 = this.m_startTime;
        ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object).trimOut = l10 += l11;
        n11 = (int)(this.m_stillImageHint ? 1 : 0);
        ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object).stillImageHint = n11;
        arrayList = new ArrayList<Object>();
        arrayList.add(object);
        this.m_internalView.setThumbnailSequenceDescArray(arrayList);
    }

    private void init(Context object) {
        NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView;
        this.m_internalView = nvsMultiThumbnailSequenceView = new NvsMultiThumbnailSequenceView((Context)object);
        nvsMultiThumbnailSequenceView.setScrollEnabled(false);
        object = this.m_internalView;
        int n10 = -1;
        nvsMultiThumbnailSequenceView = new ViewGroup.LayoutParams(n10, n10);
        this.addView((View)object, (ViewGroup.LayoutParams)nvsMultiThumbnailSequenceView);
    }

    private void updateInternalView() {
        this.m_needsUpdateInternalView = true;
        Handler handler = new Handler();
        NvsThumbnailSequenceView$1 nvsThumbnailSequenceView$1 = new NvsThumbnailSequenceView$1(this);
        handler.post((Runnable)nvsThumbnailSequenceView$1);
    }

    public long getDuration() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_duration;
    }

    public String getMediaFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_mediaFilePath;
    }

    public long getStartTime() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_startTime;
    }

    public boolean getStillImageHint() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_stillImageHint;
    }

    public float getThumbnailAspectRatio() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_thumbnailAspectRatio;
    }

    public int getThumbnailImageFillMode() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_thumbnailImageFillMode;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView = this.m_internalView;
        n10 = this.getWidth();
        n11 = this.getHeight();
        nvsMultiThumbnailSequenceView.layout(0, 0, n10, n11);
    }

    public void onMeasure(int n10, int n11) {
        this.m_internalView.measure(n10, n11);
        super.onMeasure(n10, n11);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        if (n12 != n10) {
            this.updateInternalView();
        }
        super.onSizeChanged(n10, n11, n12, n13);
    }

    public void setDuration(long l10) {
        long l11;
        NvsUtils.checkFunctionInMainThread();
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (l13 <= 0) {
            l10 = 1L;
        }
        if ((l13 = (l11 = l10 - (l12 = this.m_duration)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
            return;
        }
        this.m_duration = l10;
        this.updateInternalView();
    }

    public void setMediaFilePath(String string2) {
        boolean bl2;
        NvsUtils.checkFunctionInMainThread();
        String string3 = this.m_mediaFilePath;
        if (string3 != null && string2 != null && (bl2 = string3.equals(string2))) {
            return;
        }
        this.m_mediaFilePath = string2;
        this.updateInternalView();
    }

    public void setStartTime(long l10) {
        long l11;
        long l12;
        NvsUtils.checkFunctionInMainThread();
        long l13 = 0L;
        long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        if (l14 < 0) {
            l10 = l13;
        }
        if ((l12 = (l11 = l10 - (l13 = this.m_startTime)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
            return;
        }
        this.m_startTime = l10;
        this.updateInternalView();
    }

    public void setStillImageHint(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        boolean bl3 = this.m_stillImageHint;
        if (bl2 == bl3) {
            return;
        }
        this.m_stillImageHint = bl2;
        this.updateInternalView();
    }

    public void setThumbnailAspectRatio(float f10) {
        NvsUtils.checkFunctionInMainThread();
        int n10 = 0x3DCCCCCD;
        float f11 = 0.1f;
        float f12 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        float f13 = 10.0f;
        if (f12 < 0) {
            f10 = f11;
        } else {
            n10 = (int)(f10 == f13 ? 0 : (f10 > f13 ? 1 : -1));
            if (n10 > 0) {
                f10 = f13;
            }
        }
        f11 = Math.abs(this.m_thumbnailAspectRatio - f10);
        f12 = 981668463;
        float f14 = 0.001f;
        n10 = (int)(f11 == f14 ? 0 : (f11 < f14 ? -1 : 1));
        if (n10 < 0) {
            return;
        }
        this.m_thumbnailAspectRatio = f10;
        this.updateInternalView();
    }

    public void setThumbnailImageFillMode(int n10) {
        NvsUtils.checkFunctionInMainThread();
        int n11 = this.m_thumbnailImageFillMode;
        int n12 = 1;
        if (n11 != n12 && n11 != 0) {
            n11 = 0;
            this.m_thumbnailImageFillMode = 0;
        }
        if ((n11 = this.m_thumbnailImageFillMode) == n10) {
            return;
        }
        this.m_thumbnailImageFillMode = n10;
        this.updateInternalView();
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

