package com.cafeatte.util.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

public class ImageResize {

	// imageResizing(업로드 Path, 이미지 파일명, 파일명 앞에 추가문자, 사이즈 조정 너비,사이즈 조정 높이)
	public static String imageResize(String imagePath, String fileName,
			String header, int x, int y)
			throws Exception {

		// 넘어온 데이터 확인 출력
		System.out.println("넘어온 데이터 확인 출력-----------------");
		System.out.println("imagePath : " + imagePath);
		System.out.println("filename : " + fileName);
		System.out.println("header : " + header);
		System.out.println("x : " + x);
		System.out.println("y : " + y);

		// 기본 값 처리
		if (header == null) {
			header = "";
		}

		// ---------------------------
		// 사이즈 조정을 할 원본 소스 이미지 파일 준비
		// ---------------------------
		// 그려 줄수 있는 이미지를 담는 객체 생성 -> ParameterBlock
		ParameterBlock pb = new ParameterBlock();
		// 원본 이미지를 담아 놓는다.
		pb.add(imagePath + "/" + fileName);
		RenderedOp rOp = JAI.create("fileload", pb);

		// 정해진 위치에 그림을 그리기 위해서 이미지를 정해진 메모리 위치에 저장해 놓는다.
		BufferedImage bi = rOp.getAsBufferedImage();
		
		// 새롭게 그려질 이미지 버퍼를 작성한다.
		BufferedImage thumb = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = thumb.createGraphics();

		// BufferedImage 에 원본 이미지 그려 넣기-- 메모리에서 작업
		g.drawImage(bi, 0, 0, x, y, null);

		// 새로 그려지는 그림 파일의 이름 = 앞에 붙일 문자+원래 파일명
		// 예를 들어서 리스트의 사용할 작은 파일인 경우 s_imgFile.jpg
		String newFileName = header + fileName;
		// 실제적으로 저장할 파일 정하기 -> 경로 + 파일명
		File file = new File(imagePath + "/" + newFileName);
		// 이미지 버퍼에 있는 내용을 파일로 저장하자.
		ImageIO.write(thumb, "jpg", file);

		System.out.println(imagePath + "/" + newFileName);
		System.out.println("------------------------------------");

		return newFileName;
	}// end of imageResizing()
}// end of ImageResizing class
