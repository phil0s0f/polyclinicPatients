package com.polyclinicpatients.polyclinicPatients.controllers;

import com.polyclinicpatients.polyclinicPatients.models.Post;
import com.polyclinicpatients.polyclinicPatients.rep.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class DoctorController {

    @Autowired
    private PostRepository postRepository;
    @GetMapping("/doctor")
    public String doctorMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "doctor-main";
    }
    @GetMapping("/doctor/add")
    public String doctorAdd(Model model) {
        return "doctor-add";
    }
    @PostMapping("/doctor/add")
    public String doctorPostAdd(@RequestParam String tetle,@RequestParam String anounce, @RequestParam String full_text, Model model){
        Post post = new Post(tetle, anounce, full_text);
        postRepository.save(post);
        return "redirect:/doctor";
    }
    @GetMapping("/doctor/{id}")
    public String doctorDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/doctor";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "doctor-details";
    }
    @GetMapping("/doctor/{id}/edit")
    public String doctorEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/doctor";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "doctor-edit";
    }
    @PostMapping("/doctor/{id}/edit")
    public String doctorPostUpdate(@PathVariable(value = "id") long id,@RequestParam String tetle,@RequestParam String anounce, @RequestParam String full_text, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTetle(tetle);
        post.setAnounce(anounce);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/doctor";
    }
    @PostMapping("/doctor/{id}/remove")
    public String doctorPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/doctor";
    }
}
