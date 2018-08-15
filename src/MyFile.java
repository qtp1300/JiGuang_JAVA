import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class MyFile {
    String Path = "";
    String Parent = "";
    String Name = "";
//    getParent()+"\tgetName:"+selectedfile.getName()
//    File file;
//    public MyFile(String path){
//        this.path = path;
//    }

    public MyFile(String Parent,String Name){
        this.Parent = Parent;
        this.Name = Name;
    }
    public void setPath(String path){
        this.Path = path;
    }
    public void setParent(String parent){
        this.Parent = parent;
    }

    public boolean write(String s){
        boolean writeSuscess = false;
//        file.setWritable(true);
//        OutputStream outputStream = file
        try {
//            file = File.cre
            FileWriter fileWriter = new FileWriter(Parent+"\\"+Name);
            fileWriter.write(s);
            fileWriter.flush();
            writeSuscess = true;
            fileWriter.close();
//            fileWriter.write();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return writeSuscess;
    }

//    public boolean canRead(){
//        boolean canRead = false;
//        file = new File(path);
//        canRead = file.canRead();
//        return canRead;
//    }
}
