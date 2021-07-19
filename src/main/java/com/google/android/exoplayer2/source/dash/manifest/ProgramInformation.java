/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

public class ProgramInformation {
    public final String copyright;
    public final String lang;
    public final String moreInformationURL;
    public final String source;
    public final String title;

    public ProgramInformation(String string2, String string3, String string4, String string5, String string6) {
        this.title = string2;
        this.source = string3;
        this.copyright = string4;
        this.moreInformationURL = string5;
        this.lang = string6;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (ProgramInformation)object;
            object3 = this.title;
            object2 = ((ProgramInformation)object).title;
            boolean bl4 = Util.areEqual(object3, object2);
            if (!(bl4 && (bl4 = Util.areEqual(object3 = this.source, object2 = ((ProgramInformation)object).source)) && (bl4 = Util.areEqual(object3 = this.copyright, object2 = ((ProgramInformation)object).copyright)) && (bl4 = Util.areEqual(object3 = this.moreInformationURL, object2 = ((ProgramInformation)object).moreInformationURL)) && (bl3 = Util.areEqual(object3 = this.lang, object = ((ProgramInformation)object).lang)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.title;
        int n11 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        int n12 = (527 + n10) * 31;
        string2 = this.source;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n12 = (n12 + n10) * 31;
        string2 = this.copyright;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n12 = (n12 + n10) * 31;
        string2 = this.moreInformationURL;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n12 = (n12 + n10) * 31;
        string2 = this.lang;
        if (string2 != null) {
            n11 = string2.hashCode();
        }
        return n12 + n11;
    }
}

