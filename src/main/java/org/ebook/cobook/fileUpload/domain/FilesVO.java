package org.ebook.cobook.fileUpload.domain;

import java.util.Arrays;

import org.apache.ibatis.type.Alias;

@Alias("FilesVO")
public class FilesVO {

	private Integer file_no;
	private String filename;
	private String fileurl;
	private Integer book_no;
	private String book_type;
	private String filetype;

	private String[] files;

	// 파일 등록,수정 하는경우에 파일 풀네임을 파싱하는 함수
	public void parsingFileData(String fullnameFile) {

			// 파일 url추출
			this.fileurl = fullnameFile.substring(fullnameFile.indexOf("=") + 1);
			// 파일 이름 추출
			this.filename = fileurl.substring(fileurl.indexOf("_") + 1);
			// 확장자 추출
			this.filetype = fileurl.substring(fileurl.indexOf(".") + 1);

	}

	@Override
	public String toString() {
		return "FilesVO [file_no=" + file_no + ", filename=" + filename + ", fileurl=" + fileurl + ", book_no="
				+ book_no + ", book_type=" + book_type + ", filetype=" + filetype + ", files=" + Arrays.toString(files)
				+ "]";
	}

	public Integer getFile_no() {
		return file_no;
	}

	public void setFile_no(Integer file_no) {
		this.file_no = file_no;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public Integer getBook_no() {
		return book_no;
	}

	public void setBook_no(Integer book_no) {
		this.book_no = book_no;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

}