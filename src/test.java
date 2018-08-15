import javax.swing.*;
import java.io.File;

public class test {
    public static void main(String[] args){
//        String test = "[dafsd]";
//        System.out.println(test);
//
//        System.out.println(test);

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("选择图片");
        jFileChooser.setCurrentDirectory(new File("./"));
        jFileChooser.showOpenDialog(null);
        File selectedfile = jFileChooser.getSelectedFile();
        String newName = "";
//        String[] ss = selectedfile.getName().split("[.]");
//        System.out.println("长度："+ss.length);
        newName = selectedfile.getName().split("[.]")[0]+".天培";
        MyFile myFile = new MyFile(selectedfile.getParent(),newName);
        System.out.println(myFile.write("fdsafs"));
        System.out.println(selectedfile.getParent()+"\\"+newName);
//        System.out.println("getParent:"+selectedfile.getParent()+"\tgetName:"+selectedfile.getName()+"\tgetPath:"+selectedfile.getPath());
    }
}
