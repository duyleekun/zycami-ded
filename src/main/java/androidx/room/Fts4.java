/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.FtsOptions$MatchInfo;
import androidx.room.FtsOptions$Order;

public @interface Fts4 {
    public Class contentEntity();

    public String languageId();

    public FtsOptions.MatchInfo matchInfo();

    public String[] notIndexed();

    public FtsOptions.Order order();

    public int[] prefix();

    public String tokenizer();

    public String[] tokenizerArgs();
}

