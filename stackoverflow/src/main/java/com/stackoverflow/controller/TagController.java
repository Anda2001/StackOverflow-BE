package com.stackoverflow.controller;

import com.stackoverflow.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackoverflow.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    //read tags
    @GetMapping("/getAll")
    @ResponseBody
    public List<Tag> retrieveTags() {
        return (List<Tag>) tagService.retrieveTags();
    }

    //create tag
    @PostMapping("/create")
    @ResponseBody
    public Tag createTag(@RequestBody Tag tag){
        return tagService.createTag(tag);
    }

    //update tag
    @PutMapping("/update")
    @ResponseBody
    public Tag updateTag(@RequestBody Tag tag){
        return tagService.updateTag(tag);
    }

    //delete tag
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteTag(@RequestBody Tag tag){
        tagService.deleteTag(tag);
    }

    //read tag by name
    @GetMapping("/getByName/{name}")
    @ResponseBody
    public Tag retrieveTagByName(@PathVariable("name") String name) {
        return tagService.retrieveTagByName(name);
    }

    //read tag by question id
    @GetMapping("/getByQuestionId/{id}")
    @ResponseBody
    public List<Tag> retrieveTagByQuestionId(@PathVariable("id") int id) {
        return tagService.retrieveTagByQuestionId(id);
    }

}
