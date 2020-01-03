package travel.manager.filestorage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageImpl implements FileStorage{

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("resources/static/images/user");

 
	@Override
	public void store(MultipartFile file){
		try {
            Path fp = rootLocation;
            if (!Files.exists(fp)){
                Files.createDirectory(fp);
            }
            Path p =fp.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(),p);
        } catch (Exception e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}

}