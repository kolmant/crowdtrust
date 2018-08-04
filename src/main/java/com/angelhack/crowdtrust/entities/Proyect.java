package com.angelhack.crowdtrust.entities;

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes;

import java.sql.Date;
import java.util.List;

/**
 * Created by David Useche on 4/08/2018.
 */
public class Proyect {

    int id;
    String name;
    String description;
    String imgName;
    float expectedBudget;
    Date expectedInitDate;
    Date expectedEndDate;
    List<String> orgNames;
    List<ExternalIncomes> incomes;



}
