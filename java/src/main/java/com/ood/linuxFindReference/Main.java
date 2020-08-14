package com.ood.linuxFindReference;

import java.io.IOException;

// 需要通过命令行提供参数，可以先打包成jar文件然后通过命令行执行
// 例如：
// java -jar find.jar . -name data.txt
// java -jar find.jar . -name \*.txt
// java -jar find.jar /Some/Path -maxdepth 3 -name \*.h -or -name \*.cpp
// java -jar find.jar /Some/Path \( -name \*.h -or -name \*.cpp \) -and -size +100K
public class Main {
    public static void main(String[] args) throws IOException {
        Executor exec = new ExecutionGenerator().generateExecutor(args);
        exec.Execute();
    }
}