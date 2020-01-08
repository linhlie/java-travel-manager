package travel.manager.filestorage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageImpl  {
    private final Path rootLocation = Paths.get("D:\\TTCSCN\\java-travel-manager\\src\\main\\resources\\static\\images\\user");
	public String store(MultipartFile file){
		try {
            Path fp = rootLocation;
            Path p =fp.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(),p);
            String url = "images/user/"+file.getOriginalFilename();
            return url;
        } catch (Exception e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}

}