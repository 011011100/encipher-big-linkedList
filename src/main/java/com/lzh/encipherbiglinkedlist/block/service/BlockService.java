package com.lzh.encipherbiglinkedlist.block.service;


import com.lzh.encipherbiglinkedlist.block.entity.Block.Block;
import com.lzh.encipherbiglinkedlist.block.entity.encipher.EncipherData;

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
    Block createBlock(String target, Map<String,String> blockData);

    /**
     * <p>
     * 在上一个块上添加新的块<br>
     * </p>
     * @author LZH
     * @since 17:22 2023/7/11
     * @param block 上一个块
     * @param target 难度目标
     * @param blockData 块内容
     * @return java.lang.String
     **/
    Block joinBlock(Block block, String target, Map<String,String> blockData);

    /**
     * <p>
     * 加密块<br>
     * </p>
     * @author LZH
     * @since 16:55 2023/7/12
     * @param block 块
     * @return com.lzh.encipherbiglinkedlist.block.entity.encipher.EncipherData
     **/
    EncipherData encipherBlock(Block block);
}
