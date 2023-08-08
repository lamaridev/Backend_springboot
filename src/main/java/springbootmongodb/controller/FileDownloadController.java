package springbootmongodb.controller;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileDownloadController {

    @GetMapping(value = "/demo-file-download")
    public ResponseEntity<byte[]> demo() { // (1) Return byte array response
        String demoContent = "This is dynamically generated content in demo file"; // (2) Dynamic content
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE); // (3) Content-Type: application/octet-stream
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename("demo-file.txt").build().toString()); // (4) Content-Disposition: attachment; filename="demo-file.txt"
        return ResponseEntity.ok().headers(httpHeaders).body(demoContent.getBytes()); // (5) Return Response
    }
}