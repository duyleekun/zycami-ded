/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class AdaptationSet {
    public static final int ID_UNSET = 255;
    public final List accessibilityDescriptors;
    public final List essentialProperties;
    public final int id;
    public final List representations;
    public final List supplementalProperties;
    public final int type;

    public AdaptationSet(int n10, int n11, List list, List list2, List list3, List list4) {
        List list5;
        this.id = n10;
        this.type = n11;
        this.representations = list5 = Collections.unmodifiableList(list);
        this.accessibilityDescriptors = list5 = Collections.unmodifiableList(list2);
        this.essentialProperties = list5 = Collections.unmodifiableList(list3);
        this.supplementalProperties = list5 = Collections.unmodifiableList(list4);
    }
}

