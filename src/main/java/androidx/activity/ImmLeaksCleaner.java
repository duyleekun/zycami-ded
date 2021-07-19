/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.inputmethod.InputMethodManager
 */
package androidx.activity;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

public final class ImmLeaksCleaner
implements LifecycleEventObserver {
    private static final int INIT_FAILED = 2;
    private static final int INIT_SUCCESS = 1;
    private static final int NOT_INITIALIAZED;
    private static Field sHField;
    private static Field sNextServedViewField;
    private static int sReflectedFieldsInitialized;
    private static Field sServedViewField;
    private Activity mActivity;

    public ImmLeaksCleaner(Activity activity) {
        this.mActivity = activity;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void initializeReflectiveFields() {
        String string2;
        Object object;
        int n10 = 2;
        try {
            sReflectedFieldsInitialized = n10;
            object = InputMethodManager.class;
            string2 = "mServedView";
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return;
        }
        object = ((Class)object).getDeclaredField(string2);
        sServedViewField = object;
        int n11 = 1;
        ((Field)object).setAccessible(n11 != 0);
        object = InputMethodManager.class;
        String string3 = "mNextServedView";
        object = ((Class)object).getDeclaredField(string3);
        sNextServedViewField = object;
        ((Field)object).setAccessible(n11 != 0);
        object = InputMethodManager.class;
        string3 = "mH";
        object = ((Class)object).getDeclaredField(string3);
        sHField = object;
        ((Field)object).setAccessible(n11 != 0);
        sReflectedFieldsInitialized = n11;
    }

    /*
     * Exception decompiling
     */
    public void onStateChanged(LifecycleOwner var1_1, Lifecycle$Event var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 10[TRYBLOCK] [20 : 142->145)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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
}

