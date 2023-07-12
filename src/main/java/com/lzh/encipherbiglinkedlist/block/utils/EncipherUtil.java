package com.lzh.encipherbiglinkedlist.block.utils;

import com.lzh.encipherbiglinkedlist.block.entity.Block.Block;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p>
 * pow加密工具<br>
 * </p>
 *
 * @author LZH
 * @version V1.0
 * @since 2023/7/7 14:52
 */
@Component
public class EncipherUtil {

    public Block encipherBlock(Block block){
        String blockData = block.getBlockData().toString();
        String target = block.getTarget();

        int count = 0;
        String encodeSHA = SHAUtils.encodeSHA(blockData);
        if(Objects.isNull(encodeSHA)){
            return null;
        }
        while (!encodeSHA.substring(0, target.length()).equals(target)){
            count++;
            String hexString = Integer.toHexString(count);
            encodeSHA = SHAUtils.encodeSHA(encodeSHA+hexString);
        };
        block.setCount(count);
        return block;
    }

}
