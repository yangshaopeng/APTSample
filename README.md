# APTSample
APT
# 1.概念
APT，全称Annotation Processor Tools，注解处理器，它是一种在编译期就能自动生成代码的工具。

随着越来越多的第三方框架都在使用这种技术，类似于Dagger2、ButterKnife等，所以为了能够更好的阅读源码，开发人员有必要去学习这种技术。

# 2.撸码
## 2.1.创建注解处理器
### 2.1.1.新建一个Java Library的Module，并创建文件。
```
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.caesar.aptannotation.TestAnno")
public class AnnotationProcessor extends AbstractProcessor {

    private Filer mFiler;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnvironment.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        MethodSpec main = MethodSpec.methodBuilder("main")
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
        .returns(void.class)
        .addParameter(String[].class, "args")
        .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
        .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
        .addMethod(main)
        .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
             .build();
        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
```
### 2.1.2.导入第三方框架
```
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.google.auto.service:auto-service:1.0-rc3'
    compile 'com.squareup:javapoet:1.11.1'
}
sourceCompatibility = "1.7"
targetCompatibility = "1.7"
```
## 2.2.创建注解的Java Library的Module
### 2.2.1.创建注解
```
@Target(TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface TestAnno {
}
```
这一步最简单（注解中的各个参数就不详细描述）。
## 2.3.使用
### 2.3.1.在app的gradle文件中导入新建的两个Module
```
annotationProcessor project(':APTCompile')
implementation project(":APTAnnotation")
```
### 2.3.2.使用注解修饰类
```
@TestAnno
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```
### 2.3.3.效果
rebuild项目，即可在 app/build/generated/source/apt/debug 目录下会自动生成想要的文件。

![](https://user-gold-cdn.xitu.io/2018/11/20/16731a49c4154f34?w=404&h=368&f=png&s=15604)
# 3.question && answer（原理）
## 3.1.导入auto-service和Javapoet的原因
- 注解处理器和Android的四大组件类似，在使用时需要注册，而Google提供了一个自动注册的框架，更加简化了注册的流程。
- 在自动生成文件的时候，square公司也提供了一个可更加方便生成文件的框架，对使用者来说也更加方便。
## 3.2.为什么新建的是Java Library，而不是Android Library？
因为AbstractProcessor只存在于rt.jar(jdk)中，而非Android的SDK中，所以apt只存在于java项目当中。而Android项目是可以引用java模块的。



[附上GitHub地址](https://github.com/yangshaopeng/APTSample)