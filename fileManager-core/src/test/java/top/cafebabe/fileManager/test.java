package top.cafebabe.fileManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.cafebabe.fileManager.bean.Block;
import top.cafebabe.fileManager.bean.BlockFile;
import top.cafebabe.fileManager.manger.SimpleFileManager;
import top.cafebabe.fileManager.manger.integrator.Integrator;
import top.cafebabe.fileManager.manger.integrator.IntegratorFactory;
import top.cafebabe.fileManager.manger.integrator.SimpleIntegratorFactory;
import top.cafebabe.fileManager.manger.splitter.SimpleSplitterFactory;
import top.cafebabe.fileManager.manger.splitter.SplitterFactory;
import top.cafebabe.fileManager.manger.memory.MongodbMemory;

import java.io.*;

/**
 * @author cafababe
 */
public class test {

    private MongodbMemory memory;
    private SplitterFactory splitterFactory;
    private IntegratorFactory integratorFactory;
    private SimpleFileManager simpleFileManager;

    private String md5;
    private final String path = "/home/zh/a.pdf";
    private final String path1 = "/home/zh/b.pdf";

    @Before
    public void init() throws Exception {
        this.memory = new MongodbMemory("172.20.10.10", 27017, "file", "Admin@123", "file");
        this.splitterFactory = new SimpleSplitterFactory(1024 * 1024);
        this.integratorFactory = new SimpleIntegratorFactory();
        this.simpleFileManager = new SimpleFileManager(this.memory, this.splitterFactory, this.integratorFactory, true);
    }

    @After
    public void list() throws Exception {

        this.memory.list();
    }

    @Test
    public void add()throws Exception{
        this.simpleFileManager.addFile(new FileInputStream(this.path));
    }

    @Test
    public void get() throws Exception {

        Integrator file = this.simpleFileManager.getFile("24ae6d6e92cd324b1eeb67f3f5bd3d98");
        OutputStream os = new FileOutputStream(this.path1);
        while (file.hasNext()) {
            os.write(file.next());
        }
    }

    @Test
    public void delete() throws Exception{
        this.simpleFileManager.removeFile("24ae6d6e92cd324b1eeb67f3f5bd3d98");
    }

    @Test
    public void exist(){
        System.out.println(this.simpleFileManager.exist("24ae6d6e92cd324b1eeb67f3f5bd3d98"));
    }

}