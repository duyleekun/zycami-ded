/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public final class PatternFilenameFilter
implements FilenameFilter {
    private final Pattern pattern;

    public PatternFilenameFilter(String object) {
        object = Pattern.compile((String)object);
        this((Pattern)object);
    }

    public PatternFilenameFilter(Pattern pattern) {
        this.pattern = pattern = (Pattern)Preconditions.checkNotNull(pattern);
    }

    public boolean accept(File file, String string2) {
        return this.pattern.matcher(string2).matches();
    }
}

