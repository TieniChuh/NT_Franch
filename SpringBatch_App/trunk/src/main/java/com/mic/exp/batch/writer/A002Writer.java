package com.mic.exp.batch.writer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.mic.exp.batch.dto.a002.A002OutputActorDto;
import com.mic.exp.batch.dto.a002.A002OutputBaseDto;
import com.mic.exp.batch.dto.a002.A002OutputContractDto;
import com.mic.exp.batch.dto.a002.A002OutputScheduleDto;

/**
 * The Class A002Writer
 */
public class A002Writer implements ItemWriter<A002OutputBaseDto> {

    /** The delegates. */
    private List<ItemWriter<? super A002OutputBaseDto>> delegates;

    /**
     * Sets the delegates.
     * 
     * @param delegates the new delegates
     */
    public void setDelegates(List<ItemWriter<? super A002OutputBaseDto>> delegates) {
        this.delegates = delegates;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
     */
    @Override
    public void write(List<? extends A002OutputBaseDto> items) throws Exception {
        ItemWriter actorsWriter = (ItemWriter) delegates.get(0);
        ItemWriter contractsWriter = (ItemWriter) delegates.get(1);
        ItemWriter schedulesWriter = (ItemWriter) delegates.get(2);

        List<A002OutputActorDto> actorDtoList = new ArrayList<A002OutputActorDto>();
        List<A002OutputContractDto> contractDtoList = new ArrayList<A002OutputContractDto>();
        List<A002OutputScheduleDto> scheduleDtoList = new ArrayList<A002OutputScheduleDto>();

        for (A002OutputBaseDto item : items) {
            if (item.isCreatDto()) {
                if (item.getDtoObject() instanceof A002OutputActorDto) {
                    actorDtoList.add((A002OutputActorDto) item.getDtoObject());
                } else if (item.getDtoObject() instanceof A002OutputContractDto) {
                    contractDtoList.add((A002OutputContractDto) item.getDtoObject());
                } else if (item.getDtoObject() instanceof A002OutputScheduleDto) {
                    scheduleDtoList.add((A002OutputScheduleDto) item.getDtoObject());
                }
            }

        }
        if (contractDtoList.size() > 0) {
            contractsWriter.write(contractDtoList);
        }

        if (actorDtoList.size() > 0) {
            actorsWriter.write(actorDtoList);
        }

        if (scheduleDtoList.size() > 0) {
            schedulesWriter.write(scheduleDtoList);
        }
    }

}
