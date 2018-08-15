/*
 * ver1.1
 * 下个版本按照轮廓找到点，实现沿线打印
 *
 */

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import oracle.jrockit.jfr.JFR;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import sun.rmi.runtime.Log;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.html.ImageView;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//row行，也就是高
//col列，也就是宽

public class Lala1_1 {
    static {
        System.loadLibrary("opencv_java342");
    }


    public static void main(String[] args) {
        System.out.println("xzc");
        String imgString = "";
        int rate = 10;
        ImageProcess imageProcess = new ImageProcess();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("选择图片");
        jFileChooser.setFileFilter(new FileFilter() {
            public boolean accept(File f) {
                if (f.getName().endsWith(".png") || f.isDirectory()) {
                    return true;
                }
                return false;
            }

            public String getDescription() {
                return "PNG图片(*.png)";
            }
        });
        jFileChooser.setCurrentDirectory(new File("./"));
        jFileChooser.showOpenDialog(null);
        File selectedfile = jFileChooser.getSelectedFile();
        if (selectedfile != null) {
            Mat src = Imgcodecs.imread(selectedfile.getPath());
//            Mat src = Imgcodecs.imread("F:\\JAVA\\test1\\test1.png");
            System.out.println("输入的图片宽为：" + src.width() + "\r\n输入的图片高为：" + src.height());

            Mat contourmat = imageProcess.Contours(src);
            List<MatOfPoint> contours = imageProcess.getContours();
            Iterator<MatOfPoint> each = contours.iterator();
            while (each.hasNext()){
                org.opencv.core.Point[] points = each.next().toArray();
                for (int i = 0;i < points.length;i++){
                    imgString += (int) points[i].x * rate + "," + (int) points[i].y * rate + "," + 255 + "\r\n";
//                    System.out.println((int) points[i].x * rate + "," + (int) points[i].y * rate + "," + 255 + "\r\n");
                }

            }

            Viewer viewer4 = new Viewer(contourmat,"coutour");
            viewer4.imshow();

            String newName = "";
            newName = selectedfile.getName().split("[.]")[0] + ".天培";
            MyFile myFile = new MyFile(selectedfile.getParent(), newName);
            System.out.println(myFile.write(imgString));
            System.out.println(selectedfile.getParent() + "\\" + newName);
            System.out.println("Over");
            System.exit(0);
        }
    }
}
