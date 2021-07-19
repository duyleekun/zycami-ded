/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

public final class OnErrorAction
extends Enum {
    public static final /* enum */ OnErrorAction SKIP;
    public static final /* enum */ OnErrorAction TERMINATE;
    private static final /* synthetic */ OnErrorAction[] a;

    static {
        OnErrorAction onErrorAction;
        OnErrorAction[] onErrorActionArray = new OnErrorAction[2];
        SKIP = onErrorAction = new OnErrorAction("SKIP", 0);
        onErrorActionArray[0] = onErrorAction;
        int n10 = 1;
        TERMINATE = onErrorAction = new OnErrorAction("TERMINATE", n10);
        onErrorActionArray[n10] = onErrorAction;
        a = onErrorActionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OnErrorAction() {
        void var2_-1;
        void var1_-1;
    }

    public static OnErrorAction valueOf(String string2) {
        return Enum.valueOf(OnErrorAction.class, string2);
    }

    public static OnErrorAction[] values() {
        return (OnErrorAction[])a.clone();
    }
}

