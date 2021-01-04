package com.zking.ssm.service.Impl;

import com.zking.ssm.mapper.FileMapper;
import com.zking.ssm.model.MyFile;
import com.zking.ssm.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileServiceImpl implements IFileService {
    @Autowired
    private FileMapper iFileService;

    @Override
    public int deleteByPrimaryKey(Long fileId) {
        return iFileService.deleteByPrimaryKey(fileId);
    }

    @Override
    public int insert(MyFile record) {
        return iFileService.insert(record);
    }

    @Override
    public int insertSelective(MyFile record) {
        return iFileService.insertSelective(record);
    }

    @Override
    public MyFile selectByPrimaryKey(Long fileId) {
        return iFileService.selectByPrimaryKey(fileId);
    }

    @Override
    public int updateByPrimaryKeySelective(MyFile record) {
        return iFileService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MyFile record) {
        return iFileService.updateByPrimaryKey(record);
    }
}
