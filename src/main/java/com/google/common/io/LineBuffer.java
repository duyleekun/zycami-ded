/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

public abstract class LineBuffer {
    private StringBuilder line;
    private boolean sawReturn;

    public LineBuffer() {
        StringBuilder stringBuilder;
        this.line = stringBuilder = new StringBuilder();
    }

    private boolean finishLine(boolean bl2) {
        boolean bl3 = this.sawReturn;
        CharSequence charSequence = bl3 ? (bl2 ? "\r\n" : "\r") : (bl2 ? "\n" : "");
        String string2 = this.line.toString();
        this.handleLine(string2, (String)charSequence);
        charSequence = new StringBuilder();
        this.line = charSequence;
        this.sawReturn = false;
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    public void add(char[] var1_1, int var2_2, int var3_3) {
        var4_4 = this.sawReturn;
        var5_5 = 10;
        var6_6 = 1;
        if (var4_4 == 0 || var3_3 <= 0) ** GOTO lbl-1000
        var4_4 = var1_1[var2_2];
        if (var4_4 == var5_5) {
            var4_4 = var6_6;
        } else {
            var4_4 = 0;
            var7_7 = null;
        }
        var4_4 = this.finishLine((boolean)var4_4);
        if (var4_4 != 0) {
            var4_4 = var2_2 + 1;
        } else lbl-1000:
        // 2 sources

        {
            var4_4 = var2_2;
        }
        var2_2 += var3_3;
        var3_3 = var4_4;
        while (var4_4 < var2_2) {
            block10: {
                block11: {
                    block9: {
                        var8_8 = var1_1[var4_4];
                        if (var8_8 == var5_5) break block9;
                        var9_9 = 13;
                        if (var8_8 != var9_9) break block10;
                        var10_10 = this.line;
                        var9_9 = var4_4 - var3_3;
                        var10_10.append(var1_1, var3_3, var9_9);
                        this.sawReturn = var6_6;
                        var3_3 = var4_4 + 1;
                        if (var3_3 < var2_2) {
                            var8_8 = var1_1[var3_3];
                            if (var8_8 == var5_5) {
                                var8_8 = var6_6;
                            } else {
                                var8_8 = 0;
                                var10_10 = null;
                            }
                            var8_8 = this.finishLine((boolean)var8_8);
                            if (var8_8 != 0) {
                                var4_4 = var3_3;
                            }
                        }
                        break block11;
                    }
                    var10_10 = this.line;
                    var9_9 = var4_4 - var3_3;
                    var10_10.append(var1_1, var3_3, var9_9);
                    this.finishLine((boolean)var6_6);
                }
                var3_3 = var4_4 + 1;
            }
            var4_4 += var6_6;
        }
        var7_7 = this.line;
        var7_7.append(var1_1, var3_3, var2_2 -= var3_3);
    }

    public void finish() {
        StringBuilder stringBuilder;
        int n10 = this.sawReturn;
        if (n10 != 0 || (n10 = (stringBuilder = this.line).length()) > 0) {
            n10 = 0;
            stringBuilder = null;
            this.finishLine(false);
        }
    }

    public abstract void handleLine(String var1, String var2);
}

