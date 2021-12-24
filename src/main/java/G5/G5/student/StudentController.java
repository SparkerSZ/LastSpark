package G5.G5.student;


import G5.G5.student.repo.StudentRepository;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @GetMapping
    public List<Student> getStudents() {

        List<Student> list = studentRepository.findAll();

        return list;

    }

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadS3(@RequestParam(required = true) MultipartFile file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());
        objectMetadata.setContentLength(file.getSize());
        try {
            String key = System.currentTimeMillis() + file.getOriginalFilename();
            System.out.println("key=="+key);
            PutObjectResult result = amazonS3.putObject(new PutObjectRequest(bucketName, key, file.getInputStream(), objectMetadata));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("success");
    }

    @GetMapping(value = "/getUrl")
    private String downloadFile(String key){
        try {
            if(StringUtils.isEmpty(key)){
                return null;
            }
            GeneratePresignedUrlRequest httpRequest = new GeneratePresignedUrlRequest(bucketName, key);
            return amazonS3.generatePresignedUrl(httpRequest).toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
