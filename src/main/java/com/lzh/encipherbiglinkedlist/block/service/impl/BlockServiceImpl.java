package com.lzh.encipherbiglinkedlist.block.service.impl;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.lzh.encipherbiglinkedlist.block.entity.Block.Block;
import com.lzh.encipherbiglinkedlist.block.entity.encipher.EncipherData;
import com.lzh.encipherbiglinkedlist.block.service.BlockService;
import com.lzh.encipherbiglinkedlist.block.utils.EncipherUtil;
import com.lzh.encipherbiglinkedlist.block.utils.SHAUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
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
     * 创建区块并返回<br>
     * </p>
     *
     * @param target    难度目标
     * @param blockData 块内容
     * @return com.lzh.encipherbiglinkedlist.block.entity.Block
     * @author LZH
     * @since 14:48 2023/7/7
     **/
    @Override
    public Block createBlock(String target, Map<String, String> blockData) {
        Block block = new Block();
        block.setCreateTime(new Date());
        block.setBlockData(blockData);
        block.setTarget(target);
        return encipherUtil.encipherBlock(block);
    }

    /**
     * <p>
     * 在上一个块上添加新的块<br>
     * </p>
     *
     * @param block     上一个块
     * @param target    难度目标
     * @param blockData 块内容
     * @return java.lang.String
     * @author LZH
     * @since 17:22 2023/7/11
     **/
    @Override
    public Block joinBlock(Block block, String target, Map<String, String> blockData) {
        Block newBlock = this.createBlock(target, blockData);
        newBlock.setPreviousBlockHash(SHAUtils.encodeSHA(block.toString()));
        return newBlock;
    }

    /**
     * <p>
     * 加密块<br>
     * </p>
     * @author LZH
     * @since 16:55 2023/7/12
     * @param block 块
     * @return com.lzh.encipherbiglinkedlist.block.entity.encipher.EncipherData
     **/
    @Override
    public EncipherData encipherBlock(Block block) {
        KeyPair pair = SecureUtil.generateKeyPair("RSA" , 1024 , StrUtil.bytes(block.toString(), CharsetUtil.CHARSET_UTF_8));
        RSA rsa = new RSA(pair.getPrivate(),pair.getPublic());
        byte[] encrypt = rsa.encrypt(StrUtil.bytes(block.toString(), CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        return new EncipherData(encrypt,pair.getPublic(),pair.getPrivate());
    }
}
