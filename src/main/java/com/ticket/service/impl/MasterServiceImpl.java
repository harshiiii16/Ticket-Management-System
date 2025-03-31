package com.ticket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.dto.KeyValueDto;
import com.ticket.enums.Priority;
import com.ticket.enums.Status;
import com.ticket.exception.ResourceNotFoundException;
import com.ticket.repository.DepartmentRepository;
import com.ticket.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private DepartmentRepository departmentRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<KeyValueDto> getAllStatus() {
		List<KeyValueDto> list = new ArrayList<>();
		for (Status st : Status.values()) {
			KeyValueDto status = new KeyValueDto(st.getId(), st.getName());
			list.add(status);
		}
		return list;
	}

	@Override
	public List<KeyValueDto> getAllDepartment() {
		return departmentRepo.findAll().stream().map(dept -> mapper.map(dept, KeyValueDto.class)).toList();
	}

	@Override
	public List<KeyValueDto> getAllPriority() {
		List<KeyValueDto> list = new ArrayList<>();
		for (Priority st : Priority.values()) {
			KeyValueDto priority = new KeyValueDto(st.getId(), st.getName());
			list.add(priority);
		}
		return list;
	}

	@Override
	public KeyValueDto getStatusById(Integer id) throws Exception {
		return getAllStatus().stream().filter(st -> st.getId().equals(id)).map(st -> mapper.map(st, KeyValueDto.class))
				.findFirst().orElseThrow(() -> new ResourceNotFoundException("Status Not found"));
	}

	@Override
	public KeyValueDto getPriorityById(Integer id) throws Exception {
		return getAllPriority().stream().filter(pr -> pr.getId().equals(id))
				.map(pr -> mapper.map(pr, KeyValueDto.class)).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Priority Not found"));
	}

	@Override
	public KeyValueDto getDepartmentById(Integer id) throws Exception {
		return departmentRepo.findById(id).map(dept -> mapper.map(dept, KeyValueDto.class))
				.orElseThrow(() -> new ResourceNotFoundException("Department Not found"));
	}

}
