package com.atguigu.edu.service.impl;

import com.atguigu.edu.entity.EduTeacher;
import com.atguigu.edu.mapper.EduTeacherMapper;
import com.atguigu.edu.service.EduTeacherService;
import com.atguigu.request.TeacherConditionVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-12-22
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    //返回总结果集带分页
    @Override
    public void queryTeacherPageByCondition(Page<EduTeacher> teacherPage, TeacherConditionVo teacherConditionVo) {

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        String teacherName = teacherConditionVo.getName();
        Integer level = teacherConditionVo.getLevel();
        String beginTime = teacherConditionVo.getBeginTime();
        String endTime = teacherConditionVo.getEndTime();


        if (StringUtils.isNotEmpty(teacherName)) {
            wrapper.like("name", teacherName);
        }

        if (level != null) {
            wrapper.eq("level", level);
        }

        if (StringUtils.isNotEmpty(beginTime)) {
            wrapper.ge("gmt_create", beginTime);
        }
        if (StringUtils.isNotEmpty(beginTime)) {
            wrapper.le("gmt_create", beginTime);
        }
        baseMapper.selectPage(teacherPage, wrapper);


    }
}
