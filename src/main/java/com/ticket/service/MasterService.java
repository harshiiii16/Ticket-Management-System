package com.ticket.service;

import java.util.List;

import com.ticket.dto.KeyValueDto;

public interface MasterService {

	public List<KeyValueDto> getAllStatus();

	public List<KeyValueDto> getAllDepartment();

	public List<KeyValueDto> getAllPriority();

	public KeyValueDto getStatusById(Integer id) throws Exception;

	public KeyValueDto getPriorityById(Integer id) throws Exception;

	public KeyValueDto getDepartmentById(Integer id) throws Exception;

}
