package org.ebook.cobook.fileUpload.persistence;

import org.ebook.cobook.fileUpload.domain.FilesVO;

public interface FilesDAO {

	public void insertFile(FilesVO vo)throws Exception;
	
	public void deleteFile(FilesVO vo)throws Exception;
	
	public void multiFile(String[] files, FilesVO filesVO)throws Exception;
}
