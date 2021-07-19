/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.ContiguousPagedList;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PagedStorage$Callback;
import java.util.List;

public class ContiguousPagedList$1
extends PageResult$Receiver {
    public final /* synthetic */ ContiguousPagedList this$0;

    public ContiguousPagedList$1(ContiguousPagedList contiguousPagedList) {
        this.this$0 = contiguousPagedList;
    }

    /*
     * Unable to fully structure code
     */
    public void onPageResult(int var1_1, PageResult var2_2) {
        block31: {
            block28: {
                block30: {
                    block29: {
                        block27: {
                            var3_3 = var2_2.isInvalid();
                            if (var3_3 != 0) {
                                this.this$0.detach();
                                return;
                            }
                            var4_4 = this.this$0;
                            var3_3 = var4_4.isDetached();
                            if (var3_3 != 0) {
                                return;
                            }
                            var4_4 = var2_2.page;
                            var5_5 = 2;
                            var6_6 = 1;
                            if (var1_1 != 0) break block27;
                            var7_7 = this.this$0;
                            var8_8 = var7_7.mStorage;
                            var9_9 = var2_2.leadingNulls;
                            var10_11 = var2_2.trailingNulls;
                            var11_13 = var2_2.positionOffset;
                            var12_15 = var4_4;
                            var8_8.init(var9_9, (List)var4_4, var10_11, var11_13, var7_7);
                            var8_8 = this.this$0;
                            var9_9 = var8_8.mLastLoad;
                            var13_17 = -1;
                            if (var9_9 == var13_17) {
                                var9_9 = var2_2.leadingNulls;
                                var13_17 = var2_2.positionOffset;
                                var9_9 += var13_17;
                                var3_3 = var4_4.size() / var5_5;
                                var8_8.mLastLoad = var9_9 += var3_3;
                            }
                            break block28;
                        }
                        var8_8 = this.this$0;
                        var9_10 = var8_8.mLastLoad;
                        var8_8 = var8_8.mStorage;
                        var14_19 = var8_8.getMiddleOfLoadedRange();
                        if (var9_10 > var14_19) {
                            var14_19 = var6_6;
                        } else {
                            var14_19 = 0;
                            var8_8 = null;
                        }
                        var15_20 = this.this$0;
                        var13_18 = var15_20.mShouldTrim;
                        if (var13_18 == 0) ** GOTO lbl-1000
                        var12_16 = var15_20.mStorage;
                        var16_21 = var15_20.mConfig;
                        var10_12 = var16_21.maxSize;
                        var9_10 = var15_20.mRequiredRemainder;
                        var11_14 = var4_4.size();
                        if ((var9_10 = (int)var12_16.shouldPreTrimNewPage(var10_12, var9_10, var11_14)) != 0) {
                            var9_10 = var6_6;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var9_10 = 0;
                            var15_20 = null;
                        }
                        if (var1_1 != var6_6) break block29;
                        if (var9_10 != 0 && var14_19 == 0) {
                            var4_4 = this.this$0;
                            var4_4.mAppendItemsRequested = 0;
                            var4_4.mAppendWorkerState = 0;
                        } else {
                            var15_20 = this.this$0;
                            var12_16 = var15_20.mStorage;
                            var12_16.appendPage((List)var4_4, var15_20);
                        }
                        break block30;
                    }
                    if (var1_1 != var5_5) break block31;
                    if (var9_10 != 0 && var14_19 != 0) {
                        var4_4 = this.this$0;
                        var4_4.mPrependItemsRequested = 0;
                        var4_4.mPrependWorkerState = 0;
                    } else {
                        var15_20 = this.this$0;
                        var12_16 = var15_20.mStorage;
                        var12_16.prependPage((List)var4_4, var15_20);
                    }
                }
                var4_4 = this.this$0;
                var9_10 = (int)var4_4.mShouldTrim;
                if (var9_10 != 0) {
                    if (var14_19 != 0) {
                        var14_19 = var4_4.mPrependWorkerState;
                        if (var14_19 != var6_6) {
                            var8_8 = var4_4.mStorage;
                            var9_10 = (int)var4_4.mReplacePagesWithNulls;
                            var12_16 = var4_4.mConfig;
                            var13_18 = var12_16.maxSize;
                            var10_12 = var4_4.mRequiredRemainder;
                            var3_3 = var8_8.trimFromFront((boolean)var9_10, var13_18, var10_12, (PagedStorage$Callback)var4_4);
                            if (var3_3 != 0) {
                                var4_4 = this.this$0;
                                var4_4.mPrependWorkerState = 0;
                            }
                        }
                    } else {
                        var14_19 = var4_4.mAppendWorkerState;
                        if (var14_19 != var6_6) {
                            var8_8 = var4_4.mStorage;
                            var9_10 = (int)var4_4.mReplacePagesWithNulls;
                            var12_16 = var4_4.mConfig;
                            var13_18 = var12_16.maxSize;
                            var10_12 = var4_4.mRequiredRemainder;
                            var3_3 = var8_8.trimFromEnd((boolean)var9_10, var13_18, var10_12, (PagedStorage$Callback)var4_4);
                            if (var3_3 != 0) {
                                var4_4 = this.this$0;
                                var4_4.mAppendWorkerState = 0;
                            }
                        }
                    }
                }
            }
            var4_4 = this.this$0;
            var8_8 = var4_4.mBoundaryCallback;
            if (var8_8 != null) {
                var4_4 = var4_4.mStorage;
                var3_3 = var4_4.size();
                if (var3_3 == 0) {
                    var3_3 = var6_6;
                } else {
                    var3_3 = 0;
                    var4_4 = null;
                }
                if (var3_3 == 0 && var1_1 == var5_5 && (var14_19 = (var8_8 = var2_2.page).size()) == 0) {
                    var14_19 = var6_6;
                } else {
                    var14_19 = 0;
                    var8_8 = null;
                }
                if (var3_3 != 0 || var1_1 != var6_6 || (var1_1 = (var17_22 = var2_2.page).size()) != 0) {
                    var6_6 = 0;
                }
                var17_22 = this.this$0;
                var17_22.deferBoundaryCallbacks((boolean)var3_3, (boolean)var14_19, (boolean)var6_6);
            }
            return;
        }
        var4_4 = new StringBuilder();
        var4_4.append("unexpected resultType ");
        var4_4.append(var1_1);
        var17_23 = var4_4.toString();
        var2_2 = new IllegalArgumentException(var17_23);
        throw var2_2;
    }
}

