package com.dru.care.app.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertEmployeeReqs {
     private Integer orgId;
     private List<InsertEmployeeBean> insertEmployeeBeans;
}
