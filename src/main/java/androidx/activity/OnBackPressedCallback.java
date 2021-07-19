/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity;

import androidx.activity.Cancellable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList mCancellables;
    private boolean mEnabled;

    public OnBackPressedCallback(boolean bl2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.mCancellables = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mEnabled = bl2;
    }

    public void addCancellable(Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    public abstract void handleOnBackPressed();

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        boolean bl2;
        Iterator iterator2 = this.mCancellables.iterator();
        while (bl2 = iterator2.hasNext()) {
            Cancellable cancellable = (Cancellable)iterator2.next();
            cancellable.cancel();
        }
    }

    public void removeCancellable(Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }

    public final void setEnabled(boolean bl2) {
        this.mEnabled = bl2;
    }
}

