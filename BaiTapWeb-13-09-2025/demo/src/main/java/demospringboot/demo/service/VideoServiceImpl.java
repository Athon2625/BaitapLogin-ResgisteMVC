package demospringboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import demospringboot.demo.entity.Video;
import demospringboot.demo.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }
    
    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void deleteById(Long id) {
        videoRepository.deleteById(id);
    }

    @Override
    public List<Video> search(String keyword) {
        return videoRepository.findByTitleContaining(keyword);
    }

    @Override
    public Video findById(Long id) {
        // TODO Auto-generated method stub
        return videoRepository.findById(id).orElse(null);
    }
}
