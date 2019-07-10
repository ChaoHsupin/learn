package site.yanyan.learn.service.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.SysRoleDao;
import site.yanyan.learn.pojo.PageTableData;
import site.yanyan.learn.pojo.SysRole;
import site.yanyan.learn.vo.SysRoleQuery;
import site.yanyan.learn.service.SysRoleService;

import com.github.pagehelper.PageHelper;
@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	public SysRoleDao sysRoleDao;
	@Override
	public Long delById(Long id) {
	   sysRoleDao.delById(id);
	   return id;
	}

	@Override
	public Long save(SysRole record) {
		sysRoleDao.save(record);
		return record.getRoleId();
	}

	@Override
	public SysRole getById(Long id) {
		return sysRoleDao.getById(id);
	}


	@Override
	public Long editById(SysRole record) {
		sysRoleDao.editById(record);
		return record.getRoleId();
	}

	@Override
	public PageTableData<SysRole> list(int pagenum, int pagesize, SysRoleQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<SysRole> datalist = sysRoleDao.list(param);
		PageTableData<SysRole> resultPage = new PageTableData<SysRole>(datalist);
		PageInfo<SysRole> p = new PageInfo<SysRole>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<SysRole> listAll(SysRoleQuery param) {
		List<SysRole> datalist = sysRoleDao.list(param);
		return datalist;
	}

}
