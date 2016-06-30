package cn.seands.file;

import java.io.File;
import java.util.List;

/**
 * Created by Seands on 2016/6/29.
 * 文件操作学习
 * File工具类
 */
public class FileUtils {


    /**
     * 将 dir目录下的所有目录和文件放到list中
     * @param dir
     * @param list
     * @return
     */
    public static List<File> listDirectory(File dir,List<File> list){
        if(dir==null||!dir.exists()||!dir.isDirectory()){
            throw new IllegalArgumentException("参数错误：----->"+dir+"\t参数为空或目录不存在或不是目录.");
        }
        File[] files = dir.listFiles();
        if(files!=null && files.length>0){
            for (File file : files){
                list.add(file);
                if(file.isDirectory()){
                    listDirectory(file,list);
                }
            }
        }
        return list;
    }



    public static void copyFile(File srcFile,File dir){
        if(srcFile==null || !srcFile.exists() || !srcFile.isFile()){
            throw new IllegalArgumentException("源文件参数错误：---> "+srcFile+"\t 参数为空或文件不存在或不是一个文件");
        }
        if(dir==null || !dir.exists() || !dir.isDirectory()){
            throw new IllegalArgumentException("目标文件夹参数错误：---> "+dir+"\t 参数为空或文件夹不存在或不是一个目录");
        }

    }


    public static void main(String[] args){
       /* List<File> list = new ArrayList<File>();
        FileUtils.listDirectory(new File("F:\\工作\\workspace\\MyTool\\src\\SwingTool"),list);
        for (File file: list){
            System.out.println(file);
        }*/

        File f = new File("D:\\新建文件夹");
        boolean fl = f.delete();//删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除。
        System.out.println(fl);

    }
}
