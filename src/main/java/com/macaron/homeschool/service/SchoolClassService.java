package com.macaron.homeschool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macaron.homeschool.common.enums.AuditStatus;
import com.macaron.homeschool.model.dto.SchoolClassDTO;
import com.macaron.homeschool.model.entity.SchoolClass;
import com.macaron.homeschool.model.vo.SchoolClassUserVO;
import com.macaron.homeschool.model.vo.SchoolClassVO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
* @author 马拉圈
* @description 针对表【school_class(班级表)】的数据库操作Service
* @createDate 2024-11-05 21:06:05
*/
public interface SchoolClassService extends IService<SchoolClass> {

    Optional<SchoolClass> getSchoolClass(Long classId);

    Long createSchoolClass(Long teacherId, SchoolClassDTO schoolClassDTO);

    SchoolClass checkAndGetSchoolClass(Long classId);

    void updateSchoolClass(Long classId, Long teacherId, SchoolClassDTO schoolClassDTO);

    void auditSchoolClass(Long classId, AuditStatus auditStatus);

    List<SchoolClassVO> querySchoolClassList(List<AuditStatus> auditStatuseList);

    Set<SchoolClassVO> querySelfSchoolClassSet(Long userId);

    void attendSchoolClass(Long classId, Long userId);

    List<SchoolClassUserVO> querySchoolClassUserList(Long classId);

    void auditClassUser(Long classId, Long userId, AuditStatus auditStatus);

    // 未审核/未通过则报错
    void checkSchoolClassApproved(Long classId);

    void checkCreatorOfSchoolClass(Long classId, Long userId);

    void checkPartnerOfSchoolClass(Long classId, Long userId);

}
