package com.tfm.planitnow.ui.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tfm.planitnow.database.PlanItNowDatabase;
import com.tfm.planitnow.models.Plan;
import com.tfm.planitnow.utils.PlanComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private List<Plan> planList;

    public HomeViewModel() {
        planList = new ArrayList<Plan>();
    }

    public void setPlanList(List<Plan> planList){
        Collections.sort(planList, new PlanComparator());
        this.planList = planList;
    }

    public void addPlan(Plan p){
        planList.add(p);
        Collections.sort(planList, new PlanComparator());
    }

    public void deletePlan(Plan p) { planList.removeIf(pl -> (pl.getId() == p.getId())); }

    public List<Plan> getPlanList(){ return planList; }

    public LiveData<String> getText() {
        return mText;
    }
}