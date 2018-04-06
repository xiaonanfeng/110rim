package com.zxit.service.impl;

import com.zxit.model.dto.CountDto;
import com.zxit.dao.HjjlbRepository;
import com.zxit.service.HjjlbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HjjlbServiceImpl implements HjjlbService {

    @Resource
    private HjjlbRepository hjjlbRepository;

    @Override
    public List<CountDto> findLdsjBetweenGroupByHjzt(Date ldsjStart, Date ldsjEnd) {
        List<Object[]> list = hjjlbRepository.findLdsjBetweenGroupByHjzt(ldsjStart, ldsjEnd);
        return transList(list);
    }

    @Override
    public List<CountDto> findLdsjBetweenGroupByBjhm(Date ldsjStart, Date ldsjEnd) {
        Long size_110 = hjjlbRepository.findLdsjBetweenCount110(ldsjStart, ldsjEnd);
        Long size_122 = hjjlbRepository.findLdsjBetweenCount122(ldsjStart, ldsjEnd);
        Long other = hjjlbRepository.findLdsjBetweenCountOther(ldsjStart,ldsjEnd);
        List<CountDto> result = new ArrayList<>();
        result.add(new CountDto("其他", other));
        result.add(new CountDto("110", size_110));
        result.add(new CountDto("122", size_122));

        return result;
    }

    private List<CountDto> transList(List<Object[]> list) {
        List<CountDto> countDtos = new ArrayList<>();
        for (Object[] d : list) {
            CountDto countDto = new CountDto();
            Long count = (Long) d[0];
            String name = (String) d[1];
            countDto.setName(name);
            countDto.setCountNum(count);
            countDtos.add(countDto);
        }
        return countDtos;

    }

}
    



