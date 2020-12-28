package com.atguigu.edu.controller;


import com.atguigu.edu.entity.EduTeacher;
import com.atguigu.edu.service.EduTeacherService;
import com.atguigu.request.TeacherConditionVo;
import com.atguigu.response.RetVal;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.bcel.internal.generic.RET;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-12-22
 */
@RestController
@RequestMapping("/edu-teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @GetMapping
    public RetVal getAlTeacher() {
        List<EduTeacher> teacherList = teacherService.list(null);

        return RetVal.success().data("teacherList", teacherList);
    }

    //2.删除讲师
    @DeleteMapping("{id}")
    public RetVal deleteTeacherById(@ApiParam(name = "id", value = "讲师id", required = true)
                                    @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return RetVal.success();
        } else {
            return RetVal.error();
        }
    }

    //3.讲师列表的分页查询
    @GetMapping("queryTeacherPage/{pageNum}/{pageSize}")
    public RetVal queryTeacherPage(@PathVariable("pageNum") long pageNum,
                                   @PathVariable("pageSize") long pageSize,
                                   TeacherConditionVo teacherConditionVo) {

        Page<EduTeacher> teacherPage = new Page<>(pageNum, pageSize);
        // 返回总结果集
        teacherService.queryTeacherPageByCondition(teacherPage, teacherConditionVo);

        List<EduTeacher> teacherList = teacherPage.getRecords();

        long total = teacherPage.getTotal();
        return RetVal.success().data("teacherList", teacherList).data("total", total);
    }

    @PostMapping
    public RetVal saveTeacher(EduTeacher teacher) {
        boolean flag = teacherService.save(teacher);
        if (flag) {
            return RetVal.success();
        } else {
            return RetVal.error();
        }
    }

    @GetMapping("{id}")
    public RetVal queryTeacherById(@PathVariable String id) {
        EduTeacher teacher = teacherService.getById(id);
        return RetVal.success().data("teacher", teacher);
    }

    @PostMapping
    public RetVal updateTeacher(EduTeacher teacher) {
        boolean flag = teacherService.updateById(teacher);
        if (flag) {
            return RetVal.success();
        } else {
            return RetVal.error();
        }
    }

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");

        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next.equals("1111")) {
                list.remove("222");
            }
            System.out.println(list);
        }
    }
}

