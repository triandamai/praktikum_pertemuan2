package com.example.kelompok3.pmo2_pert2;

import java.io.File;
import java.io.FilenameFilter;

public class filter implements FilenameFilter {
    @Override
    public boolean accept(File file, String s) {
        return (s.endsWith(".mp3"));
    }
}
