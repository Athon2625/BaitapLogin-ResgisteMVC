package demospringboot.demo.controller.admin;

import java.util.List;

import demospringboot.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demospringboot.demo.entity.Video;
import demospringboot.demo.service.VideoService;

@Controller
@RequestMapping("admin/videos")
public class VideoController {

    @Autowired
    VideoService videoService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String list(ModelMap model){
        List<Video> list = videoService.findAll();
        model.addAttribute("videos", list);

        return "admin/videos/list";
    }

    @GetMapping("add")
    public String add(ModelMap model){
        model.addAttribute("video", new Video());
        return "admin/videos/add";
    }
    
    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @ModelAttribute("video") Video video) {
        videoService.save(video);
        model.addAttribute("message", "Video saved successfully");
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("edit/{videoId}")
    public ModelAndView edit(ModelMap model, @PathVariable("videoId") Long videoId) {
        Video video = videoService.findById(videoId);
        model.addAttribute("video", video);
        return new ModelAndView("admin/videos/edit", model);
    }

    @GetMapping("delete/{videoId}")
    public ModelAndView delete(ModelMap model, @PathVariable("videoId") Long videoId) {
        videoService.deleteById(videoId);
        model.addAttribute("message", "User is deleted!");
        return new ModelAndView("redirect:/index", model);
    }

    @RequestMapping("search")
    public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
        List<Video> videos;
        if (StringUtils.hasText(name)){
            videos = videoService.search(name);
        }
        else {
            videos = videoService.findAll();
        }
        model.addAttribute("videos", videos);
        return "admin/videos/list";
    }
}
