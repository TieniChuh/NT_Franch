/*
. * Creation : May 3, 2017
 */
package com.mic.exp.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mic.exp.batch.dto.a002.A002InputActorDto;
import com.mic.exp.batch.dto.a002.A002InputBaseDto;
import com.mic.exp.batch.dto.a002.A002InputContractDto;
import com.mic.exp.batch.dto.a002.A002InputScheduleDto;
import com.mic.exp.batch.dto.a002.A002OutputActorDto;
import com.mic.exp.batch.dto.a002.A002OutputBaseDto;
import com.mic.exp.batch.dto.a002.A002OutputContractDto;
import com.mic.exp.batch.dto.a002.A002OutputScheduleDto;

public class A002Processor implements ItemProcessor<A002InputBaseDto, A002OutputBaseDto> {

    public A002Processor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public A002OutputBaseDto process(A002InputBaseDto item) throws Exception {
        A002OutputBaseDto outputDto = null;
        if (item instanceof A002InputActorDto) {
            A002OutputActorDto contractDto = new A002OutputActorDto();
            contractDto.setOutColActor001(((A002InputActorDto) item).getColInputActor001() + "_O");
            contractDto.setOutColActor002(((A002InputActorDto) item).getColInputActor002() + "_O");
            contractDto.setOutColActor003(((A002InputActorDto) item).getColInputActor003() + "_O");
            contractDto.setOutColActor004(((A002InputActorDto) item).getColInputActor004() + "_O");
            contractDto.setOutColActor005(((A002InputActorDto) item).getColInputActor005() + "_O");
            contractDto.setOutColActor006(((A002InputActorDto) item).getColInputActor006() + "_O");
            contractDto.setOutColActor007(((A002InputActorDto) item).getColInputActor007() + "_O");
            contractDto.setOutColActor008(((A002InputActorDto) item).getColInputActor008() + "_O");
            contractDto.setOutColActor009(((A002InputActorDto) item).getColInputActor009() + "_O");
            contractDto.setOutColActor010(((A002InputActorDto) item).getColInputActor010() + "_O");

            outputDto = new A002OutputBaseDto();
            outputDto.setCreatDto(true);
            outputDto.setDtoObject(contractDto);

        } else if (item instanceof A002InputContractDto) {
            A002OutputContractDto contractDto = new A002OutputContractDto();
            contractDto.setOutColContract001(((A002InputContractDto) item).getColInputContract001() + "_O");
            contractDto.setOutColContract002(((A002InputContractDto) item).getColInputContract002() + "_O");
            contractDto.setOutColContract003(((A002InputContractDto) item).getColInputContract003() + "_O");
            contractDto.setOutColContract004(((A002InputContractDto) item).getColInputContract004() + "_O");
            contractDto.setOutColContract005(((A002InputContractDto) item).getColInputContract005() + "_O");
            contractDto.setOutColContract006(((A002InputContractDto) item).getColInputContract006() + "_O");
            contractDto.setOutColContract007(((A002InputContractDto) item).getColInputContract007() + "_O");
            contractDto.setOutColContract008(((A002InputContractDto) item).getColInputContract008() + "_O");
            contractDto.setOutColContract009(((A002InputContractDto) item).getColInputContract009() + "_O");
            contractDto.setOutColContract010(((A002InputContractDto) item).getColInputContract010() + "_O");

            outputDto = new A002OutputBaseDto();
            outputDto.setCreatDto(true);
            outputDto.setDtoObject(contractDto);
        } else if (item instanceof A002InputScheduleDto) {
            A002OutputScheduleDto scheduleDto = new A002OutputScheduleDto();
            scheduleDto.setOutColSchedule001(((A002InputScheduleDto) item).getColInputSchedule001() + "_O");
            scheduleDto.setOutColSchedule002(((A002InputScheduleDto) item).getColInputSchedule002() + "_O");
            scheduleDto.setOutColSchedule003(((A002InputScheduleDto) item).getColInputSchedule003() + "_O");
            scheduleDto.setOutColSchedule004(((A002InputScheduleDto) item).getColInputSchedule004() + "_O");
            scheduleDto.setOutColSchedule005(((A002InputScheduleDto) item).getColInputSchedule005() + "_O");
            scheduleDto.setOutColSchedule006(((A002InputScheduleDto) item).getColInputSchedule006() + "_O");
            scheduleDto.setOutColSchedule007(((A002InputScheduleDto) item).getColInputSchedule007() + "_O");
            scheduleDto.setOutColSchedule008(((A002InputScheduleDto) item).getColInputSchedule008() + "_O");
            scheduleDto.setOutColSchedule009(((A002InputScheduleDto) item).getColInputSchedule009() + "_O");
            scheduleDto.setOutColSchedule010(((A002InputScheduleDto) item).getColInputSchedule010() + "_O");

            outputDto = new A002OutputBaseDto();
            outputDto.setCreatDto(true);
            outputDto.setDtoObject(scheduleDto);
        }
        return outputDto;
    }
}
