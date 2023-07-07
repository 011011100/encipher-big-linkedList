package com.lzh.encipherbiglinkedlist.block.entity;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 定义块<br>
 * </p>
 *
 * @author LZH
 * @version V1.0
 * @since 2023/7/7 14:36
 */
public class Block {

    /**
     * 块内容
     */
    private Map<String,String> blockData;

    /**
     * 上个块的哈希
     */
    private String previousBlockHash;

    /**
     * 块创建时间
     */
    private Date createTime;

    /**
     * 计数器
     */
    private int count;

    private String target;

    public Block() {
    }

    public Block(Map<String, String> blockData, String previousBlockHash, Date createTime, int count, String target) {
        this.blockData = blockData;
        this.previousBlockHash = previousBlockHash;
        this.createTime = createTime;
        this.count = count;
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Map<String, String> getBlockData() {
        return blockData;
    }

    public void setBlockData(Map<String, String> blockData) {
        this.blockData = blockData;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
