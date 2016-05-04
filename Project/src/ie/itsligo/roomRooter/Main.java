package ie.itsligo. roomRooter;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Main {

		static JTextField textField = null;
		static String filePath = "myQRCode.png";
		
		//Qrcode1
		//static String qrCodeData = "Day: Tuesday\nTime: 09:00 to 11:00\nSubject: Software Engineering\nRoom: E2004";
		
		//QRcode2
		//static String qrCodeData = "Day: Wenesday\nTime: 14:00 to 16:00\nSubject: Microcontroller Programming\nRoom: A0006";
		
		//QRcode3
		static String qrCodeData = "Day: Wednesday\nTime: 16:00 to 18:00\nSubject: Software Engineering\nRoom: B1002";
		
		
		static QR qr = new QR(qrCodeData, filePath);
		static Room room = new Room();
		static Directions directions = new Directions();
		static Day date = new Day();
		static Hour hour = new Hour();

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String[] args) throws WriterException, IOException, NotFoundException {
			// Initial hardcoded data for test program 
			//String qrCodeData = "Day: Tuesday\nTime: 09:00 to 11:00\nSubject: Software Engineering\nRoom: E2004";
			String filePath = "myQRCode.png";
			
			
			Map hintMap = new HashMap();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

			// create the QR barcode
			qr.createQRCode(qrCodeData, filePath, hintMap, 200, 200);
			System.out.println("QR Code image created successfully!");

			// read the barcode
			String QRdata = qr.readQRCode(filePath, hintMap);
			System.out.println("The barcode reads : " + QRdata);
			
			//Is it a QRCode the type we want
			String delims = "[\n]+";
			String[] tokens = QRdata.split(delims);
			
			String line0=tokens[0];
			String line1=tokens[1];
			String line2=tokens[2];
			String line3=tokens[3];
			String delims2 = "[ ]+";
			String[] line00 = line0.split(delims2);
			String[] line01 = line1.split(delims2);
			String[] line02 = line2.split(delims2);
			String[] line03 = line3.split(delims2);
			
			if((line00[0].equals("Day:")!=true)||(line01[0].equals("Time:")!=true)||(line02[0].equals("Subject:")!=true)||(line03[0].equals("Room:")!=true)){
				QRSound2.main('w');
				QRSound2.main('z');
				System.exit(0);
			}
			
			
			
			//Find the hour
			String thehour = hour.get(QRdata);
			//System.out.println("The hour is " + thehour);
			int Currenthour = Integer.parseInt(hour.hour);
			int QRhour = Integer.parseInt(thehour);
			
			//Find the day		
			String QRday = date.get(QRdata);
			System.out.println(QRday);
			System.out.println(date.Currentdate);
			
			if(date.Currentdate.equals(QRday)==true){
				System.out.println("The lesson is Today");
				QRSound2.main('Y');
				
				if(Currenthour==QRhour){
					System.out.println("You're late, hurry up");
					QRSound2.main('m');
				}
				else if(Currenthour>QRhour){
					String endhour = hour.get(QRdata);
					int QRhour2 = Integer.parseInt(endhour);
					if (Currenthour>QRhour2){
						System.out.println("It's too late, the lesson has allready ended");
						QRSound2.main('l');
					}
					else{
						System.out.println("You're more than 1 hour late =(");
						QRSound2.main('s');
					}
				}
				else {
					System.out.println("The lesson starts at " + QRhour);
					QRSound2.main('9');
				}
			}
			else{
				System.out.println("The lesson is not Today");
				QRSound2.main('N');
			}
			
			
			
			
			// Find the room
			String theRoom = room.get(QRdata);
			//System.out.println("The room is " + theRoom);
			
			// get directions
			if (directions.validate(theRoom) == false) {
				System.out.println("The directions to this room are unknown");
			}
			else {
				System.out.println("DIRECTIONS");
				System.out.println(directions.toBuilding());
				System.out.println(directions.toFloor());
				System.out.println(directions.toLocation());
			}
			
			
		}


}
