/*
. * Creation : May 3, 2017
 */
package com.mic.exp.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mic.exp.batch.dto.a001.A001InputDto;
import com.mic.exp.batch.dto.a001.A001OutputDto;

public class A001Processor implements ItemProcessor<A001InputDto, A001OutputDto> {

    public A001Processor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public A001OutputDto process(A001InputDto item) throws Exception {
        A001OutputDto outputDto = new A001OutputDto();
        outputDto.setOutCol001(item.getCol001() + "_O");
        outputDto.setOutCol002(item.getCol002() + "_O");
        outputDto.setOutCol003(item.getCol003() + "_O");
        outputDto.setOutCol004(item.getCol004() + "_O");
        outputDto.setOutCol005(item.getCol005() + "_O");
        outputDto.setOutCol006(item.getCol006() + "_O");
        outputDto.setOutCol007(item.getCol007() + "_O");
        outputDto.setOutCol008(item.getCol008() + "_O");
        outputDto.setOutCol009(item.getCol009() + "_O");
        outputDto.setOutCol010(item.getCol010() + "_O");
        return outputDto;
    }
}
