/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  com.mob.tools.utils.BitmapHelper
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.gui.BitmapProcessor$BitmapCallback;
import com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Random;

public class AsyncImageView
extends ImageView
implements BitmapProcessor$BitmapCallback,
Handler.Callback {
    private static final int MSG_IMG_GOT = 1;
    private static final Random RND;
    private Bitmap defaultBm;
    private int defaultRes;
    private int desiredHeight;
    private int desiredWidth;
    private long diskCacheTime;
    private Bitmap errorBm = null;
    private int errorRes = 0;
    private boolean lastReqIsOk;
    private long maxBytes;
    private Path path;
    private int quality;
    private float[] rect;
    private WeakReference refAiv = null;
    private Bitmap result;
    private boolean scaleToCrop;
    private String url;
    private boolean useDiskCache;
    private boolean useRamCache;

    static {
        Random random;
        RND = random = new Random();
    }

    public AsyncImageView(Context context) {
        super(context);
        long l10;
        boolean bl2;
        this.useRamCache = bl2 = true;
        this.useDiskCache = bl2;
        this.diskCacheTime = l10 = 0L;
        this.desiredWidth = 0;
        this.desiredHeight = 0;
        this.maxBytes = l10;
        this.quality = 0;
        this.init(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        long l10;
        boolean bl2;
        this.useRamCache = bl2 = true;
        this.useDiskCache = bl2;
        this.diskCacheTime = l10 = 0L;
        this.desiredWidth = 0;
        this.desiredHeight = 0;
        this.maxBytes = l10;
        this.quality = 0;
        this.init(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        long l10;
        n10 = 1;
        this.useRamCache = n10;
        this.useDiskCache = n10;
        this.diskCacheTime = l10 = 0L;
        this.desiredWidth = 0;
        this.desiredHeight = 0;
        this.maxBytes = l10;
        this.quality = 0;
        this.init(context);
    }

    private BitmapProcessor$BitmapDesiredOptions getBitmapDesiredOptions() {
        BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions;
        long l10;
        long l11;
        long l12;
        int n10 = this.desiredWidth;
        int n11 = 1;
        if ((n10 <= n11 || (n10 = this.desiredHeight) <= n11) && (n10 = (int)((l12 = (l11 = this.maxBytes) - (l10 = 10240L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0 && (n10 = this.quality) <= 0) {
            n10 = 0;
            bitmapProcessor$BitmapDesiredOptions = null;
        } else {
            long l13;
            bitmapProcessor$BitmapDesiredOptions = new BitmapProcessor$BitmapDesiredOptions();
            bitmapProcessor$BitmapDesiredOptions.desiredWidth = n11 = this.desiredWidth;
            bitmapProcessor$BitmapDesiredOptions.desiredHeight = n11 = this.desiredHeight;
            bitmapProcessor$BitmapDesiredOptions.maxBytes = l13 = this.maxBytes;
            bitmapProcessor$BitmapDesiredOptions.quality = n11 = this.quality;
        }
        return bitmapProcessor$BitmapDesiredOptions;
    }

    private int[] getSize() {
        ViewGroup.LayoutParams layoutParams;
        int n10 = this.getWidth();
        int n11 = this.getHeight();
        if ((n10 == 0 || n11 == 0) && (layoutParams = this.getLayoutParams()) != null) {
            n10 = layoutParams.width;
            n11 = layoutParams.height;
        }
        layoutParams = null;
        if (n10 == 0 || n11 == 0) {
            this.measure(0, 0);
            n10 = this.getMeasuredWidth();
            n11 = this.getMeasuredHeight();
        }
        int[] nArray = new int[]{n10, n11};
        return nArray;
    }

    private Bitmap goCrop(Bitmap bitmap) {
        float f10;
        int n10 = bitmap.getWidth();
        float f11 = n10;
        int n11 = bitmap.getHeight();
        float f12 = n11;
        int n12 = 0;
        int[] nArray = null;
        float f13 = f11 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false && (n12 = (f10 = f12 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) != 0) {
            int n13;
            nArray = this.getSize();
            object = false;
            int n14 = nArray[0];
            if (n14 != 0 && (n13 = nArray[n14 = 1]) != 0) {
                n13 = nArray[n14];
                float f14 = (float)n13 * f11;
                float f15 = nArray[0];
                float f16 = (f14 /= f15) - f12;
                Object object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
                if (object2 == false) {
                    return bitmap;
                }
                object2 = 4;
                f15 = 5.6E-45f;
                int[] nArray2 = new int[object2];
                float f17 = f14 == f12 ? 0 : (f14 < f12 ? -1 : 1);
                int n15 = 3;
                int n16 = 2;
                float f18 = 2.0f;
                if (f17 < 0) {
                    f12 = (f12 - f14) / f18;
                    nArray2[n14] = n10 = (int)f12;
                    nArray2[n15] = n10 = nArray2[n14];
                } else {
                    n13 = nArray[0];
                    f14 = (float)n13 * f12;
                    n11 = nArray[n14];
                    f12 = n11;
                    f11 = (f11 - (f14 /= f12)) / f18;
                    nArray2[0] = n10 = (int)f11;
                    nArray2[n16] = n10 = nArray2[0];
                }
                n10 = nArray2[0];
                n11 = nArray2[n14];
                n12 = nArray2[n16];
                object = nArray2[n15];
                try {
                    bitmap = BitmapHelper.cropBitmap((Bitmap)bitmap, (int)n10, (int)n11, (int)n12, (int)object);
                }
                catch (Throwable throwable) {
                    NLog nLog = MobLog.getInstance();
                    nLog.w(throwable);
                }
            }
        }
        return bitmap;
    }

    private void init(Context context) {
        boolean bl2 = this.isInEditMode();
        if (bl2) {
            this.setBackgroundColor(-16777216);
            return;
        }
        BitmapProcessor.prepare(context);
    }

    private void myClip(Canvas canvas) {
        Object object = this.rect;
        if (object != null) {
            object = this.path;
            if (object == null) {
                Path path;
                int n10 = this.getWidth();
                int n11 = this.getHeight();
                this.path = path = new Path();
                float f10 = n10;
                float f11 = n11;
                path = new RectF(0.0f, 0.0f, f10, f11);
                object = this.path;
                float[] fArray = this.rect;
                Path.Direction direction = Path.Direction.CW;
                object.addRoundRect((RectF)path, fArray, direction);
            }
            object = this.path;
            canvas.clipPath((Path)object);
        }
    }

    public void deleteCachedFile(String string2) {
        BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions = this.getBitmapDesiredOptions();
        BitmapProcessor.deleteCachedFile(string2, bitmapProcessor$BitmapDesiredOptions);
    }

    public void execute(String string2, int n10) {
        this.execute(string2, n10, 0);
    }

    public void execute(String string2, int n10, int n11) {
        WeakReference weakReference;
        Bitmap bitmap;
        String string3;
        boolean bl2 = this.useRamCache;
        if ((bl2 || (bl2 = this.useDiskCache)) && (bl2 = this.lastReqIsOk) && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && (bl2 = string2.equals(string3 = this.url))) {
            return;
        }
        this.lastReqIsOk = false;
        this.url = string2;
        string3 = null;
        this.result = null;
        this.defaultRes = n10;
        this.errorRes = n11;
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            if (n11 != 0) {
                n10 = n11;
            }
            this.setImageResource(n10);
            return;
        }
        BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions = this.getBitmapDesiredOptions();
        n11 = (int)(this.useRamCache ? 1 : 0);
        if (n11 != 0 && (bitmap = BitmapProcessor.getBitmapFromCache(string2, bitmapProcessor$BitmapDesiredOptions)) != null && !(bl2 = bitmap.isRecycled())) {
            this.setBitmap(bitmap);
            this.lastReqIsOk = true;
            return;
        }
        if (n10 > 0) {
            this.setImageResource(n10);
        }
        if ((weakReference = this.refAiv) == null || (weakReference = weakReference.get()) == null) {
            this.refAiv = weakReference = new WeakReference(this);
        }
        boolean bl3 = this.useRamCache;
        boolean bl4 = this.useDiskCache;
        long l10 = this.diskCacheTime;
        string3 = string2;
        BitmapProcessor.process(string2, bitmapProcessor$BitmapDesiredOptions, bl3, bl4, l10, this);
    }

    public void execute(String string2, Bitmap bitmap) {
        this.execute(string2, bitmap, null);
    }

    public void execute(String string2, Bitmap object, Bitmap bitmap) {
        String string3;
        boolean bl2 = this.useRamCache;
        if ((bl2 || (bl2 = this.useDiskCache)) && (bl2 = this.lastReqIsOk) && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && (bl2 = string2.equals(string3 = this.url))) {
            return;
        }
        this.lastReqIsOk = false;
        this.url = string2;
        string3 = null;
        this.result = null;
        this.defaultBm = object;
        this.errorBm = bitmap;
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            if (bitmap != null) {
                object = bitmap;
            }
            this.setImageBitmap((Bitmap)object);
            return;
        }
        BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions = this.getBitmapDesiredOptions();
        boolean bl3 = this.useRamCache;
        if (bl3 && (bitmap = BitmapProcessor.getBitmapFromCache(string2, bitmapProcessor$BitmapDesiredOptions)) != null && !(bl2 = bitmap.isRecycled())) {
            this.setBitmap(bitmap);
            this.lastReqIsOk = true;
            return;
        }
        if (object != null && !(bl3 = object.isRecycled())) {
            this.setImageBitmap((Bitmap)object);
        }
        if ((object = this.refAiv) == null || (object = object.get()) == null) {
            object = new WeakReference(this);
            this.refAiv = object;
        }
        boolean bl4 = this.useRamCache;
        boolean bl5 = this.useDiskCache;
        long l10 = this.diskCacheTime;
        string3 = string2;
        BitmapProcessor.process(string2, bitmapProcessor$BitmapDesiredOptions, bl4, bl5, l10, this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 != n11) return false;
        Object object2 = this.refAiv;
        if (object2 == null) return false;
        if ((object2 = ((Reference)object2).get()) == null) {
            return false;
        }
        try {
            String string2;
            Object object3;
            object2 = object3 = object.obj;
            object2 = (Object[])object3;
            object2 = object2[0];
            Object[] objectArray = (Object[])object3;
            Object object4 = objectArray[n11];
            if (object4 != null && object2 != null && (n10 = (int)(object2.equals(string2 = this.url) ? 1 : 0)) != 0) {
                Bitmap bitmap;
                this.result = bitmap = (Bitmap)object4;
                WeakReference weakReference = this.refAiv;
                Object t10 = weakReference.get();
                AsyncImageView asyncImageView = (AsyncImageView)t10;
                object2 = this.result;
                asyncImageView.setImageBitmap((Bitmap)object2);
                this.lastReqIsOk = n11;
                return false;
            }
            int n12 = this.errorRes;
            if (n12 > 0) {
                WeakReference weakReference = this.refAiv;
                Object t11 = weakReference.get();
                AsyncImageView asyncImageView = (AsyncImageView)t11;
                n10 = this.errorRes;
                asyncImageView.setImageResource(n10);
                return false;
            }
            Bitmap bitmap = this.errorBm;
            if (bitmap != null && (n12 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                WeakReference weakReference = this.refAiv;
                Object t12 = weakReference.get();
                AsyncImageView asyncImageView = (AsyncImageView)t12;
                object2 = this.errorBm;
                asyncImageView.setImageBitmap((Bitmap)object2);
                return false;
            }
            Bitmap bitmap2 = this.defaultBm;
            if (bitmap2 != null && (n12 = (int)(bitmap2.isRecycled() ? 1 : 0)) == 0) {
                WeakReference weakReference = this.refAiv;
                Object t13 = weakReference.get();
                AsyncImageView asyncImageView = (AsyncImageView)t13;
                object2 = this.defaultBm;
                asyncImageView.setImageBitmap((Bitmap)object2);
                return false;
            }
            WeakReference weakReference = this.refAiv;
            Object t14 = weakReference.get();
            AsyncImageView asyncImageView = (AsyncImageView)t14;
            n10 = this.defaultRes;
            asyncImageView.setImageResource(n10);
            return false;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
        return false;
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        drawable2 = this.getDrawable();
        int n10 = drawable2.getIntrinsicWidth();
        if (n10 != 0 && (n10 = (drawable2 = this.getDrawable()).getIntrinsicHeight()) != 0) {
            drawable2 = this.getImageMatrix();
            int n11 = this.getPaddingLeft();
            int n12 = this.getPaddingTop();
            int n13 = canvas.getSaveCount();
            canvas.save();
            Bitmap bitmap = this.result;
            if (bitmap != null) {
                this.myClip(canvas);
                Bitmap bitmap2 = this.result;
                int n14 = 6;
                Paint paint = new Paint(n14);
                canvas.drawBitmap(bitmap2, (Matrix)drawable2, paint);
            } else {
                if (drawable2 != null || n11 != 0 || n12 != 0) {
                    int n15 = Build.VERSION.SDK_INT;
                    int n16 = 16;
                    if (n15 >= n16 && (n15 = (int)(this.getCropToPadding() ? 1 : 0)) != 0) {
                        n15 = this.getScrollX();
                        n16 = this.getScrollY();
                        int n17 = n15 + n11;
                        int n18 = n16 + n12;
                        int n19 = this.getRight();
                        n15 += n19;
                        n19 = this.getLeft();
                        n15 -= n19;
                        n19 = this.getPaddingRight();
                        n15 -= n19;
                        n19 = this.getBottom();
                        n16 += n19;
                        n19 = this.getTop();
                        n16 -= n19;
                        n19 = this.getPaddingBottom();
                        canvas.clipRect(n17, n18, n15, n16 -= n19);
                    }
                    float f10 = n11;
                    float f11 = n12;
                    canvas.translate(f10, f11);
                    if (drawable2 != null) {
                        canvas.concat((Matrix)drawable2);
                    }
                }
                drawable2 = this.getDrawable();
                drawable2.draw(canvas);
            }
            canvas.restoreToCount(n13);
        }
    }

    public void onImageGot(String object, Bitmap bitmap) {
        WeakReference weakReference = this.refAiv;
        if (weakReference != null && (weakReference = weakReference.get()) != null) {
            int n10;
            String string2;
            int n11;
            boolean bl2 = false;
            weakReference = null;
            if (object == null || (n11 = (string2 = ((String)object).trim()).length()) <= 0 || (n11 = (int)(((String)object).equals(string2 = this.url) ? 1 : 0)) == 0) {
                n10 = 0;
                bitmap = null;
            }
            if (bitmap != null && (bl2 = this.scaleToCrop)) {
                bitmap = this.goCrop(bitmap);
            }
            weakReference = new Message();
            ((Message)weakReference).what = n11 = 1;
            int n12 = 2;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object;
            objectArray[n11] = bitmap;
            ((Message)weakReference).obj = objectArray;
            object = RND;
            n10 = 300;
            int n13 = ((Random)object).nextInt(n10);
            long l10 = n13;
            UIHandler.sendMessageDelayed((Message)weakReference, l10, this);
        }
    }

    public void removeRamCache(String string2) {
        boolean bl2 = this.useRamCache;
        if (bl2) {
            BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions = this.getBitmapDesiredOptions();
            BitmapProcessor.removeBitmapFromRamCache(string2, bitmapProcessor$BitmapDesiredOptions);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        boolean bl2 = this.scaleToCrop;
        if (bl2) {
            bitmap = this.goCrop(bitmap);
        }
        this.setImageBitmap(bitmap);
        this.result = bitmap;
    }

    public void setCompressOptions(int n10, int n11, int n12, long l10) {
        this.desiredWidth = n10;
        this.desiredHeight = n11;
        this.quality = n12;
        this.maxBytes = l10;
    }

    public void setPadding(int n10, int n11, int n12, int n13) {
        NLog nLog = MobLog.getInstance();
        RuntimeException runtimeException = new RuntimeException("Not Support");
        nLog.w(runtimeException);
    }

    public void setRound(float f10) {
        this.setRound(f10, f10, f10, f10);
    }

    public void setRound(float f10, float f11, float f12, float f13) {
        float[] fArray = new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
        this.rect = fArray;
    }

    public void setScaleToCropCenter(boolean bl2) {
        this.scaleToCrop = bl2;
    }

    public void setUseCacheOption(boolean bl2, boolean bl3) {
        this.setUseCacheOption(bl2, bl3, 0L);
    }

    public void setUseCacheOption(boolean bl2, boolean bl3, long l10) {
        this.useRamCache = bl2;
        this.useDiskCache = bl3;
        if (bl3) {
            this.diskCacheTime = l10;
        }
    }
}

