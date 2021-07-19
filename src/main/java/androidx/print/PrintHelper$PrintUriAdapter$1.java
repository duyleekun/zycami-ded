/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.CancellationSignal
 *  android.os.CancellationSignal$OnCancelListener
 *  android.print.PrintAttributes
 *  android.print.PrintDocumentAdapter$LayoutResultCallback
 *  android.print.PrintDocumentInfo
 *  android.print.PrintDocumentInfo$Builder
 */
package androidx.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;
import androidx.print.PrintHelper$PrintUriAdapter;
import androidx.print.PrintHelper$PrintUriAdapter$1$1;
import java.io.FileNotFoundException;

public class PrintHelper$PrintUriAdapter$1
extends AsyncTask {
    public final /* synthetic */ PrintHelper$PrintUriAdapter this$1;
    public final /* synthetic */ CancellationSignal val$cancellationSignal;
    public final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback val$layoutResultCallback;
    public final /* synthetic */ PrintAttributes val$newPrintAttributes;
    public final /* synthetic */ PrintAttributes val$oldPrintAttributes;

    public PrintHelper$PrintUriAdapter$1(PrintHelper$PrintUriAdapter printHelper$PrintUriAdapter, CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
        this.this$1 = printHelper$PrintUriAdapter;
        this.val$cancellationSignal = cancellationSignal;
        this.val$newPrintAttributes = printAttributes;
        this.val$oldPrintAttributes = printAttributes2;
        this.val$layoutResultCallback = layoutResultCallback;
    }

    public Bitmap doInBackground(Uri ... uri) {
        try {
            uri = this.this$1;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        PrintHelper printHelper = uri.this$0;
        uri = uri.mImageFile;
        return printHelper.loadConstrainedBitmap(uri);
    }

    public void onCancelled(Bitmap bitmap) {
        this.val$layoutResultCallback.onLayoutCancelled();
        this.this$1.mLoadBitmap = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onPostExecute(Bitmap bitmap) {
        PrintAttributes printAttributes;
        PrintAttributes printAttributes2;
        float f10;
        int n10;
        Object object;
        int n11;
        block9: {
            block10: {
                super.onPostExecute((Object)bitmap);
                if (bitmap == null) break block9;
                n11 = PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION;
                if (!n11) break block10;
                object = this.this$1.this$0;
                n11 = object.mOrientation;
                if (n11) break block9;
            }
            // MONITORENTER : this
            object = this.this$1;
            object = ((PrintHelper$PrintUriAdapter)object).mAttributes;
            object = object.getMediaSize();
            // MONITOREXIT : this
            if (object != null && (n11 = (int)(object.isPortrait() ? 1 : 0)) != (n10 = PrintHelper.isPortrait(bitmap))) {
                Matrix matrix = new Matrix();
                n11 = 1119092736;
                f10 = 90.0f;
                matrix.postRotate(f10);
                printAttributes2 = null;
                int n12 = bitmap.getWidth();
                int n13 = bitmap.getHeight();
                boolean bl2 = true;
                printAttributes = bitmap;
                bitmap = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n12, (int)n13, (Matrix)matrix, (boolean)bl2);
            }
        }
        this.this$1.mBitmap = bitmap;
        n11 = 0;
        f10 = 0.0f;
        object = null;
        if (bitmap != null) {
            String string2 = this.this$1.mJobName;
            bitmap = new PrintDocumentInfo.Builder(string2);
            n10 = 1;
            bitmap = bitmap.setContentType(n10).setPageCount(n10).build();
            printAttributes = this.val$newPrintAttributes;
            printAttributes2 = this.val$oldPrintAttributes;
            int n14 = printAttributes.equals((Object)printAttributes2);
            printAttributes = this.val$layoutResultCallback;
            printAttributes.onLayoutFinished((PrintDocumentInfo)bitmap, (n10 ^= n14) != 0);
        } else {
            bitmap = this.val$layoutResultCallback;
            bitmap.onLayoutFailed(null);
        }
        this.this$1.mLoadBitmap = null;
    }

    public void onPreExecute() {
        CancellationSignal cancellationSignal = this.val$cancellationSignal;
        PrintHelper$PrintUriAdapter$1$1 printHelper$PrintUriAdapter$1$1 = new PrintHelper$PrintUriAdapter$1$1(this);
        cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener)printHelper$PrintUriAdapter$1$1);
    }
}

