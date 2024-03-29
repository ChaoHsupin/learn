package site.yanyan.learn.service.sys;

import site.yanyan.learn.pojo.dev.PageTableData;
import site.yanyan.learn.pojo.sys.SysUser;
import site.yanyan.learn.vo.sys.SysUserQuery;
import java.util.List;


public interface SysUserService {


   /**
    *根据id删除SysUser
    */
	Long delById(Long id);

   /**
    *根据新增SysUser，id自增
    */
    Long save(SysUser record);

   /**
    *根据id查询SysUser
    */
    SysUser getById(Long id);
    
   /**
    *根据id更新SysUser
    */ 
    Long editById(SysUser record);

   /**
    *查询所有SysUser
    */ 
    PageTableData<SysUser> list(int pagenum, int pagesize, SysUserQuery param);

    List<SysUser> listAll(SysUserQuery param);
}