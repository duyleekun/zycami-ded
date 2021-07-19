/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text.util;

import androidx.core.text.util.LinkifyCompat$LinkSpec;
import java.util.Comparator;

public class LinkifyCompat$1
implements Comparator {
    public int compare(LinkifyCompat$LinkSpec linkifyCompat$LinkSpec, LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2) {
        int n10 = linkifyCompat$LinkSpec.start;
        int n11 = linkifyCompat$LinkSpec2.start;
        int n12 = -1;
        if (n10 < n11) {
            return n12;
        }
        int n13 = 1;
        if (n10 > n11) {
            return n13;
        }
        int n14 = linkifyCompat$LinkSpec.end;
        int n15 = linkifyCompat$LinkSpec2.end;
        if (n14 < n15) {
            return n13;
        }
        if (n14 > n15) {
            return n12;
        }
        return 0;
    }
}

