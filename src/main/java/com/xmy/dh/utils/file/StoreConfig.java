package com.xmy.dh.utils.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by qinyong on 2017/2/15.
 */
@Component
public class StoreConfig {
    @Value("${cos.appId}")
    public int appId;

    @Value("${cos.secretId}")
    public String secretId;

    @Value("${cos.secretKey}")
    public String secretKey;

    public final static String DEFAULT_BUCKET_NAME = "dreamhere";

    public String bucketName = DEFAULT_BUCKET_NAME;
}
