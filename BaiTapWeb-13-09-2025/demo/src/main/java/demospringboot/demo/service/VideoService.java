package demospringboot.demo.service;

import java.util.List;
import demospringboot.demo.entity.Video; 


public interface VideoService {
    List<Video> findAll();
    Video save(Video video);
    void deleteById(Long id);
    List<Video> search(String keyword);
    Video findById(Long id);
}
