package com.atguigu.edu.service;

import com.atguigu.edu.entity.EduTeacher;
import com.atguigu.request.TeacherConditionVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author ${author}
 * @since 2020-12-22
 */
public interface EduTeacherService extends IService<EduTeacher> {

    //返回总结果集带分页
    void queryTeacherPageByCondition(Page<EduTeacher> teacherPage, TeacherConditionVo teacherConditionVo);
}
