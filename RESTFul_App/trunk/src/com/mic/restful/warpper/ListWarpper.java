/*
 * Creation : Apr 20, 2017
 */
package com.mic.restful.warpper;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listWarpper")
public class ListWarpper implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> list;

    public ListWarpper() {
    }

    public ListWarpper(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}