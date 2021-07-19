/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public final class CompositeOnPageChangeCallback
extends ViewPager2$OnPageChangeCallback {
    private final List mCallbacks;

    public CompositeOnPageChangeCallback(int n10) {
        ArrayList arrayList;
        this.mCallbacks = arrayList = new ArrayList(n10);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException concurrentModificationException) {
        IllegalStateException illegalStateException = new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
        throw illegalStateException;
    }

    public void addOnPageChangeCallback(ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback) {
        this.mCallbacks.add(viewPager2$OnPageChangeCallback);
    }

    public void onPageScrollStateChanged(int n10) {
        Object object = this.mCallbacks;
        try {
            object = object.iterator();
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            this.throwCallbackListModifiedWhileInUse(concurrentModificationException);
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object object2 = object.next();
            object2 = (ViewPager2$OnPageChangeCallback)object2;
            ((ViewPager2$OnPageChangeCallback)object2).onPageScrollStateChanged(n10);
            continue;
            break;
        }
    }

    public void onPageScrolled(int n10, float f10, int n11) {
        Object object = this.mCallbacks;
        try {
            object = object.iterator();
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            this.throwCallbackListModifiedWhileInUse(concurrentModificationException);
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object object2 = object.next();
            object2 = (ViewPager2$OnPageChangeCallback)object2;
            ((ViewPager2$OnPageChangeCallback)object2).onPageScrolled(n10, f10, n11);
            continue;
            break;
        }
    }

    public void onPageSelected(int n10) {
        Object object = this.mCallbacks;
        try {
            object = object.iterator();
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            this.throwCallbackListModifiedWhileInUse(concurrentModificationException);
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object object2 = object.next();
            object2 = (ViewPager2$OnPageChangeCallback)object2;
            ((ViewPager2$OnPageChangeCallback)object2).onPageSelected(n10);
            continue;
            break;
        }
    }

    public void removeOnPageChangeCallback(ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback) {
        this.mCallbacks.remove(viewPager2$OnPageChangeCallback);
    }
}

