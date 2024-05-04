package com.example.BakalavarSpeciality.service.speciality;

import com.example.BakalavarSpeciality.catchesystem.Catch;
import com.example.BakalavarSpeciality.catchesystem.SystemCatchManager;
import com.example.BakalavarSpeciality.dto.*;
import com.example.BakalavarSpeciality.entity.*;
import com.example.BakalavarSpeciality.mapper.IxtisasMapper;
import com.example.BakalavarSpeciality.mapper.SpecialityMapper;
import com.example.BakalavarSpeciality.nodejsservice.NodejsService;
import com.example.BakalavarSpeciality.repository.*;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;
    private final SpecialityMapper specialityMapper;
    private final AreaRepository areaRepository;
    private final SpecialityTestRepository specialityTestRepository;
    private final SaheRepository saheRepository;
    private final IxtisasRepository ixtisasRepository;
    private final IxtisasMapper ixtisasMapper;
    private final Catch<String,List<IxtisasDto>> ixtisasCatch;
    private final Catch<String,List<IxtisasDto>> resultixtisasCatche;
    private final NodejsService nodejsService;
    public SpecialityServiceImpl(SpecialityRepository specialityRepository, SpecialityMapper specialityMapper, AreaRepository areaRepository, SpecialityTestRepository specialityTestRepository, SaheRepository saheRepository, IxtisasRepository ixtisasRepository, IxtisasMapper ixtisasMapper, SystemCatchManager systemCatchManager, NodejsService nodejsService) {
        this.specialityRepository = specialityRepository;
        this.specialityMapper = specialityMapper;
        this.areaRepository = areaRepository;
        this.specialityTestRepository = specialityTestRepository;
        this.saheRepository = saheRepository;
        this.ixtisasRepository = ixtisasRepository;
        this.ixtisasMapper = ixtisasMapper;
        this.ixtisasCatch = systemCatchManager.createCache("ixtisasCatche");
        this.resultixtisasCatche = systemCatchManager.createCache("resultixtisasCatche");
        this.nodejsService = nodejsService;
        nodejsService.creatCache("results");
    }
    @Override
    public List<SpecialityDto> getSpecialityes(){
        return specialityMapper.specialitiesToDTOs(specialityRepository.findAll());
    }

    @Override
    public University getSpecilaityUni(String spid){
        System.out.println(specialityRepository.findById(spid).orElse(null).getArea().getName());
        return specialityRepository.findById(spid).orElse(null).getUniversity();
    }


    @Override
    public List<SpecialityDto> studentChoiseSpecialityes(NewFilterDto newFilterDto){
        double scoreNumber = newFilterDto.getFirstscoreNumber()+newFilterDto.getSecondscoreNumber();
        String specialityGroup = newFilterDto.getSpecialityGroup();
        String undergroup = newFilterDto.getUndergroup();
        List<String> favAreas = newFilterDto.getFavAreas();
        List<Speciality> specialityes = specialityRepository.findByMainsectorInAndSpecialitygroupAndUndergroupAndFreescoreBetween(
                List.of(newFilterDto.getSector(),"Aze/Rus"),
                specialityGroup,
                undergroup,
                scoreNumber-getMinusValue(scoreNumber),
                scoreNumber+50
        );
        return specialityMapper.specialitiesToDTOs(specialityes);
    }


    private double getMinusValue(double scoreNumber) {
        if (scoreNumber < 300) {
            return 70;
        } else if (scoreNumber < 400) {
            return 100;
        } else if (scoreNumber < 500) {
            return 150;
        } else if (scoreNumber < 600) {
            return 200;
        } else {
            return 300;
        }
    }


    @Override
    public List<Speciality> findByAreaId(AreSectorsDto areSectorsDto){
        List<Speciality> sp = specialityTestRepository.findByArea_IdAndEducationtype(areSectorsDto.getArea_id(),areSectorsDto.getSector());
        return sp;
    }


    public List<Ixtisas> findtt(List<String> ids){
        List<Ixtisas> ixs  = ixtisasRepository.findAll();
        List<Ixtisas> f = ixs.stream().filter(c->check(ids,c.getSaheler())).collect(Collectors.toList());
        return f;
    }
    public boolean check(List<String> ids,String s){
        String[] ss = s.split(",");
        for(String c:ss){
            int index = ids.indexOf(c);
            if(index!=-1){
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Sahe> getSaheler(){
        return saheRepository.findAll();
    }
    @Override
    public List<IxtisasDto> getIxtisaslar(){
        List<IxtisasDto> catchedIxtisas = ixtisasCatch.get("ixtisaslar");
        ixtisasCatch.printKey();
        if(catchedIxtisas!=null){
            System.out.println("Data come from catche");
            return  catchedIxtisas;
        }

        System.out.println("Data come from databaza");
        List<IxtisasDto> d = ixtisasMapper.ixtisaslarToDTOs(ixtisasRepository.findAll());
        for(IxtisasDto dt:d){
            List<Sahe> s = saheRepository.findByIdIn(dt.getSaheler().split(","));
            dt.setAreas(s);
        }
        ixtisasCatch.put("ixtisaslar",d);
        return d;
    }
    @Override
    public List<IxtisasDto> getBySahelerIn(SahelerDto sahelerDto) {
        resultixtisasCatche.printKey();
        String specialitygroup = sahelerDto.getSpecialitygroup();
        String undergroup = sahelerDto.getUndergroup();
        String mainsecotor = sahelerDto.getMainsector();
        if(Objects.equals(specialitygroup, "2") || Objects.equals(specialitygroup, "4")){
            undergroup = "";
        }
        double score = sahelerDto.getFirstscore()+ sahelerDto.getSecondscore();
        List<String> ids = sahelerDto.getIds();
        String nameforcatche = specialitygroup+":"+undergroup+":"+mainsecotor+":"+sahelerDto.getFirstscore()+":"+ sahelerDto.getSecondscore()+":"+String.join(",",ids);
//        List<IxtisasDto> catchedResult = resultixtisasCatche.get(nameforcatche);
        List<IxtisasDto> catchedResult = (List<IxtisasDto>) nodejsService.getdata("results","studentresults");

        if(catchedResult!=null){
            System.out.println("Data come from catche");
            return catchedResult;
        }

        double max = score+50;
        double min = score-getMinusValue(score);
        List<IxtisasDto> result = new ArrayList<>();
        for (String id : ids) {
            result.addAll(ixtisasMapper.ixtisaslarToDTOs(ixtisasRepository.findBySahelerId(id,min,max,specialitygroup,undergroup,mainsecotor)));
        }
        for (IxtisasDto dto : result) {
            double freescore = dto.getFreescore();
            double percentage = (score / freescore) * 100;
            List<Sahe> sahes = saheRepository.findByIdIn(dto.getSaheler().split(","));
            dto.setAreas(sahes);
            dto.setPercentage(percentage);
        }
//        resultixtisasCatche.put(nameforcatche,result);
        nodejsService.sendDataToCache("results","studentresults",result);
        System.out.println("Data come from databaza");
        return result;
    }

}
