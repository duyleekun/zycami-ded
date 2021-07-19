/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package com.meicam.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsIconGenerator;
import com.meicam.sdk.NvsIconGenerator$IconCallback;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$1;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$2;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$ClipImageView;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$ContentView;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$OnScrollChangeListener;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$Thumbnail;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$ThumbnailId;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$ThumbnailSequence;
import com.meicam.sdk.NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsUtils;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class NvsMultiThumbnailSequenceView
extends HorizontalScrollView
implements NvsIconGenerator$IconCallback {
    private static final String TAG = "Meicam";
    public static final int THUMBNAIL_IMAGE_FILLMODE_ASPECTCROP = 1;
    public static final int THUMBNAIL_IMAGE_FILLMODE_STRETCH = 0;
    private static final int THUMBNAIL_SEQUENCE_FLAGS_CACHED_KEYFRAME_ONLY = 1;
    private static final int THUMBNAIL_SEQUENCE_FLAGS_CACHED_KEYFRAME_ONLY_VALID = 2;
    private NvsMultiThumbnailSequenceView$ContentView m_contentView;
    private int m_contentWidth;
    private ArrayList m_descArray;
    private int m_endPadding = 0;
    private NvsIconGenerator m_iconGenerator = null;
    private int m_maxThumbnailWidth;
    private long m_maxTimelinePosToScroll = 0L;
    private double m_pixelPerMicrosecond = 7.2E-5;
    public Bitmap m_placeholderBitmap;
    private NvsMultiThumbnailSequenceView$OnScrollChangeListener m_scrollChangeListener;
    private boolean m_scrollEnabled = true;
    private int m_startPadding = 0;
    private float m_thumbnailAspectRatio = 0.5625f;
    private int m_thumbnailImageFillMode = 0;
    private TreeMap m_thumbnailMap;
    private ArrayList m_thumbnailSequenceArray;
    private TreeMap m_thumbnailSequenceMap;
    private boolean m_updatingThumbnail;

    public NvsMultiThumbnailSequenceView(Context context) {
        super(context);
        Cloneable cloneable;
        this.m_thumbnailSequenceArray = cloneable = new Cloneable();
        super();
        this.m_thumbnailSequenceMap = cloneable;
        this.m_contentWidth = 0;
        super();
        this.m_thumbnailMap = cloneable;
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        NvsUtils.checkFunctionInMainThread();
        this.init(context);
    }

    public NvsMultiThumbnailSequenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Cloneable cloneable;
        this.m_thumbnailSequenceArray = cloneable = new Cloneable();
        super();
        this.m_thumbnailSequenceMap = cloneable;
        this.m_contentWidth = 0;
        super();
        this.m_thumbnailMap = cloneable;
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        NvsUtils.checkFunctionInMainThread();
        this.init(context);
    }

    public NvsMultiThumbnailSequenceView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        Cloneable cloneable;
        this.m_thumbnailSequenceArray = cloneable = new Cloneable();
        super();
        this.m_thumbnailSequenceMap = cloneable;
        this.m_contentWidth = 0;
        super();
        this.m_thumbnailMap = cloneable;
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        NvsUtils.checkFunctionInMainThread();
        this.init(context);
    }

    public NvsMultiThumbnailSequenceView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        Cloneable cloneable;
        this.m_thumbnailSequenceArray = cloneable = new Cloneable();
        super();
        this.m_thumbnailSequenceMap = cloneable;
        this.m_contentWidth = 0;
        super();
        this.m_thumbnailMap = cloneable;
        this.m_maxThumbnailWidth = 0;
        this.m_updatingThumbnail = false;
        NvsUtils.checkFunctionInMainThread();
        this.init(context);
    }

    public static /* synthetic */ int access$000(NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView) {
        return nvsMultiThumbnailSequenceView.m_contentWidth;
    }

    public static /* synthetic */ void access$100(NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView) {
        nvsMultiThumbnailSequenceView.requestUpdateThumbnailSequenceGeometry();
    }

    public static /* synthetic */ void access$200(NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView) {
        nvsMultiThumbnailSequenceView.updateThumbnailSequenceGeometry();
    }

    private void cancelIconTask() {
        NvsIconGenerator nvsIconGenerator = this.m_iconGenerator;
        if (nvsIconGenerator != null) {
            long l10 = 0L;
            nvsIconGenerator.cancelTask(l10);
        }
    }

    private void clearThumbnailSequences() {
        this.cancelIconTask();
        this.clearThumbnails();
        this.m_thumbnailSequenceArray.clear();
        this.m_thumbnailSequenceMap.clear();
        this.m_contentWidth = 0;
    }

    private void clearThumbnails() {
        boolean bl2;
        Iterator iterator2 = this.m_thumbnailMap.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            ImageView imageView = iterator2.next();
            NvsMultiThumbnailSequenceView$ContentView nvsMultiThumbnailSequenceView$ContentView = this.m_contentView;
            imageView = ((NvsMultiThumbnailSequenceView$Thumbnail)imageView.getValue()).m_imageView;
            nvsMultiThumbnailSequenceView$ContentView.removeView((View)imageView);
        }
        this.m_thumbnailMap.clear();
    }

    private void init(Context context) {
        NvsMultiThumbnailSequenceView$ContentView nvsMultiThumbnailSequenceView$ContentView;
        this.setVerticalScrollBarEnabled(false);
        this.setHorizontalScrollBarEnabled(false);
        this.m_contentView = nvsMultiThumbnailSequenceView$ContentView = new NvsMultiThumbnailSequenceView$ContentView(this, context);
        context = new FrameLayout.LayoutParams(-2, -1);
        this.addView((View)nvsMultiThumbnailSequenceView$ContentView, (ViewGroup.LayoutParams)context);
    }

    private void requestUpdateThumbnailSequenceGeometry() {
        Handler handler = new Handler();
        NvsMultiThumbnailSequenceView$1 nvsMultiThumbnailSequenceView$1 = new NvsMultiThumbnailSequenceView$1(this);
        handler.post((Runnable)nvsMultiThumbnailSequenceView$1);
    }

    private boolean setBitmapToThumbnail(Bitmap bitmap, NvsMultiThumbnailSequenceView$Thumbnail nvsMultiThumbnailSequenceView$Thumbnail) {
        if (bitmap != null && (nvsMultiThumbnailSequenceView$Thumbnail = nvsMultiThumbnailSequenceView$Thumbnail.m_imageView) != null) {
            nvsMultiThumbnailSequenceView$Thumbnail.setImageBitmap(bitmap);
            return true;
        }
        return false;
    }

    private boolean shouldDecodecKeyFrameOnly(String string2, long l10) {
        int n10;
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        if (nvsStreamingContext == null) {
            return false;
        }
        NvsAVFileInfo nvsAVFileInfo = nvsStreamingContext.getAVFileInfo(string2);
        if (nvsAVFileInfo == null) {
            return false;
        }
        int n11 = nvsAVFileInfo.getVideoStreamCount();
        if (n11 < (n10 = 1)) {
            return false;
        }
        NvsRational nvsRational = nvsAVFileInfo.getVideoStreamFrameRate(0);
        if (nvsRational == null) {
            return false;
        }
        int n12 = nvsRational.den;
        if (n12 > 0 && (n12 = nvsRational.num) > 0) {
            long l11 = nvsAVFileInfo.getVideoStreamDuration(0);
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object < 0) {
                return false;
            }
            int n13 = nvsStreamingContext.detectVideoFileKeyframeInterval(string2);
            int n14 = 30;
            if (n13 == 0) {
                n13 = n14;
            } else if (n13 == n10) {
                return false;
            }
            double d10 = n13;
            double d11 = nvsRational.den;
            double d12 = nvsRational.num;
            d10 *= (d11 /= d12);
            d12 = 1000000.0;
            object = (int)(d10 *= d12);
            if (n13 <= n14) {
                double d13 = l10;
                d12 = object;
                l11 = 4606281698874543309L;
                d10 = 0.9;
                double d14 = d13 - (d12 *= d10);
                n13 = (int)(d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1));
                if (n13 > 0) {
                    return n10 != 0;
                }
            } else {
                n14 = 60;
                if (n13 <= n14) {
                    double d15 = l10;
                    d12 = object;
                    l11 = 4605380978949069210L;
                    d10 = 0.8;
                    double d16 = d15 - (d12 *= d10);
                    n13 = (int)(d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1));
                    if (n13 > 0) {
                        return n10 != 0;
                    }
                } else {
                    n14 = 100;
                    if (n13 <= n14) {
                        double d17 = l10;
                        d12 = object;
                        l11 = 4604480259023595110L;
                        d10 = 0.7;
                        double d18 = d17 - (d12 *= d10);
                        n13 = (int)(d18 == 0.0 ? 0 : (d18 > 0.0 ? 1 : -1));
                        if (n13 > 0) {
                            return n10 != 0;
                        }
                    } else {
                        n14 = 150;
                        if (n13 <= n14) {
                            double d19 = l10;
                            d12 = object;
                            l11 = 4602678819172646912L;
                            d10 = 0.5;
                            double d20 = d19 - (d12 *= d10);
                            n13 = (int)(d20 == 0.0 ? 0 : (d20 > 0.0 ? 1 : -1));
                            if (n13 > 0) {
                                return n10 != 0;
                            }
                        } else {
                            n14 = 250;
                            if (n13 <= n14) {
                                double d21 = l10;
                                d12 = object;
                                l11 = 0x3FD3333333333333L;
                                d10 = 0.3;
                                double d22 = d21 - (d12 *= d10);
                                n13 = (int)(d22 == 0.0 ? 0 : (d22 > 0.0 ? 1 : -1));
                                if (n13 > 0) {
                                    return n10 != 0;
                                }
                            } else {
                                double d23 = l10;
                                d12 = object;
                                l11 = 4596373779694328218L;
                                d10 = 0.2;
                                double d24 = d23 - (d12 *= d10);
                                n13 = (int)(d24 == 0.0 ? 0 : (d24 > 0.0 ? 1 : -1));
                                if (n13 > 0) {
                                    return n10 != 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void updateKeyframeOnlyModeForThumbnailSequence(NvsMultiThumbnailSequenceView$ThumbnailSequence nvsMultiThumbnailSequenceView$ThumbnailSequence) {
        int n10 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags;
        int n11 = n10 & 2;
        if (n11 != 0) {
            return;
        }
        n11 = (int)(nvsMultiThumbnailSequenceView$ThumbnailSequence.m_onlyDecodeKeyFrame ? 1 : 0);
        if (n11 != 0) {
            nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags = n10 |= 3;
            return;
        }
        double d10 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_thumbnailWidth;
        double d11 = this.m_pixelPerMicrosecond;
        d10 = d10 / d11 + 0.5;
        long l10 = (long)d10;
        long l11 = 1L;
        d11 = Double.MIN_VALUE;
        String string2 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_mediaFilePath;
        n10 = (int)(this.shouldDecodecKeyFrameOnly(string2, l10 = Math.max(l10, l11)) ? 1 : 0);
        nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags = n10 != 0 ? (n10 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags | 1) : (n10 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags & 0xFFFFFFFE);
        nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags = n10 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags | 2;
    }

    private void updateThumbnailSequenceGeometry() {
        double d10;
        double d11;
        long l10;
        double d12;
        this.cancelIconTask();
        this.clearThumbnails();
        int n10 = this.getHeight();
        if (n10 == 0) {
            return;
        }
        TreeMap treeMap = this.m_thumbnailSequenceMap;
        treeMap.clear();
        int n11 = this.m_startPadding;
        this.m_maxThumbnailWidth = 0;
        Iterator iterator2 = this.m_thumbnailSequenceArray.iterator();
        while (true) {
            int n12;
            boolean bl2 = iterator2.hasNext();
            d12 = 0.5;
            if (!bl2) break;
            NvsMultiThumbnailSequenceView$ThumbnailSequence nvsMultiThumbnailSequenceView$ThumbnailSequence = (NvsMultiThumbnailSequenceView$ThumbnailSequence)iterator2.next();
            nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags = n12 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_flags & 0xFFFFFFFD;
            l10 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_inPoint;
            d11 = l10;
            d10 = this.m_pixelPerMicrosecond;
            d11 = Math.floor(d11 * d10 + d12);
            n12 = (int)d11;
            int n13 = this.m_startPadding;
            n12 += n13;
            long l11 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_outPoint;
            double d13 = l11;
            double d14 = this.m_pixelPerMicrosecond;
            d13 = Math.floor(d13 * d14 + d12);
            n13 = (int)d13;
            int n14 = this.m_startPadding;
            if ((n13 += n14) <= n12) continue;
            nvsMultiThumbnailSequenceView$ThumbnailSequence.m_x = n12;
            nvsMultiThumbnailSequenceView$ThumbnailSequence.m_width = n11 = n13 - n12;
            float f10 = nvsMultiThumbnailSequenceView$ThumbnailSequence.m_thumbnailAspectRatio;
            float f11 = 0.0f;
            float f12 = f10 - 0.0f;
            n14 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n14 <= 0) {
                f10 = this.m_thumbnailAspectRatio;
            }
            f11 = (float)n10 * f10;
            d10 = (double)f11 + d12;
            d12 = Math.floor(d10);
            nvsMultiThumbnailSequenceView$ThumbnailSequence.m_thumbnailWidth = n11 = (int)d12;
            nvsMultiThumbnailSequenceView$ThumbnailSequence.m_thumbnailWidth = n11 = Math.max(n11, 1);
            int n15 = this.m_maxThumbnailWidth;
            this.m_maxThumbnailWidth = n11 = Math.max(n11, n15);
            treeMap = this.m_thumbnailSequenceMap;
            Integer n16 = n12;
            treeMap.put(n16, nvsMultiThumbnailSequenceView$ThumbnailSequence);
            n11 = n13;
        }
        long l12 = this.m_maxTimelinePosToScroll;
        l10 = 0L;
        d11 = 0.0;
        n10 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1));
        if (n10 <= 0) {
            n10 = this.m_endPadding;
            n11 += n10;
        } else {
            d11 = this.m_startPadding;
            double d15 = l12;
            d10 = this.m_pixelPerMicrosecond;
            d15 *= d10;
            n10 = (int)(d15 = Math.floor(d11 = d11 + d15 + d12));
            if (n10 < n11) {
                n11 = n10;
            }
        }
        this.m_contentWidth = n11;
        NvsMultiThumbnailSequenceView$ContentView nvsMultiThumbnailSequenceView$ContentView = this.m_contentView;
        int n17 = this.getHeight();
        nvsMultiThumbnailSequenceView$ContentView.layout(0, 0, n11, n17);
        nvsMultiThumbnailSequenceView$ContentView = this.m_contentView;
        nvsMultiThumbnailSequenceView$ContentView.requestLayout();
        n10 = this.getWidth();
        n11 = this.getScrollX();
        n10 += n11;
        n11 = this.m_contentWidth;
        if (n10 > n11) {
            n10 = this.getScrollX();
            n11 = this.getWidth();
            n17 = this.getScrollX();
            n11 += n17;
            n17 = this.m_contentWidth;
            n11 -= n17;
            if ((n10 = Math.max(n10 - n11, 0)) != (n11 = this.getScrollX())) {
                this.scrollTo(n10, 0);
            }
        }
    }

    public int getEndPadding() {
        return this.m_endPadding;
    }

    public long getMaxTimelinePosToScroll() {
        return this.m_maxTimelinePosToScroll;
    }

    public NvsMultiThumbnailSequenceView$OnScrollChangeListener getOnScrollChangeListenser() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_scrollChangeListener;
    }

    public double getPixelPerMicrosecond() {
        return this.m_pixelPerMicrosecond;
    }

    public boolean getScrollEnabled() {
        return this.m_scrollEnabled;
    }

    public int getStartPadding() {
        return this.m_startPadding;
    }

    public float getThumbnailAspectRatio() {
        return this.m_thumbnailAspectRatio;
    }

    public int getThumbnailImageFillMode() {
        return this.m_thumbnailImageFillMode;
    }

    public ArrayList getThumbnailSequenceDescArray() {
        return this.m_descArray;
    }

    public long mapTimelinePosFromX(int n10) {
        NvsUtils.checkFunctionInMainThread();
        int n11 = this.getScrollX();
        n10 += n11;
        n11 = this.m_startPadding;
        double d10 = n10 - n11;
        double d11 = this.m_pixelPerMicrosecond;
        return (long)Math.floor(d10 / d11 + 0.5);
    }

    public int mapXFromTimelinePos(long l10) {
        NvsUtils.checkFunctionInMainThread();
        double d10 = l10;
        double d11 = this.m_pixelPerMicrosecond;
        int n10 = (int)Math.floor(d10 * d11 + 0.5);
        int n11 = this.getScrollX();
        int n12 = this.m_startPadding;
        return n10 + n12 - n11;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean bl2 = this.isInEditMode();
        if (!bl2) {
            NvsIconGenerator nvsIconGenerator;
            this.m_iconGenerator = nvsIconGenerator = new NvsIconGenerator();
            nvsIconGenerator.setIconCallback(this);
        }
    }

    public void onDetachedFromWindow() {
        this.cancelIconTask();
        this.m_scrollChangeListener = null;
        NvsIconGenerator nvsIconGenerator = this.m_iconGenerator;
        if (nvsIconGenerator != null) {
            nvsIconGenerator.release();
            this.m_iconGenerator = null;
        }
        super.onDetachedFromWindow();
    }

    public void onIconReady(Bitmap bitmap, long l10, long l11) {
        boolean bl2 = this.m_updatingThumbnail;
        if (!bl2) {
            this.updateThumbnails();
        } else {
            bitmap = new Handler();
            NvsMultiThumbnailSequenceView$2 nvsMultiThumbnailSequenceView$2 = new NvsMultiThumbnailSequenceView$2(this);
            bitmap.post((Runnable)nvsMultiThumbnailSequenceView$2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean bl2 = this.m_scrollEnabled;
        if (bl2) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
    }

    public void onScrollChanged(int n10, int n11, int n12, int n13) {
        super.onScrollChanged(n10, n11, n12, n13);
        NvsMultiThumbnailSequenceView$OnScrollChangeListener nvsMultiThumbnailSequenceView$OnScrollChangeListener = this.m_scrollChangeListener;
        if (nvsMultiThumbnailSequenceView$OnScrollChangeListener != null) {
            nvsMultiThumbnailSequenceView$OnScrollChangeListener.onScrollChanged(this, n10, n12);
        }
        this.updateThumbnails();
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2 = this.m_scrollEnabled;
        if (bl2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void scaleWithAnchor(double d10, int n10) {
        double d11;
        NvsUtils.checkFunctionInMainThread();
        long l10 = 0L;
        double d12 = 0.0;
        double d13 = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1);
        if (d13 <= 0) {
            return;
        }
        l10 = this.mapTimelinePosFromX(n10);
        this.m_pixelPerMicrosecond = d11 = this.m_pixelPerMicrosecond * d10;
        this.updateThumbnailSequenceGeometry();
        int n11 = this.mapXFromTimelinePos(l10);
        int n12 = this.getScrollX() + n11 - n10;
        this.scrollTo(n12, 0);
    }

    public void setEndPadding(int n10) {
        int n11;
        NvsUtils.checkFunctionInMainThread();
        if (n10 >= 0 && n10 != (n11 = this.m_endPadding)) {
            this.m_endPadding = n10;
            this.updateThumbnailSequenceGeometry();
        }
    }

    public void setMaxTimelinePosToScroll(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = Math.max(n10, 0);
        long l11 = this.m_maxTimelinePosToScroll;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n10 == 0) {
            return;
        }
        this.m_maxTimelinePosToScroll = l10;
        this.updateThumbnailSequenceGeometry();
    }

    public void setOnScrollChangeListenser(NvsMultiThumbnailSequenceView$OnScrollChangeListener nvsMultiThumbnailSequenceView$OnScrollChangeListener) {
        NvsUtils.checkFunctionInMainThread();
        this.m_scrollChangeListener = nvsMultiThumbnailSequenceView$OnScrollChangeListener;
    }

    public void setPixelPerMicrosecond(double d10) {
        double d11;
        NvsUtils.checkFunctionInMainThread();
        double d12 = 0.0;
        double d13 = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1);
        if (d13 > 0 && (d13 = (d11 = d10 - (d12 = this.m_pixelPerMicrosecond)) == 0.0 ? 0 : (d11 > 0.0 ? 1 : -1)) != false) {
            this.m_pixelPerMicrosecond = d10;
            this.updateThumbnailSequenceGeometry();
        }
    }

    public void setScrollEnabled(boolean bl2) {
        this.m_scrollEnabled = bl2;
    }

    public void setStartPadding(int n10) {
        int n11;
        NvsUtils.checkFunctionInMainThread();
        if (n10 >= 0 && n10 != (n11 = this.m_startPadding)) {
            this.m_startPadding = n10;
            this.updateThumbnailSequenceGeometry();
        }
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
        this.updateThumbnailSequenceGeometry();
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
        this.updateThumbnailSequenceGeometry();
    }

    public void setThumbnailSequenceDescArray(ArrayList object) {
        NvsUtils.checkFunctionInMainThread();
        Object object2 = this.m_descArray;
        if (object == object2) {
            return;
        }
        this.clearThumbnailSequences();
        int n10 = 0;
        float f10 = 0.0f;
        object2 = null;
        this.m_placeholderBitmap = null;
        this.m_descArray = object;
        if (object != null) {
            boolean bl2;
            long l10;
            n10 = 0;
            f10 = 0.0f;
            object2 = null;
            object = ((ArrayList)object).iterator();
            long l11 = l10 = 0L;
            while (bl2 = object.hasNext()) {
                long l12;
                long l13;
                long l14;
                long l15;
                long l16;
                long l17;
                long l18;
                long l19;
                Object object3 = (NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object.next();
                String string2 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).mediaFilePath;
                if (string2 != null && (l19 = (l18 = (l17 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).inPoint) - l11) == 0L ? 0 : (l18 < 0L ? -1 : 1)) >= 0 && (l16 = (l15 = (l14 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).outPoint) - l17) == 0L ? 0 : (l15 < 0L ? -1 : 1)) > 0 && (l19 = (l13 = (l17 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).trimIn) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0 && (l16 = (l12 = (l14 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).trimOut) - l17) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                    NvsMultiThumbnailSequenceView$ThumbnailSequence nvsMultiThumbnailSequenceView$ThumbnailSequence = new NvsMultiThumbnailSequenceView$ThumbnailSequence();
                    int n11 = n10 + 1;
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_index = n10;
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_mediaFilePath = object2 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).mediaFilePath;
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_inPoint = l17 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).inPoint;
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_outPoint = l17 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).outPoint;
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_trimIn = l17 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).trimIn;
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_trimDuration = l14 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).trimOut - l17;
                    n10 = (int)(((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).stillImageHint ? 1 : 0);
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_stillImageHint = n10;
                    n10 = (int)(((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).onlyDecodeKeyFrame ? 1 : 0);
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_onlyDecodeKeyFrame = n10;
                    nvsMultiThumbnailSequenceView$ThumbnailSequence.m_thumbnailAspectRatio = f10 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).thumbnailAspectRatio;
                    object2 = this.m_thumbnailSequenceArray;
                    ((ArrayList)object2).add(nvsMultiThumbnailSequenceView$ThumbnailSequence);
                    long l20 = ((NvsMultiThumbnailSequenceView$ThumbnailSequenceDesc)object3).outPoint;
                    n10 = n11;
                    l11 = l20;
                    continue;
                }
                object3 = TAG;
                string2 = "Invalid ThumbnailSequenceDesc!";
                Log.e((String)object3, (String)string2);
            }
        }
        this.updateThumbnailSequenceGeometry();
    }

    public void updateThumbnails() {
        int n10;
        int n11;
        NvsMultiThumbnailSequenceView$Thumbnail nvsMultiThumbnailSequenceView$Thumbnail;
        int n12;
        int n13;
        boolean bl2;
        Object object = this.m_iconGenerator;
        if (object == null) {
            return;
        }
        object = this.m_thumbnailSequenceMap;
        boolean n14 = ((AbstractMap)object).isEmpty();
        if (n14) {
            this.clearThumbnails();
            return;
        }
        int n15 = this.m_maxThumbnailWidth;
        int n16 = this.getScrollX();
        int n17 = this.getWidth();
        n16 -= n15;
        int n18 = this.m_startPadding;
        if ((n17 = n17 + (n16 = Math.max(n16, n18)) + n15) <= n16) {
            this.clearThumbnails();
            return;
        }
        object = this.m_thumbnailSequenceMap;
        Object object2 = n16;
        if ((object = ((TreeMap)object).floorKey(object2)) == null) {
            object = (Integer)this.m_thumbnailSequenceMap.firstKey();
        }
        object2 = this.m_thumbnailSequenceMap;
        object = ((TreeMap)object2).tailMap(object).entrySet().iterator();
        while (true) {
            block31: {
                int n19;
                n18 = (int)(object.hasNext() ? 1 : 0);
                bl2 = false;
                n13 = 1;
                if (n18 == 0) break;
                object2 = (NvsMultiThumbnailSequenceView$ThumbnailSequence)object.next().getValue();
                int n20 = ((NvsMultiThumbnailSequenceView$ThumbnailSequence)object2).m_x;
                n12 = ((NvsMultiThumbnailSequenceView$ThumbnailSequence)object2).m_width;
                int n21 = n20 + n12;
                if (n21 < n16) continue;
                if (n20 >= n17) break;
                if (n20 < n16) {
                    n21 = n16 - n20;
                    n19 = ((NvsMultiThumbnailSequenceView$ThumbnailSequence)object2).m_thumbnailWidth;
                    n21 = n21 / n19 * n19 + n20;
                } else {
                    n21 = n20;
                }
                n20 += n12;
                while (n21 < n20) {
                    long l10;
                    Object object3;
                    if (n21 >= n17) {
                        n18 = n13;
                        break block31;
                    }
                    n12 = ((NvsMultiThumbnailSequenceView$ThumbnailSequence)object2).m_thumbnailWidth;
                    n19 = n21 + n12;
                    if (n19 > n20) {
                        n12 = n20 - n21;
                    }
                    if ((nvsMultiThumbnailSequenceView$Thumbnail = (NvsMultiThumbnailSequenceView$Thumbnail)this.m_thumbnailMap.get(object3 = new NvsMultiThumbnailSequenceView$ThumbnailId(n11 = ((NvsMultiThumbnailSequenceView$ThumbnailSequence)object2).m_index, l10 = ((NvsMultiThumbnailSequenceView$ThumbnailSequence)object2).calcTimestampFromX(n21)))) == null) {
                        Context context;
                        nvsMultiThumbnailSequenceView$Thumbnail = new NvsMultiThumbnailSequenceView$Thumbnail();
                        nvsMultiThumbnailSequenceView$Thumbnail.m_owner = object2;
                        nvsMultiThumbnailSequenceView$Thumbnail.m_timestamp = l10;
                        nvsMultiThumbnailSequenceView$Thumbnail.m_imageViewUpToDate = false;
                        nvsMultiThumbnailSequenceView$Thumbnail.m_touched = n13;
                        Object object4 = this.m_thumbnailMap;
                        object4.put(object3, nvsMultiThumbnailSequenceView$Thumbnail);
                        n19 = ((NvsMultiThumbnailSequenceView$ThumbnailSequence)object2).m_thumbnailWidth;
                        if (n12 == n19) {
                            context = this.getContext();
                            object4 = new ImageView(context);
                            nvsMultiThumbnailSequenceView$Thumbnail.m_imageView = object4;
                        } else {
                            context = this.getContext();
                            object4 = new NvsMultiThumbnailSequenceView$ClipImageView(context, n12);
                            nvsMultiThumbnailSequenceView$Thumbnail.m_imageView = object4;
                        }
                        n19 = this.m_thumbnailImageFillMode;
                        if (n19 == 0) {
                            object4 = nvsMultiThumbnailSequenceView$Thumbnail.m_imageView;
                            context = ImageView.ScaleType.FIT_XY;
                            object4.setScaleType((ImageView.ScaleType)context);
                        } else if (n19 == n13) {
                            object4 = nvsMultiThumbnailSequenceView$Thumbnail.m_imageView;
                            context = ImageView.ScaleType.CENTER_CROP;
                            object4.setScaleType((ImageView.ScaleType)context);
                        }
                        object4 = this.m_contentView;
                        context = nvsMultiThumbnailSequenceView$Thumbnail.m_imageView;
                        object4.addView((View)context);
                        object4 = nvsMultiThumbnailSequenceView$Thumbnail.m_imageView;
                        n10 = ((NvsMultiThumbnailSequenceView$ThumbnailSequence)object2).m_thumbnailWidth + n21;
                        object3 = this.m_contentView;
                        int n22 = object3.getHeight();
                        object4.layout(n21, 0, n10, n22);
                    } else {
                        nvsMultiThumbnailSequenceView$Thumbnail.m_touched = n13;
                    }
                    n21 += n12;
                }
                n18 = 0;
                object2 = null;
            }
            if (n18 != 0) break;
        }
        this.m_updatingThumbnail = n13;
        object = new TreeMap();
        Object object5 = this.m_thumbnailMap.entrySet().iterator();
        n17 = 0;
        Object object6 = null;
        while ((n18 = (int)(object5.hasNext() ? 1 : 0)) != 0) {
            long l11;
            long l12;
            object2 = object5.next();
            NvsMultiThumbnailSequenceView$Thumbnail nvsMultiThumbnailSequenceView$Thumbnail2 = (NvsMultiThumbnailSequenceView$Thumbnail)object2.getValue();
            Object object7 = nvsMultiThumbnailSequenceView$Thumbnail2.m_imageView;
            if (object7 != null && (object7 = object7.getDrawable()) != null && (object7 = ((BitmapDrawable)object7).getBitmap()) != null) {
                this.m_placeholderBitmap = object7;
            }
            n12 = (int)(nvsMultiThumbnailSequenceView$Thumbnail2.m_touched ? 1 : 0);
            long l13 = 0L;
            if (n12 == 0) {
                l12 = nvsMultiThumbnailSequenceView$Thumbnail2.m_iconTaskId;
                long l14 = l12 - l13;
                n18 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                if (n18 != 0) {
                    object2 = this.m_iconGenerator;
                    ((NvsIconGenerator)object2).cancelTask(l12);
                }
                object2 = this.m_contentView;
                nvsMultiThumbnailSequenceView$Thumbnail2 = nvsMultiThumbnailSequenceView$Thumbnail2.m_imageView;
                object2.removeView((View)nvsMultiThumbnailSequenceView$Thumbnail2);
                object5.remove();
                continue;
            }
            nvsMultiThumbnailSequenceView$Thumbnail2.m_touched = false;
            n12 = (int)(nvsMultiThumbnailSequenceView$Thumbnail2.m_imageViewUpToDate ? 1 : 0);
            if (n12 != 0) {
                nvsMultiThumbnailSequenceView$Thumbnail2 = ((BitmapDrawable)nvsMultiThumbnailSequenceView$Thumbnail2.m_imageView.getDrawable()).getBitmap();
                object2 = (NvsMultiThumbnailSequenceView$ThumbnailId)object2.getKey();
                ((TreeMap)object).put(object2, nvsMultiThumbnailSequenceView$Thumbnail2);
                continue;
            }
            object7 = nvsMultiThumbnailSequenceView$Thumbnail2.m_owner;
            n10 = object7.m_stillImageHint;
            l12 = n10 != 0 ? l13 : nvsMultiThumbnailSequenceView$Thumbnail2.m_timestamp;
            this.updateKeyframeOnlyModeForThumbnailSequence((NvsMultiThumbnailSequenceView$ThumbnailSequence)object7);
            object7 = nvsMultiThumbnailSequenceView$Thumbnail2.m_owner;
            n11 = object7.m_flags & n13;
            if (n11 != 0) {
                n11 = n13;
            } else {
                n11 = 0;
                nvsMultiThumbnailSequenceView$Thumbnail = null;
            }
            NvsIconGenerator nvsIconGenerator = this.m_iconGenerator;
            object7 = object7.m_mediaFilePath;
            object7 = nvsIconGenerator.getIconFromCache((String)object7, l12, n11);
            if (object7 != null) {
                object2 = (NvsMultiThumbnailSequenceView$ThumbnailId)object2.getKey();
                ((TreeMap)object).put(object2, object7);
                n18 = (int)(this.setBitmapToThumbnail((Bitmap)object7, nvsMultiThumbnailSequenceView$Thumbnail2) ? 1 : 0);
                if (n18 == 0) continue;
                nvsMultiThumbnailSequenceView$Thumbnail2.m_imageViewUpToDate = n13;
                nvsMultiThumbnailSequenceView$Thumbnail2.m_iconTaskId = l13;
                continue;
            }
            object6 = this.m_iconGenerator;
            object2 = nvsMultiThumbnailSequenceView$Thumbnail2.m_owner.m_mediaFilePath;
            nvsMultiThumbnailSequenceView$Thumbnail2.m_iconTaskId = l11 = ((NvsIconGenerator)object6).getIcon((String)object2, l12, n11);
            n17 = n13;
        }
        this.m_updatingThumbnail = false;
        if (n17 == 0) {
            return;
        }
        n16 = (int)(((AbstractMap)object).isEmpty() ? 1 : 0);
        if (n16 != 0) {
            object = this.m_placeholderBitmap;
            if (object != null) {
                object = this.m_thumbnailMap.entrySet().iterator();
                while ((n16 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    object5 = (NvsMultiThumbnailSequenceView$Thumbnail)((Map.Entry)object.next()).getValue();
                    n17 = (int)(((NvsMultiThumbnailSequenceView$Thumbnail)object5).m_imageViewUpToDate ? 1 : 0);
                    if (n17 != 0) continue;
                    object6 = this.m_placeholderBitmap;
                    this.setBitmapToThumbnail((Bitmap)object6, (NvsMultiThumbnailSequenceView$Thumbnail)object5);
                }
            }
            return;
        }
        object5 = this.m_thumbnailMap.entrySet().iterator();
        while ((n17 = (int)(object5.hasNext() ? 1 : 0)) != 0) {
            object6 = object5.next();
            object2 = (NvsMultiThumbnailSequenceView$Thumbnail)object6.getValue();
            bl2 = ((NvsMultiThumbnailSequenceView$Thumbnail)object2).m_imageViewUpToDate;
            if (bl2) continue;
            object6 = (NvsMultiThumbnailSequenceView$ThumbnailId)object6.getKey();
            if ((object6 = ((TreeMap)object).ceilingEntry(object6)) != null) {
                object6 = (Bitmap)object6.getValue();
                this.setBitmapToThumbnail((Bitmap)object6, (NvsMultiThumbnailSequenceView$Thumbnail)object2);
                continue;
            }
            object6 = (Bitmap)((TreeMap)object).lastEntry().getValue();
            this.setBitmapToThumbnail((Bitmap)object6, (NvsMultiThumbnailSequenceView$Thumbnail)object2);
        }
    }
}

