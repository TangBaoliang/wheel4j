package com.wheel.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wheel.admin.dto.ResultDto;
import com.wheel.admin.model.SysLog;
import com.wheel.admin.service.SysLogService;
import com.wheel.admin.wrapper.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jack_yun
 * @version 1.0
 * @description:
 * @date 2022/7/30 12:59
 */
@RestController
@RequestMapping("/sysLog")
@Api(tags = "用户操作日志展示")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;
    
    /**
     *
     *
     * @param condition 
     * @param account 
     * @return com.wheel.admin.dto.ResultDto<com.baomidou.mybatisplus.core.metadata.IPage<com.wheel.admin.model.SysLog>> 
     * @author long_yun
     * @date 2022/7/30 13:06 
     * @describe
     */
    
    @ApiOperation(value = "展示用户操作日志")
    @GetMapping("/pageSysLogs")
    public ResultDto<IPage<SysLog>> pageSysLogs(@RequestBody IPage<SysLog> condition,@RequestParam("account") String account){
        IPage<SysLog> page1 = sysLogService.page(condition, new LambdaQueryWrapper<SysLog>().eq(SysLog::getUsername, account));
        return ResultWrapper.success(page1);
    }

}
