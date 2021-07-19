/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
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
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;
import androidx.print.PrintHelper$OnPrintFinishCallback;

public class PrintHelper$PrintBitmapAdapter
extends PrintDocumentAdapter {
    private PrintAttributes mAttributes;
    private final Bitmap mBitmap;
    private final PrintHelper$OnPrintFinishCallback mCallback;
    private final int mFittingMode;
    private final String mJobName;
    public final /* synthetic */ PrintHelper this$0;

    public PrintHelper$PrintBitmapAdapter(PrintHelper printHelper, String string2, int n10, Bitmap bitmap, PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
        this.this$0 = printHelper;
        this.mJobName = string2;
        this.mFittingMode = n10;
        this.mBitmap = bitmap;
        this.mCallback = printHelper$OnPrintFinishCallback;
    }

    public void onFinish() {
        PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback = this.mCallback;
        if (printHelper$OnPrintFinishCallback != null) {
            printHelper$OnPrintFinishCallback.onFinish();
        }
    }

    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle object) {
        this.mAttributes = printAttributes2;
        object = this.mJobName;
        cancellationSignal = new PrintDocumentInfo.Builder((String)object);
        int n10 = 1;
        cancellationSignal = cancellationSignal.setContentType(n10).setPageCount(n10).build();
        boolean bl2 = printAttributes2.equals((Object)printAttributes) ^ n10;
        layoutResultCallback.onLayoutFinished((PrintDocumentInfo)cancellationSignal, bl2);
    }

    public void onWrite(PageRange[] pageRangeArray, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        PrintHelper printHelper = this.this$0;
        PrintAttributes printAttributes = this.mAttributes;
        int n10 = this.mFittingMode;
        Bitmap bitmap = this.mBitmap;
        printHelper.writeBitmap(printAttributes, n10, bitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
    }
}

