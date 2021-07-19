/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.CancellationSignal
 *  android.os.ParcelFileDescriptor
 *  android.print.PageRange
 *  android.print.PrintAttributes
 *  android.print.PrintDocumentAdapter
 *  android.print.PrintDocumentAdapter$LayoutResultCallback
 *  android.print.PrintDocumentAdapter$WriteResultCallback
 *  android.print.PrintDocumentInfo
 *  android.print.PrintDocumentInfo$Builder
 */
package androidx.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;
import androidx.print.PrintHelper$OnPrintFinishCallback;
import androidx.print.PrintHelper$PrintUriAdapter$1;

public class PrintHelper$PrintUriAdapter
extends PrintDocumentAdapter {
    public PrintAttributes mAttributes;
    public Bitmap mBitmap;
    public final PrintHelper$OnPrintFinishCallback mCallback;
    public final int mFittingMode;
    public final Uri mImageFile;
    public final String mJobName;
    public AsyncTask mLoadBitmap;
    public final /* synthetic */ PrintHelper this$0;

    public PrintHelper$PrintUriAdapter(PrintHelper printHelper, String string2, Uri uri, PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback, int n10) {
        this.this$0 = printHelper;
        this.mJobName = string2;
        this.mImageFile = uri;
        this.mCallback = printHelper$OnPrintFinishCallback;
        this.mFittingMode = n10;
        this.mBitmap = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cancelLoad() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            PrintHelper printHelper = this.this$0;
            printHelper = printHelper.mDecodeOptions;
            if (printHelper != null) {
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 24;
                if (n10 < n11) {
                    printHelper.requestCancelDecode();
                }
                printHelper = this.this$0;
                n10 = 0;
                printHelper.mDecodeOptions = null;
            }
            return;
        }
    }

    public void onFinish() {
        super.onFinish();
        this.cancelLoad();
        Object object = this.mLoadBitmap;
        if (object != null) {
            boolean bl2 = true;
            object.cancel(bl2);
        }
        if ((object = this.mCallback) != null) {
            object.onFinish();
        }
        if ((object = this.mBitmap) != null) {
            object.recycle();
            object = null;
            this.mBitmap = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onLayout(PrintAttributes uriArray, PrintAttributes printAttributes, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle object) {
        synchronized (this) {
            this.mAttributes = printAttributes;
        }
        int n10 = cancellationSignal.isCanceled();
        if (n10 != 0) {
            layoutResultCallback.onLayoutCancelled();
            return;
        }
        object = this.mBitmap;
        if (object != null) {
            object = this.mJobName;
            cancellationSignal = new PrintDocumentInfo.Builder((String)object);
            n10 = 1;
            cancellationSignal = cancellationSignal.setContentType(n10).setPageCount(n10).build();
            boolean bl2 = printAttributes.equals((Object)uriArray) ^ n10;
            layoutResultCallback.onLayoutFinished((PrintDocumentInfo)cancellationSignal, bl2);
            return;
        }
        object = new PrintHelper$PrintUriAdapter$1(this, cancellationSignal, printAttributes, (PrintAttributes)uriArray, layoutResultCallback);
        uriArray = new Uri[]{};
        this.mLoadBitmap = uriArray = object.execute((Object[])uriArray);
    }

    public void onWrite(PageRange[] pageRangeArray, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        PrintHelper printHelper = this.this$0;
        PrintAttributes printAttributes = this.mAttributes;
        int n10 = this.mFittingMode;
        Bitmap bitmap = this.mBitmap;
        printHelper.writeBitmap(printAttributes, n10, bitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
    }
}

