package travel.manager.filestorage;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {
	public void store(MultipartFile file);

}