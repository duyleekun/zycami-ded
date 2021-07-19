/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Point
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.media.ExifInterface
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnLongClickListener
 *  android.view.ViewParent
 */
package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.R$styleable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$1;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$2;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$AnimationBuilder;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnImageEventListener;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnStateChangedListener;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TileLoadTask;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TilesInitTask;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

public class SubsamplingScaleImageView
extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = 255;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    private static final String TAG;
    public static int TILE_SIZE_AUTO = 0;
    private static final List VALID_EASING_STYLES;
    private static final List VALID_ORIENTATIONS;
    private static final List VALID_PAN_LIMITS;
    private static final List VALID_SCALE_TYPES;
    private static final List VALID_ZOOM_STYLES;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private SubsamplingScaleImageView$Anim anim;
    private Bitmap bitmap;
    private DecoderFactory bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugPaint;
    private ImageRegionDecoder decoder;
    private final Object decoderLock;
    private float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private float[] dstArray;
    private int fullImageSampleSize;
    private Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private SubsamplingScaleImageView$OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private SubsamplingScaleImageView$OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private boolean parallelLoadingEnabled;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private DecoderFactory regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private SubsamplingScaleImageView$ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private float[] srcArray;
    private Paint tileBgPaint;
    private Map tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;

    static {
        Integer n10;
        TAG = SubsamplingScaleImageView.class.getSimpleName();
        Integer[] integerArray = new Integer[5];
        integerArray[0] = n10 = Integer.valueOf(0);
        n10 = 90;
        int n11 = 1;
        Integer n12 = n11;
        integerArray[n11] = n10;
        n10 = 180;
        int n13 = 2;
        Integer n14 = n13;
        integerArray[n13] = n10;
        n10 = 270;
        int n15 = 3;
        Integer n16 = n15;
        integerArray[n15] = n10;
        integerArray[4] = n10 = Integer.valueOf(-1);
        VALID_ORIENTATIONS = Arrays.asList(integerArray);
        integerArray = new Integer[n15];
        integerArray[0] = n12;
        integerArray[n11] = n14;
        integerArray[n13] = n16;
        VALID_ZOOM_STYLES = Arrays.asList(integerArray);
        integerArray = new Integer[n13];
        integerArray[0] = n14;
        integerArray[n11] = n12;
        VALID_EASING_STYLES = Arrays.asList(integerArray);
        integerArray = new Integer[n15];
        integerArray[0] = n12;
        integerArray[n11] = n14;
        integerArray[n13] = n16;
        VALID_PAN_LIMITS = Arrays.asList(integerArray);
        integerArray = new Integer[n15];
        integerArray[0] = n14;
        integerArray[n11] = n12;
        integerArray[n13] = n16;
        VALID_SCALE_TYPES = Arrays.asList(integerArray);
        TILE_SIZE_AUTO = -1 >>> 1;
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        float f11;
        Object object;
        int n10;
        float f12;
        int n11 = 0;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = f12 = this.minScale();
        this.minimumTileDpi = -1;
        boolean bl2 = true;
        f12 = Float.MIN_VALUE;
        this.panLimit = bl2;
        this.minimumScaleType = bl2;
        this.maxTileWidth = n10 = TILE_SIZE_AUTO;
        this.maxTileHeight = n10;
        this.panEnabled = bl2;
        this.zoomEnabled = bl2;
        this.quickScaleEnabled = bl2;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = bl2;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = object = new Object();
        this.bitmapDecoderFactory = object = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = object = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        n10 = 8;
        Object object2 = new float[n10];
        this.srcArray = object2;
        object = new float[n10];
        this.dstArray = (float[])object;
        this.density = f11 = this.getResources().getDisplayMetrics().density;
        n10 = 160;
        f11 = 2.24E-43f;
        this.setMinimumDpi(n10);
        this.setDoubleTapZoomDpi(n10);
        this.setGestureDetector(context);
        object2 = new SubsamplingScaleImageView$1;
        super(this);
        object = new Handler((Handler.Callback)object2);
        this.handler = object;
        if (attributeSet != null) {
            object = this.getContext();
            attributeSet = object.obtainStyledAttributes(attributeSet, (int[])(object2 = (Object)R$styleable.SubsamplingScaleImageView));
            int n12 = attributeSet.hasValue(n10 = R$styleable.SubsamplingScaleImageView_assetName);
            if (n12 != 0 && (object = attributeSet.getString(n10)) != null && (n12 = ((String)object).length()) > 0) {
                object = ImageSource.asset((String)object).tilingEnabled();
                this.setImage((ImageSource)object);
            }
            if ((n12 = attributeSet.hasValue(n10 = R$styleable.SubsamplingScaleImageView_src)) != 0 && (n10 = attributeSet.getResourceId(n10, 0)) > 0) {
                object = ImageSource.resource(n10).tilingEnabled();
                this.setImage((ImageSource)object);
            }
            if ((n12 = (int)(attributeSet.hasValue(n10 = R$styleable.SubsamplingScaleImageView_panEnabled) ? 1 : 0)) != 0) {
                n10 = (int)(attributeSet.getBoolean(n10, bl2) ? 1 : 0);
                this.setPanEnabled(n10 != 0);
            }
            if ((n12 = (int)(attributeSet.hasValue(n10 = R$styleable.SubsamplingScaleImageView_zoomEnabled) ? 1 : 0)) != 0) {
                n10 = (int)(attributeSet.getBoolean(n10, bl2) ? 1 : 0);
                this.setZoomEnabled(n10 != 0);
            }
            if ((n12 = (int)(attributeSet.hasValue(n10 = R$styleable.SubsamplingScaleImageView_quickScaleEnabled) ? 1 : 0)) != 0) {
                n10 = (int)(attributeSet.getBoolean(n10, bl2) ? 1 : 0);
                this.setQuickScaleEnabled(n10 != 0);
            }
            if ((n12 = (int)(attributeSet.hasValue(n10 = R$styleable.SubsamplingScaleImageView_tileBackgroundColor) ? 1 : 0)) != 0) {
                n11 = Color.argb((int)0, (int)0, (int)0, (int)0);
                n11 = attributeSet.getColor(n10, n11);
                this.setTileBackgroundColor(n11);
            }
            attributeSet.recycle();
        }
        context = context.getResources().getDisplayMetrics();
        this.quickScaleThreshold = f10 = TypedValue.applyDimension((int)(bl2 ? 1 : 0), (float)20.0f, (DisplayMetrics)context);
    }

    public static /* synthetic */ View.OnLongClickListener access$000(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.onLongClickListener;
    }

    public static /* synthetic */ float access$1000(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.scale;
    }

    public static /* synthetic */ int access$102(SubsamplingScaleImageView subsamplingScaleImageView, int n10) {
        subsamplingScaleImageView.maxTouchCount = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$1400(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.zoomEnabled;
    }

    public static /* synthetic */ void access$1500(SubsamplingScaleImageView subsamplingScaleImageView, Context context) {
        subsamplingScaleImageView.setGestureDetector(context);
    }

    public static /* synthetic */ boolean access$1600(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.quickScaleEnabled;
    }

    public static /* synthetic */ PointF access$1700(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.vCenterStart;
    }

    public static /* synthetic */ PointF access$1702(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.vCenterStart = pointF;
        return pointF;
    }

    public static /* synthetic */ PointF access$1802(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.vTranslateStart = pointF;
        return pointF;
    }

    public static /* synthetic */ float access$1902(SubsamplingScaleImageView subsamplingScaleImageView, float f10) {
        subsamplingScaleImageView.scaleStart = f10;
        return f10;
    }

    public static /* synthetic */ boolean access$2002(SubsamplingScaleImageView subsamplingScaleImageView, boolean bl2) {
        subsamplingScaleImageView.isQuickScaling = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$201(SubsamplingScaleImageView subsamplingScaleImageView, View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
    }

    public static /* synthetic */ float access$2102(SubsamplingScaleImageView subsamplingScaleImageView, float f10) {
        subsamplingScaleImageView.quickScaleLastDistance = f10;
        return f10;
    }

    public static /* synthetic */ PointF access$2200(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.quickScaleSCenter;
    }

    public static /* synthetic */ PointF access$2202(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.quickScaleSCenter = pointF;
        return pointF;
    }

    public static /* synthetic */ PointF access$2302(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.quickScaleVStart = pointF;
        return pointF;
    }

    public static /* synthetic */ PointF access$2402(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.quickScaleVLastPoint = pointF;
        return pointF;
    }

    public static /* synthetic */ boolean access$2502(SubsamplingScaleImageView subsamplingScaleImageView, boolean bl2) {
        subsamplingScaleImageView.quickScaleMoved = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$2600(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, PointF pointF2) {
        subsamplingScaleImageView.doubleTapZoom(pointF, pointF2);
    }

    public static /* synthetic */ void access$301(SubsamplingScaleImageView subsamplingScaleImageView, View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
    }

    public static /* synthetic */ void access$5100(SubsamplingScaleImageView subsamplingScaleImageView, String string2, Object[] objectArray) {
        subsamplingScaleImageView.debug(string2, objectArray);
    }

    public static /* synthetic */ int access$5200(SubsamplingScaleImageView subsamplingScaleImageView, Context context, String string2) {
        return subsamplingScaleImageView.getExifOrientation(context, string2);
    }

    public static /* synthetic */ Rect access$5300(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.sRegion;
    }

    public static /* synthetic */ String access$5400() {
        return TAG;
    }

    public static /* synthetic */ void access$5500(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, int n10, int n11, int n12) {
        subsamplingScaleImageView.onTilesInited(imageRegionDecoder, n10, n11, n12);
    }

    public static /* synthetic */ SubsamplingScaleImageView$OnImageEventListener access$5600(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.onImageEventListener;
    }

    public static /* synthetic */ Object access$5700(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.decoderLock;
    }

    public static /* synthetic */ void access$5800(SubsamplingScaleImageView subsamplingScaleImageView, Rect rect, Rect rect2) {
        subsamplingScaleImageView.fileSRect(rect, rect2);
    }

    public static /* synthetic */ void access$5900(SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.onTileLoaded();
    }

    public static /* synthetic */ boolean access$600(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.panEnabled;
    }

    public static /* synthetic */ void access$6000(SubsamplingScaleImageView subsamplingScaleImageView, Bitmap bitmap) {
        subsamplingScaleImageView.onPreviewLoaded(bitmap);
    }

    public static /* synthetic */ void access$6100(SubsamplingScaleImageView subsamplingScaleImageView, Bitmap bitmap, int n10, boolean bl2) {
        subsamplingScaleImageView.onImageLoaded(bitmap, n10, bl2);
    }

    public static /* synthetic */ List access$6300() {
        return VALID_EASING_STYLES;
    }

    public static /* synthetic */ SubsamplingScaleImageView$Anim access$6400(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.anim;
    }

    public static /* synthetic */ SubsamplingScaleImageView$Anim access$6402(SubsamplingScaleImageView subsamplingScaleImageView, SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        subsamplingScaleImageView.anim = subsamplingScaleImageView$Anim;
        return subsamplingScaleImageView$Anim;
    }

    public static /* synthetic */ float access$6500(SubsamplingScaleImageView subsamplingScaleImageView, float f10) {
        return subsamplingScaleImageView.limitedScale(f10);
    }

    public static /* synthetic */ PointF access$6600(SubsamplingScaleImageView subsamplingScaleImageView, float f10, float f11, float f12, PointF pointF) {
        return subsamplingScaleImageView.limitedSCenter(f10, f11, f12, pointF);
    }

    public static /* synthetic */ void access$6800(SubsamplingScaleImageView subsamplingScaleImageView, boolean bl2, SubsamplingScaleImageView$ScaleAndTranslate subsamplingScaleImageView$ScaleAndTranslate) {
        subsamplingScaleImageView.fitToBounds(bl2, subsamplingScaleImageView$ScaleAndTranslate);
    }

    public static /* synthetic */ boolean access$700(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.readySent;
    }

    public static /* synthetic */ PointF access$800(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.vTranslate;
    }

    public static /* synthetic */ boolean access$900(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.isZooming;
    }

    public static /* synthetic */ boolean access$902(SubsamplingScaleImageView subsamplingScaleImageView, boolean bl2) {
        subsamplingScaleImageView.isZooming = bl2;
        return bl2;
    }

    private int calculateInSampleSize(float f10) {
        float f11;
        float f12;
        int n10 = this.minimumTileDpi;
        if (n10 > 0) {
            DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
            f12 = displayMetrics.xdpi;
            f11 = displayMetrics.ydpi;
            f12 = (f12 + f11) / 2.0f;
            n10 = this.minimumTileDpi;
            f11 = (float)n10 / f12;
            f10 *= f11;
        }
        f11 = (float)this.sWidth() * f10;
        n10 = (int)f11;
        int n11 = this.sHeight();
        f12 = (float)n11 * f10;
        int n12 = (int)f12;
        if (n10 != 0 && n12 != 0) {
            n11 = this.sHeight();
            int n13 = 1;
            float f13 = Float.MIN_VALUE;
            if (n11 <= n12 && (n11 = this.sWidth()) <= n10) {
                n12 = n13;
                f10 = f13;
            } else {
                f12 = this.sHeight();
                f10 = n12;
                n12 = Math.round(f12 / f10);
                n11 = this.sWidth();
                f12 = n11;
                f11 = n10;
                if (n12 >= (n10 = Math.round(f12 /= f11))) {
                    n12 = n10;
                }
            }
            while ((n10 = n13 * 2) < n12) {
                n13 = n10;
            }
            return n13;
        }
        return 32;
    }

    private boolean checkImageLoaded() {
        boolean bl2 = this.isBaseLayerReady();
        boolean bl3 = this.imageLoadedSent;
        if (!bl3 && bl2) {
            this.preDraw();
            this.imageLoadedSent = bl3 = true;
            this.onImageLoaded();
            SubsamplingScaleImageView$OnImageEventListener subsamplingScaleImageView$OnImageEventListener = this.onImageEventListener;
            if (subsamplingScaleImageView$OnImageEventListener != null) {
                subsamplingScaleImageView$OnImageEventListener.onImageLoaded();
            }
        }
        return bl2;
    }

    private boolean checkReady() {
        Bitmap bitmap;
        int n10 = this.getWidth();
        boolean bl2 = true;
        if (n10 > 0 && (n10 = this.getHeight()) > 0 && (n10 = this.sWidth) > 0 && (n10 = this.sHeight) > 0 && ((bitmap = this.bitmap) != null || (n10 = (int)(this.isBaseLayerReady() ? 1 : 0)) != 0)) {
            n10 = (int)(bl2 ? 1 : 0);
        } else {
            n10 = 0;
            bitmap = null;
        }
        boolean bl3 = this.readySent;
        if (!bl3 && n10 != 0) {
            this.preDraw();
            this.readySent = bl2;
            this.onReady();
            SubsamplingScaleImageView$OnImageEventListener subsamplingScaleImageView$OnImageEventListener = this.onImageEventListener;
            if (subsamplingScaleImageView$OnImageEventListener != null) {
                subsamplingScaleImageView$OnImageEventListener.onReady();
            }
        }
        return n10 != 0;
    }

    private void createPaints() {
        boolean bl2;
        int n10;
        Paint paint = this.bitmapPaint;
        if (paint == null) {
            this.bitmapPaint = paint = new Paint();
            n10 = 1;
            paint.setAntiAlias(n10 != 0);
            this.bitmapPaint.setFilterBitmap(n10 != 0);
            paint = this.bitmapPaint;
            paint.setDither(n10 != 0);
        }
        if ((paint = this.debugPaint) == null && (bl2 = this.debug)) {
            this.debugPaint = paint = new Paint();
            paint.setTextSize(18.0f);
            paint = this.debugPaint;
            n10 = -65281;
            paint.setColor(n10);
            paint = this.debugPaint;
            Paint.Style style2 = Paint.Style.STROKE;
            paint.setStyle(style2);
        }
    }

    private void debug(String string2, Object ... objectArray) {
        boolean bl2 = this.debug;
        if (bl2) {
            String string3 = TAG;
            string2 = String.format(string2, objectArray);
            Log.d((String)string3, (String)string2);
        }
    }

    private float distance(float f10, float f11, float f12, float f13) {
        f10 -= f11;
        f12 -= f13;
        f10 *= f10;
        f12 *= f12;
        return (float)Math.sqrt(f10 + f12);
    }

    private void doubleTapZoom(PointF object, PointF object2) {
        float f10;
        float f11;
        Object object3;
        int n10 = this.panEnabled;
        int n11 = 2;
        if (n10 == 0) {
            object3 = this.sRequestedCenter;
            if (object3 != null) {
                ((PointF)object).x = f11 = ((PointF)object3).x;
                ((PointF)object).y = f10 = ((PointF)object3).y;
            } else {
                ((PointF)object).x = f10 = (float)(this.sWidth() / n11);
                n10 = this.sHeight() / n11;
                ((PointF)object).y = f10 = (float)n10;
            }
        }
        f10 = this.maxScale;
        f11 = this.doubleTapZoomScale;
        f10 = Math.min(f10, f11);
        f11 = this.scale;
        double d10 = f11;
        double d11 = f10;
        double d12 = 0.9;
        double d13 = d10 - (d11 *= d12);
        double d14 = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        int n12 = 1;
        float f12 = Float.MIN_VALUE;
        if (d14 <= 0) {
            d14 = n12;
            f11 = f12;
        } else {
            d14 = 0.0;
            f11 = 0.0f;
        }
        if (d14 == false) {
            f10 = this.minScale();
        }
        float f13 = f10;
        n10 = this.doubleTapZoomStyle;
        int n13 = 3;
        if (n10 == n13) {
            this.setScaleAndCenter(f10, (PointF)object);
        } else {
            int n14 = 4;
            if (n10 != n11 && d14 != false && (n11 = (int)(this.panEnabled ? 1 : 0)) != 0) {
                if (n10 == n12) {
                    object3 = new SubsamplingScaleImageView$AnimationBuilder(this, f10, (PointF)object, (PointF)object2, null);
                    object = ((SubsamplingScaleImageView$AnimationBuilder)object3).withInterruptible(false);
                    int n15 = this.doubleTapZoomDuration;
                    long l10 = n15;
                    object = SubsamplingScaleImageView$AnimationBuilder.access$1300(((SubsamplingScaleImageView$AnimationBuilder)object).withDuration(l10), n14);
                    ((SubsamplingScaleImageView$AnimationBuilder)object).start();
                }
            } else {
                n10 = 0;
                f10 = 0.0f;
                object3 = null;
                object2 = new SubsamplingScaleImageView$AnimationBuilder(this, f13, (PointF)object, null);
                object = ((SubsamplingScaleImageView$AnimationBuilder)object2).withInterruptible(false);
                int n16 = this.doubleTapZoomDuration;
                long l11 = n16;
                object = SubsamplingScaleImageView$AnimationBuilder.access$1300(((SubsamplingScaleImageView$AnimationBuilder)object).withDuration(l11), n14);
                ((SubsamplingScaleImageView$AnimationBuilder)object).start();
            }
        }
        this.invalidate();
    }

    private float ease(int n10, long l10, float f10, float f11, long l11) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 == n11) {
                return this.easeInOutQuad(l10, f10, f11, l11);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected easing type: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        return this.easeOutQuad(l10, f10, f11, l11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private float easeInOutQuad(long l10, float f10, float f11, long l11) {
        float f12 = l10;
        float f13 = l11;
        float f14 = 2.0f;
        f13 /= f14;
        float f15 = (f12 /= f13) - (f13 = 1.0f);
        Object object = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
        if (object < 0) {
            f11 = f11 / f14 * f12;
            return f11 * f12 + f10;
        }
        f11 = -f11 / f14;
        f14 = (f12 -= f13) - f14;
        f12 = f12 * f14 - f13;
        return f11 * f12 + f10;
    }

    private float easeOutQuad(long l10, float f10, float f11, long l11) {
        float f12 = l10;
        float f13 = l11;
        f12 /= f13;
        f13 = -f11 * f12;
        return f13 * (f12 -= 2.0f) + f10;
    }

    private void execute(AsyncTask asyncTask) {
        int n10;
        int n11 = this.parallelLoadingEnabled;
        if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 11)) {
            Object object = AsyncTask.class;
            String string2 = "THREAD_POOL_EXECUTOR";
            object = ((Class)object).getField(string2);
            n10 = 0;
            string2 = null;
            object = ((Field)object).get(null);
            object = (Executor)object;
            Object object2 = AsyncTask.class;
            Object[] objectArray = "executeOnExecutor";
            int n12 = 2;
            Class[] classArray = new Class[n12];
            Class<Executor> clazz = Executor.class;
            classArray[0] = clazz;
            clazz = Object[].class;
            int n13 = 1;
            classArray[n13] = clazz;
            object2 = ((Class)object2).getMethod((String)objectArray, classArray);
            objectArray = new Object[n12];
            objectArray[0] = object;
            objectArray[n13] = null;
            try {
                ((Method)object2).invoke(asyncTask, objectArray);
                return;
            }
            catch (Exception exception) {
                string2 = TAG;
                object2 = "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor";
                Log.i((String)string2, (String)object2, (Throwable)exception);
            }
        }
        Object[] objectArray = new Void[]{};
        asyncTask.execute(objectArray);
    }

    private void fileSRect(Rect rect, Rect rect2) {
        int n10 = this.getRequiredRotation();
        if (n10 == 0) {
            rect2.set(rect);
        } else {
            int n11;
            n10 = this.getRequiredRotation();
            if (n10 == (n11 = 90)) {
                n10 = rect.top;
                n11 = this.sHeight;
                int n12 = rect.right;
                n12 = n11 - n12;
                int n13 = rect.bottom;
                int n14 = rect.left;
                rect2.set(n10, n12, n13, n11 -= n14);
            } else {
                n10 = this.getRequiredRotation();
                if (n10 == (n11 = 180)) {
                    n10 = this.sWidth;
                    n11 = rect.right;
                    n11 = n10 - n11;
                    int n15 = this.sHeight;
                    int n16 = rect.bottom;
                    n16 = n15 - n16;
                    int n17 = rect.left;
                    int n18 = rect.top;
                    rect2.set(n11, n16, n10 -= n17, n15 -= n18);
                } else {
                    n10 = this.sWidth;
                    n11 = rect.bottom;
                    n11 = n10 - n11;
                    int n19 = rect.left;
                    int n20 = rect.top;
                    int n21 = rect.right;
                    rect2.set(n11, n19, n10 -= n20, n21);
                }
            }
        }
    }

    private void fitToBounds(boolean bl2) {
        float f10;
        Object object;
        float f11;
        int n10;
        PointF pointF = this.vTranslate;
        int n11 = 0;
        float f12 = 0.0f;
        SubsamplingScaleImageView$ScaleAndTranslate subsamplingScaleImageView$ScaleAndTranslate = null;
        if (pointF == null) {
            n10 = 1;
            f11 = Float.MIN_VALUE;
            this.vTranslate = object = new PointF(0.0f, 0.0f);
        } else {
            n10 = 0;
            f11 = 0.0f;
            pointF = null;
        }
        object = this.satTemp;
        if (object == null) {
            PointF pointF2 = new PointF(0.0f, 0.0f);
            object = new SubsamplingScaleImageView$ScaleAndTranslate(0.0f, pointF2, null);
            this.satTemp = object;
        }
        subsamplingScaleImageView$ScaleAndTranslate = this.satTemp;
        float f13 = this.scale;
        SubsamplingScaleImageView$ScaleAndTranslate.access$4702(subsamplingScaleImageView$ScaleAndTranslate, f13);
        subsamplingScaleImageView$ScaleAndTranslate = SubsamplingScaleImageView$ScaleAndTranslate.access$4800(this.satTemp);
        object = this.vTranslate;
        subsamplingScaleImageView$ScaleAndTranslate.set((PointF)object);
        subsamplingScaleImageView$ScaleAndTranslate = this.satTemp;
        this.fitToBounds(bl2, subsamplingScaleImageView$ScaleAndTranslate);
        this.scale = f10 = SubsamplingScaleImageView$ScaleAndTranslate.access$4700(this.satTemp);
        PointF pointF3 = this.vTranslate;
        subsamplingScaleImageView$ScaleAndTranslate = SubsamplingScaleImageView$ScaleAndTranslate.access$4800(this.satTemp);
        pointF3.set((PointF)subsamplingScaleImageView$ScaleAndTranslate);
        if (n10 != 0) {
            pointF3 = this.vTranslate;
            n10 = this.sWidth() / 2;
            f11 = n10;
            n11 = this.sHeight() / 2;
            f12 = n11;
            f13 = this.scale;
            pointF = this.vTranslateForSCenter(f11, f12, f13);
            pointF3.set(pointF);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void fitToBounds(boolean var1_1, SubsamplingScaleImageView$ScaleAndTranslate var2_2) {
        block10: {
            var3_3 = this.panLimit;
            var4_4 = 0;
            var5_5 = 0.0f;
            var6_6 = 2;
            var7_7 = 2.8E-45f;
            if (var3_3 == var6_6 && (var3_3 = (int)this.isReady()) != 0) {
                var1_1 = false;
                var8_8 = 0.0f;
            }
            var9_9 = SubsamplingScaleImageView$ScaleAndTranslate.access$4800(var2_2);
            var10_10 = SubsamplingScaleImageView$ScaleAndTranslate.access$4700(var2_2);
            var10_10 = this.limitedScale(var10_10);
            var11_11 = this.sWidth();
            var12_12 = (float)var11_11 * var10_10;
            var13_13 = this.sHeight();
            var14_14 = (float)var13_13 * var10_10;
            var15_15 = this.panLimit;
            var16_16 = 3;
            if (var15_15 == var16_16 && (var15_15 = (int)this.isReady()) != 0) {
                var17_17 = var9_9.x;
                var18_18 = (float)(this.getWidth() / var6_6) - var12_12;
                var9_9.x = var17_17 = Math.max(var17_17, var18_18);
                var17_17 = var9_9.y;
                var19_19 = this.getHeight() / var6_6;
                var18_18 = (float)var19_19 - var14_14;
                var9_9.y = var17_17 = Math.max(var17_17, var18_18);
            } else if (var1_1) {
                var17_17 = var9_9.x;
                var18_18 = (float)this.getWidth() - var12_12;
                var9_9.x = var17_17 = Math.max(var17_17, var18_18);
                var17_17 = var9_9.y;
                var19_19 = this.getHeight();
                var18_18 = (float)var19_19 - var14_14;
                var9_9.y = var17_17 = Math.max(var17_17, var18_18);
            } else {
                var17_17 = var9_9.x;
                var18_18 = -var12_12;
                var9_9.x = var17_17 = Math.max(var17_17, var18_18);
                var17_17 = var9_9.y;
                var18_18 = -var14_14;
                var9_9.y = var17_17 = Math.max(var17_17, var18_18);
            }
            var15_15 = this.getPaddingLeft();
            var19_19 = 0x3F000000;
            var18_18 = 0.5f;
            if (var15_15 <= 0 && (var15_15 = this.getPaddingRight()) <= 0) {
                var15_15 = var19_19;
                var17_17 = var18_18;
            } else {
                var15_15 = this.getPaddingLeft();
                var17_17 = var15_15;
                var20_20 = this.getPaddingLeft();
                var21_21 = this.getPaddingRight();
                var22_22 = var20_20 += var21_21;
                var17_17 /= var22_22;
            }
            var20_20 = this.getPaddingTop();
            if (var20_20 > 0 || (var20_20 = this.getPaddingBottom()) > 0) {
                var19_19 = this.getPaddingTop();
                var18_18 = var19_19;
                var20_20 = this.getPaddingTop();
                var21_21 = this.getPaddingBottom();
                var22_22 = var20_20 += var21_21;
                var18_18 /= var22_22;
            }
            if ((var20_20 = this.panLimit) != var16_16 || (var16_16 = (int)this.isReady()) == 0) break block10;
            var1_1 = this.getWidth() / var6_6;
            var1_1 = Math.max(0, (int)var1_1);
            var8_8 = (float)var1_1;
            var11_11 = this.getHeight() / var6_6;
            var4_4 = Math.max(0, var11_11);
            ** GOTO lbl85
        }
        if (var1_1) {
            var1_1 = this.getWidth();
            var8_8 = ((float)var1_1 - var12_12) * var17_17;
            var4_4 = 0;
            var8_8 = Math.max(0.0f, var8_8);
            var6_6 = this.getHeight();
            var7_7 = ((float)var6_6 - var14_14) * var18_18;
            var5_5 = Math.max(0.0f, var7_7);
        } else {
            var1_1 = this.getWidth();
            var1_1 = Math.max(0, (int)var1_1);
            var8_8 = (float)var1_1;
            var6_6 = this.getHeight();
            var4_4 = Math.max(0, var6_6);
lbl85:
            // 2 sources

            var5_5 = var4_4;
        }
        var9_9.x = var8_8 = Math.min(var9_9.x, var8_8);
        var9_9.y = var8_8 = Math.min(var9_9.y, var5_5);
        SubsamplingScaleImageView$ScaleAndTranslate.access$4702(var2_2, var10_10);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int getExifOrientation(Context object, String object2) {
        CharSequence charSequence = "content";
        int n10 = ((String)object2).startsWith((String)charSequence);
        int n11 = 0;
        if (n10 != 0) {
            Throwable throwable2;
            block13: {
                int n12;
                n10 = 0;
                charSequence = null;
                Object object3 = "orientation";
                String[] stringArray = new String[]{object3};
                Object object4 = object.getContentResolver();
                Uri uri = Uri.parse((String)object2);
                charSequence = object4.query(uri, stringArray, null, null, null);
                if (charSequence != null && (n12 = charSequence.moveToFirst()) != 0) {
                    object2 = VALID_ORIENTATIONS;
                    n12 = charSequence.getInt(0);
                    object3 = n12;
                    int n13 = object2.contains(object3);
                    if (n13 != 0 && n12 != (n13 = -1)) {
                        n11 = n12;
                    } else {
                        object2 = TAG;
                        object3 = new StringBuilder();
                        object4 = "Unsupported orientation: ";
                        ((StringBuilder)object3).append((String)object4);
                        ((StringBuilder)object3).append(n12);
                        object = ((StringBuilder)object3).toString();
                        Log.w((String)object2, (String)object);
                    }
                }
                if (charSequence == null) return n11;
                {
                    catch (Throwable throwable2) {
                        break block13;
                    }
                    catch (Exception exception) {}
                    {
                        object = TAG;
                        object2 = "Could not get orientation of image from media store";
                        Log.w((String)object, (String)object2);
                        if (charSequence == null) return n11;
                    }
                }
                charSequence.close();
                return n11;
            }
            if (charSequence == null) throw throwable2;
            charSequence.close();
            throw throwable2;
        }
        object = "file:///";
        int n14 = ((String)object2).startsWith((String)object);
        if (n14 == 0) return n11;
        object = "file:///android_asset/";
        n14 = ((String)object2).startsWith((String)object);
        if (n14 != 0) return n11;
        try {
            n10 = 7;
            object2 = ((String)object2).substring(n10);
            object = new ExifInterface((String)object2);
            object2 = "Orientation";
            n10 = 1;
            n14 = object.getAttributeInt((String)object2, n10);
            if (n14 == n10) return n11;
            if (n14 == 0) {
                return n11;
            }
            int n15 = 6;
            if (n14 == n15) {
                return 90;
            }
            n15 = 3;
            if (n14 == n15) {
                return 180;
            }
            n15 = 8;
            if (n14 == n15) return 270;
            object2 = TAG;
            charSequence = new StringBuilder();
            String string2 = "Unsupported EXIF orientation: ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n14);
            object = ((StringBuilder)charSequence).toString();
            Log.w((String)object2, (String)object);
            return n11;
        }
        catch (Exception exception) {
            object = TAG;
            object2 = "Could not get EXIF orientation of image";
            Log.w((String)object, (String)object2);
        }
        return n11;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Point getMaxBitmapDimensions(Canvas object) {
        int n10;
        int n11;
        int n12;
        block7: {
            block5: {
                int n13;
                block4: {
                    String string2;
                    Object[] objectArray;
                    Object object2;
                    block6: {
                        n13 = Build.VERSION.SDK_INT;
                        n12 = 2048;
                        n11 = 14;
                        if (n13 < n11) break block5;
                        Object object3 = Canvas.class;
                        object2 = "getMaximumBitmapWidth";
                        objectArray = null;
                        Class[] classArray = new Class[]{};
                        object3 = ((Class)object3).getMethod((String)object2, classArray);
                        object2 = new Object[]{};
                        object3 = ((Method)object3).invoke(object, (Object[])object2);
                        object3 = (Integer)object3;
                        n13 = (Integer)object3;
                        object2 = Canvas.class;
                        string2 = "getMaximumBitmapHeight";
                        try {}
                        catch (Exception exception) {
                            break block4;
                        }
                        break block6;
                        catch (Exception exception) {
                            n13 = n12;
                        }
                        break block4;
                    }
                    Class[] classArray = new Class[]{};
                    object2 = ((Class)object2).getMethod(string2, classArray);
                    objectArray = new Object[]{};
                    object = ((Method)object2).invoke(object, objectArray);
                    object = (Integer)object;
                    n12 = (Integer)object;
                }
                n10 = n12;
                n12 = n13;
                break block7;
            }
            n10 = n12;
        }
        n11 = this.maxTileWidth;
        n12 = Math.min(n12, n11);
        n11 = this.maxTileHeight;
        n10 = Math.min(n10, n11);
        return new Point(n12, n10);
    }

    private int getRequiredRotation() {
        int n10 = this.orientation;
        int n11 = -1;
        if (n10 == n11) {
            n10 = this.sOrientation;
        }
        return n10;
    }

    private void initialiseBaseLayer(Point object) {
        synchronized (this) {
            Object object2 = "initialiseBaseLayer maxTileDimensions=%dx%d";
            int bl2 = 2;
            Object object3 = new Object[bl2];
            int n10 = 0;
            Integer n11 = null;
            int n12 = object.x;
            Integer n13 = n12;
            object3[0] = n13;
            n10 = object.y;
            n11 = n10;
            int n14 = 1;
            object3[n14] = n11;
            this.debug((String)object2, (Object[])object3);
            n10 = 0;
            n11 = null;
            try {
                int n15;
                int n16;
                int n17;
                int n18;
                int n19;
                int n20;
                object3 = new PointF(0.0f, 0.0f);
                this.satTemp = object2 = new SubsamplingScaleImageView$ScaleAndTranslate(0.0f, (PointF)object3, null);
                this.fitToBounds(n14 != 0, (SubsamplingScaleImageView$ScaleAndTranslate)object2);
                object2 = this.satTemp;
                float f10 = SubsamplingScaleImageView$ScaleAndTranslate.access$4700((SubsamplingScaleImageView$ScaleAndTranslate)object2);
                this.fullImageSampleSize = n20 = this.calculateInSampleSize(f10);
                if (n20 > n14) {
                    int n21;
                    this.fullImageSampleSize = n21 = n20 / bl2;
                }
                if ((n19 = this.fullImageSampleSize) == n14 && (object2 = this.sRegion) == null && (n18 = this.sWidth()) < (n17 = object.x) && (n16 = this.sHeight()) < (n15 = object.y)) {
                    object = this.decoder;
                    object.recycle();
                    this.decoder = null;
                    Context context = this.getContext();
                    DecoderFactory decoderFactory = this.bitmapDecoderFactory;
                    Uri uri = this.uri;
                    object = new SubsamplingScaleImageView$BitmapLoadTask(this, context, decoderFactory, uri, false);
                    this.execute((AsyncTask)object);
                } else {
                    boolean bl3;
                    this.initialiseTileMap((Point)object);
                    object = this.tileMap;
                    int n22 = this.fullImageSampleSize;
                    object2 = n22;
                    object = object.get(object2);
                    object = (List)object;
                    object = object.iterator();
                    while (bl3 = object.hasNext()) {
                        object2 = object.next();
                        object2 = (SubsamplingScaleImageView$Tile)object2;
                        object3 = this.decoder;
                        SubsamplingScaleImageView$TileLoadTask subsamplingScaleImageView$TileLoadTask = new SubsamplingScaleImageView$TileLoadTask(this, (ImageRegionDecoder)object3, (SubsamplingScaleImageView$Tile)object2);
                        this.execute(subsamplingScaleImageView$TileLoadTask);
                    }
                    this.refreshRequiredTiles(n14 != 0);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }

    private void initialiseTileMap(Point point) {
        SubsamplingScaleImageView subsamplingScaleImageView = this;
        Point point2 = point;
        Object object = new Object[2];
        Object object2 = point.x;
        int n10 = 0;
        float f10 = 0.0f;
        Map map = null;
        object[0] = object2;
        object2 = point.y;
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        object[n11] = object2;
        object2 = "initialiseTileMap maxTileDimensions=%dx%d";
        this.debug((String)object2, object);
        this.tileMap = object = new LinkedHashMap();
        int n12 = this.fullImageSampleSize;
        int n13 = n11;
        int n14 = n11;
        block0: while (true) {
            int n15 = this.sWidth() / n13;
            int n16 = this.sHeight() / n14;
            int n17 = n15 / n12;
            int n18 = n16 / n12;
            while (true) {
                int n19;
                int n20;
                if ((n20 = n17 + n13 + n11) <= (n19 = point2.x)) {
                    double d10 = n17;
                    double d11 = this.getWidth();
                    double d12 = 1.25;
                    double d13 = d10 - (d11 *= d12);
                    n17 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
                    if (n17 <= 0 || n12 >= (n17 = subsamplingScaleImageView.fullImageSampleSize)) {
                        while (true) {
                            double d14;
                            double d15;
                            if ((n17 = n18 + n14 + n11) <= (n20 = point2.y) && ((n17 = (int)((d15 = (d14 = (double)n18) - (d10 = (double)(n20 = this.getHeight()) * d12)) == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1))) <= 0 || n12 >= (n17 = subsamplingScaleImageView.fullImageSampleSize))) {
                                n18 = n13 * n14;
                                ArrayList<SubsamplingScaleImageView$Tile> arrayList = new ArrayList<SubsamplingScaleImageView$Tile>(n18);
                                for (n18 = 0; n18 < n13; ++n18) {
                                    for (n20 = 0; n20 < n14; ++n20) {
                                        Rect rect = null;
                                        SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile = new SubsamplingScaleImageView$Tile(null);
                                        SubsamplingScaleImageView$Tile.access$4302(subsamplingScaleImageView$Tile, n12);
                                        int n21 = subsamplingScaleImageView.fullImageSampleSize;
                                        if (n12 == n21) {
                                            n21 = n11;
                                        } else {
                                            n21 = 0;
                                            rect = null;
                                        }
                                        SubsamplingScaleImageView$Tile.access$402(subsamplingScaleImageView$Tile, n21 != 0);
                                        int n22 = n18 * n15;
                                        int n23 = n20 * n16;
                                        n11 = n13 + -1;
                                        n11 = n18 == n11 ? this.sWidth() : (n18 + 1) * n15;
                                        n10 = n14 + -1;
                                        n10 = n20 == n10 ? this.sHeight() : (n20 + 1) * n16;
                                        rect = new Rect(n22, n23, n11, n10);
                                        SubsamplingScaleImageView$Tile.access$4102(subsamplingScaleImageView$Tile, rect);
                                        map = new Rect(0, 0, 0, 0);
                                        SubsamplingScaleImageView$Tile.access$4202(subsamplingScaleImageView$Tile, (Rect)map);
                                        rect = SubsamplingScaleImageView$Tile.access$4100(subsamplingScaleImageView$Tile);
                                        map = new Rect(rect);
                                        SubsamplingScaleImageView$Tile.access$5002(subsamplingScaleImageView$Tile, (Rect)map);
                                        arrayList.add(subsamplingScaleImageView$Tile);
                                        n10 = 0;
                                        map = null;
                                        f10 = 0.0f;
                                        n11 = 1;
                                        f11 = Float.MIN_VALUE;
                                    }
                                    n11 = 1;
                                    f11 = Float.MIN_VALUE;
                                }
                                n11 = 0;
                                f11 = 0.0f;
                                map = subsamplingScaleImageView.tileMap;
                                Integer n24 = n12;
                                map.put(n24, arrayList);
                                n10 = 1;
                                f10 = Float.MIN_VALUE;
                                if (n12 == n10) {
                                    return;
                                }
                                n12 /= 2;
                                n11 = n10;
                                f11 = f10;
                                n10 = 0;
                                map = null;
                                f10 = 0.0f;
                                continue block0;
                            }
                            n10 = n11;
                            f10 = f11;
                            n16 = this.sHeight() / ++n14;
                            n18 = n16 / n12;
                            n10 = 0;
                            map = null;
                            f10 = 0.0f;
                        }
                    }
                }
                n10 = n11;
                f10 = f11;
                n15 = this.sWidth() / ++n13;
                n17 = n15 / n12;
                n10 = 0;
                map = null;
                f10 = 0.0f;
            }
            break;
        }
    }

    private boolean isBaseLayerReady() {
        boolean bl2;
        Object object = this.bitmap;
        boolean bl3 = true;
        if (object != null && !(bl2 = this.bitmapIsPreview)) {
            return bl3;
        }
        object = this.tileMap;
        if (object != null) {
            boolean bl4;
            object = object.entrySet().iterator();
            while (bl4 = object.hasNext()) {
                int n10;
                Object object2 = (Map.Entry)object.next();
                Object object3 = (Integer)object2.getKey();
                int n11 = (Integer)object3;
                if (n11 != (n10 = this.fullImageSampleSize)) continue;
                object2 = ((List)object2.getValue()).iterator();
                while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object3 = (SubsamplingScaleImageView$Tile)object2.next();
                    n10 = (int)(SubsamplingScaleImageView$Tile.access$4000((SubsamplingScaleImageView$Tile)object3) ? 1 : 0);
                    if (n10 == 0 && (object3 = SubsamplingScaleImageView$Tile.access$500((SubsamplingScaleImageView$Tile)object3)) != null) continue;
                    bl3 = false;
                }
            }
            return bl3;
        }
        return false;
    }

    private PointF limitedSCenter(float f10, float f11, float f12, PointF pointF) {
        PointF pointF2 = this.vTranslateForSCenter(f10, f11, f12);
        int n10 = this.getPaddingLeft();
        int n11 = this.getWidth();
        int n12 = this.getPaddingRight();
        n11 -= n12;
        n12 = this.getPaddingLeft();
        n11 = (n11 - n12) / 2;
        n10 += n11;
        n11 = this.getPaddingTop();
        n12 = this.getHeight();
        int n13 = this.getPaddingBottom();
        n12 -= n13;
        n13 = this.getPaddingTop();
        n12 = (n12 - n13) / 2;
        f11 = n10;
        float f13 = pointF2.x;
        f11 = (f11 - f13) / f12;
        float f14 = n11 += n12;
        f10 = pointF2.y;
        f14 = (f14 - f10) / f12;
        pointF.set(f11, f14);
        return pointF;
    }

    private float limitedScale(float f10) {
        f10 = Math.max(this.minScale(), f10);
        return Math.min(this.maxScale, f10);
    }

    private float minScale() {
        float f10;
        float f11;
        int n10 = this.getPaddingBottom();
        int n11 = this.getPaddingTop();
        n10 += n11;
        n11 = this.getPaddingLeft();
        int n12 = this.getPaddingRight();
        n11 += n12;
        n12 = this.minimumScaleType;
        int n13 = 2;
        if (n12 == n13) {
            float f12 = this.getWidth() - n11;
            float f13 = this.sWidth();
            f12 /= f13;
            float f14 = this.getHeight() - n10;
            f13 = this.sHeight();
            return Math.max(f12, f14 /= f13);
        }
        n13 = 3;
        if (n12 == n13 && (n13 = (int)((f11 = (f10 = this.minScale) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) > 0) {
            return f10;
        }
        float f15 = this.getWidth() - n11;
        f10 = this.sWidth();
        f15 /= f10;
        float f16 = this.getHeight() - n10;
        f10 = this.sHeight();
        return Math.min(f15, f16 /= f10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onImageLoaded(Bitmap bitmap, int n10, boolean bl2) {
        synchronized (this) {
            boolean bl3;
            int n11;
            void var3_3;
            int n12;
            Object object = "onImageLoaded";
            Object[] objectArray = new Object[]{};
            this.debug((String)object, objectArray);
            int n13 = this.sWidth;
            if (n13 > 0 && (n12 = this.sHeight) > 0 && (n13 != (n12 = bitmap.getWidth()) || (n13 = this.sHeight) != (n12 = bitmap.getHeight()))) {
                this.reset(false);
            }
            if ((object = this.bitmap) != null && (n12 = (int)(this.bitmapIsCached ? 1 : 0)) == 0) {
                object.recycle();
            }
            if ((object = this.bitmap) != null && (n13 = (int)(this.bitmapIsCached ? 1 : 0)) != 0 && (object = this.onImageEventListener) != null) {
                object.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = var3_3;
            this.bitmap = bitmap;
            bl2 = bitmap.getWidth();
            this.sWidth = (int)(bl2 ? 1 : 0);
            this.sHeight = n11 = bitmap.getHeight();
            this.sOrientation = bl3;
            n11 = (int)(this.checkReady() ? 1 : 0);
            bl3 = this.checkImageLoaded();
            if (n11 != 0 || bl3) {
                this.invalidate();
                this.requestLayout();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onPreviewLoaded(Bitmap bitmap) {
        synchronized (this) {
            int n10;
            String string2 = "onPreviewLoaded";
            int n11 = 0;
            Object[] objectArray = null;
            objectArray = new Object[]{};
            this.debug(string2, objectArray);
            string2 = this.bitmap;
            if (string2 == null && (n10 = this.imageLoadedSent) == 0) {
                boolean bl2;
                string2 = this.pRegion;
                if (string2 != null) {
                    n11 = ((Rect)string2).left;
                    int n12 = ((Rect)string2).top;
                    n10 = string2.width();
                    Rect rect = this.pRegion;
                    int n13 = rect.height();
                    this.bitmap = bitmap = Bitmap.createBitmap((Bitmap)bitmap, (int)n11, (int)n12, (int)n10, (int)n13);
                } else {
                    this.bitmap = bitmap;
                }
                this.bitmapIsPreview = bl2 = true;
                bl2 = this.checkReady();
                if (bl2) {
                    this.invalidate();
                    this.requestLayout();
                }
                return;
            }
            bitmap.recycle();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onTileLoaded() {
        synchronized (this) {
            Object object = "onTileLoaded";
            Object[] objectArray = new Object[]{};
            this.debug((String)object, objectArray);
            this.checkReady();
            this.checkImageLoaded();
            boolean bl2 = this.isBaseLayerReady();
            if (bl2 && (object = this.bitmap) != null) {
                boolean bl3 = this.bitmapIsCached;
                if (!bl3) {
                    object.recycle();
                }
                bl2 = false;
                object = null;
                this.bitmap = null;
                object = this.onImageEventListener;
                if (object != null && (bl3 = this.bitmapIsCached)) {
                    object.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
            this.invalidate();
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onTilesInited(ImageRegionDecoder imageRegionDecoder, int n10, int n11, int n12) {
        synchronized (this) {
            void var4_4;
            int n13;
            int n14;
            Object object = "onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d";
            int n15 = 3;
            Object[] objectArray = new Object[n15];
            Integer n16 = n14;
            objectArray[0] = n16;
            int n17 = 1;
            Integer n18 = n13;
            objectArray[n17] = n18;
            n17 = 2;
            int n19 = this.orientation;
            n18 = n19;
            objectArray[n17] = n18;
            this.debug((String)object, objectArray);
            int n20 = this.sWidth;
            if (n20 > 0 && (n15 = this.sHeight) > 0 && (n20 != n14 || n15 != n13)) {
                this.reset(false);
                object = this.bitmap;
                if (object != null) {
                    n15 = (int)(this.bitmapIsCached ? 1 : 0);
                    if (n15 == 0) {
                        object.recycle();
                    }
                    n20 = 0;
                    object = null;
                    this.bitmap = null;
                    object = this.onImageEventListener;
                    if (object != null && (n15 = (int)(this.bitmapIsCached ? 1 : 0)) != 0) {
                        object.onPreviewReleased();
                    }
                    this.bitmapIsPreview = false;
                    this.bitmapIsCached = false;
                }
            }
            this.decoder = imageRegionDecoder;
            this.sWidth = n14;
            this.sHeight = n13;
            this.sOrientation = var4_4;
            this.checkReady();
            int n21 = this.checkImageLoaded();
            if (n21 == 0 && (n21 = this.maxTileWidth) > 0 && n21 != (n14 = TILE_SIZE_AUTO) && (n21 = this.maxTileHeight) > 0 && n21 != n14 && (n21 = this.getWidth()) > 0 && (n21 = this.getHeight()) > 0) {
                n14 = this.maxTileWidth;
                n13 = this.maxTileHeight;
                imageRegionDecoder = new Point(n14, n13);
                this.initialiseBaseLayer((Point)imageRegionDecoder);
            }
            this.invalidate();
            this.requestLayout();
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean onTouchEventInternal(MotionEvent var1_1) {
        block47: {
            block48: {
                block50: {
                    block46: {
                        block51: {
                            block60: {
                                block59: {
                                    block61: {
                                        block62: {
                                            block64: {
                                                block63: {
                                                    block52: {
                                                        block55: {
                                                            block56: {
                                                                block58: {
                                                                    block57: {
                                                                        block54: {
                                                                            block53: {
                                                                                block49: {
                                                                                    var2_2 = var1_1.getPointerCount();
                                                                                    var3_3 = var1_1.getAction();
                                                                                    var4_4 = 0x40000000;
                                                                                    var5_5 = 2.0f;
                                                                                    var6_6 = 2;
                                                                                    var7_7 = 2.8E-45f;
                                                                                    var8_8 = 1;
                                                                                    var9_9 = 1.4E-45f;
                                                                                    if (var3_3 == 0) break block47;
                                                                                    if (var3_3 == var8_8) break block48;
                                                                                    if (var3_3 == var6_6) break block49;
                                                                                    var10_10 = 5;
                                                                                    var11_13 = 7.0E-45f;
                                                                                    if (var3_3 == var10_10) break block47;
                                                                                    var10_10 = 6;
                                                                                    var11_13 = 8.4E-45f;
                                                                                    if (var3_3 == var10_10) break block48;
                                                                                    var10_10 = 261;
                                                                                    var11_13 = 3.66E-43f;
                                                                                    if (var3_3 == var10_10) break block47;
                                                                                    var4_4 = 262;
                                                                                    var5_5 = 3.67E-43f;
                                                                                    if (var3_3 == var4_4) break block48;
                                                                                    break block50;
                                                                                }
                                                                                var3_3 = this.maxTouchCount;
                                                                                if (var3_3 <= 0) break block51;
                                                                                var3_3 = 0x40A00000;
                                                                                var12_17 = 5.0f;
                                                                                if (var2_2 < var6_6) break block52;
                                                                                var13_19 = var1_1.getX(0);
                                                                                var11_14 = var1_1.getX(var8_8);
                                                                                var14_23 = var1_1.getY(0);
                                                                                var15_26 = var1_1.getY(var8_8);
                                                                                var13_19 = this.distance(var13_19, var11_14, var14_23, var15_26);
                                                                                var11_14 = var1_1.getX(0);
                                                                                var14_23 = var1_1.getX(var8_8);
                                                                                var11_14 = (var11_14 + var14_23) / var5_5;
                                                                                var14_23 = var1_1.getY(0);
                                                                                var16_28 = var1_1.getY(var8_8);
                                                                                var14_23 = (var14_23 + var16_28) / var5_5;
                                                                                var17_32 /* !! */  = this.zoomEnabled;
                                                                                if (var17_32 /* !! */  == 0) break block51;
                                                                                var1_1 = this.vCenterStart;
                                                                                var5_5 = var1_1.x;
                                                                                var16_28 = var1_1.y;
                                                                                cfr_temp_0 = (var16_28 = this.distance(var5_5, var11_14, var16_28, var14_23)) - var12_17;
                                                                                var17_32 /* !! */  = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                                                                if (var17_32 /* !! */  > 0) break block53;
                                                                                var16_28 = this.vDistStart;
                                                                                cfr_temp_1 = (var16_28 = Math.abs(var13_19 - var16_28)) - var12_17;
                                                                                var17_32 /* !! */  = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                                                                                if (var17_32 /* !! */  <= 0 && (var17_32 /* !! */  = (int)this.isPanning) == 0) break block51;
                                                                            }
                                                                            this.isZooming = var8_8;
                                                                            this.isPanning = var8_8;
                                                                            var18_34 = this.scale;
                                                                            var16_28 = this.maxScale;
                                                                            var15_26 = this.vDistStart;
                                                                            var15_26 = var13_19 / var15_26;
                                                                            var20_36 = this.scaleStart;
                                                                            this.scale = var16_28 = Math.min(var16_28, var15_26 *= var20_36);
                                                                            var15_26 = this.minScale();
                                                                            cfr_temp_2 = var16_28 - var15_26;
                                                                            var17_32 /* !! */  = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1));
                                                                            if (var17_32 /* !! */  > 0) break block54;
                                                                            this.vDistStart = var13_19;
                                                                            this.scaleStart = var16_28 = this.minScale();
                                                                            this.vCenterStart.set(var11_14, var14_23);
                                                                            var1_1 = this.vTranslateStart;
                                                                            var21_39 = this.vTranslate;
                                                                            var1_1.set(var21_39);
                                                                            break block55;
                                                                        }
                                                                        var17_32 /* !! */  = (int)this.panEnabled;
                                                                        if (var17_32 /* !! */  == 0) break block56;
                                                                        var1_1 = this.vCenterStart;
                                                                        var7_7 = var1_1.x;
                                                                        var22_44 = this.vTranslateStart;
                                                                        var20_36 = var22_44.x;
                                                                        var7_7 -= var20_36;
                                                                        var16_28 = var1_1.y;
                                                                        var15_26 = var22_44.y;
                                                                        var16_28 -= var15_26;
                                                                        var15_26 = this.scale;
                                                                        var20_36 = this.scaleStart;
                                                                        var23_46 = var15_26 / var20_36;
                                                                        var7_7 *= var23_46;
                                                                        var16_28 *= (var15_26 /= var20_36);
                                                                        var22_44 = this.vTranslate;
                                                                        var22_44.x = var7_7 = var11_14 - var7_7;
                                                                        var22_44.y = var16_28 = var14_23 - var16_28;
                                                                        var24_48 = (double)this.sHeight() * var18_34;
                                                                        cfr_temp_3 = var24_48 - (var26_49 = (double)this.getHeight());
                                                                        var17_32 /* !! */  = (int)(cfr_temp_3 == 0.0 ? 0 : (cfr_temp_3 < 0.0 ? -1 : 1));
                                                                        if (var17_32 /* !! */  >= 0) break block57;
                                                                        var16_28 = this.scale;
                                                                        var7_7 = this.sHeight();
                                                                        var6_6 = this.getHeight();
                                                                        cfr_temp_4 = (var16_28 *= var7_7) - (var7_7 = (float)var6_6);
                                                                        var17_32 /* !! */  = (int)(cfr_temp_4 == 0.0f ? 0 : (cfr_temp_4 > 0.0f ? 1 : -1));
                                                                        if (var17_32 /* !! */  >= 0) break block58;
                                                                    }
                                                                    var24_48 = this.sWidth();
                                                                    cfr_temp_5 = (var18_34 *= var24_48) - (var24_48 = (double)this.getWidth());
                                                                    var17_32 /* !! */  = (int)(cfr_temp_5 == 0.0 ? 0 : (cfr_temp_5 < 0.0 ? -1 : 1));
                                                                    if (var17_32 /* !! */  >= 0) break block55;
                                                                    var16_28 = this.scale;
                                                                    var12_17 = this.sWidth();
                                                                    var3_3 = this.getWidth();
                                                                    cfr_temp_6 = (var16_28 *= var12_17) - (var12_17 = (float)var3_3);
                                                                    var17_32 /* !! */  = (int)(cfr_temp_6 == 0.0f ? 0 : (cfr_temp_6 > 0.0f ? 1 : -1));
                                                                    if (var17_32 /* !! */  < 0) break block55;
                                                                }
                                                                this.fitToBounds((boolean)var8_8);
                                                                this.vCenterStart.set(var11_14, var14_23);
                                                                var1_1 = this.vTranslateStart;
                                                                var28_50 = this.vTranslate;
                                                                var1_1.set(var28_50);
                                                                this.scaleStart = var16_28 = this.scale;
                                                                this.vDistStart = var13_19;
                                                                break block55;
                                                            }
                                                            var1_1 = this.sRequestedCenter;
                                                            if (var1_1 != null) {
                                                                var1_1 = this.vTranslate;
                                                                var13_19 = this.getWidth() / var6_6;
                                                                var12_17 = this.scale;
                                                                var5_5 = this.sRequestedCenter.x;
                                                                var1_1.x = var13_19 -= (var12_17 *= var5_5);
                                                                var1_1 = this.vTranslate;
                                                                var2_2 = this.getHeight() / var6_6;
                                                                var13_19 = var2_2;
                                                                var12_17 = this.scale;
                                                                var29_54 = this.sRequestedCenter;
                                                                var5_5 = var29_54.y;
                                                                var1_1.y = var13_19 -= (var12_17 *= var5_5);
                                                            } else {
                                                                var1_1 = this.vTranslate;
                                                                var13_19 = this.getWidth() / var6_6;
                                                                var12_17 = this.scale;
                                                                var5_5 = this.sWidth() / var6_6;
                                                                var1_1.x = var13_19 -= (var12_17 *= var5_5);
                                                                var1_1 = this.vTranslate;
                                                                var2_2 = this.getHeight() / var6_6;
                                                                var13_19 = var2_2;
                                                                var12_17 = this.scale;
                                                                var4_4 = this.sHeight() / var6_6;
                                                                var5_5 = var4_4;
                                                                var1_1.y = var13_19 -= (var12_17 *= var5_5);
                                                            }
                                                        }
                                                        this.fitToBounds((boolean)var8_8);
                                                        this.refreshRequiredTiles(false);
                                                        break block59;
                                                    }
                                                    var2_2 = (int)this.isQuickScaling;
                                                    if (var2_2 == 0) break block60;
                                                    var21_40 = this.quickScaleVStart;
                                                    var13_20 = var21_40.y;
                                                    var12_17 = var1_1.getY();
                                                    var13_20 = Math.abs(var13_20 - var12_17) * var5_5;
                                                    var12_17 = this.quickScaleThreshold;
                                                    var13_20 += var12_17;
                                                    var12_17 = this.quickScaleLastDistance;
                                                    var4_4 = -1082130432;
                                                    var5_5 = -1.0f;
                                                    cfr_temp_7 = var12_17 - var5_5;
                                                    var3_3 = (int)(cfr_temp_7 == 0.0f ? 0 : (cfr_temp_7 > 0.0f ? 1 : -1));
                                                    if (var3_3 == 0) {
                                                        this.quickScaleLastDistance = var13_20;
                                                    }
                                                    var12_17 = var1_1.getY();
                                                    var29_55 = this.quickScaleVLastPoint;
                                                    var11_15 = var29_55.y;
                                                    cfr_temp_8 = var12_17 - var11_15;
                                                    var3_3 = (int)(cfr_temp_8 == 0.0f ? 0 : (cfr_temp_8 > 0.0f ? 1 : -1));
                                                    if (var3_3 > 0) {
                                                        var3_3 = var8_8;
                                                        var12_17 = var9_9;
                                                    } else {
                                                        var3_3 = 0;
                                                        var28_51 = null;
                                                        var12_17 = 0.0f;
                                                    }
                                                    var16_28 = var1_1.getY();
                                                    var10_11 = 0;
                                                    var11_15 = 0.0f;
                                                    var30_58 = null;
                                                    var29_55.set(0.0f, var16_28);
                                                    var16_28 = this.quickScaleLastDistance;
                                                    var16_28 = var13_20 / var16_28;
                                                    var4_4 = 1065353216;
                                                    var5_5 = 1.0f;
                                                    var16_28 = Math.abs(var5_5 - var16_28) * 0.5f;
                                                    var14_24 = 0.03f;
                                                    var31_60 /* !! */  = var16_28 == var14_24 ? 0 : (var16_28 > var14_24 ? 1 : -1);
                                                    if (var31_60 /* !! */  <= 0 && (var31_60 /* !! */  = (float)this.quickScaleMoved) == false) break block61;
                                                    this.quickScaleMoved = var8_8;
                                                    var14_24 = this.quickScaleLastDistance;
                                                    cfr_temp_9 = var14_24 - 0.0f;
                                                    var31_60 /* !! */  = (float)(cfr_temp_9 == 0.0f ? 0 : (cfr_temp_9 > 0.0f ? 1 : -1));
                                                    if (var31_60 /* !! */  > 0) {
                                                        if (var3_3 != 0) {
                                                            var16_28 += var5_5;
                                                            var5_5 = var16_28;
                                                        } else {
                                                            var5_5 -= var16_28;
                                                        }
                                                    }
                                                    var32_61 = this.scale;
                                                    var16_28 = this.minScale();
                                                    var12_17 = this.maxScale;
                                                    var20_37 = this.scale * var5_5;
                                                    var12_17 = Math.min(var12_17, var20_37);
                                                    this.scale = var16_28 = Math.max(var16_28, var12_17);
                                                    var3_3 = (int)this.panEnabled;
                                                    if (var3_3 == 0) break block62;
                                                    var28_51 = this.vCenterStart;
                                                    var5_5 = var28_51.x;
                                                    var34_62 = this.vTranslateStart;
                                                    var20_37 = var34_62.x;
                                                    var20_37 = var5_5 - var20_37;
                                                    var12_17 = var28_51.y;
                                                    var7_7 = var34_62.y;
                                                    var7_7 = var12_17 - var7_7;
                                                    var23_47 = this.scaleStart;
                                                    var35_65 = var16_28 / var23_47;
                                                    var1_1 = this.vTranslate;
                                                    var1_1.x = var5_5 -= (var20_37 *= var35_65);
                                                    var1_1.y = var12_17 -= (var7_7 *= (var16_28 /= var23_47));
                                                    var18_35 = (double)this.sHeight() * var32_61;
                                                    cfr_temp_10 = var18_35 - (var36_66 = (double)this.getHeight());
                                                    var17_32 /* !! */  = (int)(cfr_temp_10 == 0.0 ? 0 : (cfr_temp_10 < 0.0 ? -1 : 1));
                                                    if (var17_32 /* !! */  >= 0) break block63;
                                                    var16_28 = this.scale;
                                                    var12_17 = this.sHeight();
                                                    var3_3 = this.getHeight();
                                                    cfr_temp_11 = (var16_28 *= var12_17) - (var12_17 = (float)var3_3);
                                                    var17_32 /* !! */  = (int)(cfr_temp_11 == 0.0f ? 0 : (cfr_temp_11 > 0.0f ? 1 : -1));
                                                    if (var17_32 /* !! */  >= 0) break block64;
                                                }
                                                var18_35 = this.sWidth();
                                                cfr_temp_12 = (var32_61 *= var18_35) - (var18_35 = (double)this.getWidth());
                                                var17_32 /* !! */  = (int)(cfr_temp_12 == 0.0 ? 0 : (cfr_temp_12 < 0.0 ? -1 : 1));
                                                if (var17_32 /* !! */  >= 0) break block61;
                                                var16_28 = this.scale;
                                                var12_17 = this.sWidth();
                                                var3_3 = this.getWidth();
                                                cfr_temp_13 = (var16_28 *= var12_17) - (var12_17 = (float)var3_3);
                                                var17_32 /* !! */  = (int)(cfr_temp_13 == 0.0f ? 0 : (cfr_temp_13 > 0.0f ? 1 : -1));
                                                if (var17_32 /* !! */  < 0) break block61;
                                            }
                                            this.fitToBounds((boolean)var8_8);
                                            var1_1 = this.vCenterStart;
                                            var21_40 = this.quickScaleSCenter;
                                            var21_40 = this.sourceToViewCoord(var21_40);
                                            var1_1.set(var21_40);
                                            var1_1 = this.vTranslateStart;
                                            var21_40 = this.vTranslate;
                                            var1_1.set(var21_40);
                                            this.scaleStart = var16_28 = this.scale;
                                            var2_2 = 0;
                                            var21_40 = null;
                                            var13_20 = 0.0f;
                                            break block61;
                                        }
                                        var1_1 = this.sRequestedCenter;
                                        if (var1_1 != null) {
                                            var1_1 = this.vTranslate;
                                            var12_17 = this.getWidth() / var6_6;
                                            var5_5 = this.scale;
                                            var30_58 = this.sRequestedCenter;
                                            var11_15 = var30_58.x;
                                            var1_1.x = var12_17 -= (var5_5 *= var11_15);
                                            var1_1 = this.vTranslate;
                                            var3_3 = this.getHeight() / var6_6;
                                            var12_17 = var3_3;
                                            var5_5 = this.scale;
                                            var34_63 = this.sRequestedCenter;
                                            var7_7 = var34_63.y;
                                            var1_1.y = var12_17 -= (var5_5 *= var7_7);
                                        } else {
                                            var1_1 = this.vTranslate;
                                            var12_17 = this.getWidth() / var6_6;
                                            var5_5 = this.scale;
                                            var11_15 = this.sWidth() / var6_6;
                                            var1_1.x = var12_17 -= (var5_5 *= var11_15);
                                            var1_1 = this.vTranslate;
                                            var3_3 = this.getHeight() / var6_6;
                                            var12_17 = var3_3;
                                            var5_5 = this.scale;
                                            var10_11 = this.sHeight() / var6_6;
                                            var7_7 = var10_11;
                                            var1_1.y = var12_17 -= (var5_5 *= var7_7);
                                        }
                                    }
                                    this.quickScaleLastDistance = var13_20;
                                    this.fitToBounds((boolean)var8_8);
                                    this.refreshRequiredTiles(false);
                                }
lbl298:
                                // 2 sources

                                while (true) {
                                    var17_32 /* !! */  = var8_8;
                                    var16_28 = var9_9;
                                    break block46;
                                    break;
                                }
                            }
                            var2_2 = (int)this.isZooming;
                            if (var2_2 == 0) {
                                var13_21 = var1_1.getX();
                                var29_56 = this.vCenterStart;
                                var5_5 = var29_56.x;
                                var13_21 = Math.abs(var13_21 - var5_5);
                                var5_5 = var1_1.getY();
                                var34_64 = this.vCenterStart;
                                var7_7 = var34_64.y;
                                var5_5 = Math.abs(var5_5 - var7_7);
                                var7_7 = this.density * var12_17;
                                cfr_temp_14 = var13_21 - var7_7;
                                var3_3 = (int)(cfr_temp_14 == 0.0f ? 0 : (cfr_temp_14 > 0.0f ? 1 : -1));
                                if (var3_3 > 0 || (var10_12 = var5_5 == var7_7 ? 0 : (var5_5 > var7_7 ? 1 : -1)) > 0 || (var10_12 = (float)this.isPanning) != false) {
                                    var30_59 = this.vTranslate;
                                    var14_25 = this.vTranslateStart.x;
                                    var15_27 = var1_1.getX();
                                    var38_67 = this.vCenterStart;
                                    var20_38 = var38_67.x;
                                    var30_59.x = var14_25 += (var15_27 -= var20_38);
                                    var30_59 = this.vTranslate;
                                    var14_25 = this.vTranslateStart.y;
                                    var16_28 = var1_1.getY();
                                    var22_45 = this.vCenterStart;
                                    var15_27 = var22_45.y;
                                    var30_59.y = var14_25 += (var16_28 -= var15_27);
                                    var1_1 = this.vTranslate;
                                    var11_16 = var1_1.x;
                                    var16_28 = var1_1.y;
                                    this.fitToBounds((boolean)var8_8);
                                    var39_68 = this.vTranslate;
                                    var15_27 = var39_68.x;
                                    var10_12 = var11_16 == var15_27 ? 0 : (var11_16 > var15_27 ? 1 : -1);
                                    if (var10_12 != false) {
                                        var10_12 = var8_8;
                                        var11_16 = var9_9;
                                    } else {
                                        var10_12 = (float)false;
                                        var30_59 = null;
                                        var11_16 = 0.0f;
                                    }
                                    var14_25 = var39_68.y;
                                    var40_69 = var16_28 == var14_25 ? 0 : (var16_28 > var14_25 ? 1 : -1);
                                    if (var40_69 != false) {
                                        var40_69 = var8_8;
                                        var15_27 = var9_9;
                                    } else {
                                        var40_69 = (float)false;
                                        var22_45 = null;
                                        var15_27 = 0.0f;
                                    }
                                    if (var10_12 != false && (var41_70 = var13_21 == var5_5 ? 0 : (var13_21 > var5_5 ? 1 : -1)) > 0 && (var41_70 = (int)this.isPanning) == 0) {
                                        var41_70 = var8_8;
                                        var20_38 = var9_9;
                                    } else {
                                        var41_70 = 0;
                                        var38_67 = null;
                                        var20_38 = 0.0f;
                                    }
                                    if (var40_69 != false && (var2_2 = (int)(var5_5 == var13_21 ? 0 : (var5_5 > var13_21 ? 1 : -1))) > 0 && (var2_2 = (int)this.isPanning) == 0) {
                                        var2_2 = var8_8;
                                        var13_21 = var9_9;
                                    } else {
                                        var2_2 = 0;
                                        var21_41 = null;
                                        var13_21 = 0.0f;
                                    }
                                    var17_32 /* !! */  = (int)(var16_28 == var14_25 ? 0 : (var16_28 > var14_25 ? 1 : -1));
                                    if (var17_32 /* !! */  == 0 && (var17_32 /* !! */  = (int)((cfr_temp_15 = var5_5 - (var16_28 = 3.0f * var7_7)) == 0.0f ? 0 : (cfr_temp_15 > 0.0f ? 1 : -1))) > 0) {
                                        var17_32 /* !! */  = var8_8;
                                        var16_28 = var9_9;
                                    } else {
                                        var17_32 /* !! */  = 0;
                                        var1_1 = null;
                                        var16_28 = 0.0f;
                                    }
                                    if (var41_70 == 0 && var2_2 == 0 && (var10_12 == false || var40_69 == false || var17_32 /* !! */  != 0 || (var17_32 /* !! */  = (int)this.isPanning) != 0)) {
                                        this.isPanning = var8_8;
                                    } else if (var3_3 > 0 || (var17_32 /* !! */  = (int)(var5_5 == var7_7 ? 0 : (var5_5 > var7_7 ? 1 : -1))) > 0) {
                                        this.maxTouchCount = 0;
                                        var1_1 = this.handler;
                                        var1_1.removeMessages(var8_8);
                                        this.requestDisallowInterceptTouchEvent(false);
                                    }
                                    var17_32 /* !! */  = (int)this.panEnabled;
                                    if (var17_32 /* !! */  == 0) {
                                        var1_1 = this.vTranslate;
                                        var21_41 = this.vTranslateStart;
                                        var1_1.x = var12_17 = var21_41.x;
                                        var1_1.y = var13_21 = var21_41.y;
                                        this.requestDisallowInterceptTouchEvent(false);
                                    }
                                    this.refreshRequiredTiles(false);
                                    ** continue;
                                }
                            }
                        }
                        var17_32 /* !! */  = 0;
                        var1_1 = null;
                        var16_28 = 0.0f;
                    }
                    if (var17_32 /* !! */  != 0) {
                        this.handler.removeMessages(var8_8);
                        this.invalidate();
                        return (boolean)var8_8;
                    }
                }
                return false;
            }
            var28_52 = this.handler;
            var28_52.removeMessages(var8_8);
            var3_3 = (int)this.isQuickScaling;
            if (var3_3 != 0) {
                this.isQuickScaling = false;
                var3_3 = (int)this.quickScaleMoved;
                if (var3_3 == 0) {
                    var28_52 = this.quickScaleSCenter;
                    var29_57 = this.vCenterStart;
                    this.doubleTapZoom((PointF)var28_52, var29_57);
                }
            }
            if ((var3_3 = this.maxTouchCount) > 0 && ((var3_3 = (int)this.isZooming) != 0 || (var4_4 = (int)this.isPanning) != 0)) {
                if (var3_3 != 0 && var2_2 == var6_6) {
                    this.isPanning = var8_8;
                    var28_52 = this.vTranslateStart;
                    var29_57 = this.vTranslate;
                    var11_13 = var29_57.x;
                    var5_5 = var29_57.y;
                    var28_52.set(var11_13, var5_5);
                    var3_3 = var1_1.getActionIndex();
                    if (var3_3 == var8_8) {
                        var28_52 = this.vCenterStart;
                        var5_5 = var1_1.getX(0);
                        var16_29 = var1_1.getY(0);
                        var28_52.set(var5_5, var16_29);
                    } else {
                        var28_52 = this.vCenterStart;
                        var5_5 = var1_1.getX(var8_8);
                        var16_29 = var1_1.getY(var8_8);
                        var28_52.set(var5_5, var16_29);
                    }
                }
                var17_33 = 3;
                var16_29 = 4.2E-45f;
                if (var2_2 < var17_33) {
                    this.isZooming = false;
                }
                if (var2_2 < var6_6) {
                    this.isPanning = false;
                    this.maxTouchCount = 0;
                }
                this.refreshRequiredTiles((boolean)var8_8);
                return (boolean)var8_8;
            }
            if (var2_2 == var8_8) {
                this.isZooming = false;
                this.isPanning = false;
                this.maxTouchCount = 0;
            }
            return (boolean)var8_8;
        }
        var12_18 = 0.0f;
        var28_53 = null;
        this.anim = null;
        this.requestDisallowInterceptTouchEvent((boolean)var8_8);
        this.maxTouchCount = var3_3 = Math.max(this.maxTouchCount, var2_2);
        if (var2_2 >= var6_6) {
            var2_2 = this.zoomEnabled;
            if (var2_2 != 0) {
                var13_22 = var1_1.getX(0);
                var12_18 = var1_1.getX(var8_8);
                var7_7 = var1_1.getY(0);
                var11_13 = var1_1.getY(var8_8);
                var13_22 = this.distance(var13_22, var12_18, var7_7, var11_13);
                this.scaleStart = var12_18 = this.scale;
                this.vDistStart = var13_22;
                var21_42 = this.vTranslateStart;
                var28_53 = this.vTranslate;
                var7_7 = var28_53.x;
                var12_18 = var28_53.y;
                var21_42.set(var7_7, var12_18);
                var21_42 = this.vCenterStart;
                var12_18 = var1_1.getX(0);
                var7_7 = var1_1.getX(var8_8);
                var12_18 = (var12_18 + var7_7) / var5_5;
                var7_7 = var1_1.getY(0);
                var16_30 = var1_1.getY(var8_8);
                var7_7 = (var7_7 + var16_30) / var5_5;
                var21_42.set(var12_18, var7_7);
            } else {
                this.maxTouchCount = 0;
            }
            var1_1 = this.handler;
            var1_1.removeMessages(var8_8);
        } else {
            var2_2 = this.isQuickScaling;
            if (var2_2 == 0) {
                var21_43 = this.vTranslateStart;
                var28_53 = this.vTranslate;
                var5_5 = var28_53.x;
                var12_18 = var28_53.y;
                var21_43.set(var5_5, var12_18);
                var21_43 = this.vCenterStart;
                var12_18 = var1_1.getX();
                var16_31 = var1_1.getY();
                var21_43.set(var12_18, var16_31);
                var1_1 = this.handler;
                var42_71 = 600L;
                var1_1.sendEmptyMessageDelayed(var8_8, var42_71);
            }
        }
        return (boolean)var8_8;
    }

    private void preDraw() {
        int n10 = this.getWidth();
        if (n10 && (n10 = this.getHeight()) && (n10 = this.sWidth) > 0 && (n10 = this.sHeight) > 0) {
            float f10;
            Object object = this.sPendingCenter;
            if (object != null && (object = this.pendingScale) != null) {
                this.scale = f10 = ((Float)object).floatValue();
                object = this.vTranslate;
                if (object == null) {
                    object = new PointF();
                    this.vTranslate = object;
                }
                object = this.vTranslate;
                float f11 = this.getWidth() / 2;
                float f12 = this.scale;
                float f13 = this.sPendingCenter.x;
                ((PointF)object).x = f11 -= (f12 *= f13);
                object = this.vTranslate;
                int n11 = this.getHeight() / 2;
                f11 = n11;
                f12 = this.scale;
                PointF pointF = this.sPendingCenter;
                f13 = pointF.y;
                ((PointF)object).y = f11 -= (f12 *= f13);
                object = null;
                this.sPendingCenter = null;
                this.pendingScale = null;
                n10 = 1;
                f10 = Float.MIN_VALUE;
                this.fitToBounds(n10 != 0);
                this.refreshRequiredTiles(n10 != 0);
            }
            n10 = 0;
            f10 = 0.0f;
            object = null;
            this.fitToBounds(false);
        }
    }

    private void refreshRequiredTiles(boolean bl2) {
        Object object = this.decoder;
        if (object != null && (object = this.tileMap) != null) {
            boolean bl3;
            int n10 = this.fullImageSampleSize;
            float f10 = this.scale;
            int n11 = this.calculateInSampleSize(f10);
            n10 = Math.min(n10, n11);
            Iterator iterator2 = this.tileMap.entrySet().iterator();
            while (bl3 = iterator2.hasNext()) {
                boolean bl4;
                Iterator iterator3 = ((List)iterator2.next().getValue()).iterator();
                while (bl4 = iterator3.hasNext()) {
                    Object object2;
                    int n12;
                    SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile = (SubsamplingScaleImageView$Tile)iterator3.next();
                    int n13 = SubsamplingScaleImageView$Tile.access$4300(subsamplingScaleImageView$Tile);
                    int n14 = 0;
                    ImageRegionDecoder imageRegionDecoder = null;
                    if (n13 < n10 || (n13 = SubsamplingScaleImageView$Tile.access$4300(subsamplingScaleImageView$Tile)) > n10 && (n13 = SubsamplingScaleImageView$Tile.access$4300(subsamplingScaleImageView$Tile)) != (n12 = this.fullImageSampleSize)) {
                        SubsamplingScaleImageView$Tile.access$402(subsamplingScaleImageView$Tile, false);
                        object2 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile);
                        if (object2 != null) {
                            object2 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile);
                            object2.recycle();
                            SubsamplingScaleImageView$Tile.access$502(subsamplingScaleImageView$Tile, null);
                        }
                    }
                    n13 = SubsamplingScaleImageView$Tile.access$4300(subsamplingScaleImageView$Tile);
                    n12 = 1;
                    if (n13 == n10) {
                        n13 = (int)(this.tileVisible(subsamplingScaleImageView$Tile) ? 1 : 0);
                        if (n13 != 0) {
                            SubsamplingScaleImageView$Tile.access$402(subsamplingScaleImageView$Tile, n12 != 0);
                            n13 = (int)(SubsamplingScaleImageView$Tile.access$4000(subsamplingScaleImageView$Tile) ? 1 : 0);
                            if (n13 != 0 || (object2 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile)) != null || !bl2) continue;
                            imageRegionDecoder = this.decoder;
                            object2 = new SubsamplingScaleImageView$TileLoadTask(this, imageRegionDecoder, subsamplingScaleImageView$Tile);
                            this.execute((AsyncTask)object2);
                            continue;
                        }
                        n13 = SubsamplingScaleImageView$Tile.access$4300(subsamplingScaleImageView$Tile);
                        if (n13 == (n12 = this.fullImageSampleSize)) continue;
                        SubsamplingScaleImageView$Tile.access$402(subsamplingScaleImageView$Tile, false);
                        object2 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile);
                        if (object2 == null) continue;
                        object2 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile);
                        object2.recycle();
                        SubsamplingScaleImageView$Tile.access$502(subsamplingScaleImageView$Tile, null);
                        continue;
                    }
                    n13 = SubsamplingScaleImageView$Tile.access$4300(subsamplingScaleImageView$Tile);
                    if (n13 != (n14 = this.fullImageSampleSize)) continue;
                    SubsamplingScaleImageView$Tile.access$402(subsamplingScaleImageView$Tile, n12 != 0);
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean bl2) {
        ViewParent viewParent = this.getParent();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void reset(boolean bl2) {
        Object object;
        Iterator iterator2 = new Iterator();
        ((StringBuilder)((Object)iterator2)).append("reset newImage=");
        ((StringBuilder)((Object)iterator2)).append(bl2);
        iterator2 = ((StringBuilder)((Object)iterator2)).toString();
        Object[] objectArray = new Object[]{};
        this.debug((String)((Object)iterator2), objectArray);
        boolean bl3 = false;
        iterator2 = null;
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        objectArray = null;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        Object object2 = Float.valueOf(0.0f);
        this.pendingScale = object2;
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (bl2) {
            this.uri = null;
            object = this.decoder;
            if (object != null) {
                object = this.decoderLock;
                synchronized (object) {
                    iterator2 = this.decoder;
                    iterator2.recycle();
                    this.decoder = null;
                }
            }
            if ((object = this.bitmap) != null && !(bl3 = this.bitmapIsCached)) {
                object.recycle();
            }
            if ((object = this.bitmap) != null && (bl2 = this.bitmapIsCached) && (object = this.onImageEventListener) != null) {
                object.onPreviewReleased();
            }
            this.sWidth = 0;
            this.sHeight = 0;
            this.sOrientation = 0;
            this.sRegion = null;
            this.pRegion = null;
            this.readySent = false;
            this.imageLoadedSent = false;
            this.bitmap = null;
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        if ((object = this.tileMap) != null) {
            object = object.entrySet().iterator();
            while (bl3 = object.hasNext()) {
                boolean bl4;
                iterator2 = ((List)((Map.Entry)object.next()).getValue()).iterator();
                while (bl4 = iterator2.hasNext()) {
                    object2 = (SubsamplingScaleImageView$Tile)iterator2.next();
                    SubsamplingScaleImageView$Tile.access$402((SubsamplingScaleImageView$Tile)object2, false);
                    Bitmap bitmap = SubsamplingScaleImageView$Tile.access$500((SubsamplingScaleImageView$Tile)object2);
                    if (bitmap == null) continue;
                    bitmap = SubsamplingScaleImageView$Tile.access$500((SubsamplingScaleImageView$Tile)object2);
                    bitmap.recycle();
                    SubsamplingScaleImageView$Tile.access$502((SubsamplingScaleImageView$Tile)object2, null);
                }
            }
            this.tileMap = null;
        }
        object = this.getContext();
        this.setGestureDetector((Context)object);
    }

    private void restoreState(ImageViewState imageViewState) {
        int n10;
        Integer n11;
        int n12;
        Object object;
        if (imageViewState != null && (object = imageViewState.getCenter()) != null && (n12 = (object = VALID_ORIENTATIONS).contains(n11 = Integer.valueOf(n10 = imageViewState.getOrientation()))) != 0) {
            this.orientation = n12 = imageViewState.getOrientation();
            float f10 = imageViewState.getScale();
            this.pendingScale = object = Float.valueOf(f10);
            imageViewState = imageViewState.getCenter();
            this.sPendingCenter = imageViewState;
            this.invalidate();
        }
    }

    private int sHeight() {
        int n10;
        int n11 = this.getRequiredRotation();
        if (n11 != (n10 = 90) && n11 != (n10 = 270)) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private int sWidth() {
        int n10;
        int n11 = this.getRequiredRotation();
        if (n11 != (n10 = 90) && n11 != (n10 = 270)) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    private void sendStateChanged(float f10, PointF pointF, int n10) {
        SubsamplingScaleImageView$OnStateChangedListener subsamplingScaleImageView$OnStateChangedListener;
        float f11;
        float f12;
        float f13;
        SubsamplingScaleImageView$OnStateChangedListener subsamplingScaleImageView$OnStateChangedListener2 = this.onStateChangedListener;
        if (subsamplingScaleImageView$OnStateChangedListener2 != null && (f13 = (f12 = (f11 = this.scale) - f10) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) != false) {
            subsamplingScaleImageView$OnStateChangedListener2.onScaleChanged(f11, n10);
        }
        if ((subsamplingScaleImageView$OnStateChangedListener = this.onStateChangedListener) != null && (f13 = (float)(subsamplingScaleImageView$OnStateChangedListener = this.vTranslate).equals(pointF)) == false) {
            subsamplingScaleImageView$OnStateChangedListener = this.onStateChangedListener;
            pointF = this.getCenter();
            subsamplingScaleImageView$OnStateChangedListener.onCenterChanged(pointF, n10);
        }
    }

    private void setGestureDetector(Context context) {
        GestureDetector gestureDetector;
        SubsamplingScaleImageView$2 subsamplingScaleImageView$2 = new SubsamplingScaleImageView$2(this, context);
        this.detector = gestureDetector = new GestureDetector(context, (GestureDetector.OnGestureListener)subsamplingScaleImageView$2);
    }

    private void setMatrixArray(float[] fArray, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        fArray[0] = f10;
        fArray[1] = f11;
        fArray[2] = f12;
        fArray[3] = f13;
        fArray[4] = f14;
        fArray[5] = f15;
        fArray[6] = f16;
        fArray[7] = f17;
    }

    private Rect sourceToViewRect(Rect rect, Rect rect2) {
        float f10 = rect.left;
        int n10 = (int)this.sourceToViewX(f10);
        float f11 = rect.top;
        int n11 = (int)this.sourceToViewY(f11);
        float f12 = rect.right;
        int n12 = (int)this.sourceToViewX(f12);
        float f13 = rect.bottom;
        int n13 = (int)this.sourceToViewY(f13);
        rect2.set(n10, n11, n12, n13);
        return rect2;
    }

    private float sourceToViewX(float f10) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return 0.0f / 0.0f;
        }
        float f11 = this.scale;
        float f12 = pointF.x;
        return (f10 *= f11) + f12;
    }

    private float sourceToViewY(float f10) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return 0.0f / 0.0f;
        }
        float f11 = this.scale;
        float f12 = pointF.y;
        return (f10 *= f11) + f12;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean tileVisible(SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile) {
        void var15_21;
        boolean bl2 = false;
        float f10 = this.viewToSourceX(0.0f);
        int n10 = this.getWidth();
        float f11 = n10;
        f11 = this.viewToSourceX(f11);
        float f12 = this.viewToSourceY(0.0f);
        int n11 = this.getHeight();
        float f13 = n11;
        f13 = this.viewToSourceY(f13);
        Rect rect = SubsamplingScaleImageView$Tile.access$4100(subsamplingScaleImageView$Tile);
        int n12 = rect.right;
        float f14 = n12;
        float f15 = f10 - f14;
        Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object <= 0) {
            Rect rect2 = SubsamplingScaleImageView$Tile.access$4100(subsamplingScaleImageView$Tile);
            f10 = rect2.left;
            float f16 = f10 - f11;
            Object object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object2 <= 0) {
                rect2 = SubsamplingScaleImageView$Tile.access$4100(subsamplingScaleImageView$Tile);
                int n13 = rect2.bottom;
                f10 = n13;
                float f17 = f12 - f10;
                Object object3 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
                if (object3 <= 0) {
                    subsamplingScaleImageView$Tile = SubsamplingScaleImageView$Tile.access$4100(subsamplingScaleImageView$Tile);
                    float f18 = ((Rect)subsamplingScaleImageView$Tile).top;
                    float f19 = f18 - f13;
                    Object object4 = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
                    if (object4 <= 0) {
                        return (boolean)var15_21;
                    }
                }
            }
        }
        boolean bl3 = false;
        return (boolean)var15_21;
    }

    private PointF vTranslateForSCenter(float f10, float f11, float f12) {
        int n10 = this.getPaddingLeft();
        int n11 = this.getWidth();
        int n12 = this.getPaddingRight();
        n11 -= n12;
        n12 = this.getPaddingLeft();
        n11 = (n11 - n12) / 2;
        n10 += n11;
        n11 = this.getPaddingTop();
        n12 = this.getHeight();
        int n13 = this.getPaddingBottom();
        n12 -= n13;
        n13 = this.getPaddingTop();
        n12 = (n12 - n13) / 2;
        n11 += n12;
        SubsamplingScaleImageView$ScaleAndTranslate subsamplingScaleImageView$ScaleAndTranslate = this.satTemp;
        if (subsamplingScaleImageView$ScaleAndTranslate == null) {
            PointF pointF = new PointF(0.0f, 0.0f);
            this.satTemp = subsamplingScaleImageView$ScaleAndTranslate = new SubsamplingScaleImageView$ScaleAndTranslate(0.0f, pointF, null);
        }
        SubsamplingScaleImageView$ScaleAndTranslate.access$4702(this.satTemp, f12);
        subsamplingScaleImageView$ScaleAndTranslate = SubsamplingScaleImageView$ScaleAndTranslate.access$4800(this.satTemp);
        float f13 = n10;
        f10 = n11;
        subsamplingScaleImageView$ScaleAndTranslate.set(f13 -= (f10 *= f12), f10 -= (f11 *= f12));
        SubsamplingScaleImageView$ScaleAndTranslate subsamplingScaleImageView$ScaleAndTranslate2 = this.satTemp;
        this.fitToBounds(true, subsamplingScaleImageView$ScaleAndTranslate2);
        return SubsamplingScaleImageView$ScaleAndTranslate.access$4800(this.satTemp);
    }

    private float viewToSourceX(float f10) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return 0.0f / 0.0f;
        }
        float f11 = pointF.x;
        f10 -= f11;
        f11 = this.scale;
        return f10 / f11;
    }

    private float viewToSourceY(float f10) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return 0.0f / 0.0f;
        }
        float f11 = pointF.y;
        f10 -= f11;
        f11 = this.scale;
        return f10 / f11;
    }

    public SubsamplingScaleImageView$AnimationBuilder animateCenter(PointF pointF) {
        boolean bl2 = this.isReady();
        if (!bl2) {
            return null;
        }
        SubsamplingScaleImageView$AnimationBuilder subsamplingScaleImageView$AnimationBuilder = new SubsamplingScaleImageView$AnimationBuilder(this, pointF, null);
        return subsamplingScaleImageView$AnimationBuilder;
    }

    public SubsamplingScaleImageView$AnimationBuilder animateScale(float f10) {
        boolean bl2 = this.isReady();
        if (!bl2) {
            return null;
        }
        SubsamplingScaleImageView$AnimationBuilder subsamplingScaleImageView$AnimationBuilder = new SubsamplingScaleImageView$AnimationBuilder(this, f10, null);
        return subsamplingScaleImageView$AnimationBuilder;
    }

    public SubsamplingScaleImageView$AnimationBuilder animateScaleAndCenter(float f10, PointF pointF) {
        boolean bl2 = this.isReady();
        if (!bl2) {
            return null;
        }
        SubsamplingScaleImageView$AnimationBuilder subsamplingScaleImageView$AnimationBuilder = new SubsamplingScaleImageView$AnimationBuilder(this, f10, pointF, null);
        return subsamplingScaleImageView$AnimationBuilder;
    }

    public final int getAppliedOrientation() {
        return this.getRequiredRotation();
    }

    public final PointF getCenter() {
        int n10 = this.getWidth() / 2;
        int n11 = this.getHeight() / 2;
        float f10 = n10;
        float f11 = n11;
        return this.viewToSourceCoord(f10, f11);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return this.minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final ImageViewState getState() {
        int n10;
        Object object = this.vTranslate;
        if (object != null && (n10 = this.sWidth) > 0 && (n10 = this.sHeight) > 0) {
            float f10 = this.getScale();
            PointF pointF = this.getCenter();
            int n11 = this.getOrientation();
            object = new ImageViewState(f10, pointF, n11);
            return object;
        }
        return null;
    }

    public boolean hasImage() {
        boolean bl2;
        Uri uri = this.uri;
        if (uri == null && (uri = this.bitmap) == null) {
            bl2 = false;
            uri = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    /*
     * Handled impossible loop by adding 'first' condition
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDraw(Canvas canvas) {
        float f10;
        Object[] objectArray;
        int n10;
        float f11;
        int n11;
        float f12;
        int n12;
        Paint paint;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        int n13;
        float f18;
        int n14;
        long l10;
        float f19;
        Float f20;
        float f21;
        Object object;
        int n15;
        Canvas canvas2;
        SubsamplingScaleImageView subsamplingScaleImageView;
        block56: {
            int n16;
            block55: {
                subsamplingScaleImageView = this;
                canvas2 = canvas;
                super.onDraw(canvas);
                this.createPaints();
                n15 = this.sWidth;
                if (n15 == 0) return;
                n15 = this.sHeight;
                if (n15 == 0) return;
                n15 = this.getWidth();
                if (n15 == 0) return;
                n15 = this.getHeight();
                if (n15 == 0) {
                    return;
                }
                object = this.tileMap;
                if (object == null && (object = this.decoder) != null) {
                    object = this.getMaxBitmapDimensions(canvas);
                    this.initialiseBaseLayer((Point)object);
                }
                if ((n15 = (int)(this.checkReady() ? 1 : 0)) == 0) {
                    return;
                }
                this.preDraw();
                object = subsamplingScaleImageView.anim;
                f21 = 0.0f;
                f20 = null;
                if (object != null) {
                    SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim;
                    SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim2;
                    float f22;
                    f19 = subsamplingScaleImageView.scale;
                    PointF pointF = subsamplingScaleImageView.vTranslateBefore;
                    if (pointF == null) {
                        PointF pointF2;
                        subsamplingScaleImageView.vTranslateBefore = pointF2 = new PointF(0.0f, 0.0f);
                    }
                    PointF pointF3 = subsamplingScaleImageView.vTranslateBefore;
                    PointF pointF4 = subsamplingScaleImageView.vTranslate;
                    pointF3.set(pointF4);
                    long l11 = System.currentTimeMillis();
                    long l12 = SubsamplingScaleImageView$Anim.access$3100(subsamplingScaleImageView.anim);
                    l11 -= l12;
                    SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim3 = subsamplingScaleImageView.anim;
                    l12 = SubsamplingScaleImageView$Anim.access$3200(subsamplingScaleImageView$Anim3);
                    l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    if (l10 > 0) {
                        n14 = 1;
                        f18 = Float.MIN_VALUE;
                    } else {
                        n14 = 0;
                        f18 = 0.0f;
                    }
                    l12 = SubsamplingScaleImageView$Anim.access$3200(subsamplingScaleImageView.anim);
                    long l13 = Math.min(l11, l12);
                    n13 = SubsamplingScaleImageView$Anim.access$3300(subsamplingScaleImageView.anim);
                    f17 = SubsamplingScaleImageView$Anim.access$3400(subsamplingScaleImageView.anim);
                    f16 = SubsamplingScaleImageView$Anim.access$3500(subsamplingScaleImageView.anim);
                    f15 = SubsamplingScaleImageView$Anim.access$3400(subsamplingScaleImageView.anim);
                    f14 = f16 - f15;
                    long l14 = SubsamplingScaleImageView$Anim.access$3200(subsamplingScaleImageView.anim);
                    SubsamplingScaleImageView subsamplingScaleImageView2 = this;
                    l12 = l13;
                    subsamplingScaleImageView.scale = f16 = this.ease(n13, l13, f17, f14, l14);
                    n13 = SubsamplingScaleImageView$Anim.access$3300(subsamplingScaleImageView.anim);
                    f17 = SubsamplingScaleImageView$Anim.access$3600((SubsamplingScaleImageView$Anim)subsamplingScaleImageView.anim).x;
                    f16 = SubsamplingScaleImageView$Anim.access$3700((SubsamplingScaleImageView$Anim)subsamplingScaleImageView.anim).x;
                    f15 = SubsamplingScaleImageView$Anim.access$3600((SubsamplingScaleImageView$Anim)subsamplingScaleImageView.anim).x;
                    f14 = f16 - f15;
                    l14 = SubsamplingScaleImageView$Anim.access$3200(subsamplingScaleImageView.anim);
                    SubsamplingScaleImageView subsamplingScaleImageView3 = this;
                    float f23 = this.ease(n13, l13, f17, f14, l14);
                    n13 = SubsamplingScaleImageView$Anim.access$3300(subsamplingScaleImageView.anim);
                    f17 = SubsamplingScaleImageView$Anim.access$3600((SubsamplingScaleImageView$Anim)subsamplingScaleImageView.anim).y;
                    f16 = SubsamplingScaleImageView$Anim.access$3700((SubsamplingScaleImageView$Anim)subsamplingScaleImageView.anim).y;
                    PointF pointF5 = SubsamplingScaleImageView$Anim.access$3600(subsamplingScaleImageView.anim);
                    f15 = pointF5.y;
                    f14 = f16 - f15;
                    l14 = SubsamplingScaleImageView$Anim.access$3200(subsamplingScaleImageView.anim);
                    SubsamplingScaleImageView subsamplingScaleImageView4 = this;
                    f16 = this.ease(n13, l13, f17, f14, l14);
                    PointF pointF6 = subsamplingScaleImageView.vTranslate;
                    f15 = pointF6.x;
                    f13 = SubsamplingScaleImageView$Anim.access$3800((SubsamplingScaleImageView$Anim)subsamplingScaleImageView.anim).x;
                    f13 = subsamplingScaleImageView.sourceToViewX(f13) - f23;
                    pointF6.x = f15 -= f13;
                    PointF pointF7 = subsamplingScaleImageView.vTranslate;
                    f15 = pointF7.y;
                    paint = SubsamplingScaleImageView$Anim.access$3800(subsamplingScaleImageView.anim);
                    f13 = paint.y;
                    f13 = subsamplingScaleImageView.sourceToViewY(f13) - f16;
                    pointF7.y = f15 -= f13;
                    if (n14 == 0 && (n12 = (f22 = (f16 = SubsamplingScaleImageView$Anim.access$3400(subsamplingScaleImageView$Anim2 = subsamplingScaleImageView.anim)) - (f12 = SubsamplingScaleImageView$Anim.access$3500(subsamplingScaleImageView$Anim = subsamplingScaleImageView.anim))) == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1)) != 0) {
                        n12 = 0;
                        f16 = 0.0f;
                        Object var9_18 = null;
                    } else {
                        n12 = 1;
                        f16 = Float.MIN_VALUE;
                    }
                    subsamplingScaleImageView.fitToBounds(n12 != 0);
                    PointF pointF8 = subsamplingScaleImageView.vTranslateBefore;
                    SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim4 = subsamplingScaleImageView.anim;
                    n13 = SubsamplingScaleImageView$Anim.access$3900(subsamplingScaleImageView$Anim4);
                    subsamplingScaleImageView.sendStateChanged(f19, pointF8, n13);
                    subsamplingScaleImageView.refreshRequiredTiles(n14 != 0);
                    if (n14 != 0) {
                        object = SubsamplingScaleImageView$Anim.access$2800(subsamplingScaleImageView.anim);
                        if (object != null) {
                            try {
                                object = subsamplingScaleImageView.anim;
                                object = SubsamplingScaleImageView$Anim.access$2800((SubsamplingScaleImageView$Anim)object);
                                object.onComplete();
                            }
                            catch (Exception exception) {
                                String string2 = TAG;
                                String string3 = "Error thrown by animation listener";
                                Log.w((String)string2, (String)string3, (Throwable)exception);
                            }
                        }
                        n15 = 0;
                        f19 = 0.0f;
                        object = null;
                        subsamplingScaleImageView.anim = null;
                    }
                    this.invalidate();
                }
                object = subsamplingScaleImageView.tileMap;
                n16 = 270;
                n14 = 90;
                f18 = 1.26E-43f;
                n11 = 180;
                f11 = 2.52E-43f;
                if (object != null && (n15 = (int)(this.isBaseLayerReady() ? 1 : 0)) != 0) break block55;
                int n17 = n11;
                float f24 = f11;
                int n18 = n14;
                float f25 = f18;
                object = subsamplingScaleImageView.bitmap;
                if (object != null) {
                    f16 = subsamplingScaleImageView.scale;
                    n13 = subsamplingScaleImageView.bitmapIsPreview;
                    if (n13 != 0) {
                        f12 = subsamplingScaleImageView.sWidth;
                        n15 = object.getWidth();
                        f19 = n15;
                        f16 *= (f12 /= f19);
                        f19 = subsamplingScaleImageView.scale;
                        n13 = subsamplingScaleImageView.sHeight;
                        f12 = n13;
                        Bitmap bitmap = subsamplingScaleImageView.bitmap;
                        l10 = bitmap.getHeight();
                        f15 = l10;
                        f19 *= (f12 /= f15);
                    } else {
                        f19 = f16;
                    }
                    Matrix matrix = subsamplingScaleImageView.matrix;
                    if (matrix == null) {
                        Matrix matrix2;
                        subsamplingScaleImageView.matrix = matrix2 = new Matrix();
                    }
                    subsamplingScaleImageView.matrix.reset();
                    Matrix matrix3 = subsamplingScaleImageView.matrix;
                    matrix3.postScale(f16, f19);
                    object = subsamplingScaleImageView.matrix;
                    n12 = this.getRequiredRotation();
                    f16 = n12;
                    object.postRotate(f16);
                    object = subsamplingScaleImageView.matrix;
                    PointF pointF = subsamplingScaleImageView.vTranslate;
                    f12 = pointF.x;
                    f16 = pointF.y;
                    object.postTranslate(f12, f16);
                    n15 = this.getRequiredRotation();
                    if (n15 == n17) {
                        object = subsamplingScaleImageView.matrix;
                        f16 = subsamplingScaleImageView.scale;
                        n13 = subsamplingScaleImageView.sWidth;
                        f12 = (float)n13 * f16;
                        l10 = subsamplingScaleImageView.sHeight;
                        f15 = l10;
                        object.postTranslate(f12, f16 *= f15);
                    } else {
                        n15 = this.getRequiredRotation();
                        if (n15 == n18) {
                            object = subsamplingScaleImageView.matrix;
                            f16 = subsamplingScaleImageView.scale;
                            n13 = subsamplingScaleImageView.sHeight;
                            f12 = n13;
                            object.postTranslate(f16 *= f12, 0.0f);
                        } else {
                            n15 = this.getRequiredRotation();
                            if (n15 == n16) {
                                object = subsamplingScaleImageView.matrix;
                                f16 = subsamplingScaleImageView.scale;
                                n13 = subsamplingScaleImageView.sWidth;
                                f12 = n13;
                                object.postTranslate(0.0f, f16 *= f12);
                            }
                        }
                    }
                    object = subsamplingScaleImageView.tileBgPaint;
                    if (object != null) {
                        object = subsamplingScaleImageView.sRect;
                        if (object == null) {
                            object = new RectF();
                            subsamplingScaleImageView.sRect = object;
                        }
                        object = subsamplingScaleImageView.sRect;
                        n12 = (int)(subsamplingScaleImageView.bitmapIsPreview ? 1 : 0);
                        if (n12 != 0) {
                            Bitmap bitmap = subsamplingScaleImageView.bitmap;
                            n12 = bitmap.getWidth();
                        } else {
                            n12 = subsamplingScaleImageView.sWidth;
                        }
                        f16 = n12;
                        n13 = (int)(subsamplingScaleImageView.bitmapIsPreview ? 1 : 0);
                        if (n13 != 0) {
                            Bitmap bitmap = subsamplingScaleImageView.bitmap;
                            n13 = bitmap.getHeight();
                        } else {
                            n13 = subsamplingScaleImageView.sHeight;
                        }
                        f12 = n13;
                        object.set(0.0f, 0.0f, f16, f12);
                        object = subsamplingScaleImageView.matrix;
                        RectF rectF = subsamplingScaleImageView.sRect;
                        object.mapRect(rectF);
                        object = subsamplingScaleImageView.sRect;
                        Paint paint2 = subsamplingScaleImageView.tileBgPaint;
                        canvas2.drawRect((RectF)object, paint2);
                    }
                    object = subsamplingScaleImageView.bitmap;
                    Matrix matrix4 = subsamplingScaleImageView.matrix;
                    Paint paint3 = subsamplingScaleImageView.bitmapPaint;
                    canvas2.drawBitmap((Bitmap)object, matrix4, paint3);
                }
                break block56;
            }
            n15 = subsamplingScaleImageView.fullImageSampleSize;
            f16 = subsamplingScaleImageView.scale;
            n12 = subsamplingScaleImageView.calculateInSampleSize(f16);
            n15 = Math.min(n15, n12);
            Iterator iterator2 = subsamplingScaleImageView.tileMap.entrySet().iterator();
            boolean bl2 = false;
            while ((n13 = iterator2.hasNext()) != 0) {
                Map.Entry entry = iterator2.next();
                Integer n19 = (Integer)entry.getKey();
                l10 = n19.intValue();
                if (l10 != n15) continue;
                Iterator iterator3 = ((List)entry.getValue()).iterator();
                while ((l10 = (long)iterator3.hasNext()) != false) {
                    Bitmap bitmap;
                    SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile = (SubsamplingScaleImageView$Tile)iterator3.next();
                    n10 = SubsamplingScaleImageView$Tile.access$400(subsamplingScaleImageView$Tile);
                    if (n10 == 0 || (n10 = SubsamplingScaleImageView$Tile.access$4000(subsamplingScaleImageView$Tile)) == 0 && (bitmap = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile)) != null) continue;
                    bl2 = true;
                }
            }
            Set set = subsamplingScaleImageView.tileMap.entrySet();
            Iterator iterator4 = set.iterator();
            block4: while ((n12 = (int)(iterator4.hasNext() ? 1 : 0)) != 0) {
                boolean bl3 = true;
                while (true) {
                    Bitmap bitmap;
                    Object e10;
                    float f26;
                    int n20;
                    float f27;
                    int n21;
                    Iterator iterator5;
                    block59: {
                        block58: {
                            block57: {
                                if (!bl3 || (bl3 = false)) break block57;
                                Map.Entry entry = iterator4.next();
                                Integer n22 = (Integer)entry.getKey();
                                n13 = n22;
                                if (n13 != n15 && !bl2) break block58;
                                List list = (List)entry.getValue();
                                iterator5 = list.iterator();
                            }
                            if ((n12 = (int)(iterator5.hasNext() ? 1 : 0)) != 0) break block59;
                        }
                        n21 = n11;
                        f27 = f11;
                        n20 = n14;
                        f26 = f18;
                        continue block4;
                    }
                    Object e11 = e10 = iterator5.next();
                    SubsamplingScaleImageView$Tile subsamplingScaleImageView$Tile = (SubsamplingScaleImageView$Tile)e10;
                    Rect rect = SubsamplingScaleImageView$Tile.access$4100(subsamplingScaleImageView$Tile);
                    Rect rect2 = SubsamplingScaleImageView$Tile.access$4200(subsamplingScaleImageView$Tile);
                    subsamplingScaleImageView.sourceToViewRect(rect, rect2);
                    n12 = (int)(SubsamplingScaleImageView$Tile.access$4000(subsamplingScaleImageView$Tile) ? 1 : 0);
                    if (n12 == 0 && (bitmap = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile)) != null) {
                        Matrix matrix;
                        Paint paint4 = subsamplingScaleImageView.tileBgPaint;
                        if (paint4 != null) {
                            Rect rect3 = SubsamplingScaleImageView$Tile.access$4200(subsamplingScaleImageView$Tile);
                            Paint paint5 = subsamplingScaleImageView.tileBgPaint;
                            canvas2.drawRect(rect3, paint5);
                        }
                        if ((matrix = subsamplingScaleImageView.matrix) == null) {
                            Matrix matrix5;
                            subsamplingScaleImageView.matrix = matrix5 = new Matrix();
                        }
                        subsamplingScaleImageView.matrix.reset();
                        float[] fArray = subsamplingScaleImageView.srcArray;
                        l10 = 0;
                        f15 = 0.0f;
                        Object var15_117 = null;
                        n10 = 0;
                        f13 = 0.0f;
                        paint = null;
                        f17 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile).getWidth();
                        f14 = 0.0f;
                        objectArray = null;
                        f10 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile).getWidth();
                        f21 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile).getHeight();
                        f16 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile).getHeight();
                        SubsamplingScaleImageView subsamplingScaleImageView5 = this;
                        n21 = n11;
                        f27 = f11;
                        f11 = f21;
                        f20 = null;
                        f21 = 0.0f;
                        n20 = n14;
                        f26 = f18;
                        f18 = f16;
                        this.setMatrixArray(fArray, 0.0f, 0.0f, f17, 0.0f, f10, f11, 0.0f, f16);
                        n12 = this.getRequiredRotation();
                        if (n12 == 0) {
                            float[] fArray2 = subsamplingScaleImageView.dstArray;
                            f15 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                            f13 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                            f17 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                            f14 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                            f10 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                            f11 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                            f21 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                            n12 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                            f18 = n12;
                            SubsamplingScaleImageView subsamplingScaleImageView6 = this;
                            this.setMatrixArray(fArray2, f15, f13, f17, f14, f10, f11, f21, f18);
                        } else {
                            n12 = this.getRequiredRotation();
                            if (n12 == n14) {
                                float[] fArray3 = subsamplingScaleImageView.dstArray;
                                f15 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                                f13 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                                f17 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                                f14 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                                f10 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                                f11 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                                f21 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                                n12 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                                f18 = n12;
                                SubsamplingScaleImageView subsamplingScaleImageView7 = this;
                                this.setMatrixArray(fArray3, f15, f13, f17, f14, f10, f11, f21, f18);
                            } else {
                                n12 = this.getRequiredRotation();
                                if (n12 == n11) {
                                    float[] fArray4 = subsamplingScaleImageView.dstArray;
                                    f15 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                                    f13 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                                    f17 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                                    f14 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                                    f10 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                                    f11 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                                    f21 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                                    n12 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                                    f18 = n12;
                                    SubsamplingScaleImageView subsamplingScaleImageView8 = this;
                                    this.setMatrixArray(fArray4, f15, f13, f17, f14, f10, f11, f21, f18);
                                } else {
                                    n12 = this.getRequiredRotation();
                                    if (n12 == n16) {
                                        float[] fArray5 = subsamplingScaleImageView.dstArray;
                                        f15 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                                        f13 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                                        f17 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                                        f14 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                                        f10 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                                        f11 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                                        f21 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                                        n12 = SubsamplingScaleImageView$Tile.access$4200((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                                        f18 = n12;
                                        SubsamplingScaleImageView subsamplingScaleImageView9 = this;
                                        this.setMatrixArray(fArray5, f15, f13, f17, f14, f10, f11, f21, f18);
                                    }
                                }
                            }
                        }
                        Matrix matrix6 = subsamplingScaleImageView.matrix;
                        float[] fArray6 = subsamplingScaleImageView.srcArray;
                        float[] fArray7 = subsamplingScaleImageView.dstArray;
                        int n23 = 4;
                        matrix6.setPolyToPoly(fArray6, 0, fArray7, 0, n23);
                        Bitmap bitmap2 = SubsamplingScaleImageView$Tile.access$500(subsamplingScaleImageView$Tile);
                        Matrix matrix7 = subsamplingScaleImageView.matrix;
                        Paint paint6 = subsamplingScaleImageView.bitmapPaint;
                        canvas2.drawBitmap(bitmap2, matrix7, paint6);
                        n12 = (int)(subsamplingScaleImageView.debug ? 1 : 0);
                        if (n12 != 0) {
                            Rect rect4 = SubsamplingScaleImageView$Tile.access$4200(subsamplingScaleImageView$Tile);
                            Paint paint7 = subsamplingScaleImageView.debugPaint;
                            canvas2.drawRect(rect4, paint7);
                        }
                    } else {
                        n21 = n11;
                        f27 = f11;
                        n20 = n14;
                        f26 = f18;
                        n12 = (int)(SubsamplingScaleImageView$Tile.access$4000(subsamplingScaleImageView$Tile) ? 1 : 0);
                        if (n12 != 0 && (n12 = (int)(subsamplingScaleImageView.debug ? 1 : 0)) != 0) {
                            Rect rect5 = SubsamplingScaleImageView$Tile.access$4200(subsamplingScaleImageView$Tile);
                            n12 = rect5.left + 5;
                            f16 = n12;
                            Rect rect6 = SubsamplingScaleImageView$Tile.access$4200(subsamplingScaleImageView$Tile);
                            n13 = rect6.top + 35;
                            f12 = n13;
                            Paint paint8 = subsamplingScaleImageView.debugPaint;
                            paint = "LOADING";
                            canvas2.drawText((String)paint, f16, f12, paint8);
                        }
                    }
                    if ((n12 = (int)(SubsamplingScaleImageView$Tile.access$400(subsamplingScaleImageView$Tile) ? 1 : 0)) != 0 && (n12 = (int)(subsamplingScaleImageView.debug ? 1 : 0)) != 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("ISS ");
                        n13 = SubsamplingScaleImageView$Tile.access$4300(subsamplingScaleImageView$Tile);
                        stringBuilder.append(n13);
                        stringBuilder.append(" RECT ");
                        n13 = SubsamplingScaleImageView$Tile.access$4100((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).top;
                        stringBuilder.append(n13);
                        String string4 = ",";
                        stringBuilder.append(string4);
                        l10 = SubsamplingScaleImageView$Tile.access$4100((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).left;
                        stringBuilder.append((int)l10);
                        stringBuilder.append(string4);
                        l10 = SubsamplingScaleImageView$Tile.access$4100((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).bottom;
                        stringBuilder.append((int)l10);
                        stringBuilder.append(string4);
                        n13 = SubsamplingScaleImageView$Tile.access$4100((SubsamplingScaleImageView$Tile)subsamplingScaleImageView$Tile).right;
                        stringBuilder.append(n13);
                        String string5 = stringBuilder.toString();
                        Rect rect7 = SubsamplingScaleImageView$Tile.access$4200(subsamplingScaleImageView$Tile);
                        n13 = rect7.left + 5;
                        f12 = n13;
                        Rect rect8 = SubsamplingScaleImageView$Tile.access$4200(subsamplingScaleImageView$Tile);
                        l10 = rect8.top + 15;
                        f15 = l10;
                        paint = subsamplingScaleImageView.debugPaint;
                        canvas2.drawText(string5, f12, f15, paint);
                    }
                    n14 = n20;
                    f18 = f26;
                    n11 = n21;
                    f11 = f27;
                }
            }
        }
        if ((n15 = (int)(subsamplingScaleImageView.debug ? 1 : 0)) == 0) return;
        object = new StringBuilder();
        ((StringBuilder)object).append("Scale: ");
        Locale locale = Locale.ENGLISH;
        Object[] objectArray2 = new Object[1];
        Float f28 = Float.valueOf(subsamplingScaleImageView.scale);
        objectArray2[0] = f28;
        String string6 = "%.2f";
        String string7 = String.format(locale, string6, objectArray2);
        ((StringBuilder)object).append(string7);
        object = ((StringBuilder)object).toString();
        paint = subsamplingScaleImageView.debugPaint;
        f17 = 5.0f;
        canvas2.drawText((String)object, f17, 15.0f, paint);
        object = new StringBuilder();
        ((StringBuilder)object).append("Translate: ");
        l10 = 1;
        paint = new Object[l10];
        objectArray = Float.valueOf(subsamplingScaleImageView.vTranslate.x);
        paint[0] = objectArray;
        paint = String.format(locale, string6, (Object[])paint);
        ((StringBuilder)object).append((String)paint);
        paint = ":";
        ((StringBuilder)object).append((String)paint);
        objectArray = new Object[l10];
        Float f29 = Float.valueOf(subsamplingScaleImageView.vTranslate.y);
        objectArray[0] = f29;
        String string8 = String.format(locale, string6, objectArray);
        ((StringBuilder)object).append(string8);
        object = ((StringBuilder)object).toString();
        Paint paint9 = subsamplingScaleImageView.debugPaint;
        f14 = 35.0f;
        canvas2.drawText((String)object, f17, f14, paint9);
        object = this.getCenter();
        StringBuilder stringBuilder = new StringBuilder();
        String string9 = "Source center: ";
        stringBuilder.append(string9);
        int n24 = 1;
        f10 = Float.MIN_VALUE;
        PointF pointF = new Object[n24];
        f21 = ((PointF)object).x;
        f20 = Float.valueOf(f21);
        n14 = 0;
        f18 = 0.0f;
        pointF[0] = f20;
        pointF = String.format(locale, string6, (Object[])pointF);
        stringBuilder.append((String)pointF);
        stringBuilder.append((String)paint);
        paint = new Object[n24];
        f19 = ((PointF)object).y;
        paint[0] = object = Float.valueOf(f19);
        object = String.format(locale, string6, (Object[])paint);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        Paint paint10 = subsamplingScaleImageView.debugPaint;
        canvas2.drawText((String)object, f17, 55.0f, paint10);
        subsamplingScaleImageView.debugPaint.setStrokeWidth(2.0f);
        object = subsamplingScaleImageView.anim;
        n12 = 1106247680;
        f16 = 30.0f;
        n13 = -16711681;
        f12 = -1.714704E38f;
        l10 = -16776961;
        f15 = -1.7014636E38f;
        n10 = 1101004800;
        f13 = 20.0f;
        int n25 = -65536;
        f17 = 0.0f / 0.0f;
        if (object != null) {
            object = SubsamplingScaleImageView$Anim.access$4400((SubsamplingScaleImageView$Anim)object);
            object = subsamplingScaleImageView.sourceToViewCoord((PointF)object);
            string9 = SubsamplingScaleImageView$Anim.access$4500(subsamplingScaleImageView.anim);
            string9 = subsamplingScaleImageView.sourceToViewCoord((PointF)string9);
            pointF = SubsamplingScaleImageView$Anim.access$3800(subsamplingScaleImageView.anim);
            pointF = subsamplingScaleImageView.sourceToViewCoord(pointF);
            f21 = ((PointF)object).x;
            f19 = ((PointF)object).y;
            n14 = 1092616192;
            f18 = 10.0f;
            Paint paint11 = subsamplingScaleImageView.debugPaint;
            canvas2.drawCircle(f21, f19, f18, paint11);
            subsamplingScaleImageView.debugPaint.setColor(n25);
            f19 = ((PointF)string9).x;
            f10 = ((PointF)string9).y;
            f20 = subsamplingScaleImageView.debugPaint;
            canvas2.drawCircle(f19, f10, f13, (Paint)f20);
            subsamplingScaleImageView.debugPaint.setColor((int)l10);
            f19 = pointF.x;
            f10 = pointF.y;
            n11 = 1103626240;
            f11 = 25.0f;
            f20 = subsamplingScaleImageView.debugPaint;
            canvas2.drawCircle(f19, f10, f11, (Paint)f20);
            object = subsamplingScaleImageView.debugPaint;
            object.setColor(n13);
            n15 = this.getWidth() / 2;
            f19 = n15;
            n24 = this.getHeight() / 2;
            f10 = n24;
            pointF = subsamplingScaleImageView.debugPaint;
            canvas2.drawCircle(f19, f10, f16, (Paint)pointF);
        }
        if ((object = subsamplingScaleImageView.vCenterStart) != null) {
            subsamplingScaleImageView.debugPaint.setColor(n25);
            object = subsamplingScaleImageView.vCenterStart;
            f17 = ((PointF)object).x;
            f19 = ((PointF)object).y;
            string9 = subsamplingScaleImageView.debugPaint;
            canvas2.drawCircle(f17, f19, f13, (Paint)string9);
        }
        if ((object = subsamplingScaleImageView.quickScaleSCenter) != null) {
            subsamplingScaleImageView.debugPaint.setColor((int)l10);
            object = subsamplingScaleImageView.quickScaleSCenter;
            f19 = ((PointF)object).x;
            f19 = subsamplingScaleImageView.sourceToViewX(f19);
            PointF pointF9 = subsamplingScaleImageView.quickScaleSCenter;
            f15 = pointF9.y;
            f15 = subsamplingScaleImageView.sourceToViewY(f15);
            paint = subsamplingScaleImageView.debugPaint;
            canvas2.drawCircle(f19, f15, f14, paint);
        }
        if ((object = subsamplingScaleImageView.quickScaleVStart) != null) {
            subsamplingScaleImageView.debugPaint.setColor(n13);
            object = subsamplingScaleImageView.quickScaleVStart;
            f12 = ((PointF)object).x;
            f19 = ((PointF)object).y;
            Paint paint12 = subsamplingScaleImageView.debugPaint;
            canvas2.drawCircle(f12, f19, f16, paint12);
        }
        subsamplingScaleImageView.debugPaint.setColor(-65281);
        object = subsamplingScaleImageView.debugPaint;
        n12 = 1065353216;
        f16 = 1.0f;
        object.setStrokeWidth(f16);
    }

    public void onImageLoaded() {
    }

    public void onMeasure(int n10, int n11) {
        int n12 = View.MeasureSpec.getMode((int)n10);
        int n13 = View.MeasureSpec.getMode((int)n11);
        n10 = View.MeasureSpec.getSize((int)n10);
        n11 = View.MeasureSpec.getSize((int)n11);
        int n14 = 1;
        int n15 = 0x40000000;
        n12 = n12 != n15 ? n14 : 0;
        if (n13 == n15) {
            n14 = 0;
        }
        n13 = this.sWidth;
        if (n13 > 0 && (n13 = this.sHeight) > 0) {
            if (n12 != 0 && n14 != 0) {
                n10 = this.sWidth();
                n11 = this.sHeight();
            } else if (n14 != 0) {
                double d10 = this.sHeight();
                double d11 = this.sWidth();
                d10 /= d11;
                d11 = n10;
                n11 = (int)(d10 *= d11);
            } else if (n12 != 0) {
                double d12 = this.sWidth();
                double d13 = this.sHeight();
                d12 /= d13;
                d13 = n11;
                n10 = (int)(d12 *= d13);
            }
        }
        n12 = this.getSuggestedMinimumWidth();
        n10 = Math.max(n10, n12);
        n12 = this.getSuggestedMinimumHeight();
        n11 = Math.max(n11, n12);
        this.setMeasuredDimension(n10, n11);
    }

    public void onReady() {
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        int n14 = 4;
        Object[] objectArray = new Object[n14];
        Integer n15 = n12;
        objectArray[0] = n15;
        n15 = n13;
        n13 = 1;
        objectArray[n13] = n15;
        Integer n16 = n10;
        n12 = 2;
        objectArray[n12] = n16;
        n16 = n11;
        float f10 = 4.2E-45f;
        objectArray[3] = n16;
        this.debug("onSizeChanged %dx%d -> %dx%d", objectArray);
        n16 = this.getCenter();
        n11 = (int)(this.readySent ? 1 : 0);
        if (n11 != 0 && n16 != null) {
            Float f11;
            n11 = 0;
            this.anim = null;
            f10 = this.scale;
            this.pendingScale = f11 = Float.valueOf(f10);
            this.sPendingCenter = n16;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        String string2;
        String string3;
        boolean bl3;
        Object object = this.anim;
        boolean bl4 = true;
        if (object != null && !(bl3 = SubsamplingScaleImageView$Anim.access$2700((SubsamplingScaleImageView$Anim)object))) {
            this.requestDisallowInterceptTouchEvent(bl4);
            return bl4;
        }
        object = this.anim;
        if (object != null && (object = SubsamplingScaleImageView$Anim.access$2800((SubsamplingScaleImageView$Anim)object)) != null) {
            object = this.anim;
            object = SubsamplingScaleImageView$Anim.access$2800((SubsamplingScaleImageView$Anim)object);
            try {
                object.onInterruptedByUser();
            }
            catch (Exception exception) {
                string3 = TAG;
                string2 = "Error thrown by animation listener";
                Log.w((String)string3, (String)string2, (Throwable)exception);
            }
        }
        bl3 = false;
        float f10 = 0.0f;
        this.anim = null;
        object = this.vTranslate;
        if (object == null) {
            return bl4;
        }
        bl3 = this.isQuickScaling;
        string3 = null;
        if (!bl3 && ((object = this.detector) == null || (bl3 = object.onTouchEvent(motionEvent)))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return bl4;
        }
        object = this.vTranslateStart;
        boolean bl5 = false;
        string2 = null;
        if (object == null) {
            object = new PointF(0.0f, 0.0f);
            this.vTranslateStart = object;
        }
        if ((object = this.vTranslateBefore) == null) {
            object = new PointF(0.0f, 0.0f);
            this.vTranslateBefore = object;
        }
        if ((object = this.vCenterStart) == null) {
            object = new PointF(0.0f, 0.0f);
            this.vCenterStart = object;
        }
        f10 = this.scale;
        string2 = this.vTranslateBefore;
        PointF pointF = this.vTranslate;
        string2.set(pointF);
        bl5 = this.onTouchEventInternal(motionEvent);
        pointF = this.vTranslateBefore;
        int n10 = 2;
        this.sendStateChanged(f10, pointF, n10);
        if (!bl5 && !(bl2 = super.onTouchEvent(motionEvent))) {
            bl4 = false;
        }
        return bl4;
    }

    public void recycle() {
        this.reset(true);
        this.bitmapPaint = null;
        this.debugPaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        Float f10;
        this.anim = null;
        PointF pointF = null;
        float f11 = this.limitedScale(0.0f);
        this.pendingScale = f10 = Float.valueOf(f11);
        int n10 = this.isReady();
        if (n10 != 0) {
            n10 = this.sWidth() / 2;
            f11 = n10;
            int n11 = this.sHeight() / 2;
            float f12 = n11;
            this.sPendingCenter = pointF = new PointF(f11, f12);
        } else {
            f10 = new PointF(0.0f, 0.0f);
            this.sPendingCenter = f10;
        }
        this.invalidate();
    }

    public final void setBitmapDecoderClass(Class serializable) {
        if (serializable != null) {
            CompatDecoderFactory compatDecoderFactory = new CompatDecoderFactory((Class)serializable);
            this.bitmapDecoderFactory = compatDecoderFactory;
            return;
        }
        serializable = new IllegalArgumentException("Decoder class cannot be set to null");
        throw serializable;
    }

    public final void setBitmapDecoderFactory(DecoderFactory object) {
        if (object != null) {
            this.bitmapDecoderFactory = object;
            return;
        }
        object = new IllegalArgumentException("Decoder factory cannot be set to null");
        throw object;
    }

    public final void setDebug(boolean bl2) {
        this.debug = bl2;
    }

    public final void setDoubleTapZoomDpi(int n10) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float f10 = displayMetrics.xdpi;
        float f11 = displayMetrics.ydpi;
        f10 = (f10 + f11) / 2.0f;
        float f12 = n10;
        this.setDoubleTapZoomScale(f10 /= f12);
    }

    public final void setDoubleTapZoomDuration(int n10) {
        this.doubleTapZoomDuration = n10 = Math.max(0, n10);
    }

    public final void setDoubleTapZoomScale(float f10) {
        this.doubleTapZoomScale = f10;
    }

    public final void setDoubleTapZoomStyle(int n10) {
        Object object = VALID_ZOOM_STYLES;
        Comparable<Integer> comparable = n10;
        boolean bl2 = object.contains(comparable);
        if (bl2) {
            this.doubleTapZoomStyle = n10;
            return;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Invalid zoom style: ");
        ((StringBuilder)comparable).append(n10);
        String string2 = ((StringBuilder)comparable).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final void setImage(ImageSource imageSource) {
        this.setImage(imageSource, null, null);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        this.setImage(imageSource, imageSource2, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void setImage(ImageSource object, ImageSource object2, ImageViewState object3) {
        boolean bl2;
        DecoderFactory decoderFactory;
        Context context;
        int n10;
        Object object4;
        String string2 = "imageSource must not be null";
        Objects.requireNonNull(object, string2);
        int n11 = 1;
        this.reset(n11 != 0);
        if (object3 != null) {
            this.restoreState((ImageViewState)object3);
        }
        object3 = "/";
        String string3 = "android.resource://";
        if (object2 != null) {
            object4 = ((ImageSource)object).getBitmap();
            if (object4 != null) {
                object = new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                throw object;
            }
            n10 = ((ImageSource)object).getSWidth();
            if (n10 > 0 && (n10 = ((ImageSource)object).getSHeight()) > 0) {
                this.sWidth = n10 = ((ImageSource)object).getSWidth();
                this.sHeight = n10 = ((ImageSource)object).getSHeight();
                object4 = ((ImageSource)object2).getSRegion();
                this.pRegion = object4;
                object4 = ((ImageSource)object2).getBitmap();
                if (object4 != null) {
                    n10 = (int)(((ImageSource)object2).isCached() ? 1 : 0);
                    this.bitmapIsCached = n10;
                    object2 = ((ImageSource)object2).getBitmap();
                    this.onPreviewLoaded((Bitmap)object2);
                } else {
                    Integer n12;
                    object4 = ((ImageSource)object2).getUri();
                    if (object4 == null && (n12 = ((ImageSource)object2).getResource()) != null) {
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append(string3);
                        String string4 = this.getContext().getPackageName();
                        ((StringBuilder)object4).append(string4);
                        ((StringBuilder)object4).append((String)object3);
                        object2 = ((ImageSource)object2).getResource();
                        ((StringBuilder)object4).append(object2);
                        object2 = ((StringBuilder)object4).toString();
                        object4 = Uri.parse((String)object2);
                    }
                    context = this.getContext();
                    decoderFactory = this.bitmapDecoderFactory;
                    boolean bl3 = true;
                    Object object5 = object2;
                    SubsamplingScaleImageView subsamplingScaleImageView = this;
                    object2 = new SubsamplingScaleImageView$BitmapLoadTask(this, context, decoderFactory, (Uri)object4, bl3);
                    this.execute((AsyncTask)object2);
                }
            } else {
                object = new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                throw object;
            }
        }
        object2 = ((ImageSource)object).getBitmap();
        n10 = 0;
        object4 = null;
        if (object2 != null && (object2 = ((ImageSource)object).getSRegion()) != null) {
            object2 = ((ImageSource)object).getBitmap();
            object3 = ((ImageSource)object).getSRegion();
            int n13 = ((Rect)object3).left;
            Rect rect = ((ImageSource)object).getSRegion();
            n11 = rect.top;
            Rect rect2 = ((ImageSource)object).getSRegion();
            int n14 = rect2.width();
            int n15 = ((ImageSource)object).getSRegion().height();
            object = Bitmap.createBitmap((Bitmap)object2, (int)n13, (int)n11, (int)n14, (int)n15);
            this.onImageLoaded((Bitmap)object, 0, false);
            return;
        }
        object2 = ((ImageSource)object).getBitmap();
        if (object2 != null) {
            object2 = ((ImageSource)object).getBitmap();
            boolean bl4 = ((ImageSource)object).isCached();
            this.onImageLoaded((Bitmap)object2, 0, bl4);
            return;
        }
        object2 = ((ImageSource)object).getSRegion();
        this.sRegion = object2;
        object2 = ((ImageSource)object).getUri();
        this.uri = object2;
        if (object2 == null && (object2 = ((ImageSource)object).getResource()) != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            String string5 = this.getContext().getPackageName();
            ((StringBuilder)object2).append(string5);
            ((StringBuilder)object2).append((String)object3);
            object3 = ((ImageSource)object).getResource();
            ((StringBuilder)object2).append(object3);
            object2 = Uri.parse((String)((StringBuilder)object2).toString());
            this.uri = object2;
        }
        if (!(bl2 = ((ImageSource)object).getTile()) && (object = this.sRegion) == null) {
            Context context2 = this.getContext();
            DecoderFactory decoderFactory2 = this.bitmapDecoderFactory;
            context = this.uri;
            decoderFactory = null;
            Object object6 = object;
            object4 = this;
            object = new SubsamplingScaleImageView$BitmapLoadTask(this, context2, decoderFactory2, (Uri)context, false);
            this.execute((AsyncTask)object);
            return;
        }
        object2 = this.getContext();
        object3 = this.regionDecoderFactory;
        Uri uri = this.uri;
        object = new SubsamplingScaleImageView$TilesInitTask(this, (Context)object2, (DecoderFactory)object3, uri);
        this.execute((AsyncTask)object);
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        this.setImage(imageSource, null, imageViewState);
    }

    public final void setMaxScale(float f10) {
        this.maxScale = f10;
    }

    public void setMaxTileSize(int n10) {
        this.maxTileWidth = n10;
        this.maxTileHeight = n10;
    }

    public void setMaxTileSize(int n10, int n11) {
        this.maxTileWidth = n10;
        this.maxTileHeight = n11;
    }

    public final void setMaximumDpi(int n10) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float f10 = displayMetrics.xdpi;
        float f11 = displayMetrics.ydpi;
        f10 = (f10 + f11) / 2.0f;
        float f12 = n10;
        this.setMinScale(f10 /= f12);
    }

    public final void setMinScale(float f10) {
        this.minScale = f10;
    }

    public final void setMinimumDpi(int n10) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float f10 = displayMetrics.xdpi;
        float f11 = displayMetrics.ydpi;
        f10 = (f10 + f11) / 2.0f;
        float f12 = n10;
        this.setMaxScale(f10 /= f12);
    }

    public final void setMinimumScaleType(int n10) {
        Object object = VALID_SCALE_TYPES;
        Comparable<Integer> comparable = n10;
        boolean bl2 = object.contains(comparable);
        if (bl2) {
            this.minimumScaleType = n10;
            n10 = (int)(this.isReady() ? 1 : 0);
            if (n10 != 0) {
                n10 = 1;
                this.fitToBounds(n10 != 0);
                this.invalidate();
            }
            return;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Invalid scale type: ");
        ((StringBuilder)comparable).append(n10);
        String string2 = ((StringBuilder)comparable).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void setMinimumTileDpi(int n10) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float f10 = displayMetrics.xdpi;
        float f11 = displayMetrics.ydpi;
        f10 += f11;
        f11 = 2.0f;
        float f12 = n10;
        f12 = Math.min(f10 /= f11, f12);
        this.minimumTileDpi = n10 = (int)f12;
        n10 = (int)(this.isReady() ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            f12 = 0.0f;
            this.reset(false);
            this.invalidate();
        }
    }

    public void setOnImageEventListener(SubsamplingScaleImageView$OnImageEventListener subsamplingScaleImageView$OnImageEventListener) {
        this.onImageEventListener = subsamplingScaleImageView$OnImageEventListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnStateChangedListener(SubsamplingScaleImageView$OnStateChangedListener subsamplingScaleImageView$OnStateChangedListener) {
        this.onStateChangedListener = subsamplingScaleImageView$OnStateChangedListener;
    }

    public final void setOrientation(int n10) {
        Object object = VALID_ORIENTATIONS;
        Comparable<Integer> comparable = n10;
        boolean bl2 = object.contains(comparable);
        if (bl2) {
            this.orientation = n10;
            this.reset(false);
            this.invalidate();
            this.requestLayout();
            return;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Invalid orientation: ");
        ((StringBuilder)comparable).append(n10);
        String string2 = ((StringBuilder)comparable).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final void setPanEnabled(boolean bl2) {
        PointF pointF;
        this.panEnabled = bl2;
        if (!bl2 && (pointF = this.vTranslate) != null) {
            float f10 = this.getWidth() / 2;
            float f11 = this.scale;
            float f12 = this.sWidth() / 2;
            pointF.x = f10 -= (f11 *= f12);
            pointF = this.vTranslate;
            int n10 = this.getHeight() / 2;
            f10 = n10;
            f11 = this.scale;
            int n11 = this.sHeight() / 2;
            f12 = n11;
            pointF.y = f10 -= (f11 *= f12);
            bl2 = this.isReady();
            if (bl2) {
                bl2 = true;
                this.refreshRequiredTiles(bl2);
                this.invalidate();
            }
        }
    }

    public final void setPanLimit(int n10) {
        Object object = VALID_PAN_LIMITS;
        Comparable<Integer> comparable = n10;
        boolean bl2 = object.contains(comparable);
        if (bl2) {
            this.panLimit = n10;
            n10 = (int)(this.isReady() ? 1 : 0);
            if (n10 != 0) {
                n10 = 1;
                this.fitToBounds(n10 != 0);
                this.invalidate();
            }
            return;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Invalid pan limit: ");
        ((StringBuilder)comparable).append(n10);
        String string2 = ((StringBuilder)comparable).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void setParallelLoadingEnabled(boolean bl2) {
        this.parallelLoadingEnabled = bl2;
    }

    public final void setQuickScaleEnabled(boolean bl2) {
        this.quickScaleEnabled = bl2;
    }

    public final void setRegionDecoderClass(Class serializable) {
        if (serializable != null) {
            CompatDecoderFactory compatDecoderFactory = new CompatDecoderFactory((Class)serializable);
            this.regionDecoderFactory = compatDecoderFactory;
            return;
        }
        serializable = new IllegalArgumentException("Decoder class cannot be set to null");
        throw serializable;
    }

    public final void setRegionDecoderFactory(DecoderFactory object) {
        if (object != null) {
            this.regionDecoderFactory = object;
            return;
        }
        object = new IllegalArgumentException("Decoder factory cannot be set to null");
        throw object;
    }

    public final void setScaleAndCenter(float f10, PointF pointF) {
        Float f11;
        this.anim = null;
        this.pendingScale = f11 = Float.valueOf(f10);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        this.invalidate();
    }

    public final void setTileBackgroundColor(int n10) {
        int n11 = Color.alpha((int)n10);
        if (n11 == 0) {
            n10 = 0;
            this.tileBgPaint = null;
        } else {
            Paint paint;
            this.tileBgPaint = paint = new Paint();
            Paint.Style style2 = Paint.Style.FILL;
            paint.setStyle(style2);
            paint = this.tileBgPaint;
            paint.setColor(n10);
        }
        this.invalidate();
    }

    public final void setZoomEnabled(boolean bl2) {
        this.zoomEnabled = bl2;
    }

    public final PointF sourceToViewCoord(float f10, float f11) {
        PointF pointF = new PointF();
        return this.sourceToViewCoord(f10, f11, pointF);
    }

    public final PointF sourceToViewCoord(float f10, float f11, PointF pointF) {
        PointF pointF2 = this.vTranslate;
        if (pointF2 == null) {
            return null;
        }
        f10 = this.sourceToViewX(f10);
        f11 = this.sourceToViewY(f11);
        pointF.set(f10, f11);
        return pointF;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        float f10 = pointF.x;
        float f11 = pointF.y;
        PointF pointF2 = new PointF();
        return this.sourceToViewCoord(f10, f11, pointF2);
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        float f10 = pointF.x;
        float f11 = pointF.y;
        return this.sourceToViewCoord(f10, f11, pointF2);
    }

    public final PointF viewToSourceCoord(float f10, float f11) {
        PointF pointF = new PointF();
        return this.viewToSourceCoord(f10, f11, pointF);
    }

    public final PointF viewToSourceCoord(float f10, float f11, PointF pointF) {
        PointF pointF2 = this.vTranslate;
        if (pointF2 == null) {
            return null;
        }
        f10 = this.viewToSourceX(f10);
        f11 = this.viewToSourceY(f11);
        pointF.set(f10, f11);
        return pointF;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        float f10 = pointF.x;
        float f11 = pointF.y;
        PointF pointF2 = new PointF();
        return this.viewToSourceCoord(f10, f11, pointF2);
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        float f10 = pointF.x;
        float f11 = pointF.y;
        return this.viewToSourceCoord(f10, f11, pointF2);
    }
}

