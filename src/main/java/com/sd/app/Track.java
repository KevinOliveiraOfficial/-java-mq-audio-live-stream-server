package com.sd.app;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Track
{
    public String name;
    public File file;
    public AudioFormat audioFormat;
    public long audioLength;
    public int headerSize = 0;
    public byte[] header;
    public AudioInputStream audioInputStream;

    public Track( String name, File file, int headerSize ) throws UnsupportedAudioFileException, IOException {
        this.name = name;
        this.file = file;
        this.audioLength = file.length();
        this.headerSize = headerSize;

        this.audioInputStream = AudioSystem.getAudioInputStream(file);
        
        AudioFormat format = this.audioInputStream.getFormat();
        this.audioFormat = format;
        
        float sampleRate = format.getSampleRate();
        int sampleSizeInBits = format.getSampleSizeInBits();
        int channels = format.getChannels();
        boolean isBigEndian = format.isBigEndian();

        System.out.println("Name: " + name);
        System.out.println("Sample Rate: " + sampleRate + " Hz");
        System.out.println("Sample Size in Bits: " + sampleSizeInBits + " bits");
        System.out.println("Channels: " + channels);
        System.out.println("Big Endian: " + isBigEndian);
        System.out.println("bps " + this.calcBps());
        //this.audioInputStream.close();
    }
    
    public int calcBps() {
        AudioFormat format = this.audioInputStream.getFormat();
        float sampleRate = format.getSampleRate();
        int sampleSizeInBits = format.getSampleSizeInBits();
        int channels = format.getChannels();

        return (int) (sampleRate * (sampleSizeInBits/8) * channels);
    }
}
