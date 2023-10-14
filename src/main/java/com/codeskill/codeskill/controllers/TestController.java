package com.codeskill.codeskill.controllers;

        import com.codeskill.codeskill.models.Test;
        import com.codeskill.codeskill.services.TestService;
        import org.bson.types.ObjectId;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping("/tests")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping
    public List<Test> getAllTests(){
        return testService.getAllTests();
    }

    @GetMapping
    public List<Test> getTestsByCategoryIds(@RequestParam List<String> categoryIds){
        return testService.getTestsByCategoryIds(categoryIds);
    }

    @GetMapping("/{id}")
    public Optional<Test> getTestById(@PathVariable String id){
        return testService.getTestById(id);
    }


    @PostMapping
    public Test createTest(@RequestBody Test test, @RequestBody List<String> categoryIds){
        test.setCategoryIds(categoryIds);
        return testService.createTest(test);
    }

    @DeleteMapping ("/{id}")
    public void deleteTestById(@PathVariable String id){
        testService.deleteTestById(id);
    }
}
