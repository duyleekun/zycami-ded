/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GaplessInfoHolder {
    private static final Pattern GAPLESS_COMMENT_PATTERN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    private static final String GAPLESS_DESCRIPTION = "iTunSMPB";
    private static final String GAPLESS_DOMAIN = "com.apple.iTunes";
    public int encoderDelay;
    public int encoderPadding;

    public GaplessInfoHolder() {
        int n10;
        this.encoderDelay = n10 = -1;
        this.encoderPadding = n10;
    }

    private boolean setFromComment(String object) {
        block12: {
            Pattern pattern = GAPLESS_COMMENT_PATTERN;
            boolean bl2 = ((Matcher)(object = pattern.matcher((CharSequence)object))).find();
            if (bl2) {
                Object object2;
                bl2 = true;
                try {
                    object2 = ((Matcher)object).group((int)(bl2 ? 1 : 0));
                }
                catch (NumberFormatException numberFormatException) {}
                object2 = Util.castNonNull(object2);
                object2 = (String)object2;
                int n10 = 16;
                int n11 = Integer.parseInt((String)object2, n10);
                int n12 = 2;
                object = ((Matcher)object).group(n12);
                object = Util.castNonNull(object);
                object = (String)object;
                int n13 = Integer.parseInt((String)object, n10);
                if (n11 <= 0 && n13 <= 0) break block12;
                this.encoderDelay = n11;
                this.encoderPadding = n13;
                return bl2;
            }
        }
        return false;
    }

    public boolean hasGaplessInfo() {
        int n10 = this.encoderDelay;
        int n11 = -1;
        n10 = n10 != n11 && (n10 = this.encoderPadding) != n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean setFromMetadata(Metadata metadata) {
        int n10;
        for (int i10 = 0; i10 < (n10 = metadata.length()); ++i10) {
            String string2;
            Object object = metadata.get(i10);
            boolean bl2 = object instanceof CommentFrame;
            String string3 = GAPLESS_DESCRIPTION;
            boolean bl3 = true;
            if (bl2) {
                object = (CommentFrame)object;
                string2 = ((CommentFrame)object).description;
                bl2 = string3.equals(string2);
                if (!bl2 || (n10 = (int)(this.setFromComment((String)(object = ((CommentFrame)object).text)) ? 1 : 0)) == 0) continue;
                return bl3;
            }
            bl2 = object instanceof InternalFrame;
            if (!bl2) continue;
            object = (InternalFrame)object;
            String string4 = GAPLESS_DOMAIN;
            string2 = ((InternalFrame)object).domain;
            bl2 = string4.equals(string2);
            if (!bl2 || !(bl2 = string3.equals(string2 = ((InternalFrame)object).description)) || (n10 = (int)(this.setFromComment((String)(object = ((InternalFrame)object).text)) ? 1 : 0)) == 0) continue;
            return bl3;
        }
        return false;
    }

    public boolean setFromXingHeaderValue(int n10) {
        int n11 = n10 >> 12;
        if (n11 <= 0 && (n10 &= 0xFFF) <= 0) {
            return false;
        }
        this.encoderDelay = n11;
        this.encoderPadding = n10;
        return true;
    }
}

