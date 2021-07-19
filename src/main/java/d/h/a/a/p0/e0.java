/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.p0;

import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.exoplayer2.ui.TrackSelectionView$TrackInfo;
import java.util.Comparator;

public final class e0
implements Comparator {
    public final /* synthetic */ Comparator a;

    public /* synthetic */ e0(Comparator comparator) {
        this.a = comparator;
    }

    public final int compare(Object object, Object object2) {
        Comparator comparator = this.a;
        object = (TrackSelectionView$TrackInfo)object;
        object2 = (TrackSelectionView$TrackInfo)object2;
        return TrackSelectionView.a(comparator, (TrackSelectionView$TrackInfo)object, (TrackSelectionView$TrackInfo)object2);
    }
}

