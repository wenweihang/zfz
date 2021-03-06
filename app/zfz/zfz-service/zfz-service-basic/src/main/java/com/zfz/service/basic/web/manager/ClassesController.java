package com.zfz.service.basic.web.manager;

import com.zfz.common.annotation.BindingResultValid;
import com.zfz.common.api.Result;
import com.zfz.common.entity.PageParam;
import com.zfz.service.basic.model.Classes;
import com.zfz.service.basic.service.ClassesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * author: DreamSaddle
 * date: 2020年01月04日
 * time: 15:04
 */
@Slf4j
@RestController
@RequestMapping("/api/service/basic/classes")
public class ClassesController {

	@Resource
	private ClassesService classesService;

	@GetMapping("/listPage")
	public Result getAllClasses(PageParam pageParam) {
		log.info("获取班级列表");
		return Result.success(classesService.getAll(pageParam));
	}

	@PostMapping("/add")
	@BindingResultValid
	public Result addClasses(@Valid @RequestBody Classes classes, BindingResult bindingResult) {
		log.info("添加班级信息...");
		return Result.smart(classesService.addClasses(classes));
	}

	@PutMapping("/update")
	@BindingResultValid
	public Result updateClasses(@Valid @RequestBody Classes classes, BindingResult bindingResult) {
		return Result.smart(classesService.updateClasses(classes));
	}

	@DeleteMapping("/delete/{id}")
	public Result deleteClasses(@PathVariable("id") Long id) {
		return Result.smart(classesService.deleteClasses(id));
	}
}
