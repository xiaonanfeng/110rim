package com.zxit.service.impl;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;
import java.io.IOException;

import com.zxit.service.TransWav2Mp3Service;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;


@Service
public class TransWav2Mp3ServiceImpl implements TransWav2Mp3Service {

    @Override
    public void copyWavIntoDesk(String wavPath, String mp3Path) throws IOException {
        File source = new File(wavPath);
        File tar = new File(mp3Path);
        FileCopyUtils.copy(source, tar);
    }

    public String transWav2Mp3(String wavPath, String mp3Path) throws Exception {
        File mp3 = new File(mp3Path);
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(36000)); //音频比率 MP3默认是1280000
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(44100));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        File source = new File(wavPath);
        encoder.encode(source, mp3, attrs);
        return mp3Path;
    }

}
    



