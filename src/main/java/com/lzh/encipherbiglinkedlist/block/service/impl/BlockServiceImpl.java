package com.lzh.encipherbiglinkedlist.block.service.impl;

import com.lzh.encipherbiglinkedlist.block.entity.Block;
import com.lzh.encipherbiglinkedlist.block.service.BlockService;
import com.lzh.encipherbiglinkedlist.block.utils.EncipherUtil;
import com.lzh.encipherbiglinkedlist.block.utils.SHAUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 操作块接口实现类<br>
 * </p>
 *
 * @author LZH
 * @version V1.0
 * @since 2023/7/7 14:43
 */
@Service
public class BlockServiceImpl implements BlockService {

    @Resource
    private EncipherUtil encipherUtil;

    /**
     * <p>
     * 创建区块<br>
     * </p>
     *
     * @param target    难度目标
     * @param blockData 块内容
     * @return com.lzh.encipherbiglinkedlist.block.entity.Block
     * @author LZH
     * @since 14:48 2023/7/7
     **/
    @Override
    public String createBlock(String target, Map<String, String> blockData) {
        Block block = new Block();
        block.setCreateTime(new Date());
        block.setBlockData(blockData);
        block.setTarget(target);
        Block encipherBlock = encipherUtil.encipherBlock(block);
        return SHAUtils.encodeSHA(encipherBlock.toString());
    }
}
