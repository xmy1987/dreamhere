package com.xmy.dh.util.file;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;

/**
 * Created by qinyong on 2017/2/15.
 */
public class FileStore {

    private COSClient cosClient;

    private StoreConfig storeConfig;

    private FileStore(StoreConfig storeConfig){
        this.storeConfig = storeConfig;
        init();
    }

    private void init(){
        ClientConfig clientConfig = new ClientConfig();
        // 设置bucket所在的区域，比如广州(gz), 天津(tj)
        clientConfig.setRegion(this.storeConfig.region);
        Credentials cred = new Credentials(this.storeConfig.appId,this.storeConfig.secretId,this.storeConfig.secretKey);
        cosClient = new COSClient(clientConfig,cred);
    }

    public static FileStore getInstance(StoreConfig storeConfig){
        return new FileStore(storeConfig);
    }

    public String uploadFile(String storePath,String localFilePath){
        UploadFileRequest uploadFileRequest = new UploadFileRequest(this.storeConfig.bucketName, storePath, localFilePath);
        String res =  cosClient.uploadFile(uploadFileRequest);
        cosClient.shutdown();
        return res;
    }

}
