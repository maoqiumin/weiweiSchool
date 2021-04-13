package com.qmmao.weiweischool.security.common.domin;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author DELL
 */
public class ImageCode {

    private String code;

    private BufferedImage bufferedImage;
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 设置在多少秒之后过期
     *
     * @param bufferImage 图片流
     * @param code        验证码
     * @param expireIn    秒数
     */
    public ImageCode(BufferedImage bufferImage, String code, int expireIn) {
        this.code = code;
        this.bufferedImage = bufferImage;
        // 当前时间+过期时间长度(使用缓存之后此配置即不需要)
        // todo redis
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
