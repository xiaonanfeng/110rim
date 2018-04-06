package com.zxit.service;

import java.io.IOException;

public interface TransWav2Mp3Service {

    /**
     * 把需要播放的录音下载到本地web服务的临时路径
     *
     * @param wavPath
     * @param mp3Path
     * @return
     */
    void copyWavIntoDesk(String wavPath, String mp3Path) throws IOException;

    /**
     * wav转换mp3
     *
     * @param wavPath
     * @param mp3Path
     * @return
     * @throws Exception
     */
    String transWav2Mp3(String wavPath, String mp3Path) throws Exception;


}
    



