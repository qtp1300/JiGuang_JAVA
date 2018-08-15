import serial.tools.list_ports
import sys
import time

port_list = serial.tools.list_ports.comports(include_links=True)
mega_2560_port = ""
foundFile = 0

if (len(port_list)) <= 0:
    print("没有找到串口")
else:
    i = 0
    while (i < len(port_list)):  # 遍历当前已有端口找到Mega2560串口
        port_num = port_list[i][0]
        device_name = port_list[i][1]
        i = i + 1
        if (device_name[0:17] == "Arduino Mega 2560"):
            mega_2560_port = port_num
            break

    if (mega_2560_port != ""):
        print(mega_2560_port)
        # com = serial.Serial("COM8", 9600)
        # com = serial.Serial("COM13", 9600)
        com = serial.Serial(mega_2560_port, 9600)     #//////////////////
        time.sleep(2);

        for i in range(1, len(sys.argv)):
            foundFile = 1
            print(sys.argv[i])
            if (i == 1):
                file_path = sys.argv[1]
                if (file_path[len(sys.argv[1]) - 3:len(sys.argv[1])] == ".天培"):
                    ProcessedImg = open(file_path, "r")
                    readed = ProcessedImg.read()
                    readeds = readed.split('\n')
                    print(len(readeds))
                    for pixel_int in range(0, len(readeds)):
                        time.sleep(0.5)
                        print("第%s个"%pixel_int)
                        baifenbi = pixel_int/len(readeds)*100
                        print(str(baifenbi)+"%")
                        bytts = bytes(readeds[pixel_int]+"E", encoding='utf-8')

                        print("开始发送")
                        write_status = com.write(bytts);
                        print("发送完毕:\t" + str(write_status)+"\t个字符")
                        while(1):
                            lala = str(com.readline())
                            print("lala:\t"+lala)
                            if(lala.find("b'getted") != -1):
                                print("收到返回信号")
                                lala = ""
                                break
                            else:
                                print("wait——没找到返回的接受到信号")
                                time.sleep(1)
                        print("本次完成")
                    com.write(bytes("end", encoding='utf-8'))
        if(foundFile == 0):
            print("没有找到文件")
    else:
        print("没有找到雕刻机")
