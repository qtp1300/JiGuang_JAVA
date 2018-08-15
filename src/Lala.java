/*
 * ver1.0
 * 按照坐标遍历图形，找到需要打印的点
 * 此方法慢且不好看
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
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

//row行，也就是高
//col列，也就是宽

public class Lala {
    static {
        System.loadLibrary("opencv_java342");
    }


    public static void main(String[] args) {
        System.out.println("xzc");
        String imgString = "";
        int rate = 10;
        ImageProcess imageProcess = new ImageProcess();
//        JFrame jFrame = new JFrame("图片转换程序");
//        jFrame.setBounds(500,500,300,300);
//        jFrame.setVisible(true);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        JButton jButton = new JButton("打开图片");
//        jButton.setBounds(0,0,90,90);
//        jFrame.add(jButton);
//        jButton.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("cewcoiw");
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("akak");
//                Stage stage = null;
//                fileChooser.showOpenDialog(stage);
//            }
//        });


//        File file = new File("f:\\JAVA\\test1\\test1.png");
//        System.out.println(file.canRead());
//        try {
//            BufferedImage bufferedImage = ImageIO.read(file);
//            int imagetype = bufferedImage.getType();
//            int width = bufferedImage.getWidth();
//            int heigh = bufferedImage.getHeight();
//            System.out.println(Integer.toHexString(bufferedImage.getRGB(200,200)));
//            Mat mat = new Mat(10,10, CvType.CV_8UC1,new Scalar(0));
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("akak");
//                Stage stage = null;
//                fileChooser.showOpenDialog(stage);
//            }
//        });
//
//        thread.run();
//        fileChooser.setInitialDirectory("");
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
//        jFileChooser.

//        if ()
        if (selectedfile != null) {
            Mat src = Imgcodecs.imread(selectedfile.getPath());
//            Mat src = Imgcodecs.imread("F:\\JAVA\\test1\\test1.png");
            System.out.println("输入的图片宽为：" + src.width() + "\r\n输入的图片高为：" + src.height());
//            int[] ii =new int[src.channels()];
//            System.out.println("channels:"+src.channels());
//            System.out.println("type:"+src.type());
//            System.out.println("CvType.depth:"+CvType.depth(16));
//            Mat mat2 = new Mat(src.rows(),src.cols(),CvType.CV_8UC3);
//            src.copyTo(mat2);
//            mat2.get(1,1,ii);
//            src.g
            Mat grayedmat = imageProcess.canny(src);
            Mat resizedmat = grayedmat.clone();
            Imgproc.resize(grayedmat, resizedmat, new Size(src.width() * 10, src.height() * 10));
            System.out.println(resizedmat.cols() + "*" + resizedmat.rows());

//            imageProcess.canny()
//            Viewer viewer2 = new Viewer(src,"test");
//            viewer2.imshow();
            Viewer viewer = new Viewer(grayedmat, "二值化");
            viewer.imshow();
//            Viewer viewer3 = new Viewer(resizedmat,"重设大小");
//            viewer3.imshow();
//            System.out.println("grayedmat"+grayedmat.toString());
//            int row = 0;
//            int col = 0;
//            int rows = grayedmat.rows();
//        MatOfPoint matOfPoint = new MatOfPoint();
            Mat finalMat = grayedmat.clone();

            boolean nextInverse = false;
            for (int selectedRow = 0; selectedRow < finalMat.rows(); selectedRow++) {       //第几行
                System.out.println((((double) selectedRow / (double) (finalMat.rows())) * 100) + "%");
                if (nextInverse) {
                    for (int selectedCol = finalMat.cols()-1; selectedCol > 0; selectedCol--) {   //第几列
                        if (!(finalMat.col(selectedCol).row(selectedRow).dump().equals("[  0]"))) {
                            String selectedValue = finalMat.col(selectedCol).row(selectedRow).dump();
                            selectedValue = selectedValue.substring(1, selectedValue.length() - 1);

//                    System.out.println("x:"+selectedCol+"\ty:"+selectedRow+"\t"+selectedValue);
                            //重映射大小

//                    System.out.print(selectedCol+","+selectedRow+","+selectedValue+"\r\n");

                            imgString += selectedCol * rate + "," + selectedRow * rate + "," + selectedValue + "\r\n";
//                    System.out.println(grayedmat.col(selectedCol).row(selectedRow).dump());
                        }
                    }
                    nextInverse = false;
                } else {
                    for (int selectedCol = 0; selectedCol < finalMat.cols(); selectedCol++) {   //第几列
                        if (!(finalMat.col(selectedCol).row(selectedRow).dump().equals("[  0]"))) {
                            String selectedValue = finalMat.col(selectedCol).row(selectedRow).dump();
                            selectedValue = selectedValue.substring(1, selectedValue.length() - 1);

//                    System.out.println("x:"+selectedCol+"\ty:"+selectedRow+"\t"+selectedValue);
                            //重映射大小

//                    System.out.print(selectedCol+","+selectedRow+","+selectedValue+"\r\n");

                            imgString += selectedCol * rate + "," + selectedRow * rate + "," + selectedValue + "\r\n";
//                    System.out.println(grayedmat.col(selectedCol).row(selectedRow).dump());
                        }
                    }

                    nextInverse = true;

                }

            }


            String newName = "";
            newName = selectedfile.getName().split("[.]")[0] + ".天培";
            MyFile myFile = new MyFile(selectedfile.getParent(), newName);
            System.out.println(myFile.write(imgString));
            System.out.println(selectedfile.getParent() + "\\" + newName);


//        System.out.println(grayedmat.row(0).dump());
//        System.out.println(grayedmat.row(grayedmat.rows()-1).dump());
//        System.out.println(grayedmat.rows());

//            for (row = 0; row < grayedmat.rows();row++){
//                System.out.println(grayedmat.row(row).dump());
//            }

//            Mat newmat = new Mat(grayedmat.rows(),grayedmat.cols(),CvType.CV_8UC1);
//            grayedmat.convertTo(newmat,CvType.CV_8UC1);
//            newmat.get(2,2,ii);
//            grayedmat.get(2,2,ii);
//            System.out.println(Arrays.toString(ii));
        }
//        selectedfile.
//        System.out.println("getParent:"+selectedfile.getParent()+"\tgetName:"+selectedfile.getName()+"\tgetPath:"+selectedfile.getPath());


//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Image img = new BufferedImage();
//
//        Color color = new Color()

    }


}
