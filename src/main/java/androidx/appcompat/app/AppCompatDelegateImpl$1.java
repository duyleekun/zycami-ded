/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$NotFoundException
 */
package androidx.appcompat.app;

import android.content.res.Resources;

public class AppCompatDelegateImpl$1
implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ Thread.UncaughtExceptionHandler val$defHandler;

    public AppCompatDelegateImpl$1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.val$defHandler = uncaughtExceptionHandler;
    }

    private boolean shouldWrapException(Throwable object) {
        boolean bl2;
        String string2;
        boolean bl3 = object instanceof Resources.NotFoundException;
        boolean bl4 = false;
        if (bl3 && (object = ((Throwable)object).getMessage()) != null && ((bl3 = ((String)object).contains(string2 = "drawable")) || (bl2 = ((String)object).contains(string2 = "Drawable")))) {
            bl4 = true;
        }
        return bl4;
    }

    public void uncaughtException(Thread thread, Throwable object) {
        boolean bl2 = this.shouldWrapException((Throwable)object);
        if (bl2) {
            Object object2 = new StringBuilder();
            String string2 = ((Throwable)object).getMessage();
            ((StringBuilder)object2).append(string2);
            string2 = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            Resources.NotFoundException notFoundException = new Resources.NotFoundException((String)object2);
            object2 = ((Throwable)object).getCause();
            notFoundException.initCause((Throwable)object2);
            object = ((Throwable)object).getStackTrace();
            notFoundException.setStackTrace((StackTraceElement[])object);
            object = this.val$defHandler;
            object.uncaughtException(thread, (Throwable)notFoundException);
        } else {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.val$defHandler;
            uncaughtExceptionHandler.uncaughtException(thread, (Throwable)object);
        }
    }
}

