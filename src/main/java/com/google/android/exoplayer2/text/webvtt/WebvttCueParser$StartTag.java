/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class WebvttCueParser$StartTag {
    public final Set classes;
    public final String name;
    public final int position;
    public final String voice;

    private WebvttCueParser$StartTag(String string2, int n10, String string3, Set set) {
        this.position = n10;
        this.name = string2;
        this.voice = string3;
        this.classes = set;
    }

    public static WebvttCueParser$StartTag buildStartTag(String object, int n10) {
        int n11;
        String string2;
        object = object.trim();
        int n12 = object.isEmpty();
        int n13 = 1;
        Assertions.checkArgument(n12 ^ n13);
        String string3 = " ";
        n12 = object.indexOf(string3);
        int n14 = -1;
        HashSet<String> hashSet = null;
        if (n12 == n14) {
            string3 = "";
        } else {
            string2 = object.substring(n12).trim();
            object = object.substring(0, n12);
            string3 = string2;
        }
        object = Util.split((String)object, "\\.");
        string2 = object[0];
        hashSet = new HashSet<String>();
        while (n13 < (n11 = ((String[])object).length)) {
            String string4 = object[n13];
            hashSet.add(string4);
            ++n13;
        }
        object = new WebvttCueParser$StartTag(string2, n10, string3, hashSet);
        return object;
    }

    public static WebvttCueParser$StartTag buildWholeCueVirtualTag() {
        Set set = Collections.emptySet();
        String string2 = "";
        WebvttCueParser$StartTag webvttCueParser$StartTag = new WebvttCueParser$StartTag(string2, 0, string2, set);
        return webvttCueParser$StartTag;
    }
}

