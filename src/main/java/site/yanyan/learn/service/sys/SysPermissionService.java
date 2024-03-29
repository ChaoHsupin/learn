package site.yanyan.learn.service.sys;

import site.yanyan.learn.pojo.sys.SysPermission;
import site.yanyan.learn.vo.sys.SysPermissionQuery;
import java.util.List;
import site.yanyan.learn.pojo.dev.PageTableData;

public interface SysPermissionService {


   /**
    *根据id删除SysPermission
    */
	Long delById(Long id);

   /**
    *根据新增SysPermission，id自增
    */
    Long save(SysPermission record);

   /**
    *根据id查询SysPermission
    */
    SysPermission getById(Long id);
    
   /**
    *根据id更新SysPermission
    */ 
    Long editById(SysPermission record);

   /**
    *查询所有SysPermission
    */ 
    PageTableData<SysPermission> list(int pagenum, int pagesize,SysPermissionQuery param);

    List<SysPermission> listAll(SysPermissionQuery param);
}