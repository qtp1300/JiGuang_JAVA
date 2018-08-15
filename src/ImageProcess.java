import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageProcess {
    List<MatOfPoint> contours;

    public Mat gray(Mat input_mat) {
        Mat pre_process_mat = input_mat;
        Mat processing_mat = new Mat();
//        Toast.makeText(getApplication(), "进入灰化", Toast.LENGTH_SHORT).show();
        /*处理流程*/
        Imgproc.cvtColor(pre_process_mat, processing_mat, Imgproc.COLOR_BGR2GRAY);
//        processing_mat = getCannyMat(pre_process_mat);
        return processing_mat;
    }

    public Mat canny(Mat input_mat) {
//        int th1 = Integer.parseInt(ShapeActivity.canny_th1.getText().toString());
//        int th2 = Integer.parseInt(ShapeActivity.canny_th2.getText().toString());

//        Log.i("th1","  "+th1);
        Mat processing_mat = new Mat();
        Mat processed_mat = new Mat();
//        Toast.makeText(getApplication(), "灰化->边缘检测", Toast.LENGTH_SHORT).show();
        Imgproc.cvtColor(input_mat, processing_mat, Imgproc.COLOR_BGR2GRAY);
//        Imgproc.Canny(processing_mat, processed_mat, th1, th2);
        Imgproc.Canny(processing_mat, processed_mat, 30, 200);
        return processed_mat;
    }

    public Mat canny_dilate(Mat input_mat) {
//        int th1 = Integer.parseInt(ShapeActivity.canny_th1.getText().toString());
//        int th2 = Integer.parseInt(ShapeActivity.canny_th2.getText().toString());
        Mat processing_mat = new Mat();
        Mat processed_mat = new Mat();
//        Toast.makeText(getApplication(), "灰化->边缘检测->膨胀", Toast.LENGTH_SHORT).show();

        /*处理流程*/
        Imgproc.cvtColor(input_mat, processing_mat, Imgproc.COLOR_BGR2GRAY);
//        Imgproc.Canny(processing_mat, processing_mat, th1, th2);
        Imgproc.Canny(processing_mat, processing_mat, 20, 100);
        Imgproc.dilate(processing_mat, processed_mat, new Mat());

        return processed_mat;
    }

    public Mat sample_fun(Mat input_mat) {
        Mat pre_process_mat;
        Mat processing_mat = new Mat();
        Mat processed_mat = new Mat();
//        Toast.makeText(getApplication(), "进入处理", Toast.LENGTH_SHORT).show();

        /*处理流程*/


        return processed_mat;
    }


    public Mat Contours(Mat input_mat) {
        Mat processing_mat;
        Mat processed_mat;
//        Toast.makeText(getApplication(), "灰化->边缘检测->边缘", Toast.LENGTH_SHORT).show();

        processing_mat = canny(input_mat);

        double mMinContourArea = 0.05;       //最小轮廓区域
        Mat hierarchy = new Mat();
        contours = new ArrayList<MatOfPoint>();        //ArrayList可以存放Object


        Imgproc.findContours(processing_mat, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_NONE);
        //学长Imgproc.CHAIN_APPROX_SIMPLE只取了拐点
        //hierarchy[i][后一个轮廓，前一个轮廓，父轮廓，内嵌轮廓]   的编号，没有相应内容的会被置-1,i与contours的编号对应。
//        double maxAr = 320 * 280 * 0.95;
        double maxAr = processing_mat.cols() * processing_mat.rows() * 0.95;
        double maxArea = 0;
        double mixArea = 0;
        Iterator<MatOfPoint> each = contours.iterator();        //1迭代器，依次取出contours内的各个轮廓
        while (each.hasNext()) {                                //3遍历轮廓集合，得到最大轮廓面积maxArea
            MatOfPoint wrapper = each.next();
            double area = Imgproc.contourArea(wrapper);         //2轮廓List中点的面积
//            Imgproc.contourArea(Mat类型的contours轮廓，顺时针还是逆时针)
            if (area > maxArea)
                maxArea = area;
            mixArea = maxArea;
        }
        System.out.println("maxArea:" + maxArea);
        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
        List<MatOfPoint> mContours = new ArrayList<MatOfPoint>();
        each = contours.iterator();
        while (each.hasNext()) {
            MatOfPoint contour = each.next();
            double area = Imgproc.contourArea(contour);
            if (area > mMinContourArea * maxArea && area < maxAr) {
                mContours.add(contour);
            }
        }
        System.out.println("添加完点的列表到mContours");
        processed_mat = new Mat(processing_mat.height(), processing_mat.width(), CvType.CV_8UC3);

        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
        Imgproc.drawContours(processed_mat, contours, -1, new Scalar(255, 0, 0), 1);         //自己加的，画不出来；画出来了

        return processed_mat;
    }

    public List<MatOfPoint> getContours() {
        return contours;
    }
}
