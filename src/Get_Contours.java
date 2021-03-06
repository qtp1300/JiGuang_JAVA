//import android.util.Log;
//import android.widget.Toast;
//
//import org.opencv.core.CvType;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfPoint;
//import org.opencv.core.MatOfPoint2f;
//import org.opencv.core.Point;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.core.Size;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.utils.Converters;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class Get_Contours {
//
//    public Mat gray(Mat input_mat) {
//        Mat pre_process_mat = input_mat;
//        Mat processing_mat = new Mat();
////        Toast.makeText(getApplication(), "进入灰化", Toast.LENGTH_SHORT).show();
//        /*处理流程*/
//        Imgproc.cvtColor(pre_process_mat, processing_mat, Imgproc.COLOR_BGR2GRAY);
////        processing_mat = getCannyMat(pre_process_mat);
//        return processing_mat;
//    }
//
//    public Mat canny(Mat input_mat) {
//        int th1 = Integer.parseInt(ShapeActivity.canny_th1.getText().toString());
//        int th2 = Integer.parseInt(ShapeActivity.canny_th2.getText().toString());
////        Log.i("th1","  "+th1);
//        Mat processing_mat = new Mat();
//        Mat processed_mat = new Mat();
////        Toast.makeText(getApplication(), "灰化->边缘检测", Toast.LENGTH_SHORT).show();
//        Imgproc.cvtColor(input_mat, processing_mat, Imgproc.COLOR_BGR2GRAY);
////        Imgproc.Canny(processing_mat, processed_mat, th1, th2);
//        Imgproc.Canny(processing_mat, processed_mat, 20, 100);
//        return processed_mat;
//    }
//
//    public Mat canny_dilate(Mat input_mat) {
////        int th1 = Integer.parseInt(ShapeActivity.canny_th1.getText().toString());
////        int th2 = Integer.parseInt(ShapeActivity.canny_th2.getText().toString());
//        Mat processing_mat = new Mat();
//        Mat processed_mat = new Mat();
////        Toast.makeText(getApplication(), "灰化->边缘检测->膨胀", Toast.LENGTH_SHORT).show();
//
//        /*处理流程*/
//        Imgproc.cvtColor(input_mat, processing_mat, Imgproc.COLOR_BGR2GRAY);
////        Imgproc.Canny(processing_mat, processing_mat, th1, th2);
//        Imgproc.Canny(processing_mat, processing_mat, 20, 100);
//        Imgproc.dilate(processing_mat, processed_mat, new Mat());
//
//        return processed_mat;
//    }
//
//    public Mat sample_fun(Mat input_mat) {
//        Mat pre_process_mat;
//        Mat processing_mat = new Mat();
//        Mat processed_mat = new Mat();
////        Toast.makeText(getApplication(), "进入处理", Toast.LENGTH_SHORT).show();
//
//        /*处理流程*/
//
//
//        return processed_mat;
//    }
//
//    public Mat Contours(Mat input_mat) {
//        Mat processing_mat;
//        Mat processed_mat = new Mat();
////        Toast.makeText(getApplication(), "灰化->边缘检测->边缘", Toast.LENGTH_SHORT).show();
//
//        processing_mat = canny(input_mat);
//
//        double mMinContourArea = 0.1;       //最小轮廓区域
//        Mat hierarchy = new Mat();
//        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();        //ArrayList可以存放Object
//
////        Mat test = new Mat(input_mat.height(),input_mat.width(),CvType.CV_8UC3);
////        input_mat.convertTo(test,CvType.CV_8UC1);
////        Log.i("需要识别的Mat类型是：",""+test.type());
////        CvType.CV_8UC1
//
//        Imgproc.findContours(processing_mat, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
//        //学长Imgproc.CHAIN_APPROX_SIMPLE只取了拐点
//        //hierarchy[i][后一个轮廓，前一个轮廓，父轮廓，内嵌轮廓]   的编号，没有相应内容的会被置-1,i与contours的编号对应。
////        double maxAr = 320 * 280 * 0.95;
//        double maxAr = 640 * 360 * 0.95;
//        double maxArea = 0;
//        double mixArea = 0;
//        Iterator<MatOfPoint> each = contours.iterator();        //1迭代器，依次取出contours内的各个轮廓
//        while (each.hasNext()) {                                //3遍历轮廓集合，得到最大轮廓面积maxArea
//            MatOfPoint wrapper = each.next();
//            double area = Imgproc.contourArea(wrapper);         //2轮廓List中点的面积
////            Imgproc.contourArea(Mat类型的contours轮廓，顺时针还是逆时针)
//            if (area > maxArea)
//                maxArea = area;
//            mixArea = maxArea;
//        }
//        Log.i("maxArea:", "" + maxArea);
//        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
//        List<MatOfPoint> mContours = new ArrayList<MatOfPoint>();
//        each = contours.iterator();
//        while (each.hasNext()) {
//            MatOfPoint contour = each.next();
//            double area = Imgproc.contourArea(contour);
//            if (area > mMinContourArea * maxArea && area < maxAr) {
//                mContours.add(contour);
//            }
//        }
//        Log.i("添加完点的列表到mContours", "");
//        processed_mat = new Mat(processing_mat.height(), processing_mat.width(), CvType.CV_8UC3);
//
//        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
//        Imgproc.drawContours(processed_mat, mContours, -1, new Scalar(255, 0, 0), 1);         //自己加的，画不出来；画出来了
//
//
////        MatOfPoint2f approxCurve = new MatOfPoint2f();
////        List<MatOfPoint> mContour2 = new ArrayList<MatOfPoint>();
////        each = mContours.iterator();
////        while (each.hasNext()) {
////            MatOfPoint contour = each.next();
////            MatOfPoint2f new_mat = new MatOfPoint2f( contour.toArray() );       //把轮廓的点转化为数组并以数组建立新的MatOfPoint对象new_mat
////            Imgproc.approxPolyDP(new_mat, approxCurve, 30, true);
////            //Imgproc.approxPolyDP(输入的轮廓点的点集，输出的多边形点集，输出精度——和另一个轮廓点的最大距离数，输出的多边形是否闭合)
////            long total  = approxCurve.total();      //边的数量？
////            if (total == 4 ) {
////                MatOfPoint contour2 = new MatOfPoint(approxCurve.toArray());       //把边的点集转化为MatOfPoint
////                mContour2.add(contour2);        //把点集的MatOfPoint加入列表mContour2
////            }
////        }
//
//        return processed_mat;
//    }
//
//    public Mat dilate_Contours(Mat input_mat) {
//        Mat processing_mat;
//        Mat processed_mat = new Mat();
////        Toast.makeText(getApplication(), "灰化->边缘检测->膨胀->边缘", Toast.LENGTH_SHORT).show();
//
//        processing_mat = canny_dilate(input_mat);
//
//        double mMinContourArea = 0.1;       //最小轮廓区域
//        Mat hierarchy = new Mat();
//        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();        //ArrayList可以存放Object
//
//
//        Imgproc.findContours(processing_mat, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
//        //学长Imgproc.CHAIN_APPROX_SIMPLE只取了拐点
//        //hierarchy[i][后一个轮廓，前一个轮廓，父轮廓，内嵌轮廓]   的编号，没有相应内容的会被置-1,i与contours的编号对应。
//        double maxAr = 320 * 280 * 0.95;
//        double maxArea = 0;
//        double mixArea = 0;
//        Iterator<MatOfPoint> each = contours.iterator();        //1迭代器，依次取出contours内的各个轮廓
//        while (each.hasNext()) {                                //3遍历轮廓集合，得到最大轮廓面积maxArea
//            MatOfPoint wrapper = each.next();
//            double area = Imgproc.contourArea(wrapper);         //2轮廓List中点的面积
////            Imgproc.contourArea(Mat类型的contours轮廓，顺时针还是逆时针)
//            if (area > maxArea)
//                maxArea = area;
//            mixArea = maxArea;
//        }
//        Log.i("maxArea:", "" + maxArea);
//        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
//        List<MatOfPoint> mContours = new ArrayList<MatOfPoint>();
//        each = contours.iterator();
//        while (each.hasNext()) {
//            MatOfPoint contour = each.next();
//            double area = Imgproc.contourArea(contour);
//            if (area > mMinContourArea * maxArea && area < maxAr) {
//                mContours.add(contour);
//            }
//        }
//        Log.i("添加完点的列表到mContours", "数量是:" + mContours.size() + "  分别是" + mContours.toString());
//        processed_mat = new Mat(processing_mat.height(), processing_mat.width(), CvType.CV_8UC3);
//
//        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
//        Imgproc.drawContours(processed_mat, mContours, -1, new Scalar(255, 0, 0), 1);         //自己加的，画不出来；
//
//        return processed_mat;
//    }
//
//    public Mat dilate_Contours_rectandle(Mat input_mat) {           //得到显示屏外轮廓
//        Mat processing_mat;
//        Mat processed_mat = new Mat();
////        Toast.makeText(getApplication(), "灰化->边缘检测->膨胀->边缘", Toast.LENGTH_SHORT).show();
//
//        processing_mat = canny_dilate(input_mat);
//
//        double mMinContourArea = 0.1;       //最小轮廓区域
//        Mat hierarchy = new Mat();
//        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();        //ArrayList可以存放Object
//
//        Imgproc.findContours(processing_mat, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
//        //学长Imgproc.CHAIN_APPROX_SIMPLE只取了拐点
//        //hierarchy[i][后一个轮廓，前一个轮廓，父轮廓，内嵌轮廓]   的编号，没有相应内容的会被置-1,i与contours的编号对应。
//        double maxAr = 320 * 280 * 0.95;
//        double maxArea = 0;
//        double mixArea = 0;
//        Iterator<MatOfPoint> each = contours.iterator();        //1迭代器，依次取出contours内的各个轮廓
//        while (each.hasNext()) {                                //3遍历轮廓集合，得到最大轮廓面积maxArea
//            MatOfPoint wrapper = each.next();
//            double area = Imgproc.contourArea(wrapper);         //2轮廓List中点的面积
////            Imgproc.contourArea(Mat类型的contours轮廓，顺时针还是逆时针)
//            if (area > maxArea)
//                maxArea = area;
//            mixArea = maxArea;
//        }
//        Log.i("maxArea:", "" + maxArea);
//        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
//        List<MatOfPoint> mContours = new ArrayList<MatOfPoint>();
//        each = contours.iterator();
//        while (each.hasNext()) {
//            MatOfPoint contour = each.next();
//            double area = Imgproc.contourArea(contour);
//            if (area > mMinContourArea * maxArea && area < maxAr) {
//                mContours.add(contour);
//            }
//        }
//        Log.i("添加完点的列表到mContours", "数量是:" + mContours.size() + "  分别是" + mContours.toString());
//        processed_mat = new Mat(processing_mat.height(), processing_mat.width(), CvType.CV_8UC3);
//
//        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
////        Imgproc.drawContours(processed_mat,mContours,-1,new Scalar( 255,0, 0),1);         //自己加的，画出找到的所有轮廓
//
//        MatOfPoint2f approxCurve = new MatOfPoint2f();
//        List<MatOfPoint> mContour2 = new ArrayList<MatOfPoint>();
//        each = mContours.iterator();
//        while (each.hasNext()) {
//            MatOfPoint contour = each.next();
//            MatOfPoint2f new_mat = new MatOfPoint2f(contour.toArray());       //把轮廓的点转化为数组并以数组建立新的MatOfPoint对象new_mat
//            Imgproc.approxPolyDP(new_mat, approxCurve, 30, true);
//
//            //Imgproc.approxPolyDP(输入的轮廓点的点集，输出的多边形点集，输出精度——和另一个轮廓点的最大距离数，输出的多边形是否闭合)
//            long total = approxCurve.total();      //边的数量？   确定，边的数量
////            Log.i("approxCurve",approxCurve.toString());
////            Log.i("approxCurve.total",total+"");
//            if (total == 4) {                                  //找到四边形
//                MatOfPoint contour2 = new MatOfPoint(approxCurve.toArray());       //把边的点集转化为MatOfPoint
//                mContour2.add(contour2);        //把点集的MatOfPoint加入列表mContour2，四边形的集合
//            }
//        }
//
//
//        Iterator<MatOfPoint> each2 = mContour2.iterator();      //把轮廓的集进行迭代，找到宽高比例在1到2之间的矩形，实际显示屏比例为1.7222
//        MatOfPoint mContour3 = null;
//        while (each2.hasNext()) {
//            MatOfPoint wrapper = each2.next();
//            double area = Imgproc.contourArea(wrapper);     //计算轮廓面积
//            List<Point> pointList = wrapper.toList();       //把轮廓转化为List
//            Log.i("pointList内容", pointList.toString());
//            double width = Math.abs(pointList.get(2).x - pointList.get(0).x);
//            double height = Math.abs(pointList.get(2).y - pointList.get(0).y);
//            float b1 = ((float) width / (float) height);
//            Log.i("pointList宽高比例", b1 + "");
//
//            if (b1 > 1 && b1 < 2) {
//                if (area < mixArea) {
//                    mixArea = area;                 //取最小轮廓，很具前面处理，这里一般会是显示屏外轮廓
//                    mContour3 = wrapper;
//                }
//            }
//        }
////        return mContour3;
//        if (mContour3 == null || mContour3.empty()) {
//            Log.i("mContour3是否为空", "为空");      //这里可能获取不到，要加保护//warning
//            return processing_mat;
//        } else {
//            Log.i("mContour3是否为空", "不空");
//            List<MatOfPoint> disp = new ArrayList<MatOfPoint>();
//            disp.add(mContour3);
//            Imgproc.drawContours(processed_mat, disp, -1, new Scalar(0, 255, 0), 1);
//            Log.i("mContour3输出", processed_mat.toString());
//        }
////        mContour3.convertTo(processed_mat,CvType.CV_8UC3);
//        return processed_mat;
//    }
//
//    public Mat Contours_rectandle_get_point_FullScreen(Mat input_mat) {           //得到显示屏外轮廓\\\\\\\的外围坐标
//        Mat processing_mat;
//        Mat processed_mat = new Mat();
////        Toast.makeText(getApplication(), "灰化->边缘检测->膨胀->边缘->四边形->变形全屏", Toast.LENGTH_SHORT).show();
//
//        processing_mat = canny_dilate(input_mat);
//
//        double mMinContourArea = 0.1;       //最小轮廓区域
//        Mat hierarchy = new Mat();
//        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();        //ArrayList可以存放Object
//
//        Imgproc.findContours(processing_mat, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
//        //学长Imgproc.CHAIN_APPROX_SIMPLE只取了拐点
//        //hierarchy[i][后一个轮廓，前一个轮廓，父轮廓，内嵌轮廓]   的编号，没有相应内容的会被置-1,i与contours的编号对应。
//        double maxAr = 320 * 280 * 0.95;
//        double maxArea = 0;
//        double mixArea = 0;
//        Iterator<MatOfPoint> each = contours.iterator();        //1迭代器，依次取出contours内的各个轮廓
//        while (each.hasNext()) {                                //3遍历轮廓集合，得到最大轮廓面积maxArea
//            MatOfPoint wrapper = each.next();
//            double area = Imgproc.contourArea(wrapper);         //2轮廓List中点的面积
////            Imgproc.contourArea(Mat类型的contours轮廓，顺时针还是逆时针)
//            if (area > maxArea)
//                maxArea = area;
//            mixArea = maxArea;
//        }
//        Log.i("maxArea:", "" + maxArea);
//        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
//        List<MatOfPoint> mContours = new ArrayList<MatOfPoint>();
//        each = contours.iterator();
//        while (each.hasNext()) {
//            MatOfPoint contour = each.next();
//            double area = Imgproc.contourArea(contour);
//            if (area > mMinContourArea * maxArea && area < maxAr) {
//                mContours.add(contour);
//            }
//        }
//        Log.i("添加完点的列表到mContours", "数量是:" + mContours.size() + "  分别是" + mContours.toString());
//        processed_mat = new Mat(processing_mat.height(), processing_mat.width(), CvType.CV_8UC3);
//
//        /*新建一个List列表，遍历得到大于0.1*最大面积且小于最大面积的集合mContours*/
////        Imgproc.drawContours(processed_mat,mContours,-1,new Scalar( 255,0, 0),1);         //自己加的，画出找到的所有轮廓
//
//        MatOfPoint2f approxCurve = new MatOfPoint2f();
//        List<MatOfPoint> mContour2 = new ArrayList<MatOfPoint>();
//        each = mContours.iterator();
//        while (each.hasNext()) {
//            MatOfPoint contour = each.next();
//            MatOfPoint2f new_mat = new MatOfPoint2f(contour.toArray());       //把轮廓的点转化为数组并以数组建立新的MatOfPoint对象new_mat
//            Imgproc.approxPolyDP(new_mat, approxCurve, 30, true);
//
//            //Imgproc.approxPolyDP(输入的轮廓点的点集，输出的多边形点集，输出精度——和另一个轮廓点的最大距离数，输出的多边形是否闭合)
//            long total = approxCurve.total();      //边的数量？   确定，边的数量
////            Log.i("approxCurve",approxCurve.toString());
////            Log.i("approxCurve.total",total+"");
//            if (total == 4) {                                  //找到四边形
//                MatOfPoint contour2 = new MatOfPoint(approxCurve.toArray());       //把边的点集转化为MatOfPoint
//                mContour2.add(contour2);        //把点集的MatOfPoint加入列表mContour2，四边形的集合
//            }
//        }
//
//
//        Iterator<MatOfPoint> each2 = mContour2.iterator();      //把轮廓的集进行迭代，找到宽高比例在1到2之间的矩形，实际显示屏比例为1.7222
//        MatOfPoint mContour3 = null;
//        while (each2.hasNext()) {
//            MatOfPoint wrapper = each2.next();
//            double area = Imgproc.contourArea(wrapper);     //计算轮廓面积
//            List<Point> pointList = wrapper.toList();       //把轮廓转化为List
//            Log.i("pointList内容", pointList.toString());
//            double width = Math.abs(pointList.get(2).x - pointList.get(0).x);
//            double height = Math.abs(pointList.get(2).y - pointList.get(0).y);
//            float b1 = ((float) width / (float) height);
//            Log.i("pointList宽高比例", b1 + "");
//
//            if (b1 > 1 && b1 < 2) {
//                if (area < mixArea) {
//                    mixArea = area;                 //取最小轮廓，很具前面处理，这里一般会是显示屏外轮廓
//                    mContour3 = wrapper;
//                }
//            }
//        }
//        if (mContour3 == null || mContour3.empty()) {
////            Log.i("mContour3是否为空","为空");      //这里可能获取不到，要加保护//warning
//            Log.i("没找到合适比例的轮廓","");
////            Toast.makeText(getApplication(),"没找到合适比例的轮廓",Toast.LENGTH_SHORT).show();
//            Imgproc.drawContours(processed_mat, mContours, -1, new Scalar(0, 0, 255), 1);         //自己加的，画出找到的所有轮廓
////            return null;
//        } else {
////            Log.i("mContour3是否为空","不空");
////            Toast.makeText(getApplication(),"找到合适比例的轮廓"+mContour3.toString(),Toast.LENGTH_SHORT).show();
//            Log.i("找到合适比例的轮廓",mContour3.toString());
////            List<MatOfPoint>disp = new ArrayList<MatOfPoint>();
////            disp.add(mContour3);
////            Imgproc.drawContours(processed_mat,disp,-1,new Scalar( 0,255, 0),1);
////            Log.i("mContour3输出",processed_mat.toString());
//            Rect imageTureRect = null;
//            Mat dstImage = null;
//            imageTureRect = get_min_screen_point(mContour3);
////        MatOfPoint mContourtrue = null;
//            List<MatOfPoint> outcontourList = new ArrayList<MatOfPoint>();
//            outcontourList.add(mContour3);                     //新建一个List<MatOfPoint>，把之前返回的显示器外轮廓的MatOfPoint加入List，绘画出来
//            Mat mat4 = new Mat(imageTureRect.height, imageTureRect.width, CvType.CV_8UC3);     //新建一个与外框相同大小的Mat
//            input_mat.copyTo(mat4);                            //将原图像复制过来
//            processed_mat = new Mat(imageTureRect.height, imageTureRect.width, CvType.CV_8UC3);      //新建一个与外框相同大小的Mat
//            warpPersMat(mat4, processed_mat, mContour3);
//        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//        return processed_mat;
//    }
//
//    private void warpPersMat(Mat src, Mat dst, MatOfPoint matPoint)//(摄像头原图，空的图，最小屏幕外框点列表)
//    {
//        int resultWidth = src.width();
//        int resultHeight = src.height();
//        Point[] poitI = matPoint.toArray();
//        Point[] poitII = matPoint.toArray();
//
//        /*真实截取到的轮廓坐标*/
//        double mixNum = poitI[0].x + poitI[0].y;
//        double maxNum = poitI[0].x + poitI[0].y;
//        double mixSub = poitI[0].x - poitI[0].y;
//        double maxSub = poitI[0].x - poitI[0].y;
//        for (int j = 0; j < poitII.length; j++) {
//            double num = poitII[j].x + poitII[j].y;
//            double sub = poitII[j].x - poitII[j].y;
//            if (num >= maxNum) {
//                maxNum = num;
//                poitI[2] = poitII[j];
//            }
//            if (num <= mixNum) {
//                mixNum = num;
//                poitI[0] = poitII[j];
//            }
//            if (sub >= maxSub) {
//                poitI[3] = poitII[j];
//                maxSub = sub;
//            }
//            if (sub <= mixSub) {
//                poitI[1] = poitII[j];
//                mixSub = sub;
//            }
//        }
//
//        Point ocvPIn1 = new Point(poitI[0].x, poitI[0].y);
//        Point ocvPIn2 = new Point(poitI[1].x, poitI[1].y);
//        Point ocvPIn3 = new Point(poitI[2].x, poitI[2].y);
//        Point ocvPIn4 = new Point(poitI[3].x, poitI[3].y);
//        List<Point> source = new ArrayList<Point>();
//        source.add(ocvPIn1);
//        source.add(ocvPIn2);
//        source.add(ocvPIn3);
//        source.add(ocvPIn4);
//        Mat startM = Converters.vector_Point2f_to_Mat(source);
//        /*真实截取到的轮廓坐标*/
//
//        /*要显示的图片大小*/
//        Point ocvPOut1 = new Point(0, 0);
//        Point ocvPOut2 = new Point(0, resultHeight);
//        Point ocvPOut3 = new Point(resultWidth, resultHeight);
//        Point ocvPOut4 = new Point(resultWidth, 0);
//        List<Point> dest = new ArrayList<Point>();
//        dest.add(ocvPOut1);
//        dest.add(ocvPOut2);
//        dest.add(ocvPOut3);
//        dest.add(ocvPOut4);
//        Mat endM = Converters.vector_Point2f_to_Mat(dest);
//        Mat perspectiveTransform = Imgproc.getPerspectiveTransform(startM, endM);       //根据输入点和输出点得到透视变换矩阵
//        //注意 此Mat  perspectiveTransform是形变矩阵，不包含实际图像或坐标/像素信息
//        Imgproc.warpPerspective(src,
//                dst,
//                perspectiveTransform,
//                new Size(resultWidth, resultHeight),
//                Imgproc.INTER_CUBIC);
//    }
//
//    private Rect get_min_screen_point(MatOfPoint matPoint) {
//        double pointD = 1;
//        Point[] poitI = matPoint.toArray();
//        Point[] poitII = matPoint.toArray();
//
//
//        double mixNum = poitI[0].x + poitI[0].y;
//        double maxNum = poitI[0].x + poitI[0].y;
//        double mixSub = poitI[0].x - poitI[0].y;
//        double maxSub = poitI[0].x - poitI[0].y;
//        for (int j = 0; j < poitII.length; j++) {
//            double num = poitII[j].x + poitII[j].y;
//            double sub = poitII[j].x - poitII[j].y;
//            if (num > maxNum) {
//                maxNum = num;
//                poitI[2] = poitII[j];
//            }
//            if (num < mixNum) {
//                mixNum = num;
//                poitI[0] = poitII[j];
//            }
//            if (sub > maxSub) {
//                poitI[3] = poitII[j];
//                maxSub = sub;
//            }
//            if (sub < mixSub) {
//                poitI[1] = poitII[j];
//                mixSub = sub;
//            }
//        }
//        double startX = poitI[0].x;
//        double startY = poitI[0].y;
//        double endX = poitI[2].x;
//        double endY = poitI[2].y;
//        if (poitI[0].x < poitI[1].x) {
//            startX = poitI[1].x;
//        }
//        if (poitI[3].x < poitI[2].x) {
//            endX = poitI[2].x;
//        }
//        if (poitI[1].y < poitI[2].y) {
//            endY = poitI[1].y;
//        }
//        if (poitI[0].y < poitI[3].y) {
//            startY = poitI[3].y;
//        }
//        return new Rect(new Point(startX + pointD, startY + pointD), new Point(endX - pointD, endY - pointD));
//    }
//
//
//}
