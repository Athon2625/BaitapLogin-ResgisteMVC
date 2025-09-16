package demospringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import demospringboot.demo.entity.Video;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByTitleContaining(String title);
    Page<Video> findByTitleContaining(String title, Pageable pageable);
}

