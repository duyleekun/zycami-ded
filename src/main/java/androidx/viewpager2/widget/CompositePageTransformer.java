/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2$PageTransformer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CompositePageTransformer
implements ViewPager2$PageTransformer {
    private final List mTransformers;

    public CompositePageTransformer() {
        ArrayList arrayList;
        this.mTransformers = arrayList = new ArrayList();
    }

    public void addTransformer(ViewPager2$PageTransformer viewPager2$PageTransformer) {
        this.mTransformers.add(viewPager2$PageTransformer);
    }

    public void removeTransformer(ViewPager2$PageTransformer viewPager2$PageTransformer) {
        this.mTransformers.remove(viewPager2$PageTransformer);
    }

    public void transformPage(View view, float f10) {
        boolean bl2;
        Iterator iterator2 = this.mTransformers.iterator();
        while (bl2 = iterator2.hasNext()) {
            ViewPager2$PageTransformer viewPager2$PageTransformer = (ViewPager2$PageTransformer)iterator2.next();
            viewPager2$PageTransformer.transformPage(view, f10);
        }
    }
}

