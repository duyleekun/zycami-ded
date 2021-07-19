/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.v2.AVIMMessageStorage$MessageQueryResult;
import java.util.List;
import java.util.Map;

public interface DatabaseDelegate {
    public long countForQuery(String var1, String[] var2);

    public int delete(String var1, String var2, String[] var3);

    public int insert(String var1, Map var2);

    public List queryConversations(String[] var1, String var2, String[] var3, String var4, String var5, String var6, String var7);

    public int queryCount(String var1, String[] var2, String var3, String[] var4, String var5, String var6, String var7);

    public AVIMMessageStorage.MessageQueryResult queryMessages(String[] var1, String var2, String[] var3, String var4, String var5, String var6, String var7);

    public List rawQueryConversations(String var1, String[] var2);

    public int update(String var1, Map var2, String var3, String[] var4);
}

