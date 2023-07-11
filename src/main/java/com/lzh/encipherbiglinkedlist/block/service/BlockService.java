package com.lzh.encipherbiglinkedlist.block.service;


import java.util.Map;

/**
 * <p>
 * 操作块方法接口<br>
 * </p>
 *
 * @author LZH
 * @version V1.0
 * @since 2023/7/7 14:42
 */
public interface BlockService {

    /**
     * <p>
     * 创建区块并返回加密信息<br>
     * </p>
     * @author LZH
     * @since 14:48 2023/7/7
     * @param target 难度目标
     * @param blockData 块内容
     * @return java.lang.String
     **/
    String createBlock(String target, Map<String,String> blockData);
}
