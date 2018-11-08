package com.caesar.aptlib;

import com.google.auto.service.AutoService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/11/8 22:05
 * email : yangshaopeng_it@163.com
 */

@AutoService(Processor.class)
@SupportedAnnotationTypes("butterknife.BindView")
public class AnnotationProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        System.out.print("yang 11111111111111");
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        //System.out.print("yang process");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\a.txt"));
            fileOutputStream.write("11111".getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
