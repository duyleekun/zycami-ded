/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.text.TextOutput;
import java.util.List;

public interface Player$TextComponent {
    public void addTextOutput(TextOutput var1);

    public List getCurrentCues();

    public void removeTextOutput(TextOutput var1);
}

