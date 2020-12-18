package test;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.FileEditor;

class TestFileState {

    private FileEditor file;

    @BeforeEach
    public void before() {
        file = new FileEditor(new File("opgave"));
    }

    @Test
    public void testInitState() {
        Assertions.assertFalse(file.save());
    }

    @Test
    public void testNaarCleanState() {

        file.edit();

        //Van dirty naar clean
        Assertions.assertTrue(file.save());

        Assertions.assertFalse(file.save());
    }

    @Test
    public void testNaarDirtyState() {
        //Van clean naar dirty
    	Assertions.assertTrue(file.edit());

    	Assertions.assertFalse(file.edit());

        file.save();

        //Van clean naar dirty
        Assertions.assertTrue(file.edit());
    }
}
