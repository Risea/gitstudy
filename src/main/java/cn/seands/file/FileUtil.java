/**
 * 
 */
package cn.seands.file;
import java.io.*;
/**
 * @author Seands
 *
 */
public class FileUtil {


	
	/**
	 * 把源文件复制到目标文件夹中
	 * @param srcfile 	//源文件
	 * @param destdirfile  //目标文件目录
	 */
	public static void copyFile(File srcfile,File destdirfile){
		//如果源文件是目录或不存在，目标文件夹 是文件或不存在，无法创建
		if(srcfile==null||srcfile.isDirectory()
			||destdirfile.isFile()||destdirfile==null){
			System.out.println("copyfile无法复制！");
			return ;
		}
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			//创建buffer流通道
			bis = new BufferedInputStream(new FileInputStream(srcfile));
			bos = new BufferedOutputStream(new FileOutputStream(new File(destdirfile,srcfile.getName())));
			
			//建立缓冲区
			byte [] bybuff = new byte[1024*50];//一次50k;
			int len = -1;
			while((len = bis.read(bybuff))!=-1){
				bos.write(bybuff, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{        //关闭流
			try {
				bos.flush();
				bos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 把一个目录或文件复制到另一个目录中
	 */
	public static void copyFiles(File srcfile, File destdirfile){
		if(srcfile == null||destdirfile == null||destdirfile.isFile()){
			System.out.println("copyFiles无法复制！");
		}
		
		if(srcfile.isFile()){
			//如果srcfile是个文件
			copyFile(srcfile, destdirfile);
		}else if(srcfile.isDirectory()){
			//如果srcfile是个目录
			File f = new File(destdirfile,srcfile.getName());
			f.mkdir();//创建目录
			File [] files = srcfile.listFiles();//不能用f.listFiles..f只复制了目录,子文件夹还没复制
			for (File file : files) {//列出其子目录和文件
				copyFiles(file , f);
			}
		}
	}
	
	
	/**
	 * 删除文件
	 * @param srcFile
	 */
	public static void deleteFile(File srcFile){
		srcFile.delete();
	}
	
	
	/**
	 * 移动文件
	 * @param srcFile
	 * @param destdirFile
	 */
	public static void moveFile(File srcFile,File destdirFile){
		copyFile(srcFile, destdirFile);
		deleteFile(srcFile);
	}
	
	
	/**
	 * 移动目录
	 * @param srcFile
	 * @param destdirFile
	 */
	public static void moveFiles(File srcFile,File destdirFile){
		copyFiles(srcFile, destdirFile);
		deleteFile(srcFile);
	}
	
	
	/**
	 * 在file文件中查找(筛选)后缀名为suffix的文件
	 * @param file	源文件夹
	 * @param suffix 后缀名
	 * @return
	 */
	public static File[] findFile(File file,final String suffix){
		
		File [] files = file.listFiles(new FileFilter(){

			public boolean accept(File pathname) {
				String fileName = pathname.getName();
				if(fileName.endsWith(suffix))//内部类调用外部的常量
					return true;
				else 
					return false;
			}
		});
		
		return files;
	}
	
	
	
	
	
	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File[] files = findFile(new File("f:/doc文件"),".jpg");
		for (File file : files) {
			System.out.println(file.getName());
		}
		
	}*/

}
