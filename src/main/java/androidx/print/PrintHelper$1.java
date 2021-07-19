/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.AsyncTask
 *  android.os.CancellationSignal
 *  android.os.ParcelFileDescriptor
 *  android.print.PageRange
 *  android.print.PrintAttributes
 *  android.print.PrintDocumentAdapter$WriteResultCallback
 *  android.util.Log
 */
package androidx.print;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.util.Log;
import androidx.print.PrintHelper;

public class PrintHelper$1
extends AsyncTask {
    public final /* synthetic */ PrintHelper this$0;
    public final /* synthetic */ PrintAttributes val$attributes;
    public final /* synthetic */ Bitmap val$bitmap;
    public final /* synthetic */ CancellationSignal val$cancellationSignal;
    public final /* synthetic */ ParcelFileDescriptor val$fileDescriptor;
    public final /* synthetic */ int val$fittingMode;
    public final /* synthetic */ PrintAttributes val$pdfAttributes;
    public final /* synthetic */ PrintDocumentAdapter.WriteResultCallback val$writeResultCallback;

    public PrintHelper$1(PrintHelper printHelper, CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int n10, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.this$0 = printHelper;
        this.val$cancellationSignal = cancellationSignal;
        this.val$pdfAttributes = printAttributes;
        this.val$bitmap = bitmap;
        this.val$attributes = printAttributes2;
        this.val$fittingMode = n10;
        this.val$fileDescriptor = parcelFileDescriptor;
        this.val$writeResultCallback = writeResultCallback;
    }

    /*
     * Exception decompiling
     */
    public Throwable doInBackground(Void ... var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [40[TRYBLOCK]], but top level block is 61[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void onPostExecute(Throwable throwable) {
        PageRange[] pageRangeArray = this.val$cancellationSignal;
        int n10 = (int)(pageRangeArray.isCanceled() ? 1 : 0);
        if (n10 != 0) {
            throwable = this.val$writeResultCallback;
            throwable.onWriteCancelled();
        } else if (throwable == null) {
            PageRange pageRange;
            throwable = this.val$writeResultCallback;
            n10 = 1;
            pageRangeArray = new PageRange[n10];
            Object var4_4 = null;
            pageRangeArray[0] = pageRange = PageRange.ALL_PAGES;
            throwable.onWriteFinished(pageRangeArray);
        } else {
            String string2 = "Error writing printed content";
            Log.e((String)"PrintHelper", (String)string2, (Throwable)throwable);
            throwable = this.val$writeResultCallback;
            n10 = 0;
            pageRangeArray = null;
            throwable.onWriteFailed(null);
        }
    }
}

