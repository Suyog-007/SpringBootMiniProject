package org.shah.springapp.ems.Controllers;

import org.shah.springapp.ems.Domains.Demand;
import org.shah.springapp.ems.Domains.Member;
import org.shah.springapp.ems.Repository.DemandRepository;
import org.shah.springapp.ems.Repository.MemberRepository;
import org.shah.springapp.ems.Services.MemberFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requestor")
public class RequestorRestController {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DemandRepository demandRepository;

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") long id) {
        Optional<Member> memberData = memberRepository.findById(id);

        if (memberData.isPresent()) {
            return new ResponseEntity<>(memberData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demands")
    public List<Demand> getAllDemands() {
        return demandRepository.findAll();
    }
    @GetMapping("/demands/{id}")
    public ResponseEntity<Demand> getDemandById(@PathVariable("id") long id) {
        Optional<Demand> demandData = demandRepository.findById(id);

        if (demandData.isPresent()) {
            return new ResponseEntity<>(demandData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/demands")
    public Demand createDemand(@RequestBody Demand demand) {
        return demandRepository.save(demand);
    }

    @Autowired
    private MemberFilterService memberFilterService;

    @GetMapping("/members/filter")
    public List<Member> filterMembers(
            @RequestParam(required = false) String employeeId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfJoining,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Integer experience,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String positionLevel,
            @RequestParam(required = false) String skillKey,
            @RequestParam(required = false) Integer skillValue,
            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortOrder) {

        return memberFilterService.filterMembers(employeeId, firstName, lastName, dateOfJoining, location,
                experience, status, positionLevel, skillKey, skillValue,sortOrder);
    }
}
