package com.lzh.encipherbiglinkedlist.block.entity.encipher;

import lombok.experimental.Accessors;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * <p>
 * <br>
 * </p>
 *
 * @author LZH
 * @version V1.0
 * @since 2023/7/12 16:51
 */
@Accessors(chain = true)
public class EncipherData {

    private byte[] data;

    private PublicKey publicKey;

    private PrivateKey privateKey;

    public EncipherData(byte[] data, PublicKey publicKey, PrivateKey privateKey) {
        this.data = data;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public EncipherData() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}
