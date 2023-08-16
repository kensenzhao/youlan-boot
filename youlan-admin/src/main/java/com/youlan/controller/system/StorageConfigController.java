package com.youlan.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.youlan.common.core.restful.ApiResult;
import com.youlan.common.core.restful.enums.ApiResultCode;
import com.youlan.common.db.entity.dto.ListDTO;
import com.youlan.common.db.helper.DBHelper;
import com.youlan.framework.anno.SystemLog;
import com.youlan.framework.constant.SystemLogType;
import com.youlan.framework.controller.BaseController;
import com.youlan.system.entity.Config;
import com.youlan.system.entity.StorageConfig;
import com.youlan.system.service.StorageConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "存储管理")
@RestController
@RequestMapping("/system/storageConfig")
@AllArgsConstructor
public class StorageConfigController extends BaseController {
    private final StorageConfigService storageConfigService;

    @SaCheckPermission("system:storageConfig:add")
    @Operation(summary = "系统配置新增")
    @SystemLog(name = "系统配置", type = SystemLogType.OPERATION_LOG_TYPE_ADD)
    @PostMapping("/addStorageConfig")
    public ApiResult addConfig(@Validated @RequestBody StorageConfig storageConfig) {
        return toSuccess(storageConfigService.addStorageConfig(storageConfig));
    }

    @SaCheckPermission("system:storageConfig:update")
    @Operation(summary = "系统配置修改")
    @PostMapping("/updateStorageConfig")
    @SystemLog(name = "系统配置", type = SystemLogType.OPERATION_LOG_TYPE_UPDATE)
    public ApiResult updateConfig(@Validated @RequestBody StorageConfig storageConfig) {
        if (ObjectUtil.isNull(storageConfig.getId())) {
            return toError(ApiResultCode.C0001);
        }
        return toSuccess(storageConfigService.updateStorageConfig(storageConfig));
    }

    @SaCheckPermission("system:storageConfig:remove")
    @Operation(summary = "系统配置删除")
    @PostMapping("/removeStorageConfig")
    @SystemLog(name = "系统配置", type = SystemLogType.OPERATION_LOG_TYPE_REMOVE)
    public ApiResult removeConfig(@Validated @RequestBody ListDTO<Long> dto) {
        if (CollectionUtil.isEmpty(dto.getList())) {
            return toSuccess();
        }
        return toSuccess(storageConfigService.removeByIds(dto.getList()));
    }

    @SaCheckPermission("system:storageConfig:load")
    @Operation(summary = "系统配置详情")
    @PostMapping("/loadStorageConfig")
    public ApiResult loadConfig(@RequestParam Long id) {
        return toSuccess(storageConfigService.loadOne(id));
    }

    @SaCheckPermission("system:storageConfig:list")
    @Operation(summary = "系统配置分页")
    @PostMapping("/getStorageConfigPageList")
    @SystemLog(name = "系统配置", type = SystemLogType.OPERATION_LOG_TYPE_PAGE_LIST)
    public ApiResult getConfigPageList(@RequestBody StorageConfig storageConfig) {
        return toSuccess(storageConfigService.loadPage(storageConfig, DBHelper.getQueryWrapper(storageConfig)));
    }
}
