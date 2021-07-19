/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

public class ResponseParser {
    public static final int ResponseActionDiscard = 0;
    public static final int ResponseActionRetry = 1;

    public static int parse(int n10) {
        int n11 = 0;
        int n12 = 200;
        if (n10 >= n12 && n10 <= (n12 = 299)) {
            return 0;
        }
        n12 = 300;
        int n13 = 1;
        if (n10 >= n12 && n10 <= (n12 = 399)) {
            return n13;
        }
        n12 = 400;
        if (n10 >= n12 && n10 <= (n12 = 499)) {
            return 0;
        }
        n11 = 500;
        if (n10 >= n11) {
            // empty if block
        }
        return n13;
    }
}

