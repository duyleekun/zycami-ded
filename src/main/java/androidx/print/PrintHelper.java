/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.ParcelFileDescriptor
 *  android.print.PrintAttributes
 *  android.print.PrintAttributes$Builder
 *  android.print.PrintAttributes$Margins
 *  android.print.PrintAttributes$MediaSize
 *  android.print.PrintAttributes$Resolution
 *  android.print.PrintDocumentAdapter
 *  android.print.PrintDocumentAdapter$WriteResultCallback
 *  android.print.PrintManager
 *  android.util.Log
 */
package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.util.Log;
import androidx.print.PrintHelper$1;
import androidx.print.PrintHelper$OnPrintFinishCallback;
import androidx.print.PrintHelper$PrintBitmapAdapter;
import androidx.print.PrintHelper$PrintUriAdapter;
import java.io.IOException;
import java.io.InputStream;

public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final boolean IS_MIN_MARGINS_HANDLING_CORRECT = false;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = false;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    public int mColorMode;
    public final Context mContext;
    public BitmapFactory.Options mDecodeOptions = null;
    public final Object mLock;
    public int mOrientation;
    public int mScaleMode;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 0;
        int n12 = 23;
        int n13 = 1;
        int n14 = 20;
        n14 = n10 >= n14 && n10 <= n12 ? 0 : n13;
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = n14;
        if (n10 != n12) {
            n11 = n13;
        }
        IS_MIN_MARGINS_HANDLING_CORRECT = n11;
    }

    public PrintHelper(Context context) {
        int n10;
        Object object;
        this.mLock = object = new Object();
        this.mScaleMode = n10 = 2;
        this.mColorMode = n10;
        this.mOrientation = 1;
        this.mContext = context;
    }

    public static Bitmap convertBitmapForColorMode(Bitmap bitmap, int n10) {
        int n11 = 1;
        if (n10 != n11) {
            return bitmap;
        }
        n10 = bitmap.getWidth();
        n11 = bitmap.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
        Canvas canvas = new Canvas(bitmap2);
        config = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        config.setColorFilter((ColorFilter)colorMatrixColorFilter);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint)config);
        canvas.setBitmap(null);
        return bitmap2;
    }

    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        int n10;
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        PrintAttributes.MediaSize mediaSize = printAttributes.getMediaSize();
        builder = builder.setMediaSize(mediaSize);
        mediaSize = printAttributes.getResolution();
        builder = builder.setResolution((PrintAttributes.Resolution)mediaSize);
        mediaSize = printAttributes.getMinMargins();
        builder = builder.setMinMargins((PrintAttributes.Margins)mediaSize);
        int n11 = printAttributes.getColorMode();
        if (n11 != 0) {
            n11 = printAttributes.getColorMode();
            builder.setColorMode(n11);
        }
        if ((n11 = Build.VERSION.SDK_INT) >= (n10 = 23) && (n11 = printAttributes.getDuplexMode()) != 0) {
            int n12 = printAttributes.getDuplexMode();
            builder.setDuplexMode(n12);
        }
        return builder;
    }

    public static Matrix getMatrix(int n10, int n11, RectF rectF, int n12) {
        float f10;
        Matrix matrix = new Matrix();
        float f11 = rectF.width();
        float f12 = n10;
        f11 /= f12;
        int n13 = 2;
        float f13 = 2.8E-45f;
        if (n12 == n13) {
            f10 = rectF.height();
            f13 = n11;
            f10 /= f13;
            f10 = Math.max(f11, f10);
        } else {
            f10 = rectF.height();
            f13 = n11;
            f10 /= f13;
            f10 = Math.min(f11, f10);
        }
        matrix.postScale(f10, f10);
        f11 = rectF.width();
        f11 -= (f12 *= f10);
        f12 = 2.0f;
        float f14 = rectF.height();
        float f15 = (float)n11 * f10;
        f14 = (f14 - f15) / f12;
        matrix.postTranslate(f11 /= f12, f14);
        return matrix;
    }

    public static boolean isPortrait(Bitmap bitmap) {
        int n10;
        int n11 = bitmap.getWidth();
        if (n11 <= (n10 = bitmap.getHeight())) {
            n10 = 1;
        } else {
            n10 = 0;
            bitmap = null;
        }
        return n10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Bitmap loadBitmap(Uri object, BitmapFactory.Options options) {
        Context context;
        String string3 = "close fail ";
        String string2 = LOG_TAG;
        if (object != null && (context = this.mContext) != null) {
            void var2_7;
            Object inputStream;
            block9: {
                inputStream = null;
                try {
                    context = context.getContentResolver();
                    object = context.openInputStream((Uri)object);
                }
                catch (Throwable throwable) {
                    // empty catch block
                    break block9;
                }
                try {
                    options = BitmapFactory.decodeStream((InputStream)object, null, (BitmapFactory.Options)options);
                    if (object == null) return options;
                }
                catch (Throwable throwable) {
                    inputStream = object;
                    break block9;
                }
                try {
                    ((InputStream)object).close();
                    return options;
                }
                catch (IOException iOException) {
                    Log.w((String)string2, (String)string3, (Throwable)iOException);
                }
                return options;
            }
            if (inputStream == null) throw var2_7;
            try {
                ((InputStream)inputStream).close();
                throw var2_7;
            }
            catch (IOException iOException) {
                Log.w((String)string2, (String)string3, (Throwable)iOException);
            }
            throw var2_7;
        }
        object = new IllegalArgumentException("bad argument to loadBitmap");
        throw object;
    }

    public static boolean systemSupportsPrint() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (n10 = this.mOrientation) == 0) {
            return 1;
        }
        return this.mOrientation;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap loadConstrainedBitmap(Uri object) {
        Object object2;
        if (object != null && (object2 = this.mContext) != null) {
            BitmapFactory.Options options;
            int n10;
            int n11;
            object2 = new BitmapFactory.Options();
            object2.inJustDecodeBounds = n11 = 1;
            this.loadBitmap((Uri)object, (BitmapFactory.Options)object2);
            int n12 = object2.outWidth;
            int n13 = object2.outHeight;
            if (n12 <= 0) return null;
            if (n13 <= 0) {
                return null;
            }
            int n14 = n11;
            for (int i10 = Math.max(n12, n13); i10 > (n10 = 3500); i10 >>>= 1, n14 <<= 1) {
            }
            if (n14 <= 0) return null;
            if ((n13 = Math.min(n12, n13) / n14) <= 0) {
                return null;
            }
            object2 = this.mLock;
            synchronized (object2) {
                this.mDecodeOptions = options = new BitmapFactory.Options();
                options.inMutable = n11;
                options.inSampleSize = n14;
            }
            try {
                object = this.loadBitmap((Uri)object, options);
                return object;
            }
            finally {
                object2 = this.mLock;
                synchronized (object2) {
                    this.mDecodeOptions = null;
                }
            }
        }
        object = new IllegalArgumentException("bad argument to getScaledBitmap");
        throw object;
    }

    public void printBitmap(String string2, Bitmap bitmap) {
        this.printBitmap(string2, bitmap, null);
    }

    public void printBitmap(String string2, Bitmap bitmap, PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && bitmap != null) {
            PrintHelper$PrintBitmapAdapter printHelper$PrintBitmapAdapter;
            Context context = this.mContext;
            String string3 = "print";
            context = (PrintManager)context.getSystemService(string3);
            n11 = (int)(PrintHelper.isPortrait(bitmap) ? 1 : 0);
            string3 = n11 != 0 ? PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            Object object = new PrintAttributes.Builder();
            string3 = object.setMediaSize((PrintAttributes.MediaSize)string3);
            int n12 = this.mColorMode;
            string3 = string3.setColorMode(n12).build();
            int n13 = this.mScaleMode;
            object = printHelper$PrintBitmapAdapter;
            printHelper$PrintBitmapAdapter = new PrintHelper$PrintBitmapAdapter(this, string2, n13, bitmap, printHelper$OnPrintFinishCallback);
            context.print(string2, (PrintDocumentAdapter)printHelper$PrintBitmapAdapter, (PrintAttributes)string3);
        }
    }

    public void printBitmap(String string2, Uri uri) {
        this.printBitmap(string2, uri, null);
    }

    public void printBitmap(String string2, Uri uri, PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 < n11) {
            return;
        }
        int n12 = this.mScaleMode;
        PrintHelper$PrintUriAdapter printHelper$PrintUriAdapter = new PrintHelper$PrintUriAdapter(this, string2, uri, printHelper$OnPrintFinishCallback, n12);
        uri = (PrintManager)this.mContext.getSystemService("print");
        printHelper$OnPrintFinishCallback = new PrintAttributes.Builder();
        n11 = this.mColorMode;
        printHelper$OnPrintFinishCallback.setColorMode(n11);
        n11 = this.mOrientation;
        int n13 = 1;
        if (n11 != n13 && n11 != 0) {
            n13 = 2;
            if (n11 == n13) {
                PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
                printHelper$OnPrintFinishCallback.setMediaSize(mediaSize);
            }
        } else {
            PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            printHelper$OnPrintFinishCallback.setMediaSize(mediaSize);
        }
        printHelper$OnPrintFinishCallback = printHelper$OnPrintFinishCallback.build();
        uri.print(string2, (PrintDocumentAdapter)printHelper$PrintUriAdapter, (PrintAttributes)printHelper$OnPrintFinishCallback);
    }

    public void setColorMode(int n10) {
        this.mColorMode = n10;
    }

    public void setOrientation(int n10) {
        this.mOrientation = n10;
    }

    public void setScaleMode(int n10) {
        this.mScaleMode = n10;
    }

    public void writeBitmap(PrintAttributes printAttributes, int n10, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        PrintAttributes.Margins margins;
        Object object;
        PrintAttributes printAttributes2;
        boolean bl2 = IS_MIN_MARGINS_HANDLING_CORRECT;
        Object[] objectArray = null;
        if (bl2) {
            printAttributes2 = printAttributes;
        } else {
            object = PrintHelper.copyAttributes(printAttributes);
            margins = new PrintAttributes.Margins(0, 0, 0, 0);
            object = object.setMinMargins(margins).build();
            printAttributes2 = object;
        }
        margins = object;
        object = new PrintHelper$1(this, cancellationSignal, printAttributes2, bitmap, printAttributes, n10, parcelFileDescriptor, writeResultCallback);
        objectArray = new Void[]{};
        object.execute(objectArray);
    }
}

