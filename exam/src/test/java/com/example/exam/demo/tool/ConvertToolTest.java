package com.example.exam.demo.tool;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ConvertToolTest {

    @Test
    public void convertFileToJson() {
        ConvertTool.convertFileToJson(new File("sample_1.sdf"));
    }
}